package com.patrickborrelli.dndiscord.commands;

import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageAttachment;
import org.javacord.api.entity.message.embed.EmbedBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.patrickborrelli.dndiscord.exceptions.CommandProcessingException;
import com.patrickborrelli.dndiscord.messaging.MessageResponse;
import com.patrickborrelli.dndiscord.model.DiscordUser;
import com.patrickborrelli.dndiscord.model.dndbeyond.DndBeyondSheet;

/**
 * Command class provided to process all character sheet related
 * command requests incoming from the DnDiscord bot.
 * 
 * @author Patrick Borrelli
 */
public class SheetCommand implements CommandExecutor {
	private static final Logger LOGGER = LogManager.getLogger(SheetCommand.class);
	private List<MessageAttachment> attachments;

	@Override
	public void onCommand(Message msg, DiscordUser user) throws CommandProcessingException {
		InputStream stream = null;
		DndBeyondSheet sheet = null;
		//TODO: need to store currently loaded characters in a CharacterModel, along with indication of currently active character:
		List<DndBeyondSheet> characters = new ArrayList<>();
		attachments = msg.getAttachments();
		ObjectMapper mapper = new ObjectMapper();
		LOGGER.debug("Received Sheet Command message: " + msg.getContent() + " with " + attachments.size() + " attachments");
		
		for(MessageAttachment attach : attachments) {
			//for now, assume it is a json file representing a character.
			try {
				stream = attach.downloadAsInputStream();
				sheet = mapper.readValue(stream, DndBeyondSheet.class);
				characters.add(sheet);				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		LOGGER.debug("Retrieved the following characters:");
		for(DndBeyondSheet index : characters) {
			LOGGER.debug(index.toString());
			buildSheetEmbed(msg, index);
		}
	}
	
	private void buildSheetEmbed(Message msg, DndBeyondSheet sheet) {
		EmbedBuilder embed = new EmbedBuilder()
			.setTitle(sheet.getName())
			.setDescription("DnDiscord is a multifaceted D&D 5e utility bot designed to enable you and your party a seamless online D&D experience.")
		    .setColor(Color.GREEN)
		    .setFooter("©2020 AwareSoft, LLC", "https://cdn.discordapp.com/embed/avatars/1.png")
		    .setThumbnail(sheet.getAvatarUrl().toString());
		MessageResponse.sendEmbedMessage(msg.getChannel(), embed);		
	}
}
