package com.patrickborrelli.dndiscord.model.dndiscord;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.patrickborrelli.dndiscord.utilities.ActivationType;
import com.patrickborrelli.dndiscord.utilities.FeatureType;
import com.patrickborrelli.dndiscord.utilities.ResetType;

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

	@Override
	public String toString() {
		return "Feature [type=" + type.toString() + ", displayOrder=" + displayOrder + ", name=" + name + ", description="
				+ description + ", snippet=" + snippet + ", activationType=" + activationType + ", duration=" + duration
				+ ", multiClassDescription=" + multiClassDescription + ", requiredLevel=" + requiredLevel
				+ ", isSubClassFeature=" + isSubClassFeature + ", limitedUseResetType=" + limitedUseResetType
				+ ", limitedUseNumberUsed=" + limitedUseNumberUsed + ", limitedUseMinNumberConsumed="
				+ limitedUseMinNumberConsumed + ", limitedUseMaxNumberConsumed=" + limitedUseMaxNumberConsumed
				+ ", limitedUseMaxUses=" + limitedUseMaxUses + ", limitedUseOperator=" + limitedUseOperator
				+ ", hideInSheet=" + hideInSheet + ", source=" + source + ", sourcePageNumber=" + sourcePageNumber
				+ "]";
	}
}
