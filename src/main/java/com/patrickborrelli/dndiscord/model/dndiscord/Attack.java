package com.patrickborrelli.dndiscord.model.dndiscord;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties; 

/**
 * Model of dDnDiscord attack.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Attack {
	
	private String name;
	private String toHit;
	private String damageString;
	private String damageType;
	
	public Attack() {
		
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
	 * @return the toHit
	 */
	public String getToHit() {
		return toHit;
	}

	/**
	 * @param toHit the toHit to set
	 */
	public void setToHit(String toHit) {
		this.toHit = toHit;
	}

	/**
	 * @return the damageString
	 */
	public String getDamageString() {
		return damageString;
	}

	/**
	 * @param damageString the damageString to set
	 */
	public void setDamageString(String damageString) {
		this.damageString = damageString;
	}

	/**
	 * @return the damageType
	 */
	public String getDamageType() {
		return damageType;
	}

	/**
	 * @param damageType the damageType to set
	 */
	public void setDamageType(String damageType) {
		this.damageType = damageType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((damageString == null) ? 0 : damageString.hashCode());
		result = prime * result + ((damageType == null) ? 0 : damageType.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((toHit == null) ? 0 : toHit.hashCode());
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
		Attack other = (Attack) obj;
		if (damageString == null) {
			if (other.damageString != null)
				return false;
		} else if (!damageString.equals(other.damageString))
			return false;
		if (damageType == null) {
			if (other.damageType != null)
				return false;
		} else if (!damageType.equals(other.damageType))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (toHit == null) {
			if (other.toHit != null)
				return false;
		} else if (!toHit.equals(other.toHit))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Attack [name=" + name + ", toHit=" + toHit + ", damageString=" + damageString + ", damageType="
				+ damageType + "]";
	}	
}
