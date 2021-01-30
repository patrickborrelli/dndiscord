package com.patrickborrelli.dndiscord.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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
	private String avatar;
	private boolean bot;
	private boolean system;
	
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

	/**
	 * @return boolean the system
	 */
	public boolean isSystem() {
		return system;
	}

	/**
	 * @param boolean the system to set
	 */
	public void setSystem(boolean system) {
		this.system = system;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avatar == null) ? 0 : avatar.hashCode());
		result = prime * result + (bot ? 1231 : 1237);
		result = prime * result + ((discord_id == null) ? 0 : discord_id.hashCode());
		result = prime * result + ((discriminator == null) ? 0 : discriminator.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (system ? 1231 : 1237);
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DiscordUser other = (DiscordUser) obj;
		if (avatar == null) {
			if (other.avatar != null)
				return false;
		} else if (!avatar.equals(other.avatar))
			return false;
		if (bot != other.bot)
			return false;
		if (discord_id == null) {
			if (other.discord_id != null)
				return false;
		} else if (!discord_id.equals(other.discord_id))
			return false;
		if (discriminator == null) {
			if (other.discriminator != null)
				return false;
		} else if (!discriminator.equals(other.discriminator))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (system != other.system)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DiscordUser [id=" + id + ", discord_id=" + discord_id + ", username=" + username + ", discriminator="
				+ discriminator + ", avatar=" + avatar + ", bot=" + bot + ", system=" + system + "]";
	}
}
