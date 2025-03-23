package com.patrickborrelli.dndiscord.commands;

import java.awt.Color;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.embed.EmbedBuilder;

import com.patrickborrelli.dndiscord.exceptions.CommandProcessingException;
import com.patrickborrelli.dndiscord.messaging.MessageResponse;
import com.patrickborrelli.dndiscord.model.DiscordUser;
import com.patrickborrelli.dndiscord.model.dndiscord.CharacterClass;
import com.patrickborrelli.dndiscord.model.dndiscord.CharacterSheet;
import com.patrickborrelli.dndiscord.model.webservice.WebserviceManager;

/**
 * Command class provided to process all character sheet related
 * command requests incoming from the DnDiscord bot.
 * 
 * @author Patrick Borrelli
 */
public class SheetCommand implements CommandExecutor {
	private static final Logger LOGGER = LogManager.getLogger(SheetCommand.class);
	private static final String SPACE = " ";
	private static final String SEPARATOR = "/";
	private static final String LIST = "list";
	private String characterName = null;
	private CharacterSheet activeCharacter = null;
	
	WebserviceManager wsManager = WebserviceManager.getInstance();

	@Override
	public void onCommand(Message msg, DiscordUser user, long messageReceiptTime) throws CommandProcessingException {
		String[] args = msg.getContent().split(" ");
		TextChannel channel = msg.getChannel();
		
		if (args.length == 1) {
			if(LOGGER.isDebugEnabled()) {
				LOGGER.debug("Received request for current character: " + msg.getContent());
			}
			if(user.getActiveCharacter() != null) {
				activeCharacter = user.getActiveCharacter();
				characterName = activeCharacter.getCharacterName();	
				buildSheetEmbed(msg);
			} else {
				characterName = "No current character selected";
			}
		} else if(args.length == 2 && args[1].equalsIgnoreCase(LIST)) {
			MessageResponse.sendReply(channel, buildCharacterList(user));
		} else {
			LOGGER.error("Inappropriate arguments provided: ");
			MessageResponse.sendReply(channel, "Inappropriate arguments provided:");
		}
	}
	
	private void buildSheetEmbed(Message msg) {
		EmbedBuilder embed = new EmbedBuilder()
			.setTitle(characterName)
			.setDescription(buildDescription())
			.addInlineField("STR", Integer.toString(activeCharacter.getTotalStrength()))
			.addInlineField("DEX", Integer.toString(activeCharacter.getTotalDexterity()))
			.addInlineField("CON", Integer.toString(activeCharacter.getTotalConstitution()))
			.addInlineField("INT", Integer.toString(activeCharacter.getTotalIntelligence()))
			.addInlineField("WIS", Integer.toString(activeCharacter.getTotalWisdom()))
			.addInlineField("CHA", Integer.toString(activeCharacter.getTotalCharisma()))
		    .setColor(Color.GREEN)
		    .setFooter("©2020 AwareSoft, LLC", "https://cdn.discordapp.com/embed/avatars/1.png")
		    .setThumbnail(activeCharacter.getAvatarUrl());
		MessageResponse.sendEmbedMessage(msg.getChannel(), embed);		
	}
	
	/**
	 * The description of a character is a single string containing its species, class(es), and level(s).
	 * @return a String representation of the character
	 */
	private String buildDescription() {
		StringBuilder buff = new StringBuilder();
		List<CharacterClass> classes = activeCharacter.getCharacterClasses();
		int separators = classes.size() - 1;

		buff.append(activeCharacter.getRace()).append(SPACE);
		
		for(CharacterClass myClass : classes) {
			buff.append(myClass.getName()).append(SPACE).append(myClass.getLevel());
			if(separators > 0) {
				buff.append(SEPARATOR);
				separators--;
			}
		}
		
		return buff.toString();
	}
	
	/**
	 * Get the names of all characters the user has imported.
	 * @param user
	 * @return
	 */
	private String buildCharacterList(DiscordUser user) {
		StringBuilder buff = new StringBuilder();
		
		List<CharacterSheet> sheets = wsManager.getUserCharacters(user);
		for(CharacterSheet sheet : sheets) {
			buff.append(sheet.getCharacterName()).append(SPACE);
		}
		
		return buff.toString();
	}
}
