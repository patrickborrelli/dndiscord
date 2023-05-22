package com.patrickborrelli.dndiscord.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.patrickborrelli.dndiscord.model.dndiscord.CharacterSheet;

/**
 * Representational data encapsulating a
 * Discord user for identification and
 * storage of user specific data.
 *
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DiscordUser {
	
	@JsonProperty("_id")
	private String id;
	private String discord_id;
	private String username;
	private String discriminator;
	@JsonProperty("avatar_hash")
	private String avatar;
	private boolean bot;
	@JsonIgnore
	private List<CharacterSheet> characters = new ArrayList<>();
	
	//default constructor:
	public DiscordUser() {
		
	}

	/**
	 * @return String the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param String the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return String the discord_id
	 */
	public String getDiscord_id() {
		return discord_id;
	}

	/**
	 * @param String the discord_id to set
	 */
	public void setDiscord_id(String discord_id) {
		this.discord_id = discord_id;
	}

	/**
	 * @return String the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param String the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return String the discriminator
	 */
	public String getDiscriminator() {
		return discriminator;
	}

	/**
	 * @param String the discriminator to set
	 */
	public void setDiscriminator(String discriminator) {
		this.discriminator = discriminator;
	}

	/**
	 * @return String the avatar
	 */
	public String getAvatar() {
		return avatar;
	}

	/**
	 * @param String the avatar to set
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	/**
	 * @return boolean the bot
	 */
	public boolean isBot() {
		return bot;
	}

	/**
	 * @param boolean the bot to set
	 */
	public void setBot(boolean bot) {
		this.bot = bot;
	}
	
	public void addCharacter(CharacterSheet sheet) {
		characters.add(sheet);
	}
	
	public List<CharacterSheet> getCharacters() {
		return characters;
	}

	@Override
	public int hashCode() {
		return Objects.hash(avatar, bot, discord_id, discriminator, id, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof DiscordUser))
			return false;
		DiscordUser other = (DiscordUser) obj;
		return Objects.equals(avatar, other.avatar) && bot == other.bot && Objects.equals(discord_id, other.discord_id)
				&& Objects.equals(discriminator, other.discriminator) && Objects.equals(id, other.id)
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "DiscordUser [id=" + id + ", discord_id=" + discord_id + ", username=" + username + ", discriminator="
				+ discriminator + ", avatar=" + avatar + ", bot=" + bot + "]";
	}	
}
