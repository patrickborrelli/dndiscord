package com.patrickborrelli.dndiscord.model.dndbeyond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for a wealth die json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WealthDie {
	private int diceCount;
	private int diceValue;
	private int diceMultiplier;
	private int fixedValue;
	private String diceString;
	
	public WealthDie() {
		
	}

	/**
	 * @return int the diceCount
	 */
	public int getDiceCount() {
		return diceCount;
	}

	/**
	 * @param int the diceCount to set
	 */
	public void setDiceCount(int diceCount) {
		this.diceCount = diceCount;
	}

	/**
	 * @return int the diceValue
	 */
	public int getDiceValue() {
		return diceValue;
	}

	/**
	 * @param int the diceValue to set
	 */
	public void setDiceValue(int diceValue) {
		this.diceValue = diceValue;
	}

	/**
	 * @return int the diceMultiplier
	 */
	public int getDiceMultiplier() {
		return diceMultiplier;
	}

	/**
	 * @param int the diceMultiplier to set
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
	 * @param int the fixedValue to set
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
	 * @param String the diceString to set
	 */
	public void setDiceString(String diceString) {
		this.diceString = diceString;
	}

	@Override
	public String toString() {
		return "WealthDie [diceCount=" + diceCount + ", diceValue=" + diceValue + ", diceMultiplier=" + diceMultiplier
				+ ", fixedValue=" + fixedValue + ", diceString=" + diceString + "]";
	}
}
