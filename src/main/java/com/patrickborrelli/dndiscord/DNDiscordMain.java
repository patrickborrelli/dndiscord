package com.patrickborrelli.dndiscord;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

import com.patrickborrelli.dndiscord.exceptions.MissingEnvironmentVarException;
import com.patrickborrelli.dndiscord.listeners.DNDiscordMessageCreateListener;
import com.patrickborrelli.dndiscord.utilities.ConfigurationUtil;

public class DNDiscordMain {
	
	private static final Logger LOGGER = LogManager.getLogger(DNDiscordMain.class);
	
	public static void main(String args[]) {
		
		String token = null;
		ConfigurationUtil instance;
		try {
			LOGGER.debug("Attempting to have DNDiscord login and join.");
			instance = ConfigurationUtil.getInstance();
			token = instance.getBotToken();
			DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();
			
	        api.addMessageCreateListener(new DNDiscordMessageCreateListener());
		} catch(MissingEnvironmentVarException mevEx) {
			System.err.println("Failed to initiate DNDiscord. " + mevEx.getLocalizedMessage());
			mevEx.printStackTrace();
			LOGGER.error("Failed to initiate DNDiscord. " + mevEx.getLocalizedMessage());
		}

        
    }
}
