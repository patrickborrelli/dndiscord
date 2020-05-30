package com.patrickborrelli.dndiscord.commands;

import java.awt.Color;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.user.User;

import com.patrickborrelli.dndiscord.exceptions.CommandProcessingException;
import com.patrickborrelli.dndiscord.exceptions.MissingEnvironmentVarException;
import com.patrickborrelli.dndiscord.messaging.MessageResponse;
import com.patrickborrelli.dndiscord.utilities.AppUtil;
import com.patrickborrelli.dndiscord.utilities.CommandUtil;
import com.patrickborrelli.dndiscord.utilities.ConfigurationUtil;

/**
 * Command class to handle all types of administrative commands
 * issued from Discord to the DnDiscord bot.  Note that all administrative
 * commands will not begin with the bot prefix but rather will
 * mention the bot in the command itself.
 * 
 * @author Patrick Borrelli
 */
public class AdminCommand implements CommandExecutor {
	private static final Logger LOGGER = LogManager.getLogger(AdminCommand.class);
	private static ConfigurationUtil configUtil;
	private AppUtil appUtil;
	
	public AdminCommand() {
		try {
			configUtil = ConfigurationUtil.getInstance();
		} catch(MissingEnvironmentVarException mevEx) {
			System.err.println("Failed to initiate DNDiscord. " + mevEx.getLocalizedMessage());
			mevEx.printStackTrace();
			LOGGER.error("Failed to initiate DNDiscord. " + mevEx.getLocalizedMessage());
		}
		appUtil = AppUtil.getInstance();
	}

	@Override
	public void onCommand(Message msg) throws CommandProcessingException {
		String[] args = msg.getContent().split(" ");
		String primaryToken = args.length > 0 ? args[1].toUpperCase() : null;
		String secondaryToken = args.length > 1 ? args[2].toUpperCase() : null;
		
		switch(primaryToken) {
			case CommandUtil.PREFIX:
				LOGGER.debug("Processing a prefix command.");
				switch(secondaryToken) {
					case CommandUtil.RESET:
						LOGGER.debug("Processing a prefix reset.");
						configUtil.setBotPrefix(ConfigurationUtil.DEFAULT_PREFIX);
						//notify user that prefix has been reset:
						buildPrefixResetEmbed(msg);						
						break;
					default:
						LOGGER.warn("Unknown secondary token: " + secondaryToken);
				}
				break;
			default:
				LOGGER.warn("Unknown primary token: " + primaryToken);
		}
	}
	
	private void buildPrefixResetEmbed(Message msg) {
		//get bot avatar:
		DiscordApi apiConnection = appUtil.getApi();
		User botUser = apiConnection.getYourself();		
		URL avatarUrl = botUser.getAvatar().getUrl();
		//TODO: move embed color to configuration and reference from there.
		EmbedBuilder embed = new EmbedBuilder()
			.setTitle("Admin Command Request")
		    .addField("Message Processed Successfully", "Prefix reset to " + configUtil.getBotPrefix() + "\n")
		    .setColor(Color.GREEN)
		    .setThumbnail(avatarUrl.toString());
		MessageResponse.sendEmbedMessage(msg.getChannel(), embed);		
	}
}