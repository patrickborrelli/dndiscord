package com.patrickborrelli.dndiscord.model.dndbeyond;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for a background definition json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BackgroundDefinition {
	private long id;
	private long entityType;
	private String name;
	private String description;
	private String snippet;
	private String shortDescription;
	private String skillProficiencyDescription;
	private String toolProficiencyDescription;
	private String languagesDescription;
	private String equipmentDescription;
	private String featureName;
	private String featureDescription;
	private String avatarUrl;
	private String largeAvatarUrl;
	private String[] suggestedProficiencies;
	private String[] suggestedLanguages;
	private String organization;
	private String contractsDescription;
	private String spellsPreDescription;
	private String spellsPostDescription;
	private PersonalityTrait[] personalityTraits;
	private Ideal[] ideals;
	private Bond[] bonds;
	private Flaw[] flaws;
	
	public BackgroundDefinition() {
		
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
	 * @return long the entityType
	 */
	public long getEntityType() {
		return entityType;
	}

	/**
	 * @param long the entityType to set
	 */
	public void setEntityType(long entityType) {
		this.entityType = entityType;
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
	 * @return String the snippet
	 */
	public String getSnippet() {
		return snippet;
	}

	/**
	 * @param String the snippet to set
	 */
	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}

	/**
	 * @return String the shortDescription
	 */
	public String getShortDescription() {
		return shortDescription;
	}

	/**
	 * @param String the shortDescription to set
	 */
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	/**
	 * @return String the skillProficiencyDescription
	 */
	public String getSkillProficiencyDescription() {
		return skillProficiencyDescription;
	}

	/**
	 * @param String the skillProficiencyDescription to set
	 */
	public void setSkillProficiencyDescription(String skillProficiencyDescription) {
		this.skillProficiencyDescription = skillProficiencyDescription;
	}

	/**
	 * @return String the toolProficiencyDescription
	 */
	public String getToolProficiencyDescription() {
		return toolProficiencyDescription;
	}

	/**
	 * @param String the toolProficiencyDescription to set
	 */
	public void setToolProficiencyDescription(String toolProficiencyDescription) {
		this.toolProficiencyDescription = toolProficiencyDescription;
	}

	/**
	 * @return String the languagesDescription
	 */
	public String getLanguagesDescription() {
		return languagesDescription;
	}

	/**
	 * @param String the languagesDescription to set
	 */
	public void setLanguagesDescription(String languagesDescription) {
		this.languagesDescription = languagesDescription;
	}

	/**
	 * @return String the equipmentDescription
	 */
	public String getEquipmentDescription() {
		return equipmentDescription;
	}

	/**
	 * @param String the equipmentDescription to set
	 */
	public void setEquipmentDescription(String equipmentDescription) {
		this.equipmentDescription = equipmentDescription;
	}

	/**
	 * @return String the featureName
	 */
	public String getFeatureName() {
		return featureName;
	}

	/**
	 * @param String the featureName to set
	 */
	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	/**
	 * @return String the featureDescription
	 */
	public String getFeatureDescription() {
		return featureDescription;
	}

	/**
	 * @param String the featureDescription to set
	 */
	public void setFeatureDescription(String featureDescription) {
		this.featureDescription = featureDescription;
	}

	/**
	 * @return String the avatarUrl
	 */
	public String getAvatarUrl() {
		return avatarUrl;
	}

	/**
	 * @param String the avatarUrl to set
	 */
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	/**
	 * @return String the largeAvatarUrl
	 */
	public String getLargeAvatarUrl() {
		return largeAvatarUrl;
	}

	/**
	 * @param String the largeAvatarUrl to set
	 */
	public void setLargeAvatarUrl(String largeAvatarUrl) {
		this.largeAvatarUrl = largeAvatarUrl;
	}

	/**
	 * @return String[] the suggestedProficiencies
	 */
	public String[] getSuggestedProficiencies() {
		return suggestedProficiencies;
	}

	/**
	 * @param String[] the suggestedProficiencies to set
	 */
	public void setSuggestedProficiencies(String[] suggestedProficiencies) {
		this.suggestedProficiencies = suggestedProficiencies;
	}

	/**
	 * @return String[] the suggestedLanguages
	 */
	public String[] getSuggestedLanguages() {
		return suggestedLanguages;
	}

	/**
	 * @param String[] the suggestedLanguages to set
	 */
	public void setSuggestedLanguages(String[] suggestedLanguages) {
		this.suggestedLanguages = suggestedLanguages;
	}

	/**
	 * @return String the organization
	 */
	public String getOrganization() {
		return organization;
	}

	/**
	 * @param String the organization to set
	 */
	public void setOrganization(String organization) {
		this.organization = organization;
	}

	/**
	 * @return String the contractsDescription
	 */
	public String getContractsDescription() {
		return contractsDescription;
	}

	/**
	 * @param String the contractsDescription to set
	 */
	public void setContractsDescription(String contractsDescription) {
		this.contractsDescription = contractsDescription;
	}

	/**
	 * @return String the spellsPreDescription
	 */
	public String getSpellsPreDescription() {
		return spellsPreDescription;
	}

	/**
	 * @param String the spellsPreDescription to set
	 */
	public void setSpellsPreDescription(String spellsPreDescription) {
		this.spellsPreDescription = spellsPreDescription;
	}

	/**
	 * @return String the spellsPostDescription
	 */
	public String getSpellsPostDescription() {
		return spellsPostDescription;
	}

	/**
	 * @param String the spellsPostDescription to set
	 */
	public void setSpellsPostDescription(String spellsPostDescription) {
		this.spellsPostDescription = spellsPostDescription;
	}

	/**
	 * @return PersonalityTrait[] the personalityTraits
	 */
	public PersonalityTrait[] getPersonalityTraits() {
		return personalityTraits;
	}

	/**
	 * @param PersonalityTrait[] the personalityTraits to set
	 */
	public void setPersonalityTraits(PersonalityTrait[] personalityTraits) {
		this.personalityTraits = personalityTraits;
	}

	/**
	 * @return Ideal[] the ideals
	 */
	public Ideal[] getIdeals() {
		return ideals;
	}

	/**
	 * @param Ideal[] the ideals to set
	 */
	public void setIdeals(Ideal[] ideals) {
		this.ideals = ideals;
	}

	/**
	 * @return Bond[] the bonds
	 */
	public Bond[] getBonds() {
		return bonds;
	}

	/**
	 * @param Bond[] the bonds to set
	 */
	public void setBonds(Bond[] bonds) {
		this.bonds = bonds;
	}

	/**
	 * @return Flaw[] the flaws
	 */
	public Flaw[] getFlaws() {
		return flaws;
	}

	/**
	 * @param Flaw[] the flaws to set
	 */
	public void setFlaws(Flaw[] flaws) {
		this.flaws = flaws;
	}

	@Override
	public String toString() {
		return "BackgroundDefinition [id=" + id + ", entityType=" + entityType + ", name=" + name + ", description="
				+ description + ", snippet=" + snippet + ", shortDescription=" + shortDescription
				+ ", skillProficiencyDescription=" + skillProficiencyDescription + ", toolProficiencyDescription="
				+ toolProficiencyDescription + ", languagesDescription=" + languagesDescription
				+ ", equipmentDescription=" + equipmentDescription + ", featureName=" + featureName
				+ ", featureDescription=" + featureDescription + ", avatarUrl=" + avatarUrl + ", largeAvatarUrl="
				+ largeAvatarUrl + ", suggestedProficiencies=" + Arrays.toString(suggestedProficiencies)
				+ ", suggestedLanguages=" + Arrays.toString(suggestedLanguages) + ", organization=" + organization
				+ ", contractsDescription=" + contractsDescription + ", spellsPreDescription=" + spellsPreDescription
				+ ", spellsPostDescription=" + spellsPostDescription + ", personalityTraits="
				+ Arrays.toString(personalityTraits) + ", ideals=" + Arrays.toString(ideals) + ", bonds="
				+ Arrays.toString(bonds) + ", flaws=" + Arrays.toString(flaws) + "]";
	}

}
