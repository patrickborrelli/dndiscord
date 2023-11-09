package com.patrickborrelli.dndiscord.model.dndbeyond;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for a DndBeyond character sheet, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DndBeyondSheet {

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
	private int removedHitPoints;
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
	private Item[] inventory;
	private Coinpurse currencies;
	private DndBeyondCharacterClass[] classes;
	private Feat[] feats;
	private String[] customDefenseAdjustments;
	private String[] customSenses;
	private Speed[] customSpeeds;
	private String[] customProficiencies;
	private String spellDefenses;
	private CustomAction[] customActions;
	private CharacterValue[] characterValues;
	private String[] conditions;
	private DeathSaveRecord deathSaves;
	private int adjustmentXp;
	private SpellSlot[] spellSlots;
	private PactMagicSlot[] pactMagic;
	private int[] activeSourceCategories;
	private Spellbook spells;
	private Options<Action> actions;
	private Options<Option> options;
	private ModifierArray modifiers;
	
	public DndBeyondSheet() {		
		
	}
	
	/**
	 * Return the class feature with the provided ID
	 * 
	 * @param id an int representing the option's id.
	 * @return a ClassFeature if one exists, or a null if none exists.
	 */
	public ClassFeature getClassFeatureById(int id) {
		ClassFeature result = null;
		//iterate through each class and see if matching feature exists:
		for(int i = 0; i < classes.length; i++) {
			for(ClassFeature myFeat : classes[i].getClassFeatures()) {
				if(myFeat.getDefinition().getId() == id) {
					result = myFeat;
				}
			}
		}
		return result;
	}
	
	/**
	 * Return the racial trait with the provided ID
	 * 
	 * @param id an int representing the trait's id.
	 * @return a RacialTrait if one exists, or a null if none exists.
	 */
	public RacialTrait getTraitById(int id) {
		RacialTrait result = null;
		//iterate through each trait and see if a matching feature exists:
		for(RacialTrait trait : race.getRacialTraits()) {
			if(trait.getDefinition().getId() == id) {
				result = trait;
			}
		}
		race.getRacialTraits();
		return result;
	}
	
	/**
	 * Returns the feat matching the provided ID.
	 * 
	 * @param id an int representing the feat's ID
	 * @return a Feat if a match exists, otherwise returns null
	 */
	public Feat getFeatById(int id) {
		Feat result = null;
		//iterate through each feat and see if match exists:
		for(Feat feat : feats) {
			if(feat.getDefinition().getId() == id) {
				result = feat;
			}
		}
		return result;
	}
	
	/**
	 * Return the class option with the provided ID.
	 * 
	 * @param id an int representing the option's id.
	 * @return an Option if one exists, or a null if none exists.
	 */
	public Option getClassOption(int id) {
		List<Option> myOptions = options.getClassOptions();
		Option result = null;
		
		for(Option opt : myOptions) {
			if(opt.getDefinition().getId() == id) {
				result = opt;
			}
		}
		return result;
	}
		
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the readonlyUrl
	 */
	public String getReadonlyUrl() {
		return readonlyUrl;
	}

	/**
	 * @param readonlyUrl the readonlyUrl to set
	 */
	public void setReadonlyUrl(String readonlyUrl) {
		this.readonlyUrl = readonlyUrl;
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
	 * @return the frameAvatarUrl
	 */
	public String getFrameAvatarUrl() {
		return frameAvatarUrl;
	}

	/**
	 * @param frameAvatarUrl the frameAvatarUrl to set
	 */
	public void setFrameAvatarUrl(String frameAvatarUrl) {
		this.frameAvatarUrl = frameAvatarUrl;
	}

	/**
	 * @return the backdropAvatarUrl
	 */
	public String getBackdropAvatarUrl() {
		return backdropAvatarUrl;
	}

	/**
	 * @param backdropAvatarUrl the backdropAvatarUrl to set
	 */
	public void setBackdropAvatarUrl(String backdropAvatarUrl) {
		this.backdropAvatarUrl = backdropAvatarUrl;
	}

	/**
	 * @return the smallBackdropAvatarUrl
	 */
	public String getSmallBackdropAvatarUrl() {
		return smallBackdropAvatarUrl;
	}

	/**
	 * @param smallBackdropAvatarUrl the smallBackdropAvatarUrl to set
	 */
	public void setSmallBackdropAvatarUrl(String smallBackdropAvatarUrl) {
		this.smallBackdropAvatarUrl = smallBackdropAvatarUrl;
	}

	/**
	 * @return the largeBackdropAvatarUrl
	 */
	public String getLargeBackdropAvatarUrl() {
		return largeBackdropAvatarUrl;
	}

	/**
	 * @param largeBackdropAvatarUrl the largeBackdropAvatarUrl to set
	 */
	public void setLargeBackdropAvatarUrl(String largeBackdropAvatarUrl) {
		this.largeBackdropAvatarUrl = largeBackdropAvatarUrl;
	}

	/**
	 * @return the thumbnailBackdropAvatarUrl
	 */
	public String getThumbnailBackdropAvatarUrl() {
		return thumbnailBackdropAvatarUrl;
	}

	/**
	 * @param thumbnailBackdropAvatarUrl the thumbnailBackdropAvatarUrl to set
	 */
	public void setThumbnailBackdropAvatarUrl(String thumbnailBackdropAvatarUrl) {
		this.thumbnailBackdropAvatarUrl = thumbnailBackdropAvatarUrl;
	}

	/**
	 * @return the avatarId
	 */
	public Long getAvatarId() {
		return avatarId;
	}

	/**
	 * @param avatarId the avatarId to set
	 */
	public void setAvatarId(Long avatarId) {
		this.avatarId = avatarId;
	}

	/**
	 * @return the frameAvatarId
	 */
	public Long getFrameAvatarId() {
		return frameAvatarId;
	}

	/**
	 * @param frameAvatarId the frameAvatarId to set
	 */
	public void setFrameAvatarId(Long frameAvatarId) {
		this.frameAvatarId = frameAvatarId;
	}

	/**
	 * @return the backdropAvatarId
	 */
	public Long getBackdropAvatarId() {
		return backdropAvatarId;
	}

	/**
	 * @param backdropAvatarId the backdropAvatarId to set
	 */
	public void setBackdropAvatarId(Long backdropAvatarId) {
		this.backdropAvatarId = backdropAvatarId;
	}

	/**
	 * @return the smallBackdropAvatarId
	 */
	public Long getSmallBackdropAvatarId() {
		return smallBackdropAvatarId;
	}

	/**
	 * @param smallBackdropAvatarId the smallBackdropAvatarId to set
	 */
	public void setSmallBackdropAvatarId(Long smallBackdropAvatarId) {
		this.smallBackdropAvatarId = smallBackdropAvatarId;
	}

	/**
	 * @return the largeBackdropAvatarId
	 */
	public Long getLargeBackdropAvatarId() {
		return largeBackdropAvatarId;
	}

	/**
	 * @param largeBackdropAvatarId the largeBackdropAvatarId to set
	 */
	public void setLargeBackdropAvatarId(Long largeBackdropAvatarId) {
		this.largeBackdropAvatarId = largeBackdropAvatarId;
	}

	/**
	 * @return the thumbnailAvatarId
	 */
	public Long getThumbnailAvatarId() {
		return thumbnailAvatarId;
	}

	/**
	 * @param thumbnailAvatarId the thumbnailAvatarId to set
	 */
	public void setThumbnailAvatarId(Long thumbnailAvatarId) {
		this.thumbnailAvatarId = thumbnailAvatarId;
	}

	/**
	 * @return the themeColorId
	 */
	public Long getThemeColorId() {
		return themeColorId;
	}

	/**
	 * @param themeColorId the themeColorId to set
	 */
	public void setThemeColorId(Long themeColorId) {
		this.themeColorId = themeColorId;
	}

	/**
	 * @return the themeColor
	 */
	public ThemeColor getThemeColor() {
		return themeColor;
	}

	/**
	 * @param themeColor the themeColor to set
	 */
	public void setThemeColor(ThemeColor themeColor) {
		this.themeColor = themeColor;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the socialName
	 */
	public String getSocialName() {
		return socialName;
	}

	/**
	 * @param socialName the socialName to set
	 */
	public void setSocialName(String socialName) {
		this.socialName = socialName;
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
	 * @return the eyes
	 */
	public String getEyes() {
		return eyes;
	}

	/**
	 * @param eyes the eyes to set
	 */
	public void setEyes(String eyes) {
		this.eyes = eyes;
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
	 * @return the baseHitPoints
	 */
	public int getBaseHitPoints() {
		return baseHitPoints;
	}

	/**
	 * @param baseHitPoints the baseHitPoints to set
	 */
	public void setBaseHitPoints(int baseHitPoints) {
		this.baseHitPoints = baseHitPoints;
	}

	/**
	 * @return the bonusHitPoints
	 */
	public int getBonusHitPoints() {
		return bonusHitPoints;
	}

	/**
	 * @param bonusHitPoints the bonusHitPoints to set
	 */
	public void setBonusHitPoints(int bonusHitPoints) {
		this.bonusHitPoints = bonusHitPoints;
	}

	/**
	 * @return the overrideHitPoints
	 */
	public int getOverrideHitPoints() {
		return overrideHitPoints;
	}

	/**
	 * @param overrideHitPoints the overrideHitPoints to set
	 */
	public void setOverrideHitPoints(int overrideHitPoints) {
		this.overrideHitPoints = overrideHitPoints;
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
	 * @return the removedHitPoints
	 */
	public int getRemovedHitPoints() {
		return removedHitPoints;
	}

	/**
	 * @param removedHitPoints the removedHitPoints to set
	 */
	public void setRemovedHitPoints(int removedHitPoints) {
		this.removedHitPoints = removedHitPoints;
	}

	/**
	 * @return the currentXp
	 */
	public int getCurrentXp() {
		return currentXp;
	}

	/**
	 * @param currentXp the currentXp to set
	 */
	public void setCurrentXp(int currentXp) {
		this.currentXp = currentXp;
	}

	/**
	 * @return the alignmentId
	 */
	public int getAlignmentId() {
		return alignmentId;
	}

	/**
	 * @param alignmentId the alignmentId to set
	 */
	public void setAlignmentId(int alignmentId) {
		this.alignmentId = alignmentId;
	}

	/**
	 * @return the lifestyleId
	 */
	public int getLifestyleId() {
		return lifestyleId;
	}

	/**
	 * @param lifestyleId the lifestyleId to set
	 */
	public void setLifestyleId(int lifestyleId) {
		this.lifestyleId = lifestyleId;
	}

	/**
	 * @return the stats
	 */
	public Stat[] getStats() {
		return stats;
	}

	/**
	 * @param stats the stats to set
	 */
	public void setStats(Stat[] stats) {
		this.stats = stats;
	}

	/**
	 * @return the bonusStats
	 */
	public Stat[] getBonusStats() {
		return bonusStats;
	}

	/**
	 * @param bonusStats the bonusStats to set
	 */
	public void setBonusStats(Stat[] bonusStats) {
		this.bonusStats = bonusStats;
	}

	/**
	 * @return the overrideStats
	 */
	public Stat[] getOverrideStats() {
		return overrideStats;
	}

	/**
	 * @param overrideStats the overrideStats to set
	 */
	public void setOverrideStats(Stat[] overrideStats) {
		this.overrideStats = overrideStats;
	}

	/**
	 * @return the background
	 */
	public Background getBackground() {
		return background;
	}

	/**
	 * @param background the background to set
	 */
	public void setBackground(Background background) {
		this.background = background;
	}

	/**
	 * @return the race
	 */
	public Race getRace() {
		return race;
	}

	/**
	 * @param race the race to set
	 */
	public void setRace(Race race) {
		this.race = race;
	}

	/**
	 * @return the notes
	 */
	public CharacterNotes getNotes() {
		return notes;
	}

	/**
	 * @param notes the notes to set
	 */
	public void setNotes(CharacterNotes notes) {
		this.notes = notes;
	}

	/**
	 * @return the traits
	 */
	public CharacterTraits getTraits() {
		return traits;
	}

	/**
	 * @param traits the traits to set
	 */
	public void setTraits(CharacterTraits traits) {
		this.traits = traits;
	}

	/**
	 * @return the preferences
	 */
	public DndBeyondPreferences getPreferences() {
		return preferences;
	}

	/**
	 * @param preferences the preferences to set
	 */
	public void setPreferences(DndBeyondPreferences preferences) {
		this.preferences = preferences;
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
	 * @return the inventory
	 */
	public Item[] getInventory() {
		return inventory;
	}

	/**
	 * @param inventory the inventory to set
	 */
	public void setInventory(Item[] inventory) {
		this.inventory = inventory;
	}

	/**
	 * @return the currencies
	 */
	public Coinpurse getCurrencies() {
		return currencies;
	}

	/**
	 * @param currencies the currencies to set
	 */
	public void setCurrencies(Coinpurse currencies) {
		this.currencies = currencies;
	}

	/**
	 * @return the classes
	 */
	public DndBeyondCharacterClass[] getClasses() {
		return classes;
	}

	/**
	 * @param classes the classes to set
	 */
	public void setClasses(DndBeyondCharacterClass[] classes) {
		this.classes = classes;
	}

	/**
	 * @return Feat[] the feats
	 */
	public Feat[] getFeats() {
		return feats;
	}

	/**
	 * @param feats Feat[] the feats to set
	 */
	public void setFeats(Feat[] feats) {
		this.feats = feats;
	}

	/**
	 * @return the customDefenseAdjustments
	 */
	public String[] getCustomDefenseAdjustments() {
		return customDefenseAdjustments;
	}

	/**
	 * @param customDefenseAdjustments the customDefenseAdjustments to set
	 */
	public void setCustomDefenseAdjustments(String[] customDefenseAdjustments) {
		this.customDefenseAdjustments = customDefenseAdjustments;
	}

	/**
	 * @return the customSenses
	 */
	public String[] getCustomSenses() {
		return customSenses;
	}

	/**
	 * @param customSenses the customSenses to set
	 */
	public void setCustomSenses(String[] customSenses) {
		this.customSenses = customSenses;
	}

	/**
	 * @return the customSpeeds
	 */
	public Speed[] getCustomSpeeds() {
		return customSpeeds;
	}

	/**
	 * @param customSpeeds the customSpeeds to set
	 */
	public void setCustomSpeeds(Speed[] customSpeeds) {
		this.customSpeeds = customSpeeds;
	}

	/**
	 * @return the customProficiencies
	 */
	public String[] getCustomProficiencies() {
		return customProficiencies;
	}

	/**
	 * @param customProficiencies the customProficiencies to set
	 */
	public void setCustomProficiencies(String[] customProficiencies) {
		this.customProficiencies = customProficiencies;
	}

	/**
	 * @return the spellDefenses
	 */
	public String getSpellDefenses() {
		return spellDefenses;
	}

	/**
	 * @param spellDefenses the spellDefenses to set
	 */
	public void setSpellDefenses(String spellDefenses) {
		this.spellDefenses = spellDefenses;
	}

	/**
	 * @return the customActions
	 */
	public CustomAction[] getCustomActions() {
		return customActions;
	}

	/**
	 * @param customActions the customActions to set
	 */
	public void setCustomActions(CustomAction[] customActions) {
		this.customActions = customActions;
	}

	/**
	 * @return the characterValues
	 */
	public CharacterValue[] getCharacterValues() {
		return characterValues;
	}

	/**
	 * @param characterValues the characterValues to set
	 */
	public void setCharacterValues(CharacterValue[] characterValues) {
		this.characterValues = characterValues;
	}

	/**
	 * @return the conditions
	 */
	public String[] getConditions() {
		return conditions;
	}

	/**
	 * @param conditions the conditions to set
	 */
	public void setConditions(String[] conditions) {
		this.conditions = conditions;
	}

	/**
	 * @return the deathSaves
	 */
	public DeathSaveRecord getDeathSaves() {
		return deathSaves;
	}

	/**
	 * @param deathSaves the deathSaves to set
	 */
	public void setDeathSaves(DeathSaveRecord deathSaves) {
		this.deathSaves = deathSaves;
	}

	/**
	 * @return the adjustmentXp
	 */
	public int getAdjustmentXp() {
		return adjustmentXp;
	}

	/**
	 * @param adjustmentXp the adjustmentXp to set
	 */
	public void setAdjustmentXp(int adjustmentXp) {
		this.adjustmentXp = adjustmentXp;
	}

	/**
	 * @return the spellSlots
	 */
	public SpellSlot[] getSpellSlots() {
		return spellSlots;
	}

	/**
	 * @param spellSlots the spellSlots to set
	 */
	public void setSpellSlots(SpellSlot[] spellSlots) {
		this.spellSlots = spellSlots;
	}

	/**
	 * @return the pactMagic
	 */
	public PactMagicSlot[] getPactMagic() {
		return pactMagic;
	}

	/**
	 * @param pactMagic the pactMagic to set
	 */
	public void setPactMagic(PactMagicSlot[] pactMagic) {
		this.pactMagic = pactMagic;
	}

	/**
	 * @return the activeSourceCategories
	 */
	public int[] getActiveSourceCategories() {
		return activeSourceCategories;
	}

	/**
	 * @param activeSourceCategories the activeSourceCategories to set
	 */
	public void setActiveSourceCategories(int[] activeSourceCategories) {
		this.activeSourceCategories = activeSourceCategories;
	}

	/**
	 * @return the spells
	 */
	public Spellbook getSpells() {
		return spells;
	}

	/**
	 * @param spells the spells to set
	 */
	public void setSpells(Spellbook spells) {
		this.spells = spells;
	}

	/**
	 * @return the actions
	 */
	public Options<Action> getActions() {
		return actions;
	}

	/**
	 * @param actions the actions to set
	 */
	public void setActions(Options<Action> actions) {
		this.actions = actions;
	}

	/**
	 * @return the options
	 */
	public Options<Option> getOptions() {
		return options;
	}

	/**
	 * @param options the options to set
	 */
	public void setOptions(Options<Option> options) {
		this.options = options;
	}

	/**
	 * @return the modifiers
	 */
	public ModifierArray getModifiers() {
		return modifiers;
	}

	/**
	 * @param modifiers the modifiers to set
	 */
	public void setModifiers(ModifierArray modifiers) {
		this.modifiers = modifiers;
	}

	@Override
	public String toString() {
		return "DndBeyondSheet [id=" + id + ", readonlyUrl=" + readonlyUrl + ", avatarUrl=" + avatarUrl
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
				+ ", temporaryHitPoints=" + temporaryHitPoints + ", removedHitPoints=" + removedHitPoints
				+ ", currentXp=" + currentXp + ", alignmentId=" + alignmentId + ", lifestyleId=" + lifestyleId
				+ ", stats=" + Arrays.toString(stats) + ", bonusStats=" + Arrays.toString(bonusStats)
				+ ", overrideStats=" + Arrays.toString(overrideStats) + ", background=" + background + ", race=" + race
				+ ", notes=" + notes + ", traits=" + traits + ", preferences=" + preferences + ", lifestyle="
				+ lifestyle + ", inventory=" + Arrays.toString(inventory) + ", currencies=" + currencies + ", classes="
				+ Arrays.toString(classes) + ", feats=" + Arrays.toString(feats) + ", customDefenseAdjustments="
				+ Arrays.toString(customDefenseAdjustments) + ", customSenses=" + Arrays.toString(customSenses)
				+ ", customSpeeds=" + Arrays.toString(customSpeeds) + ", customProficiencies="
				+ Arrays.toString(customProficiencies) + ", spellDefenses=" + spellDefenses + ", customActions="
				+ Arrays.toString(customActions) + ", characterValues=" + Arrays.toString(characterValues)
				+ ", conditions=" + Arrays.toString(conditions) + ", deathSaves=" + deathSaves + ", adjustmentXp="
				+ adjustmentXp + ", spellSlots=" + Arrays.toString(spellSlots) + ", pactMagic="
				+ Arrays.toString(pactMagic) + ", activeSourceCategories=" + Arrays.toString(activeSourceCategories)
				+ ", spells=" + spells + ", actions=" + actions + ", options=" + options + ", modifiers=" + modifiers
				+ "]";
	}
	
}