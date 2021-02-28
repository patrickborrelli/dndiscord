package com.patrickborrelli.dndiscord.commands;

import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import com.patrickborrelli.dndiscord.model.dndbeyond.Activation;
import com.patrickborrelli.dndiscord.model.dndbeyond.Background;
import com.patrickborrelli.dndiscord.model.dndbeyond.ClassFeature;
import com.patrickborrelli.dndiscord.model.dndbeyond.DndBeyondCharacterClass;
import com.patrickborrelli.dndiscord.model.dndbeyond.DndBeyondConstants;
import com.patrickborrelli.dndiscord.model.dndbeyond.DndBeyondSheet;
import com.patrickborrelli.dndiscord.model.dndbeyond.Feat;
import com.patrickborrelli.dndiscord.model.dndbeyond.ItemDefinition;
import com.patrickborrelli.dndiscord.model.dndbeyond.ItemProperty;
import com.patrickborrelli.dndiscord.model.dndbeyond.LimitedUse;
import com.patrickborrelli.dndiscord.model.dndbeyond.Modifier;
import com.patrickborrelli.dndiscord.model.dndbeyond.Option;
import com.patrickborrelli.dndiscord.model.dndbeyond.Options;
import com.patrickborrelli.dndiscord.model.dndbeyond.RacialTrait;
import com.patrickborrelli.dndiscord.model.dndbeyond.Stat;
import com.patrickborrelli.dndiscord.model.dndiscord.CharacterSheet;
import com.patrickborrelli.dndiscord.model.dndiscord.Feature;
import com.patrickborrelli.dndiscord.model.dndiscord.Item;
import com.patrickborrelli.dndiscord.model.dndiscord.Action;
import com.patrickborrelli.dndiscord.model.dndiscord.CharacterClass;
import com.patrickborrelli.dndiscord.utilities.ActionType;
import com.patrickborrelli.dndiscord.utilities.ActivationType;
import com.patrickborrelli.dndiscord.utilities.AlignmentType;
import com.patrickborrelli.dndiscord.utilities.ArmorType;
import com.patrickborrelli.dndiscord.utilities.AttackSubtype;
import com.patrickborrelli.dndiscord.utilities.CommandUtil;
import com.patrickborrelli.dndiscord.utilities.DamageType;
import com.patrickborrelli.dndiscord.utilities.FeatureType;
import com.patrickborrelli.dndiscord.utilities.FilterType;
import com.patrickborrelli.dndiscord.utilities.LifestyleType;
import com.patrickborrelli.dndiscord.utilities.ResetType;
import com.patrickborrelli.dndiscord.utilities.RulesetUtil;
import com.patrickborrelli.dndiscord.utilities.SheetSourceType;
import com.patrickborrelli.dndiscord.utilities.StatType;
import com.patrickborrelli.dndiscord.utilities.WeaponPropertyType;

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
	private Set<Feature> features = null;

	@Override
	public void onCommand(Message msg, DiscordUser user, long messageReceiptTime) throws CommandProcessingException {
		features = new HashSet<>();
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
			AlignmentType align = AlignmentType.getEnum(character.getAlignmentId());
			LifestyleType life = LifestyleType.getEnum(character.getLifestyleId());
			if(align != null) sheet.setAlignment(align.getStringValue());
			if(life != null) sheet.setLifestyle(life.getStringValue());
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
			sheet.setPlatinumPieces(character.getCurrencies().getPlatinumPieces());
			sheet.setGoldPieces(character.getCurrencies().getGoldPieces());
			sheet.setElectrumPieces(character.getCurrencies().getElectrumPieces());
			sheet.setSilverPieces(character.getCurrencies().getSilverPieces());
			sheet.setCopperPieces(character.getCurrencies().getCopperPieces());	
			sheet.setRace(character.getRace().getFullName());
			sheet.setBaseRace(character.getRace().getBaseName());
			sheet.setSize(character.getRace().getSize());
			sheet.setWalkSpeed(character.getRace().getWeightSpeeds().getNormal().getWalk());
			sheet.setFlySpeed(character.getRace().getWeightSpeeds().getNormal().getFly());
			sheet.setBurrowSpeed(character.getRace().getWeightSpeeds().getNormal().getBurrow());
			sheet.setSwimSpeed(character.getRace().getWeightSpeeds().getNormal().getSwim());
			sheet.setClimbSpeed(character.getRace().getWeightSpeeds().getNormal().getClimb()); 
			setClasses(sheet, character);
			convertBeyondStats(sheet, character);
			processBeyondModifiers(sheet, character);	
			processInventory(sheet, character);
			sheet.setMaxHitPoints(character.getBaseHitPoints() + (sheet.getTotalLevel() * sheet.getConstitutionMod()));
			sheet.setCurrentHitPoints(sheet.getMaxHitPoints() - character.getRemovedHitPoints());
			sheet.setTemporaryHitPoints(character.getTemporaryHitPoints());	
			sheet.setFeatures(features);
			sheet.setActions(generateActions(sheet, character));
			//TODO: convert any inventory items to actions as necessary
			//TODO: on any import, convert any strings to strip out any HTML formatting, extra spaces, etc
			
			applyAbilityScoreMods(sheet);
			applySavingThrowMods(sheet);
			applySkillMods(sheet);
		}
		LOGGER.debug("Converted character to: " + sheet.toString());
		return sheet;
	}
	
	private Set<Action> generateActions(CharacterSheet sheet, DndBeyondSheet character) {
		Set<Action> actions = new HashSet<>();
		
		//retrieve dndBeyond sheet Action data:
		Options<com.patrickborrelli.dndiscord.model.dndbeyond.Action> importActions = character.getActions();
		List<com.patrickborrelli.dndiscord.model.dndbeyond.Action> racialImports = importActions.getRace();
		List<com.patrickborrelli.dndiscord.model.dndbeyond.Action> classImports = importActions.getClassOptions();
		List<com.patrickborrelli.dndiscord.model.dndbeyond.Action> featImports = importActions.getFeat();
		
		//iterate through:
		for(com.patrickborrelli.dndiscord.model.dndbeyond.Action raceIn : racialImports) {
			actions.add(convertAction(raceIn, FeatureType.RACE));
		}	
		
		for(com.patrickborrelli.dndiscord.model.dndbeyond.Action classIn : classImports) {
			actions.add(convertAction(classIn, FeatureType.CLASS_FEATURE));
		}
		
		for(com.patrickborrelli.dndiscord.model.dndbeyond.Action featIn : featImports) {
			actions.add(convertAction(featIn, FeatureType.FEAT));
		}
		
		//next create actions from inventory items that are displayed as attacks:
		for(Item item : sheet.getInventory()) {
			Action attackAction = null;
			if(item.isAttack()) {
				attackAction = convertItemToAction(RulesetUtil.NOT_VERSATILE, item);
				actions.add(attackAction);
			}
			if(item.getProperties() != null && item.getProperties().contains(WeaponPropertyType.VERSATILE)) {
				actions.add(convertItemToAction(RulesetUtil.VERSATILE, item));
			}
		}		
		return actions;
	}
	
	private Action convertItemToAction(String attackType, Item item) {
		Action action = new Action();
		if(attackType == RulesetUtil.NOT_VERSATILE) {
			action.setName(item.getName());
			action.setDieCount(item.getDieCount());
			action.setDieValue(item.getDieValue());
			action.setDiceMultiplier(item.getDieMultiplier());
			action.setFixedValue(item.getFixedDamage());
			action.setDiceString(item.getDiceString());
		} else if(attackType == RulesetUtil.VERSATILE) {
			action.setName(item.getName() + " - two-handed");
			action.setDieCount(item.getVersatileDieCount());
			action.setDieValue(item.getVersatileDieValue());
			action.setDiceMultiplier(item.getVersatileDieMultiplier());
			action.setFixedValue(item.getVersatileFixedDamage());
			action.setDiceString(item.getVersatileDiceString());
		}		
		action.setDescription(item.getDescription());
		action.setSnippet(item.getSnippet());
		action.setType(FeatureType.ITEM);		
		action.setDamageType(item.getDamageType());
		action.setMartialArt(item.isMonkWeapon());
		
		return action;
	}
	
	private Action convertAction(com.patrickborrelli.dndiscord.model.dndbeyond.Action actIn, FeatureType type) {
		Action action = new Action();
		action.setName(actIn.getName());
		action.setDescription(actIn.getDescription());
		action.setSnippet(actIn.getSnippet());
		action.setType(FeatureType.RACE);
		action.setAbilityModifierStat(StatType.getEnum(actIn.getAbilityModifierStatId()));
		action.setAttackTypeRange(actIn.getAttackTypeRange());
		action.setActionType(ActionType.getEnum(actIn.getActionType()));
		action.setValue(actIn.getValue());
		action.setSpellRangeType(actIn.getSpellRangeType());
		if(actIn.getDice() != null) {
			action.setDieCount(actIn.getDice().getDiceCount());
			action.setDieValue(actIn.getDice().getDiceValue());
			action.setDiceMultiplier(actIn.getDice().getDiceMultiplier());
			action.setFixedValue(actIn.getDice().getFixedValue());
			action.setDiceString(actIn.getDice().getDiceString());
		}
		action.setAttackSubtype(AttackSubtype.getEnum(actIn.getAttackSubtype()));
		action.setOnMissDescription(actIn.getOnMissDescription());
		action.setDamageType(DamageType.getEnum(actIn.getDamageTypeId()));
		action.setMartialArt(actIn.isMartialArts());
		action.setProficient(actIn.isProficient());
		action.setDisplayAsAttack(actIn.isDisplayAsAttack());
		if(actIn.getRange() != null) {
			action.setOrigin(actIn.getRange().getOrigin());
			action.setRangeValue(actIn.getRange().getRangeValue());
			action.setAoeSize(actIn.getRange().getAoeSize());
			action.setAoeType(actIn.getRange().getAoeType());
			action.setAoeValue(actIn.getRange().getAoeValue());
			action.setAoeSpecialDescription(actIn.getRange().isHasAoeSpecialDescription());
			action.setRange(actIn.getRange().getRange());
			action.setLongRange(actIn.getRange().getLongRange());
		}
		action.setSaveFailDescription(actIn.getSaveFailDescription());
		action.setSaveSuccessDescription(actIn.getSaveSuccessDescription());
		action.setSaveStat(StatType.getEnum(actIn.getSaveStatId()));
		action.setFixedSaveDc(actIn.getFixedSaveDc());
		if(actIn.getLimitedUse() != null) {
			action.setResetType(ResetType.getEnum(actIn.getLimitedUse().getResetType()));
			action.setNumberUsed(actIn.getLimitedUse().getNumberUsed());
			action.setMaxUses(actIn.getLimitedUse().getMaxUses());
		}
		if(actIn.getActivation() != null) {
			action.setActivationType(ActivationType.getEnum(actIn.getActivation().getActivationType()));
			String actTime = actIn.getActivation().getActivationTime();
			if(actTime != null && !actTime.isEmpty()) action.setDuration(Integer.valueOf(actIn.getActivation().getActivationTime()));
		}		
		
		return action;
	}
	
	private void processInventory(CharacterSheet sheet, DndBeyondSheet character) {
		List<Item> charInventory = new ArrayList<>();
		Item charItem = null;
		com.patrickborrelli.dndiscord.model.dndbeyond.Item[] currentInv = character.getInventory();
		
		//iterate through the inventory to be converted, converting each Item:
		for(com.patrickborrelli.dndiscord.model.dndbeyond.Item item : Arrays.asList(currentInv)) {
			charItem = new Item();
			convertItem(item, charItem);
			charInventory.add(charItem);
		}
		sheet.setInventory(charInventory);
	}
	
	private void convertItem(com.patrickborrelli.dndiscord.model.dndbeyond.Item sourceItem, Item convertedItem) {
		LOGGER.debug("Original Item: " + sourceItem.toString());
		
		ItemDefinition sourceDetail = sourceItem.getDefinition();
		convertedItem.setName(sourceDetail.getName());
		convertedItem.setDescription(sourceDetail.getDescription());
		convertedItem.setSnippet(sourceDetail.getSnippet());
		convertedItem.setQuantity(sourceItem.getQuantity());
		convertedItem.setImageUrl(sourceDetail.getAvatarUrl());
		convertedItem.setLargeImageUrl(sourceDetail.getLargeAvatarUrl());
		convertedItem.setCost(sourceDetail.getCost());
		convertedItem.setWeight(sourceDetail.getWeight());
		convertedItem.setType(sourceDetail.getType());
		convertedItem.setSubType(sourceDetail.getSubType());
		convertedItem.setTags(sourceDetail.getTags());
		convertedItem.setConsumable(sourceDetail.isConsumable());
		convertedItem.setMonkWeapon(sourceDetail.isMonkWeapon());
		convertedItem.setRequiresAttunement(sourceDetail.isCanAttune());
		convertedItem.setAttuned(sourceItem.isAttuned());
		convertedItem.setEquipped(sourceItem.isEquipped());
		convertedItem.setAttack(sourceItem.isDisplayAsAttack());
		convertedItem.setStealthDisadvantage(sourceDetail.getStealthCheck() > 1);
		convertedItem.setStrengthRequirement(sourceDetail.getStrengthRequirement() > 0);
		convertedItem.setMagic(sourceDetail.isMagic());
		convertedItem.setArmorClass(sourceDetail.getArmorClass());
		convertedItem.setArmorType(ArmorType.getEnum(sourceDetail.getArmorTypeId()));
		if(convertedItem.isStrengthRequirement()) {
			convertedItem.setStrengthRequired(sourceDetail.getStrengthRequirement());
		}
		convertedItem.setDamageType(DamageType.getEnum(sourceDetail.getDamageType()));
		if(sourceDetail.getDamage() != null) {
			convertedItem.setDieCount(sourceDetail.getDamage().getDiceCount());
			convertedItem.setDieValue(sourceDetail.getDamage().getDiceValue());
			convertedItem.setDieMultiplier(sourceDetail.getDamage().getDiceMultiplier());
			convertedItem.setDiceString(sourceDetail.getDamage().getDiceString());
			convertedItem.setFixedDamage(sourceDetail.getDamage().getFixedValue());
		}
		convertedItem.setFilterType(FilterType.getEnum(sourceDetail.getFilterType()));
		convertedItem.setRange(sourceDetail.getRange());
		convertedItem.setLongRange(sourceDetail.getLongRange());
		if(sourceDetail.getProperties() != null) {
			convertedItem.setProperties(convertWeaponProperties(sourceDetail.getProperties()));
			if(convertedItem.getProperties().contains(WeaponPropertyType.VERSATILE)) {
				ItemProperty[] props = sourceDetail.getProperties();
				for(int i = 0; i < props.length; i++) {
					if(props[i].getId() == WeaponPropertyType.VERSATILE.getValue()) {
						convertedItem.setVersatileDiceString(props[i].getNotes());
					}
				}
			}
		}
		if(sourceItem.getLimitedUse() != null) {
			convertedItem.setMaxUses(sourceItem.getLimitedUse().getMaxUses());
			convertedItem.setNumberUsed(sourceItem.getLimitedUse().getNumberUsed());
			convertedItem.setResetType(ResetType.getEnum(sourceItem.getLimitedUse().getResetType()));
			convertedItem.setResetTypeDescription(sourceItem.getLimitedUse().getResetTypeDescription());
		}		
		if(sourceDetail.getWeaponBehaviors() != null && sourceDetail.getWeaponBehaviors().length > 0) {
			convertedItem.setAttack(true);
			convertedItem.setProperties(convertWeaponProperties(sourceDetail.getWeaponBehaviors()[0].getProperties()));
			convertedItem.setDieCount(sourceDetail.getWeaponBehaviors()[0].getDamage().getDiceCount());
			convertedItem.setDieValue(sourceDetail.getWeaponBehaviors()[0].getDamage().getDiceValue());
			convertedItem.setDieMultiplier(sourceDetail.getWeaponBehaviors()[0].getDamage().getDiceMultiplier());
			convertedItem.setDiceString(sourceDetail.getWeaponBehaviors()[0].getDamage().getDiceString());
			convertedItem.setFixedDamage(sourceDetail.getWeaponBehaviors()[0].getDamage().getFixedValue());
			convertedItem.setDamageType(DamageType.getEnum(sourceDetail.getWeaponBehaviors()[0].getDamageType()));
			convertedItem.setRange(sourceDetail.getWeaponBehaviors()[0].getRange());
			convertedItem.setLongRange(sourceDetail.getWeaponBehaviors()[0].getLongRange());
			convertedItem.setMonkWeapon(sourceDetail.getWeaponBehaviors()[0].isMonkWeapon());
		}
		LOGGER.debug("Converted Item: " + convertedItem.toString());
	}
	
	private Set<WeaponPropertyType> convertWeaponProperties(ItemProperty[] props) {
		Set<WeaponPropertyType> types = new HashSet<>();
		
		for(int i = 0; i < props.length; i++) {
			types.add(WeaponPropertyType.getEnum(props[i].getId()));
		}
		return types;
	}
	
	private void applySkillMods(CharacterSheet sheet) {
		int profBonus = ruleset.getProficiencyScore(sheet.getTotalLevel());
		int expertiseBonus = profBonus * 2;
		
		sheet.setAcrobaticsMod(sheet.getDexterityMod() +
				(sheet.isAcrobaticsExpertise() ? expertiseBonus : (sheet.isAcrobaticsProficiency() ? profBonus : 0)));
		sheet.setAnimalHandlingMod(sheet.getWisdomMod() +
				(sheet.isAnimalHandlingExpertise() ? expertiseBonus : (sheet.isAnimalHandlingProficiency() ? profBonus : 0)));
		sheet.setArcanaMod(sheet.getIntelligenceMod() + 
				(sheet.isArcanaExpertise() ? expertiseBonus : (sheet.isArcanaProficiency() ? profBonus : 0)));
		sheet.setAthleticsMod(sheet.getStrengthMod() + 
				(sheet.isAthleticsExpertise() ? expertiseBonus : (sheet.isAthleticsProficiency() ? profBonus : 0)));
		sheet.setDeceptionMod(sheet.getCharismaMod() + 
				(sheet.isDeceptionExpertise() ? expertiseBonus : (sheet.isDeceptionProficiency() ? profBonus : 0)));
		sheet.setHistoryMod(sheet.getIntelligenceMod() + 
				(sheet.isHistoryExpertise() ? expertiseBonus : (sheet.isHistoryProficiency() ? profBonus : 0)));
		sheet.setInsightMod(sheet.getWisdomMod() + 
				(sheet.isInsightExpertise() ? expertiseBonus : (sheet.isInsightProficiency() ? profBonus : 0)));
		sheet.setIntimidationMod(sheet.getCharismaMod() + 
				(sheet.isIntimidationExpertise() ? expertiseBonus : (sheet.isIntimidationProficiency() ? profBonus : 0)));
		sheet.setInvestigationMod(sheet.getIntelligenceMod() + 
				(sheet.isInvestigationExpertise() ? expertiseBonus : (sheet.isInvestigationProficiency() ? profBonus : 0)));
		sheet.setMedicineMod(sheet.getWisdomMod() + 
				(sheet.isMedicineExpertise() ? expertiseBonus : (sheet.isMedicineProficiency() ? profBonus : 0)));
		sheet.setNatureMod(sheet.getIntelligenceMod() + 
				(sheet.isNatureExpertise() ? expertiseBonus : (sheet.isNatureProficiency() ? profBonus : 0)));
		sheet.setPerceptionMod(sheet.getWisdomMod() + 
				(sheet.isPerceptionExpertise() ? expertiseBonus : (sheet.isPerceptionProficiency() ? profBonus : 0)));
		sheet.setPerformanceMod(sheet.getCharismaMod() + 
				(sheet.isPerformanceExpertise() ? expertiseBonus : (sheet.isPerformanceProficiency() ? profBonus : 0)));
		sheet.setPersuasionMod(sheet.getCharismaMod() + 
				(sheet.isPersuasionExpertise() ? expertiseBonus : (sheet.isPersuasionProficiency() ? profBonus : 0)));
		sheet.setReligionMod(sheet.getIntelligenceMod() + 
				(sheet.isReligionExpertise() ? expertiseBonus : (sheet.isReligionProficiency() ? profBonus : 0)));
		sheet.setSleightOfHandMod(sheet.getDexterityMod() + 
				(sheet.isSleightOfHandExpertise() ? expertiseBonus : (sheet.isSleightOfHandProficiency() ? profBonus : 0)));
		sheet.setStealthMod(sheet.getDexterityMod() + 
				(sheet.isStealthExpertise() ? expertiseBonus : (sheet.isStealthProficiency() ? profBonus : 0)));
		sheet.setSurvivalMod(sheet.getWisdomMod() + 
				(sheet.isSurvivalExpertise() ? expertiseBonus : (sheet.isSurvivalProficiency() ? profBonus : 0)));
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
		List<DndBeyondCharacterClass> beyondClasses =
				Arrays.asList(character.getClasses());
		List<CharacterClass> discordClasses = new ArrayList<>();
		CharacterClass thisClass = null;
		int totalLevel = 0;
		
		for(DndBeyondCharacterClass beyondClass : beyondClasses) {
			thisClass = new CharacterClass();
			thisClass.setLevel(beyondClass.getLevel());
			thisClass.setName(beyondClass.getDefinition().getName());
			thisClass.setStartingClass(beyondClass.isStartingClass());
			thisClass.setSubclassName(beyondClass.getSubclassDefinition().getName());
			thisClass.setHitDiceUsed(beyondClass.getHitDiceUsed());
			thisClass.setHitDieType(beyondClass.getDefinition().getHitDice());
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
		
		processBeyondModifierSet(racialModifiers, sheet, "Race", character);
		processBeyondModifierSet(classModifiers, sheet, "Class", character);
		processBeyondModifierSet(backgroundModifiers, sheet, "Background", character);
		processBeyondModifierSet(itemModifiers, sheet, "Item", character);
		processBeyondModifierSet(featModifiers, sheet, "Feat", character);
		processBeyondModifierSet(conditionModifiers, sheet, "Condition", character);				
	}
	
	private FeatureType getFeatureType(String mod) {
		FeatureType type = null;
		if(mod.contains(DndBeyondConstants.CLASS_OPTION)) {
			type = FeatureType.CLASS_OPTION;
		} else if(mod.contains(DndBeyondConstants.RACIAL_TRAIT)) {
			type = FeatureType.RACE;
		} else if(mod.contains(DndBeyondConstants.FEAT)) {
			type = FeatureType.FEAT;
		} else if(mod.contains(DndBeyondConstants.CLASS_FEATURE)) {
			type = FeatureType.CLASS_FEATURE;
		} else if(mod.contains(DndBeyondConstants.BACKGROUND_FEATURE)) {
			type = FeatureType.BACKGROUND;
		} else if(mod.contains(DndBeyondConstants.ITEM_FEATURE)) {
			type = FeatureType.ITEM;
		}
			
		return type;
	}
	
	private Feature getFeatureFromModifier(Modifier mod, DndBeyondSheet character) {
		Feature feat = null;
		FeatureType type = getFeatureType(mod.getId());
		if(type != null) {
			switch(type) {
			
				case CLASS_OPTION:
					Option opt = character.getClassOption(mod.getComponentId());
					if(null != opt) {
						feat = new Feature();
						feat.setType(type);
						feat.setOptionName(opt.getDefinition().getName());
						feat.setOptionDescription(opt.getDefinition().getDescription());
						feat.setOptionSnippet(opt.getDefinition().getSnippet());
						ClassFeature myFeature = character.getClassFeatureById(opt.getComponentId());
						if(myFeature != null) {
							Activation act = myFeature.getDefinition().getActivation();
							if(act != null) {
								String actType = act.getActivationType();
								String actTime = act.getActivationTime();
								if(actType != null) feat.setActivationType(ActivationType.getEnum(Integer.parseInt(actType)));
								if(actTime != null) feat.setDuration(Integer.parseInt(actTime));
							}						
							feat.setDisplayOrder(myFeature.getDefinition().getDisplayOrder());
							feat.setName(myFeature.getDefinition().getName());
							feat.setDescription(myFeature.getDefinition().getDescription());
							feat.setSnippet(myFeature.getDefinition().getSnippet());
							feat.setRequiredLevel(myFeature.getDefinition().getRequiredLevel());
							feat.setSubClassFeature(myFeature.getDefinition().isSubClassFeature());
							LimitedUse[] limUses = myFeature.getDefinition().getLimitedUse();
							if(limUses != null && limUses.length > 0) {
								feat.setLimitedUseResetType(ResetType.getEnum(Integer.parseInt(limUses[0].getResetType())));
								feat.setLimitedUseNumberUsed(limUses[0].getNumberUsed());
								feat.setLimitedUseMinNumberConsumed(limUses[0].getMinNumberConsumed());
								feat.setLimitedUseMaxNumberConsumed(limUses[0].getMaxNumberConsumed());
								feat.setLimitedUseMaxUses(limUses[0].getMaxUses());
								feat.setLimitedUseOperator(limUses[0].getOperator());
							}
							feat.setHideInSheet(myFeature.getDefinition().isHideInSheet());
							feat.setSource(Integer.toString(myFeature.getDefinition().getSourceId()));
							feat.setSourcePageNumber(myFeature.getDefinition().getSourcePageNumber());						
						}
					}					
					break;
					
				case CLASS_FEATURE:
					ClassFeature myFeature = character.getClassFeatureById(mod.getComponentId());						
					if(myFeature != null) {
						feat = new Feature();
						feat.setType(type);
						Activation act = myFeature.getDefinition().getActivation();
						if(act != null) {
							String actType = act.getActivationType();
							String actTime = act.getActivationTime();
							if(actType != null) feat.setActivationType(ActivationType.getEnum(Integer.parseInt(actType)));
							if(actTime != null) feat.setDuration(Integer.parseInt(actTime));
						}						
						feat.setDisplayOrder(myFeature.getDefinition().getDisplayOrder());
						feat.setName(myFeature.getDefinition().getName());
						feat.setDescription(myFeature.getDefinition().getDescription());
						feat.setSnippet(myFeature.getDefinition().getSnippet());
						feat.setRequiredLevel(myFeature.getDefinition().getRequiredLevel());
						feat.setSubClassFeature(myFeature.getDefinition().isSubClassFeature());
						LimitedUse[] limUses = myFeature.getDefinition().getLimitedUse();
						if(limUses != null && limUses.length > 0) {
							feat.setLimitedUseResetType(ResetType.getEnum(Integer.parseInt(limUses[0].getResetType())));
							feat.setLimitedUseNumberUsed(limUses[0].getNumberUsed());
							feat.setLimitedUseMinNumberConsumed(limUses[0].getMinNumberConsumed());
							feat.setLimitedUseMaxNumberConsumed(limUses[0].getMaxNumberConsumed());
							feat.setLimitedUseMaxUses(limUses[0].getMaxUses());
							feat.setLimitedUseOperator(limUses[0].getOperator());
						}
						feat.setHideInSheet(myFeature.getDefinition().isHideInSheet());
						feat.setSource(Integer.toString(myFeature.getDefinition().getSourceId()));
						feat.setSourcePageNumber(myFeature.getDefinition().getSourcePageNumber());						
					}
					break;
					
				case RACE:
					RacialTrait trait = character.getTraitById(mod.getComponentId());
					if(trait != null) {
						feat = new Feature();
						feat.setType(type);
						Activation act = trait.getDefinition().getActivation();
						if(act != null) {
							String actType = act.getActivationType();
							String actTime = act.getActivationTime();
							if(actType != null) feat.setActivationType(ActivationType.getEnum(Integer.parseInt(actType)));
							if(actTime != null) feat.setDuration(Integer.parseInt(actTime));
						}						
						feat.setDisplayOrder(trait.getDefinition().getDisplayOrder());
						feat.setName(trait.getDefinition().getName());
						feat.setDescription(trait.getDefinition().getDescription());
						feat.setSnippet(trait.getDefinition().getSnippet());
						feat.setRequiredLevel(trait.getDefinition().getRequiredLevel());
						feat.setSubClassFeature(trait.getDefinition().isSubClassFeature());
						LimitedUse[] limUses = trait.getDefinition().getLimitedUse();
						if(limUses != null && limUses.length > 0) {
							feat.setLimitedUseResetType(ResetType.getEnum(Integer.parseInt(limUses[0].getResetType())));
							feat.setLimitedUseNumberUsed(limUses[0].getNumberUsed());
							feat.setLimitedUseMinNumberConsumed(limUses[0].getMinNumberConsumed());
							feat.setLimitedUseMaxNumberConsumed(limUses[0].getMaxNumberConsumed());
							feat.setLimitedUseMaxUses(limUses[0].getMaxUses());
							feat.setLimitedUseOperator(limUses[0].getOperator());
						}
						feat.setHideInSheet(trait.getDefinition().isHideInSheet());
						feat.setSource(Integer.toString(trait.getDefinition().getSourceId()));
						feat.setSourcePageNumber(trait.getDefinition().getSourcePageNumber());						
					}			
					break;
					
				case FEAT:
					Feat dndbFeat = character.getFeatById(mod.getComponentId());
					if(dndbFeat != null) {
						feat = new Feature();
						feat.setType(type);
						Activation act = dndbFeat.getDefinition().getActivation();
						if(act != null) {
							String actType = act.getActivationType();
							String actTime = act.getActivationTime();
							if(actType != null) feat.setActivationType(ActivationType.getEnum(Integer.parseInt(actType)));
							if(actTime != null) feat.setDuration(Integer.parseInt(actTime));
						}						
						feat.setDisplayOrder(dndbFeat.getDefinition().getDisplayOrder());
						feat.setName(dndbFeat.getDefinition().getName());
						feat.setDescription(dndbFeat.getDefinition().getDescription());
						feat.setSnippet(dndbFeat.getDefinition().getSnippet());
						feat.setRequiredLevel(dndbFeat.getDefinition().getRequiredLevel());
						feat.setSubClassFeature(dndbFeat.getDefinition().isSubClassFeature());
						LimitedUse[] limUses = dndbFeat.getDefinition().getLimitedUse();
						if(limUses != null && limUses.length > 0) {
							feat.setLimitedUseResetType(ResetType.getEnum(Integer.parseInt(limUses[0].getResetType())));
							feat.setLimitedUseNumberUsed(limUses[0].getNumberUsed());
							feat.setLimitedUseMinNumberConsumed(limUses[0].getMinNumberConsumed());
							feat.setLimitedUseMaxNumberConsumed(limUses[0].getMaxNumberConsumed());
							feat.setLimitedUseMaxUses(limUses[0].getMaxUses());
							feat.setLimitedUseOperator(limUses[0].getOperator());
						}
						feat.setHideInSheet(dndbFeat.getDefinition().isHideInSheet());
						feat.setSource(Integer.toString(dndbFeat.getDefinition().getSourceId()));
						feat.setSourcePageNumber(dndbFeat.getDefinition().getSourcePageNumber());						
					}			
					break;
					
				case BACKGROUND:
					Background background = character.getBackground();
					if(background != null) {
						feat = new Feature();
						feat.setType(type);
						feat.setDisplayOrder(1);
						feat.setName(background.getDefinition().getName());
						feat.setDescription(background.getDefinition().getDescription());
						feat.setSnippet(background.getDefinition().getSnippet());
						feat.setHideInSheet(false);
						feat.setFeatureDescription(background.getDefinition().getFeatureDescription());
						feat.setFeatureName(background.getDefinition().getFeatureName());
						feat.setShortDescription(background.getDefinition().getShortDescription());
						feat.setSuggestedCharacteristicsDescription(background.getDefinition().getSuggestedCharacteristicsDescription());
					}
					break;
					
				default:
					break;						
			}
		}		
		return feat;
	}
	
	private void processBeyondModifierSet(List<Modifier> mods, CharacterSheet sheet, String modifierType, DndBeyondSheet character) {
		LOGGER.debug("Processing "+ modifierType + " modifiers.");
		for(Modifier mod : mods) {
			LOGGER.debug("Modifier: " + mod.toString());
			
			Feature feat = getFeatureFromModifier(mod, character);
			if(feat != null) features.add(feat);
			
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
						
					case DndBeyondConstants.ACROBATICS:
						sheet.setAcrobaticsProficiency(true);
						break;
						
					case DndBeyondConstants.ANIMAL_HANDLING:
						sheet.setAnimalHandlingProficiency(true);
						break;
						
					case DndBeyondConstants.ARCANA:
						sheet.setArcanaProficiency(true);
						break;
						
					case DndBeyondConstants.ATHLETICS:
						sheet.setAthleticsProficiency(true);
						break;
						
					case DndBeyondConstants.DECEPTION:
						sheet.setDeceptionProficiency(true);
						break;
						
					case DndBeyondConstants.HISTORY:
						sheet.setHistoryProficiency(true);
						break;
						
					case DndBeyondConstants.INSIGHT:
						sheet.setInsightProficiency(true);
						break;
						
					case DndBeyondConstants.INTIMIDATION:
						sheet.setIntimidationProficiency(true);
						break;
						
					case DndBeyondConstants.INVESTIGATION:
						sheet.setInvestigationProficiency(true);
						break;
						
					case DndBeyondConstants.MEDICINE:
						sheet.setMedicineProficiency(true);
						break;
						
					case DndBeyondConstants.NATURE:
						sheet.setNatureProficiency(true);
						break;
						
					case DndBeyondConstants.PERCEPTION:
						sheet.setPerceptionProficiency(true);
						break;
						
					case DndBeyondConstants.PERFORMANCE:
						sheet.setPerformanceProficiency(true);
						break;
						
					case DndBeyondConstants.PERSUASION:
						sheet.setPersuasionProficiency(true);
						break;
						
					case DndBeyondConstants.RELIGION:
						sheet.setReligionProficiency(true);
						break;
						
					case DndBeyondConstants.SLEIGHT_OF_HAND:
						sheet.setSleightOfHandProficiency(true);
						break;
						
					case DndBeyondConstants.STEALTH:
						sheet.setStealthProficiency(true);
						break;
						
					case DndBeyondConstants.SURVIVAL:
						sheet.setSurvivalProficiency(true);
						break;
						
					default:
						LOGGER.info("Received sub type I am not currently handling: " + mod.getSubType());	
				}
			} else if(mod.getType().equalsIgnoreCase(DndBeyondConstants.EXPERTISE)) {
				switch(mod.getSubType()) {
					case DndBeyondConstants.ACROBATICS:
						sheet.setAcrobaticsExpertise(true);
						break;
						
					case DndBeyondConstants.ANIMAL_HANDLING:
						sheet.setAnimalHandlingExpertise(true);
						break;
						
					case DndBeyondConstants.ARCANA:
						sheet.setArcanaExpertise(true);
						break;
						
					case DndBeyondConstants.ATHLETICS:
						sheet.setAthleticsExpertise(true);
						break;
						
					case DndBeyondConstants.DECEPTION:
						sheet.setDeceptionExpertise(true);
						break;
						
					case DndBeyondConstants.HISTORY:
						sheet.setHistoryExpertise(true);
						break;
						
					case DndBeyondConstants.INSIGHT:
						sheet.setInsightExpertise(true);
						break;
						
					case DndBeyondConstants.INTIMIDATION:
						sheet.setIntimidationExpertise(true);
						break;
						
					case DndBeyondConstants.INVESTIGATION:
						sheet.setInvestigationExpertise(true);
						break;
						
					case DndBeyondConstants.MEDICINE:
						sheet.setMedicineExpertise(true);
						break;
						
					case DndBeyondConstants.NATURE:
						sheet.setNatureExpertise(true);
						break;
						
					case DndBeyondConstants.PERCEPTION:
						sheet.setPerceptionExpertise(true);
						break;
						
					case DndBeyondConstants.PERFORMANCE:
						sheet.setPerformanceExpertise(true);
						break;
						
					case DndBeyondConstants.PERSUASION:
						sheet.setPersuasionExpertise(true);
						break;
						
					case DndBeyondConstants.RELIGION:
						sheet.setReligionExpertise(true);
						break;
						
					case DndBeyondConstants.SLEIGHT_OF_HAND:
						sheet.setSleightOfHandExpertise(true);
						break;
						
					case DndBeyondConstants.STEALTH:
						sheet.setStealthExpertise(true);
						break;
						
					case DndBeyondConstants.SURVIVAL:
						sheet.setSurvivalExpertise(true);
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
			StatType stat = StatType.getEnum(stats[i].getId());
			int value = stats[i].getValue();
			switch(stat) {
				case STRENGTH:
					sheet.setBaseStrength(value);
					break;
				case DEXTERITY:
					sheet.setBaseDexterity(value);
					break;
				case CONSTITUTION:
					sheet.setBaseConstitution(value);
					break;
				case INTELLIGENCE:
					sheet.setBaseIntelligence(value);
					break;
				case WISDOM:
					sheet.setBaseWisdom(value);
					break;
				case CHARISMA:
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
}
