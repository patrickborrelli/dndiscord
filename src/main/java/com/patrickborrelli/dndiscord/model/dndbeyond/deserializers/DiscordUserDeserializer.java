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
		
		ObjectMapper om = new ObjectMapper();
        om.addMixIn(CharacterSheet.class, DefaultJsonDeserializer.class);
		
		DiscordUser user = new DiscordUser();
		
		JsonNode node = parser.getCodec().readTree(parser);
		user.setId(node.get("_id").asText());
		user.setDiscord_id(node.get("discord_id").asText());
		user.setUsername(node.get("username").asText());
		user.setDiscriminator(node.get("discriminator").asText());
		user.setAvatar(node.get("avatar_hash").asText());
		user.setBot(node.get("bot").asBoolean());
		
		JsonNode activeCharId = node.get("active_character");
		if(activeCharId != null && !(activeCharId instanceof NullNode) && activeCharId.hasNonNull("_id")) {
			CharacterSheet active = null;
			//clean up node as text to remove any empty strings replacing them with nulls:
			String cleanedString = removeEmptyStrings(activeCharId.toString());
			
			try {
				active = om.readValue(cleanedString, CharacterSheet.class);
				user.setActiveCharacter(active);
			} catch(JsonProcessingException e) {
			LOGGER.error("Failed to deserialize character sheet {}", e);
			}			
		}
		
		JsonNode characters = node.get("characters");
		if(characters != null && characters.isArray()) {
			for(int i = 0; i < characters.size(); i++) {
				if(!(characters.get(i) instanceof NullNode)) {
					characterIds.add(characters.get(i).asText());
				}
			}
		}
		
		for(String id : characterIds) {
			CharacterSheet sheet = new CharacterSheet();
			sheet.setId(id);
			user.addCharacter(sheet);
		}
		
		return user;
	}
	
	@JsonDeserialize
    private interface DefaultJsonDeserializer {
        // Reset default json deserializer
    }
	
	private String removeEmptyStrings(String source) {	
		LOGGER.debug("Received INPUT: " + source);
		String temp = removeEscapes(source);
		LOGGER.debug("Rmoved ESCAPES: " + temp);
		String cleared = temp.replaceAll("(\"\")", "null");
		LOGGER.debug("Removed EMPTY STRINGS: " + cleared);
		String output = cleared.replace("inches", "\\\"");
		LOGGER.debug("Returning OUTPUT: " + output);
		return output;
	}
	
	private static String removeEscapes(String jsonString) {
        StringBuilder result = new StringBuilder();
        boolean escaped = false;

        for (int i = 0; i < jsonString.length(); i++) {
            char currentChar = jsonString.charAt(i);
            if (escaped) {
                escaped = false; // Reset the flag
                if(currentChar == '"') {
                	result.append("inches");
                }
                continue;
            } else if (currentChar == '\\') {
                escaped = true; // Mark the next character as escaped
            } else {
                result.append(currentChar); // Append normal characters
            }
        }
        return result.toString();
    }
	
}
