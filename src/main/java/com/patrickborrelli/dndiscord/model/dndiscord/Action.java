package com.patrickborrelli.dndiscord.model.dndiscord;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.patrickborrelli.dndiscord.model.type.ActionType;
import com.patrickborrelli.dndiscord.model.type.ActivationType;
import com.patrickborrelli.dndiscord.model.type.AttackSubtype;
import com.patrickborrelli.dndiscord.model.type.DamageType;
import com.patrickborrelli.dndiscord.model.type.FeatureType;
import com.patrickborrelli.dndiscord.model.type.ResetType;
import com.patrickborrelli.dndiscord.model.type.StatType;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model of dDnDiscord Character Action.
 * 
 * @author Patrick Borrelli
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Action {
	@JsonProperty("_id")
	private String id;
	private String name;
	private String description;
	private String snippet;
	private FeatureType type;
	@JsonProperty("ability_modifier_stat")
	private StatType abilityModifierStat;
	@JsonProperty("action_type")
	private ActionType actionType;
	
	//###########################
	//the contents of these elements from the DNDBeyond schema are unknown:
	@JsonProperty("attack_type_range")
	private int attackTypeRange;
	private int value;
	@JsonProperty("spell_range_type")
	private String spellRangeType;
	//###########################
	
	//for actions with associated damage:
	@JsonProperty("die_count")
	private int dieCount;
	@JsonProperty("die_value")
	private int dieValue;
	@JsonProperty("dice_multiplier")
	private int diceMultiplier;
	@JsonProperty("fixed_value")
	private int fixedValue;
	@JsonProperty("dice_string")
	private String diceString;
	@JsonProperty("attack_subtype")
	private AttackSubtype attackSubtype;
	@JsonProperty("on_miss_description")
	private String onMissDescription;
	@JsonProperty("damage_type")
	private DamageType damageType;
	@JsonProperty("martial_art")
	private boolean martialArt;
	private boolean proficient;
	@JsonProperty("display_as_attack")
	private boolean displayAsAttack;
	
	//for actions that have a range:
	private String origin;
	@JsonProperty("range_value")
    private int rangeValue;
	@JsonProperty("aoe_size")
    private String aoeSize;
	@JsonProperty("aoe_type")
    private String aoeType;
	@JsonProperty("aoe_value")
    private int aoeValue;
	@JsonProperty("aoe_special_description")
    private boolean aoeSpecialDescription;
    private int range;
	@JsonProperty("long_range")
    private int longRange;
	
	//for actions with saving throws:
	@JsonProperty("save_fail_description")
	private String saveFailDescription;
	@JsonProperty("save_success_description")
	private String saveSuccessDescription;
	@JsonProperty("save_stat")
	private StatType saveStat;
	@JsonProperty("fixed_save_dc")
	private int fixedSaveDc;
	
	//for limited use actions:
	@JsonProperty("reset_type")
	private ResetType resetType;
	@JsonProperty("number_used")
    private int numberUsed;
	@JsonProperty("max_uses")
    private int maxUses;
    
    //triggering action type:
	@JsonProperty("activation_type")
    private ActivationType activationType;
	private int duration;
}
