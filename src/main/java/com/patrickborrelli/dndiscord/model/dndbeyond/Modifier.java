package com.patrickborrelli.dndiscord.model.dndbeyond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for a modifier json element.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Modifier {
	
	private String id;
	private String entityId;
	private String entityTypeId;
	private String type;
	private String subType;
	private Dice dice;
	private String restriction;
	private String statId;
	private boolean requiresAttunement;
	private String duration;
	private String friendlyTypeName;
	private String friendlySubtypeName;
	private boolean isGranted;
	private int value;
	private int componentId;
	
	public Modifier() {
		
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the entityId
	 */
	public String getEntityId() {
		return entityId;
	}

	/**
	 * @param entityId the entityId to set
	 */
	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	/**
	 * @return the entityTypeId
	 */
	public String getEntityTypeId() {
		return entityTypeId;
	}

	/**
	 * @param entityTypeId the entityTypeId to set
	 */
	public void setEntityTypeId(String entityTypeId) {
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
	 * @return the dice
	 */
	public Dice getDice() {
		return dice;
	}

	/**
	 * @param dice the dice to set
	 */
	public void setDice(Dice dice) {
		this.dice = dice;
	}

	/**
	 * @return the restriction
	 */
	public String getRestriction() {
		return restriction;
	}

	/**
	 * @param restriction the restriction to set
	 */
	public void setRestriction(String restriction) {
		this.restriction = restriction;
	}

	/**
	 * @return the statId
	 */
	public String getStatId() {
		return statId;
	}

	/**
	 * @param statId the statId to set
	 */
	public void setStatId(String statId) {
		this.statId = statId;
	}

	/**
	 * @return the requiresAttunement
	 */
	public boolean isRequiresAttunement() {
		return requiresAttunement;
	}

	/**
	 * @param requiresAttunement the requiresAttunement to set
	 */
	public void setRequiresAttunement(boolean requiresAttunement) {
		this.requiresAttunement = requiresAttunement;
	}

	/**
	 * @return the duration
	 */
	public String getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(String duration) {
		this.duration = duration;
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
	 * @return the friendlySubtypeName
	 */
	public String getFriendlySubtypeName() {
		return friendlySubtypeName;
	}

	/**
	 * @param friendlySubtypeName the friendlySubtypeName to set
	 */
	public void setFriendlySubtypeName(String friendlySubtypeName) {
		this.friendlySubtypeName = friendlySubtypeName;
	}

	/**
	 * @return the isGranted
	 */
	public boolean isGranted() {
		return isGranted;
	}

	/**
	 * @param isGranted the isGranted to set
	 */
	public void setGranted(boolean isGranted) {
		this.isGranted = isGranted;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dice == null) ? 0 : dice.hashCode());
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((entityId == null) ? 0 : entityId.hashCode());
		result = prime * result + ((entityTypeId == null) ? 0 : entityTypeId.hashCode());
		result = prime * result + ((friendlySubtypeName == null) ? 0 : friendlySubtypeName.hashCode());
		result = prime * result + ((friendlyTypeName == null) ? 0 : friendlyTypeName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isGranted ? 1231 : 1237);
		result = prime * result + (requiresAttunement ? 1231 : 1237);
		result = prime * result + ((restriction == null) ? 0 : restriction.hashCode());
		result = prime * result + ((statId == null) ? 0 : statId.hashCode());
		result = prime * result + ((subType == null) ? 0 : subType.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Modifier other = (Modifier) obj;
		if (dice == null) {
			if (other.dice != null)
				return false;
		} else if (!dice.equals(other.dice))
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (entityId == null) {
			if (other.entityId != null)
				return false;
		} else if (!entityId.equals(other.entityId))
			return false;
		if (entityTypeId == null) {
			if (other.entityTypeId != null)
				return false;
		} else if (!entityTypeId.equals(other.entityTypeId))
			return false;
		if (friendlySubtypeName == null) {
			if (other.friendlySubtypeName != null)
				return false;
		} else if (!friendlySubtypeName.equals(other.friendlySubtypeName))
			return false;
		if (friendlyTypeName == null) {
			if (other.friendlyTypeName != null)
				return false;
		} else if (!friendlyTypeName.equals(other.friendlyTypeName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isGranted != other.isGranted)
			return false;
		if (requiresAttunement != other.requiresAttunement)
			return false;
		if (restriction == null) {
			if (other.restriction != null)
				return false;
		} else if (!restriction.equals(other.restriction))
			return false;
		if (statId == null) {
			if (other.statId != null)
				return false;
		} else if (!statId.equals(other.statId))
			return false;
		if (subType == null) {
			if (other.subType != null)
				return false;
		} else if (!subType.equals(other.subType))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (value != other.value)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Modifier [id=" + id + ", entityId=" + entityId + ", entityTypeId=" + entityTypeId + ", type=" + type
				+ ", subType=" + subType + ", dice=" + dice + ", restriction=" + restriction + ", statId=" + statId
				+ ", requiresAttunement=" + requiresAttunement + ", duration=" + duration + ", friendlyTypeName="
				+ friendlyTypeName + ", friendlySubtypeName=" + friendlySubtypeName + ", isGranted=" + isGranted
				+ ", value=" + value + ", componentId=" + componentId + "]";
	}
	
}
