package com.patrickborrelli.dndiscord.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.entity.message.Message;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import com.patrickborrelli.dndiscord.exceptions.MissingEnvironmentVarException;
import com.patrickborrelli.dndiscord.utilities.ConfigurationUtil;

/**
 * DNDiscordMessageCreateListener is a custom listener class for 
 * the DNDiscord bot that will handle all message create events.
 * 
 * @author Patrick Borrelli
 */
public class DNDiscordMessageCreateListener implements MessageCreateListener {

	private static final Logger LOGGER = LogManager.getLogger(DNDiscordMessageCreateListener.class);
	
	ConfigurationUtil instance;
	
	public DNDiscordMessageCreateListener() {
		try {
			instance = ConfigurationUtil.getInstance();
		} catch (MissingEnvironmentVarException e) {
			LOGGER.error("Unable to get instance of ConfigurationUtil.");
			LOGGER.error(e.getStackTrace());
		}
	}
	
	@Override
	public void onMessageCreate(MessageCreateEvent event) {
		Message message = event.getMessage();
		String prefix = instance == null ? "!" : instance.getBotPrefix();
		LOGGER.debug("Received message: " + message.toString());
		if(!message.getAuthor().isBotUser() && message.getContent().equalsIgnoreCase(prefix + "ping")) {
			//process ping
			LOGGER.debug("Handling ping message.");
			event.getChannel().sendMessage("Pong!");
		} else if(!message.getAuthor().isBotUser() && message.getContent().startsWith(prefix)) {
			//unknown message type:
			event.getChannel().sendMessage("What the hell are you talking about?");
		}
	}

}
