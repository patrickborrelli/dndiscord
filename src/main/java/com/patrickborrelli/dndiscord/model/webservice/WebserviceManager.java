package com.patrickborrelli.dndiscord.model.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.patrickborrelli.dndiscord.model.DiscordUser;
import com.patrickborrelli.dndiscord.model.Formula;
import com.patrickborrelli.dndiscord.model.TokenResponse;
import com.patrickborrelli.dndiscord.model.dndiscord.Action;
import com.patrickborrelli.dndiscord.model.dndiscord.Attack;
import com.patrickborrelli.dndiscord.model.dndiscord.CharacterClass;
import com.patrickborrelli.dndiscord.model.dndiscord.CharacterSheet;
import com.patrickborrelli.dndiscord.model.dndiscord.Feature;
import com.patrickborrelli.dndiscord.model.dndiscord.Item;
import com.patrickborrelli.dndiscord.utilities.AppUtil;

/**
 * Singleton instance responsible for adding, modifying, and deleting 
 * back end data.
 * 
 * @author Patrick Borrelli
 */
public class WebserviceManager {
	private volatile static WebserviceManager instance;
	private static final Logger LOGGER = LogManager.getLogger(WebserviceManager.class.getName());
	private static final String ADMIN_USERNAME = System.getenv("DNDISCORD_ADMIN_USER");
	private static final String ADMIN_CREDENTIALS = System.getenv("DNDISCORD_ADMIN_CREDENTIALS");
	private static final ObjectMapper MAPPER = new ObjectMapper();
	private static final String QUERY = "?";
	private static final String NULL_ID = ",\"_id\":null";
	
	//static URLs
	private static String ACTION_URL;
	private static String ATTACK_URL;
	private static String BASE_URL;
	private static String CHARACTER_URL;
	private static String CHARACTER_CLASS_URL;
	private static String CREATE_USER_URL;
	private static String FEATURE_URL;
	private static String FORMULA_URL;
	private static String GET_USER_URL;
	private static String ITEM_URL;
	private static String LOGIN_URL;
	private static String TOKEN = "";
	
	static {
		if(AppUtil.getInstance().getScope().equalsIgnoreCase("DEV")) {
			BASE_URL = System.getenv("DNDISCORD_DEV_API_BASE");
		} else {
			BASE_URL = System.getenv("DNDISCORD_API_BASE");			
		}
		
		ACTION_URL = BASE_URL + "actions";
		ATTACK_URL = BASE_URL + "attacks";
		CHARACTER_URL = BASE_URL + "characters";
		CHARACTER_CLASS_URL = BASE_URL + "characterClasses";
		CREATE_USER_URL = BASE_URL + "users/register";
		FEATURE_URL = BASE_URL + "features";
		FORMULA_URL = BASE_URL + "formulae";
		GET_USER_URL = BASE_URL + "users/discordUser/";	
		ITEM_URL = BASE_URL + "items";
		LOGIN_URL = BASE_URL + "users/login";
		
		LOGGER.debug("USING BaseUrl of: {} for {}", BASE_URL, AppUtil.getInstance().getScope());
	}
	
	private WebserviceManager() {
		TOKEN = getToken();
	}
	
	/**
	 * Retrieve the instance of this singleton WebserviceManager.
	 * 
	 * @return the one and only instance of the WebserviceManager
	 */
	public static WebserviceManager getInstance() {
		if(instance == null) {
			synchronized (WebserviceManager.class) {
				if(instance == null) {
					instance = new WebserviceManager();
				}
			}
		}
		return instance;
	}
	
	/**
	 * Delete saved formulas for the provided user.
	 * 
	 * @param user a DiscordUser
	 * @param names an array of Strings representing the name of the rolls
	 * @return a String representing the status of the delete attempt.
	 */
	public String deleteUserFormula(DiscordUser user, String[] names) {
		StringBuilder buff = new StringBuilder();
		
		StringBuilder params = new StringBuilder().append("user=" + user.getId());
		for(int i = 0; i < names.length; i++) {
			if(!names[i].isEmpty()) {
				params.append("&name=" + names[i]);
			}
		}
		
		LOGGER.debug("Making call to API: " + FORMULA_URL + QUERY + params.toString());
		
		BufferedReader in = null;
		HttpURLConnection con = null;		
				
		try {
			URL obj = new URL(FORMULA_URL + QUERY + params.toString());
			con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("DELETE");
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("x-access-token", TOKEN);
			con.setDoOutput(true);
			
			int responseCode = con.getResponseCode();
			
			if(responseCode != HttpURLConnection.HTTP_OK) {
				in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				String inputLine;
				StringBuffer errorResponse = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					errorResponse.append(inputLine);
				}
				
				LOGGER.error("Error while deleting formula.");
				in.close();
				con.disconnect();
				throw new IOException(errorResponse.toString());
			} else {
				in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				
				LOGGER.debug("Deleted successfully: " + response.toString());
				buff.append(response.toString());		
				in.close();
				con.disconnect();
			}		
		} catch(MalformedURLException murl) {
			LOGGER.debug(murl.getMessage());
			murl.printStackTrace();
		} catch(IOException ioex) {
			LOGGER.debug(ioex.getMessage());
			ioex.printStackTrace();
		}
		return buff.toString();
	}
	
	public String addUserCharacter(DiscordUser user, CharacterSheet character) {
		
		//first ensure any children are persisted:
		if(character.getInventory() != null) addItemsToCharacter(character);
		if(character.getActions() != null) addActionsToCharacter(character);
		if(character.getAttacks() != null) addAttacksToCharacter(character);	
		if(character.getCharacterClasses() != null) addClassesToCharacter(character);
		if(character.getFeatures() != null) addFeaturesToCharacter(character);		
		
		LOGGER.debug("Making call to API: " + CHARACTER_URL);		
		String POST_BODY = unmarshalObject(character);	
		
		LOGGER.debug("Submitting JSON: {}", POST_BODY);
		return postUrl(CHARACTER_URL, POST_BODY);
	}
	
	public String addAction(Action action) {
		LOGGER.debug("Making call to API: " + ACTION_URL);

		String POST_BODY = unmarshalObject(action);
		return postUrl(ACTION_URL, POST_BODY);
	}
	
	public String addAttack(Attack attack) {
		LOGGER.debug("Making call to API: " + ATTACK_URL);
		
		String POST_BODY = unmarshalObject(attack);			
		return postUrl(ATTACK_URL, POST_BODY);
	}
	
	public String addCharacterClass(CharacterClass charClass) {
		LOGGER.debug("Making call to API: " + CHARACTER_CLASS_URL);
		
		String POST_BODY = unmarshalObject(charClass);			
		return postUrl(CHARACTER_CLASS_URL, POST_BODY);
	}
	
	public String addFeature(Feature feature) {
		LOGGER.debug("Making call to API: " + FEATURE_URL);
		
		String POST_BODY = unmarshalObject(feature);			
		return postUrl(FEATURE_URL, POST_BODY);
	}
	
	public String addItem(Item item) {
		LOGGER.debug("Making call to API: " + ITEM_URL);
		
		String POST_BODY = unmarshalObject(item);			
		return postUrl(ITEM_URL, POST_BODY);
	}
	
	/**
	 * Adds a new roll formula for the provided user.
	 * 
	 * @param user a DiscordUser
	 * @param formula a String containing the roll formula to be saved
	 * @param name a String representing the name of the saved roll
	 * @return a String representing the status of the save attempt.
	 */
	public String addUserFormula(DiscordUser user, String formula, String name) {
		StringBuilder buff = new StringBuilder();
		
		LOGGER.debug("Making call to API: " + FORMULA_URL);
		
		BufferedReader in = null;
		HttpURLConnection con = null;
		
		final String POST_PARAMS = "{\n\t" + "\"user\": \"" + user.getId() + "\",\n" +
				   "\t" + "\"name\": \"" + name + "\",\n" + 
				   "\t" + "\"roll\": \"" + formula + "\"\n}";
		
		LOGGER.debug("Using parameters: " + POST_PARAMS);
		
		try {
			URL obj = new URL(FORMULA_URL);
			con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("x-access-token", TOKEN);
			con.setDoOutput(true);
			
			OutputStream os = con.getOutputStream();
			os.write(POST_PARAMS.getBytes());
			os.flush();
			os.close();
				
			int responseCode = con.getResponseCode();
			
			if(responseCode != HttpURLConnection.HTTP_OK) {
				in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				String inputLine;
				StringBuffer errorResponse = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					errorResponse.append(inputLine);
				}
				
				LOGGER.error("Error while adding formula: " + errorResponse.toString());
				in.close();
				con.disconnect();
				throw new IOException(errorResponse.toString());
			} else {
				in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				
				LOGGER.debug("Saved successfully: " + response.toString());
				buff.append("User formula: " + formula + " can now be called with roll $" + name);		
				in.close();
				con.disconnect();
			}		
		} catch(MalformedURLException murl) {
			LOGGER.debug(murl.getMessage());
			murl.printStackTrace();
		} catch(IOException ioex) {
			LOGGER.debug(ioex.getMessage());
			ioex.printStackTrace();
		}
		return buff.toString();
	}
	
	/**
	 * Retrieves a user saved formula by name.  Returns a string representation 
	 * of the roll formula or null if none exists.
	 * 
	 * @param user a DiscordUser 
	 * @param name a String representing the saved roll name
	 * @return a String representation of the roll formula or a null if none exists.
	 */
	public String getUserFormula(DiscordUser user, String name) {
		StringBuilder url = new StringBuilder().append(FORMULA_URL).append(QUERY);
		url.append("user=" + user.getId() + "&name=" + name);
		LOGGER.debug("Making call to API: " + url.toString());
		
		BufferedReader in = null;
		HttpURLConnection con = null;
		ObjectMapper mapper = new ObjectMapper();
		Formula[] formulas = null;
		
		try {
			URL obj = new URL(url.toString());
			con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("x-access-token", TOKEN);
			int responseCode = con.getResponseCode();			
			
			if(responseCode != HttpURLConnection.HTTP_OK) {
				in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				String inputLine;
				StringBuffer errorResponse = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					errorResponse.append(inputLine);
				}
				
				//print in String
				LOGGER.debug("GOT AN ERROR: " + errorResponse.toString());
				in.close();
				con.disconnect();
				throw new IOException(errorResponse.toString());
			} else {
				in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				
				//handle case where user does not currently exist:
				if(response.toString().equalsIgnoreCase("null") || response.toString().equalsIgnoreCase("[]")) {
					LOGGER.debug("Received a null response");
				} else {
					//print response:
					LOGGER.debug(response.toString());
					formulas = mapper.readValue(response.toString(), Formula[].class);			
				}
				
				in.close();
				con.disconnect();
			}		
		} catch(MalformedURLException murl) {
			LOGGER.debug(murl.getMessage());
			murl.printStackTrace();
		} catch(IOException ioex) {
			LOGGER.debug(ioex.getMessage());
			ioex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return (formulas == null) ? null : formulas[0].getRoll();
	}
	
	/**
	 * Retrieves a list of all saved roll Formulas
	 * belonging to the provided user.
	 * 
	 * @param user a DiscordUser
	 * @return a List of Formula objects containing all saved rolls for the provided user.
	 */
	public List<Formula> getUserFormulas(DiscordUser user) {
		List<Formula> result = new ArrayList<>();
		StringBuilder url = new StringBuilder().append(FORMULA_URL).append(QUERY);
		url.append("user=" + user.getId());
		LOGGER.debug("Making call to API: " + url.toString());
		
		BufferedReader in = null;
		HttpURLConnection con = null;
		ObjectMapper mapper = new ObjectMapper();
		Formula[] formulas = null;
		
		try {
			URL obj = new URL(url.toString());
			con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("x-access-token", TOKEN);
			int responseCode = con.getResponseCode();			
			
			if(responseCode != HttpURLConnection.HTTP_OK) {
				in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				String inputLine;
				StringBuffer errorResponse = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					errorResponse.append(inputLine);
				}
				
				//print in String
				LOGGER.debug("GOT AN ERROR: " + errorResponse.toString());
				in.close();
				con.disconnect();
				throw new IOException(errorResponse.toString());
			} else {
				in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				
				//handle case where user does not currently exist:
				if(response.toString().equalsIgnoreCase("null") || response.toString().equalsIgnoreCase("[]")) {
					LOGGER.debug("Received a null response");
				} else {
					//print response:
					LOGGER.debug(response.toString());
					formulas = mapper.readValue(response.toString(), Formula[].class);			
				}
				
				in.close();
				con.disconnect();
			}		
		} catch(MalformedURLException murl) {
			LOGGER.debug(murl.getMessage());
			murl.printStackTrace();
		} catch(IOException ioex) {
			LOGGER.debug(ioex.getMessage());
			ioex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		result = (formulas == null) ? null : new ArrayList<>(Arrays.asList(formulas));		
		return result;
	}
	
	/**
	 * Returns a DiscordUser from the back-end data based on a discord user id.
	 * 
	 * @param discordId a String containing the discord user id
	 * @return a discord user or a null if no user found
	 */
	public DiscordUser getUser(String discordId) {
		StringBuilder buf = new StringBuilder();
		buf.append(GET_USER_URL)
			.append(discordId);
		
		LOGGER.debug("Making call to API: " + buf.toString());
		
		BufferedReader in = null;
		HttpURLConnection con = null;
		ObjectMapper mapper = new ObjectMapper();
		DiscordUser user = null;
		
		try {
			URL obj = new URL(buf.toString());
			con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("x-access-token", TOKEN);
			int responseCode = con.getResponseCode();			
			
			if(responseCode != HttpURLConnection.HTTP_OK) {
				in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				String inputLine;
				StringBuffer errorResponse = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					errorResponse.append(inputLine);
				}
				
				//print in String
				LOGGER.debug("GOT AN ERROR: " + errorResponse.toString());
				in.close();
				con.disconnect();
				throw new IOException(errorResponse.toString());
			} else {
				in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				
				//handle case where user does not currently exist:
				if(response.toString().equalsIgnoreCase("null")) {
					LOGGER.debug("Received a null response");
				} else {
					//print response:
					LOGGER.debug("Retrieved User: {}", response);
					user = mapper.readValue(response.toString(), DiscordUser.class);					
				}
				
				in.close();
				con.disconnect();
			}		
		} catch(MalformedURLException murl) {
			LOGGER.debug(murl.getMessage());
			murl.printStackTrace();
		} catch(IOException ioex) {
			LOGGER.debug(ioex.getMessage());
			ioex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return user;
	}
	
	/**
	 * Creates the DiscordUser in the datastore.
	 *  
	 * @param id
	 * @param username
	 * @param discriminator
	 * @param avatar
	 * @param bot
	 * @param system
	 * @return the DiscordUser or null if one could not be created.
	 */
	public DiscordUser createUser(
			String id, String username, String discriminator, 
			String avatar, boolean bot) {
		
		BufferedReader in = null;
		HttpURLConnection con = null;
		DiscordUser result = null;
		
		final String POST_PARAMS = "{\n\t" + "\"discord_id\": \"" + id + "\",\n" +
				   "\t" + "\"username\": \"" + username + "\",\n" + 
				   "\t" + "\"discriminator\": \"" + discriminator + "\",\n" + 
				   "\t" + "\"avatar_hash\": \"" + avatar + "\",\n" + 
				   "\t" + "\"bot\": \"" + bot + "\",\n" + 
				   "\t" + "\"password\": \"" + "nonsense" + "\"\n}";
		
		LOGGER.debug("Using parameters: " + POST_PARAMS);
		
		try {
			URL obj = new URL(CREATE_USER_URL);
			con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("x-access-token", TOKEN);
			con.setDoOutput(true);
			
			OutputStream os = con.getOutputStream();
			os.write(POST_PARAMS.getBytes());
			os.flush();
			os.close();
				
			int responseCode = con.getResponseCode();
			
			if(responseCode != HttpURLConnection.HTTP_OK) {
				in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				String inputLine;
				StringBuffer errorResponse = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					errorResponse.append(inputLine);
				}
				
				LOGGER.error("Error while creating user: " + errorResponse.toString());
				in.close();
				con.disconnect();
				throw new IOException(errorResponse.toString());
			} else {
				in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				
				LOGGER.debug(response.toString());
				result = retrieveCreateUserResponse(response.toString());			
				in.close();
				con.disconnect();
			}		
		} catch(MalformedURLException murl) {
			LOGGER.debug(murl.getMessage());
			murl.printStackTrace();
		} catch(IOException ioex) {
			LOGGER.debug(ioex.getMessage());
			ioex.printStackTrace();
		}

		return result;
	}		
	
	private String getToken() {
		StringBuffer result = new StringBuffer();
		BufferedReader in = null;
		HttpURLConnection con = null;
		
		final String POST_PARAMS = "{\n\t" + "\"username\": \"" + ADMIN_USERNAME + "\",\n" +
				"\t" + "\"password\": \"" + ADMIN_CREDENTIALS + "\"\n}";
		LOGGER.debug("Using parameters: " + POST_PARAMS);
		
		try {
			URL obj = new URL(LOGIN_URL);
			con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json");
			con.setDoOutput(true);
			
			LOGGER.debug("Using URL: " + obj.toExternalForm());
			
			OutputStream os = con.getOutputStream();
			os.write(POST_PARAMS.getBytes());
			os.flush();
			os.close();
			
			LOGGER.debug("Using connection URL: " + obj.toString());
				
			int responseCode = con.getResponseCode();
			
			if(responseCode != HttpURLConnection.HTTP_OK) {
				in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				String inputLine;
				StringBuffer errorResponse = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					errorResponse.append(inputLine);
				}
				
				LOGGER.error("Error while retrieving token: " + errorResponse.toString());
				in.close();
				con.disconnect();
				throw new IOException(errorResponse.toString());
			} else {
				in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				
				//handle case where user does not currently exist:
				if(response.toString().equalsIgnoreCase("null")) {
					LOGGER.error("Received a null response while attempting to retrieve token.");
				} else {
					//print response and retrieve token value:
					LOGGER.debug(response.toString());
					result.append(retrieveTokenResponse(response.toString()));
				}				
				in.close();
				con.disconnect();
			}		
		} catch(MalformedURLException murl) {
			LOGGER.debug(murl.getMessage());
			murl.printStackTrace();
		} catch(IOException ioex) {
			LOGGER.debug(ioex.getMessage());
			ioex.printStackTrace();
		}

		return result.toString();
	}
	
	private String retrieveTokenResponse(String response) {
		StringBuffer result = new StringBuffer();
		TokenResponse token;
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			token = mapper.readValue(response, TokenResponse.class);
			result.append(token.getToken());
		} catch (JsonMappingException e) {
			LOGGER.error(e);
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			LOGGER.error(e);
			e.printStackTrace();
		}
		
		return result.toString();
	}
	
	private DiscordUser retrieveCreateUserResponse(String response) {
		DiscordUser user = null;
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			user = mapper.readValue(response, DiscordUser.class);
		} catch (JsonMappingException e) {
			LOGGER.error(e);
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			LOGGER.error(e);
			e.printStackTrace();
		}		
		return user;
	}
	
	private void addActionsToCharacter(CharacterSheet character) {
		List<Action> actions = new ArrayList<>();
		Action result = null;
		
		for(Action action : character.getActions()) {
			LOGGER.debug("Attempting to persist action {}", action);
			String response = addAction(action);
			
			LOGGER.debug("Received response {}", response);
			try {
				result =  MAPPER.readValue(response, Action.class);
				LOGGER.debug("Deserialized response to object {}", result);
			} catch (JsonProcessingException e) {
				LOGGER.error("Failed to marshall action {}", e);
			}
			actions.add(result);
		}
		
		character.setActions(new HashSet<Action>(actions));
	}
	
	private void addAttacksToCharacter(CharacterSheet character) {
		List<Attack> attacks = new ArrayList<>();
		Attack result = null;
		
		for(Attack attack : character.getAttacks()) {
			LOGGER.debug("Attempting to persist attack {}", attack);
			String response = addAttack(attack);
			
			LOGGER.debug("Received response {}", response);			
			try {
				result =  MAPPER.readValue(response, Attack.class);
				LOGGER.debug("Deserialized response to object {}", result);
			} catch (JsonProcessingException e) {
				LOGGER.error("Failed to marshall attack {}", e);
			}
			attacks.add(result);
		}
		
		character.setAttacks(new HashSet<Attack>(attacks));
	}
	
	private void addItemsToCharacter(CharacterSheet character) {
		List<Item> inventory = new ArrayList<>();
		Item result = null;
		
		for(Item item : character.getInventory()) {
			if(item.getGrantedModifiers() != null) {
				addFeaturesToItem(item);
			}
			
			LOGGER.debug("Attempting to persist item {}", item);
			String response = addItem(item);
			
			LOGGER.debug("Received response {}", response);
			try {
				result =  MAPPER.readValue(response, Item.class);
				LOGGER.debug("Deserialized response to object {}", result);
			} catch (JsonProcessingException e) {
				LOGGER.error("Failed to marshall item {}", e);
			}
			inventory.add(result);
		}
		
		character.setInventory(inventory);
	}
	
	private void addClassesToCharacter(CharacterSheet character) {
		List<CharacterClass> classes = new ArrayList<>();
		CharacterClass result = null;
		
		for(CharacterClass charClass : character.getCharacterClasses()) {
			LOGGER.debug("Attempting to persist class {}", charClass);
			String response = addCharacterClass(charClass);
			
			LOGGER.debug("Received response {}", response);
			try {
				result =  MAPPER.readValue(response, CharacterClass.class);
				LOGGER.debug("Deserialized response to object {}", result);
			} catch (JsonProcessingException e) {
				LOGGER.error("Failed to marshall character class {}", e);
			}
			classes.add(result);
		}
		
		character.setCharacterClasses(classes);
	}	
	
	private void addFeaturesToCharacter(CharacterSheet character) {
		List<Feature> features = new ArrayList<>();
		Feature result = null;
		
		for(Feature feature : character.getFeatures()) {
			LOGGER.debug("Attempting to persist feature {}", feature);
			String response = addFeature(feature);
			
			LOGGER.debug("Received response {}", response);			
			try {
				result =  MAPPER.readValue(response, Feature.class);
				LOGGER.debug("Deserialized response to object {}", result);
			} catch (JsonProcessingException e) {
				LOGGER.error("Failed to marshall feature {}", e);
			}
			features.add(result);
		}
		
		character.setFeatures(new HashSet<Feature>(features));
	}
	
	private void addFeaturesToItem(Item item) {
		List<Feature> features = new ArrayList<>();
		Feature result = null;
		
		for(Feature feature : item.getGrantedModifiers()) {
			LOGGER.debug("Attempting to persist feature {}", feature);
			String response = addFeature(feature);
			
			LOGGER.debug("Received response {}", response);	
			
			try {
				result =  MAPPER.readValue(response, Feature.class);
				LOGGER.debug("Deserialized response to object {}", result);
			} catch (JsonProcessingException e) {
				LOGGER.error("Failed to marshall feature {}", e);
			}
			features.add(result);
		}
		
		item.setGrantedModifiers(features);
	}
	
	private String unmarshalObject(Object object) {
		String result = "";
		try {
			result = MAPPER.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			LOGGER.error("Failed to unmarshall object {}", e);
		}
		
		return result;
	}
	
	private String postUrl(String url, String body) {
		
		StringBuilder response = new StringBuilder();
		BufferedReader in = null;
		HttpURLConnection con = null;
		
		body = body.replace(NULL_ID, "");
		
		try {
			URL obj = new URL(url);
			con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("x-access-token", TOKEN);
			con.setDoOutput(true);
			
			OutputStream os = con.getOutputStream();
			os.write(body.getBytes());
			os.flush();
			os.close();
				
			int responseCode = con.getResponseCode();
			
			if(responseCode != HttpURLConnection.HTTP_OK) {
				in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				String inputLine;
				StringBuffer errorResponse = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					errorResponse.append(inputLine);
				}
				
				LOGGER.error("Error while posting: " + errorResponse.toString());
				in.close();
				con.disconnect();
				throw new IOException(errorResponse.toString());
			} else {
				in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				
				LOGGER.debug("Saved successfully: " + response.toString());		
				in.close();
				con.disconnect();
			}		
		} catch(IOException e) {
			LOGGER.error(e);
		} finally {
			con.disconnect();
		}
		
		return response.toString();
	}
}
