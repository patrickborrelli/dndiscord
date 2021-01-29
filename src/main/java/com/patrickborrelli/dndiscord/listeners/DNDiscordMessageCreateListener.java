package com.patrickborrelli.dndiscord.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageAttachment;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.user.User;
import org.javacord.api.entity.user.UserFlag;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import com.patrickborrelli.dndiscord.commands.CommandExecutor;
import com.patrickborrelli.dndiscord.commands.CommandExecutorRouter;
import com.patrickborrelli.dndiscord.exceptions.CommandProcessingException;
import com.patrickborrelli.dndiscord.exceptions.MissingEnvironmentVarException;
import com.patrickborrelli.dndiscord.model.DiscordUser;
import com.patrickborrelli.dndiscord.model.webservice.WebserviceManager;
import com.patrickborrelli.dndiscord.utilities.AppUtil;
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
	WebserviceManager wsManager;
	
	ConfigurationUtil instance;
	
	public DNDiscordMessageCreateListener() {
		try {
			instance = ConfigurationUtil.getInstance();
			wsManager = WebserviceManager.getInstance();
		} catch (MissingEnvironmentVarException e) {
			LOGGER.error("Unable to get instance of ConfigurationUtil.");
			LOGGER.error(e.getStackTrace());
		}
	}
	
	@Override
	public void onMessageCreate(MessageCreateEvent event) {
		DiscordUser user;
		Message message = event.getMessage();
		LOGGER.debug("Received message: " + message.toString());
		List<MessageAttachment> attachments = message.getAttachments();
		if(attachments != null && attachments.size() > 0) {
			for(MessageAttachment file : attachments) {
				LOGGER.debug("Recieved file attachment: " + file.getFileName());
			}
		}
		String[] messageArgs = message.getContent().split(" ");
		boolean isRealUser = !message.getAuthor().isBotUser();
		String command = stripPrefix(messageArgs[0]);
		
		//check to get user who authored message:
		MessageAuthor author = message.getAuthor();
		Optional<User> optUser = author.asUser();
		User currentUser = null;
		if(optUser.isPresent()) currentUser = optUser.get();
		
		if(currentUser != null) {
			LOGGER.debug("Message sent by user: " + currentUser.toString());
			if(isRealUser) {
				user = wsManager.getUser(String.valueOf(currentUser.getId()));
				if(user == null) {
					//no user found so create one:
					LOGGER.error("Could not find user.  Must create one.");
					user = wsManager.createUser(
							String.valueOf(currentUser.getId()), 
							currentUser.getName(), 
							currentUser.getDiscriminator(), 
							String.valueOf(currentUser.getAvatar().hashCode()), 
							currentUser.isBot(), 
							currentUser.getUserFlags().contains(UserFlag.SYSTEM));
					LOGGER.debug("Created user: " + user.toString());
				} else {
					LOGGER.debug("Retrieved existing user: " + user.toString());
				}
			}
		}	
		
		if(isRealUser && isMyMessage(message)) {		
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
						
					case CommandUtil.SHEET:
						LOGGER.debug("Handling sheet command message.");
						executor = router.getCommandExecutor(CommandUtil.SHEET);
						if(null != executor) executor.onCommand(message);
						break;
						
					case CommandUtil.IMPORT:
						LOGGER.debug("Handling import command message.");
						executor = router.getCommandExecutor(CommandUtil.IMPORT);
						if(null != executor) executor.onCommand(message);
						break;
						
					default:						
						if(message.getMentionedUsers().contains(AppUtil.getInstance().getApi().getYourself())) {
							LOGGER.info("DNDiscord bot is mentioned in the message.");
							executor = router.getCommandExecutor(CommandUtil.ADMIN);
							if(null != executor) executor.onCommand(message);
						} else {
							//TODO: more rigorous error handling here:
							LOGGER.info("Received unparsable message: " + message.getContent());
						}
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
		String prefix = instance == null ? "-" : instance.getBotPrefix();
		
		String[] finalargs = prefixed.split(prefix);
		if(finalargs.length > 1) {
			result = finalargs[1].toUpperCase();
		}
		return result;		
	}
	
	private boolean isMyMessage(Message message) {
		boolean isForProcessing = false;
		String prefix = instance == null ? "-" : instance.getBotPrefix();
		if(message.getContent().startsWith(prefix) ||
			message.getMentionedUsers().contains(AppUtil.getInstance().getApi().getYourself())) {
			isForProcessing = true;
		}		
		return isForProcessing;
	}

}
