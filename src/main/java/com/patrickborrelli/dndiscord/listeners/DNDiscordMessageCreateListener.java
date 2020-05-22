package com.patrickborrelli.dndiscord.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.entity.message.Message;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import com.patrickborrelli.dndiscord.commands.CommandExecutor;
import com.patrickborrelli.dndiscord.commands.CommandExecutorRouter;
import com.patrickborrelli.dndiscord.exceptions.CommandProcessingException;
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
	private CommandExecutorRouter router = CommandExecutorRouter.getInstance();
	private CommandExecutor executor = null;
	
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
		String[] messageArgs = message.getContent().split(" ");
		boolean isRealUser = !message.getAuthor().isBotUser();
		
		try {			
			if(isRealUser && messageArgs[0].equalsIgnoreCase(prefix + "ping")) {
				//process ping
				LOGGER.debug("Handling ping message.");
				//TODO: add constants for command types
				executor = router.getCommandExecutor("ping");
				if(null != executor) executor.onCommand(message);
			} else if(isRealUser && messageArgs[0].equalsIgnoreCase(prefix + "prefix")) {
				//process prefix
				LOGGER.debug("Handling prefix message.");
				executor = router.getCommandExecutor("prefix");
				if(null != executor) executor.onCommand(message);
			} else if(isRealUser && messageArgs[0].equalsIgnoreCase(prefix + "help")) {
				//process prefix
				LOGGER.debug("Handling help message.");
				executor = router.getCommandExecutor("help");
				if(null != executor) executor.onCommand(message);
			} else if(isRealUser && message.getContent().startsWith(prefix)) {
				//unknown message type:
				event.getChannel().sendMessage("What the hell are you talking about?");
			}
			executor = null;
			
		} catch(CommandProcessingException cpe) {
			LOGGER.error("Error during command processing: " + cpe.getLocalizedMessage());
			cpe.printStackTrace();
		}
	}

}
