package com.patrickborrelli.dndiscord.model.dndiscord;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.patrickborrelli.dndiscord.model.DiscordUser;

/**
 * Model of dDnDiscord Character Sheet entry.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterSheet {
	
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
	
	//Ability Scores:
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
	
	//saving throws:
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
	private String size;
	private int walkSpeed;
	private int flySpeed;
	private int burrowSpeed;
	private int swimSpeed;
	private int climbSpeed;
	private int racialStrengthMod;
	private int racialDexterityMod;
	private int racialConstitutionMod;
	private int racialWisdomMod;
	private int racialIntelligenceMod;
	private int racialCharismaMod;
	
	//Classes and subclasses and related traits:
	private List<CharacterClass> characterClasses;
	private int totalLevel;
	private String subclass;
	private int maxHitPoints;
	private int currentHitPoints;
	private int temporaryHitPoints;
	private int hitDiceBase;
	private int currentHitDice;
	
	//attacks and actions:
	private int attackCount;
	private int attacksUsed;
	private List<Attack> attacks;		
	
	public CharacterSheet() {
		
	}

	/**
	 * @return the sheetSource
	 */
	public String getSheetSource() {
		return sheetSource;
	}

	/**
	 * @param sheetSource the sheetSource to set
	 */
	public void setSheetSource(String sheetSource) {
		this.sheetSource = sheetSource;
	}

	/**
	 * @return the user
	 */
	public DiscordUser getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(DiscordUser user) {
		this.user = user;
	}

	/**
	 * @return the characterName
	 */
	public String getCharacterName() {
		return characterName;
	}

	/**
	 * @param characterName the characterName to set
	 */
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	/**
	 * @return the avatarUrl
	 */
	public String getAvatarUrl() {
		return avatarUrl;
	}

	/**
	 * @param avatarUrl the avatarUrl to set
	 */
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	/**
	 * @return the faith
	 */
	public String getFaith() {
		return faith;
	}

	/**
	 * @param faith the faith to set
	 */
	public void setFaith(String faith) {
		this.faith = faith;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the hair
	 */
	public String getHair() {
		return hair;
	}

	/**
	 * @param hair the hair to set
	 */
	public void setHair(String hair) {
		this.hair = hair;
	}

	/**
	 * @return the skin
	 */
	public String getSkin() {
		return skin;
	}

	/**
	 * @param skin the skin to set
	 */
	public void setSkin(String skin) {
		this.skin = skin;
	}

	/**
	 * @return the height
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(String height) {
		this.height = height;
	}

	/**
	 * @return the weight
	 */
	public String getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}

	/**
	 * @return the inspiration
	 */
	public boolean isInspiration() {
		return inspiration;
	}

	/**
	 * @param inspiration the inspiration to set
	 */
	public void setInspiration(boolean inspiration) {
		this.inspiration = inspiration;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the experiencePoints
	 */
	public int getExperiencePoints() {
		return experiencePoints;
	}

	/**
	 * @param experiencePoints the experiencePoints to set
	 */
	public void setExperiencePoints(int experiencePoints) {
		this.experiencePoints = experiencePoints;
	}

	/**
	 * @return the alignment
	 */
	public String getAlignment() {
		return alignment;
	}

	/**
	 * @param alignment the alignment to set
	 */
	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}

	/**
	 * @return the lifestyle
	 */
	public String getLifestyle() {
		return lifestyle;
	}

	/**
	 * @param lifestyle the lifestyle to set
	 */
	public void setLifestyle(String lifestyle) {
		this.lifestyle = lifestyle;
	}

	/**
	 * @return the personalityTraits
	 */
	public String getPersonalityTraits() {
		return personalityTraits;
	}

	/**
	 * @param personalityTraits the personalityTraits to set
	 */
	public void setPersonalityTraits(String personalityTraits) {
		this.personalityTraits = personalityTraits;
	}

	/**
	 * @return the ideals
	 */
	public String getIdeals() {
		return ideals;
	}

	/**
	 * @param ideals the ideals to set
	 */
	public void setIdeals(String ideals) {
		this.ideals = ideals;
	}

	/**
	 * @return the bonds
	 */
	public String getBonds() {
		return bonds;
	}

	/**
	 * @param bonds the bonds to set
	 */
	public void setBonds(String bonds) {
		this.bonds = bonds;
	}

	/**
	 * @return the flaws
	 */
	public String getFlaws() {
		return flaws;
	}

	/**
	 * @param flaws the flaws to set
	 */
	public void setFlaws(String flaws) {
		this.flaws = flaws;
	}

	/**
	 * @return the appearance
	 */
	public String getAppearance() {
		return appearance;
	}

	/**
	 * @param appearance the appearance to set
	 */
	public void setAppearance(String appearance) {
		this.appearance = appearance;
	}

	/**
	 * @return the copperPieces
	 */
	public int getCopperPieces() {
		return copperPieces;
	}

	/**
	 * @param copperPieces the copperPieces to set
	 */
	public void setCopperPieces(int copperPieces) {
		this.copperPieces = copperPieces;
	}

	/**
	 * @return the silverPieces
	 */
	public int getSilverPieces() {
		return silverPieces;
	}

	/**
	 * @param silverPieces the silverPieces to set
	 */
	public void setSilverPieces(int silverPieces) {
		this.silverPieces = silverPieces;
	}

	/**
	 * @return the electrumPieces
	 */
	public int getElectrumPieces() {
		return electrumPieces;
	}

	/**
	 * @param electrumPieces the electrumPieces to set
	 */
	public void setElectrumPieces(int electrumPieces) {
		this.electrumPieces = electrumPieces;
	}

	/**
	 * @return the goldPieces
	 */
	public int getGoldPieces() {
		return goldPieces;
	}

	/**
	 * @param goldPieces the goldPieces to set
	 */
	public void setGoldPieces(int goldPieces) {
		this.goldPieces = goldPieces;
	}

	/**
	 * @return the platinumPieces
	 */
	public int getPlatinumPieces() {
		return platinumPieces;
	}

	/**
	 * @param platinumPieces the platinumPieces to set
	 */
	public void setPlatinumPieces(int platinumPieces) {
		this.platinumPieces = platinumPieces;
	}

	/**
	 * @return the baseStrength
	 */
	public int getBaseStrength() {
		return baseStrength;
	}

	/**
	 * @param baseStrength the baseStrength to set
	 */
	public void setBaseStrength(int baseStrength) {
		this.baseStrength = baseStrength;
		this.totalStrength = baseStrength + strengthBonus;
	}

	/**
	 * @return the baseDexterity
	 */
	public int getBaseDexterity() {
		return baseDexterity;
	}

	/**
	 * @param baseDexterity the baseDexterity to set
	 */
	public void setBaseDexterity(int baseDexterity) {
		this.baseDexterity = baseDexterity;
		this.totalDexterity = baseDexterity + dexterityBonus;
	}

	/**
	 * @return the baseConstitution
	 */
	public int getBaseConstitution() {
		return baseConstitution;
	}

	/**
	 * @param baseConstitution the baseConstitution to set
	 */
	public void setBaseConstitution(int baseConstitution) {
		this.baseConstitution = baseConstitution;
		this.totalConstitution = baseConstitution + constitutionBonus;
	}

	/**
	 * @return the baseIntelligence
	 */
	public int getBaseIntelligence() {
		return baseIntelligence;
	}

	/**
	 * @param baseIntelligence the baseIntelligence to set
	 */
	public void setBaseIntelligence(int baseIntelligence) {
		this.baseIntelligence = baseIntelligence;
		this.totalIntelligence = baseIntelligence + intelligenceBonus;
	}

	/**
	 * @return the baseWisdom
	 */
	public int getBaseWisdom() {
		return baseWisdom;
	}

	/**
	 * @param baseWisdom the baseWisdom to set
	 */
	public void setBaseWisdom(int baseWisdom) {
		this.baseWisdom = baseWisdom;
		this.totalWisdom = baseWisdom + wisdomBonus;
	}

	/**
	 * @return the baseCharisma
	 */
	public int getBaseCharisma() {
		return baseCharisma;
	}

	/**
	 * @param baseCharisma the baseCharisma to set
	 */
	public void setBaseCharisma(int baseCharisma) {
		this.baseCharisma = baseCharisma;
		this.totalCharisma = baseCharisma + charismaBonus;
	}

	/**
	 * @return the strengthBonus
	 */
	public int getStrengthBonus() {
		return strengthBonus;
	}

	/**
	 * @param strengthBonus the strengthBonus to set
	 */
	public void setStrengthBonus(int strengthBonus) {
		this.strengthBonus = strengthBonus;
		this.totalStrength = baseStrength + strengthBonus;
	}

	/**
	 * @return the dexterityBonus
	 */
	public int getDexterityBonus() {
		return dexterityBonus;
	}

	/**
	 * @param dexterityBonus the dexterityBonus to set
	 */
	public void setDexterityBonus(int dexterityBonus) {
		this.dexterityBonus = dexterityBonus;
		this.totalDexterity = baseDexterity + dexterityBonus;
	}

	/**
	 * @return the constitutionBonus
	 */
	public int getConstitutionBonus() {
		return constitutionBonus;
	}

	/**
	 * @param constitutionBonus the constitutionBonus to set
	 */
	public void setConstitutionBonus(int constitutionBonus) {
		this.constitutionBonus = constitutionBonus;
		this.totalConstitution = baseConstitution + constitutionBonus;
	}

	/**
	 * @return the intelligenceBonus
	 */
	public int getIntelligenceBonus() {
		return intelligenceBonus;
	}

	/**
	 * @param intelligenceBonus the intelligenceBonus to set
	 */
	public void setIntelligenceBonus(int intelligenceBonus) {
		this.intelligenceBonus = intelligenceBonus;
		this.totalIntelligence = baseIntelligence + intelligenceBonus;
	}

	/**
	 * @return the wisdomBonus
	 */
	public int getWisdomBonus() {
		return wisdomBonus;
	}

	/**
	 * @param wisdomBonus the wisdomBonus to set
	 */
	public void setWisdomBonus(int wisdomBonus) {
		this.wisdomBonus = wisdomBonus;
		this.totalWisdom = baseWisdom + wisdomBonus;
	}

	/**
	 * @return the charismaBonus
	 */
	public int getCharismaBonus() {
		return charismaBonus;
	}

	/**
	 * @param charismaBonus the charismaBonus to set
	 */
	public void setCharismaBonus(int charismaBonus) {
		this.charismaBonus = charismaBonus;
		this.totalCharisma = baseCharisma + charismaBonus;
	}

	/**
	 * @return the totalStrength
	 */
	public int getTotalStrength() {
		return totalStrength;
	}

	/**
	 * @param totalStrength the totalStrength to set
	 */
	public void setTotalStrength(int totalStrength) {
		this.totalStrength = totalStrength;
	}

	/**
	 * @return the totalDexterity
	 */
	public int getTotalDexterity() {
		return totalDexterity;
	}

	/**
	 * @param totalDexterity the totalDexterity to set
	 */
	public void setTotalDexterity(int totalDexterity) {
		this.totalDexterity = totalDexterity;
	}

	/**
	 * @return the totalConstitution
	 */
	public int getTotalConstitution() {
		return totalConstitution;
	}

	/**
	 * @param totalConstitution the totalConstitution to set
	 */
	public void setTotalConstitution(int totalConstitution) {
		this.totalConstitution = totalConstitution;
	}

	/**
	 * @return the totalIntelligence
	 */
	public int getTotalIntelligence() {
		return totalIntelligence;
	}

	/**
	 * @param totalIntelligence the totalIntelligence to set
	 */
	public void setTotalIntelligence(int totalIntelligence) {
		this.totalIntelligence = totalIntelligence;
	}

	/**
	 * @return the totalWisdom
	 */
	public int getTotalWisdom() {
		return totalWisdom;
	}

	/**
	 * @param totalWisdom the totalWisdom to set
	 */
	public void setTotalWisdom(int totalWisdom) {
		this.totalWisdom = totalWisdom;
	}

	/**
	 * @return the totalCharisma
	 */
	public int getTotalCharisma() {
		return totalCharisma;
	}

	/**
	 * @param totalCharisma the totalCharisma to set
	 */
	public void setTotalCharisma(int totalCharisma) {
		this.totalCharisma = totalCharisma;
	}

	/**
	 * @return the strengthMod
	 */
	public int getStrengthMod() {
		return strengthMod;
	}

	/**
	 * @param strengthMod the strengthMod to set
	 */
	public void setStrengthMod(int strengthMod) {
		this.strengthMod = strengthMod;
	}

	/**
	 * @return the dexterityMod
	 */
	public int getDexterityMod() {
		return dexterityMod;
	}

	/**
	 * @param dexterityMod the dexterityMod to set
	 */
	public void setDexterityMod(int dexterityMod) {
		this.dexterityMod = dexterityMod;
	}

	/**
	 * @return the constitutionMod
	 */
	public int getConstitutionMod() {
		return constitutionMod;
	}

	/**
	 * @param constitutionMod the constitutionMod to set
	 */
	public void setConstitutionMod(int constitutionMod) {
		this.constitutionMod = constitutionMod;
	}

	/**
	 * @return the intelligenceMod
	 */
	public int getIntelligenceMod() {
		return intelligenceMod;
	}

	/**
	 * @param intelligenceMod the intelligenceMod to set
	 */
	public void setIntelligenceMod(int intelligenceMod) {
		this.intelligenceMod = intelligenceMod;
	}

	/**
	 * @return the wisdomMod
	 */
	public int getWisdomMod() {
		return wisdomMod;
	}

	/**
	 * @param wisdomMod the wisdomMod to set
	 */
	public void setWisdomMod(int wisdomMod) {
		this.wisdomMod = wisdomMod;
	}

	/**
	 * @return the charismaMod
	 */
	public int getCharismaMod() {
		return charismaMod;
	}

	/**
	 * @param charismaMod the charismaMod to set
	 */
	public void setCharismaMod(int charismaMod) {
		this.charismaMod = charismaMod;
	}

	/**
	 * @return the strengthSave
	 */
	public int getStrengthSave() {
		return strengthSave;
	}

	/**
	 * @param strengthSave the strengthSave to set
	 */
	public void setStrengthSave(int strengthSave) {
		this.strengthSave = strengthSave;
	}

	/**
	 * @return the dexteritySave
	 */
	public int getDexteritySave() {
		return dexteritySave;
	}

	/**
	 * @param dexteritySave the dexteritySave to set
	 */
	public void setDexteritySave(int dexteritySave) {
		this.dexteritySave = dexteritySave;
	}

	/**
	 * @return the constitutionSave
	 */
	public int getConstitutionSave() {
		return constitutionSave;
	}

	/**
	 * @param constitutionSave the constitutionSave to set
	 */
	public void setConstitutionSave(int constitutionSave) {
		this.constitutionSave = constitutionSave;
	}

	/**
	 * @return the intelligenceSave
	 */
	public int getIntelligenceSave() {
		return intelligenceSave;
	}

	/**
	 * @param intelligenceSave the intelligenceSave to set
	 */
	public void setIntelligenceSave(int intelligenceSave) {
		this.intelligenceSave = intelligenceSave;
	}

	/**
	 * @return the wisdomSave
	 */
	public int getWisdomSave() {
		return wisdomSave;
	}

	/**
	 * @param wisdomSave the wisdomSave to set
	 */
	public void setWisdomSave(int wisdomSave) {
		this.wisdomSave = wisdomSave;
	}

	/**
	 * @return the charismaSave
	 */
	public int getCharismaSave() {
		return charismaSave;
	}

	/**
	 * @param charismaSave the charismaSave to set
	 */
	public void setCharismaSave(int charismaSave) {
		this.charismaSave = charismaSave;
	}

	/**
	 * @return the strengthSaveProficiency
	 */
	public boolean isStrengthSaveProficiency() {
		return strengthSaveProficiency;
	}

	/**
	 * @param strengthSaveProficiency the strengthSaveProficiency to set
	 */
	public void setStrengthSaveProficiency(boolean strengthSaveProficiency) {
		this.strengthSaveProficiency = strengthSaveProficiency;
	}

	/**
	 * @return the dexteritySaveProficiency
	 */
	public boolean isDexteritySaveProficiency() {
		return dexteritySaveProficiency;
	}

	/**
	 * @param dexteritySaveProficiency the dexteritySaveProficiency to set
	 */
	public void setDexteritySaveProficiency(boolean dexteritySaveProficiency) {
		this.dexteritySaveProficiency = dexteritySaveProficiency;
	}

	/**
	 * @return the constitutionSaveProficiency
	 */
	public boolean isConstitutionSaveProficiency() {
		return constitutionSaveProficiency;
	}

	/**
	 * @param constitutionSaveProficiency the constitutionSaveProficiency to set
	 */
	public void setConstitutionSaveProficiency(boolean constitutionSaveProficiency) {
		this.constitutionSaveProficiency = constitutionSaveProficiency;
	}

	/**
	 * @return the intelligenceSaveProficiency
	 */
	public boolean isIntelligenceSaveProficiency() {
		return intelligenceSaveProficiency;
	}

	/**
	 * @param intelligenceSaveProficiency the intelligenceSaveProficiency to set
	 */
	public void setIntelligenceSaveProficiency(boolean intelligenceSaveProficiency) {
		this.intelligenceSaveProficiency = intelligenceSaveProficiency;
	}

	/**
	 * @return the wisdomSaveProficiency
	 */
	public boolean isWisdomSaveProficiency() {
		return wisdomSaveProficiency;
	}

	/**
	 * @param wisdomSaveProficiency the wisdomSaveProficiency to set
	 */
	public void setWisdomSaveProficiency(boolean wisdomSaveProficiency) {
		this.wisdomSaveProficiency = wisdomSaveProficiency;
	}

	/**
	 * @return the charismaSaveProficiency
	 */
	public boolean isCharismaSaveProficiency() {
		return charismaSaveProficiency;
	}

	/**
	 * @param charismaSaveProficiency the charismaSaveProficiency to set
	 */
	public void setCharismaSaveProficiency(boolean charismaSaveProficiency) {
		this.charismaSaveProficiency = charismaSaveProficiency;
	}
	
	/**
	 * @return the acrobaticsMod
	 */
	public int getAcrobaticsMod() {
		return acrobaticsMod;
	}

	/**
	 * @param acrobaticsMod the acrobaticsMod to set
	 */
	public void setAcrobaticsMod(int acrobaticsMod) {
		this.acrobaticsMod = acrobaticsMod;
	}

	/**
	 * @return the animalHandlingMod
	 */
	public int getAnimalHandlingMod() {
		return animalHandlingMod;
	}

	/**
	 * @param animalHandlingMod the animalHandlingMod to set
	 */
	public void setAnimalHandlingMod(int animalHandlingMod) {
		this.animalHandlingMod = animalHandlingMod;
	}

	/**
	 * @return the arcanaMod
	 */
	public int getArcanaMod() {
		return arcanaMod;
	}

	/**
	 * @param arcanaMod the arcanaMod to set
	 */
	public void setArcanaMod(int arcanaMod) {
		this.arcanaMod = arcanaMod;
	}

	/**
	 * @return the athleticsMod
	 */
	public int getAthleticsMod() {
		return athleticsMod;
	}

	/**
	 * @param athleticsMod the athleticsMod to set
	 */
	public void setAthleticsMod(int athleticsMod) {
		this.athleticsMod = athleticsMod;
	}

	/**
	 * @return the deceptionMod
	 */
	public int getDeceptionMod() {
		return deceptionMod;
	}

	/**
	 * @param deceptionMod the deceptionMod to set
	 */
	public void setDeceptionMod(int deceptionMod) {
		this.deceptionMod = deceptionMod;
	}

	/**
	 * @return the historyMod
	 */
	public int getHistoryMod() {
		return historyMod;
	}

	/**
	 * @param historyMod the historyMod to set
	 */
	public void setHistoryMod(int historyMod) {
		this.historyMod = historyMod;
	}

	/**
	 * @return the insightMod
	 */
	public int getInsightMod() {
		return insightMod;
	}

	/**
	 * @param insightMod the insightMod to set
	 */
	public void setInsightMod(int insightMod) {
		this.insightMod = insightMod;
	}

	/**
	 * @return the intimidationMod
	 */
	public int getIntimidationMod() {
		return intimidationMod;
	}

	/**
	 * @param intimidationMod the intimidationMod to set
	 */
	public void setIntimidationMod(int intimidationMod) {
		this.intimidationMod = intimidationMod;
	}

	/**
	 * @return the investigationMod
	 */
	public int getInvestigationMod() {
		return investigationMod;
	}

	/**
	 * @param investigationMod the investigationMod to set
	 */
	public void setInvestigationMod(int investigationMod) {
		this.investigationMod = investigationMod;
	}

	/**
	 * @return the medicineMod
	 */
	public int getMedicineMod() {
		return medicineMod;
	}

	/**
	 * @param medicineMod the medicineMod to set
	 */
	public void setMedicineMod(int medicineMod) {
		this.medicineMod = medicineMod;
	}

	/**
	 * @return the natureMod
	 */
	public int getNatureMod() {
		return natureMod;
	}

	/**
	 * @param natureMod the natureMod to set
	 */
	public void setNatureMod(int natureMod) {
		this.natureMod = natureMod;
	}

	/**
	 * @return the perceptionMod
	 */
	public int getPerceptionMod() {
		return perceptionMod;
	}

	/**
	 * @param perceptionMod the perceptionMod to set
	 */
	public void setPerceptionMod(int perceptionMod) {
		this.perceptionMod = perceptionMod;
	}

	/**
	 * @return the performanceMod
	 */
	public int getPerformanceMod() {
		return performanceMod;
	}

	/**
	 * @param performanceMod the performanceMod to set
	 */
	public void setPerformanceMod(int performanceMod) {
		this.performanceMod = performanceMod;
	}

	/**
	 * @return the persuasionMod
	 */
	public int getPersuasionMod() {
		return persuasionMod;
	}

	/**
	 * @param persuasionMod the persuasionMod to set
	 */
	public void setPersuasionMod(int persuasionMod) {
		this.persuasionMod = persuasionMod;
	}

	/**
	 * @return the religionMod
	 */
	public int getReligionMod() {
		return religionMod;
	}

	/**
	 * @param religionMod the religionMod to set
	 */
	public void setReligionMod(int religionMod) {
		this.religionMod = religionMod;
	}

	/**
	 * @return the sleightOfHandMod
	 */
	public int getSleightOfHandMod() {
		return sleightOfHandMod;
	}

	/**
	 * @param sleightOfHandMod the sleightOfHandMod to set
	 */
	public void setSleightOfHandMod(int sleightOfHandMod) {
		this.sleightOfHandMod = sleightOfHandMod;
	}

	/**
	 * @return the stealthMod
	 */
	public int getStealthMod() {
		return stealthMod;
	}

	/**
	 * @param stealthMod the stealthMod to set
	 */
	public void setStealthMod(int stealthMod) {
		this.stealthMod = stealthMod;
	}

	/**
	 * @return the survivalMod
	 */
	public int getSurvivalMod() {
		return survivalMod;
	}

	/**
	 * @param survivalMod the survivalMod to set
	 */
	public void setSurvivalMod(int survivalMod) {
		this.survivalMod = survivalMod;
	}

	/**
	 * @return the acrobaticsProficiency
	 */
	public boolean isAcrobaticsProficiency() {
		return acrobaticsProficiency;
	}

	/**
	 * @param acrobaticsProficiency the acrobaticsProficiency to set
	 */
	public void setAcrobaticsProficiency(boolean acrobaticsProficiency) {
		this.acrobaticsProficiency = acrobaticsProficiency;
	}

	/**
	 * @return the animalHandlingProficiency
	 */
	public boolean isAnimalHandlingProficiency() {
		return animalHandlingProficiency;
	}

	/**
	 * @param animalHandlingProficiency the animalHandlingProficiency to set
	 */
	public void setAnimalHandlingProficiency(boolean animalHandlingProficiency) {
		this.animalHandlingProficiency = animalHandlingProficiency;
	}

	/**
	 * @return the arcanaProficiency
	 */
	public boolean isArcanaProficiency() {
		return arcanaProficiency;
	}

	/**
	 * @param arcanaProficiency the arcanaProficiency to set
	 */
	public void setArcanaProficiency(boolean arcanaProficiency) {
		this.arcanaProficiency = arcanaProficiency;
	}

	/**
	 * @return the athleticsProficiency
	 */
	public boolean isAthleticsProficiency() {
		return athleticsProficiency;
	}

	/**
	 * @param athleticsProficiency the athleticsProficiency to set
	 */
	public void setAthleticsProficiency(boolean athleticsProficiency) {
		this.athleticsProficiency = athleticsProficiency;
	}

	/**
	 * @return the deceptionProficiency
	 */
	public boolean isDeceptionProficiency() {
		return deceptionProficiency;
	}

	/**
	 * @param deceptionProficiency the deceptionProficiency to set
	 */
	public void setDeceptionProficiency(boolean deceptionProficiency) {
		this.deceptionProficiency = deceptionProficiency;
	}

	/**
	 * @return the historyProficiency
	 */
	public boolean isHistoryProficiency() {
		return historyProficiency;
	}

	/**
	 * @param historyProficiency the historyProficiency to set
	 */
	public void setHistoryProficiency(boolean historyProficiency) {
		this.historyProficiency = historyProficiency;
	}

	/**
	 * @return the insightProficiency
	 */
	public boolean isInsightProficiency() {
		return insightProficiency;
	}

	/**
	 * @param insightProficiency the insightProficiency to set
	 */
	public void setInsightProficiency(boolean insightProficiency) {
		this.insightProficiency = insightProficiency;
	}

	/**
	 * @return the intimidationProficiency
	 */
	public boolean isIntimidationProficiency() {
		return intimidationProficiency;
	}

	/**
	 * @param intimidationProficiency the intimidationProficiency to set
	 */
	public void setIntimidationProficiency(boolean intimidationProficiency) {
		this.intimidationProficiency = intimidationProficiency;
	}

	/**
	 * @return the investigationProficiency
	 */
	public boolean isInvestigationProficiency() {
		return investigationProficiency;
	}

	/**
	 * @param investigationProficiency the investigationProficiency to set
	 */
	public void setInvestigationProficiency(boolean investigationProficiency) {
		this.investigationProficiency = investigationProficiency;
	}

	/**
	 * @return the medicineProficiency
	 */
	public boolean isMedicineProficiency() {
		return medicineProficiency;
	}

	/**
	 * @param medicineProficiency the medicineProficiency to set
	 */
	public void setMedicineProficiency(boolean medicineProficiency) {
		this.medicineProficiency = medicineProficiency;
	}

	/**
	 * @return the natureProficiency
	 */
	public boolean isNatureProficiency() {
		return natureProficiency;
	}

	/**
	 * @param natureProficiency the natureProficiency to set
	 */
	public void setNatureProficiency(boolean natureProficiency) {
		this.natureProficiency = natureProficiency;
	}

	/**
	 * @return the perceptionProficiency
	 */
	public boolean isPerceptionProficiency() {
		return perceptionProficiency;
	}

	/**
	 * @param perceptionProficiency the perceptionProficiency to set
	 */
	public void setPerceptionProficiency(boolean perceptionProficiency) {
		this.perceptionProficiency = perceptionProficiency;
	}

	/**
	 * @return the performanceProficiency
	 */
	public boolean isPerformanceProficiency() {
		return performanceProficiency;
	}

	/**
	 * @param performanceProficiency the performanceProficiency to set
	 */
	public void setPerformanceProficiency(boolean performanceProficiency) {
		this.performanceProficiency = performanceProficiency;
	}

	/**
	 * @return the persuasionProficiency
	 */
	public boolean isPersuasionProficiency() {
		return persuasionProficiency;
	}

	/**
	 * @param persuasionProficiency the persuasionProficiency to set
	 */
	public void setPersuasionProficiency(boolean persuasionProficiency) {
		this.persuasionProficiency = persuasionProficiency;
	}

	/**
	 * @return the religionProficiency
	 */
	public boolean isReligionProficiency() {
		return religionProficiency;
	}

	/**
	 * @param religionProficiency the religionProficiency to set
	 */
	public void setReligionProficiency(boolean religionProficiency) {
		this.religionProficiency = religionProficiency;
	}

	/**
	 * @return the sleightOfHandProficiency
	 */
	public boolean isSleightOfHandProficiency() {
		return sleightOfHandProficiency;
	}

	/**
	 * @param sleightOfHandProficiency the sleightOfHandProficiency to set
	 */
	public void setSleightOfHandProficiency(boolean sleightOfHandProficiency) {
		this.sleightOfHandProficiency = sleightOfHandProficiency;
	}

	/**
	 * @return the stealthProficiency
	 */
	public boolean isStealthProficiency() {
		return stealthProficiency;
	}

	/**
	 * @param stealthProficiency the stealthProficiency to set
	 */
	public void setStealthProficiency(boolean stealthProficiency) {
		this.stealthProficiency = stealthProficiency;
	}

	/**
	 * @return the survivalProficiency
	 */
	public boolean isSurvivalProficiency() {
		return survivalProficiency;
	}

	/**
	 * @param survivalProficiency the survivalProficiency to set
	 */
	public void setSurvivalProficiency(boolean survivalProficiency) {
		this.survivalProficiency = survivalProficiency;
	}

	/**
	 * @return the acrobaticsExpertise
	 */
	public boolean isAcrobaticsExpertise() {
		return acrobaticsExpertise;
	}

	/**
	 * @param acrobaticsExpertise the acrobaticsExpertise to set
	 */
	public void setAcrobaticsExpertise(boolean acrobaticsExpertise) {
		this.acrobaticsExpertise = acrobaticsExpertise;
	}

	/**
	 * @return the animalHandlingExpertise
	 */
	public boolean isAnimalHandlingExpertise() {
		return animalHandlingExpertise;
	}

	/**
	 * @param animalHandlingExpertise the animalHandlingExpertise to set
	 */
	public void setAnimalHandlingExpertise(boolean animalHandlingExpertise) {
		this.animalHandlingExpertise = animalHandlingExpertise;
	}

	/**
	 * @return the arcanaExpertise
	 */
	public boolean isArcanaExpertise() {
		return arcanaExpertise;
	}

	/**
	 * @param arcanaExpertise the arcanaExpertise to set
	 */
	public void setArcanaExpertise(boolean arcanaExpertise) {
		this.arcanaExpertise = arcanaExpertise;
	}

	/**
	 * @return the athleticsExpertise
	 */
	public boolean isAthleticsExpertise() {
		return athleticsExpertise;
	}

	/**
	 * @param athleticsExpertise the athleticsExpertise to set
	 */
	public void setAthleticsExpertise(boolean athleticsExpertise) {
		this.athleticsExpertise = athleticsExpertise;
	}

	/**
	 * @return the deceptionExpertise
	 */
	public boolean isDeceptionExpertise() {
		return deceptionExpertise;
	}

	/**
	 * @param deceptionExpertise the deceptionExpertise to set
	 */
	public void setDeceptionExpertise(boolean deceptionExpertise) {
		this.deceptionExpertise = deceptionExpertise;
	}

	/**
	 * @return the historyExpertise
	 */
	public boolean isHistoryExpertise() {
		return historyExpertise;
	}

	/**
	 * @param historyExpertise the historyExpertise to set
	 */
	public void setHistoryExpertise(boolean historyExpertise) {
		this.historyExpertise = historyExpertise;
	}

	/**
	 * @return the insightExpertise
	 */
	public boolean isInsightExpertise() {
		return insightExpertise;
	}

	/**
	 * @param insightExpertise the insightExpertise to set
	 */
	public void setInsightExpertise(boolean insightExpertise) {
		this.insightExpertise = insightExpertise;
	}

	/**
	 * @return the intimidationExpertise
	 */
	public boolean isIntimidationExpertise() {
		return intimidationExpertise;
	}

	/**
	 * @param intimidationExpertise the intimidationExpertise to set
	 */
	public void setIntimidationExpertise(boolean intimidationExpertise) {
		this.intimidationExpertise = intimidationExpertise;
	}

	/**
	 * @return the investigationExpertise
	 */
	public boolean isInvestigationExpertise() {
		return investigationExpertise;
	}

	/**
	 * @param investigationExpertise the investigationExpertise to set
	 */
	public void setInvestigationExpertise(boolean investigationExpertise) {
		this.investigationExpertise = investigationExpertise;
	}

	/**
	 * @return the medicineExpertise
	 */
	public boolean isMedicineExpertise() {
		return medicineExpertise;
	}

	/**
	 * @param medicineExpertise the medicineExpertise to set
	 */
	public void setMedicineExpertise(boolean medicineExpertise) {
		this.medicineExpertise = medicineExpertise;
	}

	/**
	 * @return the natureExpertise
	 */
	public boolean isNatureExpertise() {
		return natureExpertise;
	}

	/**
	 * @param natureExpertise the natureExpertise to set
	 */
	public void setNatureExpertise(boolean natureExpertise) {
		this.natureExpertise = natureExpertise;
	}

	/**
	 * @return the perceptionExpertise
	 */
	public boolean isPerceptionExpertise() {
		return perceptionExpertise;
	}

	/**
	 * @param perceptionExpertise the perceptionExpertise to set
	 */
	public void setPerceptionExpertise(boolean perceptionExpertise) {
		this.perceptionExpertise = perceptionExpertise;
	}

	/**
	 * @return the performanceExpertise
	 */
	public boolean isPerformanceExpertise() {
		return performanceExpertise;
	}

	/**
	 * @param performanceExpertise the performanceExpertise to set
	 */
	public void setPerformanceExpertise(boolean performanceExpertise) {
		this.performanceExpertise = performanceExpertise;
	}

	/**
	 * @return the persuasionExpertise
	 */
	public boolean isPersuasionExpertise() {
		return persuasionExpertise;
	}

	/**
	 * @param persuasionExpertise the persuasionExpertise to set
	 */
	public void setPersuasionExpertise(boolean persuasionExpertise) {
		this.persuasionExpertise = persuasionExpertise;
	}

	/**
	 * @return the religionExpertise
	 */
	public boolean isReligionExpertise() {
		return religionExpertise;
	}

	/**
	 * @param religionExpertise the religionExpertise to set
	 */
	public void setReligionExpertise(boolean religionExpertise) {
		this.religionExpertise = religionExpertise;
	}

	/**
	 * @return the sleightOfHandExpertise
	 */
	public boolean isSleightOfHandExpertise() {
		return sleightOfHandExpertise;
	}

	/**
	 * @param sleightOfHandExpertise the sleightOfHandExpertise to set
	 */
	public void setSleightOfHandExpertise(boolean sleightOfHandExpertise) {
		this.sleightOfHandExpertise = sleightOfHandExpertise;
	}

	/**
	 * @return the stealthExpertise
	 */
	public boolean isStealthExpertise() {
		return stealthExpertise;
	}

	/**
	 * @param stealthExpertise the stealthExpertise to set
	 */
	public void setStealthExpertise(boolean stealthExpertise) {
		this.stealthExpertise = stealthExpertise;
	}

	/**
	 * @return the survivalExpertise
	 */
	public boolean isSurvivalExpertise() {
		return survivalExpertise;
	}

	/**
	 * @param survivalExpertise the survivalExpertise to set
	 */
	public void setSurvivalExpertise(boolean survivalExpertise) {
		this.survivalExpertise = survivalExpertise;
	}

	/**
	 * @return the background
	 */
	public String getBackground() {
		return background;
	}

	/**
	 * @param background the background to set
	 */
	public void setBackground(String background) {
		this.background = background;
	}

	/**
	 * @return the race
	 */
	public String getRace() {
		return race;
	}

	/**
	 * @param race the race to set
	 */
	public void setRace(String race) {
		this.race = race;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * @return the walkSpeed
	 */
	public int getWalkSpeed() {
		return walkSpeed;
	}

	/**
	 * @param walkSpeed the walkSpeed to set
	 */
	public void setWalkSpeed(int walkSpeed) {
		this.walkSpeed = walkSpeed;
	}

	/**
	 * @return the flySpeed
	 */
	public int getFlySpeed() {
		return flySpeed;
	}

	/**
	 * @param flySpeed the flySpeed to set
	 */
	public void setFlySpeed(int flySpeed) {
		this.flySpeed = flySpeed;
	}

	/**
	 * @return the burrowSpeed
	 */
	public int getBurrowSpeed() {
		return burrowSpeed;
	}

	/**
	 * @param burrowSpeed the burrowSpeed to set
	 */
	public void setBurrowSpeed(int burrowSpeed) {
		this.burrowSpeed = burrowSpeed;
	}

	/**
	 * @return the swimSpeed
	 */
	public int getSwimSpeed() {
		return swimSpeed;
	}

	/**
	 * @param swimSpeed the swimSpeed to set
	 */
	public void setSwimSpeed(int swimSpeed) {
		this.swimSpeed = swimSpeed;
	}

	/**
	 * @return the climbSpeed
	 */
	public int getClimbSpeed() {
		return climbSpeed;
	}

	/**
	 * @param climbSpeed the climbSpeed to set
	 */
	public void setClimbSpeed(int climbSpeed) {
		this.climbSpeed = climbSpeed;
	}

	/**
	 * @return the racialStrengthMod
	 */
	public int getRacialStrengthMod() {
		return racialStrengthMod;
	}

	/**
	 * @param racialStrengthMod the racialStrengthMod to set
	 */
	public void setRacialStrengthMod(int racialStrengthMod) {
		this.racialStrengthMod = racialStrengthMod;
	}

	/**
	 * @return the racialDexterityMod
	 */
	public int getRacialDexterityMod() {
		return racialDexterityMod;
	}

	/**
	 * @param racialDexterityMod the racialDexterityMod to set
	 */
	public void setRacialDexterityMod(int racialDexterityMod) {
		this.racialDexterityMod = racialDexterityMod;
	}

	/**
	 * @return the racialConstitutionMod
	 */
	public int getRacialConstitutionMod() {
		return racialConstitutionMod;
	}

	/**
	 * @param racialConstitutionMod the racialConstitutionMod to set
	 */
	public void setRacialConstitutionMod(int racialConstitutionMod) {
		this.racialConstitutionMod = racialConstitutionMod;
	}

	/**
	 * @return the racialWisdomMod
	 */
	public int getRacialWisdomMod() {
		return racialWisdomMod;
	}

	/**
	 * @param racialWisdomMod the racialWisdomMod to set
	 */
	public void setRacialWisdomMod(int racialWisdomMod) {
		this.racialWisdomMod = racialWisdomMod;
	}

	/**
	 * @return the racialIntelligenceMod
	 */
	public int getRacialIntelligenceMod() {
		return racialIntelligenceMod;
	}

	/**
	 * @param racialIntelligenceMod the racialIntelligenceMod to set
	 */
	public void setRacialIntelligenceMod(int racialIntelligenceMod) {
		this.racialIntelligenceMod = racialIntelligenceMod;
	}

	/**
	 * @return the racialCharismaMod
	 */
	public int getRacialCharismaMod() {
		return racialCharismaMod;
	}

	/**
	 * @param racialCharismaMod the racialCharismaMod to set
	 */
	public void setRacialCharismaMod(int racialCharismaMod) {
		this.racialCharismaMod = racialCharismaMod;
	}

	/**
	 * @return the characterClasses
	 */
	public List<CharacterClass> getCharacterClasses() {
		return characterClasses;
	}

	/**
	 * @param characterClasses the characterClasses to set
	 */
	public void setCharacterClasses(List<CharacterClass> characterClasses) {
		this.characterClasses = characterClasses;
	}

	/**
	 * @return the totalLevel
	 */
	public int getTotalLevel() {
		return totalLevel;
	}

	/**
	 * @param totalLevel the totalLevel to set
	 */
	public void setTotalLevel(int totalLevel) {
		this.totalLevel = totalLevel;
	}

	/**
	 * @return the subclass
	 */
	public String getSubclass() {
		return subclass;
	}

	/**
	 * @param subclass the subclass to set
	 */
	public void setSubclass(String subclass) {
		this.subclass = subclass;
	}

	/**
	 * @return the maxHitPoints
	 */
	public int getMaxHitPoints() {
		return maxHitPoints;
	}

	/**
	 * @param maxHitPoints the maxHitPoints to set
	 */
	public void setMaxHitPoints(int maxHitPoints) {
		this.maxHitPoints = maxHitPoints;
	}

	/**
	 * @return the currentHitPoints
	 */
	public int getCurrentHitPoints() {
		return currentHitPoints;
	}

	/**
	 * @param currentHitPoints the currentHitPoints to set
	 */
	public void setCurrentHitPoints(int currentHitPoints) {
		this.currentHitPoints = currentHitPoints;
	}

	/**
	 * @return the temporaryHitPoints
	 */
	public int getTemporaryHitPoints() {
		return temporaryHitPoints;
	}

	/**
	 * @param temporaryHitPoints the temporaryHitPoints to set
	 */
	public void setTemporaryHitPoints(int temporaryHitPoints) {
		this.temporaryHitPoints = temporaryHitPoints;
	}

	/**
	 * @return the hitDiceBase
	 */
	public int getHitDiceBase() {
		return hitDiceBase;
	}

	/**
	 * @param hitDiceBase the hitDiceBase to set
	 */
	public void setHitDiceBase(int hitDiceBase) {
		this.hitDiceBase = hitDiceBase;
	}

	/**
	 * @return the currentHitDice
	 */
	public int getCurrentHitDice() {
		return currentHitDice;
	}

	/**
	 * @param currentHitDice the currentHitDice to set
	 */
	public void setCurrentHitDice(int currentHitDice) {
		this.currentHitDice = currentHitDice;
	}

	/**
	 * @return the attackCount
	 */
	public int getAttackCount() {
		return attackCount;
	}

	/**
	 * @param attackCount the attackCount to set
	 */
	public void setAttackCount(int attackCount) {
		this.attackCount = attackCount;
	}

	/**
	 * @return the attacksUsed
	 */
	public int getAttacksUsed() {
		return attacksUsed;
	}

	/**
	 * @param attacksUsed the attacksUsed to set
	 */
	public void setAttacksUsed(int attacksUsed) {
		this.attacksUsed = attacksUsed;
	}

	/**
	 * @return the attacks
	 */
	public List<Attack> getAttacks() {
		return attacks;
	}

	/**
	 * @param attacks the attacks to set
	 */
	public void setAttacks(List<Attack> attacks) {
		this.attacks = attacks;
	}

	@Override
	public String toString() {
		return "CharacterSheet [sheetSource=" + sheetSource + ", user=" + user + ", characterName=" + characterName
				+ ", avatarUrl=" + avatarUrl + ", faith=" + faith + ", age=" + age + ", hair=" + hair + ", skin=" + skin
				+ ", height=" + height + ", weight=" + weight + ", inspiration=" + inspiration + ", gender=" + gender
				+ ", experiencePoints=" + experiencePoints + ", alignment=" + alignment + ", lifestyle=" + lifestyle
				+ ", personalityTraits=" + personalityTraits + ", ideals=" + ideals + ", bonds=" + bonds + ", flaws="
				+ flaws + ", appearance=" + appearance + ", copperPieces=" + copperPieces + ", silverPieces="
				+ silverPieces + ", electrumPieces=" + electrumPieces + ", goldPieces=" + goldPieces
				+ ", platinumPieces=" + platinumPieces + ", baseStrength=" + baseStrength + ", baseDexterity="
				+ baseDexterity + ", baseConstitution=" + baseConstitution + ", baseIntelligence=" + baseIntelligence
				+ ", baseWisdom=" + baseWisdom + ", baseCharisma=" + baseCharisma + ", strengthBonus=" + strengthBonus
				+ ", dexterityBonus=" + dexterityBonus + ", constitutionBonus=" + constitutionBonus
				+ ", intelligenceBonus=" + intelligenceBonus + ", wisdomBonus=" + wisdomBonus + ", charismaBonus="
				+ charismaBonus + ", totalStrength=" + totalStrength + ", totalDexterity=" + totalDexterity
				+ ", totalConstitution=" + totalConstitution + ", totalIntelligence=" + totalIntelligence
				+ ", totalWisdom=" + totalWisdom + ", totalCharisma=" + totalCharisma + ", strengthMod=" + strengthMod
				+ ", dexterityMod=" + dexterityMod + ", constitutionMod=" + constitutionMod + ", intelligenceMod="
				+ intelligenceMod + ", wisdomMod=" + wisdomMod + ", charismaMod=" + charismaMod + ", strengthSave="
				+ strengthSave + ", dexteritySave=" + dexteritySave + ", constitutionSave=" + constitutionSave
				+ ", intelligenceSave=" + intelligenceSave + ", wisdomSave=" + wisdomSave + ", charismaSave="
				+ charismaSave + ", strengthSaveProficiency=" + strengthSaveProficiency + ", dexteritySaveProficiency="
				+ dexteritySaveProficiency + ", constitutionSaveProficiency=" + constitutionSaveProficiency
				+ ", intelligenceSaveProficiency=" + intelligenceSaveProficiency + ", wisdomSaveProficiency="
				+ wisdomSaveProficiency + ", charismaSaveProficiency=" + charismaSaveProficiency + ", acrobaticsMod="
				+ acrobaticsMod + ", animalHandlingMod=" + animalHandlingMod + ", arcanaMod=" + arcanaMod
				+ ", athleticsMod=" + athleticsMod + ", deceptionMod=" + deceptionMod + ", historyMod=" + historyMod
				+ ", insightMod=" + insightMod + ", intimidationMod=" + intimidationMod + ", investigationMod="
				+ investigationMod + ", medicineMod=" + medicineMod + ", natureMod=" + natureMod + ", perceptionMod="
				+ perceptionMod + ", performanceMod=" + performanceMod + ", persuasionMod=" + persuasionMod
				+ ", religionMod=" + religionMod + ", sleightOfHandMod=" + sleightOfHandMod + ", stealthMod="
				+ stealthMod + ", survivalMod=" + survivalMod + ", acrobaticsProficiency=" + acrobaticsProficiency
				+ ", animalHandlingProficiency=" + animalHandlingProficiency + ", arcanaProficiency="
				+ arcanaProficiency + ", athleticsProficiency=" + athleticsProficiency + ", deceptionProficiency="
				+ deceptionProficiency + ", historyProficiency=" + historyProficiency + ", insightProficiency="
				+ insightProficiency + ", intimidationProficiency=" + intimidationProficiency
				+ ", investigationProficiency=" + investigationProficiency + ", medicineProficiency="
				+ medicineProficiency + ", natureProficiency=" + natureProficiency + ", perceptionProficiency="
				+ perceptionProficiency + ", performanceProficiency=" + performanceProficiency
				+ ", persuasionProficiency=" + persuasionProficiency + ", religionProficiency=" + religionProficiency
				+ ", sleightOfHandProficiency=" + sleightOfHandProficiency + ", stealthProficiency="
				+ stealthProficiency + ", survivalProficiency=" + survivalProficiency + ", acrobaticsExpertise="
				+ acrobaticsExpertise + ", animalHandlingExpertise=" + animalHandlingExpertise + ", arcanaExpertise="
				+ arcanaExpertise + ", athleticsExpertise=" + athleticsExpertise + ", deceptionExpertise="
				+ deceptionExpertise + ", historyExpertise=" + historyExpertise + ", insightExpertise="
				+ insightExpertise + ", intimidationExpertise=" + intimidationExpertise + ", investigationExpertise="
				+ investigationExpertise + ", medicineExpertise=" + medicineExpertise + ", natureExpertise="
				+ natureExpertise + ", perceptionExpertise=" + perceptionExpertise + ", performanceExpertise="
				+ performanceExpertise + ", persuasionExpertise=" + persuasionExpertise + ", religionExpertise="
				+ religionExpertise + ", sleightOfHandExpertise=" + sleightOfHandExpertise + ", stealthExpertise="
				+ stealthExpertise + ", survivalExpertise=" + survivalExpertise + ", background=" + background
				+ ", race=" + race + ", size=" + size + ", walkSpeed=" + walkSpeed + ", flySpeed=" + flySpeed
				+ ", burrowSpeed=" + burrowSpeed + ", swimSpeed=" + swimSpeed + ", climbSpeed=" + climbSpeed
				+ ", racialStrengthMod=" + racialStrengthMod + ", racialDexterityMod=" + racialDexterityMod
				+ ", racialConstitutionMod=" + racialConstitutionMod + ", racialWisdomMod=" + racialWisdomMod
				+ ", racialIntelligenceMod=" + racialIntelligenceMod + ", racialCharismaMod=" + racialCharismaMod
				+ ", characterClasses=" + characterClasses + ", totalLevel=" + totalLevel + ", subclass=" + subclass
				+ ", maxHitPoints=" + maxHitPoints + ", currentHitPoints=" + currentHitPoints + ", temporaryHitPoints="
				+ temporaryHitPoints + ", hitDiceBase=" + hitDiceBase + ", currentHitDice=" + currentHitDice
				+ ", attackCount=" + attackCount + ", attacksUsed=" + attacksUsed + ", attacks=" + attacks + "]";
	}
}