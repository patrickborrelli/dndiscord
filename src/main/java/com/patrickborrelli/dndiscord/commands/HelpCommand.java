package com.patrickborrelli.dndiscord.commands;

import java.awt.Color;
import java.net.URL;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.user.User;

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
	private static final String HELP_TEXT = 
			"__**prefix**__ - sets the bot's prefix for this server.\n" +
			"__**ping**__ - tests the bot's connection.\n" +
			"__**help**__ - shows this message.\n";
	
	private static final String MORE_HELP = 
			"An underlined command indicates that the command has subcommands.\n" +
			"Type help <command> for more information on a specific command.";
	
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
		User botUser = apiConnection.getYourself();		
		URL avatarUrl = botUser.getAvatar().getUrl();
				
		EmbedBuilder embed = new EmbedBuilder()
			.setTitle("DnDiscord Help")
			.setDescription("DnDiscord is a multifaceted D&D 5e utility bot designed to enable you and your party a seamless online D&D experience.")
		    .setAuthor("DnDiscord", "http://github.com/patrickborrelli", avatarUrl.toString())
		    .addField("Basic Commands", HELP_TEXT)
		    .addField("More Help", MORE_HELP)
		    .setColor(Color.GREEN)
		    .setFooter("Footer", "https://cdn.discordapp.com/embed/avatars/1.png")
		    .setThumbnail(avatarUrl.toString());
		MessageResponse.sendEmbedMessage(msg.getChannel(), embed);		
	}
}
