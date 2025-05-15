 package com.patrickborrelli.dndiscord.commands;

import java.awt.Color;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.embed.EmbedBuilder;

import com.patrickborrelli.dndiscord.exceptions.CommandProcessingException;
import com.patrickborrelli.dndiscord.messaging.MessageResponse;
import com.patrickborrelli.dndiscord.model.DiscordUser;
import com.patrickborrelli.dndiscord.model.converters.SheetConverter;
import com.patrickborrelli.dndiscord.model.dndbeyond.DndBeyondSheet;
import com.patrickborrelli.dndiscord.model.dndiscord.CharacterSheet;
import com.patrickborrelli.dndiscord.model.type.SheetSourceType;
import com.patrickborrelli.dndiscord.model.webservice.WebserviceManager;
import com.patrickborrelli.dndiscord.utilities.CommandUtil;

/**
 * Command class provided to process all sheet import related command requests
 * incoming from the DnDiscord bot.
 * 
 * @author Patrick Borrelli
 */
public class ImportCommand implements CommandExecutor {
	private static final Logger LOGGER = LogManager.getLogger(ImportCommand.class);
	
	private static final WebserviceManager WSMANAGER = WebserviceManager.getInstance();
	private static final SheetConverter CONVERTER = SheetConverter.getInstance();

	@Override
	public void onCommand(Message msg, DiscordUser user, long messageReceiptTime) throws CommandProcessingException {

		TextChannel channel = msg.getChannel();
		CharacterSheet converted = null;

		String[] args = msg.getContent().split(" ");
		StringBuilder urlStringBuffer = new StringBuilder()
				.append("https://dndbeyond.com/character/");
		String terminator = "/";

		if (args.length != 3) {
			LOGGER.warn("Inappropriate arguments provided to import command: {}", msg.getContent());
			MessageResponse.sendReply(channel, "Inappropriate arguments provided: IMPORT BEYOND <<characterIDnumber>>");
			new HelpCommand().onCommand(msg, CommandUtil.IMPORT, user, messageReceiptTime);
		} else if (args.length == 3) {
			urlStringBuffer.append(extractCharacterId(args[2]));
			urlStringBuffer.append(terminator).append("json");

			//retrieve and convert character sheet from DnDBeyond:
			DndBeyondSheet response = WSMANAGER.importDndBeyondSheet(urlStringBuffer.toString());			
			
			if(response != null) {
				converted = CONVERTER.convertFormat(SheetSourceType.BEYOND, response);
				WSMANAGER.addUserCharacter(user, converted);
				buildSheetEmbed(msg, converted);	
				WSMANAGER.setActiveCharacter(user.getId(), converted.getId());
			} else {
				//handle case where no sheet is returned:
				LOGGER.warn("Unable to retrieve character: {}", msg.getContent());
				MessageResponse.sendReply(channel, "Unable to retrieve character: {" + msg.getContent() + "}");
			}
		}
	}

	private String extractCharacterId(String string) {
		StringBuffer buf = new StringBuffer();		
		String[] substrings = string.split("/");
	
		if(substrings.length > 1) { 
			buf.append(substrings[2]);
		} else
			buf.append(substrings[0]);
		return buf.toString();
	}
	
	private void buildSheetEmbed(Message msg, CharacterSheet sheet) {
		EmbedBuilder embed = new EmbedBuilder().setTitle(sheet.getCharacterName())
				.setDescription("DnDiscord successfully imported character: " + sheet.getCharacterName())
				.setColor(Color.GREEN)
				.setFooter("©2020 AwareSoft, LLC", "https://cdn.discordapp.com/embed/avatars/1.png")
				.setThumbnail(sheet.getAvatarUrl());
		MessageResponse.sendEmbedMessage(msg.getChannel(), embed);
	}
}
