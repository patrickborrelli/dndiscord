package com.patrickborrelli.dndiscord.model.dndbeyond;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for a character json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterRecord {

	private long id;
	private String readonlyUrl;
	private String avatarUrl;
	private String frameAvatarUrl;
	private String backdropAvatarUrl;
	private String smallBackdropAvatarUrl;
	private String largeBackdropAvatarUrl;
	private String thumbnailBackdropAvatarUrl;
	private Long avatarId;
	private Long frameAvatarId;
	private Long backdropAvatarId;
	private Long smallBackdropAvatarId;
	private Long largeBackdropAvatarId;
	private Long thumbnailAvatarId;
	private Long themeColorId;
	private ThemeColor themeColor;
	private String name;
	private String socialName;
	private String gender;
	private String faith;
	private int age;
	private String hair;
	private String eyes;
	private String skin;
	private String height;
	private String weight;
	private boolean inspiration;
	private int baseHitPoints;
	private int bonusHitPoints;
	private int overrideHitPoints;
	private int temporaryHitPoints;
	private int currentXp;
	private int alignmentId;
	private int lifestyleId;
	private Stat[] stats;
	private Stat[] bonusStats;
	private Stat[] overrideStats;
	private Background background;
	private Race race;
	private CharacterNotes notes;
	private CharacterTraits traits;
	private DndBeyondPreferences preferences;
	private String lifestyle;
	//private Item[] inventory;
	private Coinpurse currencies;
	private CharacterClass[] classes;
	//private Feat[] feats;
	private String[] customDefenseAdjustments;
	private String[] customSenses;
	private String[] customSpeeds;
	private String[] customProficiencies;
	private String spellDefenses;
	private String[] customActions;
	private CharacterValue[] characterValues;
	private String[] conditions;
	private DeathSaveRecord deathSaves;
	private int adjustmentXp;
	private SpellSlot[] spellSlots;
	private PactMagicSlot[] pactMagic;
	private int[] activeSourceCategories;
	private Spellbook spells;
	
	public CharacterRecord() {		
		
	}

	/**
	 * @return long the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param long the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return String the readonlyUrl
	 */
	public String getReadonlyUrl() {
		return readonlyUrl;
	}

	/**
	 * @param String the readonlyUrl to set
	 */
	public void setReadonlyUrl(String readonlyUrl) {
		this.readonlyUrl = readonlyUrl;
	}

	/**
	 * @return String the avatarUrl
	 */
	public String getAvatarUrl() {
		return avatarUrl;
	}

	/**
	 * @param String the avatarUrl to set
	 */
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	/**
	 * @return String the frameAvatarUrl
	 */
	public String getFrameAvatarUrl() {
		return frameAvatarUrl;
	}

	/**
	 * @param String the frameAvatarUrl to set
	 */
	public void setFrameAvatarUrl(String frameAvatarUrl) {
		this.frameAvatarUrl = frameAvatarUrl;
	}

	/**
	 * @return String the backdropAvatarUrl
	 */
	public String getBackdropAvatarUrl() {
		return backdropAvatarUrl;
	}

	/**
	 * @param String the backdropAvatarUrl to set
	 */
	public void setBackdropAvatarUrl(String backdropAvatarUrl) {
		this.backdropAvatarUrl = backdropAvatarUrl;
	}

	/**
	 * @return String the smallBackdropAvatarUrl
	 */
	public String getSmallBackdropAvatarUrl() {
		return smallBackdropAvatarUrl;
	}

	/**
	 * @param String the smallBackdropAvatarUrl to set
	 */
	public void setSmallBackdropAvatarUrl(String smallBackdropAvatarUrl) {
		this.smallBackdropAvatarUrl = smallBackdropAvatarUrl;
	}

	/**
	 * @return String the largeBackdropAvatarUrl
	 */
	public String getLargeBackdropAvatarUrl() {
		return largeBackdropAvatarUrl;
	}

	/**
	 * @param String the largeBackdropAvatarUrl to set
	 */
	public void setLargeBackdropAvatarUrl(String largeBackdropAvatarUrl) {
		this.largeBackdropAvatarUrl = largeBackdropAvatarUrl;
	}

	/**
	 * @return String the thumbnailBackdropAvatarUrl
	 */
	public String getThumbnailBackdropAvatarUrl() {
		return thumbnailBackdropAvatarUrl;
	}

	/**
	 * @param String the thumbnailBackdropAvatarUrl to set
	 */
	public void setThumbnailBackdropAvatarUrl(String thumbnailBackdropAvatarUrl) {
		this.thumbnailBackdropAvatarUrl = thumbnailBackdropAvatarUrl;
	}

	/**
	 * @return Long the avatarId
	 */
	public Long getAvatarId() {
		return avatarId;
	}

	/**
	 * @param Long the avatarId to set
	 */
	public void setAvatarId(Long avatarId) {
		this.avatarId = avatarId;
	}

	/**
	 * @return Long the frameAvatarId
	 */
	public Long getFrameAvatarId() {
		return frameAvatarId;
	}

	/**
	 * @param Long the frameAvatarId to set
	 */
	public void setFrameAvatarId(Long frameAvatarId) {
		this.frameAvatarId = frameAvatarId;
	}

	/**
	 * @return Long the backdropAvatarId
	 */
	public Long getBackdropAvatarId() {
		return backdropAvatarId;
	}

	/**
	 * @param Long the backdropAvatarId to set
	 */
	public void setBackdropAvatarId(Long backdropAvatarId) {
		this.backdropAvatarId = backdropAvatarId;
	}

	/**
	 * @return Long the smallBackdropAvatarId
	 */
	public Long getSmallBackdropAvatarId() {
		return smallBackdropAvatarId;
	}

	/**
	 * @param Long the smallBackdropAvatarId to set
	 */
	public void setSmallBackdropAvatarId(Long smallBackdropAvatarId) {
		this.smallBackdropAvatarId = smallBackdropAvatarId;
	}

	/**
	 * @return Long the largeBackdropAvatarId
	 */
	public Long getLargeBackdropAvatarId() {
		return largeBackdropAvatarId;
	}

	/**
	 * @param Long the largeBackdropAvatarId to set
	 */
	public void setLargeBackdropAvatarId(Long largeBackdropAvatarId) {
		this.largeBackdropAvatarId = largeBackdropAvatarId;
	}

	/**
	 * @return Long the thumbnailAvatarId
	 */
	public Long getThumbnailAvatarId() {
		return thumbnailAvatarId;
	}

	/**
	 * @param Long the thumbnailAvatarId to set
	 */
	public void setThumbnailAvatarId(Long thumbnailAvatarId) {
		this.thumbnailAvatarId = thumbnailAvatarId;
	}

	/**
	 * @return Long the themeColorId
	 */
	public Long getThemeColorId() {
		return themeColorId;
	}

	/**
	 * @param Long the themeColorId to set
	 */
	public void setThemeColorId(Long themeColorId) {
		this.themeColorId = themeColorId;
	}

	/**
	 * @return ThemeColor the themeColor
	 */
	public ThemeColor getThemeColor() {
		return themeColor;
	}

	/**
	 * @param ThemeColor the themeColor to set
	 */
	public void setThemeColor(ThemeColor themeColor) {
		this.themeColor = themeColor;
	}

	/**
	 * @return String the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param String the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return String the socialName
	 */
	public String getSocialName() {
		return socialName;
	}

	/**
	 * @param String the socialName to set
	 */
	public void setSocialName(String socialName) {
		this.socialName = socialName;
	}

	/**
	 * @return String the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param String the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return String the faith
	 */
	public String getFaith() {
		return faith;
	}

	/**
	 * @param String the faith to set
	 */
	public void setFaith(String faith) {
		this.faith = faith;
	}

	/**
	 * @return int the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param int the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return String the hair
	 */
	public String getHair() {
		return hair;
	}

	/**
	 * @param String the hair to set
	 */
	public void setHair(String hair) {
		this.hair = hair;
	}

	/**
	 * @return String the eyes
	 */
	public String getEyes() {
		return eyes;
	}

	/**
	 * @param String the eyes to set
	 */
	public void setEyes(String eyes) {
		this.eyes = eyes;
	}

	/**
	 * @return String the skin
	 */
	public String getSkin() {
		return skin;
	}

	/**
	 * @param String the skin to set
	 */
	public void setSkin(String skin) {
		this.skin = skin;
	}

	/**
	 * @return String the height
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * @param String the height to set
	 */
	public void setHeight(String height) {
		this.height = height;
	}

	/**
	 * @return String the weight
	 */
	public String getWeight() {
		return weight;
	}

	/**
	 * @param String the weight to set
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}

	/**
	 * @return boolean the inspiration
	 */
	public boolean isInspiration() {
		return inspiration;
	}

	/**
	 * @param boolean the inspiration to set
	 */
	public void setInspiration(boolean inspiration) {
		this.inspiration = inspiration;
	}

	/**
	 * @return int the baseHitPoints
	 */
	public int getBaseHitPoints() {
		return baseHitPoints;
	}

	/**
	 * @param int the baseHitPoints to set
	 */
	public void setBaseHitPoints(int baseHitPoints) {
		this.baseHitPoints = baseHitPoints;
	}

	/**
	 * @return int the bonusHitPoints
	 */
	public int getBonusHitPoints() {
		return bonusHitPoints;
	}

	/**
	 * @param int the bonusHitPoints to set
	 */
	public void setBonusHitPoints(int bonusHitPoints) {
		this.bonusHitPoints = bonusHitPoints;
	}

	/**
	 * @return int the overrideHitPoints
	 */
	public int getOverrideHitPoints() {
		return overrideHitPoints;
	}

	/**
	 * @param int the overrideHitPoints to set
	 */
	public void setOverrideHitPoints(int overrideHitPoints) {
		this.overrideHitPoints = overrideHitPoints;
	}

	/**
	 * @return int the temporaryHitPoints
	 */
	public int getTemporaryHitPoints() {
		return temporaryHitPoints;
	}

	/**
	 * @param int the temporaryHitPoints to set
	 */
	public void setTemporaryHitPoints(int temporaryHitPoints) {
		this.temporaryHitPoints = temporaryHitPoints;
	}

	/**
	 * @return int the currentXp
	 */
	public int getCurrentXp() {
		return currentXp;
	}

	/**
	 * @param int the currentXp to set
	 */
	public void setCurrentXp(int currentXp) {
		this.currentXp = currentXp;
	}

	/**
	 * @return int the alignmentId
	 */
	public int getAlignmentId() {
		return alignmentId;
	}

	/**
	 * @param int the alignmentId to set
	 */
	public void setAlignmentId(int alignmentId) {
		this.alignmentId = alignmentId;
	}

	/**
	 * @return int the lifestyleId
	 */
	public int getLifestyleId() {
		return lifestyleId;
	}

	/**
	 * @param int the lifestyleId to set
	 */
	public void setLifestyleId(int lifestyleId) {
		this.lifestyleId = lifestyleId;
	}

	/**
	 * @return Stat[] the stats
	 */
	public Stat[] getStats() {
		return stats;
	}

	/**
	 * @param Stat[] the stats to set
	 */
	public void setStats(Stat[] stats) {
		this.stats = stats;
	}

	/**
	 * @return Stat[] the bonusStats
	 */
	public Stat[] getBonusStats() {
		return bonusStats;
	}

	/**
	 * @param Stat[] the bonusStats to set
	 */
	public void setBonusStats(Stat[] bonusStats) {
		this.bonusStats = bonusStats;
	}

	/**
	 * @return Stat[] the overrideStats
	 */
	public Stat[] getOverrideStats() {
		return overrideStats;
	}

	/**
	 * @param Stat[] the overrideStats to set
	 */
	public void setOverrideStats(Stat[] overrideStats) {
		this.overrideStats = overrideStats;
	}

	/**
	 * @return Background the background
	 */
	public Background getBackground() {
		return background;
	}

	/**
	 * @param Background the background to set
	 */
	public void setBackground(Background background) {
		this.background = background;
	}

	/**
	 * @return Race the race
	 */
	public Race getRace() {
		return race;
	}

	/**
	 * @param Race the race to set
	 */
	public void setRace(Race race) {
		this.race = race;
	}

	/**
	 * @return CharacterNotes the notes
	 */
	public CharacterNotes getNotes() {
		return notes;
	}

	/**
	 * @param CharacterNotes the notes to set
	 */
	public void setNotes(CharacterNotes notes) {
		this.notes = notes;
	}

	/**
	 * @return CharacterTraits the traits
	 */
	public CharacterTraits getTraits() {
		return traits;
	}

	/**
	 * @param CharacterTraits the traits to set
	 */
	public void setTraits(CharacterTraits traits) {
		this.traits = traits;
	}

	/**
	 * @return DndBeyondPreferences the preferences
	 */
	public DndBeyondPreferences getPreferences() {
		return preferences;
	}

	/**
	 * @param DndBeyondPreferences the preferences to set
	 */
	public void setPreferences(DndBeyondPreferences preferences) {
		this.preferences = preferences;
	}

	/**
	 * @return String the lifestyle
	 */
	public String getLifestyle() {
		return lifestyle;
	}

	/**
	 * @param String the lifestyle to set
	 */
	public void setLifestyle(String lifestyle) {
		this.lifestyle = lifestyle;
	}

	/**
	 * @return Coinpurse the currencies
	 */
	public Coinpurse getCurrencies() {
		return currencies;
	}

	/**
	 * @param Coinpurse the currencies to set
	 */
	public void setCurrencies(Coinpurse currencies) {
		this.currencies = currencies;
	}

	/**
	 * @return CharacterClass[] the classes
	 */
	public CharacterClass[] getClasses() {
		return classes;
	}

	/**
	 * @param CharacterClass[] the classes to set
	 */
	public void setClasses(CharacterClass[] classes) {
		this.classes = classes;
	}

	/**
	 * @return String[] the customDefenseAdjustments
	 */
	public String[] getCustomDefenseAdjustments() {
		return customDefenseAdjustments;
	}

	/**
	 * @param String[] the customDefenseAdjustments to set
	 */
	public void setCustomDefenseAdjustments(String[] customDefenseAdjustments) {
		this.customDefenseAdjustments = customDefenseAdjustments;
	}

	/**
	 * @return String[] the customSenses
	 */
	public String[] getCustomSenses() {
		return customSenses;
	}

	/**
	 * @param String[] the customSenses to set
	 */
	public void setCustomSenses(String[] customSenses) {
		this.customSenses = customSenses;
	}

	/**
	 * @return String[] the customSpeeds
	 */
	public String[] getCustomSpeeds() {
		return customSpeeds;
	}

	/**
	 * @param String[] the customSpeeds to set
	 */
	public void setCustomSpeeds(String[] customSpeeds) {
		this.customSpeeds = customSpeeds;
	}

	/**
	 * @return String[] the customProficiencies
	 */
	public String[] getCustomProficiencies() {
		return customProficiencies;
	}

	/**
	 * @param String[] the customProficiencies to set
	 */
	public void setCustomProficiencies(String[] customProficiencies) {
		this.customProficiencies = customProficiencies;
	}

	/**
	 * @return String the spellDefenses
	 */
	public String getSpellDefenses() {
		return spellDefenses;
	}

	/**
	 * @param String the spellDefenses to set
	 */
	public void setSpellDefenses(String spellDefenses) {
		this.spellDefenses = spellDefenses;
	}

	/**
	 * @return String[] the customActions
	 */
	public String[] getCustomActions() {
		return customActions;
	}

	/**
	 * @param String[] the customActions to set
	 */
	public void setCustomActions(String[] customActions) {
		this.customActions = customActions;
	}

	/**
	 * @return CharacterValue[] the characterValues
	 */
	public CharacterValue[] getCharacterValues() {
		return characterValues;
	}

	/**
	 * @param CharacterValue[] the characterValues to set
	 */
	public void setCharacterValues(CharacterValue[] characterValues) {
		this.characterValues = characterValues;
	}

	/**
	 * @return String[] the conditions
	 */
	public String[] getConditions() {
		return conditions;
	}

	/**
	 * @param String[] the conditions to set
	 */
	public void setConditions(String[] conditions) {
		this.conditions = conditions;
	}

	/**
	 * @return DeathSaveRecord the deathSaves
	 */
	public DeathSaveRecord getDeathSaves() {
		return deathSaves;
	}

	/**
	 * @param DeathSaveRecord the deathSaves to set
	 */
	public void setDeathSaves(DeathSaveRecord deathSaves) {
		this.deathSaves = deathSaves;
	}

	/**
	 * @return int the adjustmentXp
	 */
	public int getAdjustmentXp() {
		return adjustmentXp;
	}

	/**
	 * @param int the adjustmentXp to set
	 */
	public void setAdjustmentXp(int adjustmentXp) {
		this.adjustmentXp = adjustmentXp;
	}

	/**
	 * @return SpellSlot[] the spellSlots
	 */
	public SpellSlot[] getSpellSlots() {
		return spellSlots;
	}

	/**
	 * @param SpellSlot[] the spellSlots to set
	 */
	public void setSpellSlots(SpellSlot[] spellSlots) {
		this.spellSlots = spellSlots;
	}

	/**
	 * @return PactMagicSlot[] the pactMagic
	 */
	public PactMagicSlot[] getPactMagic() {
		return pactMagic;
	}

	/**
	 * @param PactMagicSlot[] the pactMagic to set
	 */
	public void setPactMagic(PactMagicSlot[] pactMagic) {
		this.pactMagic = pactMagic;
	}

	/**
	 * @return int[] the activeSourceCategories
	 */
	public int[] getActiveSourceCategories() {
		return activeSourceCategories;
	}

	/**
	 * @param int[] the activeSourceCategories to set
	 */
	public void setActiveSourceCategories(int[] activeSourceCategories) {
		this.activeSourceCategories = activeSourceCategories;
	}

	/**
	 * @return Spellbook the spells
	 */
	public Spellbook getSpells() {
		return spells;
	}

	/**
	 * @param Spellbook the spells to set
	 */
	public void setSpells(Spellbook spells) {
		this.spells = spells;
	}

	@Override
	public String toString() {
		return "CharacterRecord [id=" + id + ", readonlyUrl=" + readonlyUrl + ", avatarUrl=" + avatarUrl
				+ ", frameAvatarUrl=" + frameAvatarUrl + ", backdropAvatarUrl=" + backdropAvatarUrl
				+ ", smallBackdropAvatarUrl=" + smallBackdropAvatarUrl + ", largeBackdropAvatarUrl="
				+ largeBackdropAvatarUrl + ", thumbnailBackdropAvatarUrl=" + thumbnailBackdropAvatarUrl + ", avatarId="
				+ avatarId + ", frameAvatarId=" + frameAvatarId + ", backdropAvatarId=" + backdropAvatarId
				+ ", smallBackdropAvatarId=" + smallBackdropAvatarId + ", largeBackdropAvatarId="
				+ largeBackdropAvatarId + ", thumbnailAvatarId=" + thumbnailAvatarId + ", themeColorId=" + themeColorId
				+ ", themeColor=" + themeColor + ", name=" + name + ", socialName=" + socialName + ", gender=" + gender
				+ ", faith=" + faith + ", age=" + age + ", hair=" + hair + ", eyes=" + eyes + ", skin=" + skin
				+ ", height=" + height + ", weight=" + weight + ", inspiration=" + inspiration + ", baseHitPoints="
				+ baseHitPoints + ", bonusHitPoints=" + bonusHitPoints + ", overrideHitPoints=" + overrideHitPoints
				+ ", temporaryHitPoints=" + temporaryHitPoints + ", currentXp=" + currentXp + ", alignmentId="
				+ alignmentId + ", lifestyleId=" + lifestyleId + ", stats=" + Arrays.toString(stats) + ", bonusStats="
				+ Arrays.toString(bonusStats) + ", overrideStats=" + Arrays.toString(overrideStats) + ", background="
				+ background + ", race=" + race + ", notes=" + notes + ", traits=" + traits + ", preferences="
				+ preferences + ", lifestyle=" + lifestyle + ", currencies=" + currencies + ", classes="
				+ Arrays.toString(classes) + ", customDefenseAdjustments=" + Arrays.toString(customDefenseAdjustments)
				+ ", customSenses=" + Arrays.toString(customSenses) + ", customSpeeds=" + Arrays.toString(customSpeeds)
				+ ", customProficiencies=" + Arrays.toString(customProficiencies) + ", spellDefenses=" + spellDefenses
				+ ", customActions=" + Arrays.toString(customActions) + ", characterValues="
				+ Arrays.toString(characterValues) + ", conditions=" + Arrays.toString(conditions) + ", deathSaves="
				+ deathSaves + ", adjustmentXp=" + adjustmentXp + ", spellSlots=" + Arrays.toString(spellSlots)
				+ ", pactMagic=" + Arrays.toString(pactMagic) + ", activeSourceCategories="
				+ Arrays.toString(activeSourceCategories) + ", spells=" + spells + "]";
	}
	
}