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
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the entityTypeId
	 */
	public long getEntityTypeId() {
		return entityTypeId;
	}

	/**
	 * @param entityTypeId the entityTypeId to set
	 */
	public void setEntityTypeId(long entityTypeId) {
		this.entityTypeId = entityTypeId;
	}

	/**
	 * @return the displayOrder
	 */
	public int getDisplayOrder() {
		return displayOrder;
	}

	/**
	 * @param displayOrder the displayOrder to set
	 */
	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the snippet
	 */
	public String getSnippet() {
		return snippet;
	}

	/**
	 * @param snippet the snippet to set
	 */
	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}

	/**
	 * @return the hideInBuilder
	 */
	public boolean isHideInBuilder() {
		return hideInBuilder;
	}

	/**
	 * @param hideInBuilder the hideInBuilder to set
	 */
	public void setHideInBuilder(boolean hideInBuilder) {
		this.hideInBuilder = hideInBuilder;
	}

	/**
	 * @return the hideInSheet
	 */
	public boolean isHideInSheet() {
		return hideInSheet;
	}

	/**
	 * @param hideInSheet the hideInSheet to set
	 */
	public void setHideInSheet(boolean hideInSheet) {
		this.hideInSheet = hideInSheet;
	}

	/**
	 * @return the activation
	 */
	public Activation getActivation() {
		return activation;
	}

	/**
	 * @param activation the activation to set
	 */
	public void setActivation(Activation activation) {
		this.activation = activation;
	}

	/**
	 * @return the sourceId
	 */
	public int getSourceId() {
		return sourceId;
	}

	/**
	 * @param sourceId the sourceId to set
	 */
	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}

	/**
	 * @return the sourcePageNumber
	 */
	public int getSourcePageNumber() {
		return sourcePageNumber;
	}

	/**
	 * @param sourcePageNumber the sourcePageNumber to set
	 */
	public void setSourcePageNumber(int sourcePageNumber) {
		this.sourcePageNumber = sourcePageNumber;
	}

	/**
	 * @return the creatureRules
	 */
	public String[] getCreatureRules() {
		return creatureRules;
	}

	/**
	 * @param creatureRules the creatureRules to set
	 */
	public void setCreatureRules(String[] creatureRules) {
		this.creatureRules = creatureRules;
	}

	@Override
	public String toString() {
		return "Definition [id=" + id + ", entityTypeId=" + entityTypeId + ", displayOrder=" + displayOrder + ", name="
				+ name + ", description=" + description + ", snippet=" + snippet + ", hideInBuilder=" + hideInBuilder
				+ ", hideInSheet=" + hideInSheet + ", activation=" + activation + ", sourceId=" + sourceId
				+ ", sourcePageNumber=" + sourcePageNumber + ", creatureRules=" + Arrays.toString(creatureRules) + "]";
	}

}