package com.patrickborrelli.dndiscord.commands;

import java.awt.Color;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.user.User;

import com.patrickborrelli.dndiscord.DNDiscordMain;
import com.patrickborrelli.dndiscord.exceptions.CommandProcessingException;
import com.patrickborrelli.dndiscord.exceptions.MissingEnvironmentVarException;
import com.patrickborrelli.dndiscord.messaging.MessageResponse;
import com.patrickborrelli.dndiscord.utilities.AppUtil;
import com.patrickborrelli.dndiscord.utilities.ConfigurationUtil;

//TODO: will need to implement a database system so that user/server prefix can be stored in case app goes down

/**
 * Command class to handle all types of prefix commands
 * issued from Discord to the DnDiscord bot.
 * 
 * @author Patrick Borrelli
 */
public class PrefixCommand implements CommandExecutor {
	private static final Logger LOGGER = LogManager.getLogger(DNDiscordMain.class);
	private static ConfigurationUtil configUtil;
	private AppUtil appUtil;
	
	public PrefixCommand() {
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
		TextChannel channel = msg.getChannel();
		String[] args = msg.getContent().split(" ");
		String currentPrefix = configUtil.getBotPrefix();
		
		if(args.length > 2) {
			buildFormatEmbed(msg);
		} else if(args.length == 1) {
			buildFormatEmbed(msg);
		} else if(args.length == 2) {
			if(args[1].equalsIgnoreCase("list")) {
				MessageResponse.sendReply(channel, "Current prefix is: " + configUtil.getBotPrefix());
			} else {
				//get args[1] and set it as the prefix
				configUtil.setBotPrefix(args[1]);			
				MessageResponse.sendReply(channel, "DnDiscord command prefix changed from: " + currentPrefix + " to: " + configUtil.getBotPrefix());
			}			
		}
	}
	
	private void buildFormatEmbed(Message msg) {
		//get bot avatar:
		DiscordApi apiConnection = appUtil.getApi();
		User botUser = apiConnection.getYourself();		
		URL avatarUrl = botUser.getAvatar().getUrl();
		
		EmbedBuilder embed = new EmbedBuilder()
			.setTitle("Prefix Command Help")
		    .addField("Command Format", "prefix <<new prefix characters>>\n")
		    .setColor(Color.GREEN)
		    .setThumbnail(avatarUrl.toString());
		MessageResponse.sendEmbedMessage(msg.getChannel(), embed);		
	}
}
