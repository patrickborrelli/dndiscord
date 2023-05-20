package com.patrickborrelli.dndiscord.commands;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;

import com.patrickborrelli.dndiscord.DNDiscordMain;
import com.patrickborrelli.dndiscord.exceptions.CommandProcessingException;
import com.patrickborrelli.dndiscord.messaging.MessageResponse;
import com.patrickborrelli.dndiscord.model.DiscordUser;
import com.patrickborrelli.dndiscord.utilities.CommandUtil;

/**
 * Command class to handle all types of ping commands
 * issued from Discord to the DnDiscord bot.
 * 
 * @author Patrick Borrelli
 */
public class PingCommand implements CommandExecutor {
	
	private static final Logger LOGGER = LogManager.getLogger(PingCommand.class);
	private static final String PATTERN_FORMAT = "MM-dd-yyyy hh:mm:ss O";

	@Override
	public void onCommand(Message msg, DiscordUser user, long messageReceiptTime) throws CommandProcessingException {
		TextChannel channel = msg.getChannel();
		String[] args = msg.getContent().split(" ");
		
		if(args.length > 2) {
			LOGGER.warn("Too many arguments provided to Ping command: " + msg.getContent());
			MessageResponse.sendReply(channel, "Too many arguments provided to Ping command:  " + msg.getContent());
			new HelpCommand().onCommand(msg, CommandUtil.PING, user, messageReceiptTime);
		} else if(args.length == 1) {
			long currentTime = System.currentTimeMillis();			
			MessageResponse.sendReply(channel, "Message processing time: " + (currentTime - messageReceiptTime) + " milliseconds.");
		} else if(args.length == 2) {
			if(args[1].equals("author")) {
				MessageResponse.sendReply(channel, "- **Name:** Patrick Borrelli\n" +
					   "- **Website:** https://github.com/patrickborrelli");
			} else if(args[1].equals("time")) {
				Instant now = Instant.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN_FORMAT)
			            .withZone(ZoneId.systemDefault());
                MessageResponse.sendReply(channel, "Current time: " + formatter.format(now));
			} else {
				LOGGER.warn("Unknown argument provided to Ping command: " + msg.getContent());
				MessageResponse.sendReply(channel, "Unknown argument provided to Ping command:  " + msg.getContent());
				new HelpCommand().onCommand(msg, CommandUtil.PING, user, messageReceiptTime);
			}
		} else {
			LOGGER.warn("Unknown argument provided to Ping command: " + msg.getContent());
			MessageResponse.sendReply(channel, "Unknown argument provided to Ping command:  " + msg.getContent());
			new HelpCommand().onCommand(msg, CommandUtil.PING, user, messageReceiptTime);
		}
	}
}
