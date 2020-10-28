package com.patrickborrelli.dndiscord.model.dndbeyond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for a custom action json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomAction {
	
	private long id;
	private long entityTypeId;
	private String name;
	private int toHitBonus;
	private String snippet;
	private boolean isProficient;
	private boolean isOffhand;
	private int statId;
	private int rangeId;
	private int diceCount;
	private int diceType;
	private int fixedValue;
	private int damageTypeId;
	private String onMissDescription;
	private String saveFailDescription;
	private String saveSuccessDescription;
	private int saveStatId;
	private int fixedSaveDc;
	private int actionType;
	private int attackSubtype;
	private int range;
	private int longRange;
	private int aoeType;
	private int aoeSize;
	private int activationTime;
	private int activationType;
	private boolean isSilvered;
	private int damageBonus;
	private boolean isMartialArts;
	private int spellRangeType;
	private boolean displayAsAttack;
	
	public CustomAction() {
		
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
	 * @return the toHitBonus
	 */
	public int getToHitBonus() {
		return toHitBonus;
	}

	/**
	 * @param toHitBonus the toHitBonus to set
	 */
	public void setToHitBonus(int toHitBonus) {
		this.toHitBonus = toHitBonus;
	}

	/**
	 * @return the snippet
	 */
	public String getSnippet() {
		return snippet;
	}

	/**
	 * @param snippet the snippet to set
	 */
	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}

	/**
	 * @return the isProficient
	 */
	public boolean isProficient() {
		return isProficient;
	}

	/**
	 * @param isProficient the isProficient to set
	 */
	public void setProficient(boolean isProficient) {
		this.isProficient = isProficient;
	}

	/**
	 * @return the isOffhand
	 */
	public boolean isOffhand() {
		return isOffhand;
	}

	/**
	 * @param isOffhand the isOffhand to set
	 */
	public void setOffhand(boolean isOffhand) {
		this.isOffhand = isOffhand;
	}

	/**
	 * @return the statId
	 */
	public int getStatId() {
		return statId;
	}

	/**
	 * @param statId the statId to set
	 */
	public void setStatId(int statId) {
		this.statId = statId;
	}

	/**
	 * @return the rangeId
	 */
	public int getRangeId() {
		return rangeId;
	}

	/**
	 * @param rangeId the rangeId to set
	 */
	public void setRangeId(int rangeId) {
		this.rangeId = rangeId;
	}

	/**
	 * @return the diceCount
	 */
	public int getDiceCount() {
		return diceCount;
	}

	/**
	 * @param diceCount the diceCount to set
	 */
	public void setDiceCount(int diceCount) {
		this.diceCount = diceCount;
	}

	/**
	 * @return the diceType
	 */
	public int getDiceType() {
		return diceType;
	}

	/**
	 * @param diceType the diceType to set
	 */
	public void setDiceType(int diceType) {
		this.diceType = diceType;
	}

	/**
	 * @return the fixedValue
	 */
	public int getFixedValue() {
		return fixedValue;
	}

	/**
	 * @param fixedValue the fixedValue to set
	 */
	public void setFixedValue(int fixedValue) {
		this.fixedValue = fixedValue;
	}

	/**
	 * @return the damageTypeId
	 */
	public int getDamageTypeId() {
		return damageTypeId;
	}

	/**
	 * @param damageTypeId the damageTypeId to set
	 */
	public void setDamageTypeId(int damageTypeId) {
		this.damageTypeId = damageTypeId;
	}

	/**
	 * @return the onMissDescription
	 */
	public String getOnMissDescription() {
		return onMissDescription;
	}

	/**
	 * @param onMissDescription the onMissDescription to set
	 */
	public void setOnMissDescription(String onMissDescription) {
		this.onMissDescription = onMissDescription;
	}

	/**
	 * @return the saveFailDescription
	 */
	public String getSaveFailDescription() {
		return saveFailDescription;
	}

	/**
	 * @param saveFailDescription the saveFailDescription to set
	 */
	public void setSaveFailDescription(String saveFailDescription) {
		this.saveFailDescription = saveFailDescription;
	}

	/**
	 * @return the saveSuccessDescription
	 */
	public String getSaveSuccessDescription() {
		return saveSuccessDescription;
	}

	/**
	 * @param saveSuccessDescription the saveSuccessDescription to set
	 */
	public void setSaveSuccessDescription(String saveSuccessDescription) {
		this.saveSuccessDescription = saveSuccessDescription;
	}

	/**
	 * @return the saveStatId
	 */
	public int getSaveStatId() {
		return saveStatId;
	}

	/**
	 * @param saveStatId the saveStatId to set
	 */
	public void setSaveStatId(int saveStatId) {
		this.saveStatId = saveStatId;
	}

	/**
	 * @return the fixedSaveDc
	 */
	public int getFixedSaveDc() {
		return fixedSaveDc;
	}

	/**
	 * @param fixedSaveDc the fixedSaveDc to set
	 */
	public void setFixedSaveDc(int fixedSaveDc) {
		this.fixedSaveDc = fixedSaveDc;
	}

	/**
	 * @return the actionType
	 */
	public int getActionType() {
		return actionType;
	}

	/**
	 * @param actionType the actionType to set
	 */
	public void setActionType(int actionType) {
		this.actionType = actionType;
	}

	/**
	 * @return the attackSubtype
	 */
	public int getAttackSubtype() {
		return attackSubtype;
	}

	/**
	 * @param attackSubtype the attackSubtype to set
	 */
	public void setAttackSubtype(int attackSubtype) {
		this.attackSubtype = attackSubtype;
	}

	/**
	 * @return the range
	 */
	public int getRange() {
		return range;
	}

	/**
	 * @param range the range to set
	 */
	public void setRange(int range) {
		this.range = range;
	}

	/**
	 * @return the longRange
	 */
	public int getLongRange() {
		return longRange;
	}

	/**
	 * @param longRange the longRange to set
	 */
	public void setLongRange(int longRange) {
		this.longRange = longRange;
	}

	/**
	 * @return the aoeType
	 */
	public int getAoeType() {
		return aoeType;
	}

	/**
	 * @param aoeType the aoeType to set
	 */
	public void setAoeType(int aoeType) {
		this.aoeType = aoeType;
	}

	/**
	 * @return the aoeSize
	 */
	public int getAoeSize() {
		return aoeSize;
	}

	/**
	 * @param aoeSize the aoeSize to set
	 */
	public void setAoeSize(int aoeSize) {
		this.aoeSize = aoeSize;
	}

	/**
	 * @return the activationTime
	 */
	public int getActivationTime() {
		return activationTime;
	}

	/**
	 * @param activationTime the activationTime to set
	 */
	public void setActivationTime(int activationTime) {
		this.activationTime = activationTime;
	}

	/**
	 * @return the activationType
	 */
	public int getActivationType() {
		return activationType;
	}

	/**
	 * @param activationType the activationType to set
	 */
	public void setActivationType(int activationType) {
		this.activationType = activationType;
	}

	/**
	 * @return the isSilvered
	 */
	public boolean isSilvered() {
		return isSilvered;
	}

	/**
	 * @param isSilvered the isSilvered to set
	 */
	public void setSilvered(boolean isSilvered) {
		this.isSilvered = isSilvered;
	}

	/**
	 * @return the damageBonus
	 */
	public int getDamageBonus() {
		return damageBonus;
	}

	/**
	 * @param damageBonus the damageBonus to set
	 */
	public void setDamageBonus(int damageBonus) {
		this.damageBonus = damageBonus;
	}

	/**
	 * @return the isMartialArts
	 */
	public boolean isMartialArts() {
		return isMartialArts;
	}

	/**
	 * @param isMartialArts the isMartialArts to set
	 */
	public void setMartialArts(boolean isMartialArts) {
		this.isMartialArts = isMartialArts;
	}

	/**
	 * @return the spellRangeType
	 */
	public int getSpellRangeType() {
		return spellRangeType;
	}

	/**
	 * @param spellRangeType the spellRangeType to set
	 */
	public void setSpellRangeType(int spellRangeType) {
		this.spellRangeType = spellRangeType;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + actionType;
		result = prime * result + activationTime;
		result = prime * result + activationType;
		result = prime * result + aoeSize;
		result = prime * result + aoeType;
		result = prime * result + attackSubtype;
		result = prime * result + damageBonus;
		result = prime * result + damageTypeId;
		result = prime * result + diceCount;
		result = prime * result + diceType;
		result = prime * result + (displayAsAttack ? 1231 : 1237);
		result = prime * result + (int) (entityTypeId ^ (entityTypeId >>> 32));
		result = prime * result + fixedSaveDc;
		result = prime * result + fixedValue;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (isMartialArts ? 1231 : 1237);
		result = prime * result + (isOffhand ? 1231 : 1237);
		result = prime * result + (isProficient ? 1231 : 1237);
		result = prime * result + (isSilvered ? 1231 : 1237);
		result = prime * result + longRange;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((onMissDescription == null) ? 0 : onMissDescription.hashCode());
		result = prime * result + range;
		result = prime * result + rangeId;
		result = prime * result + ((saveFailDescription == null) ? 0 : saveFailDescription.hashCode());
		result = prime * result + saveStatId;
		result = prime * result + ((saveSuccessDescription == null) ? 0 : saveSuccessDescription.hashCode());
		result = prime * result + ((snippet == null) ? 0 : snippet.hashCode());
		result = prime * result + spellRangeType;
		result = prime * result + statId;
		result = prime * result + toHitBonus;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomAction other = (CustomAction) obj;
		if (actionType != other.actionType)
			return false;
		if (activationTime != other.activationTime)
			return false;
		if (activationType != other.activationType)
			return false;
		if (aoeSize != other.aoeSize)
			return false;
		if (aoeType != other.aoeType)
			return false;
		if (attackSubtype != other.attackSubtype)
			return false;
		if (damageBonus != other.damageBonus)
			return false;
		if (damageTypeId != other.damageTypeId)
			return false;
		if (diceCount != other.diceCount)
			return false;
		if (diceType != other.diceType)
			return false;
		if (displayAsAttack != other.displayAsAttack)
			return false;
		if (entityTypeId != other.entityTypeId)
			return false;
		if (fixedSaveDc != other.fixedSaveDc)
			return false;
		if (fixedValue != other.fixedValue)
			return false;
		if (id != other.id)
			return false;
		if (isMartialArts != other.isMartialArts)
			return false;
		if (isOffhand != other.isOffhand)
			return false;
		if (isProficient != other.isProficient)
			return false;
		if (isSilvered != other.isSilvered)
			return false;
		if (longRange != other.longRange)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (onMissDescription == null) {
			if (other.onMissDescription != null)
				return false;
		} else if (!onMissDescription.equals(other.onMissDescription))
			return false;
		if (range != other.range)
			return false;
		if (rangeId != other.rangeId)
			return false;
		if (saveFailDescription == null) {
			if (other.saveFailDescription != null)
				return false;
		} else if (!saveFailDescription.equals(other.saveFailDescription))
			return false;
		if (saveStatId != other.saveStatId)
			return false;
		if (saveSuccessDescription == null) {
			if (other.saveSuccessDescription != null)
				return false;
		} else if (!saveSuccessDescription.equals(other.saveSuccessDescription))
			return false;
		if (snippet == null) {
			if (other.snippet != null)
				return false;
		} else if (!snippet.equals(other.snippet))
			return false;
		if (spellRangeType != other.spellRangeType)
			return false;
		if (statId != other.statId)
			return false;
		if (toHitBonus != other.toHitBonus)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CustomAction [id=" + id + ", entityTypeId=" + entityTypeId + ", name=" + name + ", toHitBonus="
				+ toHitBonus + ", snippet=" + snippet + ", isProficient=" + isProficient + ", isOffhand=" + isOffhand
				+ ", statId=" + statId + ", rangeId=" + rangeId + ", diceCount=" + diceCount + ", diceType=" + diceType
				+ ", fixedValue=" + fixedValue + ", damageTypeId=" + damageTypeId + ", onMissDescription="
				+ onMissDescription + ", saveFailDescription=" + saveFailDescription + ", saveSuccessDescription="
				+ saveSuccessDescription + ", saveStatId=" + saveStatId + ", fixedSaveDc=" + fixedSaveDc
				+ ", actionType=" + actionType + ", attackSubtype=" + attackSubtype + ", range=" + range
				+ ", longRange=" + longRange + ", aoeType=" + aoeType + ", aoeSize=" + aoeSize + ", activationTime="
				+ activationTime + ", activationType=" + activationType + ", isSilvered=" + isSilvered
				+ ", damageBonus=" + damageBonus + ", isMartialArts=" + isMartialArts + ", spellRangeType="
				+ spellRangeType + ", displayAsAttack=" + displayAsAttack + "]";
	}
}
