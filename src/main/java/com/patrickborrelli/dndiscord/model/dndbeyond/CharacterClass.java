package com.patrickborrelli.dndiscord.model.dndbeyond;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for a character class json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterClass {

	private long id;
	private long entityTypeId;
	private int level;
	private boolean isStartingClass;
	private int hitDiceUsed;
	private ClassDefinition definition;
	private ClassDefinition subclassDefinition;
	private ClassFeature[] classFeatures;
	
	public CharacterClass() {
		
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
	 * @return int the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param int the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * @return boolean the isStartingClass
	 */
	public boolean isStartingClass() {
		return isStartingClass;
	}

	/**
	 * @param boolean the isStartingClass to set
	 */
	public void setStartingClass(boolean isStartingClass) {
		this.isStartingClass = isStartingClass;
	}

	/**
	 * @return int the hitDiceUsed
	 */
	public int getHitDiceUsed() {
		return hitDiceUsed;
	}

	/**
	 * @param int the hitDiceUsed to set
	 */
	public void setHitDiceUsed(int hitDiceUsed) {
		this.hitDiceUsed = hitDiceUsed;
	}

	/**
	 * @return ClassDefinition the definition
	 */
	public ClassDefinition getDefinition() {
		return definition;
	}

	/**
	 * @param ClassDefinition the definition to set
	 */
	public void setDefinition(ClassDefinition definition) {
		this.definition = definition;
	}

	/**
	 * @return ClassDefinition the subclassDefinition
	 */
	public ClassDefinition getSubclassDefinition() {
		return subclassDefinition;
	}

	/**
	 * @param ClassDefinition the subclassDefinition to set
	 */
	public void setSubclassDefinition(ClassDefinition subclassDefinition) {
		this.subclassDefinition = subclassDefinition;
	}

	/**
	 * @return ClassFeature[] the classFeatures
	 */
	public ClassFeature[] getClassFeatures() {
		return classFeatures;
	}

	/**
	 * @param ClassFeature[] the classFeatures to set
	 */
	public void setClassFeatures(ClassFeature[] classFeatures) {
		this.classFeatures = classFeatures;
	}

	@Override
	public String toString() {
		return "CharacterClass [id=" + id + ", entityTypeId=" + entityTypeId + ", level=" + level + ", isStartingClass="
				+ isStartingClass + ", hitDiceUsed=" + hitDiceUsed + ", definition=" + definition
				+ ", subclassDefinition=" + subclassDefinition + ", classFeatures=" + Arrays.toString(classFeatures)
				+ "]";
	}
}
