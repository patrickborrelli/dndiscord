package com.patrickborrelli.dndiscord.model.dndbeyond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for a spell level json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SpellLevel {
	protected int level;
	protected int used;
	protected int available;
	
	public SpellLevel() {
		
	}

	/**
	 * @return int the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param int the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * @return int the used
	 */
	public int getUsed() {
		return used;
	}

	/**
	 * @param int the used to set
	 */
	public void setUsed(int used) {
		this.used = used;
	}

	/**
	 * @return int the available
	 */
	public int getAvailable() {
		return available;
	}

	/**
	 * @param int the available to set
	 */
	public void setAvailable(int available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "SpellLevel [level=" + level + ", used=" + used + ", available=" + available + "]";
	}
}
