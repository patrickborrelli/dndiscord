package com.patrickborrelli.dndiscord.model.dndbeyond.deserializers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.NullNode;
import com.patrickborrelli.dndiscord.model.DiscordUser;
import com.patrickborrelli.dndiscord.model.dndiscord.CharacterSheet;
import com.patrickborrelli.dndiscord.utilities.ApplicationObjectMapper;

public class DiscordUserDeserializer extends StdDeserializer<DiscordUser> {

	private static final long serialVersionUID = 5208948948831956497L;	
	private static final Logger LOGGER = LogManager.getLogger(DiscordUserDeserializer.class.getName());
	
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
		
		ObjectMapper mapper = ApplicationObjectMapper.getInstance();
		mapper.addMixIn(CharacterSheet.class, DefaultJsonDeserializer.class);
		
		DiscordUser user = new DiscordUser();
		
		JsonNode node = parser.getCodec().readTree(parser);
		user.setId(node.get("_id").asText());
		user.setDiscord_id(node.get("discord_id").asText());
		user.setUsername(node.get("username").asText());
		user.setDiscriminator(node.get("discriminator").asText());
		user.setAvatar(node.get("avatar_hash").asText());
		user.setBot(node.get("bot").asBoolean());
		
		
		return user;
	}
	
	@JsonDeserialize
    private interface DefaultJsonDeserializer {
        // Reset default json deserializer
    }

	
}
