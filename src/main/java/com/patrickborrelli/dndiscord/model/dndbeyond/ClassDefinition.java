package com.patrickborrelli.dndiscord.model.dndbeyond;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for a class definition json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClassDefinition {
	private long id;
	private String name;
	private String description;
	private String equipmentDescription;
	private long parentClassId;
	private String avatarUrl;
	private String largeAvatarUrl;
	private String portraitAvatarUrl;
	private String moreDetailsUrl;
	private int spellCastingAbilityId;
	private int[] sourceIds;
	private int hitDice;
	private ClassFeature[] classFeatures;
	private WealthDie wealthDice;
	private boolean canCastSpells;
	private boolean knowsAllSpells;
	private int spellPrepareType;
	private String spellContainerName;
	private int sourceId;
	private int sourcePageNumber;
	private int[] primaryAbilities;
	private SpellRule spellRules;
	private Prerequisite[] prerequisites;
	
	public ClassDefinition() {
		
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
	 * @return String the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param String the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return String the equipmentDescription
	 */
	public String getEquipmentDescription() {
		return equipmentDescription;
	}

	/**
	 * @param String the equipmentDescription to set
	 */
	public void setEquipmentDescription(String equipmentDescription) {
		this.equipmentDescription = equipmentDescription;
	}

	/**
	 * @return long the parentClassId
	 */
	public long getParentClassId() {
		return parentClassId;
	}

	/**
	 * @param long the parentClassId to set
	 */
	public void setParentClassId(long parentClassId) {
		this.parentClassId = parentClassId;
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
	 * @return String the largeAvatarUrl
	 */
	public String getLargeAvatarUrl() {
		return largeAvatarUrl;
	}

	/**
	 * @param String the largeAvatarUrl to set
	 */
	public void setLargeAvatarUrl(String largeAvatarUrl) {
		this.largeAvatarUrl = largeAvatarUrl;
	}

	/**
	 * @return String the portraitAvatarUrl
	 */
	public String getPortraitAvatarUrl() {
		return portraitAvatarUrl;
	}

	/**
	 * @param String the portraitAvatarUrl to set
	 */
	public void setPortraitAvatarUrl(String portraitAvatarUrl) {
		this.portraitAvatarUrl = portraitAvatarUrl;
	}

	/**
	 * @return String the moreDetailsUrl
	 */
	public String getMoreDetailsUrl() {
		return moreDetailsUrl;
	}

	/**
	 * @param String the moreDetailsUrl to set
	 */
	public void setMoreDetailsUrl(String moreDetailsUrl) {
		this.moreDetailsUrl = moreDetailsUrl;
	}

	/**
	 * @return int the spellCastingAbilityId
	 */
	public int getSpellCastingAbilityId() {
		return spellCastingAbilityId;
	}

	/**
	 * @param int the spellCastingAbilityId to set
	 */
	public void setSpellCastingAbilityId(int spellCastingAbilityId) {
		this.spellCastingAbilityId = spellCastingAbilityId;
	}

	/**
	 * @return int[] the sourceIds
	 */
	public int[] getSourceIds() {
		return sourceIds;
	}

	/**
	 * @param int[] the sourceIds to set
	 */
	public void setSourceIds(int[] sourceIds) {
		this.sourceIds = sourceIds;
	}

	/**
	 * @return int the hitDice
	 */
	public int getHitDice() {
		return hitDice;
	}

	/**
	 * @param int the hitDice to set
	 */
	public void setHitDice(int hitDice) {
		this.hitDice = hitDice;
	}

	/**
	 * @return ClassFeature[] the classFeatures
	 */
	public ClassFeature[] getClassFeatures() {
		return classFeatures;
	}

	/**
	 * @param ClassFeature[] the classFeatures to set
	 */
	public void setClassFeatures(ClassFeature[] classFeatures) {
		this.classFeatures = classFeatures;
	}

	/**
	 * @return WealthDie the wealthDice
	 */
	public WealthDie getWealthDice() {
		return wealthDice;
	}

	/**
	 * @param WealthDie the wealthDice to set
	 */
	public void setWealthDice(WealthDie wealthDice) {
		this.wealthDice = wealthDice;
	}

	/**
	 * @return boolean the canCastSpells
	 */
	public boolean isCanCastSpells() {
		return canCastSpells;
	}

	/**
	 * @param boolean the canCastSpells to set
	 */
	public void setCanCastSpells(boolean canCastSpells) {
		this.canCastSpells = canCastSpells;
	}

	/**
	 * @return boolean the knowsAllSpells
	 */
	public boolean isKnowsAllSpells() {
		return knowsAllSpells;
	}

	/**
	 * @param boolean the knowsAllSpells to set
	 */
	public void setKnowsAllSpells(boolean knowsAllSpells) {
		this.knowsAllSpells = knowsAllSpells;
	}

	/**
	 * @return int the spellPrepareType
	 */
	public int getSpellPrepareType() {
		return spellPrepareType;
	}

	/**
	 * @param int the spellPrepareType to set
	 */
	public void setSpellPrepareType(int spellPrepareType) {
		this.spellPrepareType = spellPrepareType;
	}

	/**
	 * @return String the spellContainerName
	 */
	public String getSpellContainerName() {
		return spellContainerName;
	}

	/**
	 * @param String the spellContainerName to set
	 */
	public void setSpellContainerName(String spellContainerName) {
		this.spellContainerName = spellContainerName;
	}

	/**
	 * @return int the sourceId
	 */
	public int getSourceId() {
		return sourceId;
	}

	/**
	 * @param int the sourceId to set
	 */
	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}

	/**
	 * @return int the sourcePageNumber
	 */
	public int getSourcePageNumber() {
		return sourcePageNumber;
	}

	/**
	 * @param int the sourcePageNumber to set
	 */
	public void setSourcePageNumber(int sourcePageNumber) {
		this.sourcePageNumber = sourcePageNumber;
	}

	/**
	 * @return int[] the primaryAbilities
	 */
	public int[] getPrimaryAbilities() {
		return primaryAbilities;
	}

	/**
	 * @param int[] the primaryAbilities to set
	 */
	public void setPrimaryAbilities(int[] primaryAbilities) {
		this.primaryAbilities = primaryAbilities;
	}

	/**
	 * @return SpellRule the spellRules
	 */
	public SpellRule getSpellRules() {
		return spellRules;
	}

	/**
	 * @param SpellRule the spellRules to set
	 */
	public void setSpellRules(SpellRule spellRules) {
		this.spellRules = spellRules;
	}

	/**
	 * @return Prerequisite[] the prerequisites
	 */
	public Prerequisite[] getPrerequisites() {
		return prerequisites;
	}

	/**
	 * @param Prerequisite[] the prerequisites to set
	 */
	public void setPrerequisites(Prerequisite[] prerequisites) {
		this.prerequisites = prerequisites;
	}

	@Override
	public String toString() {
		return "ClassDefinition [id=" + id + ", name=" + name + ", description=" + description
				+ ", equipmentDescription=" + equipmentDescription + ", parentClassId=" + parentClassId + ", avatarUrl="
				+ avatarUrl + ", largeAvatarUrl=" + largeAvatarUrl + ", portraitAvatarUrl=" + portraitAvatarUrl
				+ ", moreDetailsUrl=" + moreDetailsUrl + ", spellCastingAbilityId=" + spellCastingAbilityId
				+ ", sourceIds=" + Arrays.toString(sourceIds) + ", hitDice=" + hitDice + ", classFeatures="
				+ Arrays.toString(classFeatures) + ", canCastSpells=" + canCastSpells + ", knowsAllSpells="
				+ knowsAllSpells + ", spellPrepareType=" + spellPrepareType + ", spellContainerName="
				+ spellContainerName + ", sourceId=" + sourceId + ", sourcePageNumber=" + sourcePageNumber
				+ ", primaryAbilities=" + Arrays.toString(primaryAbilities) + "]";
	}
}
