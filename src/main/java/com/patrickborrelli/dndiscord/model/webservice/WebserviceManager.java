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
import com.fasterxml.jackson.databind.ObjectReader;
import com.patrickborrelli.dndiscord.model.DiscordUser;
import com.patrickborrelli.dndiscord.model.Formula;
import com.patrickborrelli.dndiscord.model.TokenResponse;
import com.patrickborrelli.dndiscord.model.dndbeyond.DndBeyondSheet;
import com.patrickborrelli.dndiscord.model.dndiscord.Action;
import com.patrickborrelli.dndiscord.model.dndiscord.Attack;
import com.patrickborrelli.dndiscord.model.dndiscord.CharacterBrief;
import com.patrickborrelli.dndiscord.model.dndiscord.CharacterClass;
import com.patrickborrelli.dndiscord.model.dndiscord.CharacterSheet;
import com.patrickborrelli.dndiscord.model.dndiscord.Feature;
import com.patrickborrelli.dndiscord.model.dndiscord.Item;
import com.patrickborrelli.dndiscord.utilities.AppUtil;
import com.patrickborrelli.dndiscord.utilities.ApplicationObjectMapper;
import com.patrickborrelli.dndiscord.utilities.ConfigurationUtil;

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
	private static final ObjectMapper MAPPER = ApplicationObjectMapper.getInstance();
	private static final ObjectReader CHARACTER_READER = MAPPER.reader().forType(CharacterSheet.class);
	private static final ObjectReader FORMULA_READER = MAPPER.reader().forType(Formula.class);
	private static final ObjectReader FORMULA_ARRAY_READER = MAPPER.reader().forType(Formula[].class);
	private static final ObjectReader DISCORD_USER_READER = MAPPER.reader().forType(DiscordUser.class);
	private static final String QUERY = "?";
	private static final String NULL_ID = ",\"_id\":null";
	
	//static URLs
	private static final String ACTION_URL;
	private static final String ACTIVE_URL;
	private static final String ATTACK_URL;
	private static final String BASE_URL;
	private static final String CHARACTER_URL;
	private static final String CHARACTER_CLASS_URL;
	private static final String CREATE_USER_URL;
	private static final String FEATURE_URL;
	private static final String FORMULA_URL;
	private static final String USER_URL;
	private static final String USER_CHAR_URL;
	private static final String LAZY_URL;
	private static final String UPDATE_USER_URL;
	private static final String ITEM_URL;
	private static final String LOGIN_URL;

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
		USER_URL = BASE_URL + "users/discordUser";	
		USER_CHAR_URL = BASE_URL + "users/characters";
		UPDATE_USER_URL = BASE_URL + "users";
		ITEM_URL = BASE_URL + "items";
		LOGIN_URL = BASE_URL + "users/login";
		LAZY_URL = USER_CHAR_URL + "/lazy";
		ACTIVE_URL = CHARACTER_URL + "/setActive";
		
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
		
		if(LOGGER.isDebugEnabled()) 
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
				
				if(LOGGER.isDebugEnabled()) 
					LOGGER.debug("Deleted successfully: " + response.toString());
				buff.append(response.toString());		
				in.close();
				con.disconnect();
			}		
		} catch(MalformedURLException murl) {
			LOGGER.warn(murl.getMessage());
			murl.printStackTrace();
		} catch(IOException ioex) {
			LOGGER.warn(ioex.getMessage());
			ioex.printStackTrace();
		}
		return buff.toString();
	}
	
	/**
	 * Adds a new character to an existing User.
	 * 
	 * @param user
	 * @param character
	 * @return
	 */
	public CharacterSheet addUserCharacter(DiscordUser user, CharacterSheet character) {
		
		CharacterSheet addedCharacter = null; 
				
		//first ensure any children are persisted:
		if(character.getInventory() != null) addItemsToCharacter(character);
		if(character.getActions() != null) addActionsToCharacter(character);
		if(character.getAttacks() != null) addAttacksToCharacter(character);	
		if(character.getCharacterClasses() != null) addClassesToCharacter(character);
		if(character.getFeatures() != null) addFeaturesToCharacter(character);	
		character.setUser(user);
		
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("Making call to API: " + CHARACTER_URL);
			LOGGER.debug("Attempting to unmarshall object: " + character);
		}
		String POST_BODY = unmarshalObject(character);	
		
		if(LOGGER.isDebugEnabled()) 
			LOGGER.debug("Submitting JSON: {}", POST_BODY);
		String result = post(CHARACTER_URL, POST_BODY);
		
		if(LOGGER.isDebugEnabled()) 
			LOGGER.debug("Post result: {}", result);
		
		try {
			addedCharacter =  CHARACTER_READER.readValue(result);
			if(LOGGER.isDebugEnabled()) 
				LOGGER.debug("Deserialized response to object {}", addedCharacter);
		} catch (JsonProcessingException e) {
			LOGGER.error("Failed to marshall character sheet {}", e);
		}
		
		user.setActiveCharacter(addedCharacter.getDisplaySheet());
		return addedCharacter;
	}
	
	public String setActiveCharacter(String userId, String characterId) {
		StringBuilder buf = new StringBuilder();
		buf.append(ACTIVE_URL)
			.append("/")
			.append(userId)
			.append("/")
			.append(characterId);
		
		if(LOGGER.isDebugEnabled()) 
			LOGGER.debug("Making call to API: " + buf.toString());
		
		return put(buf.toString(), "");
	}
	
	public CharacterSheet getCharacter(String characterId) {
		StringBuilder buf = new StringBuilder();
		buf.append(CHARACTER_URL+ "/")
			.append(characterId);
		
		if(LOGGER.isDebugEnabled()) 
			LOGGER.debug("Making call to API: " + buf.toString());
		
		BufferedReader in = null;
		HttpURLConnection con = null;
		CharacterSheet character = null;
		
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
				if(LOGGER.isDebugEnabled()) 
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
					if(LOGGER.isDebugEnabled()) 
						LOGGER.debug("Received a null response");
				} else {
					//print response:
					if(LOGGER.isDebugEnabled()) 
						LOGGER.debug("Retrieved User: {}", response);
					character = CHARACTER_READER.readValue(response.toString());					
				}
				
				in.close();
				con.disconnect();
			}		
		} catch(MalformedURLException murl) {
			LOGGER.warn(murl.getMessage());
			murl.printStackTrace();
		} catch(IOException ioex) {
			LOGGER.warn(ioex.getMessage());
			ioex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return character;
	}
	
	/**
	 * Generic User update method.
	 * @param user
	 * @return
	 */
	public String updateUser(DiscordUser user) {
		if(LOGGER.isDebugEnabled()) 
			LOGGER.debug("Sending user : " + user + " to update");
		String unmarshalled = unmarshalObject(user);
		
		return put(UPDATE_USER_URL + "/" + user.getId(), unmarshalled);
	}
	
	public String addAction(Action action) {
		if(LOGGER.isDebugEnabled()) 
			LOGGER.debug("Making call to API: " + ACTION_URL);

		String POST_BODY = unmarshalObject(action);
		return post(ACTION_URL, POST_BODY);
	}
	
	public String addAttack(Attack attack) {
		if(LOGGER.isDebugEnabled()) 
			LOGGER.debug("Making call to API: " + ATTACK_URL);
		
		String POST_BODY = unmarshalObject(attack);			
		return post(ATTACK_URL, POST_BODY);
	}
	
	public String addCharacterClass(CharacterClass charClass) {
		if(LOGGER.isDebugEnabled()) 
			LOGGER.debug("Making call to API: " + CHARACTER_CLASS_URL);
		
		String POST_BODY = unmarshalObject(charClass);			
		return post(CHARACTER_CLASS_URL, POST_BODY);
	}
	
	public String addFeature(Feature feature) {
		if(LOGGER.isDebugEnabled()) 
			LOGGER.debug("Making call to API: " + FEATURE_URL);
		
		String POST_BODY = unmarshalObject(feature);			
		return post(FEATURE_URL, POST_BODY);
	}
	
	public String addItem(Item item) {
		if(LOGGER.isDebugEnabled()) 
			LOGGER.debug("Making call to API: " + ITEM_URL);
		
		String POST_BODY = unmarshalObject(item);			
		return post(ITEM_URL, POST_BODY);
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
		
		if(LOGGER.isDebugEnabled()) 
			LOGGER.debug("Making call to API: " + FORMULA_URL);
		
		BufferedReader in = null;
		HttpURLConnection con = null;
		
		final String POST_PARAMS = "{\n\t" + "\"user\": \"" + user.getId() + "\",\n" +
				   "\t" + "\"name\": \"" + name + "\",\n" + 
				   "\t" + "\"roll\": \"" + formula + "\"\n}";
		
		if(LOGGER.isDebugEnabled()) 
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
				
				if(LOGGER.isDebugEnabled()) 
					LOGGER.debug("Saved successfully: " + response.toString());
				buff.append("User formula: " + formula + " can now be called with roll $" + name);		
				in.close();
				con.disconnect();
			}		
		} catch(MalformedURLException murl) {
			LOGGER.warn(murl.getMessage());
			murl.printStackTrace();
		} catch(IOException ioex) {
			LOGGER.warn(ioex.getMessage());
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
		if(LOGGER.isDebugEnabled()) 
			LOGGER.debug("Making call to API: " + url.toString());
		
		BufferedReader in = null;
		HttpURLConnection con = null;
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
				if(LOGGER.isDebugEnabled()) 
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
					if(LOGGER.isDebugEnabled()) 
						LOGGER.debug("Received a null response");
				} else {
					//print response:
					if(LOGGER.isDebugEnabled()) 
						LOGGER.debug(response.toString());
					formulas = FORMULA_READER.readValue(response.toString());			
				}
				
				in.close();
				con.disconnect();
			}		
		} catch(MalformedURLException murl) {
			LOGGER.warn(murl.getMessage());
			murl.printStackTrace();
		} catch(IOException ioex) {
			LOGGER.warn(ioex.getMessage());
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
		if(LOGGER.isDebugEnabled()) 
			LOGGER.debug("Making call to API: " + url.toString());
		
		BufferedReader in = null;
		HttpURLConnection con = null;
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
				if(LOGGER.isDebugEnabled()) 
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
					if(LOGGER.isDebugEnabled()) 
						LOGGER.debug("Received a null response");
				} else {
					//print response:
					if(LOGGER.isDebugEnabled()) 
						LOGGER.debug(response.toString());
					formulas = FORMULA_ARRAY_READER.readValue(response.toString());			
				}
				
				in.close();
				con.disconnect();
			}		
		} catch(MalformedURLException murl) {
			LOGGER.warn(murl.getMessage());
			murl.printStackTrace();
		} catch(IOException ioex) {
			LOGGER.warn(ioex.getMessage());
			ioex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		result = (formulas == null) ? null : new ArrayList<>(Arrays.asList(formulas));		
		return result;
	}
	
	public List<CharacterBrief> getUserCharactersLazy(DiscordUser user) {
		List<CharacterBrief> result = new ArrayList<>();
		StringBuilder url = new StringBuilder().append(LAZY_URL).append("/").append(user.getDiscord_id());

		if(LOGGER.isDebugEnabled()) 
			LOGGER.debug("Making call to API: " + url.toString());
		
		BufferedReader in = null;
		HttpURLConnection con = null;
		CharacterBrief[] characters = null;
		ObjectReader charBriefReader = MAPPER.reader().forType(CharacterBrief[].class);
		
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
				
				if(LOGGER.isDebugEnabled()) 
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
				
				//handle case where no characters returned:
				if(response.toString().equalsIgnoreCase("null") || response.toString().equalsIgnoreCase("[]")) {
					if(LOGGER.isDebugEnabled()) 
						LOGGER.debug("Received an empty response");
				} else {
					//print response:
					if(LOGGER.isDebugEnabled()) 
						LOGGER.debug(response.toString());	
					characters = charBriefReader.readValue(response.toString());
				}
				
				in.close();
				con.disconnect();
			}		
		} catch(MalformedURLException murl) {
			LOGGER.warn(murl.getMessage());
			murl.printStackTrace();
		} catch(IOException ioex) {
			LOGGER.warn(ioex.getMessage());
			ioex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		result = (characters == null) ? null : new ArrayList<>(Arrays.asList(characters));
		return result;
	}
	
	/**
	 * Retrieves a comma-delimited string containing all characters currently imported by the user.
	 * @param user
	 * @return
	 */
	public String getUserCharacterNames(DiscordUser user) {
		String result = "";
		StringBuilder url = new StringBuilder().append(USER_CHAR_URL).append("/").append(user.getDiscord_id());

		if(LOGGER.isDebugEnabled()) 
			LOGGER.debug("Making call to API: " + url.toString());
		
		BufferedReader in = null;
		HttpURLConnection con = null;
		
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
				
				if(LOGGER.isDebugEnabled()) 
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
					if(LOGGER.isDebugEnabled()) 
						LOGGER.debug("Received a null response");
				} else {
					//print response:
					if(LOGGER.isDebugEnabled()) 
						LOGGER.debug(response.toString());	
					result = response.toString();
				}
				
				in.close();
				con.disconnect();
			}		
		} catch(MalformedURLException murl) {
			LOGGER.warn(murl.getMessage());
			murl.printStackTrace();
		} catch(IOException ioex) {
			LOGGER.warn(ioex.getMessage());
			ioex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
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
		buf.append(USER_URL+ "/")
			.append(discordId);
		
		if(LOGGER.isDebugEnabled()) 
			LOGGER.debug("Making call to API: " + buf.toString());
		
		BufferedReader in = null;
		HttpURLConnection con = null;
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
				if(LOGGER.isDebugEnabled()) 
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
					if(LOGGER.isDebugEnabled()) 
						LOGGER.debug("Received a null response");
				} else {
					//print response:
					if(LOGGER.isDebugEnabled()) 
						LOGGER.debug("Retrieved User: {}", response);
					user = DISCORD_USER_READER.readValue(response.toString());					
				}
				
				in.close();
				con.disconnect();
			}		
		} catch(MalformedURLException murl) {
			LOGGER.warn(murl.getMessage());
			murl.printStackTrace();
		} catch(IOException ioex) {
			LOGGER.warn(ioex.getMessage());
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
				
				if(LOGGER.isDebugEnabled()) 
					LOGGER.debug(response.toString());
				result = retrieveCreateUserResponse(response.toString());			
				in.close();
				con.disconnect();
			}		
		} catch(MalformedURLException murl) {
			LOGGER.warn(murl.getMessage());
			murl.printStackTrace();
		} catch(IOException ioex) {
			LOGGER.warn(ioex.getMessage());
			ioex.printStackTrace();
		}

		return result;
	}		
	
	/**
	 * Remove an existing character sheet from a User.
	 * 
	 * @param user
	 * @param character
	 * @return a DiscordUser with the character removed.
	 */
	public DiscordUser removeUserCharacter(DiscordUser user, String characterId) {
		DiscordUser updatedUser = null;
		
		delete(CHARACTER_URL + "/" + characterId, "");	
		//TODO: possibly need to reread the user from the DB at this point as we have a stale instance:\
		DiscordUser editedUser = getUser(user.getDiscord_id());
			
		editedUser.setActiveCharacter(null);
		String unmarshalled = unmarshalObject(editedUser);
		
		String result = put(UPDATE_USER_URL + "/" + editedUser.getId(), unmarshalled);
		
		//print response:
		if(LOGGER.isDebugEnabled()) 
			LOGGER.debug("Modified User: {}", result);
		
		try {			
			updatedUser = DISCORD_USER_READER.readValue(result.toString());
		} catch (JsonMappingException e) {
			LOGGER.error(e);
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			LOGGER.error(e);
			e.printStackTrace();
		}
		return updatedUser;
	}
	
	/**
	 * Retrieve a DNDBeyond character sheet if one exists.
	 * 
	 * @param urlString the URL of the character sheet json request
	 * @return a DndBeyondSheet object
	 */
	public DndBeyondSheet importDndBeyondSheet(String urlString) {
		DndBeyondSheet response = null;
		ObjectReader dndBeyondSheetReader = MAPPER.reader().forType(DndBeyondSheet.class);
		
		
		if(urlString != null && !urlString.isEmpty()) {			
			HttpURLConnection connection = null;
			
			try {
				URL url = new URL(urlString);
				connection = (HttpURLConnection) url.openConnection();
				connection.setRequestProperty("User-Agent", ConfigurationUtil.HTTP_USER_AGENT);
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

				String inputLine;
				StringBuffer content = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					content.append(inputLine);
					if(LOGGER.isDebugEnabled()) 
						LOGGER.debug("READ LINE: {}", inputLine);
				}
				in.close();

				response = dndBeyondSheetReader.readValue(content.toString());
			} catch(Exception e) {
				LOGGER.error("We broke something: {}", e);
			} finally {
				connection.disconnect();
			}
		}
		return response;
	}
	
	private String getToken() {
		StringBuffer result = new StringBuffer();
		BufferedReader in = null;
		HttpURLConnection con = null;
		
		final String POST_PARAMS = "{\n\t" + "\"username\": \"" + ADMIN_USERNAME + "\",\n" +
				"\t" + "\"password\": \"" + ADMIN_CREDENTIALS + "\"\n}";
		if(LOGGER.isDebugEnabled()) 
			LOGGER.debug("Using parameters: " + POST_PARAMS);
		
		try {
			URL obj = new URL(LOGIN_URL);
			con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json");
			con.setDoOutput(true);
			
			if(LOGGER.isDebugEnabled()) 
				LOGGER.debug("Using URL: " + obj.toExternalForm());
			
			OutputStream os = con.getOutputStream();
			os.write(POST_PARAMS.getBytes());
			os.flush();
			os.close();
			
			if(LOGGER.isDebugEnabled()) 
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
					if(LOGGER.isDebugEnabled()) 
						LOGGER.debug(response.toString());
					result.append(retrieveTokenResponse(response.toString()));
				}				
				in.close();
				con.disconnect();
			}		
		} catch(MalformedURLException murl) {
			LOGGER.warn(murl.getMessage());
			murl.printStackTrace();
		} catch(IOException ioex) {
			LOGGER.warn(ioex.getMessage());
			ioex.printStackTrace();
		}

		return result.toString();
	}
	
	private String retrieveTokenResponse(String response) {
		StringBuffer result = new StringBuffer();
		TokenResponse token;
		ObjectReader tokenResponseReader = MAPPER.reader().forType(TokenResponse.class);
		
		try {
			token = tokenResponseReader.readValue(response);
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
		
		try {
			user = DISCORD_USER_READER.readValue(response);
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
		ObjectReader actionReader = MAPPER.reader().forType(Action.class);
		
		for(Action action : character.getActions()) {
			if(LOGGER.isDebugEnabled()) 
				LOGGER.debug("Attempting to persist action {}", action);
			String response = addAction(action);
			
			LOGGER.debug("Received response {}", response);
			try {
				result =  actionReader.readValue(response);
				if(LOGGER.isDebugEnabled()) 
					LOGGER.debug("Deserialized response to object {}", result);
			} catch (JsonProcessingException e) {
				LOGGER.error("Failed to marshall action {}", e);
			}
			actions.add(new Action(result.getId()));
		}
		
		character.setActions(new HashSet<Action>(actions));
	}
	
	private void addAttacksToCharacter(CharacterSheet character) {
		List<Attack> attacks = new ArrayList<>();
		Attack result = null;
		ObjectReader attackReader = MAPPER.reader().forType(Attack.class);
		
		for(Attack attack : character.getAttacks()) {
			if(LOGGER.isDebugEnabled()) 
				LOGGER.debug("Attempting to persist attack {}", attack);
			String response = addAttack(attack);
			
			if(LOGGER.isDebugEnabled()) 
				LOGGER.debug("Received response {}", response);			
			try {
				result =  attackReader.readValue(response);
				if(LOGGER.isDebugEnabled()) 
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
		ObjectReader itemReader = MAPPER.reader().forType(Item.class);
		
		for(Item item : character.getInventory()) {
			if(item.getGrantedModifiers() != null) {
				addFeaturesToItem(item);
			}
			
			if(LOGGER.isDebugEnabled()) 
				LOGGER.debug("Attempting to persist item {}", item);
			String response = addItem(item);
			
			if(LOGGER.isDebugEnabled()) 
				LOGGER.debug("Received response {}", response);
			try {
				result =  itemReader.readValue(response);
				if(LOGGER.isDebugEnabled()) 
					LOGGER.debug("Deserialized response to object {}", result);
			} catch (JsonProcessingException e) {
				LOGGER.error("Failed to marshall item {}", e);
			}
			inventory.add(new Item(result.getId()));
		}		
		character.setInventory(inventory);
	}
	
	private void addClassesToCharacter(CharacterSheet character) {
		List<CharacterClass> classes = new ArrayList<>();
		CharacterClass result = null;
		ObjectReader characterClassReader = MAPPER.reader().forType(CharacterClass.class);
		
		for(CharacterClass charClass : character.getCharacterClasses()) {
			if(LOGGER.isDebugEnabled()) 
				LOGGER.debug("Attempting to persist class {}", charClass);
			String response = addCharacterClass(charClass);
			
			if(LOGGER.isDebugEnabled()) 
				LOGGER.debug("Received response {}", response);
			try {
				result =  characterClassReader.readValue(response);
				if(LOGGER.isDebugEnabled()) 
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
		ObjectReader featureReader = MAPPER.reader().forType(Feature.class);
		
		for(Feature feature : character.getFeatures()) {
			if(LOGGER.isDebugEnabled()) 
				LOGGER.debug("Attempting to persist feature {}", feature);
			String response = addFeature(feature);
			
			if(LOGGER.isDebugEnabled()) 
				LOGGER.debug("Received response {}", response);			
			try {
				result =  featureReader.readValue(response);
				if(LOGGER.isDebugEnabled()) 
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
		ObjectReader featureReader = MAPPER.reader().forType(Feature.class);
		
		for(Feature feature : item.getGrantedModifiers()) {
			if(LOGGER.isDebugEnabled()) 
				LOGGER.debug("Attempting to persist feature {}", feature);
			String response = addFeature(feature);
			
			if(LOGGER.isDebugEnabled()) 
				LOGGER.debug("Received response {}", response);	
			
			try {
				result =  featureReader.readValue(response);
				if(LOGGER.isDebugEnabled()) 
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
	
	private String post(String url, String body) {
		
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
				
				if(LOGGER.isDebugEnabled()) 
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
	
	private String put(String url, String body) {
		
		StringBuilder response = new StringBuilder();
		BufferedReader in = null;
		HttpURLConnection con = null;
				
		try {
			URL obj = new URL(url);
			con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("PUT");
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("x-access-token", TOKEN);
			con.setDoOutput(true);
			
			OutputStream os = con.getOutputStream();
			os.write(body.getBytes());
			os.flush();
			os.close();
			
			if(LOGGER.isDebugEnabled()) {
				LOGGER.debug("Sending connection request: " + con);
				LOGGER.debug("With body: " + body);
			}
				
			int responseCode = con.getResponseCode();
			
			if(responseCode != HttpURLConnection.HTTP_OK) {
				in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				String inputLine;
				StringBuffer errorResponse = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					errorResponse.append(inputLine);
				}
				
				LOGGER.error("Error while updating: " + errorResponse.toString());
				in.close();
				con.disconnect();
				throw new IOException(errorResponse.toString());
			} else {
				in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				
				if(LOGGER.isDebugEnabled()) 
					LOGGER.debug("Updated successfully: " + response.toString());		
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
	
	private String delete(String url, String body) {
		
		StringBuilder response = new StringBuilder();
		BufferedReader in = null;
		HttpURLConnection con = null;
		
		try {
			URL obj = new URL(url);
			con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("DELETE");
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("x-access-token", TOKEN);
			con.setDoOutput(true);
			
			OutputStream os = con.getOutputStream();
			os.write(body.getBytes());
			os.flush();
			os.close();
			
			if(LOGGER.isDebugEnabled()) {
				LOGGER.debug("Sending connection request: " + con);
				LOGGER.debug("With body: " + con.getOutputStream().toString());
			}
				
			int responseCode = con.getResponseCode();
			
			if(responseCode != HttpURLConnection.HTTP_OK) {
				in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				String inputLine;
				StringBuffer errorResponse = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					errorResponse.append(inputLine);
				}
				
				LOGGER.error("Error while removing item: " + errorResponse.toString());
				in.close();
				con.disconnect();
				throw new IOException(errorResponse.toString());
			} else {
				in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				
				if(LOGGER.isDebugEnabled()) 
					LOGGER.debug("Successfully removed: " + response.toString());		
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
