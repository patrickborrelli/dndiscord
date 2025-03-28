package com.patrickborrelli.dndiscord.commands;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.embed.EmbedBuilder;

import com.patrickborrelli.dndiscord.exceptions.CommandProcessingException;
import com.patrickborrelli.dndiscord.messaging.MessageResponse;
import com.patrickborrelli.dndiscord.model.DiscordUser;
import com.patrickborrelli.dndiscord.model.dndiscord.CharacterBrief;
import com.patrickborrelli.dndiscord.model.dndiscord.CharacterClass;
import com.patrickborrelli.dndiscord.model.dndiscord.CharacterSheet;
import com.patrickborrelli.dndiscord.model.webservice.WebserviceManager;

import me.xdrop.fuzzywuzzy.FuzzySearch;
import me.xdrop.fuzzywuzzy.model.ExtractedResult;

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
	private static final String COMMA = ",";
	private static final String LIST = "list";
	private static final String SWITCH = "switch";
	
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
			if(user.getActiveCharacter() != null) {
				activeCharacter = user.getActiveCharacter();
			}
			buildListEmbed(msg, buildCharacterList(user));
		} else if(args.length > 2 && args[1].equalsIgnoreCase(SWITCH)) {
			String requestedChar = getCharacterNameArgs(args);
			
			List<CharacterBrief> characters = wsManager.getUserCharactersLazy(user);
			List<ExtractedResult> choice = (List<ExtractedResult>)FuzzySearch.extractTop(requestedChar, getCharacterNames(characters), 1);
			if(choice != null) {
				ExtractedResult result = choice.get(0);
				if(result.getScore() > 65) {
					//consider this a valid match and retrieve the character and set it as active:
					//if this is already the active character just reply with active
					//otherwise get the character to activate, set it in the user object and update the user
					if(result.getString().equalsIgnoreCase(user.getActiveCharacter().getCharacterName())) {
						//TODO: already done
					} else {
						CharacterSheet sheet = wsManager.getCharacter(getCharacterId(characters, result.getString()));
						user.setActiveCharacter(sheet);
						wsManager.updateUser(user);
						characterName = sheet.getCharacterName();
						activeCharacter = sheet;
					}
				}
				buildSheetEmbed(msg);
			} else {
				//TODO: research interactions with user and list all and ask to select
			}
		}		
		else {
			LOGGER.error("Inappropriate arguments provided: ");
			MessageResponse.sendReply(channel, "Inappropriate arguments provided:");
		}
	}
	
	private void buildListEmbed(Message msg, String characterList) {
		EmbedBuilder embed = new EmbedBuilder()
				.setTitle(msg.getAuthor().getDisplayName() + "'s Imported Characters")
				.setDescription(buildList(characterList))
				.setColor(Color.GREEN)
			    .setFooter("©2020 AwareSoft, LLC", "https://cdn.discordapp.com/embed/avatars/1.png")
			    .setThumbnail(activeCharacter.getAvatarUrl());
			MessageResponse.sendEmbedMessage(msg.getChannel(), embed);
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
	
	private String getCharacterId(List<CharacterBrief> characters, String selectedChar) {
		String charId = null;
		for(CharacterBrief brief : characters) {
			if(brief.getName().equalsIgnoreCase(selectedChar)) {
				charId = brief.getId();
			}
		}
		return charId;
	}
	
	private String getCharacterNameArgs(String[] args) {
		StringBuilder buff = new StringBuilder();
		for(int i = 2; i < args.length; i++) {
			buff.append(args[i]);
			if(i < args.length - 1) buff.append(SPACE);
		}		
		return buff.toString();
	}
	
	private Collection<String> getCharacterNames(List<CharacterBrief> characters) {
		Collection<String> result = new ArrayList<>();
		
		for(CharacterBrief brief : characters) {
			result.add(brief.toString());
		}
		return result;
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
	
	private String buildList(String charList) {
		StringBuilder buff = new StringBuilder();
		String result = "";
		charList = charList.replaceAll("\"", "");
		if(charList != null) {
			String [] characters = charList.split(COMMA);
			Arrays.sort(characters);
			
			for(String character : characters) {
				if(activeCharacter.getCharacterName() != null && character.equalsIgnoreCase(activeCharacter.getCharacterName())) {
					//make the active character bold:
					buff.append("**" + character + "**");
				} else {
					buff.append(character);
				}
				buff.append(COMMA).append(SPACE);
			}
			//remove final COMMA/SPACE combination:
			result = buff.substring(0,  buff.length() - 2);
		}	
		return result;
	}
	
	/**
	 * Get the names of all characters the user has imported.
	 * @param user
	 * @return
	 */
	private String buildCharacterList(DiscordUser user) {
		
		return wsManager.getUserCharacterNames(user);
	}
}
