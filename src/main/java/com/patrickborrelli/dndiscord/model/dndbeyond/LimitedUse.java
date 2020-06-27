package com.patrickborrelli.dndiscord.model.dndbeyond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for a limited use json block, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LimitedUse {

    private String name;
    private int statModifierUsesId;
    private String resetType;
    private String resetTypeDescription;
    private int numberUsed;
    private int minNumberConsumed;
    private int maxNumberConsumed;
    private int maxUses;
    private int operator;
    
    public LimitedUse() {
    	
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
	 * @return the statModifierUsesId
	 */
	public int getStatModifierUsesId() {
		return statModifierUsesId;
	}

	/**
	 * @param statModifierUsesId the statModifierUsesId to set
	 */
	public void setStatModifierUsesId(int statModifierUsesId) {
		this.statModifierUsesId = statModifierUsesId;
	}

	/**
	 * @return the resetType
	 */
	public String getResetType() {
		return resetType;
	}

	/**
	 * @param resetType the resetType to set
	 */
	public void setResetType(String resetType) {
		this.resetType = resetType;
	}

	/**
	 * @return the resetTypeDescription
	 */
	public String getResetTypeDescription() {
		return resetTypeDescription;
	}

	/**
	 * @param resetTypeDescription the resetTypeDescription to set
	 */
	public void setResetTypeDescription(String resetTypeDescription) {
		this.resetTypeDescription = resetTypeDescription;
	}

	/**
	 * @return the numberUsed
	 */
	public int getNumberUsed() {
		return numberUsed;
	}

	/**
	 * @param numberUsed the numberUsed to set
	 */
	public void setNumberUsed(int numberUsed) {
		this.numberUsed = numberUsed;
	}

	/**
	 * @return the minNumberConsumed
	 */
	public int getMinNumberConsumed() {
		return minNumberConsumed;
	}

	/**
	 * @param minNumberConsumed the minNumberConsumed to set
	 */
	public void setMinNumberConsumed(int minNumberConsumed) {
		this.minNumberConsumed = minNumberConsumed;
	}

	/**
	 * @return the maxNumberConsumed
	 */
	public int getMaxNumberConsumed() {
		return maxNumberConsumed;
	}

	/**
	 * @param maxNumberConsumed the maxNumberConsumed to set
	 */
	public void setMaxNumberConsumed(int maxNumberConsumed) {
		this.maxNumberConsumed = maxNumberConsumed;
	}

	/**
	 * @return the maxUses
	 */
	public int getMaxUses() {
		return maxUses;
	}

	/**
	 * @param maxUses the maxUses to set
	 */
	public void setMaxUses(int maxUses) {
		this.maxUses = maxUses;
	}

	/**
	 * @return the operator
	 */
	public int getOperator() {
		return operator;
	}

	/**
	 * @param operator the operator to set
	 */
	public void setOperator(int operator) {
		this.operator = operator;
	}

	@Override
	public String toString() {
		return "LimitedUse [name=" + name + ", statModifierUsesId=" + statModifierUsesId + ", resetType=" + resetType
				+ ", resetTypeDescription=" + resetTypeDescription + ", numberUsed=" + numberUsed
				+ ", minNumberConsumed=" + minNumberConsumed + ", maxNumberConsumed=" + maxNumberConsumed + ", maxUses="
				+ maxUses + ", operator=" + operator + "]";
	}

}