package com.patrickborrelli.dndiscord.model.dndbeyond;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for a prerequisite json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Prerequisite {
	private String description;
	private PrerequisiteMapping[] prerequisiteMappings;
	
	public Prerequisite() {
		
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
	 * @return PrerequisiteMapping[] the prerequisiteMappings
	 */
	public PrerequisiteMapping[] getPrerequisiteMappings() {
		return prerequisiteMappings;
	}

	/**
	 * @param PrerequisiteMapping[] the prerequisiteMappings to set
	 */
	public void setPrerequisiteMappings(PrerequisiteMapping[] prerequisiteMappings) {
		this.prerequisiteMappings = prerequisiteMappings;
	}

	@Override
	public String toString() {
		return "Prerequisite [description=" + description + ", prerequisiteMappings="
				+ Arrays.toString(prerequisiteMappings) + "]";
	}
	
}

class PrerequisiteMapping {
	private long id;
	private long entityId;
	private long entityTypeId;
	private String type;
	private String subType;
	private int value;
	private String friendlyTypeName;
	private String friendlySubTypeName;
	
	public PrerequisiteMapping() {
		
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
	 * @return long the entityId
	 */
	public long getEntityId() {
		return entityId;
	}

	/**
	 * @param long the entityId to set
	 */
	public void setEntityId(long entityId) {
		this.entityId = entityId;
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
	 * @return String the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param String the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return String the subType
	 */
	public String getSubType() {
		return subType;
	}

	/**
	 * @param String the subType to set
	 */
	public void setSubType(String subType) {
		this.subType = subType;
	}

	/**
	 * @return int the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param int the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * @return String the friendlyTypeName
	 */
	public String getFriendlyTypeName() {
		return friendlyTypeName;
	}

	/**
	 * @param String the friendlyTypeName to set
	 */
	public void setFriendlyTypeName(String friendlyTypeName) {
		this.friendlyTypeName = friendlyTypeName;
	}

	/**
	 * @return String the friendlySubTypeName
	 */
	public String getFriendlySubTypeName() {
		return friendlySubTypeName;
	}

	/**
	 * @param String the friendlySubTypeName to set
	 */
	public void setFriendlySubTypeName(String friendlySubTypeName) {
		this.friendlySubTypeName = friendlySubTypeName;
	}

	@Override
	public String toString() {
		return "PrerequisiteMapping [id=" + id + ", entityId=" + entityId + ", entityTypeId=" + entityTypeId + ", type="
				+ type + ", subType=" + subType + ", value=" + value + ", friendlyTypeName=" + friendlyTypeName
				+ ", friendlySubTypeName=" + friendlySubTypeName + "]";
	}
}