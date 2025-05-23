package com.patrickborrelli.dndiscord.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.patrickborrelli.dndiscord.model.dndbeyond.serializers.DiscordUserSerializer;
import com.patrickborrelli.dndiscord.model.dndiscord.CharacterDisplay;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representational data encapsulating a
 * Discord user for identification and
 * storage of user specific data.
 *
 * @author Patrick Borrelli
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(using = DiscordUserSerializer.class)
//@JsonDeserialize(using = DiscordUserDeserializer.class)
public class DiscordUser {
	
	@JsonProperty("_id")
	private String id;
	private String discord_id;
	private String username;
	private String discriminator;
	@JsonProperty("avatar_hash")
	private String avatar;
	private boolean bot;
	@JsonProperty("active_character")
	private CharacterDisplay activeCharacter;
}
