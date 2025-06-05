package com.patrickborrelli.dndiscord.commands;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;

import com.patrickborrelli.dndiscord.exceptions.CommandProcessingException;
import com.patrickborrelli.dndiscord.exceptions.MissingEnvironmentVarException;
import com.patrickborrelli.dndiscord.messaging.MessageResponse;
import com.patrickborrelli.dndiscord.model.DiscordUser;
import com.patrickborrelli.dndiscord.utilities.CommandUtil;
import com.patrickborrelli.dndiscord.utilities.ConfigurationUtil;

/**
 * Command class to handle all types of prefix commands issued from Discord to
 * the DnDiscord bot.
 * 
 * @author Patrick Borrelli
 */
public class PrefixCommand implements CommandExecutor {

	private static final Logger LOGGER = LogManager.getLogger(PrefixCommand.class);
	private static ConfigurationUtil configUtil;

	public PrefixCommand() {
		try {
			configUtil = ConfigurationUtil.getInstance();
		} catch (MissingEnvironmentVarException mevEx) {
			System.err.println("Failed to initiate DNDiscord. " + mevEx.getLocalizedMessage());
			mevEx.printStackTrace();
			LOGGER.error("Failed to initiate DNDiscord. " + mevEx.getLocalizedMessage());
		}
	}

	@Override
	public void onCommand(Message msg, DiscordUser user, long messageReceiptTime) throws CommandProcessingException {
		TextChannel channel = msg.getChannel();
		String[] args = msg.getContent().split(" ");
		String currentPrefix = configUtil.getBotPrefix();

		if (args.length > 2 || args.length == 1) {
			LOGGER.warn("Incorrect arguments provided to Prefix command: " + msg.getContent());
			MessageResponse.sendReply(channel, "Incorrect arguments provided to Prefix command: " + msg.getContent());
			new HelpCommand().onCommand(msg, CommandUtil.PREFIX, user, messageReceiptTime);
		} else if (args.length == 2) {
			if (args[1].equalsIgnoreCase(CommandUtil.LIST)) {
				MessageResponse.sendReply(channel, "Current prefix is: " + configUtil.getBotPrefix());
			} else {
				// get args[1] and set it as the prefix
				configUtil.setBotPrefix(args[1]);
				MessageResponse.sendReply(channel, "DnDiscord command prefix changed from: " + currentPrefix + " to: "
						+ configUtil.getBotPrefix());
			}
		}
	}
}
