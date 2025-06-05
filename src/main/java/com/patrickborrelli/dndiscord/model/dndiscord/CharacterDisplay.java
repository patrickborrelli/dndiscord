package com.patrickborrelli.dndiscord.model.dndiscord;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Minimized contents of a CharacterSheet for sake of lazy loading
 * 
 * @author Patrick Borrelli
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterDisplay {
	
	@JsonProperty("_id")
	private String id;
	@JsonProperty("character_id")
	private String characterId;
	@JsonProperty("character_name")
	private String characterName;
	@JsonProperty("armor_class")
	private int armorClass;
	@JsonProperty("avatar_url")
	private String avatarUrl;
	private String alignment;
	private int copper;
	private int silver;
	private int electrum;
	private int gold;
	private int platinum;
	@JsonProperty("proficiency_bonus")
	private int proficiencyBonus;
	private int strength;
	private int dexterity;
	private int constitution;
	private int intelligence;
	private int wisdom;
	private int charisma;	
	private String background;	
	private String race;
	@JsonProperty("base_race")
	private String baseRace;
	private String size;	
	@JsonProperty("character_classes")
	private List<String> characterClasses;
	@JsonProperty("total_level")
	private int totalLevel;
	@JsonProperty("max_hit_points")
	private int maxHp;
	@JsonProperty("current_hit_points")
	private int hp;
	@JsonProperty("temporary_hit_points")
	private int tempHp;
	
}