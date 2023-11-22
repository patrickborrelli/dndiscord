package com.patrickborrelli.dndiscord.model.dndiscord;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.patrickborrelli.dndiscord.model.type.ActivationType;
import com.patrickborrelli.dndiscord.model.type.FeatureType;
import com.patrickborrelli.dndiscord.model.type.ResetType;

/**
 * Model of dDnDiscord Feature.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Feature {
	
	private FeatureType type;
	private int displayOrder;
	private String name;
	private String description;
	private String snippet;
	private ActivationType activationType;
	private int duration;
	private String multiClassDescription;
	private int requiredLevel;
	private boolean isSubClassFeature;
	private ResetType limitedUseResetType;
    private int limitedUseNumberUsed;
    private int limitedUseMinNumberConsumed;
    private int limitedUseMaxNumberConsumed;
    private int limitedUseMaxUses;
    private int limitedUseOperator;
	private boolean hideInSheet;
	private String source;
	private int sourcePageNumber;
	private String optionName;
	private String optionDescription;
	private String optionSnippet;
	private String featureName;
	private String featureDescription;
	private String shortDescription;
	private String suggestedCharacteristicsDescription;
	
	public Feature() {
		
	}

	/**
	 * @return the type
	 */
	public FeatureType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(FeatureType type) {
		this.type = type;
	}

	/**
	 * @return the displayOrder
	 */
	public int getDisplayOrder() {
		return displayOrder;
	}

	/**
	 * @param displayOrder the displayOrder to set
	 */
	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
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
	 * @return the activationType
	 */
	public ActivationType getActivationType() {
		return activationType;
	}

	/**
	 * @param activationType the activationType to set
	 */
	public void setActivationType(ActivationType activationType) {
		this.activationType = activationType;
	}

	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * @return the multiClassDescription
	 */
	public String getMultiClassDescription() {
		return multiClassDescription;
	}

	/**
	 * @param multiClassDescription the multiClassDescription to set
	 */
	public void setMultiClassDescription(String multiClassDescription) {
		this.multiClassDescription = multiClassDescription;
	}

	/**
	 * @return the requiredLevel
	 */
	public int getRequiredLevel() {
		return requiredLevel;
	}

	/**
	 * @param requiredLevel the requiredLevel to set
	 */
	public void setRequiredLevel(int requiredLevel) {
		this.requiredLevel = requiredLevel;
	}

	/**
	 * @return the isSubClassFeature
	 */
	public boolean isSubClassFeature() {
		return isSubClassFeature;
	}

	/**
	 * @param isSubClassFeature the isSubClassFeature to set
	 */
	public void setSubClassFeature(boolean isSubClassFeature) {
		this.isSubClassFeature = isSubClassFeature;
	}

	/**
	 * @return the limitedUseResetType
	 */
	public ResetType getLimitedUseResetType() {
		return limitedUseResetType;
	}

	/**
	 * @param limitedUseResetType the limitedUseResetType to set
	 */
	public void setLimitedUseResetType(ResetType limitedUseResetType) {
		this.limitedUseResetType = limitedUseResetType;
	}

	/**
	 * @return the limitedUseNumberUsed
	 */
	public int getLimitedUseNumberUsed() {
		return limitedUseNumberUsed;
	}

	/**
	 * @param limitedUseNumberUsed the limitedUseNumberUsed to set
	 */
	public void setLimitedUseNumberUsed(int limitedUseNumberUsed) {
		this.limitedUseNumberUsed = limitedUseNumberUsed;
	}

	/**
	 * @return the limitedUseMinNumberConsumed
	 */
	public int getLimitedUseMinNumberConsumed() {
		return limitedUseMinNumberConsumed;
	}

	/**
	 * @param limitedUseMinNumberConsumed the limitedUseMinNumberConsumed to set
	 */
	public void setLimitedUseMinNumberConsumed(int limitedUseMinNumberConsumed) {
		this.limitedUseMinNumberConsumed = limitedUseMinNumberConsumed;
	}

	/**
	 * @return the limitedUseMaxNumberConsumed
	 */
	public int getLimitedUseMaxNumberConsumed() {
		return limitedUseMaxNumberConsumed;
	}

	/**
	 * @param limitedUseMaxNumberConsumed the limitedUseMaxNumberConsumed to set
	 */
	public void setLimitedUseMaxNumberConsumed(int limitedUseMaxNumberConsumed) {
		this.limitedUseMaxNumberConsumed = limitedUseMaxNumberConsumed;
	}

	/**
	 * @return the limitedUseMaxUses
	 */
	public int getLimitedUseMaxUses() {
		return limitedUseMaxUses;
	}

	/**
	 * @param limitedUseMaxUses the limitedUseMaxUses to set
	 */
	public void setLimitedUseMaxUses(int limitedUseMaxUses) {
		this.limitedUseMaxUses = limitedUseMaxUses;
	}

	/**
	 * @return the limitedUseOperator
	 */
	public int getLimitedUseOperator() {
		return limitedUseOperator;
	}

	/**
	 * @param limitedUseOperator the limitedUseOperator to set
	 */
	public void setLimitedUseOperator(int limitedUseOperator) {
		this.limitedUseOperator = limitedUseOperator;
	}

	/**
	 * @return the hideInSheet
	 */
	public boolean isHideInSheet() {
		return hideInSheet;
	}

	/**
	 * @param hideInSheet the hideInSheet to set
	 */
	public void setHideInSheet(boolean hideInSheet) {
		this.hideInSheet = hideInSheet;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the sourcePageNumber
	 */
	public int getSourcePageNumber() {
		return sourcePageNumber;
	}

	/**
	 * @param sourcePageNumber the sourcePageNumber to set
	 */
	public void setSourcePageNumber(int sourcePageNumber) {
		this.sourcePageNumber = sourcePageNumber;
	}

	/**
	 * @return String the optionName
	 */
	public String getOptionName() {
		return optionName;
	}

	/**
	 * @param optionName String the optionName to set
	 */
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	/**
	 * @return String the optionDescription
	 */
	public String getOptionDescription() {
		return optionDescription;
	}

	/**
	 * @param optionDescription String the optionDescription to set
	 */
	public void setOptionDescription(String optionDescription) {
		this.optionDescription = optionDescription;
	}

	/**
	 * @return String the optionSnippet
	 */
	public String getOptionSnippet() {
		return optionSnippet;
	}

	/**
	 * @param optionSnippet String the optionSnippet to set
	 */
	public void setOptionSnippet(String optionSnippet) {
		this.optionSnippet = optionSnippet;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activationType == null) ? 0 : activationType.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + displayOrder;
		result = prime * result + duration;
		result = prime * result + ((featureDescription == null) ? 0 : featureDescription.hashCode());
		result = prime * result + ((featureName == null) ? 0 : featureName.hashCode());
		result = prime * result + (hideInSheet ? 1231 : 1237);
		result = prime * result + (isSubClassFeature ? 1231 : 1237);
		result = prime * result + limitedUseMaxNumberConsumed;
		result = prime * result + limitedUseMaxUses;
		result = prime * result + limitedUseMinNumberConsumed;
		result = prime * result + limitedUseNumberUsed;
		result = prime * result + limitedUseOperator;
		result = prime * result + ((limitedUseResetType == null) ? 0 : limitedUseResetType.hashCode());
		result = prime * result + ((multiClassDescription == null) ? 0 : multiClassDescription.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((optionDescription == null) ? 0 : optionDescription.hashCode());
		result = prime * result + ((optionName == null) ? 0 : optionName.hashCode());
		result = prime * result + ((optionSnippet == null) ? 0 : optionSnippet.hashCode());
		result = prime * result + requiredLevel;
		result = prime * result + ((shortDescription == null) ? 0 : shortDescription.hashCode());
		result = prime * result + ((snippet == null) ? 0 : snippet.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + sourcePageNumber;
		result = prime * result
				+ ((suggestedCharacteristicsDescription == null) ? 0 : suggestedCharacteristicsDescription.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Feature other = (Feature) obj;
		if (activationType != other.activationType)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (displayOrder != other.displayOrder)
			return false;
		if (duration != other.duration)
			return false;
		if (featureDescription == null) {
			if (other.featureDescription != null)
				return false;
		} else if (!featureDescription.equals(other.featureDescription))
			return false;
		if (featureName == null) {
			if (other.featureName != null)
				return false;
		} else if (!featureName.equals(other.featureName))
			return false;
		if (hideInSheet != other.hideInSheet)
			return false;
		if (isSubClassFeature != other.isSubClassFeature)
			return false;
		if (limitedUseMaxNumberConsumed != other.limitedUseMaxNumberConsumed)
			return false;
		if (limitedUseMaxUses != other.limitedUseMaxUses)
			return false;
		if (limitedUseMinNumberConsumed != other.limitedUseMinNumberConsumed)
			return false;
		if (limitedUseNumberUsed != other.limitedUseNumberUsed)
			return false;
		if (limitedUseOperator != other.limitedUseOperator)
			return false;
		if (limitedUseResetType != other.limitedUseResetType)
			return false;
		if (multiClassDescription == null) {
			if (other.multiClassDescription != null)
				return false;
		} else if (!multiClassDescription.equals(other.multiClassDescription))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (optionDescription == null) {
			if (other.optionDescription != null)
				return false;
		} else if (!optionDescription.equals(other.optionDescription))
			return false;
		if (optionName == null) {
			if (other.optionName != null)
				return false;
		} else if (!optionName.equals(other.optionName))
			return false;
		if (optionSnippet == null) {
			if (other.optionSnippet != null)
				return false;
		} else if (!optionSnippet.equals(other.optionSnippet))
			return false;
		if (requiredLevel != other.requiredLevel)
			return false;
		if (shortDescription == null) {
			if (other.shortDescription != null)
				return false;
		} else if (!shortDescription.equals(other.shortDescription))
			return false;
		if (snippet == null) {
			if (other.snippet != null)
				return false;
		} else if (!snippet.equals(other.snippet))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (sourcePageNumber != other.sourcePageNumber)
			return false;
		if (suggestedCharacteristicsDescription == null) {
			if (other.suggestedCharacteristicsDescription != null)
				return false;
		} else if (!suggestedCharacteristicsDescription.equals(other.suggestedCharacteristicsDescription))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Feature [type=" + type + ", displayOrder=" + displayOrder + ", name=" + name + ", description="
				+ description + ", snippet=" + snippet + ", activationType=" + activationType + ", duration=" + duration
				+ ", multiClassDescription=" + multiClassDescription + ", requiredLevel=" + requiredLevel
				+ ", isSubClassFeature=" + isSubClassFeature + ", limitedUseResetType=" + limitedUseResetType
				+ ", limitedUseNumberUsed=" + limitedUseNumberUsed + ", limitedUseMinNumberConsumed="
				+ limitedUseMinNumberConsumed + ", limitedUseMaxNumberConsumed=" + limitedUseMaxNumberConsumed
				+ ", limitedUseMaxUses=" + limitedUseMaxUses + ", limitedUseOperator=" + limitedUseOperator
				+ ", hideInSheet=" + hideInSheet + ", source=" + source + ", sourcePageNumber=" + sourcePageNumber
				+ ", optionName=" + optionName + ", optionDescription=" + optionDescription + ", optionSnippet="
				+ optionSnippet + ", featureName=" + featureName + ", featureDescription=" + featureDescription
				+ ", shortDescription=" + shortDescription + ", suggestedCharacteristicsDescription="
				+ suggestedCharacteristicsDescription + "]";
	}
}
