package com.patrickborrelli.dndiscord.model.dndbeyond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for an option json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Option {

	private Definition definition;
	private int componentId;
	private int componentTypeId;
	
	public Option() {
		
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
	 * @return int the componentTypeId
	 */
	public int getComponentTypeId() {
		return componentTypeId;
	}

	/**
	 * @param componentTypeId int the componentTypeId to set
	 */
	public void setComponentTypeId(int componentTypeId) {
		this.componentTypeId = componentTypeId;
	}

	@Override
	public String toString() {
		return "Option [definition=" + definition + ", componentId=" + componentId + ", componentTypeId="
				+ componentTypeId + "]";
	}
}
