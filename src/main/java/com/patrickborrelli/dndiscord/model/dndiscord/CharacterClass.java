package com.patrickborrelli.dndiscord.model.dndiscord;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.patrickborrelli.dndiscord.model.dndbeyond.DndBeyondConstants;

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
	private String subclassName;
	private int hitDieType;
	private int hitDiceUsed;
	
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
	
	/**
	 * @return the subclassName
	 */
	public String getSubclassName() {
		return subclassName;
	}

	/**
	 * @param subclassName the subclassName to set
	 */
	public void setSubclassName(String subclassName) {
		String newStr = subclassName.replaceAll(DndBeyondConstants.ARCHIVED, "");
		this.subclassName = newStr.trim();
	}

	/**
	 * @return the hitDieType
	 */
	public int getHitDieType() {
		return hitDieType;
	}

	/**
	 * @param hitDieType the hitDieType to set
	 */
	public void setHitDieType(int hitDieType) {
		this.hitDieType = hitDieType;
	}

	/**
	 * @return the hitDiceUsed
	 */
	public int getHitDiceUsed() {
		return hitDiceUsed;
	}

	/**
	 * @param hitDiceUsed the hitDiceUsed to set
	 */
	public void setHitDiceUsed(int hitDiceUsed) {
		this.hitDiceUsed = hitDiceUsed;
	}

	@Override
	public String toString() {
		return "CharacterClass [name=" + name + ", startingClass=" + startingClass + ", level=" + level
				+ ", subclassName=" + subclassName + ", hitDieType=" + hitDieType + ", hitDiceUsed=" + hitDiceUsed
				+ "]";
	}
}
