package com.patrickborrelli.dndiscord.commands;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;

import com.patrickborrelli.dndiscord.exceptions.CommandProcessingException;
import com.patrickborrelli.dndiscord.messaging.MessageResponse;
import com.patrickborrelli.dndiscord.model.DiscordUser;

/**
 * Command class to handle all types of ping commands
 * issued from Discord to the DnDiscord bot.
 * 
 * @author Patrick Borrelli
 */
public class PingCommand implements CommandExecutor {

	@Override
	public void onCommand(Message msg, DiscordUser user, long messageReceiptTime) throws CommandProcessingException {
		TextChannel channel = msg.getChannel();
		String[] args = msg.getContent().split(" ");
		
		if(args.length > 2) {
			MessageResponse.sendReply(channel, "Too many arguments provided");
		} else if(args.length == 1) {
			long currentTime = System.currentTimeMillis();
			
			MessageResponse.sendReply(channel, "Message processing time: " + (currentTime - messageReceiptTime) + " milliseconds.");
		} else if(args.length == 2) {
			if(args[1].equals("author")) {
				MessageResponse.sendReply(channel, "- **Name:** Patrick Borrelli\n" +
					   "- **Website:** https://github.com/patrickborrelli");
			} else if(args[1].equals("time")) {
				SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                Date currentDate = new Date(System.currentTimeMillis());
                MessageResponse.sendReply(channel, "Current time: " + format.format(currentDate));
			} else {
				MessageResponse.sendReply(channel, "What the hell are you talking about?");
			}
		} else {
			MessageResponse.sendReply(channel, "Unknown argument provided.");
		}
	}
}
