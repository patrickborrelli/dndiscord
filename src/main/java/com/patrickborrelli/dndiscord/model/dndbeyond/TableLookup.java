package com.patrickborrelli.dndiscord.model.dndbeyond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for a table lookup item json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TableLookup {
	private long id;
	private String description;
	private int diceRoll;
	
	public TableLookup() {
		
	}

	/**
	 * @return long the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param long the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return String the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param String the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return int the diceRoll
	 */
	public int getDiceRoll() {
		return diceRoll;
	}

	/**
	 * @param int the diceRoll to set
	 */
	public void setDiceRoll(int diceRoll) {
		this.diceRoll = diceRoll;
	}

	@Override
	public String toString() {
		return "TableLookup [id=" + id + ", description=" + description + ", diceRoll=" + diceRoll + "]";
	}
	
}
