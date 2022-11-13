package com.patrickborrelli.dndiscord.model.dndiscord;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.patrickborrelli.dndiscord.utilities.ActionType;
import com.patrickborrelli.dndiscord.utilities.ActivationType;
import com.patrickborrelli.dndiscord.utilities.AttackSubtype;
import com.patrickborrelli.dndiscord.utilities.DamageType;
import com.patrickborrelli.dndiscord.utilities.FeatureType;
import com.patrickborrelli.dndiscord.utilities.ResetType;
import com.patrickborrelli.dndiscord.utilities.StatType;

/**
 * Model of dDnDiscord Character Action.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Action {
	
	private String name;
	private String description;
	private String snippet;
	private FeatureType type;
	private StatType abilityModifierStat;
	private ActionType actionType;
	
	//###########################
	//the contents of these elements from the DNDBeyond schema are unknown:
	private int attackTypeRange;
	private int value;
	private String spellRangeType;
	//###########################
	
	//for actions with associated damage:
	private int dieCount;
	private int dieValue;
	private int diceMultiplier;
	private int fixedValue;
	private String diceString;
	private AttackSubtype attackSubtype;
	private String onMissDescription;
	private DamageType damageType;
	private boolean martialArt;
	private boolean proficient;
	private boolean displayAsAttack;
	
	//for actions that have a range:
	private String origin;
    private int rangeValue;
    private String aoeSize;
    private String aoeType;
    private int aoeValue;
    private boolean aoeSpecialDescription;
    private int range;
    private int longRange;
	
	//for actions with saving throws:
	private String saveFailDescription;
	private String saveSuccessDescription;
	private StatType saveStat;
	private int fixedSaveDc;
	
	//for limited use actions:
	private ResetType resetType;
    private int numberUsed;
    private int maxUses;
    
    //triggering action type:
    private ActivationType activationType;
	private int duration;
	
	public Action() {
		
	}

	/**
	 * @return String the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name String the name to set
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
	 * @param description String the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return String the snippet
	 */
	public String getSnippet() {
		return snippet;
	}

	/**
	 * @param snippet String the snippet to set
	 */
	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}

	/**
	 * @return FeatureType the type
	 */
	public FeatureType getType() {
		return type;
	}

	/**
	 * @param type FeatureType the type to set
	 */
	public void setType(FeatureType type) {
		this.type = type;
	}

	/**
	 * @return StatType the abilityModifierStat
	 */
	public StatType getAbilityModifierStat() {
		return abilityModifierStat;
	}

	/**
	 * @param abilityModifierStat StatType the abilityModifierStat to set
	 */
	public void setAbilityModifierStat(StatType abilityModifierStat) {
		this.abilityModifierStat = abilityModifierStat;
	}

	/**
	 * @return ActionType the actionType
	 */
	public ActionType getActionType() {
		return actionType;
	}

	/**
	 * @param actionType ActionType the actionType to set
	 */
	public void setActionType(ActionType actionType) {
		this.actionType = actionType;
	}

	/**
	 * @return int the attackTypeRange
	 */
	public int getAttackTypeRange() {
		return attackTypeRange;
	}

	/**
	 * @param attackTypeRange int the attackTypeRange to set
	 */
	public void setAttackTypeRange(int attackTypeRange) {
		this.attackTypeRange = attackTypeRange;
	}

	/**
	 * @return int the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value int the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * @return String the spellRangeType
	 */
	public String getSpellRangeType() {
		return spellRangeType;
	}

	/**
	 * @param spellRangeType String the spellRangeType to set
	 */
	public void setSpellRangeType(String spellRangeType) {
		this.spellRangeType = spellRangeType;
	}

	/**
	 * @return int the dieCount
	 */
	public int getDieCount() {
		return dieCount;
	}

	/**
	 * @param dieCount int the dieCount to set
	 */
	public void setDieCount(int dieCount) {
		this.dieCount = dieCount;
	}

	/**
	 * @return int the dieValue
	 */
	public int getDieValue() {
		return dieValue;
	}

	/**
	 * @param dieValue int the dieValue to set
	 */
	public void setDieValue(int dieValue) {
		this.dieValue = dieValue;
	}

	/**
	 * @return int the diceMultiplier
	 */
	public int getDiceMultiplier() {
		return diceMultiplier;
	}

	/**
	 * @param diceMultiplier int the diceMultiplier to set
	 */
	public void setDiceMultiplier(int diceMultiplier) {
		this.diceMultiplier = diceMultiplier;
	}

	/**
	 * @return int the fixedValue
	 */
	public int getFixedValue() {
		return fixedValue;
	}

	/**
	 * @param fixedValue int the fixedValue to set
	 */
	public void setFixedValue(int fixedValue) {
		this.fixedValue = fixedValue;
	}

	/**
	 * @return String the diceString
	 */
	public String getDiceString() {
		return diceString;
	}

	/**
	 * @param diceString String the diceString to set
	 */
	public void setDiceString(String diceString) {
		this.diceString = diceString;
	}

	/**
	 * @return AttackSubtype the attackSubtype
	 */
	public AttackSubtype getAttackSubtype() {
		return attackSubtype;
	}

	/**
	 * @param attackSubtype AttackSubtype the attackSubtype to set
	 */
	public void setAttackSubtype(AttackSubtype attackSubtype) {
		this.attackSubtype = attackSubtype;
	}

	/**
	 * @return String the onMissDescription
	 */
	public String getOnMissDescription() {
		return onMissDescription;
	}

	/**
	 * @param onMissDescription String the onMissDescription to set
	 */
	public void setOnMissDescription(String onMissDescription) {
		this.onMissDescription = onMissDescription;
	}

	/**
	 * @return DamageType the damageType
	 */
	public DamageType getDamageType() {
		return damageType;
	}

	/**
	 * @param damageType DamageType the damageType to set
	 */
	public void setDamageType(DamageType damageType) {
		this.damageType = damageType;
	}

	/**
	 * @return boolean the martialArt
	 */
	public boolean isMartialArt() {
		return martialArt;
	}

	/**
	 * @param martialArt boolean the martialArt to set
	 */
	public void setMartialArt(boolean martialArt) {
		this.martialArt = martialArt;
	}

	/**
	 * @return boolean the proficient
	 */
	public boolean isProficient() {
		return proficient;
	}

	/**
	 * @param proficient boolean the proficient to set
	 */
	public void setProficient(boolean proficient) {
		this.proficient = proficient;
	}

	/**
	 * @return boolean the displayAsAttack
	 */
	public boolean isDisplayAsAttack() {
		return displayAsAttack;
	}

	/**
	 * @param displayAsAttack boolean the displayAsAttack to set
	 */
	public void setDisplayAsAttack(boolean displayAsAttack) {
		this.displayAsAttack = displayAsAttack;
	}

	/**
	 * @return String the origin
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * @param origin String the origin to set
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	/**
	 * @return int the rangeValue
	 */
	public int getRangeValue() {
		return rangeValue;
	}

	/**
	 * @param rangeValue int the rangeValue to set
	 */
	public void setRangeValue(int rangeValue) {
		this.rangeValue = rangeValue;
	}

	/**
	 * @return String the aoeSize
	 */
	public String getAoeSize() {
		return aoeSize;
	}

	/**
	 * @param aoeSize String the aoeSize to set
	 */
	public void setAoeSize(String aoeSize) {
		this.aoeSize = aoeSize;
	}

	/**
	 * @return String the aoeType
	 */
	public String getAoeType() {
		return aoeType;
	}

	/**
	 * @param aoeType String the aoeType to set
	 */
	public void setAoeType(String aoeType) {
		this.aoeType = aoeType;
	}

	/**
	 * @return int the aoeValue
	 */
	public int getAoeValue() {
		return aoeValue;
	}

	/**
	 * @param aoeValue int the aoeValue to set
	 */
	public void setAoeValue(int aoeValue) {
		this.aoeValue = aoeValue;
	}

	/**
	 * @return boolean the aoeSpecialDescription
	 */
	public boolean isAoeSpecialDescription() {
		return aoeSpecialDescription;
	}

	/**
	 * @param aoeSpecialDescription boolean the aoeSpecialDescription to set
	 */
	public void setAoeSpecialDescription(boolean aoeSpecialDescription) {
		this.aoeSpecialDescription = aoeSpecialDescription;
	}

	/**
	 * @return int the range
	 */
	public int getRange() {
		return range;
	}

	/**
	 * @param range int the range to set
	 */
	public void setRange(int range) {
		this.range = range;
	}

	/**
	 * @return int the longRange
	 */
	public int getLongRange() {
		return longRange;
	}

	/**
	 * @param longRange int the longRange to set
	 */
	public void setLongRange(int longRange) {
		this.longRange = longRange;
	}

	/**
	 * @return String the saveFailDescription
	 */
	public String getSaveFailDescription() {
		return saveFailDescription;
	}

	/**
	 * @param saveFailDescription String the saveFailDescription to set
	 */
	public void setSaveFailDescription(String saveFailDescription) {
		this.saveFailDescription = saveFailDescription;
	}

	/**
	 * @return String the saveSuccessDescription
	 */
	public String getSaveSuccessDescription() {
		return saveSuccessDescription;
	}

	/**
	 * @param saveSuccessDescription String the saveSuccessDescription to set
	 */
	public void setSaveSuccessDescription(String saveSuccessDescription) {
		this.saveSuccessDescription = saveSuccessDescription;
	}

	/**
	 * @return StatType the saveStat
	 */
	public StatType getSaveStat() {
		return saveStat;
	}

	/**
	 * @param saveStat StatType the saveStat to set
	 */
	public void setSaveStat(StatType saveStat) {
		this.saveStat = saveStat;
	}

	/**
	 * @return int the fixedSaveDc
	 */
	public int getFixedSaveDc() {
		return fixedSaveDc;
	}

	/**
	 * @param fixedSaveDc int the fixedSaveDc to set
	 */
	public void setFixedSaveDc(int fixedSaveDc) {
		this.fixedSaveDc = fixedSaveDc;
	}

	/**
	 * @return ResetType the resetType
	 */
	public ResetType getResetType() {
		return resetType;
	}

	/**
	 * @param resetType ResetType the resetType to set
	 */
	public void setResetType(ResetType resetType) {
		this.resetType = resetType;
	}

	/**
	 * @return int the numberUsed
	 */
	public int getNumberUsed() {
		return numberUsed;
	}

	/**
	 * @param numberUsed int the numberUsed to set
	 */
	public void setNumberUsed(int numberUsed) {
		this.numberUsed = numberUsed;
	}

	/**
	 * @return int the maxUses
	 */
	public int getMaxUses() {
		return maxUses;
	}

	/**
	 * @param maxUses int the maxUses to set
	 */
	public void setMaxUses(int maxUses) {
		this.maxUses = maxUses;
	}

	/**
	 * @return ActivationType the activationType
	 */
	public ActivationType getActivationType() {
		return activationType;
	}

	/**
	 * @param activationType ActivationType the activationType to set
	 */
	public void setActivationType(ActivationType activationType) {
		this.activationType = activationType;
	}

	/**
	 * @return int the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * @param duration int the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abilityModifierStat == null) ? 0 : abilityModifierStat.hashCode());
		result = prime * result + ((actionType == null) ? 0 : actionType.hashCode());
		result = prime * result + ((activationType == null) ? 0 : activationType.hashCode());
		result = prime * result + ((aoeSize == null) ? 0 : aoeSize.hashCode());
		result = prime * result + (aoeSpecialDescription ? 1231 : 1237);
		result = prime * result + ((aoeType == null) ? 0 : aoeType.hashCode());
		result = prime * result + aoeValue;
		result = prime * result + ((attackSubtype == null) ? 0 : attackSubtype.hashCode());
		result = prime * result + attackTypeRange;
		result = prime * result + ((damageType == null) ? 0 : damageType.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + diceMultiplier;
		result = prime * result + ((diceString == null) ? 0 : diceString.hashCode());
		result = prime * result + dieCount;
		result = prime * result + dieValue;
		result = prime * result + (displayAsAttack ? 1231 : 1237);
		result = prime * result + duration;
		result = prime * result + fixedSaveDc;
		result = prime * result + fixedValue;
		result = prime * result + longRange;
		result = prime * result + (martialArt ? 1231 : 1237);
		result = prime * result + maxUses;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + numberUsed;
		result = prime * result + ((onMissDescription == null) ? 0 : onMissDescription.hashCode());
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		result = prime * result + (proficient ? 1231 : 1237);
		result = prime * result + range;
		result = prime * result + rangeValue;
		result = prime * result + ((resetType == null) ? 0 : resetType.hashCode());
		result = prime * result + ((saveFailDescription == null) ? 0 : saveFailDescription.hashCode());
		result = prime * result + ((saveStat == null) ? 0 : saveStat.hashCode());
		result = prime * result + ((saveSuccessDescription == null) ? 0 : saveSuccessDescription.hashCode());
		result = prime * result + ((snippet == null) ? 0 : snippet.hashCode());
		result = prime * result + ((spellRangeType == null) ? 0 : spellRangeType.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + value;
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
		Action other = (Action) obj;
		if (abilityModifierStat != other.abilityModifierStat)
			return false;
		if (actionType != other.actionType)
			return false;
		if (activationType != other.activationType)
			return false;
		if (aoeSize == null) {
			if (other.aoeSize != null)
				return false;
		} else if (!aoeSize.equals(other.aoeSize))
			return false;
		if (aoeSpecialDescription != other.aoeSpecialDescription)
			return false;
		if (aoeType == null) {
			if (other.aoeType != null)
				return false;
		} else if (!aoeType.equals(other.aoeType))
			return false;
		if (aoeValue != other.aoeValue)
			return false;
		if (attackSubtype != other.attackSubtype)
			return false;
		if (attackTypeRange != other.attackTypeRange)
			return false;
		if (damageType != other.damageType)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (diceMultiplier != other.diceMultiplier)
			return false;
		if (diceString == null) {
			if (other.diceString != null)
				return false;
		} else if (!diceString.equals(other.diceString))
			return false;
		if (dieCount != other.dieCount)
			return false;
		if (dieValue != other.dieValue)
			return false;
		if (displayAsAttack != other.displayAsAttack)
			return false;
		if (duration != other.duration)
			return false;
		if (fixedSaveDc != other.fixedSaveDc)
			return false;
		if (fixedValue != other.fixedValue)
			return false;
		if (longRange != other.longRange)
			return false;
		if (martialArt != other.martialArt)
			return false;
		if (maxUses != other.maxUses)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numberUsed != other.numberUsed)
			return false;
		if (onMissDescription == null) {
			if (other.onMissDescription != null)
				return false;
		} else if (!onMissDescription.equals(other.onMissDescription))
			return false;
		if (origin == null) {
			if (other.origin != null)
				return false;
		} else if (!origin.equals(other.origin))
			return false;
		if (proficient != other.proficient)
			return false;
		if (range != other.range)
			return false;
		if (rangeValue != other.rangeValue)
			return false;
		if (resetType != other.resetType)
			return false;
		if (saveFailDescription == null) {
			if (other.saveFailDescription != null)
				return false;
		} else if (!saveFailDescription.equals(other.saveFailDescription))
			return false;
		if (saveStat != other.saveStat)
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
		if (spellRangeType == null) {
			if (other.spellRangeType != null)
				return false;
		} else if (!spellRangeType.equals(other.spellRangeType))
			return false;
		if (type != other.type)
			return false;
		if (value != other.value)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Action [name=" + name + ", description=" + description + ", snippet=" + snippet + ", type=" + type
				+ ", abilityModifierStat=" + abilityModifierStat + ", actionType=" + actionType + ", attackTypeRange="
				+ attackTypeRange + ", value=" + value + ", spellRangeType=" + spellRangeType + ", dieCount=" + dieCount
				+ ", dieValue=" + dieValue + ", diceMultiplier=" + diceMultiplier + ", fixedValue=" + fixedValue
				+ ", diceString=" + diceString + ", attackSubtype=" + attackSubtype + ", onMissDescription="
				+ onMissDescription + ", damageType=" + damageType + ", martialArt=" + martialArt + ", proficient="
				+ proficient + ", displayAsAttack=" + displayAsAttack + ", origin=" + origin + ", rangeValue="
				+ rangeValue + ", aoeSize=" + aoeSize + ", aoeType=" + aoeType + ", aoeValue=" + aoeValue
				+ ", aoeSpecialDescription=" + aoeSpecialDescription + ", range=" + range + ", longRange=" + longRange
				+ ", saveFailDescription=" + saveFailDescription + ", saveSuccessDescription=" + saveSuccessDescription
				+ ", saveStat=" + saveStat + ", fixedSaveDc=" + fixedSaveDc + ", resetType=" + resetType
				+ ", numberUsed=" + numberUsed + ", maxUses=" + maxUses + ", activationType=" + activationType
				+ ", duration=" + duration + "]";
	}
}
