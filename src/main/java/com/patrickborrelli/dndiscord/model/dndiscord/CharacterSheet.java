package com.patrickborrelli.dndiscord.model.dndiscord;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.patrickborrelli.dndiscord.model.DiscordUser;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model of dDnDiscord Character Sheet entry.
 * 
 * @author Patrick Borrelli
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterSheet {
	
	@JsonProperty("_id")
	private String id;
	private String sheetSource;
	private DiscordUser user;
	private String characterName;
	private String avatarUrl;
	private String faith;
	private int age;
	private String hair;
	private String skin;
	private String height;
	private String weight;
	private boolean inspiration;
	private String gender;
	private int experiencePoints;
	private String alignment;
	private String lifestyle;
	private String personalityTraits;
	private String ideals;
	private String bonds;
	private String flaws;
	private String appearance;
	private int copperPieces;
	private int silverPieces;
	private int electrumPieces;
	private int goldPieces;
	private int platinumPieces;
	private int proficiencyBonus;
	private int effectiveArmorClass;
	
	//Ability Scores and modifiers:
	private int baseStrength;
	private int baseDexterity;
	private int baseConstitution;
	private int baseIntelligence;
	private int baseWisdom;
	private int baseCharisma;
	private int strengthBonus;
	private int dexterityBonus;
	private int constitutionBonus;
	private int intelligenceBonus;
	private int wisdomBonus;
	private int charismaBonus;	
	private int totalStrength;
	private int totalDexterity;
	private int totalConstitution;
	private int totalIntelligence;
	private int totalWisdom;
	private int totalCharisma;
	private int strengthMod;
	private int dexterityMod;
	private int constitutionMod;
	private int intelligenceMod;
	private int wisdomMod;
	private int charismaMod;	
	
	//saving throws and proficiencies:
	private int strengthSave;
	private int dexteritySave;
	private int constitutionSave;
	private int intelligenceSave;
	private int wisdomSave;
	private int charismaSave;
	private boolean strengthSaveProficiency;
	private boolean dexteritySaveProficiency;
	private boolean constitutionSaveProficiency;
	private boolean intelligenceSaveProficiency;
	private boolean wisdomSaveProficiency;
	private boolean charismaSaveProficiency;
	
	//skills:
	private int acrobaticsMod;
	private int animalHandlingMod;
	private int arcanaMod;
	private int athleticsMod;
	private int deceptionMod;
	private int historyMod;
	private int insightMod;
	private int intimidationMod;
	private int investigationMod;
	private int medicineMod;
	private int natureMod;
	private int perceptionMod;
	private int performanceMod;
	private int persuasionMod;
	private int religionMod;
	private int sleightOfHandMod;
	private int stealthMod;
	private int survivalMod;
	private boolean acrobaticsProficiency;
	private boolean animalHandlingProficiency;
	private boolean arcanaProficiency;
	private boolean athleticsProficiency;
	private boolean deceptionProficiency;
	private boolean historyProficiency;
	private boolean insightProficiency;
	private boolean intimidationProficiency;
	private boolean investigationProficiency;
	private boolean medicineProficiency;
	private boolean natureProficiency;
	private boolean perceptionProficiency;
	private boolean performanceProficiency;
	private boolean persuasionProficiency;
	private boolean religionProficiency;
	private boolean sleightOfHandProficiency;
	private boolean stealthProficiency;
	private boolean survivalProficiency;	
	private boolean acrobaticsExpertise;
	private boolean animalHandlingExpertise;
	private boolean arcanaExpertise;
	private boolean athleticsExpertise;
	private boolean deceptionExpertise;
	private boolean historyExpertise;
	private boolean insightExpertise;
	private boolean intimidationExpertise;
	private boolean investigationExpertise;
	private boolean medicineExpertise;
	private boolean natureExpertise;
	private boolean perceptionExpertise;
	private boolean performanceExpertise;
	private boolean persuasionExpertise;
	private boolean religionExpertise;
	private boolean sleightOfHandExpertise;
	private boolean stealthExpertise;
	private boolean survivalExpertise;
	
	//Background and related traits:
	private String background;
	
	//Race and related traits:
	private String race;
	private String baseRace;
	private String size;
	private int walkSpeed;
	private int flySpeed;
	private int burrowSpeed;
	private int swimSpeed;
	private int climbSpeed;
	
	//Classes and subclasses and related traits:
	private List<CharacterClass> characterClasses;
	private int totalLevel;
	private int maxHitPoints;
	private int currentHitPoints;
	private int temporaryHitPoints;
	
	//Documented features:
	private Set<Feature> features;
	
	private Set<String> proficiencies;
	
	private List<Item> inventory;
	
	//attacks and actions:
	private int attackCount;
	private int attacksUsed;
	private Set<Action> actions;
	private Set<Attack> attacks;	
	
	/**
	 * @param baseStrength the baseStrength to set
	 */
	public void setBaseStrength(int baseStrength) {
		this.baseStrength = baseStrength;
		this.totalStrength = baseStrength + strengthBonus;
	}

	/**
	 * @param baseDexterity the baseDexterity to set
	 */
	public void setBaseDexterity(int baseDexterity) {
		this.baseDexterity = baseDexterity;
		this.totalDexterity = baseDexterity + dexterityBonus;
	}

	/**
	 * @param baseConstitution the baseConstitution to set
	 */
	public void setBaseConstitution(int baseConstitution) {
		this.baseConstitution = baseConstitution;
		this.totalConstitution = baseConstitution + constitutionBonus;
	}

	/**
	 * @param baseIntelligence the baseIntelligence to set
	 */
	public void setBaseIntelligence(int baseIntelligence) {
		this.baseIntelligence = baseIntelligence;
		this.totalIntelligence = baseIntelligence + intelligenceBonus;
	}

	/**
	 * @param baseWisdom the baseWisdom to set
	 */
	public void setBaseWisdom(int baseWisdom) {
		this.baseWisdom = baseWisdom;
		this.totalWisdom = baseWisdom + wisdomBonus;
	}

	/**
	 * @param baseCharisma the baseCharisma to set
	 */
	public void setBaseCharisma(int baseCharisma) {
		this.baseCharisma = baseCharisma;
		this.totalCharisma = baseCharisma + charismaBonus;
	}

	/**
	 * @param strengthBonus the strengthBonus to set
	 */
	public void setStrengthBonus(int strengthBonus) {
		this.strengthBonus = strengthBonus;
		this.totalStrength = baseStrength + strengthBonus;
	}
	
	/**
	 * @param dexterityBonus the dexterityBonus to set
	 */
	public void setDexterityBonus(int dexterityBonus) {
		this.dexterityBonus = dexterityBonus;
		this.totalDexterity = baseDexterity + dexterityBonus;
	}

	/**
	 * @param constitutionBonus the constitutionBonus to set
	 */
	public void setConstitutionBonus(int constitutionBonus) {
		this.constitutionBonus = constitutionBonus;
		this.totalConstitution = baseConstitution + constitutionBonus;
	}

	/**
	 * @param intelligenceBonus the intelligenceBonus to set
	 */
	public void setIntelligenceBonus(int intelligenceBonus) {
		this.intelligenceBonus = intelligenceBonus;
		this.totalIntelligence = baseIntelligence + intelligenceBonus;
	}

	/**
	 * @param wisdomBonus the wisdomBonus to set
	 */
	public void setWisdomBonus(int wisdomBonus) {
		this.wisdomBonus = wisdomBonus;
		this.totalWisdom = baseWisdom + wisdomBonus;
	}

	/**
	 * @param charismaBonus the charismaBonus to set
	 */
	public void setCharismaBonus(int charismaBonus) {
		this.charismaBonus = charismaBonus;
		this.totalCharisma = baseCharisma + charismaBonus;
	}
}