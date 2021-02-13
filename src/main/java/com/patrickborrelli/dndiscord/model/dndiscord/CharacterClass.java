package com.patrickborrelli.dndiscord.model.dndiscord;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Model of dDnDiscord Character Class.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterClass {
	private String name;
	private boolean startingClass;
	private int level;
	
	public CharacterClass() {
		
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
	 * @return the startingClass
	 */
	public boolean isStartingClass() {
		return startingClass;
	}

	/**
	 * @param startingClass the startingClass to set
	 */
	public void setStartingClass(boolean startingClass) {
		this.startingClass = startingClass;
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + level;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (startingClass ? 1231 : 1237);
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
		CharacterClass other = (CharacterClass) obj;
		if (level != other.level)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (startingClass != other.startingClass)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CharacterClass [name=" + name + ", startingClass=" + startingClass + ", level=" + level + "]";
	}
}
