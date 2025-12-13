package com.patrickborrelli.dndiscord.commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;

import com.patrickborrelli.dndiscord.exceptions.CommandProcessingException;
import com.patrickborrelli.dndiscord.messaging.MessageResponse;
import com.patrickborrelli.dndiscord.model.DiscordUser;
import com.patrickborrelli.dndiscord.model.dndiscord.ArchiveMessage;

/**
 * Command class provided to process all channel archive requests
 * incoming from the DnDiscord bot.
 * 
 * @author Patrick Borrelli
 */
public class ArchiveCommand implements CommandExecutor {
	
	private static final Logger LOGGER = LogManager.getLogger(ImportCommand.class);	

	@Override
	public void onCommand(Message msg, DiscordUser user, long messageReceiptTime) throws CommandProcessingException {

		List<Message> messagesInChannel = new ArrayList<>();
		TextChannel channel = msg.getChannel();
		String[] args = msg.getContent().split(" ");
		
		if (args.length != 2) {
			LOGGER.warn("Inappropriate arguments provided to archive command: {}", msg.getContent());
			MessageResponse.sendReply(channel, "Inappropriate arguments provided: ARCHIVE <<writeFileName>>");
		} else if (args.length == 2) {
			messagesInChannel = channel.getMessagesAsStream().collect(Collectors.toList());
			File output = new File(args[1]);
			
			List<ArchiveMessage> messages = getMessages(messagesInChannel);			
			
			PrintWriter writer;
			try {
				writer = new PrintWriter(output);
				    
				for(ArchiveMessage mess : messages) {
					writer.println(mess.toString());
				}				
				
				writer.close();
			} catch (FileNotFoundException e) { 
				e.printStackTrace();
			}			
		}
	}

	private List<ArchiveMessage> getMessages(List<Message> messagesInChannel) {
		List<ArchiveMessage> result = new ArrayList<>();
		ArchiveMessage messageObject = null;
		
		for(Message message : messagesInChannel) {
			messageObject = new ArchiveMessage();
			messageObject.setCreateTimestamp(message.getCreationTimestamp());
			messageObject.setBot(message.getAuthor().isBotUser());
			messageObject.setContent(message.getContent());
			messageObject.setUserDisplayName(message.getAuthor().getDisplayName());
			messageObject.setEmbeds(message.getEmbeds());
			result.add(messageObject);
		}
		
		Collections.sort(result);
		
		return result;
	}
}
