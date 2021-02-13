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
	private int stStrength;
	private int stDexterity;
	private int stConstitution;
	private int stIntelligence;
	private int stWisdom;
	private int stCharisma;
	boolean pbStrength;
	boolean pbDexterity;
	boolean pbConstitution;
	boolean pbIntelligence;
	boolean pbWisdom;
	boolean pbCharisma;
	
	//skills:
	int spAcrobatics;
	int spAnimalHandling;
	int spArcana;
	int spAthletics;
	int spDeception;
	int spHistory;
	int spInsight;
	int spIntimidation;
	int spInvestigation;
	int spMedicine;
	int spNature;
	int spPerception;
	int spPerformance;
	int spPersuasion;
	int spReligion;
	int spSleightOfHand;
	int spStealth;
	int spSurvival;
	boolean pbAcrobatics;
	boolean pbAnimalHandling;
	boolean pbArcana;
	boolean pbAthletics;
	boolean pbDeception;
	boolean pbHistory;
	boolean pbInsight;
	boolean pbIntimidation;
	boolean pbInvestigation;
	boolean pbMedicine;
	boolean pbNature;
	boolean pbPerception;
	boolean pbPerformance;
	boolean pbPersuasion;
	boolean pbReligion;
	boolean pbSleightOfHand;
	boolean pbStealth;
	boolean pbSurvival;	
	
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
	 * @return the stStrength
	 */
	public int getStStrength() {
		return stStrength;
	}

	/**
	 * @param stStrength the stStrength to set
	 */
	public void setStStrength(int stStrength) {
		this.stStrength = stStrength;
	}

	/**
	 * @return the stDexterity
	 */
	public int getStDexterity() {
		return stDexterity;
	}

	/**
	 * @param stDexterity the stDexterity to set
	 */
	public void setStDexterity(int stDexterity) {
		this.stDexterity = stDexterity;
	}

	/**
	 * @return the stConstitution
	 */
	public int getStConstitution() {
		return stConstitution;
	}

	/**
	 * @param stConstitution the stConstitution to set
	 */
	public void setStConstitution(int stConstitution) {
		this.stConstitution = stConstitution;
	}

	/**
	 * @return the stIntelligence
	 */
	public int getStIntelligence() {
		return stIntelligence;
	}

	/**
	 * @param stIntelligence the stIntelligence to set
	 */
	public void setStIntelligence(int stIntelligence) {
		this.stIntelligence = stIntelligence;
	}

	/**
	 * @return the stWisdom
	 */
	public int getStWisdom() {
		return stWisdom;
	}

	/**
	 * @param stWisdom the stWisdom to set
	 */
	public void setStWisdom(int stWisdom) {
		this.stWisdom = stWisdom;
	}

	/**
	 * @return the stCharisma
	 */
	public int getStCharisma() {
		return stCharisma;
	}

	/**
	 * @param stCharisma the stCharisma to set
	 */
	public void setStCharisma(int stCharisma) {
		this.stCharisma = stCharisma;
	}

	/**
	 * @return the pbStrength
	 */
	public boolean isPbStrength() {
		return pbStrength;
	}

	/**
	 * @param pbStrength the pbStrength to set
	 */
	public void setPbStrength(boolean pbStrength) {
		this.pbStrength = pbStrength;
	}

	/**
	 * @return the pbDexterity
	 */
	public boolean isPbDexterity() {
		return pbDexterity;
	}

	/**
	 * @param pbDexterity the pbDexterity to set
	 */
	public void setPbDexterity(boolean pbDexterity) {
		this.pbDexterity = pbDexterity;
	}

	/**
	 * @return the pbConstitution
	 */
	public boolean isPbConstitution() {
		return pbConstitution;
	}

	/**
	 * @param pbConstitution the pbConstitution to set
	 */
	public void setPbConstitution(boolean pbConstitution) {
		this.pbConstitution = pbConstitution;
	}

	/**
	 * @return the pbIntelligence
	 */
	public boolean isPbIntelligence() {
		return pbIntelligence;
	}

	/**
	 * @param pbIntelligence the pbIntelligence to set
	 */
	public void setPbIntelligence(boolean pbIntelligence) {
		this.pbIntelligence = pbIntelligence;
	}

	/**
	 * @return the pbWisdom
	 */
	public boolean isPbWisdom() {
		return pbWisdom;
	}

	/**
	 * @param pbWisdom the pbWisdom to set
	 */
	public void setPbWisdom(boolean pbWisdom) {
		this.pbWisdom = pbWisdom;
	}

	/**
	 * @return the pbCharisma
	 */
	public boolean isPbCharisma() {
		return pbCharisma;
	}

	/**
	 * @param pbCharisma the pbCharisma to set
	 */
	public void setPbCharisma(boolean pbCharisma) {
		this.pbCharisma = pbCharisma;
	}

	/**
	 * @return the spAcrobatics
	 */
	public int getSpAcrobatics() {
		return spAcrobatics;
	}

	/**
	 * @param spAcrobatics the spAcrobatics to set
	 */
	public void setSpAcrobatics(int spAcrobatics) {
		this.spAcrobatics = spAcrobatics;
	}

	/**
	 * @return the spAnimalHandling
	 */
	public int getSpAnimalHandling() {
		return spAnimalHandling;
	}

	/**
	 * @param spAnimalHandling the spAnimalHandling to set
	 */
	public void setSpAnimalHandling(int spAnimalHandling) {
		this.spAnimalHandling = spAnimalHandling;
	}

	/**
	 * @return the spArcana
	 */
	public int getSpArcana() {
		return spArcana;
	}

	/**
	 * @param spArcana the spArcana to set
	 */
	public void setSpArcana(int spArcana) {
		this.spArcana = spArcana;
	}

	/**
	 * @return the spAthletics
	 */
	public int getSpAthletics() {
		return spAthletics;
	}

	/**
	 * @param spAthletics the spAthletics to set
	 */
	public void setSpAthletics(int spAthletics) {
		this.spAthletics = spAthletics;
	}

	/**
	 * @return the spDeception
	 */
	public int getSpDeception() {
		return spDeception;
	}

	/**
	 * @param spDeception the spDeception to set
	 */
	public void setSpDeception(int spDeception) {
		this.spDeception = spDeception;
	}

	/**
	 * @return the spHistory
	 */
	public int getSpHistory() {
		return spHistory;
	}

	/**
	 * @param spHistory the spHistory to set
	 */
	public void setSpHistory(int spHistory) {
		this.spHistory = spHistory;
	}

	/**
	 * @return the spInsight
	 */
	public int getSpInsight() {
		return spInsight;
	}

	/**
	 * @param spInsight the spInsight to set
	 */
	public void setSpInsight(int spInsight) {
		this.spInsight = spInsight;
	}

	/**
	 * @return the spIntimidation
	 */
	public int getSpIntimidation() {
		return spIntimidation;
	}

	/**
	 * @param spIntimidation the spIntimidation to set
	 */
	public void setSpIntimidation(int spIntimidation) {
		this.spIntimidation = spIntimidation;
	}

	/**
	 * @return the spInvestigation
	 */
	public int getSpInvestigation() {
		return spInvestigation;
	}

	/**
	 * @param spInvestigation the spInvestigation to set
	 */
	public void setSpInvestigation(int spInvestigation) {
		this.spInvestigation = spInvestigation;
	}

	/**
	 * @return the spMedicine
	 */
	public int getSpMedicine() {
		return spMedicine;
	}

	/**
	 * @param spMedicine the spMedicine to set
	 */
	public void setSpMedicine(int spMedicine) {
		this.spMedicine = spMedicine;
	}

	/**
	 * @return the spNature
	 */
	public int getSpNature() {
		return spNature;
	}

	/**
	 * @param spNature the spNature to set
	 */
	public void setSpNature(int spNature) {
		this.spNature = spNature;
	}

	/**
	 * @return the spPerception
	 */
	public int getSpPerception() {
		return spPerception;
	}

	/**
	 * @param spPerception the spPerception to set
	 */
	public void setSpPerception(int spPerception) {
		this.spPerception = spPerception;
	}

	/**
	 * @return the spPerformance
	 */
	public int getSpPerformance() {
		return spPerformance;
	}

	/**
	 * @param spPerformance the spPerformance to set
	 */
	public void setSpPerformance(int spPerformance) {
		this.spPerformance = spPerformance;
	}

	/**
	 * @return the spPersuasion
	 */
	public int getSpPersuasion() {
		return spPersuasion;
	}

	/**
	 * @param spPersuasion the spPersuasion to set
	 */
	public void setSpPersuasion(int spPersuasion) {
		this.spPersuasion = spPersuasion;
	}

	/**
	 * @return the spReligion
	 */
	public int getSpReligion() {
		return spReligion;
	}

	/**
	 * @param spReligion the spReligion to set
	 */
	public void setSpReligion(int spReligion) {
		this.spReligion = spReligion;
	}

	/**
	 * @return the spSleightOfHand
	 */
	public int getSpSleightOfHand() {
		return spSleightOfHand;
	}

	/**
	 * @param spSleightOfHand the spSleightOfHand to set
	 */
	public void setSpSleightOfHand(int spSleightOfHand) {
		this.spSleightOfHand = spSleightOfHand;
	}

	/**
	 * @return the spStealth
	 */
	public int getSpStealth() {
		return spStealth;
	}

	/**
	 * @param spStealth the spStealth to set
	 */
	public void setSpStealth(int spStealth) {
		this.spStealth = spStealth;
	}

	/**
	 * @return the spSurvival
	 */
	public int getSpSurvival() {
		return spSurvival;
	}

	/**
	 * @param spSurvival the spSurvival to set
	 */
	public void setSpSurvival(int spSurvival) {
		this.spSurvival = spSurvival;
	}

	/**
	 * @return the pbAcrobatics
	 */
	public boolean isPbAcrobatics() {
		return pbAcrobatics;
	}

	/**
	 * @param pbAcrobatics the pbAcrobatics to set
	 */
	public void setPbAcrobatics(boolean pbAcrobatics) {
		this.pbAcrobatics = pbAcrobatics;
	}

	/**
	 * @return the pbAnimalHandling
	 */
	public boolean isPbAnimalHandling() {
		return pbAnimalHandling;
	}

	/**
	 * @param pbAnimalHandling the pbAnimalHandling to set
	 */
	public void setPbAnimalHandling(boolean pbAnimalHandling) {
		this.pbAnimalHandling = pbAnimalHandling;
	}

	/**
	 * @return the pbArcana
	 */
	public boolean isPbArcana() {
		return pbArcana;
	}

	/**
	 * @param pbArcana the pbArcana to set
	 */
	public void setPbArcana(boolean pbArcana) {
		this.pbArcana = pbArcana;
	}

	/**
	 * @return the pbAthletics
	 */
	public boolean isPbAthletics() {
		return pbAthletics;
	}

	/**
	 * @param pbAthletics the pbAthletics to set
	 */
	public void setPbAthletics(boolean pbAthletics) {
		this.pbAthletics = pbAthletics;
	}

	/**
	 * @return the pbDeception
	 */
	public boolean isPbDeception() {
		return pbDeception;
	}

	/**
	 * @param pbDeception the pbDeception to set
	 */
	public void setPbDeception(boolean pbDeception) {
		this.pbDeception = pbDeception;
	}

	/**
	 * @return the pbHistory
	 */
	public boolean isPbHistory() {
		return pbHistory;
	}

	/**
	 * @param pbHistory the pbHistory to set
	 */
	public void setPbHistory(boolean pbHistory) {
		this.pbHistory = pbHistory;
	}

	/**
	 * @return the pbInsight
	 */
	public boolean isPbInsight() {
		return pbInsight;
	}

	/**
	 * @param pbInsight the pbInsight to set
	 */
	public void setPbInsight(boolean pbInsight) {
		this.pbInsight = pbInsight;
	}

	/**
	 * @return the pbIntimidation
	 */
	public boolean isPbIntimidation() {
		return pbIntimidation;
	}

	/**
	 * @param pbIntimidation the pbIntimidation to set
	 */
	public void setPbIntimidation(boolean pbIntimidation) {
		this.pbIntimidation = pbIntimidation;
	}

	/**
	 * @return the pbInvestigation
	 */
	public boolean isPbInvestigation() {
		return pbInvestigation;
	}

	/**
	 * @param pbInvestigation the pbInvestigation to set
	 */
	public void setPbInvestigation(boolean pbInvestigation) {
		this.pbInvestigation = pbInvestigation;
	}

	/**
	 * @return the pbMedicine
	 */
	public boolean isPbMedicine() {
		return pbMedicine;
	}

	/**
	 * @param pbMedicine the pbMedicine to set
	 */
	public void setPbMedicine(boolean pbMedicine) {
		this.pbMedicine = pbMedicine;
	}

	/**
	 * @return the pbNature
	 */
	public boolean isPbNature() {
		return pbNature;
	}

	/**
	 * @param pbNature the pbNature to set
	 */
	public void setPbNature(boolean pbNature) {
		this.pbNature = pbNature;
	}

	/**
	 * @return the pbPerception
	 */
	public boolean isPbPerception() {
		return pbPerception;
	}

	/**
	 * @param pbPerception the pbPerception to set
	 */
	public void setPbPerception(boolean pbPerception) {
		this.pbPerception = pbPerception;
	}

	/**
	 * @return the pbPerformance
	 */
	public boolean isPbPerformance() {
		return pbPerformance;
	}

	/**
	 * @param pbPerformance the pbPerformance to set
	 */
	public void setPbPerformance(boolean pbPerformance) {
		this.pbPerformance = pbPerformance;
	}

	/**
	 * @return the pbPersuasion
	 */
	public boolean isPbPersuasion() {
		return pbPersuasion;
	}

	/**
	 * @param pbPersuasion the pbPersuasion to set
	 */
	public void setPbPersuasion(boolean pbPersuasion) {
		this.pbPersuasion = pbPersuasion;
	}

	/**
	 * @return the pbReligion
	 */
	public boolean isPbReligion() {
		return pbReligion;
	}

	/**
	 * @param pbReligion the pbReligion to set
	 */
	public void setPbReligion(boolean pbReligion) {
		this.pbReligion = pbReligion;
	}

	/**
	 * @return the pbSleightOfHand
	 */
	public boolean isPbSleightOfHand() {
		return pbSleightOfHand;
	}

	/**
	 * @param pbSleightOfHand the pbSleightOfHand to set
	 */
	public void setPbSleightOfHand(boolean pbSleightOfHand) {
		this.pbSleightOfHand = pbSleightOfHand;
	}

	/**
	 * @return the pbStealth
	 */
	public boolean isPbStealth() {
		return pbStealth;
	}

	/**
	 * @param pbStealth the pbStealth to set
	 */
	public void setPbStealth(boolean pbStealth) {
		this.pbStealth = pbStealth;
	}

	/**
	 * @return the pbSurvival
	 */
	public boolean isPbSurvival() {
		return pbSurvival;
	}

	/**
	 * @param pbSurvival the pbSurvival to set
	 */
	public void setPbSurvival(boolean pbSurvival) {
		this.pbSurvival = pbSurvival;
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
				+ intelligenceMod + ", wisdomMod=" + wisdomMod + ", charismaMod=" + charismaMod + ", stStrength="
				+ stStrength + ", stDexterity=" + stDexterity + ", stConstitution=" + stConstitution
				+ ", stIntelligence=" + stIntelligence + ", stWisdom=" + stWisdom + ", stCharisma=" + stCharisma
				+ ", pbStrength=" + pbStrength + ", pbDexterity=" + pbDexterity + ", pbConstitution=" + pbConstitution
				+ ", pbIntelligence=" + pbIntelligence + ", pbWisdom=" + pbWisdom + ", pbCharisma=" + pbCharisma
				+ ", spAcrobatics=" + spAcrobatics + ", spAnimalHandling=" + spAnimalHandling + ", spArcana=" + spArcana
				+ ", spAthletics=" + spAthletics + ", spDeception=" + spDeception + ", spHistory=" + spHistory
				+ ", spInsight=" + spInsight + ", spIntimidation=" + spIntimidation + ", spInvestigation="
				+ spInvestigation + ", spMedicine=" + spMedicine + ", spNature=" + spNature + ", spPerception="
				+ spPerception + ", spPerformance=" + spPerformance + ", spPersuasion=" + spPersuasion + ", spReligion="
				+ spReligion + ", spSleightOfHand=" + spSleightOfHand + ", spStealth=" + spStealth + ", spSurvival="
				+ spSurvival + ", pbAcrobatics=" + pbAcrobatics + ", pbAnimalHandling=" + pbAnimalHandling
				+ ", pbArcana=" + pbArcana + ", pbAthletics=" + pbAthletics + ", pbDeception=" + pbDeception
				+ ", pbHistory=" + pbHistory + ", pbInsight=" + pbInsight + ", pbIntimidation=" + pbIntimidation
				+ ", pbInvestigation=" + pbInvestigation + ", pbMedicine=" + pbMedicine + ", pbNature=" + pbNature
				+ ", pbPerception=" + pbPerception + ", pbPerformance=" + pbPerformance + ", pbPersuasion="
				+ pbPersuasion + ", pbReligion=" + pbReligion + ", pbSleightOfHand=" + pbSleightOfHand + ", pbStealth="
				+ pbStealth + ", pbSurvival=" + pbSurvival + ", background=" + background + ", race=" + race + ", size="
				+ size + ", walkSpeed=" + walkSpeed + ", flySpeed=" + flySpeed + ", burrowSpeed=" + burrowSpeed
				+ ", swimSpeed=" + swimSpeed + ", climbSpeed=" + climbSpeed + ", racialStrengthMod=" + racialStrengthMod
				+ ", racialDexterityMod=" + racialDexterityMod + ", racialConstitutionMod=" + racialConstitutionMod
				+ ", racialWisdomMod=" + racialWisdomMod + ", racialIntelligenceMod=" + racialIntelligenceMod
				+ ", racialCharismaMod=" + racialCharismaMod + ", characterClasses=" + characterClasses + ", subclass="
				+ subclass + ", maxHitPoints=" + maxHitPoints + ", currentHitPoints=" + currentHitPoints
				+ ", temporaryHitPoints=" + temporaryHitPoints + ", hitDiceBase=" + hitDiceBase + ", currentHitDice="
				+ currentHitDice + ", attackCount=" + attackCount + ", attacksUsed=" + attacksUsed + ", attacks="
				+ attacks + "]";
	}

}