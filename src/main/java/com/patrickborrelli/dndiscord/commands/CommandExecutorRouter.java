package com.patrickborrelli.dndiscord.commands;

import java.util.HashMap;

/**
 * Command Factory singleton that handles all
 * message routing from listeners to command executors.
 * 
 * @author Patrick Borrelli
 *
 */
public class CommandExecutorRouter {
	HashMap<String, CommandExecutor> map = new HashMap<>();
	private static volatile CommandExecutorRouter INSTANCE;
	
	public static CommandExecutorRouter getInstance() {
		if(INSTANCE == null) {
			synchronized(CommandExecutorRouter.class) {
				if(INSTANCE == null) {
					INSTANCE = new CommandExecutorRouter();
				}
			}
		}
		return INSTANCE;
	}
	
	private CommandExecutorRouter() {
		initMap();
	}
	
	private void initMap() {
		map.put("ping", new PingCommand());
		map.put("prefix", new PrefixCommand());
		map.put("help", new HelpCommand());
	}
	
	/**
	 * Retrieve the appropriate CommandExecutor instance
	 * for the provided message type.
	 * 
	 * @param key a String indicating the message type.
	 * @return the appropriate CommandExecutor or null if none is defined.
	 */
	public CommandExecutor getCommandExecutor(String key) {
		return map.get(key);
	}
}
