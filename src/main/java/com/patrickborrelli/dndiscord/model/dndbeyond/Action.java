/**
 * 
 */
package com.patrickborrelli.dndiscord.model.dndbeyond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for an Action json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Action {

	private int id;
	private int entityTypeId;
	private LimitedUse limitedUse;
	private String name;
	private String description;
	private int abilityModifierStatId;
	private String onMissDescription;
	private String saveFailDescription;
	private String saveSuccessDescription;
	private int saveStatId;
	private int fixedSaveDc;
	private int attackTypeRange;
	private int actionType;
	private int attackSubtype;
	private ItemDamage dice;
	private int value;
	private int damageTypeId;
	private boolean isMartialArts;
	private boolean isProficient;
	private String spellRangeType;
	private boolean displayAsAttack;
	private Range range;
	private Activation activation;
	private int componentId;
	private int componentTypeId;
	
	public Action() {
		
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
	public int getEntityTypeId() {
		return entityTypeId;
	}

	/**
	 * @param entityTypeId the entityTypeId to set
	 */
	public void setEntityTypeId(int entityTypeId) {
		this.entityTypeId = entityTypeId;
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
	 * @return the abilityModifierStatId
	 */
	public int getAbilityModifierStatId() {
		return abilityModifierStatId;
	}

	/**
	 * @param abilityModifierStatId the abilityModifierStatId to set
	 */
	public void setAbilityModifierStatId(int abilityModifierStatId) {
		this.abilityModifierStatId = abilityModifierStatId;
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
	 * @return the attackTypeRange
	 */
	public int getAttackTypeRange() {
		return attackTypeRange;
	}

	/**
	 * @param attackTypeRange the attackTypeRange to set
	 */
	public void setAttackTypeRange(int attackTypeRange) {
		this.attackTypeRange = attackTypeRange;
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
	 * @return the dice
	 */
	public ItemDamage getDice() {
		return dice;
	}

	/**
	 * @param dice the dice to set
	 */
	public void setDice(ItemDamage dice) {
		this.dice = dice;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
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
	 * @return the spellRangeType
	 */
	public String getSpellRangeType() {
		return spellRangeType;
	}

	/**
	 * @param spellRangeType the spellRangeType to set
	 */
	public void setSpellRangeType(String spellRangeType) {
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
	public int getComponentTypeId() {
		return componentTypeId;
	}

	/**
	 * @param componentTypeId the componentTypeId to set
	 */
	public void setComponentTypeId(int componentTypeId) {
		this.componentTypeId = componentTypeId;
	}

	@Override
	public String toString() {
		return "Action [id=" + id + ", entityTypeId=" + entityTypeId + ", limitedUse=" + limitedUse + ", name=" + name
				+ ", description=" + description + ", abilityModifierStatId=" + abilityModifierStatId
				+ ", onMissDescription=" + onMissDescription + ", saveFailDescription=" + saveFailDescription
				+ ", saveSuccessDescription=" + saveSuccessDescription + ", saveStatId=" + saveStatId + ", fixedSaveDc="
				+ fixedSaveDc + ", attackTypeRange=" + attackTypeRange + ", actionType=" + actionType
				+ ", attackSubtype=" + attackSubtype + ", dice=" + dice + ", value=" + value + ", damageTypeId="
				+ damageTypeId + ", isMartialArts=" + isMartialArts + ", isProficient=" + isProficient
				+ ", spellRangeType=" + spellRangeType + ", displayAsAttack=" + displayAsAttack + ", range=" + range
				+ ", activation=" + activation + ", componentId=" + componentId + ", componentTypeId=" + componentTypeId
				+ "]";
	}
	
}
