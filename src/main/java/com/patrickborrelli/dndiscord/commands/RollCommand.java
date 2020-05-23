package com.patrickborrelli.dndiscord.commands;

import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;

import com.patrickborrelli.dndiscord.exceptions.CommandProcessingException;
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
		
		if(args.length < 2) {
			MessageResponse.sendReply(channel, "Not enough arguments provided");
		} else {
			MessageResponse.sendReply(channel, "Will attempt to parse" + msg.getContent());
		}
	}
}
