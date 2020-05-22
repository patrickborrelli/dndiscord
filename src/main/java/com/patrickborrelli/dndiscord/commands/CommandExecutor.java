package com.patrickborrelli.dndiscord.commands;

import org.javacord.api.entity.message.Message;
import com.patrickborrelli.dndiscord.exceptions.CommandProcessingException;

/**
 * Common interface for DNDiscord Command processing.
 * 
 * @author Patrick Borrelli
 */
public interface CommandExecutor {
	public void onCommand(Message msg) throws CommandProcessingException;
}
