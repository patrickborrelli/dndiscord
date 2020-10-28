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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the equipmentDescription
	 */
	public String getEquipmentDescription() {
		return equipmentDescription;
	}

	/**
	 * @param equipmentDescription the equipmentDescription to set
	 */
	public void setEquipmentDescription(String equipmentDescription) {
		this.equipmentDescription = equipmentDescription;
	}

	/**
	 * @return the parentClassId
	 */
	public long getParentClassId() {
		return parentClassId;
	}

	/**
	 * @param parentClassId the parentClassId to set
	 */
	public void setParentClassId(long parentClassId) {
		this.parentClassId = parentClassId;
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
	 * @return the largeAvatarUrl
	 */
	public String getLargeAvatarUrl() {
		return largeAvatarUrl;
	}

	/**
	 * @param largeAvatarUrl the largeAvatarUrl to set
	 */
	public void setLargeAvatarUrl(String largeAvatarUrl) {
		this.largeAvatarUrl = largeAvatarUrl;
	}

	/**
	 * @return the portraitAvatarUrl
	 */
	public String getPortraitAvatarUrl() {
		return portraitAvatarUrl;
	}

	/**
	 * @param portraitAvatarUrl the portraitAvatarUrl to set
	 */
	public void setPortraitAvatarUrl(String portraitAvatarUrl) {
		this.portraitAvatarUrl = portraitAvatarUrl;
	}

	/**
	 * @return the moreDetailsUrl
	 */
	public String getMoreDetailsUrl() {
		return moreDetailsUrl;
	}

	/**
	 * @param moreDetailsUrl the moreDetailsUrl to set
	 */
	public void setMoreDetailsUrl(String moreDetailsUrl) {
		this.moreDetailsUrl = moreDetailsUrl;
	}

	/**
	 * @return the spellCastingAbilityId
	 */
	public int getSpellCastingAbilityId() {
		return spellCastingAbilityId;
	}

	/**
	 * @param spellCastingAbilityId the spellCastingAbilityId to set
	 */
	public void setSpellCastingAbilityId(int spellCastingAbilityId) {
		this.spellCastingAbilityId = spellCastingAbilityId;
	}

	/**
	 * @return the sourceIds
	 */
	public int[] getSourceIds() {
		return sourceIds;
	}

	/**
	 * @param sourceIds the sourceIds to set
	 */
	public void setSourceIds(int[] sourceIds) {
		this.sourceIds = sourceIds;
	}

	/**
	 * @return the hitDice
	 */
	public int getHitDice() {
		return hitDice;
	}

	/**
	 * @param hitDice the hitDice to set
	 */
	public void setHitDice(int hitDice) {
		this.hitDice = hitDice;
	}

	/**
	 * @return the classFeatures
	 */
	public ClassFeature[] getClassFeatures() {
		return classFeatures;
	}

	/**
	 * @param classFeatures the classFeatures to set
	 */
	public void setClassFeatures(ClassFeature[] classFeatures) {
		this.classFeatures = classFeatures;
	}

	/**
	 * @return the wealthDice
	 */
	public WealthDie getWealthDice() {
		return wealthDice;
	}

	/**
	 * @param wealthDice the wealthDice to set
	 */
	public void setWealthDice(WealthDie wealthDice) {
		this.wealthDice = wealthDice;
	}

	/**
	 * @return the canCastSpells
	 */
	public boolean isCanCastSpells() {
		return canCastSpells;
	}

	/**
	 * @param canCastSpells the canCastSpells to set
	 */
	public void setCanCastSpells(boolean canCastSpells) {
		this.canCastSpells = canCastSpells;
	}

	/**
	 * @return the knowsAllSpells
	 */
	public boolean isKnowsAllSpells() {
		return knowsAllSpells;
	}

	/**
	 * @param knowsAllSpells the knowsAllSpells to set
	 */
	public void setKnowsAllSpells(boolean knowsAllSpells) {
		this.knowsAllSpells = knowsAllSpells;
	}

	/**
	 * @return the spellPrepareType
	 */
	public int getSpellPrepareType() {
		return spellPrepareType;
	}

	/**
	 * @param spellPrepareType the spellPrepareType to set
	 */
	public void setSpellPrepareType(int spellPrepareType) {
		this.spellPrepareType = spellPrepareType;
	}

	/**
	 * @return the spellContainerName
	 */
	public String getSpellContainerName() {
		return spellContainerName;
	}

	/**
	 * @param spellContainerName the spellContainerName to set
	 */
	public void setSpellContainerName(String spellContainerName) {
		this.spellContainerName = spellContainerName;
	}

	/**
	 * @return the sourceId
	 */
	public int getSourceId() {
		return sourceId;
	}

	/**
	 * @param sourceId the sourceId to set
	 */
	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}

	/**
	 * @return the sourcePageNumber
	 */
	public int getSourcePageNumber() {
		return sourcePageNumber;
	}

	/**
	 * @param sourcePageNumber the sourcePageNumber to set
	 */
	public void setSourcePageNumber(int sourcePageNumber) {
		this.sourcePageNumber = sourcePageNumber;
	}

	/**
	 * @return the primaryAbilities
	 */
	public int[] getPrimaryAbilities() {
		return primaryAbilities;
	}

	/**
	 * @param primaryAbilities the primaryAbilities to set
	 */
	public void setPrimaryAbilities(int[] primaryAbilities) {
		this.primaryAbilities = primaryAbilities;
	}

	/**
	 * @return the spellRules
	 */
	public SpellRule getSpellRules() {
		return spellRules;
	}

	/**
	 * @param spellRules the spellRules to set
	 */
	public void setSpellRules(SpellRule spellRules) {
		this.spellRules = spellRules;
	}

	/**
	 * @return the prerequisites
	 */
	public Prerequisite[] getPrerequisites() {
		return prerequisites;
	}

	/**
	 * @param prerequisites the prerequisites to set
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
				+ Arrays.toString(classFeatures) + ", wealthDice=" + wealthDice + ", canCastSpells=" + canCastSpells
				+ ", knowsAllSpells=" + knowsAllSpells + ", spellPrepareType=" + spellPrepareType
				+ ", spellContainerName=" + spellContainerName + ", sourceId=" + sourceId + ", sourcePageNumber="
				+ sourcePageNumber + ", primaryAbilities=" + Arrays.toString(primaryAbilities) + ", spellRules="
				+ spellRules + ", prerequisites=" + Arrays.toString(prerequisites) + "]";
	}
	
}
