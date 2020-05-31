package com.patrickborrelli.dndiscord.utilities;

import org.javacord.api.DiscordApi;

/**
 * A singleton application utility to provide 
 * necessary common data for the bot application.
 * 
 * @author Patrick Borrelli
 */
public class AppUtil {
	private static volatile AppUtil instance;
	
	private static DiscordApi api;
	private static String scope;
	
	/**
	 * Returns an instance of the AppUtil to the 
	 * calling client.
	 * 
	 * @return the AppUtil
	 */
	public static AppUtil getInstance() {
		if(instance == null) {
			synchronized(AppUtil.class) {
				if(instance == null) {
					instance = new AppUtil();
				}
			}
		}
		return instance;
	}
	
	public void setApi(DiscordApi theApi) {
		api = theApi;
	}
	
	public DiscordApi getApi() {
		return api;
	}
	
	public void setScope(String appScope) {
		scope = appScope;
	}
	
	public String getScope() {
		return scope;
	}
}
