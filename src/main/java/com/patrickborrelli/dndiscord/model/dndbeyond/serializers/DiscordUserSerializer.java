package com.patrickborrelli.dndiscord.model.dndbeyond.serializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.patrickborrelli.dndiscord.model.DiscordUser;
import com.patrickborrelli.dndiscord.model.dndiscord.CharacterSheet;

public class DiscordUserSerializer extends JsonSerializer<DiscordUser> {
	
	@Override
	public void serialize(DiscordUser user, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeStartObject();
		gen.writeStringField("_id", user.getId());
		gen.writeStringField("discord_id", user.getDiscord_id());
		gen.writeStringField("username", user.getUsername());
		gen.writeStringField("discriminator", user.getDiscriminator());
		gen.writeStringField("avatar_hash", user.getAvatar());
		gen.writeBooleanField("bot", user.isBot()); 
		gen.writeArrayFieldStart("characters");
		for(CharacterSheet sheet : user.getCharacters()) {
			gen.writeString(sheet.getId());
		}
		gen.writeEndArray();
		if(null != user.getActiveCharacter()) {
			gen.writeStringField("activeCharacter", user.getActiveCharacter().getId());
		} else {
			gen.writeStringField("activeCharacter",null);
		}
		gen.writeEndObject();		
	}

}
