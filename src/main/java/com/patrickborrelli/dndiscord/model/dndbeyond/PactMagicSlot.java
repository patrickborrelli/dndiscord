package com.patrickborrelli.dndiscord.model.dndbeyond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for a pact magic slot json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PactMagicSlot extends SpellLevel {

	/**
	 * 
	 */
	public PactMagicSlot() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PactMagicSlot [level=" + level + ", used=" + used + ", available=" + available + "]";
	}

}
