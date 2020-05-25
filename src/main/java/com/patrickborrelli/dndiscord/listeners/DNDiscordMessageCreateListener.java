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
import com.patrickborrelli.dndiscord.utilities.CommandUtil;
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
		LOGGER.debug("Received message: " + message.toString());
		String[] messageArgs = message.getContent().split(" ");
		boolean isRealUser = !message.getAuthor().isBotUser();
		String command = stripPrefix(messageArgs[0]);
		
		if(isRealUser) {		
			try {	
				switch(command) {
					case CommandUtil.PING:
						LOGGER.debug("Handling ping message.");
						executor = router.getCommandExecutor(CommandUtil.PING);
						if(null != executor) executor.onCommand(message);
						break;
						
					case CommandUtil.PREFIX:
						LOGGER.debug("Handling prefix message.");
						executor = router.getCommandExecutor(CommandUtil.PREFIX);
						if(null != executor) executor.onCommand(message);
						break;
						
					case CommandUtil.HELP:
						LOGGER.debug("Handling help message.");
						executor = router.getCommandExecutor(CommandUtil.HELP);
						if(null != executor) executor.onCommand(message);
						break;
						
					case CommandUtil.ROLL:
					case CommandUtil.R:
						LOGGER.debug("Handling Roll message.");
						executor = router.getCommandExecutor(CommandUtil.ROLL);
						if(null != executor) executor.onCommand(message);
						break;
						
					default:
						LOGGER.info("Received unparsable message: " + message.getContent());
						//TODO: return some sort of response on unparsable message
				}			
				executor = null;
				
			} catch(CommandProcessingException cpe) {
				LOGGER.error("Error during command processing: " + cpe.getLocalizedMessage());
				cpe.printStackTrace();
			}
		}
	}
	
	private String stripPrefix(String prefixed) {
		String result = "";
		String prefix = instance == null ? "!" : instance.getBotPrefix();
		
		String[] finalargs = prefixed.split(prefix);
		if(finalargs.length > 1) {
			result = finalargs[1].toUpperCase();
		}
		return result;		
	}

}
