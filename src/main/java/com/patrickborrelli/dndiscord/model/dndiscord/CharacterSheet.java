package com.patrickborrelli.dndiscord.model.dndiscord;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.patrickborrelli.dndiscord.model.DiscordUser;
import com.patrickborrelli.dndiscord.model.type.StatType;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model of DnDiscord Character Sheet entry.
 * 
 * @author Patrick Borrelli
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterSheet {
	
	private DiscordUser user;
	private boolean active;
	@JsonProperty("_id")
	private String id;
	@JsonProperty("sheet_source")
	private String sheetSource;
	@JsonProperty("character_name")
	private String characterName;
	@JsonProperty("avatar_url")
	private String avatarUrl;
	private String faith;
	private int age;
	private String hair;
	private String skin;
	private String height;
	private String weight;
	private boolean inspiration;
	private String gender;
	@JsonProperty("experience_points")
	private int experiencePoints;
	private String alignment;
	private String lifestyle;
	@JsonProperty("personality_traits")
	private String personalityTraits;
	private String ideals;
	private String bonds;
	private String flaws;
	private String appearance;
	@JsonProperty("copper_pieces")
	private int copperPieces;
	@JsonProperty("silver_pieces")
	private int silverPieces;
	@JsonProperty("electrum_pieces")
	private int electrumPieces;
	@JsonProperty("gold_pieces")
	private int goldPieces;
	@JsonProperty("platinum_pieces")
	private int platinumPieces;
	@JsonProperty("proficiency_bonus")
	private int proficiencyBonus;
	@JsonProperty("effective_armor_class")
	private int effectiveArmorClass;
	
	//Ability Scores and modifiers:
	@JsonProperty("base_strength")
	private int baseStrength;
	@JsonProperty("base_dexterity")
	private int baseDexterity;
	@JsonProperty("base_constitution")
	private int baseConstitution;
	@JsonProperty("base_intelligence")
	private int baseIntelligence;
	@JsonProperty("base_wisdom")
	private int baseWisdom;
	@JsonProperty("base_charisma")
	private int baseCharisma;
	@JsonProperty("strength_bonus")
	private int strengthBonus;
	@JsonProperty("dexterity_bonus")
	private int dexterityBonus;
	@JsonProperty("constitution_bonus")
	private int constitutionBonus;
	@JsonProperty("intelligence_bonus")
	private int intelligenceBonus;
	@JsonProperty("wisdom_bonus")
	private int wisdomBonus;
	@JsonProperty("charisma_bonus")
	private int charismaBonus;	
	@JsonProperty("total_strength")
	private int totalStrength;
	@JsonProperty("total_dexterity")
	private int totalDexterity;
	@JsonProperty("total_constitution")
	private int totalConstitution;
	@JsonProperty("total_intelligence")
	private int totalIntelligence;
	@JsonProperty("total_wisdom")
	private int totalWisdom;
	@JsonProperty("total_charisma")
	private int totalCharisma;
	@JsonProperty("strength_mod")
	private int strengthMod;
	@JsonProperty("dexterity_mod")
	private int dexterityMod;
	@JsonProperty("constitution_mod")
	private int constitutionMod;
	@JsonProperty("intelligence_mod")
	private int intelligenceMod;
	@JsonProperty("wisdom_mod")
	private int wisdomMod;
	@JsonProperty("charisma_mod")
	private int charismaMod;	
	
	//saving throws and proficiencies:
	@JsonProperty("strength_save")
	private int strengthSave;
	@JsonProperty("dexterity_save")
	private int dexteritySave;
	@JsonProperty("constitution_save")
	private int constitutionSave;
	@JsonProperty("intelligence_save")
	private int intelligenceSave;
	@JsonProperty("wisdom_save")
	private int wisdomSave;
	@JsonProperty("charisma_save")
	private int charismaSave;
	@JsonProperty("strength_save_proficiency")
	private boolean strengthSaveProficiency;
	@JsonProperty("dexterity_save_proficiency")
	private boolean dexteritySaveProficiency;
	@JsonProperty("constitution_save_proficiency")
	private boolean constitutionSaveProficiency;
	@JsonProperty("intelligence_save_proficiency")
	private boolean intelligenceSaveProficiency;
	@JsonProperty("wisdom_save_proficiency")
	private boolean wisdomSaveProficiency;
	@JsonProperty("charisma_save_proficiency")
	private boolean charismaSaveProficiency;
	
	//skills:
	@JsonProperty("acrobatics_mod")
	private int acrobaticsMod;
	@JsonProperty("animal_handling_mod")
	private int animalHandlingMod;
	@JsonProperty("arcana_mod")
	private int arcanaMod;
	@JsonProperty("athletics_mod")
	private int athleticsMod;
	@JsonProperty("deception_mod")
	private int deceptionMod;
	@JsonProperty("history_mod")
	private int historyMod;
	@JsonProperty("insight_mod")
	private int insightMod;
	@JsonProperty("intimidation_mod")
	private int intimidationMod;
	@JsonProperty("investigation_mod")
	private int investigationMod;
	@JsonProperty("medicine_mod")
	private int medicineMod;
	@JsonProperty("nature_mod")
	private int natureMod;
	@JsonProperty("perception_mod")
	private int perceptionMod;
	@JsonProperty("performance_mod")
	private int performanceMod;
	@JsonProperty("persuasion_mod")
	private int persuasionMod;
	@JsonProperty("religion_mod")
	private int religionMod;
	@JsonProperty("sleight_of_hand_mod")
	private int sleightOfHandMod;
	@JsonProperty("stealth_mod")
	private int stealthMod;
	@JsonProperty("survival_mod")
	private int survivalMod;
	@JsonProperty("acrobatics_proficiency")
	private boolean acrobaticsProficiency;
	@JsonProperty("animal_handling_proficiency")
	private boolean animalHandlingProficiency;
	@JsonProperty("arcana_proficiency")
	private boolean arcanaProficiency;
	@JsonProperty("athletics_proficiency")
	private boolean athleticsProficiency;
	@JsonProperty("deception_proficiency")
	private boolean deceptionProficiency;
	@JsonProperty("history_proficiency")
	private boolean historyProficiency;
	@JsonProperty("insight_proficiency")
	private boolean insightProficiency;
	@JsonProperty("intimidation_proficiency")
	private boolean intimidationProficiency;
	@JsonProperty("investigation_proficiency")
	private boolean investigationProficiency;
	@JsonProperty("medicine_proficiency")
	private boolean medicineProficiency;
	@JsonProperty("nature_proficiency")
	private boolean natureProficiency;
	@JsonProperty("perception_proficiency")
	private boolean perceptionProficiency;
	@JsonProperty("performance_proficiency")
	private boolean performanceProficiency;
	@JsonProperty("persuasion_proficiency")
	private boolean persuasionProficiency;
	@JsonProperty("religion_proficiency")
	private boolean religionProficiency;
	@JsonProperty("sleight_of_hand_proficiency")
	private boolean sleightOfHandProficiency;
	@JsonProperty("stealth_proficiency")
	private boolean stealthProficiency;
	@JsonProperty("survival_proficiency")
	private boolean survivalProficiency;	
	@JsonProperty("acrobatics_expertise")
	private boolean acrobaticsExpertise;
	@JsonProperty("animal_handling_expertise")
	private boolean animalHandlingExpertise;
	@JsonProperty("arcana_expertise")
	private boolean arcanaExpertise;
	@JsonProperty("athletics_expertise")
	private boolean athleticsExpertise;
	@JsonProperty("deception_expertise")
	private boolean deceptionExpertise;
	@JsonProperty("history_expertise")
	private boolean historyExpertise;
	@JsonProperty("insight_expertise")
	private boolean insightExpertise;
	@JsonProperty("intimidation_expertise")
	private boolean intimidationExpertise;
	@JsonProperty("investigation_expertise")
	private boolean investigationExpertise;
	@JsonProperty("medicine_expertise")
	private boolean medicineExpertise;
	@JsonProperty("nature_expertise")
	private boolean natureExpertise;
	@JsonProperty("perception_expertise")
	private boolean perceptionExpertise;
	@JsonProperty("performance_expertise")
	private boolean performanceExpertise;
	@JsonProperty("persuasion_expertise")
	private boolean persuasionExpertise;
	@JsonProperty("religion_expertise")
	private boolean religionExpertise;
	@JsonProperty("sleight_of_hand_expertise")
	private boolean sleightOfHandExpertise;
	@JsonProperty("stealth_expertise")
	private boolean stealthExpertise;
	@JsonProperty("survival_expertise")
	private boolean survivalExpertise;
	
	//Background and related traits:
	private String background;
	
	//Race and related traits:
	private String race;
	@JsonProperty("base_race")
	private String baseRace;
	private String size;
	@JsonProperty("walk_speed")
	private int walkSpeed;
	@JsonProperty("fly_speed")
	private int flySpeed;
	@JsonProperty("burrow_speed")
	private int burrowSpeed;
	@JsonProperty("swim_speed")
	private int swimSpeed;
	@JsonProperty("climb_speed")
	private int climbSpeed;
	
	//Classes and subclasses and related traits:
	@JsonProperty("character_classes")
	private List<CharacterClass> characterClasses;
	@JsonProperty("total_level")
	private int totalLevel;
	@JsonProperty("max_hit_points")
	private int maxHitPoints;
	@JsonProperty("current_hit_points")
	private int currentHitPoints;
	@JsonProperty("temporary_hit_points")
	private int temporaryHitPoints;
	
	//Documented features:
	private Set<Feature> features;
	
	private Set<String> proficiencies;
	
	private Set<String> languages;
	
	private List<Item> inventory;
	
	//attacks and actions:
	@JsonProperty("attack_count")
	private int attackCount;
	@JsonProperty("attacks_used")
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
	
	/**
	 * @param type the StatType to retrieve a modifier for.
	 * @return an integer modifier for the provided StatType
	 */
	public int getModifierByStatType(StatType type) {
		int modifier = 0;
		switch (type) {
		case STRENGTH:
			modifier = getStrengthMod();
			break;
		case DEXTERITY:
			modifier = getDexterityMod();
			break;
		case CONSTITUTION:
			modifier = getConstitutionMod();
			break;
		case INTELLIGENCE:
			modifier = getIntelligenceMod();
			break;
		case WISDOM:
			modifier = getWisdomMod();
			break;
		case CHARISMA:
			modifier = getCharismaMod();
			break;
		default:
			;
		}
		return modifier;
	}
	
	public CharacterDisplay getDisplaySheet() {
		CharacterDisplay display = new CharacterDisplay();
		
		display.setId(id);
		display.setCharacterName(characterName);
		display.setAvatarUrl(avatarUrl);
		display.setAlignment(alignment);
		display.setCopper(copperPieces);
		display.setSilver(silverPieces);
		display.setElectrum(electrumPieces);
		display.setGold(goldPieces);
		display.setPlatinum(platinumPieces);
		display.setProficiencyBonus(proficiencyBonus);
		display.setArmorClass(effectiveArmorClass);
		display.setStrength(totalStrength);
		display.setDexterity(totalDexterity);
		display.setConstitution(totalConstitution);
		display.setIntelligence(totalIntelligence);
		display.setWisdom(totalWisdom);
		display.setCharisma(totalCharisma);
		display.setBackground(background);
		display.setRace(race);
		display.setBaseRace(baseRace);
		display.setSize(size);	
		
		List<String> classes = new ArrayList<>();
		for(CharacterClass myClass : characterClasses) {
			classes.add(myClass.getName() + " " + myClass.getLevel());
		}		
		display.setTotalLevel(totalLevel);
		display.setCharacterClasses(classes);
		display.setMaxHp(maxHitPoints);
		display.setHp(currentHitPoints);
		display.setTempHp(temporaryHitPoints);
		
		return display;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CharacterSheet other = (CharacterSheet) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
}