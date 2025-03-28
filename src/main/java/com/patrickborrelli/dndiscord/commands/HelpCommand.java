package com.patrickborrelli.dndiscord.commands;

import java.awt.Color;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.embed.EmbedBuilder;

import com.patrickborrelli.dndiscord.exceptions.CommandProcessingException;
import com.patrickborrelli.dndiscord.messaging.MessageResponse;
import com.patrickborrelli.dndiscord.model.DiscordUser;
import com.patrickborrelli.dndiscord.utilities.AppUtil;
import com.patrickborrelli.dndiscord.utilities.CommandUtil;

/**
 * Command class to handle all types of help commands issued from Discord to the
 * DnDiscord bot.
 * 
 * @author Patrick Borrelli
 */
public class HelpCommand implements CommandExecutor {
	private static final Logger LOGGER = LogManager.getLogger(HelpCommand.class);
	private AppUtil appUtil;
	private static final String HELP_TEXT = "**help** - shows this message.\n"
			+ "__**import**__ - imports third-party characters for DnDiscord use.\n"
			+ "__**ping**__ - tests the bot's connection.\n"
			+ "__**prefix**__ - sets the bot's prefix for this server.\n"
			+ "__**roll, r**__ - generates dice roll results.\n"
			+ "__**sheet**__ - handling of chosen character sheet.\n";

	private static final String MORE_HELP = "An underlined command indicates that the command has subcommands.\n"
			+ "Type help <command> for more information on a specific command.";

	private static final String ROLL_HELP_TEXT = "**roll XdY+/-Z** - expresion plus or minus a constant.\n"
			+ "***X*** - number of rolls. *Optional*\n" + "***Y*** - die type.\n"
			+ "***Z*** - constant modifier OR another expression *Optional*\n\n"
			+ "**roll XdY[rN|kN|klN|khN|dlN|dhN]+/-Z** - optional modifiers.\n"
			+ "***rN*** - reroll all N's, e.g. r1 will cause all ones to be rerolled.\n"
			+ "***kN | khN*** - keep N highest rolls.\n" + "***klN*** - keep N lowest rolls.\n"
			+ "***dhN*** - drop highest N rolls.\n" + "***dlN*** - drop lowest N rolls.\n"
			+ "*NOTE:*  the modifiers above apply to ONE expression, and should immediately follow that expression.\n\n"
			+ "**roll XdY+/-Z[critd|critr]** - optional roll modifiers.\n"
			+ "***__critd__*** - critical hit, double the dice rolled.\n"
			+ "***__critr__*** - critical hit, double the rolled result.\n"
			+ "***roll repeat(<A>, <B>)*** - repeatedly calculate expression A, B times.\n"
			+ "***roll save(<A>, <B>)*** - saves roll A with name B.\n"
			+ "***roll list*** - returns a list of all saved rolls.\n"
			+ "***roll character*** - generates character ability scores.\n";

	private static final String ROLL_EXAMPLE_TEXT = "**1d8+5** - rolls a d8 and adds a modifier of 5\n"
			+ "**4d6r1** - rerolls all 1s\n" + "**4d6kh3** - keeps the highest 3 results\n"
			+ "**4d6r1k3** - rerolls all 1s and keeps the highest remaining 3 results\n"
			+ "**2d8dl1** - drops the lowest result\n"
			+ "**1d8+6 critd** - rolls critical hit, doubles the dice rolled\n"
			+ "**1d8+6 critr** - rolls critical hit, doubles the dice result rolled\n"
			+ "**1d8+6 + 2d6** - combined roll expressions\n"
			+ "**repeat(4d6k3, 6)** - generate 6 results, perhaps for character creation.\n"
			+ "**save(4d6kh3, statroll)** - saves function 4d6kh3 which can now be run using [roll $statroll].\n";

	private static final String PREFIX_HELP_TEXT = "**prefix** <<new prefix characters>>\n"
			+ "*example:* **prefix !!** \n";

	private static final String PING_HELP_TEXT = "**ping** - returns round trip message latency to the server\n"
			+ "**ping author** - returns information about the bot author\n"
			+ "**ping time** - returns the current date and time at the server.";
	
	private static final String SHEET_HELP_TEXT = "**sheet** - displays the active character sheet.\n"
			+ "**sheet list** - returns a list of all imported characters.\n"
			+ "**sheet switch <<character name>>** - sets the selected character as the active sheet.";

	private static final String IMPORT_HELP_TEXT = "**import beyond <<dnd beyond character id number>>** - imports the selected "
			+ "character and makes them your primary character.";

	private static final String IMPORT_DEV_LIST_TEXT = "Future functionality will include ability to import Roll20 characters.";

	public HelpCommand() {
		appUtil = AppUtil.getInstance();
	}

	@Override
	public void onCommand(Message msg, DiscordUser user, long messageReceiptTime) throws CommandProcessingException {
		TextChannel channel = msg.getChannel();
		String[] args = msg.getContent().split(" ");

		if (args.length > 2) {
			MessageResponse.sendReply(channel, "Too many arguments provided");
		} else if (args.length == 1) {
			// send generic help response
			buildBasicHelpEmbed(msg);
		} else if (args.length == 2) {
			// specific command help:
			String argument = args[1];
			if (argument.equalsIgnoreCase(CommandUtil.ROLL) || argument.equalsIgnoreCase(CommandUtil.R)) {
				if(LOGGER.isDebugEnabled()) 
					LOGGER.debug("Building dialog for ROLL help.");
				buildRollHelpEmbed(msg);
			} else if (argument.equalsIgnoreCase(CommandUtil.PREFIX)) {
				if(LOGGER.isDebugEnabled()) 
					LOGGER.debug("Building dialog for PREFIX help.");
				buildPrefixHelpEmbed(msg);
			} else if (argument.equalsIgnoreCase(CommandUtil.PING)) {
				if(LOGGER.isDebugEnabled()) 
					LOGGER.debug("Building dialog for PING help.");
				buildPingHelpEmbed(msg);
			} else if (argument.equalsIgnoreCase(CommandUtil.IMPORT)) {
				if(LOGGER.isDebugEnabled()) 
					LOGGER.debug("Building dialog for IMPORT help.");
				buildImportHelpEmbed(msg);
			} else if(argument.equalsIgnoreCase(CommandUtil.SHEET)) {
				if(LOGGER.isDebugEnabled()) 
					LOGGER.debug("Building dialog for SHEET help.");
				buildSheetHelpEmbed(msg);
			} else {
				MessageResponse.sendReply(channel, "Invalid help command: " + msg.getContent());
			}
		} else {
			MessageResponse.sendReply(channel, "Unknown argument provided.");
		}
	}

	public void onCommand(Message msg, String command, DiscordUser user, long messageReceiptTime)
			throws CommandProcessingException {
		if (command == CommandUtil.ROLL) {
			LOGGER.debug("Building dialog for ROLL help.");
			buildRollHelpEmbed(msg);
		} else if (command == CommandUtil.PREFIX) {
			LOGGER.debug("Building dialog for PREFIX help.");
			buildPrefixHelpEmbed(msg);
		} else if (command == CommandUtil.PING) {
			LOGGER.debug("Building dialog for PING help.");
			buildPingHelpEmbed(msg);
		} else if (command == CommandUtil.IMPORT) {
			LOGGER.debug("Building dialog for IMPORT help.");
			buildImportHelpEmbed(msg);
		}
	}

	private void buildImportHelpEmbed(Message msg) {
		EmbedBuilder embed = new EmbedBuilder().setTitle("DnDiscord Help -import")
				.setDescription("Imports third-party characters for DnDiscord use.")
				.setAuthor("DnDiscord", "http://github.com/patrickborrelli", appUtil.getBotAvatarUrl().toString())
				.addField("Format", IMPORT_HELP_TEXT).addField("Future Developments", IMPORT_DEV_LIST_TEXT)
				.setColor(Color.GREEN)
				.setFooter("©2020 AwareSoft, LLC", "https://cdn.discordapp.com/embed/avatars/1.png")
				.setThumbnail(appUtil.getBotAvatarUrl().toString());
		MessageResponse.sendEmbedMessage(msg.getChannel(), embed);
	}

	private void buildPrefixHelpEmbed(Message msg) {
		EmbedBuilder embed = new EmbedBuilder().setTitle("DnDiscord Help -prefix")
				.setDescription("Changes the server prefix for DnDiscord.")
				.setAuthor("DnDiscord", "http://github.com/patrickborrelli", appUtil.getBotAvatarUrl().toString())
				.addField("Format", PREFIX_HELP_TEXT).setColor(Color.GREEN)
				.setFooter("©2020 AwareSoft, LLC", "https://cdn.discordapp.com/embed/avatars/1.png")
				.setThumbnail(appUtil.getBotAvatarUrl().toString());
		MessageResponse.sendEmbedMessage(msg.getChannel(), embed);
	}
	
	private void buildSheetHelpEmbed(Message msg) {
		EmbedBuilder embed = new EmbedBuilder().setTitle("DnDiscord Help -sheet")
				.setDescription("Handles character sheet inquiries.")
				.setAuthor("DnDiscord", "http://github.com/patrickborrelli", appUtil.getBotAvatarUrl().toString())
				.addField("Format", SHEET_HELP_TEXT).setColor(Color.GREEN)
				.setFooter("©2020 AwareSoft, LLC", "https://cdn.discordapp.com/embed/avatars/1.png")
				.setThumbnail(appUtil.getBotAvatarUrl().toString());
		MessageResponse.sendEmbedMessage(msg.getChannel(), embed);
	}

	private void buildBasicHelpEmbed(Message msg) {
		EmbedBuilder embed = new EmbedBuilder().setTitle("DnDiscord Help").setDescription(
				"DnDiscord is a multifaceted D&D 5e utility bot designed to enable you and your party a seamless online D&D experience.")
				.setAuthor("DnDiscord", "http://github.com/patrickborrelli", appUtil.getBotAvatarUrl().toString())
				.addField("Basic Commands", HELP_TEXT).addField("More Help", MORE_HELP).setColor(Color.GREEN)
				.setFooter("©2020 AwareSoft, LLC", "https://cdn.discordapp.com/embed/avatars/1.png")
				.setThumbnail(appUtil.getBotAvatarUrl().toString());
		MessageResponse.sendEmbedMessage(msg.getChannel(), embed);
	}

	private void buildRollHelpEmbed(Message msg) {
		EmbedBuilder embed = new EmbedBuilder().setTitle("DnDiscord Help -roll, r")
				.setDescription("Rolls dice in an XdY format.")
				.setAuthor("DnDiscord", "http://github.com/patrickborrelli", appUtil.getBotAvatarUrl().toString())
				.addField("Formatting", ROLL_HELP_TEXT).addField("Examples", ROLL_EXAMPLE_TEXT)
				.addField("Additional Help", MORE_HELP).setColor(Color.GREEN)
				.setFooter("©2020 AwareSoft, LLC", "https://cdn.discordapp.com/embed/avatars/1.png")
				.setThumbnail(appUtil.getBotAvatarUrl().toString());
		MessageResponse.sendEmbedMessage(msg.getChannel(), embed);
	}

	private void buildPingHelpEmbed(Message msg) {
		EmbedBuilder embed = new EmbedBuilder().setTitle("DnDiscord Help -ping")
				.setDescription("Retrieves information from server.")
				.setAuthor("DnDiscord", "http://github.com/patrickborrelli", appUtil.getBotAvatarUrl().toString())
				.addField("Formatting", PING_HELP_TEXT).setColor(Color.GREEN)
				.setFooter("©2020 AwareSoft, LLC", "https://cdn.discordapp.com/embed/avatars/1.png")
				.setThumbnail(appUtil.getBotAvatarUrl().toString());
		MessageResponse.sendEmbedMessage(msg.getChannel(), embed);
	}
}
