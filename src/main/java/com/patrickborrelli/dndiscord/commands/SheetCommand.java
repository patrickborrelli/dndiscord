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

/**
 * Command class provided to process all character sheet related
 * command requests incoming from the DnDiscord bot.
 * 
 * @author Patrick Borrelli
 */
public class SheetCommand implements CommandExecutor {
	private static final Logger LOGGER = LogManager.getLogger(SheetCommand.class);
	private String characterName = null;

	@Override
	public void onCommand(Message msg, DiscordUser user, long messageReceiptTime) throws CommandProcessingException {
		String[] args = msg.getContent().split(" ");
		TextChannel channel = msg.getChannel();
		
		if (args.length == 1) {
			LOGGER.debug("Received request for current character: " + msg.getContent());
			if(user.getActiveCharacter() != null) {
				characterName = user.getActiveCharacter().getCharacterName();				
			} else {
				characterName = "No current character selected";
			}
		} else {
			LOGGER.error("Inappropriate arguments provided: ");
			MessageResponse.sendReply(channel, "Inappropriate arguments provided:");
		}
		buildSheetEmbed(msg);
	}
	
	private void buildSheetEmbed(Message msg) {
		EmbedBuilder embed = new EmbedBuilder()
			.setTitle(characterName)
			.setDescription(characterName)
		    .setColor(Color.GREEN)
		    .setFooter("©2020 AwareSoft, LLC", "https://cdn.discordapp.com/embed/avatars/1.png");
		MessageResponse.sendEmbedMessage(msg.getChannel(), embed);		
	}
}
