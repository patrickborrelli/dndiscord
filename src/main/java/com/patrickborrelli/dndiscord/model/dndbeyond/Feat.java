package com.patrickborrelli.dndiscord.model.dndbeyond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for a feat json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Feat {
	private int componentId;
	private Definition definition;
	
	public Feat() {
		
	}

	/**
	 * @return int the componentId
	 */
	public int getComponentId() {
		return componentId;
	}

	/**
	 * @param componentId int the componentId to set
	 */
	public void setComponentId(int componentId) {
		this.componentId = componentId;
	}

	/**
	 * @return Definition the definition
	 */
	public Definition getDefinition() {
		return definition;
	}

	/**
	 * @param definition Definition the definition to set
	 */
	public void setDefinition(Definition definition) {
		this.definition = definition;
	}

	@Override
	public String toString() {
		return "Feat [componentId=" + componentId + ", definition=" + definition + "]";
	}
}
