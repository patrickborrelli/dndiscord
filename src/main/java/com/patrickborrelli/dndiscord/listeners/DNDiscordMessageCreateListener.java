package com.patrickborrelli.dndiscord.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.entity.message.Message;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

/**
 * DNDiscordMessageCreateListener is a custom listener class for 
 * the DNDiscord bot that will handle all message create events.
 * 
 * @author Patrick Borrelli
 */
public class DNDiscordMessageCreateListener implements MessageCreateListener {

	private static final Logger LOGGER = LogManager.getLogger(DNDiscordMessageCreateListener.class);
	
	@Override
	public void onMessageCreate(MessageCreateEvent event) {
		Message message = event.getMessage();
		LOGGER.debug("Received message: " + message.toString());
	}

}
