package com.patrickborrelli.dndiscord.commands;

import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageAttachment;
import org.javacord.api.entity.message.embed.EmbedBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.patrickborrelli.dndiscord.exceptions.CommandProcessingException;
import com.patrickborrelli.dndiscord.messaging.MessageResponse;
import com.patrickborrelli.dndiscord.model.DiscordUser;
import com.patrickborrelli.dndiscord.model.dndbeyond.DndBeyondSheet;
import com.patrickborrelli.dndiscord.utilities.CommandUtil;

/**
 * Command class provided to process all sheet import related
 * command requests incoming from the DnDiscord bot.
 * 
 * @author Patrick Borrelli
 */
public class ImportCommand implements CommandExecutor {
	private static final Logger LOGGER = LogManager.getLogger(ImportCommand.class);
	private List<MessageAttachment> attachments;

	@Override
	public void onCommand(Message msg, DiscordUser user) throws CommandProcessingException {
		TextChannel channel = msg.getChannel();
		String[] args = msg.getContent().split(" ");
		
		if(args.length != 2) {
			MessageResponse.sendReply(channel, "Inappropriate arguments provided: IMPORT BEYOND|JSON|ROLL20");
		} else if(args.length == 2) {
			String argument = args[1];
			if(argument.equalsIgnoreCase(CommandUtil.BEYOND)) {
				LOGGER.debug("Processing DnDBeyond Json import");
				InputStream stream = null;
				DndBeyondSheet sheet = null;
				//TODO: need to store currently loaded characters in a CharacterModel, along with indication of currently active character:
				DndBeyondSheet character = new DndBeyondSheet();
				attachments = msg.getAttachments();
				if(attachments.size() < 1) {
					LOGGER.debug("User attempted to import dndbeyond character without an attachment.");
					MessageResponse.sendReply(channel, "DndBeyond JSON must be attached.");
				} else {
					ObjectMapper mapper = new ObjectMapper();
					LOGGER.debug("Received Sheet Command message: " + msg.getContent() + " with " + attachments.size() + " attachments");
					
					for(MessageAttachment attach : attachments) {
						try {
							stream = attach.downloadAsInputStream();
							sheet = mapper.readValue(stream, DndBeyondSheet.class);
							character = sheet;				
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					LOGGER.debug("Retrieved the following character:");
					LOGGER.debug(character.toString());
					buildSheetEmbed(msg, character);
				}
			} 
		} else {
			MessageResponse.sendReply(channel, "Unknown argument provided.");
		}
		
	}
	
	private void buildSheetEmbed(Message msg, DndBeyondSheet sheet) {
		EmbedBuilder embed = new EmbedBuilder()
			.setTitle(sheet.getName())
			.setDescription("DnDiscord successfully imported character: " + sheet.getName())
		    .setColor(Color.GREEN)
		    .setFooter("©2020 AwareSoft, LLC", "https://cdn.discordapp.com/embed/avatars/1.png")
		    .setThumbnail(sheet.getAvatarUrl().toString());
		MessageResponse.sendEmbedMessage(msg.getChannel(), embed);		
	}
}
