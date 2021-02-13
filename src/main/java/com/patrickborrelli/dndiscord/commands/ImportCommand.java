package com.patrickborrelli.dndiscord.commands;

import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
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
import com.patrickborrelli.dndiscord.model.dndbeyond.DndBeyondConstants;
import com.patrickborrelli.dndiscord.model.dndbeyond.DndBeyondSheet;
import com.patrickborrelli.dndiscord.model.dndbeyond.Modifier;
import com.patrickborrelli.dndiscord.model.dndbeyond.Stat;
import com.patrickborrelli.dndiscord.model.dndiscord.CharacterSheet;
import com.patrickborrelli.dndiscord.model.dndiscord.CharacterClass;
import com.patrickborrelli.dndiscord.utilities.AlignmentType;
import com.patrickborrelli.dndiscord.utilities.CommandUtil;
import com.patrickborrelli.dndiscord.utilities.RulesetUtil;
import com.patrickborrelli.dndiscord.utilities.SheetSourceType;

/**
 * Command class provided to process all sheet import related
 * command requests incoming from the DnDiscord bot.
 * 
 * @author Patrick Borrelli
 */
public class ImportCommand implements CommandExecutor {
	private static final Logger LOGGER = LogManager.getLogger(ImportCommand.class);
	private List<MessageAttachment> attachments;
	private RulesetUtil ruleset = RulesetUtil.getInstance();

	@Override
	public void onCommand(Message msg, DiscordUser user, long messageReceiptTime) throws CommandProcessingException {
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
					//TODO: convert to DnDiscord character format and save to database
					CharacterSheet converted = convertFormat(SheetSourceType.BEYOND, character, user);
					buildSheetEmbed(msg, character);
					buildConvertEmbed(msg, converted);
				}
			} 
		} else {
			MessageResponse.sendReply(channel, "Unknown argument provided.");
		}
		
	}
	
	private CharacterSheet convertFormat(SheetSourceType type, DndBeyondSheet character, DiscordUser user) {
		CharacterSheet sheet = new CharacterSheet();
		
		if(type == SheetSourceType.BEYOND) {
			sheet.setSheetSource(type.getValue());
			sheet.setUser(user);
			sheet.setCharacterName(character.getName());
			sheet.setAvatarUrl(character.getAvatarUrl());
			sheet.setAge(character.getAge());
			sheet.setAlignment(AlignmentType.getEnum(character.getAlignmentId()).getStringValue());
			sheet.setBackground(character.getBackground().getDefinition().getName());
			sheet.setFaith(character.getFaith());
			sheet.setBonds(character.getTraits().getBonds());
			sheet.setPersonalityTraits(character.getTraits().getPersonalityTraits());
			sheet.setIdeals(character.getTraits().getIdeals());
			sheet.setFlaws(character.getTraits().getFlaws());
			sheet.setAppearance(character.getTraits().getAppearance());
			sheet.setHair(character.getHair());
			sheet.setSkin(character.getSkin());
			sheet.setHeight(character.getHeight());
			sheet.setWeight(character.getWeight());
			sheet.setInspiration(character.isInspiration());
			sheet.setGender(character.getGender());
			sheet.setExperiencePoints(character.getCurrentXp());
			sheet.setLifestyle(character.getLifestyle());
			sheet.setPlatinumPieces(character.getCurrencies().getPlatinumPieces());
			sheet.setGoldPieces(character.getCurrencies().getGoldPieces());
			sheet.setElectrumPieces(character.getCurrencies().getElectrumPieces());
			sheet.setSilverPieces(character.getCurrencies().getSilverPieces());
			sheet.setCopperPieces(character.getCurrencies().getCopperPieces());	
			setClasses(sheet, character);
			convertBeyondStats(sheet, character);
			processBeyondModifiers(sheet, character);	
			applyAbilityScoreMods(sheet);
			applySavingThrowMods(sheet);
		}
		LOGGER.debug("Converted character to: " + sheet.toString());
		return sheet;
	}
	
	private void applySavingThrowMods(CharacterSheet sheet) {
		int profBonus = ruleset.getProficiencyScore(sheet.getTotalLevel());
		sheet.setStrengthSave(sheet.getStrengthMod() + (sheet.isStrengthSaveProficiency() ? profBonus : 0));
		sheet.setDexteritySave(sheet.getDexterityMod() + (sheet.isDexteritySaveProficiency() ? profBonus : 0));
		sheet.setConstitutionSave(sheet.getConstitutionMod() + (sheet.isConstitutionSaveProficiency() ? profBonus : 0));
		sheet.setIntelligenceSave(sheet.getIntelligenceMod() + (sheet.isIntelligenceSaveProficiency() ? profBonus : 0));
		sheet.setWisdomSave(sheet.getWisdomMod() + (sheet.isWisdomSaveProficiency() ? profBonus : 0));
		sheet.setCharismaSave(sheet.getCharismaMod() + (sheet.isCharismaSaveProficiency() ? profBonus : 0));
	}
	
	private void setClasses(CharacterSheet sheet, DndBeyondSheet character) {
		List<com.patrickborrelli.dndiscord.model.dndbeyond.CharacterClass> beyondClasses =
				Arrays.asList(character.getClasses());
		List<CharacterClass> discordClasses = new ArrayList<>();
		CharacterClass thisClass = null;
		int totalLevel = 0;
		
		for(com.patrickborrelli.dndiscord.model.dndbeyond.CharacterClass beyondClass : beyondClasses) {
			thisClass = new CharacterClass();
			thisClass.setLevel(beyondClass.getLevel());
			thisClass.setName(beyondClass.getDefinition().getName());
			thisClass.setStartingClass(beyondClass.isStartingClass());
			discordClasses.add(thisClass);
			totalLevel += beyondClass.getLevel();
		}
		sheet.setCharacterClasses(discordClasses);
		sheet.setTotalLevel(totalLevel);
	}
	
	private void applyAbilityScoreMods(CharacterSheet sheet) {
		sheet.setStrengthMod(ruleset.getAbilityScoreMod(sheet.getTotalStrength()));
		sheet.setDexterityMod(ruleset.getAbilityScoreMod(sheet.getTotalDexterity()));
		sheet.setConstitutionMod(ruleset.getAbilityScoreMod(sheet.getTotalConstitution()));
		sheet.setWisdomMod(ruleset.getAbilityScoreMod(sheet.getTotalWisdom()));
		sheet.setIntelligenceMod(ruleset.getAbilityScoreMod(sheet.getTotalIntelligence()));
		sheet.setCharismaMod(ruleset.getAbilityScoreMod(sheet.getTotalCharisma()));
	}
	
	private void processBeyondModifiers(CharacterSheet sheet, DndBeyondSheet character) {
		
		List<Modifier> racialModifiers = Arrays.asList(character.getModifiers().getRace());
		List<Modifier> classModifiers = Arrays.asList(character.getModifiers().getClass_mod());
		List<Modifier> backgroundModifiers = Arrays.asList(character.getModifiers().getBackground());
		List<Modifier> itemModifiers = Arrays.asList(character.getModifiers().getItem());
		List<Modifier> featModifiers = Arrays.asList(character.getModifiers().getFeat());
		List<Modifier> conditionModifiers = Arrays.asList(character.getModifiers().getCondition());
		
		processBeyondModifierSet(racialModifiers, sheet, "Race");
		processBeyondModifierSet(classModifiers, sheet, "Class");
		processBeyondModifierSet(backgroundModifiers, sheet, "Background");
		processBeyondModifierSet(itemModifiers, sheet, "Item");
		processBeyondModifierSet(featModifiers, sheet, "Feat");
		processBeyondModifierSet(conditionModifiers, sheet, "Condition");				
	}
	
	private void processBeyondModifierSet(List<Modifier> mods, CharacterSheet sheet, String modifierType) {
		LOGGER.debug("Processing "+ modifierType + " modifiers.");
		for(Modifier mod : mods) {
			LOGGER.debug("Modifier: " + mod.toString());
			if(mod.getType().equalsIgnoreCase(DndBeyondConstants.BONUS)) {
				switch(mod.getSubType()) {
					case DndBeyondConstants.STRENGTH_SCORE:
						sheet.setStrengthBonus(sheet.getStrengthBonus() + mod.getValue());
						break;

					case DndBeyondConstants.DEXTERITY_SCORE:
						sheet.setDexterityBonus(sheet.getDexterityBonus() + mod.getValue());
						break;	
						
					case DndBeyondConstants.CONSTITUTION_SCORE:
						sheet.setConstitutionBonus(sheet.getConstitutionBonus() + mod.getValue());
						break;
						
					case DndBeyondConstants.WISDOM_SCORE:
						sheet.setWisdomBonus(sheet.getWisdomBonus() + mod.getValue());
						break;
						
					case DndBeyondConstants.INTELLIGENCE_SCORE:
						sheet.setIntelligenceBonus(sheet.getIntelligenceBonus() + mod.getValue());
						break;
						
					case DndBeyondConstants.CHARISMA_SCORE:
						sheet.setCharismaBonus(sheet.getCharismaBonus() + mod.getValue());
						break;
						
					default:
						LOGGER.info("Received sub type I am not currently handling: " + mod.getSubType());													
				}
			} else if(mod.getType().equalsIgnoreCase(DndBeyondConstants.SET)) {
				switch(mod.getSubType()) {
					case DndBeyondConstants.STRENGTH_SCORE:
						sheet.setTotalStrength(mod.getValue());
						break;
	
					case DndBeyondConstants.DEXTERITY_SCORE:
						sheet.setTotalDexterity(mod.getValue());
						break;	
						
					case DndBeyondConstants.CONSTITUTION_SCORE:
						sheet.setTotalConstitution(mod.getValue());
						break;
						
					case DndBeyondConstants.WISDOM_SCORE:
						sheet.setTotalWisdom(mod.getValue());
						break;
						
					case DndBeyondConstants.INTELLIGENCE_SCORE:
						sheet.setTotalIntelligence(mod.getValue());
						break;
						
					case DndBeyondConstants.CHARISMA_SCORE:
						sheet.setTotalCharisma(mod.getValue());
						break;
						
					default:
						LOGGER.info("Received sub type I am not currently handling: " + mod.getSubType());	
				}
			} else if(mod.getType().equalsIgnoreCase(DndBeyondConstants.PROFICIENCY)) {
				switch(mod.getSubType()) {
					case DndBeyondConstants.STRENGTH_SAVE:
						sheet.setStrengthSaveProficiency(true);
						break;
	
					case DndBeyondConstants.DEXTERITY_SAVE:
						sheet.setDexteritySaveProficiency(true);
						break;	
						
					case DndBeyondConstants.CONSTITUTION_SAVE:
						sheet.setConstitutionSaveProficiency(true);
						break;
						
					case DndBeyondConstants.INTELLIGENCE_SAVE:
						sheet.setIntelligenceSaveProficiency(true);
						break;
						
					case DndBeyondConstants.WISDOM_SAVE:
						sheet.setWisdomSaveProficiency(true);
						break;
						
					case DndBeyondConstants.CHARISMA_SAVE:
						sheet.setCharismaSaveProficiency(true);
						break;
						
					default:
						LOGGER.info("Received sub type I am not currently handling: " + mod.getSubType());	
				}
			}
		}
	}
	
	private void convertBeyondStats(CharacterSheet sheet, DndBeyondSheet character) {
		Stat[] stats = character.getStats();
		for(int i = 0; i < stats.length; i++) {
			int value = stats[i].getValue();
			switch(stats[i].getId()) {
				case 1:
					sheet.setBaseStrength(value);
					break;
				case 2:
					sheet.setBaseDexterity(value);
					break;
				case 3:
					sheet.setBaseConstitution(value);
					break;
				case 4:
					sheet.setBaseIntelligence(value);
					break;
				case 5:
					sheet.setBaseWisdom(value);
					break;
				case 6:
					sheet.setBaseCharisma(value);
					break;
				default:
					LOGGER.error("Unidentified stat id discovered during conversion of DNDBeyond sheet: " + value);			
			}
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
	
	private void buildConvertEmbed(Message msg, CharacterSheet sheet) {
		EmbedBuilder embed = new EmbedBuilder()
			.setTitle(sheet.getCharacterName())
			.setDescription("DnDiscord successfully converted character: " + sheet.getCharacterName() + " for user: " + sheet.getUser().getUsername())
		    .setColor(Color.GREEN)
		    .setFooter("©2020 AwareSoft, LLC", "https://cdn.discordapp.com/embed/avatars/1.png")
		    .setThumbnail(sheet.getAvatarUrl().toString());
		MessageResponse.sendEmbedMessage(msg.getChannel(), embed);		
	}
}
