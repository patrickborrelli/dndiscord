package com.patrickborrelli.dndiscord.model.dndbeyond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for character notes json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterNotes {

	private String allies;
	private String personalPossessions;
	private String otherHoldings;
	private String organizations;
	private String enemies;
	private String backstory;
	private String otherNotes;
	
	public CharacterNotes() {
		
	}

	@Override
	public String toString() {
		return "CharacterNotes [allies=" + allies + ", personalPossessions=" + personalPossessions + ", otherHoldings="
				+ otherHoldings + ", organizations=" + organizations + ", enemies=" + enemies + ", backstory="
				+ backstory + ", otherNotes=" + otherNotes + "]";
	}

	/**
	 * @return the allies
	 */
	public String getAllies() {
		return allies;
	}

	/**
	 * @param allies the allies to set
	 */
	public void setAllies(String allies) {
		this.allies = allies;
	}

	/**
	 * @return the personalPossessions
	 */
	public String getPersonalPossessions() {
		return personalPossessions;
	}

	/**
	 * @param personalPossessions the personalPossessions to set
	 */
	public void setPersonalPossessions(String personalPossessions) {
		this.personalPossessions = personalPossessions;
	}

	/**
	 * @return the otherHoldings
	 */
	public String getOtherHoldings() {
		return otherHoldings;
	}

	/**
	 * @param otherHoldings the otherHoldings to set
	 */
	public void setOtherHoldings(String otherHoldings) {
		this.otherHoldings = otherHoldings;
	}

	/**
	 * @return the organizations
	 */
	public String getOrganizations() {
		return organizations;
	}

	/**
	 * @param organizations the organizations to set
	 */
	public void setOrganizations(String organizations) {
		this.organizations = organizations;
	}

	/**
	 * @return the enemies
	 */
	public String getEnemies() {
		return enemies;
	}

	/**
	 * @param enemies the enemies to set
	 */
	public void setEnemies(String enemies) {
		this.enemies = enemies;
	}

	/**
	 * @return the backstory
	 */
	public String getBackstory() {
		return backstory;
	}

	/**
	 * @param backstory the backstory to set
	 */
	public void setBackstory(String backstory) {
		this.backstory = backstory;
	}

	/**
	 * @return the otherNotes
	 */
	public String getOtherNotes() {
		return otherNotes;
	}

	/**
	 * @param otherNotes the otherNotes to set
	 */
	public void setOtherNotes(String otherNotes) {
		this.otherNotes = otherNotes;
	}
}
