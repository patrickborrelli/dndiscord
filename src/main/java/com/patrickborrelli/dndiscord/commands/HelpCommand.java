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

import com.patrickborrelli.dndiscord.exceptions.CommandProcessingException;
import com.patrickborrelli.dndiscord.messaging.MessageResponse;
import com.patrickborrelli.dndiscord.utilities.AppUtil;
import com.patrickborrelli.dndiscord.utilities.CommandUtil;

/**
 * Command class to handle all types of help commands
 * issued from Discord to the DnDiscord bot.
 * 
 * @author Patrick Borrelli
 */
public class HelpCommand implements CommandExecutor {
	private static final Logger LOGGER = LogManager.getLogger(HelpCommand.class);
	private AppUtil instance;
	private static final String HELP_TEXT = 
			"__**help**__ - shows this message.\n" +
			"__**ping**__ - tests the bot's connection.\n" +
			"__**prefix**__ - sets the bot's prefix for this server.\n" +
			"__**roll, r**__ - tests the bot's connection.\n";
	
	private static final String MORE_HELP = 
			"An underlined command indicates that the command has subcommands.\n" +
			"Type help <command> for more information on a specific command.";
	
	private static final String ROLL_HELP_TEXT = 
			"**roll|r XdY+/-Z** - simplest form, expresion plus or minus a constant.\n" + 
			"***X*** - number of rolls. *Optional* will be treated as 1 if not provided.\n" + 
			"***Y*** - die type.\n" +
			"***Z*** - constant modifier OR another expression *Optional*\n\n" +
			"**roll|r XdY[rN|kN|klN|khN|dlN|dhN]+/-Z** - optional expression modifiers.\n" +
			"***rN*** - reroll all N's, e.g. r1 will cause all ones to be rerolled.\n" + 
			"***kN|khN*** - keep N highest rolls.\n" +
			"***klN*** - keep N lowest rolls.\n" + 
			"***dhN*** - drop highest N rolls.\n" +
			"***dlN*** - drop lowest N rolls.\n" + 
			"*NOTE:*  the modifiers above apply to ONE expression, and should immediately follow that expression.\n\n" + 
			"**roll|r XdY+/-Z[critd|critr]** - optional roll modifiers.\n" + 
			"***critd*** - critical hit, double the dice rolled.\n" +
			"***critr*** - critical hit, double the rolled result.\n";
			
	
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
			//specific command help:
			String argument = args[1];
			if(argument.equalsIgnoreCase(CommandUtil.ROLL) || 
					argument.equalsIgnoreCase(CommandUtil.R)) {
				LOGGER.debug("Attempting to build dialog for ROLL help.");
				buildRollHelpEmbed(msg);
			}
		} else {
			MessageResponse.sendReply(channel, "Unknown argument provided.");
		}
	}
	
	private void buildBasicHelpEmbed(Message msg) {
		EmbedBuilder embed = new EmbedBuilder()
			.setTitle("DnDiscord Help")
			.setDescription("DnDiscord is a multifaceted D&D 5e utility bot designed to enable you and your party a seamless online D&D experience.")
		    .setAuthor("DnDiscord", "http://github.com/patrickborrelli", getBotAvatarUrl().toString())
		    .addField("Basic Commands", HELP_TEXT)
		    .addField("More Help", MORE_HELP)
		    .setColor(Color.GREEN)
		    .setFooter("©2020 AwareSoft, LLC", "https://cdn.discordapp.com/embed/avatars/1.png")
		    .setThumbnail(getBotAvatarUrl().toString());
		MessageResponse.sendEmbedMessage(msg.getChannel(), embed);		
	}
	
	private void buildRollHelpEmbed(Message msg) {
		EmbedBuilder embed = new EmbedBuilder()
			.setTitle("DnDiscord Help - roll|r")
			.setDescription("Rolls dice in an XdY format.")
		    .setAuthor("DnDiscord", "http://github.com/patrickborrelli", getBotAvatarUrl().toString())
		    .addField("Formatting", ROLL_HELP_TEXT)
		    .addField("Examples", "Here is where the examples will go.")
		    .setColor(Color.GREEN)
		    .setFooter("©2020 AwareSoft, LLC", "https://cdn.discordapp.com/embed/avatars/1.png")
		    .setThumbnail(getBotAvatarUrl().toString());
		MessageResponse.sendEmbedMessage(msg.getChannel(), embed);
	}
	
	private URL getBotAvatarUrl() {
		DiscordApi apiConnection = instance.getApi();
		User botUser = apiConnection.getYourself();		
		return botUser.getAvatar().getUrl();
	}
}
