package com.patrickborrelli.dndiscord.commands;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.component.ActionRow;
import org.javacord.api.entity.message.component.SelectMenu;
import org.javacord.api.entity.message.component.SelectMenuOption;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.interaction.SelectMenuInteraction;

import com.patrickborrelli.dndiscord.exceptions.CommandProcessingException;
import com.patrickborrelli.dndiscord.messaging.MessageResponse;
import com.patrickborrelli.dndiscord.model.DiscordUser;
import com.patrickborrelli.dndiscord.model.dndiscord.CharacterBrief;
import com.patrickborrelli.dndiscord.model.dndiscord.CharacterClass;
import com.patrickborrelli.dndiscord.model.dndiscord.CharacterSheet;
import com.patrickborrelli.dndiscord.model.webservice.WebserviceManager;
import com.patrickborrelli.dndiscord.utilities.AppUtil;

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
	private static final String REMOVE = "remove";
	
	private String characterName = null;
	private CharacterSheet activeCharacter = null;
	
	WebserviceManager wsManager = WebserviceManager.getInstance();
	DiscordApi api = AppUtil.getInstance().getApi();

	@Override
	public void onCommand(Message msg, DiscordUser user, long messageReceiptTime) throws CommandProcessingException {
		String[] args = msg.getContent().split(" ");
		TextChannel channel = msg.getChannel();
		boolean activeCharExists = user.getActiveCharacter() != null;
		
		if (args.length == 1) {
			if(LOGGER.isDebugEnabled()) {
				LOGGER.debug("Received request for current character: " + msg.getContent());
			}
			if(activeCharExists) {
				activeCharacter = user.getActiveCharacter();
				characterName = activeCharacter.getCharacterName();	
				buildSheetEmbed(msg);
			} else {
				characterName = "No current character selected";
			}
		} else if(args.length == 2 && args[1].equalsIgnoreCase(LIST)) {
			if(activeCharExists) {
				activeCharacter = user.getActiveCharacter();
			}
			buildListEmbed(msg, buildCharacterList(user), activeCharExists);
		} else if(args.length > 2 && args[1].equalsIgnoreCase(SWITCH)) {
			String requestedChar = getCharacterNameArgs(args);
			handleCleanSwitch(msg, requestedChar, user, activeCharExists);
		} else if(args.length >= 2 && args[1].equalsIgnoreCase(REMOVE)) {
			//determine if there is a provided character name, if not, remove the active character:
			if(args.length == 2) {
				CharacterSheet toBeRemoved = activeCharacter;
				user = wsManager.removeUserCharacter(user, activeCharacter);
				//set active character to null
				user.setActiveCharacter(null);
				buildRemoveEmbed(msg, toBeRemoved);
			} else {
				//character name provided, so remove that character:
				String requestedChar = getCharacterNameArgs(args);
			}
		}
		else {
			LOGGER.error("Inappropriate arguments provided: ");
			MessageResponse.sendReply(channel, "Inappropriate arguments provided:");
		}
	}
	
	private void buildListEmbed(Message msg, String characterList, boolean activeCharExists) {
		String thumbnailUrl = null;
		if(activeCharExists) {
			thumbnailUrl = activeCharacter.getAvatarUrl();
		} else {
			thumbnailUrl = "https://cdn.discordapp.com/embed/avatars/1.png";
		}
		EmbedBuilder embed = new EmbedBuilder()
				.setTitle(msg.getAuthor().getDisplayName() + "'s Imported Characters")
				.setDescription(buildList(characterList))
				.setColor(Color.GREEN)
			    .setFooter("©2020 AwareSoft, LLC", "https://cdn.discordapp.com/embed/avatars/1.png")
			    .setThumbnail(thumbnailUrl);
			MessageResponse.sendEmbedMessage(msg.getChannel(), embed);
	}
	
	private void buildRemoveEmbed(Message msg, CharacterSheet removedChar) {
		EmbedBuilder embed = new EmbedBuilder()
				.setTitle("Removed Character")
				.setDescription("Successfully removed " + removedChar.getCharacterName())
				.setColor(Color.GREEN)
			    .setFooter("©2020 AwareSoft, LLC", "https://cdn.discordapp.com/embed/avatars/1.png")
			    .setThumbnail("https://cdn.discordapp.com/embed/avatars/1.png");
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
	
	private void sendCharacterQuery(Message msg, List<String> characters, DiscordUser user) {
		List<SelectMenuOption> options = new ArrayList<>();
		for(String character : characters) {
			options.add(SelectMenuOption.create(character, "You selected " + character + "!", ""));
		}
		api.addMessageComponentCreateListener(event -> {			
			event.getInteraction().respondLater().thenAccept(originalInteraction -> {
				Optional<SelectMenuInteraction> opt = event.getMessageComponentInteraction().asSelectMenuInteraction();
							
				if(opt.isPresent()) {
					SelectMenuInteraction interaction = opt.get();
					String chosen = interaction.getChosenOptions().get(0).getLabel();				
					originalInteraction.setContent("Loading character: " + chosen).update();
					
					try {
						handleCleanSwitch(msg, chosen, user, user.getActiveCharacter() != null);
					} catch (Exception e) {
						
					}
								
				}
			});			
		});
		
		new MessageBuilder()
	    .setContent("Which character did you mean?")
	    .addComponents(
	        ActionRow.of(SelectMenu.createStringMenu("chosen",  "Click to show the list", 1, 1, options)))
	    .send(msg.getChannel());		
	}
	
	private void sendCharacterRemoveQuery(Message msg, List<String> characters, DiscordUser user) {
		List<SelectMenuOption> options = new ArrayList<>();
		for(String character : characters) {
			options.add(SelectMenuOption.create(character, "You selected " + character + "!", ""));
		}
		api.addMessageComponentCreateListener(event -> {			
			event.getInteraction().respondLater().thenAccept(originalInteraction -> {
				Optional<SelectMenuInteraction> opt = event.getMessageComponentInteraction().asSelectMenuInteraction();
							
				if(opt.isPresent()) {
					SelectMenuInteraction interaction = opt.get();
					String chosen = interaction.getChosenOptions().get(0).getLabel();				
					originalInteraction.setContent("Loading character: " + chosen).update();
					
					try {
						getCharacterIdByNameFuzzy(msg, chosen, user);
					} catch (Exception e) {
						
					}
								
				}
			});			
		});
		
		new MessageBuilder()
	    .setContent("Which character did you mean?")
	    .addComponents(
	        ActionRow.of(SelectMenu.createStringMenu("chosen",  "Click to show the list", 1, 1, options)))
	    .send(msg.getChannel());		
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
	
	private List<String> getCharacterNames(List<CharacterBrief> characters) {
		List<String> result = new ArrayList<>();
		
		for(CharacterBrief brief : characters) {
			result.add(brief.toString());
		}
		return result;
	}
	
	private void handleCleanSwitch(Message msg, String chosen, DiscordUser user, boolean activeCharExists) throws CommandProcessingException {
		List<CharacterBrief> characters = wsManager.getUserCharactersLazy(user);
		List<ExtractedResult> choice = (List<ExtractedResult>)FuzzySearch.extractTop(chosen, getCharacterNames(characters), 1);
		if(choice != null) {
			ExtractedResult result = choice.get(0);
			
			if(result.getScore() > 65) {				
				if(activeCharExists && result.getString().equalsIgnoreCase(user.getActiveCharacter().getCharacterName())) {
					//nothing to do here:
					characterName = user.getActiveCharacter().getCharacterName();
					activeCharacter = user.getActiveCharacter();
				} else {
					CharacterSheet sheet = wsManager.getCharacter(getCharacterId(characters, result.getString()));
					user.setActiveCharacter(sheet);
					wsManager.updateUser(user);
					characterName = sheet.getCharacterName();
					activeCharacter = sheet;
				}
				
				buildSheetEmbed(msg);
			} else {
				//which character did you mean?
				sendCharacterQuery(msg, getCharacterNames(characters), user);
			}
			
		} else {
			sendCharacterQuery(msg, getCharacterNames(characters), user);
		}
	}
	
	private String getCharacterIdByNameFuzzy(Message msg, String chosen, DiscordUser user) throws CommandProcessingException {
		
		StringBuilder buffer = new StringBuilder();
		List<CharacterBrief> characters = wsManager.getUserCharactersLazy(user);
		List<ExtractedResult> choice = (List<ExtractedResult>)FuzzySearch.extractTop(chosen, getCharacterNames(characters), 1);
		
		if(choice != null) {
			ExtractedResult result = choice.get(0);
			
			if(result.getScore() > 65) {				
				buffer.append(getCharacterId(characters, result.getString()));
			} else {
				buffer.append("");
				sendCharacterRemoveQuery(msg, getCharacterNames(characters), user);
			}
			
		} else {
			buffer.append("");
			sendCharacterRemoveQuery(msg, getCharacterNames(characters), user);
		}
		return buffer.toString();
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
		boolean activeCharExists = activeCharacter != null;
		
		charList = charList.replaceAll("\"", "");
		if(charList != null) {
			String [] characters = charList.split(COMMA);
			Arrays.sort(characters);
			
			for(String character : characters) {
				if(activeCharExists &&
						activeCharacter.getCharacterName() != null && 
						character.equalsIgnoreCase(activeCharacter.getCharacterName())) {
					//make the active character bold:
					buff.append("**" + character + "**");
				} else {
					buff.append(character);
				}
				buff.append(COMMA).append(SPACE);
			}
			//remove final COMMA/SPACE combination:
			result = buff.substring(0,  buff.length() - 2);
			
			if(!activeCharExists) {
				result += " ** No active character selected **";
			}
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
