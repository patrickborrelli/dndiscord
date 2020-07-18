package com.patrickborrelli.dndiscord.model.dndbeyond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for a spell json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Spell {
	private int overrideSaveDc;
	private LimitedUse limitedUse;
	private int id;
	private long entityTypeId;
	private Definition definition;
	private boolean prepared;
	private boolean countsAsKnownSpell;
	private boolean usesSpellSlot;
	private String castAtLevel;
	private boolean alwaysPrepared;
	private String restriction;
	private int spellCastingAbilityId;
	private boolean displayAsAttack;
	private String additionalDescription;
	private boolean castOnlyAsRitual;
	private String ritualCastingType;
	private Range range;
	private Activation activation;
	private boolean baseLevelAtWill;
	private int atWillLimitedUseLevel;
	private int componentId;
	private long componentTypeId;
	
	public Spell() {
		
	}

	/**
	 * @return the overrideSaveDc
	 */
	public int getOverrideSaveDc() {
		return overrideSaveDc;
	}

	/**
	 * @param overrideSaveDc the overrideSaveDc to set
	 */
	public void setOverrideSaveDc(int overrideSaveDc) {
		this.overrideSaveDc = overrideSaveDc;
	}

	/**
	 * @return the limitedUse
	 */
	public LimitedUse getLimitedUse() {
		return limitedUse;
	}

	/**
	 * @param limitedUse the limitedUse to set
	 */
	public void setLimitedUse(LimitedUse limitedUse) {
		this.limitedUse = limitedUse;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the entityTypeId
	 */
	public long getEntityTypeId() {
		return entityTypeId;
	}

	/**
	 * @param entityTypeId the entityTypeId to set
	 */
	public void setEntityTypeId(long entityTypeId) {
		this.entityTypeId = entityTypeId;
	}

	/**
	 * @return the definition
	 */
	public Definition getDefinition() {
		return definition;
	}

	/**
	 * @param definition the definition to set
	 */
	public void setDefinition(Definition definition) {
		this.definition = definition;
	}

	/**
	 * @return the prepared
	 */
	public boolean isPrepared() {
		return prepared;
	}

	/**
	 * @param prepared the prepared to set
	 */
	public void setPrepared(boolean prepared) {
		this.prepared = prepared;
	}

	/**
	 * @return the countsAsKnownSpell
	 */
	public boolean isCountsAsKnownSpell() {
		return countsAsKnownSpell;
	}

	/**
	 * @param countsAsKnownSpell the countsAsKnownSpell to set
	 */
	public void setCountsAsKnownSpell(boolean countsAsKnownSpell) {
		this.countsAsKnownSpell = countsAsKnownSpell;
	}

	/**
	 * @return the usesSpellSlot
	 */
	public boolean isUsesSpellSlot() {
		return usesSpellSlot;
	}

	/**
	 * @param usesSpellSlot the usesSpellSlot to set
	 */
	public void setUsesSpellSlot(boolean usesSpellSlot) {
		this.usesSpellSlot = usesSpellSlot;
	}

	/**
	 * @return the castAtLevel
	 */
	public String getCastAtLevel() {
		return castAtLevel;
	}

	/**
	 * @param castAtLevel the castAtLevel to set
	 */
	public void setCastAtLevel(String castAtLevel) {
		this.castAtLevel = castAtLevel;
	}

	/**
	 * @return the alwaysPrepared
	 */
	public boolean isAlwaysPrepared() {
		return alwaysPrepared;
	}

	/**
	 * @param alwaysPrepared the alwaysPrepared to set
	 */
	public void setAlwaysPrepared(boolean alwaysPrepared) {
		this.alwaysPrepared = alwaysPrepared;
	}

	/**
	 * @return the restriction
	 */
	public String getRestriction() {
		return restriction;
	}

	/**
	 * @param restriction the restriction to set
	 */
	public void setRestriction(String restriction) {
		this.restriction = restriction;
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
	 * @return the displayAsAttack
	 */
	public boolean isDisplayAsAttack() {
		return displayAsAttack;
	}

	/**
	 * @param displayAsAttack the displayAsAttack to set
	 */
	public void setDisplayAsAttack(boolean displayAsAttack) {
		this.displayAsAttack = displayAsAttack;
	}

	/**
	 * @return the additionalDescription
	 */
	public String getAdditionalDescription() {
		return additionalDescription;
	}

	/**
	 * @param additionalDescription the additionalDescription to set
	 */
	public void setAdditionalDescription(String additionalDescription) {
		this.additionalDescription = additionalDescription;
	}

	/**
	 * @return the castOnlyAsRitual
	 */
	public boolean isCastOnlyAsRitual() {
		return castOnlyAsRitual;
	}

	/**
	 * @param castOnlyAsRitual the castOnlyAsRitual to set
	 */
	public void setCastOnlyAsRitual(boolean castOnlyAsRitual) {
		this.castOnlyAsRitual = castOnlyAsRitual;
	}

	/**
	 * @return the ritualCastingType
	 */
	public String getRitualCastingType() {
		return ritualCastingType;
	}

	/**
	 * @param ritualCastingType the ritualCastingType to set
	 */
	public void setRitualCastingType(String ritualCastingType) {
		this.ritualCastingType = ritualCastingType;
	}

	/**
	 * @return the range
	 */
	public Range getRange() {
		return range;
	}

	/**
	 * @param range the range to set
	 */
	public void setRange(Range range) {
		this.range = range;
	}

	/**
	 * @return the activation
	 */
	public Activation getActivation() {
		return activation;
	}

	/**
	 * @param activation the activation to set
	 */
	public void setActivation(Activation activation) {
		this.activation = activation;
	}

	/**
	 * @return the baseLevelAtWill
	 */
	public boolean isBaseLevelAtWill() {
		return baseLevelAtWill;
	}

	/**
	 * @param baseLevelAtWill the baseLevelAtWill to set
	 */
	public void setBaseLevelAtWill(boolean baseLevelAtWill) {
		this.baseLevelAtWill = baseLevelAtWill;
	}

	/**
	 * @return the atWillLimitedUseLevel
	 */
	public int getAtWillLimitedUseLevel() {
		return atWillLimitedUseLevel;
	}

	/**
	 * @param atWillLimitedUseLevel the atWillLimitedUseLevel to set
	 */
	public void setAtWillLimitedUseLevel(int atWillLimitedUseLevel) {
		this.atWillLimitedUseLevel = atWillLimitedUseLevel;
	}

	/**
	 * @return the componentId
	 */
	public int getComponentId() {
		return componentId;
	}

	/**
	 * @param componentId the componentId to set
	 */
	public void setComponentId(int componentId) {
		this.componentId = componentId;
	}

	/**
	 * @return the componentTypeId
	 */
	public long getComponentTypeId() {
		return componentTypeId;
	}

	/**
	 * @param componentTypeId the componentTypeId to set
	 */
	public void setComponentTypeId(long componentTypeId) {
		this.componentTypeId = componentTypeId;
	}

	@Override
	public String toString() {
		return "Spell [overrideSaveDc=" + overrideSaveDc + ", limitedUse=" + limitedUse + ", id=" + id
				+ ", entityTypeId=" + entityTypeId + ", definition=" + definition + ", prepared=" + prepared
				+ ", countsAsKnownSpell=" + countsAsKnownSpell + ", usesSpellSlot=" + usesSpellSlot + ", castAtLevel="
				+ castAtLevel + ", alwaysPrepared=" + alwaysPrepared + ", restriction=" + restriction
				+ ", spellCastingAbilityId=" + spellCastingAbilityId + ", displayAsAttack=" + displayAsAttack
				+ ", additionalDescription=" + additionalDescription + ", castOnlyAsRitual=" + castOnlyAsRitual
				+ ", ritualCastingType=" + ritualCastingType + ", range=" + range + ", activation=" + activation
				+ ", baseLevelAtWill=" + baseLevelAtWill + ", atWillLimitedUseLevel=" + atWillLimitedUseLevel
				+ ", componentId=" + componentId + ", componentTypeId=" + componentTypeId + "]";
	}

}