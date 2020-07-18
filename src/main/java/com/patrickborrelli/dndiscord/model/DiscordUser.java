package com.patrickborrelli.dndiscord.model;

/**
 * Representational data encapsulating a
 * Discord user for identification and
 * storage of user specific data.
 *
 * @author Patrick Borrelli
 */
public class DiscordUser {
	private String id;
	private String username;
	private String discriminator;
	private String avatar;
	private boolean bot;
	private boolean system;
	private boolean mfaEnabled;
	private String locale;
	private boolean verified;
	private String email;
	private int flags;
	private int premiumType;
	private int publicFlags;
	
	//default constructor:
	public DiscordUser() {
		
	}

	/**
	 * @param id
	 * @param username
	 * @param discriminator
	 * @param avatar
	 * @param bot
	 * @param system
	 * @param mfaEnabled
	 * @param locale
	 * @param verified
	 * @param email
	 * @param flags
	 * @param premiumType
	 * @param publicFlags
	 */
	public DiscordUser(String id, String username, String discriminator, String avatar, boolean bot, boolean system,
			boolean mfaEnabled, String locale, boolean verified, String email, int flags, int premiumType,
			int publicFlags) {
		this.id = id;
		this.username = username;
		this.discriminator = discriminator;
		this.avatar = avatar;
		this.bot = bot;
		this.system = system;
		this.mfaEnabled = mfaEnabled;
		this.locale = locale;
		this.verified = verified;
		this.email = email;
		this.flags = flags;
		this.premiumType = premiumType;
		this.publicFlags = publicFlags;
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

	/**
	 * @return boolean the mfaEnabled
	 */
	public boolean isMfaEnabled() {
		return mfaEnabled;
	}

	/**
	 * @param boolean the mfaEnabled to set
	 */
	public void setMfaEnabled(boolean mfaEnabled) {
		this.mfaEnabled = mfaEnabled;
	}

	/**
	 * @return String the locale
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * @param String the locale to set
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}

	/**
	 * @return boolean the verified
	 */
	public boolean isVerified() {
		return verified;
	}

	/**
	 * @param boolean the verified to set
	 */
	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	/**
	 * @return String the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param String the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return int the flags
	 */
	public int getFlags() {
		return flags;
	}

	/**
	 * @param int the flags to set
	 */
	public void setFlags(int flags) {
		this.flags = flags;
	}

	/**
	 * @return int the premiumType
	 */
	public int getPremiumType() {
		return premiumType;
	}

	/**
	 * @param int the premiumType to set
	 */
	public void setPremiumType(int premiumType) {
		this.premiumType = premiumType;
	}

	/**
	 * @return int the publicFlags
	 */
	public int getPublicFlags() {
		return publicFlags;
	}

	/**
	 * @param int the publicFlags to set
	 */
	public void setPublicFlags(int publicFlags) {
		this.publicFlags = publicFlags;
	}

	@Override
	public String toString() {
		return "DiscordUser [id=" + id + ", username=" + username + ", discriminator=" + discriminator + ", avatar="
				+ avatar + ", bot=" + bot + ", system=" + system + ", mfaEnabled=" + mfaEnabled + ", locale=" + locale
				+ ", verified=" + verified + ", email=" + email + ", flags=" + flags + ", premiumType=" + premiumType
				+ ", publicFlags=" + publicFlags + "]";
	}
}
