package com.patrickborrelli.dndiscord.model;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.patrickborrelli.dndiscord.model.dndbeyond.deserializers.DiscordUserDeserializer;
import com.patrickborrelli.dndiscord.model.dndbeyond.serializers.DiscordUserSerializer;
import com.patrickborrelli.dndiscord.model.dndiscord.CharacterSheet;
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
@JsonDeserialize(using = DiscordUserDeserializer.class)
public class DiscordUser {
	
	@JsonProperty("_id")
	private String id;
	private String discord_id;
	private String username;
	private String discriminator;
	@JsonProperty("avatar_hash")
	private String avatar;
	private boolean bot;
	private List<CharacterSheet> characters = new ArrayList<>();
	@JsonProperty("active_character")
	private CharacterSheet activeCharacter;
	
	public void addCharacter(CharacterSheet sheet) {
		characters.add(sheet);
	}
	
	public void removeCharacter(CharacterSheet sheet) {
		characters.remove(sheet);
	}
}
