package com.patrickborrelli.dndiscord.model.dndiscord;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

	private String id;
	private String characterName;
	private String avatarUrl;
	private String alignment;
	private int copper;
	private int silver;
	private int electrum;
	private int gold;
	private int platinum;
	private int proficiencyBonus;
	private int ac;	
	private int strength;
	private int dexterity;
	private int constitution;
	private int intelligence;
	private int wisdom;
	private int charisma;	
	private String background;	
	private String race;
	private String baseRace;
	private String size;	
	private List<String> characterClasses;
	private int totalLevel;
	private int maxHp;
	private int hp;
	private int tempHp;
	
}