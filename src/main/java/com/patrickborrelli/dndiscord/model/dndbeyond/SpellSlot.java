package com.patrickborrelli.dndiscord.model.dndbeyond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for a spell level slot json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SpellSlot extends SpellLevel{

	/**
	 * 
	 */
	public SpellSlot() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SpellSlot [level=" + level + ", used=" + used + ", available=" + available + "]";
	}
}
