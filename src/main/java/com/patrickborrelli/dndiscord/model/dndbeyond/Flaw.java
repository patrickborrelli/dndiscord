package com.patrickborrelli.dndiscord.model.dndbeyond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for a flaw json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Flaw extends TableLookup {
	private long id;
	private String description;
	private int diceRoll;

	public Flaw() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Flaw [id=" + id + ", description=" + description + ", diceRoll=" + diceRoll + "]";
	}
}
