package com.patrickborrelli.dndiscord.model.dndbeyond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for a custom background json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomBackground {
	private long id;
	private long entityTypeId;
	private String name;
	private String description;
	private String featuresBackground;
	private String characteristicsBackground;
	private String backgroundType;

	public CustomBackground() {
		
	}

	/**
	 * @return long the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param long the id to set
	 */
	public void setId(long id) {
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
	 * @return String the featuresBackground
	 */
	public String getFeaturesBackground() {
		return featuresBackground;
	}

	/**
	 * @param String the featuresBackground to set
	 */
	public void setFeaturesBackground(String featuresBackground) {
		this.featuresBackground = featuresBackground;
	}

	/**
	 * @return String the characteristicsBackground
	 */
	public String getCharacteristicsBackground() {
		return characteristicsBackground;
	}

	/**
	 * @param String the characteristicsBackground to set
	 */
	public void setCharacteristicsBackground(String characteristicsBackground) {
		this.characteristicsBackground = characteristicsBackground;
	}

	/**
	 * @return String the backgroundType
	 */
	public String getBackgroundType() {
		return backgroundType;
	}

	/**
	 * @param String the backgroundType to set
	 */
	public void setBackgroundType(String backgroundType) {
		this.backgroundType = backgroundType;
	}

	@Override
	public String toString() {
		return "CustomBackground [id=" + id + ", entityTypeId=" + entityTypeId + ", name=" + name + ", description="
				+ description + ", featuresBackground=" + featuresBackground + ", characteristicsBackground="
				+ characteristicsBackground + ", backgroundType=" + backgroundType + "]";
	}
	
}
