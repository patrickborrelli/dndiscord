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
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.patrickborrelli.dndiscord.model.DiscordUser;
import com.patrickborrelli.dndiscord.model.Formula;
import com.patrickborrelli.dndiscord.model.TokenResponse;

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
	private static String TOKEN = "";
	
	//static URLs
	private static final String BASE_URL = System.getenv("DNDISCORD_API_BASE");
	private static final String GET_USER_URL = BASE_URL + "/users/discordUser/";
	private static final String CREATE_USER_URL = BASE_URL + "/users/register";
	private static final String LOGIN_URL = BASE_URL + "/users/login";
	private static final String FORMULA_URL = BASE_URL + "/formulae";
	private static final String QUERY = "?";
	
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
					LOGGER.debug(response.toString());
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
	
}
