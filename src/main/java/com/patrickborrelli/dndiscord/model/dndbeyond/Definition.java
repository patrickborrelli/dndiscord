package com.patrickborrelli.dndiscord.model.dndbeyond;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for a definition json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public 	class Definition {
	private int id;
	private long entityTypeId;
	private int displayOrder;
	private String name;
	private String description;
    private String snippet;
    private boolean hideInBuilder;
    private boolean hideInSheet;
    private Activation activation;
    private int sourceId;
    private int sourcePageNumber;
    private String[] creatureRules;
    
    public Definition() {
    	
    }

	/**
	 * @return int the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param int the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return long the entityTypeId
	 */
	public long getEntityTypeId() {
		return entityTypeId;
	}

	/**
	 * @param long the entityTypeId to set
	 */
	public void setEntityTypeId(long entityTypeId) {
		this.entityTypeId = entityTypeId;
	}

	/**
	 * @return int the displayOrder
	 */
	public int getDisplayOrder() {
		return displayOrder;
	}

	/**
	 * @param int the displayOrder to set
	 */
	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}

	/**
	 * @return String the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param String the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return String the snippet
	 */
	public String getSnippet() {
		return snippet;
	}

	/**
	 * @param String the snippet to set
	 */
	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}

	/**
	 * @return boolean the hideInBuilder
	 */
	public boolean isHideInBuilder() {
		return hideInBuilder;
	}

	/**
	 * @param boolean the hideInBuilder to set
	 */
	public void setHideInBuilder(boolean hideInBuilder) {
		this.hideInBuilder = hideInBuilder;
	}

	/**
	 * @return boolean the hideInSheet
	 */
	public boolean isHideInSheet() {
		return hideInSheet;
	}

	/**
	 * @param boolean the hideInSheet to set
	 */
	public void setHideInSheet(boolean hideInSheet) {
		this.hideInSheet = hideInSheet;
	}

	/**
	 * @return Activation the activation
	 */
	public Activation getActivation() {
		return activation;
	}

	/**
	 * @param Activation the activation to set
	 */
	public void setActivation(Activation activation) {
		this.activation = activation;
	}

	/**
	 * @return int the sourceId
	 */
	public int getSourceId() {
		return sourceId;
	}

	/**
	 * @param int the sourceId to set
	 */
	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}

	/**
	 * @return int the sourcePageNumber
	 */
	public int getSourcePageNumber() {
		return sourcePageNumber;
	}

	/**
	 * @param int the sourcePageNumber to set
	 */
	public void setSourcePageNumber(int sourcePageNumber) {
		this.sourcePageNumber = sourcePageNumber;
	}

	/**
	 * @return String[] the creatureRules
	 */
	public String[] getCreatureRules() {
		return creatureRules;
	}

	/**
	 * @param String[] the creatureRules to set
	 */
	public void setCreatureRules(String[] creatureRules) {
		this.creatureRules = creatureRules;
	}

	@Override
	public String toString() {
		return "Definition [id=" + id + ", entityTypeId=" + entityTypeId + ", displayOrder=" + displayOrder
				+ ", name=" + name + ", description=" + description + ", snippet=" + snippet + ", hideInBuilder="
				+ hideInBuilder + ", hideInSheet=" + hideInSheet + ", activation=" + activation + ", sourceId="
				+ sourceId + ", sourcePageNumber=" + sourcePageNumber + ", creatureRules="
				+ Arrays.toString(creatureRules) + "]";
	}   
}
