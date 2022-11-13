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
    private Activation activation;
    private int requiredLevel;
    private boolean isSubClassFeature;    
    private boolean hideInBuilder;
    private boolean hideInSheet;
    private int sourceId;
    private int sourcePageNumber;
    private String[] creatureRules;
    private LimitedUse[] limitedUse;
    
    public Definition() {
    	
    }

	/**
	 * @return int the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id int the id to set
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
	 * @param entityTypeId long the entityTypeId to set
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
	 * @param displayOrder int the displayOrder to set
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
	 * @param name String the name to set
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
	 * @param description String the description to set
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
	 * @param snippet String the snippet to set
	 */
	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}

	/**
	 * @return Activation the activation
	 */
	public Activation getActivation() {
		return activation;
	}

	/**
	 * @param activation Activation the activation to set
	 */
	public void setActivation(Activation activation) {
		this.activation = activation;
	}

	/**
	 * @return int the requiredLevel
	 */
	public int getRequiredLevel() {
		return requiredLevel;
	}

	/**
	 * @param requiredLevel int the requiredLevel to set
	 */
	public void setRequiredLevel(int requiredLevel) {
		this.requiredLevel = requiredLevel;
	}

	/**
	 * @return boolean the isSubClassFeature
	 */
	public boolean isSubClassFeature() {
		return isSubClassFeature;
	}

	/**
	 * @param isSubClassFeature boolean the isSubClassFeature to set
	 */
	public void setSubClassFeature(boolean isSubClassFeature) {
		this.isSubClassFeature = isSubClassFeature;
	}

	/**
	 * @return boolean the hideInBuilder
	 */
	public boolean isHideInBuilder() {
		return hideInBuilder;
	}

	/**
	 * @param hideInBuilder boolean the hideInBuilder to set
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
	 * @param hideInSheet boolean the hideInSheet to set
	 */
	public void setHideInSheet(boolean hideInSheet) {
		this.hideInSheet = hideInSheet;
	}

	/**
	 * @return int the sourceId
	 */
	public int getSourceId() {
		return sourceId;
	}

	/**
	 * @param sourceId int the sourceId to set
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
	 * @param sourcePageNumber int the sourcePageNumber to set
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
	 * @param creatureRules String[] the creatureRules to set
	 */
	public void setCreatureRules(String[] creatureRules) {
		this.creatureRules = creatureRules;
	}

	/**
	 * @return LimitedUse[] the limitedUse
	 */
	public LimitedUse[] getLimitedUse() {
		return limitedUse;
	}

	/**
	 * @param limitedUse LimitedUse[] the limitedUse to set
	 */
	public void setLimitedUse(LimitedUse[] limitedUse) {
		this.limitedUse = limitedUse;
	}

	@Override
	public String toString() {
		return "Definition [id=" + id + ", entityTypeId=" + entityTypeId + ", displayOrder=" + displayOrder + ", name="
				+ name + ", description=" + description + ", snippet=" + snippet + ", activation=" + activation
				+ ", requiredLevel=" + requiredLevel + ", isSubClassFeature=" + isSubClassFeature + ", hideInBuilder="
				+ hideInBuilder + ", hideInSheet=" + hideInSheet + ", sourceId=" + sourceId + ", sourcePageNumber="
				+ sourcePageNumber + ", creatureRules=" + Arrays.toString(creatureRules) + ", limitedUse="
				+ Arrays.toString(limitedUse) + "]";
	}

}