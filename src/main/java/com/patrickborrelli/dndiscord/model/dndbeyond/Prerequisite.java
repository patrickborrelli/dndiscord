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
	 * @return the prerequisiteMappings
	 */
	public PrerequisiteMapping[] getPrerequisiteMappings() {
		return prerequisiteMappings;
	}

	/**
	 * @param prerequisiteMappings the prerequisiteMappings to set
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
	 * @return the entityId
	 */
	public long getEntityId() {
		return entityId;
	}

	/**
	 * @param entityId the entityId to set
	 */
	public void setEntityId(long entityId) {
		this.entityId = entityId;
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the subType
	 */
	public String getSubType() {
		return subType;
	}

	/**
	 * @param subType the subType to set
	 */
	public void setSubType(String subType) {
		this.subType = subType;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * @return the friendlyTypeName
	 */
	public String getFriendlyTypeName() {
		return friendlyTypeName;
	}

	/**
	 * @param friendlyTypeName the friendlyTypeName to set
	 */
	public void setFriendlyTypeName(String friendlyTypeName) {
		this.friendlyTypeName = friendlyTypeName;
	}

	/**
	 * @return the friendlySubTypeName
	 */
	public String getFriendlySubTypeName() {
		return friendlySubTypeName;
	}

	/**
	 * @param friendlySubTypeName the friendlySubTypeName to set
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