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
	 * @return int the overrideSaveDc
	 */
	public int getOverrideSaveDc() {
		return overrideSaveDc;
	}

	/**
	 * @param int the overrideSaveDc to set
	 */
	public void setOverrideSaveDc(int overrideSaveDc) {
		this.overrideSaveDc = overrideSaveDc;
	}

	/**
	 * @return LimitedUse the limitedUse
	 */
	public LimitedUse getLimitedUse() {
		return limitedUse;
	}

	/**
	 * @param LimitedUse the limitedUse to set
	 */
	public void setLimitedUse(LimitedUse limitedUse) {
		this.limitedUse = limitedUse;
	}

	/**
	 * @return int the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param int the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return long the entityTypeId
	 */
	public long getEntityTypeId() {
		return entityTypeId;
	}

	/**
	 * @param long the entityTypeId to set
	 */
	public void setEntityTypeId(long entityTypeId) {
		this.entityTypeId = entityTypeId;
	}

	/**
	 * @return Definition the definition
	 */
	public Definition getDefinition() {
		return definition;
	}

	/**
	 * @param Definition the definition to set
	 */
	public void setDefinition(Definition definition) {
		this.definition = definition;
	}

	/**
	 * @return boolean the prepared
	 */
	public boolean isPrepared() {
		return prepared;
	}

	/**
	 * @param boolean the prepared to set
	 */
	public void setPrepared(boolean prepared) {
		this.prepared = prepared;
	}

	/**
	 * @return boolean the countsAsKnownSpell
	 */
	public boolean isCountsAsKnownSpell() {
		return countsAsKnownSpell;
	}

	/**
	 * @param boolean the countsAsKnownSpell to set
	 */
	public void setCountsAsKnownSpell(boolean countsAsKnownSpell) {
		this.countsAsKnownSpell = countsAsKnownSpell;
	}

	/**
	 * @return boolean the usesSpellSlot
	 */
	public boolean isUsesSpellSlot() {
		return usesSpellSlot;
	}

	/**
	 * @param boolean the usesSpellSlot to set
	 */
	public void setUsesSpellSlot(boolean usesSpellSlot) {
		this.usesSpellSlot = usesSpellSlot;
	}

	/**
	 * @return String the castAtLevel
	 */
	public String getCastAtLevel() {
		return castAtLevel;
	}

	/**
	 * @param String the castAtLevel to set
	 */
	public void setCastAtLevel(String castAtLevel) {
		this.castAtLevel = castAtLevel;
	}

	/**
	 * @return boolean the alwaysPrepared
	 */
	public boolean isAlwaysPrepared() {
		return alwaysPrepared;
	}

	/**
	 * @param boolean the alwaysPrepared to set
	 */
	public void setAlwaysPrepared(boolean alwaysPrepared) {
		this.alwaysPrepared = alwaysPrepared;
	}

	/**
	 * @return String the restriction
	 */
	public String getRestriction() {
		return restriction;
	}

	/**
	 * @param String the restriction to set
	 */
	public void setRestriction(String restriction) {
		this.restriction = restriction;
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
	 * @return boolean the displayAsAttack
	 */
	public boolean isDisplayAsAttack() {
		return displayAsAttack;
	}

	/**
	 * @param boolean the displayAsAttack to set
	 */
	public void setDisplayAsAttack(boolean displayAsAttack) {
		this.displayAsAttack = displayAsAttack;
	}

	/**
	 * @return String the additionalDescription
	 */
	public String getAdditionalDescription() {
		return additionalDescription;
	}

	/**
	 * @param String the additionalDescription to set
	 */
	public void setAdditionalDescription(String additionalDescription) {
		this.additionalDescription = additionalDescription;
	}

	/**
	 * @return boolean the castOnlyAsRitual
	 */
	public boolean isCastOnlyAsRitual() {
		return castOnlyAsRitual;
	}

	/**
	 * @param boolean the castOnlyAsRitual to set
	 */
	public void setCastOnlyAsRitual(boolean castOnlyAsRitual) {
		this.castOnlyAsRitual = castOnlyAsRitual;
	}

	/**
	 * @return String the ritualCastingType
	 */
	public String getRitualCastingType() {
		return ritualCastingType;
	}

	/**
	 * @param String the ritualCastingType to set
	 */
	public void setRitualCastingType(String ritualCastingType) {
		this.ritualCastingType = ritualCastingType;
	}

	/**
	 * @return Range the range
	 */
	public Range getRange() {
		return range;
	}

	/**
	 * @param Range the range to set
	 */
	public void setRange(Range range) {
		this.range = range;
	}

	/**
	 * @return Activation the activation
	 */
	public Activation getActivation() {
		return activation;
	}

	/**
	 * @param Activation the activation to set
	 */
	public void setActivation(Activation activation) {
		this.activation = activation;
	}

	/**
	 * @return boolean the baseLevelAtWill
	 */
	public boolean isBaseLevelAtWill() {
		return baseLevelAtWill;
	}

	/**
	 * @param boolean the baseLevelAtWill to set
	 */
	public void setBaseLevelAtWill(boolean baseLevelAtWill) {
		this.baseLevelAtWill = baseLevelAtWill;
	}

	/**
	 * @return int the atWillLimitedUseLevel
	 */
	public int getAtWillLimitedUseLevel() {
		return atWillLimitedUseLevel;
	}

	/**
	 * @param int the atWillLimitedUseLevel to set
	 */
	public void setAtWillLimitedUseLevel(int atWillLimitedUseLevel) {
		this.atWillLimitedUseLevel = atWillLimitedUseLevel;
	}

	/**
	 * @return int the componentId
	 */
	public int getComponentId() {
		return componentId;
	}

	/**
	 * @param int the componentId to set
	 */
	public void setComponentId(int componentId) {
		this.componentId = componentId;
	}

	/**
	 * @return long the componentTypeId
	 */
	public long getComponentTypeId() {
		return componentTypeId;
	}

	/**
	 * @param long the componentTypeId to set
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
