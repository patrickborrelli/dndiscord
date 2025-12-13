package com.patrickborrelli.dndiscord.model.dndiscord;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.javacord.api.entity.message.embed.Embed;

import com.patrickborrelli.dndiscord.utilities.CommandUtil;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model of a singular archive message.
 *
 * @author Patrick Borrelli
 */
@Data
@NoArgsConstructor
public class ArchiveMessage implements Comparable<ArchiveMessage> {
	
	private static final String PATTERN_FORMAT = "dd-MM-yy hh:mm:ss";
	
	private Instant createTimestamp;
	private boolean isBot;
	private String userDisplayName;
	private String content;
	private List<Embed> embeds;
	
	@Override
	public int compareTo(ArchiveMessage otherMessage) {
		return createTimestamp.compareTo(otherMessage.createTimestamp);
	}
	
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN_FORMAT).withZone(ZoneId.systemDefault());
		StringBuilder result = new StringBuilder();
		
		result.append(formatter.format(createTimestamp));
		result.append(CommandUtil.SPACE);
		result.append(userDisplayName).append(": ");
		result.append(content);
		
		return result.toString();
	}
	
}
