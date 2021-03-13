package com.patrickborrelli.dndiscord.model.dndiscord;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties; 

/**
 * Model of dDnDiscord attack.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Attack {
	
	private String name;
	private String description;
	private String snippet;

}
