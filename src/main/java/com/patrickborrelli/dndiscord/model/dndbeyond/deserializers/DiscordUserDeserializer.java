package com.patrickborrelli.dndiscord.model.dndbeyond.deserializers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.patrickborrelli.dndiscord.model.DiscordUser;
import com.patrickborrelli.dndiscord.model.dndiscord.CharacterSheet;

public class DiscordUserDeserializer extends StdDeserializer<DiscordUser> {

	private static final long serialVersionUID = 5208948948831956497L;
	
	public DiscordUserDeserializer() {
		this(null);
	}

	public DiscordUserDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public DiscordUser deserialize(JsonParser parser, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		
		List<String> characterIds = new ArrayList<>();
		
		DiscordUser user = new DiscordUser();
		
		JsonNode node = parser.getCodec().readTree(parser);
		user.setId(node.get("_id").asText());
		user.setDiscord_id(node.get("discord_id").asText());
		user.setUsername(node.get("username").asText());
		user.setDiscriminator(node.get("discriminator").asText());
		user.setAvatar(node.get("avatar_hash").asText());
		user.setBot(node.get("bot").asBoolean());
		
		String activeCharId = node.get("active_character").asText();
		CharacterSheet active = new CharacterSheet();
		active.setId(activeCharId);
		user.setActiveCharacter(active);		
		
		JsonNode characters = node.get("characters");
		if(characters != null && characters.isArray()) {
			ArrayNode arNode = (ArrayNode)characters;
			for(int i = 0; i < arNode.size(); i++) {
				characterIds.add(arNode.get(i).asText());
			}
		}
		
		for(String id : characterIds) {
			CharacterSheet sheet = new CharacterSheet();
			sheet.setId(id);
			user.addCharacter(sheet);
		}
		
		return user;
	}

}
