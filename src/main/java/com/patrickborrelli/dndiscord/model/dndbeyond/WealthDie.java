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
	 * @return the diceValue
	 */
	public int getDiceValue() {
		return diceValue;
	}

	/**
	 * @param diceValue the diceValue to set
	 */
	public void setDiceValue(int diceValue) {
		this.diceValue = diceValue;
	}

	/**
	 * @return the diceMultiplier
	 */
	public int getDiceMultiplier() {
		return diceMultiplier;
	}

	/**
	 * @param diceMultiplier the diceMultiplier to set
	 */
	public void setDiceMultiplier(int diceMultiplier) {
		this.diceMultiplier = diceMultiplier;
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
	 * @return the diceString
	 */
	public String getDiceString() {
		return diceString;
	}

	/**
	 * @param diceString the diceString to set
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