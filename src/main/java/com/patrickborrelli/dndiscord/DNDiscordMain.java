package com.patrickborrelli.dndiscord;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.intent.Intent;

import com.patrickborrelli.dndiscord.exceptions.MissingEnvironmentVarException;
import com.patrickborrelli.dndiscord.listeners.DNDiscordMessageCreateListener;
import com.patrickborrelli.dndiscord.utilities.AppUtil;
import com.patrickborrelli.dndiscord.utilities.ConfigurationUtil;

public class DNDiscordMain {
	
	private static final Logger LOGGER = LogManager.getLogger(DNDiscordMain.class);
	
	public static void main(String args[]) {
		
		if(args.length != 1) {
			System.out.println("Error in provided arguments.");
			return;
		}
		
		String token = null;
		ConfigurationUtil instance;
		AppUtil appUtilInstance;
		
		try {
			String scope = args[0];
			appUtilInstance = AppUtil.getInstance();
			appUtilInstance.setScope(scope.toUpperCase());
			if(LOGGER.isDebugEnabled()) {
				LOGGER.debug("Attempting to have DNDiscord login and join.");
			}
			instance = ConfigurationUtil.getInstance();
			
			token = instance.getBotToken();
			DiscordApi api = new DiscordApiBuilder().setToken(token).addIntents(Intent.MESSAGE_CONTENT).login().join();
			appUtilInstance.setApi(api);
			
	        api.addMessageCreateListener(new DNDiscordMessageCreateListener());
		} catch(MissingEnvironmentVarException mevEx) {
			System.err.println("Failed to initiate DNDiscord. " + mevEx.getLocalizedMessage());
			mevEx.printStackTrace();
			LOGGER.error("Failed to initiate DNDiscord. " + mevEx.getLocalizedMessage());
		}        
    }
}
