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
	@JsonProperty("display_order")
	private int displayOrder;
	private String name;
	private String description;
	private String snippet;
	@JsonProperty("activation_type")
	private ActivationType activationType;
	private int duration;
	@JsonProperty("multi_class_description")
	private String multiClassDescription;
	@JsonProperty("required_level")
	private int requiredLevel;
	@JsonProperty("is_sub_class_feature")
	private boolean isSubClassFeature;
	@JsonProperty("limited_use_reset_type")
	private ResetType limitedUseResetType;
	@JsonProperty("limited_use_number_used")
    private int limitedUseNumberUsed;
	@JsonProperty("limited_use_min_number_consumed")
    private int limitedUseMinNumberConsumed;
	@JsonProperty("limited_use_max_number_consumed")
    private int limitedUseMaxNumberConsumed;
	@JsonProperty("limited_use_max_uses")
    private int limitedUseMaxUses;
	@JsonProperty("limited_use_operator")
    private int limitedUseOperator;
	@JsonProperty("hide_in_sheet")
	private boolean hideInSheet;
	private String source;
	@JsonProperty("source_page_number")
	private int sourcePageNumber;
	@JsonProperty("option_name")
	private String optionName;
	@JsonProperty("option_description")
	private String optionDescription;
	@JsonProperty("option_snippet")
	private String optionSnippet;
	@JsonProperty("feature_name")
	private String featureName;
	@JsonProperty("feature_description")
	private String featureDescription;
	@JsonProperty("short_description")
	private String shortDescription;
	@JsonProperty("suggested_characteristics_description")
	private String suggestedCharacteristicsDescription;

}
