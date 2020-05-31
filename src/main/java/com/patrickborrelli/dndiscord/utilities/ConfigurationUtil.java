package com.patrickborrelli.dndiscord.utilities;

import com.patrickborrelli.dndiscord.exceptions.MissingEnvironmentVarException;

/**
 * A singleton configuration utility to provide 
 * necessary data for tool setup.
 * 
 * @author Patrick Borrelli
 */
public class ConfigurationUtil {
	private static volatile ConfigurationUtil instance;
	private static final String DNDISCORD_TOKEN = "DNDISCORD_TOKEN";
	private static final String DNDISCORD_BETA_TOKEN = "DNDISCORD_BETA_TOKEN";
	private static final String BETA = "BETA";
	private static final String PROD = "PROD";
	public static final String DEFAULT_PREFIX = "-";
	private static String token = null;
	private static String prefix = "-";
	private static String scope;
	
	/**
	 * Returns an instance of the ConfigurationUtil to the 
	 * calling client.
	 * 
	 * @return the ConfigurationUtil
	 * @throws MissingEnvironmentVarException if the DNDISCORD_TOKEN is not 
	 * 		present in the environment variables.
	 */
	public static ConfigurationUtil getInstance() throws MissingEnvironmentVarException {
		if(instance == null) {
			synchronized(ConfigurationUtil.class) {
				if(instance == null) {
					instance = new ConfigurationUtil();
				}
			}
		}
		return instance;
	}
	
	private ConfigurationUtil() throws MissingEnvironmentVarException {
		scope = AppUtil.getInstance().getScope();
		initConfig();
	}
	
	private void initConfig() throws MissingEnvironmentVarException {
		if(scope.equalsIgnoreCase(PROD)) {
			token = System.getenv(DNDISCORD_TOKEN);
		} else if(scope.equalsIgnoreCase(BETA)) {
			token = System.getenv(DNDISCORD_BETA_TOKEN);
		}
		if(token == null || token.isEmpty()) {
			throw new MissingEnvironmentVarException("Required DNDISCORD_TOKEN environment variable not found.");
		}
	}

	/**
	 * Retrieve the currently assigned prefix for bot commands.
	 * Default prefix is '!'
	 * 
	 * @return a String containing the prefix code.
	 */
	public String getBotPrefix() {
		return prefix;
	}
	
	/**
	 * Allows the client to change the value of the 
	 * bot prefix code that indicates the message is for the bot.
	 * 
	 * @param thePrefixCode a String representation of the chosen prefix code
	 */
	public void setBotPrefix(String thePrefixCode) {
		prefix = thePrefixCode;
	}
	
	/**
	 * Retrieve the Discord bot token.
	 * 
	 * @return a String representation of the discord token for this bot.
	 */
	public String getBotToken() {
		return token;
	}
}
