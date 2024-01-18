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
	private String suggestedCharacteristicsDescription;
	
	public BackgroundDefinition() {
		
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
	 * @return the entityType
	 */
	public long getEntityType() {
		return entityType;
	}

	/**
	 * @param entityType the entityType to set
	 */
	public void setEntityType(long entityType) {
		this.entityType = entityType;
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
	 * @return the snippet
	 */
	public String getSnippet() {
		return snippet;
	}

	/**
	 * @param snippet the snippet to set
	 */
	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}

	/**
	 * @return the shortDescription
	 */
	public String getShortDescription() {
		return shortDescription;
	}

	/**
	 * @param shortDescription the shortDescription to set
	 */
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	/**
	 * @return the skillProficiencyDescription
	 */
	public String getSkillProficiencyDescription() {
		return skillProficiencyDescription;
	}

	/**
	 * @param skillProficiencyDescription the skillProficiencyDescription to set
	 */
	public void setSkillProficiencyDescription(String skillProficiencyDescription) {
		this.skillProficiencyDescription = skillProficiencyDescription;
	}

	/**
	 * @return the toolProficiencyDescription
	 */
	public String getToolProficiencyDescription() {
		return toolProficiencyDescription;
	}

	/**
	 * @param toolProficiencyDescription the toolProficiencyDescription to set
	 */
	public void setToolProficiencyDescription(String toolProficiencyDescription) {
		this.toolProficiencyDescription = toolProficiencyDescription;
	}

	/**
	 * @return the languagesDescription
	 */
	public String getLanguagesDescription() {
		return languagesDescription;
	}

	/**
	 * @param languagesDescription the languagesDescription to set
	 */
	public void setLanguagesDescription(String languagesDescription) {
		this.languagesDescription = languagesDescription;
	}

	/**
	 * @return the equipmentDescription
	 */
	public String getEquipmentDescription() {
		return equipmentDescription;
	}

	/**
	 * @param equipmentDescription the equipmentDescription to set
	 */
	public void setEquipmentDescription(String equipmentDescription) {
		this.equipmentDescription = equipmentDescription;
	}

	/**
	 * @return the featureName
	 */
	public String getFeatureName() {
		return featureName;
	}

	/**
	 * @param featureName the featureName to set
	 */
	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	/**
	 * @return the featureDescription
	 */
	public String getFeatureDescription() {
		return featureDescription;
	}

	/**
	 * @param featureDescription the featureDescription to set
	 */
	public void setFeatureDescription(String featureDescription) {
		this.featureDescription = featureDescription;
	}

	/**
	 * @return the avatarUrl
	 */
	public String getAvatarUrl() {
		return avatarUrl;
	}

	/**
	 * @param avatarUrl the avatarUrl to set
	 */
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	/**
	 * @return the largeAvatarUrl
	 */
	public String getLargeAvatarUrl() {
		return largeAvatarUrl;
	}

	/**
	 * @param largeAvatarUrl the largeAvatarUrl to set
	 */
	public void setLargeAvatarUrl(String largeAvatarUrl) {
		this.largeAvatarUrl = largeAvatarUrl;
	}

	/**
	 * @return the suggestedProficiencies
	 */
	public String[] getSuggestedProficiencies() {
		return suggestedProficiencies;
	}

	/**
	 * @param suggestedProficiencies the suggestedProficiencies to set
	 */
	public void setSuggestedProficiencies(String[] suggestedProficiencies) {
		this.suggestedProficiencies = suggestedProficiencies;
	}

	/**
	 * @return the suggestedLanguages
	 */
	public String[] getSuggestedLanguages() {
		return suggestedLanguages;
	}

	/**
	 * @param suggestedLanguages the suggestedLanguages to set
	 */
	public void setSuggestedLanguages(String[] suggestedLanguages) {
		this.suggestedLanguages = suggestedLanguages;
	}

	/**
	 * @return the organization
	 */
	public String getOrganization() {
		return organization;
	}

	/**
	 * @param organization the organization to set
	 */
	public void setOrganization(String organization) {
		this.organization = organization;
	}

	/**
	 * @return the contractsDescription
	 */
	public String getContractsDescription() {
		return contractsDescription;
	}

	/**
	 * @param contractsDescription the contractsDescription to set
	 */
	public void setContractsDescription(String contractsDescription) {
		this.contractsDescription = contractsDescription;
	}

	/**
	 * @return the spellsPreDescription
	 */
	public String getSpellsPreDescription() {
		return spellsPreDescription;
	}

	/**
	 * @param spellsPreDescription the spellsPreDescription to set
	 */
	public void setSpellsPreDescription(String spellsPreDescription) {
		this.spellsPreDescription = spellsPreDescription;
	}

	/**
	 * @return the spellsPostDescription
	 */
	public String getSpellsPostDescription() {
		return spellsPostDescription;
	}

	/**
	 * @param spellsPostDescription the spellsPostDescription to set
	 */
	public void setSpellsPostDescription(String spellsPostDescription) {
		this.spellsPostDescription = spellsPostDescription;
	}

	/**
	 * @return the personalityTraits
	 */
	public PersonalityTrait[] getPersonalityTraits() {
		return personalityTraits;
	}

	/**
	 * @param personalityTraits the personalityTraits to set
	 */
	public void setPersonalityTraits(PersonalityTrait[] personalityTraits) {
		this.personalityTraits = personalityTraits;
	}

	/**
	 * @return the ideals
	 */
	public Ideal[] getIdeals() {
		return ideals;
	}

	/**
	 * @param ideals the ideals to set
	 */
	public void setIdeals(Ideal[] ideals) {
		this.ideals = ideals;
	}

	/**
	 * @return the bonds
	 */
	public Bond[] getBonds() {
		return bonds;
	}

	/**
	 * @param bonds the bonds to set
	 */
	public void setBonds(Bond[] bonds) {
		this.bonds = bonds;
	}

	/**
	 * @return the flaws
	 */
	public Flaw[] getFlaws() {
		return flaws;
	}

	/**
	 * @param flaws the flaws to set
	 */
	public void setFlaws(Flaw[] flaws) {
		this.flaws = flaws;
	}

	/**
	 * @return the suggestedCharacteristicsDescription
	 */
	public String getSuggestedCharacteristicsDescription() {
		return suggestedCharacteristicsDescription;
	}

	/**
	 * @param suggestedCharacteristicsDescription the suggestedCharacteristicsDescription to set
	 */
	public void setSuggestedCharacteristicsDescription(String suggestedCharacteristicsDescription) {
		this.suggestedCharacteristicsDescription = suggestedCharacteristicsDescription;
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
				+ Arrays.toString(bonds) + ", flaws=" + Arrays.toString(flaws)
				+ ", suggestedCharacteristicsDescription=" + suggestedCharacteristicsDescription + "]";
	}
}
