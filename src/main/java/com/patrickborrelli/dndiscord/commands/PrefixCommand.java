/**
 * 
 */
package com.patrickborrelli.dndiscord.commands;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;

import com.patrickborrelli.dndiscord.DNDiscordMain;
import com.patrickborrelli.dndiscord.exceptions.CommandProcessingException;
import com.patrickborrelli.dndiscord.exceptions.MissingEnvironmentVarException;
import com.patrickborrelli.dndiscord.messaging.MessageResponse;
import com.patrickborrelli.dndiscord.utilities.ConfigurationUtil;

//TODO: will need to implement a database system so that user/server prefix can be stored in case app goes down

/**
 * Command class to handle all types of prefix commands
 * issued from Discord to the DnDiscord bot.
 * 
 * @author Patrick Borrelli
 */
public class PrefixCommand implements CommandExecutor {
	private static final Logger LOGGER = LogManager.getLogger(DNDiscordMain.class);
	private static ConfigurationUtil instance;
	
	public PrefixCommand() {
		try {
			instance = ConfigurationUtil.getInstance();
		} catch(MissingEnvironmentVarException mevEx) {
			System.err.println("Failed to initiate DNDiscord. " + mevEx.getLocalizedMessage());
			mevEx.printStackTrace();
			LOGGER.error("Failed to initiate DNDiscord. " + mevEx.getLocalizedMessage());
		}
	}

	@Override
	public void onCommand(Message msg) throws CommandProcessingException {
		TextChannel channel = msg.getChannel();
		String[] args = msg.getContent().split(" ");
		String currentPrefix = instance.getBotPrefix();
		
		if(args.length > 2) {
			MessageResponse.sendReply(channel, "Too many arguments provided");
		} else if(args.length == 1) {
			//TODO: send command help
			MessageResponse.sendReply(channel, "You are doing it wrong!");
		} else if(args.length == 2) {
			//get args[1] and set it as the prefix
			instance.setBotPrefix(args[1]);			
			MessageResponse.sendReply(channel, "DnDiscord command prefix changed from: " + currentPrefix + " to: " + instance.getBotPrefix());
		}
	}
}
