package com.patrickborrelli.dndiscord.model.dndbeyond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for a class feature json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClassFeature {

	private Definition definition;
	
	public ClassFeature() {
	
	}

	/**
	 * @return the definition
	 */
	public Definition getDefinition() {
		return definition;
	}

	/**
	 * @param definition the definition to set
	 */
	public void setDefinition(Definition definition) {
		this.definition = definition;
	}

	@Override
	public String toString() {
		return "ClassFeature [definition=" + definition + "]";
	}
}
