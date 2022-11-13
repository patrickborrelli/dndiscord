package com.patrickborrelli.dndiscord.model.dndbeyond;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for a character class json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DndBeyondCharacterClass {

	private long id;
	private long entityTypeId;
	private int level; 
	private boolean isStartingClass;
	private int hitDiceUsed;
	private ClassDefinition definition;
	private ClassDefinition subclassDefinition;
	private List<ClassFeature> classFeatures;
	
	public DndBeyondCharacterClass() {
		
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
	 * @return the isStartingClass
	 */
	public boolean isStartingClass() {
		return isStartingClass;
	}

	/**
	 * @param isStartingClass the isStartingClass to set
	 */
	public void setStartingClass(boolean isStartingClass) {
		this.isStartingClass = isStartingClass;
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

	/**
	 * @return the definition
	 */
	public ClassDefinition getDefinition() {
		return definition;
	}

	/**
	 * @param definition the definition to set
	 */
	public void setDefinition(ClassDefinition definition) {
		this.definition = definition;
	}

	/**
	 * @return the subclassDefinition
	 */
	public ClassDefinition getSubclassDefinition() {
		return subclassDefinition;
	}

	/**
	 * @param subclassDefinition the subclassDefinition to set
	 */
	public void setSubclassDefinition(ClassDefinition subclassDefinition) {
		this.subclassDefinition = subclassDefinition;
	}

	/**
	 * @return List<ClassFeature> the classFeatures
	 */
	public List<ClassFeature> getClassFeatures() {
		return classFeatures;
	}

	/**
	 * @param classFeatures List<ClassFeature> the classFeatures to set
	 */
	public void setClassFeatures(List<ClassFeature> classFeatures) {
		this.classFeatures = classFeatures;
	}

	@Override
	public String toString() {
		return "DndBeyondCharacterClass [id=" + id + ", entityTypeId=" + entityTypeId + ", level=" + level
				+ ", isStartingClass=" + isStartingClass + ", hitDiceUsed=" + hitDiceUsed + ", definition=" + definition
				+ ", subclassDefinition=" + subclassDefinition + ", classFeatures=" + classFeatures + "]";
	}
}
