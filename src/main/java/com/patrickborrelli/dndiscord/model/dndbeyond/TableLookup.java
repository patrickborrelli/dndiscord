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
	 * @return the diceRoll
	 */
	public int getDiceRoll() {
		return diceRoll;
	}

	/**
	 * @param diceRoll the diceRoll to set
	 */
	public void setDiceRoll(int diceRoll) {
		this.diceRoll = diceRoll;
	}

	@Override
	public String toString() {
		return "TableLookup [id=" + id + ", description=" + description + ", diceRoll=" + diceRoll + "]";
	}

}