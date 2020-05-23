package com.patrickborrelli.dndiscord.commands;

import java.awt.Color;
import java.util.concurrent.CompletableFuture;

import org.javacord.api.DiscordApi;
import org.javacord.api.entity.ApplicationInfo;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.embed.EmbedBuilder;

import com.patrickborrelli.dndiscord.exceptions.CommandProcessingException;
import com.patrickborrelli.dndiscord.messaging.MessageResponse;
import com.patrickborrelli.dndiscord.utilities.AppUtil;

/**
 * Command class to handle all types of help commands
 * issued from Discord to the DnDiscord bot.
 * 
 * @author Patrick Borrelli
 */
public class HelpCommand implements CommandExecutor {
	
	private AppUtil instance;
	
	public HelpCommand() {
		instance = AppUtil.getInstance();
	}

	@Override
	public void onCommand(Message msg) throws CommandProcessingException {
		TextChannel channel = msg.getChannel();
		String[] args = msg.getContent().split(" ");
		
		if(args.length > 2) {
			MessageResponse.sendReply(channel, "Too many arguments provided");
		} else if(args.length == 1) {
			//send generic help response
			buildBasicHelpEmbed(msg);
		} else if(args.length == 2) {
			//specific command help
		} else {
			MessageResponse.sendReply(channel, "Unknown argument provided.");
		}
	}
	
	private void buildBasicHelpEmbed(Message msg) {
		//get bot avatar:
		DiscordApi apiConnection = instance.getApi();
		CompletableFuture<ApplicationInfo> botUser = apiConnection.getApplicationInfo();
		EmbedBuilder embed = new EmbedBuilder()
			.setTitle("DnDiscord Help")
			.setDescription("DnDiscord is a multifaceted D&D 5e utility bot designed to enable you and your party a seamless online D&D experience.")
		    .setAuthor("Patrick Borrelli", "http://github.com/patrickborrelli", "https://cdn.discordapp.com/embed/avatars/0.png")
		    .addField("Basic Commands", "For help on specific commands, type <prefix>help <command>.")
		    .setColor(Color.GREEN)
		    .setFooter("Footer", "https://cdn.discordapp.com/embed/avatars/1.png");
		MessageResponse.sendEmbedMessage(msg.getChannel(), embed);		
	}
}
