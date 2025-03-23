 package com.patrickborrelli.dndiscord.commands;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.embed.EmbedBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.patrickborrelli.dndiscord.exceptions.CommandProcessingException;
import com.patrickborrelli.dndiscord.messaging.MessageResponse;
import com.patrickborrelli.dndiscord.model.DiscordUser;
import com.patrickborrelli.dndiscord.model.converters.SheetConverter;
import com.patrickborrelli.dndiscord.model.dndbeyond.DndBeyondSheet;
import com.patrickborrelli.dndiscord.model.dndiscord.CharacterSheet;
import com.patrickborrelli.dndiscord.model.type.SheetSourceType;
import com.patrickborrelli.dndiscord.model.webservice.WebserviceManager;
import com.patrickborrelli.dndiscord.utilities.CommandUtil;
import com.patrickborrelli.dndiscord.utilities.ConfigurationUtil;

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
		DndBeyondSheet response = null;
		ObjectMapper mapper = new ObjectMapper();

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

			HttpURLConnection connection = null;

			try {
				URL url = new URL(urlStringBuffer.toString());
				connection = (HttpURLConnection) url.openConnection();
				connection.setRequestProperty("User-Agent", ConfigurationUtil.HTTP_USER_AGENT);
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

				String inputLine;
				StringBuffer content = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					content.append(inputLine);
					if(LOGGER.isDebugEnabled()) 
						LOGGER.debug("READ LINE: {}", inputLine);
				}
				in.close();

				response = mapper.readValue(content.toString(), DndBeyondSheet.class);

				CharacterSheet converted = CONVERTER.convertFormat(SheetSourceType.BEYOND, response);
				user.addCharacter(converted);
				WSMANAGER.addUserCharacter(user, converted);
				buildSheetEmbed(msg, converted);
			} catch (Exception e) {
				LOGGER.error("We broke something: {}", e);
			} finally {
				connection.disconnect();
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
