package com.patrickborrelli.dndiscord.model.dndbeyond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for a racial trait json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RacialTrait {

	private Definition definition;
	
	public RacialTrait() {
		
	}
	
	/**
	 * @return Definition the definition
	 */
	public Definition getDefinition() {
		return definition;
	}

	/**
	 * @param Definition the definition to set
	 */
	public void setDefinition(Definition definition) {
		this.definition = definition;
	}

	@Override
	public String toString() {
		return "RacialTrait [definition=" + definition + "]";
	}
}

