package com.patrickborrelli.dndiscord.commands;

import java.awt.Color;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.embed.EmbedBuilder;

import com.patrickborrelli.dndiscord.exceptions.CommandProcessingException;
import com.patrickborrelli.dndiscord.messaging.MessageResponse;
import com.patrickborrelli.dndiscord.model.DiscordUser;
import com.patrickborrelli.dndiscord.model.dndiscord.Action;
import com.patrickborrelli.dndiscord.model.dndiscord.CharacterDisplay;
import com.patrickborrelli.dndiscord.model.dndiscord.CharacterSheet;
import com.patrickborrelli.dndiscord.model.webservice.WebserviceManager;
import com.patrickborrelli.dndiscord.utilities.CommandUtil;

public class AttackCommand implements CommandExecutor {

	private static final Logger LOGGER = LogManager.getLogger(AttackCommand.class);
	private static final WebserviceManager WSMANAGER = WebserviceManager.getInstance();

	@Override
	public void onCommand(Message msg, DiscordUser user, long messageReceiptTime) throws CommandProcessingException {
		TextChannel channel = msg.getChannel();
		String[] args = msg.getContent().split(" ");

		CharacterDisplay active = user.getActiveCharacter();
		boolean hasActiveSheet = active != null;

		if (hasActiveSheet) {
			if (args.length == 2) {
				String subcommand = args[1];

				if (subcommand.equalsIgnoreCase(CommandUtil.LIST)) {
					buildAttackListResponse(msg, user, active);
				} else {
					LOGGER.warn("Inappropriate arguments provided to attack command: {}", msg.getContent());
					MessageResponse.sendReply(channel, "Inappropriate arguments provided: " + msg.getContent());
					new HelpCommand().onCommand(msg, CommandUtil.ATTACK, user, messageReceiptTime);
				}
			} else {
				LOGGER.warn("Inappropriate arguments provided to attack command: {}", msg.getContent());
				MessageResponse.sendReply(channel, "Inappropriate arguments provided: " + msg.getContent());
				new HelpCommand().onCommand(msg, CommandUtil.ATTACK, user, messageReceiptTime);
			}
		} else {
			sendNoActiveCharacterSelectedMessage(msg, user);
		}
	}

	private void buildAttackListResponse(Message msg, DiscordUser user, CharacterDisplay activeCharacter) {
		StringBuilder build = new StringBuilder();

		// first get the CharacterSheet by charId
		CharacterSheet sheet = WSMANAGER.getCharacter(activeCharacter.getCharacterId());
		Set<Action> actions = sheet.getActions();

		// iterate through the actions, building the display text:
		for (Action action : actions) {
			if(action.isDisplayAsAttack()) {
				build.append(action.getName()).append(CommandUtil.SPACE)
					.append("- ").append(action.get)
			}
		}

		buildAttackListEmbed(msg, new String(), new CharacterDisplay());
	}

	private void buildAttackListEmbed(Message msg, String attackList, CharacterDisplay activeCharacter) {

		EmbedBuilder embed = new EmbedBuilder().setTitle(activeCharacter.getCharacterName() + "'s Attacks")
				.setDescription(attackList).setColor(Color.GREEN)
				.setFooter("©2020 AwareSoft, LLC", "https://cdn.discordapp.com/embed/avatars/1.png")
				.setThumbnail(activeCharacter.getAvatarUrl());
		MessageResponse.sendEmbedMessage(msg.getChannel(), embed);
	}
}