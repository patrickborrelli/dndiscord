package com.patrickborrelli.dndiscord.commands;

import java.util.HashMap;

import com.patrickborrelli.dndiscord.utilities.CommandUtil;

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
		map.put(CommandUtil.PING, new PingCommand());
		map.put(CommandUtil.PREFIX, new PrefixCommand());
		map.put(CommandUtil.HELP, new HelpCommand());
		map.put(CommandUtil.ROLL, new RollCommand());
		map.put(CommandUtil.ADMIN,  new AdminCommand());
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
