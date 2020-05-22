package com.patrickborrelli.dndiscord.commands;

import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;

import com.patrickborrelli.dndiscord.exceptions.CommandProcessingException;
import com.patrickborrelli.dndiscord.messaging.MessageResponse;

/**
 * Command class to handle all types of help commands
 * issued from Discord to the DnDiscord bot.
 * 
 * @author Patrick Borrelli
 */
public class HelpCommand implements CommandExecutor {

	@Override
	public void onCommand(Message msg) throws CommandProcessingException {
		TextChannel channel = msg.getChannel();
		String[] args = msg.getContent().split(" ");
		
		if(args.length > 2) {
			MessageResponse.sendReply(channel, "Too many arguments provided");
		} else if(args.length == 1) {
			//send generic help response
		} else if(args.length == 2) {
			//specific command help
		} else {
			MessageResponse.sendReply(channel, "Unknown argument provided.");
		}
	}
}
