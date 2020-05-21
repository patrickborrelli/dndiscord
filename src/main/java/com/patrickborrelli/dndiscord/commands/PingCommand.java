package com.patrickborrelli.dndiscord.commands;

import java.text.SimpleDateFormat;
import java.util.Date;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;

/**
 * Command class to handle all types of ping commands
 * issued from Discord to the DnDiscord bot.
 * 
 * @author Patrick Borrelli
 */
public class PingCommand implements CommandExecutor {

	@Command(aliases = "ping", description = "Ensures proper communication to the bot", usage = "ping [author|time]")
	public String onPingCommand(String[] args) {
		if(args.length > 1) {
			return "Too many arguments provided";
		}
		if(args.length == 0) {
			return "Pong bitches!";
		}
		if(args.length == 1) {
			if(args[0].equals("author")) {
				return "- **Name:** Patrick Borrelli\n" +
					   "- **Website:** https://github.com/patrickborrelli";
			} 
			if(args[0].equals("time")) {
				SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                Date currentDate = new Date(System.currentTimeMillis());
                return "It's" + format.format(currentDate);
			}
		}
		return "Unknown argument provided.";
	}
}
