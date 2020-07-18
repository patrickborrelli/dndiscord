package com.patrickborrelli.dndiscord.model.dndbeyond;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Simple model for a ThemeColor json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ThemeColor {
	@JsonProperty("themeColorId")
	private long id;
	private String themeColor;
	private String backgroundColor;
	private String name;
	private long raceId;
	private long subRaceId;
	private long classId;
	private String[] tags;
	
	public ThemeColor() {
		
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the themeColor
	 */
	public String getThemeColor() {
		return themeColor;
	}

	/**
	 * @param themeColor the themeColor to set
	 */
	public void setThemeColor(String themeColor) {
		this.themeColor = themeColor;
	}

	/**
	 * @return the backgroundColor
	 */
	public String getBackgroundColor() {
		return backgroundColor;
	}

	/**
	 * @param backgroundColor the backgroundColor to set
	 */
	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
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
	 * @return the raceId
	 */
	public long getRaceId() {
		return raceId;
	}

	/**
	 * @param raceId the raceId to set
	 */
	public void setRaceId(long raceId) {
		this.raceId = raceId;
	}

	/**
	 * @return the subRaceId
	 */
	public long getSubRaceId() {
		return subRaceId;
	}

	/**
	 * @param subRaceId the subRaceId to set
	 */
	public void setSubRaceId(long subRaceId) {
		this.subRaceId = subRaceId;
	}

	/**
	 * @return the classId
	 */
	public long getClassId() {
		return classId;
	}

	/**
	 * @param classId the classId to set
	 */
	public void setClassId(long classId) {
		this.classId = classId;
	}

	/**
	 * @return the tags
	 */
	public String[] getTags() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(String[] tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "ThemeColor [id=" + id + ", themeColor=" + themeColor + ", backgroundColor=" + backgroundColor
				+ ", name=" + name + ", raceId=" + raceId + ", subRaceId=" + subRaceId + ", classId=" + classId
				+ ", tags=" + Arrays.toString(tags) + "]";
	}
	
}
