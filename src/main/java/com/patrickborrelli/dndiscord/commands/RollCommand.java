package com.patrickborrelli.dndiscord.commands;

import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;

import com.patrickborrelli.dndiscord.exceptions.CommandProcessingException;
import com.patrickborrelli.dndiscord.mechanics.DieType;
import com.patrickborrelli.dndiscord.messaging.MessageResponse;

/**
 * Command class to handle all types of dice rolling
 * commands issued to the DnDiscord bot.
 */
public class RollCommand implements CommandExecutor {

	@Override
	public void onCommand(Message msg) throws CommandProcessingException {
		TextChannel channel = msg.getChannel();
		String[] args = msg.getContent().split(" ");
		StringBuilder rollString = extractCommand(args);
		
		if(args.length < 2) {
			MessageResponse.sendReply(channel, "Not enough arguments provided");
		} else {
			MessageResponse.sendReply(channel, "Will attempt to parse " + rollString.toString());
			MessageResponse.sendReply(channel, generateRollResponse(rollString.toString()));
		}
	}
	
	private StringBuilder extractCommand(String[] args) {
		StringBuilder result = new StringBuilder();
		for(int i = 1; i < args.length; i++) {
			result.append(args[i]);
		}
		return result;		
	}
	
	private String generateRollResponse(String param) {
		StringBuilder result = new StringBuilder();
		 
		return result.toString();
	}
}