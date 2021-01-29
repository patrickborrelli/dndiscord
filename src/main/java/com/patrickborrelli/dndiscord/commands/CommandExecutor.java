package com.patrickborrelli.dndiscord.commands;

import org.javacord.api.entity.message.Message;
import com.patrickborrelli.dndiscord.exceptions.CommandProcessingException;
import com.patrickborrelli.dndiscord.model.DiscordUser;

/**
 * Common interface for DNDiscord Command processing.
 * 
 * @author Patrick Borrelli
 */
public interface CommandExecutor {
	/**
	 * Method that provides all handling for any command implementation.
	 * 
	 * @param msg the DiscordMessage to be processed
	 * @param user the DiscordUser who is sending the message
	 * @throws CommandProcessingException
	 */
	public void onCommand(Message msg, DiscordUser user) throws CommandProcessingException;
}
