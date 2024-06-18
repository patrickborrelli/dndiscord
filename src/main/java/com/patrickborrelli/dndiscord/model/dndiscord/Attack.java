package com.patrickborrelli.dndiscord.model.dndiscord;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor; 

/**
 * Model of dDnDiscord attack.
 * 
 * @author Patrick Borrelli
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Attack {
	
	@JsonProperty("_id")
	private String id;
	private String name;
	@JsonProperty("to_hit")
	private String toHit;
	@JsonProperty("damage_string")
	private String damageString;
	@JsonProperty("damage_type")
	private String damageType;
}
