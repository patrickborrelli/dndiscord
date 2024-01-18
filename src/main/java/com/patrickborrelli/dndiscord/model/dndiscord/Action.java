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
	private StatType abilityModifierStat;
	private ActionType actionType;
	
	//###########################
	//the contents of these elements from the DNDBeyond schema are unknown:
	private int attackTypeRange;
	private int value;
	private String spellRangeType;
	//###########################
	
	//for actions with associated damage:
	private int dieCount;
	private int dieValue;
	private int diceMultiplier;
	private int fixedValue;
	private String diceString;
	private AttackSubtype attackSubtype;
	private String onMissDescription;
	private DamageType damageType;
	private boolean martialArt;
	private boolean proficient;
	private boolean displayAsAttack;
	
	//for actions that have a range:
	private String origin;
    private int rangeValue;
    private String aoeSize;
    private String aoeType;
    private int aoeValue;
    private boolean aoeSpecialDescription;
    private int range;
    private int longRange;
	
	//for actions with saving throws:
	private String saveFailDescription;
	private String saveSuccessDescription;
	private StatType saveStat;
	private int fixedSaveDc;
	
	//for limited use actions:
	private ResetType resetType;
    private int numberUsed;
    private int maxUses;
    
    //triggering action type:
    private ActivationType activationType;
	private int duration;
}
