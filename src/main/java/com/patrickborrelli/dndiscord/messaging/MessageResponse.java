package com.patrickborrelli.dndiscord.messaging;

import org.javacord.api.entity.channel.TextChannel;

/**
 * Centralized provider to handle all outgoing 
 * message traffic with a series of static
 * methods.
 * 
 * @author Patrick Borrelli
 */
public class MessageResponse {
	public static void sendReply(TextChannel channel, String reply) {
		channel.sendMessage(reply);
	}
}
