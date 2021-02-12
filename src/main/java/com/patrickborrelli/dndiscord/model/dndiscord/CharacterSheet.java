package com.patrickborrelli.dndiscord.model.dndiscord;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.patrickborrelli.dndiscord.model.DiscordUser;

/**
 * Model of dDnDiscord Character Sheet entry.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterSheet {
	
	private String sheetSource;
	private DiscordUser user;
	private String characterName;
	private String avatarUrl;
	
	public CharacterSheet() {
		
	}

	/**
	 * @return String the sheetSource
	 */
	public String getSheetSource() {
		return sheetSource;
	}

	/**
	 * @param String the sheetSource to set
	 */
	public void setSheetSource(String sheetSource) {
		this.sheetSource = sheetSource;
	}

	/**
	 * @return DiscordUser the user
	 */
	public DiscordUser getUser() {
		return user;
	}

	/**
	 * @param DiscordUser the user to set
	 */
	public void setUser(DiscordUser user) {
		this.user = user;
	}

	/**
	 * @return String the characterName
	 */
	public String getCharacterName() {
		return characterName;
	}

	/**
	 * @param String the characterName to set
	 */
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	/**
	 * @return String the avatarUrl
	 */
	public String getAvatarUrl() {
		return avatarUrl;
	}

	/**
	 * @param String the avatarUrl to set
	 */
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avatarUrl == null) ? 0 : avatarUrl.hashCode());
		result = prime * result + ((characterName == null) ? 0 : characterName.hashCode());
		result = prime * result + ((sheetSource == null) ? 0 : sheetSource.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		CharacterSheet other = (CharacterSheet) obj;
		if (avatarUrl == null) {
			if (other.avatarUrl != null)
				return false;
		} else if (!avatarUrl.equals(other.avatarUrl))
			return false;
		if (characterName == null) {
			if (other.characterName != null)
				return false;
		} else if (!characterName.equals(other.characterName))
			return false;
		if (sheetSource == null) {
			if (other.sheetSource != null)
				return false;
		} else if (!sheetSource.equals(other.sheetSource))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CharacterSheet [sheetSource=" + sheetSource + ", user=" + user + ", characterName=" + characterName
				+ ", avatarUrl=" + avatarUrl + "]";
	}
}
