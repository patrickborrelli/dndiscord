package com.patrickborrelli.dndiscord.model.dndiscord;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.patrickborrelli.dndiscord.model.type.ActivationType;
import com.patrickborrelli.dndiscord.model.type.FeatureType;
import com.patrickborrelli.dndiscord.model.type.ResetType;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model of dDnDiscord Feature.
 * 
 * @author Patrick Borrelli
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Feature {
	
	@JsonProperty("_id")
	private String id;
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

}
