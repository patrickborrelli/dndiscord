package com.patrickborrelli.dndiscord.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model of a user roll formula.
 * 
 * @author Patrick Borrelli
 */

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Formula {

	@JsonProperty("_id")
	private String id;
	private DiscordUser user;
	private String roll;
	private String name;

}
