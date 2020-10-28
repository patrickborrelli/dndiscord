package com.patrickborrelli.dndiscord.model.dndbeyond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for item damage json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemDamage {

	private int diceCount;
	private int diceValue;
	private int diceMultiplier;
	private int fixedValue;
	private String diceString;
	
	public ItemDamage() {
		
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + diceCount;
		result = prime * result + diceMultiplier;
		result = prime * result + ((diceString == null) ? 0 : diceString.hashCode());
		result = prime * result + diceValue;
		result = prime * result + fixedValue;
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
		ItemDamage other = (ItemDamage) obj;
		if (diceCount != other.diceCount)
			return false;
		if (diceMultiplier != other.diceMultiplier)
			return false;
		if (diceString == null) {
			if (other.diceString != null)
				return false;
		} else if (!diceString.equals(other.diceString))
			return false;
		if (diceValue != other.diceValue)
			return false;
		if (fixedValue != other.fixedValue)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemDamage [diceCount=" + diceCount + ", diceValue=" + diceValue + ", diceMultiplier=" + diceMultiplier
				+ ", fixedValue=" + fixedValue + ", diceString=" + diceString + "]";
	}
	
}
