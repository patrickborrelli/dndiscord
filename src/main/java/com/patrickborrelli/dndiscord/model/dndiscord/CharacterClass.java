package com.patrickborrelli.dndiscord.model.dndiscord;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.patrickborrelli.dndiscord.model.dndbeyond.DndBeyondConstants;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model of dDnDiscord Character Class.
 * 
 * @author Patrick Borrelli
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterClass {
	
	@JsonProperty("_id")
	private String id;
	private String name;
	@JsonProperty("starting_class")
	private boolean startingClass;
	private int level;
	@JsonProperty("subclass_name")
	private String subclassName;
	@JsonProperty("hit_die_type")
	private int hitDieType;
	@JsonProperty("hit_dice_used")
	private int hitDiceUsed;

	/**
	 * @param subclassName the subclassName to set
	 */
	public void setSubclassName(String subclassName) {
		if(subclassName != null) {
			String newStr = subclassName.replaceAll(DndBeyondConstants.ARCHIVED, "");
			this.subclassName = newStr.trim();
		}
	}

}
