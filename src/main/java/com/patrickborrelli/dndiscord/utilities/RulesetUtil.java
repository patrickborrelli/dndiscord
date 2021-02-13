package com.patrickborrelli.dndiscord.utilities;

import java.util.HashMap;

import org.javacord.api.DiscordApi;

/**
 * A singleton ruleset utility to provide 
 * necessary common data for the bot application.
 * 
 * @author Patrick Borrelli
 */
public class RulesetUtil {
	private static volatile RulesetUtil instance;
	private static HashMap<Integer, Integer> modMap;
	
	static {
		modMap = new HashMap<Integer, Integer>();
		modMap.put(1, -5);
		modMap.put(2, -4);
		modMap.put(3, -4);
		modMap.put(4, -3);
		modMap.put(5, -3);
		modMap.put(6, -2);
		modMap.put(7, -2);
		modMap.put(8, -1);
		modMap.put(9, -1);
		modMap.put(10, 0);
		modMap.put(11, 0);
		modMap.put(12, 1);
		modMap.put(13, 1);
		modMap.put(14, 2);
		modMap.put(15, 2);
		modMap.put(16, 3);
		modMap.put(17, 3);
		modMap.put(18, 4);
		modMap.put(19, 4);
		modMap.put(20, 5);
		modMap.put(21, 5);
		modMap.put(22, 6);
		modMap.put(23, 6);
		modMap.put(24, 7);
		modMap.put(25, 7);
		modMap.put(26, 8);
		modMap.put(27, 8);
		modMap.put(28, 9);
		modMap.put(29, 9);
		modMap.put(30, 10);
	}
	
	private RulesetUtil() {
		//any necessary initialization
	}
	
	/**
	 * Returns an instance of the RulesetUtil to the 
	 * calling client.
	 * 
	 * @return the RulesetUtil
	 */
	public static RulesetUtil getInstance() {
		if(instance == null) {
			synchronized(RulesetUtil.class) {
				if(instance == null) {
					instance = new RulesetUtil();
				}
			}
		}
		return instance;
	}
	
	/**
	 * Retrieves the appropriate ability score modifier.
	 * 
	 * @param value an int representing the ability score
	 * @return an int representing the ability score modifier
	 */
	public int getAbilityScoreMod(int value) {
		return modMap.get(value);
	}
	
}
