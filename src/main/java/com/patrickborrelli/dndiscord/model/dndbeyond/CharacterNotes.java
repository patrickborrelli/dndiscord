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

	/**
	 * @return String the allies
	 */
	public String getAllies() {
		return allies;
	}

	/**
	 * @param String the allies to set
	 */
	public void setAllies(String allies) {
		this.allies = allies;
	}

	/**
	 * @return String the personalPossessions
	 */
	public String getPersonalPossessions() {
		return personalPossessions;
	}

	/**
	 * @param String the personalPossessions to set
	 */
	public void setPersonalPossessions(String personalPossessions) {
		this.personalPossessions = personalPossessions;
	}

	/**
	 * @return String the otherHoldings
	 */
	public String getOtherHoldings() {
		return otherHoldings;
	}

	/**
	 * @param String the otherHoldings to set
	 */
	public void setOtherHoldings(String otherHoldings) {
		this.otherHoldings = otherHoldings;
	}

	/**
	 * @return String the organizations
	 */
	public String getOrganizations() {
		return organizations;
	}

	/**
	 * @param String the organizations to set
	 */
	public void setOrganizations(String organizations) {
		this.organizations = organizations;
	}

	/**
	 * @return String the enemies
	 */
	public String getEnemies() {
		return enemies;
	}

	/**
	 * @param String the enemies to set
	 */
	public void setEnemies(String enemies) {
		this.enemies = enemies;
	}

	/**
	 * @return String the backstory
	 */
	public String getBackstory() {
		return backstory;
	}

	/**
	 * @param String the backstory to set
	 */
	public void setBackstory(String backstory) {
		this.backstory = backstory;
	}

	/**
	 * @return String the otherNotes
	 */
	public String getOtherNotes() {
		return otherNotes;
	}

	/**
	 * @param String the otherNotes to set
	 */
	public void setOtherNotes(String otherNotes) {
		this.otherNotes = otherNotes;
	}

	@Override
	public String toString() {
		return "CharacterNotes [allies=" + allies + ", personalPossessions=" + personalPossessions + ", otherHoldings="
				+ otherHoldings + ", organizations=" + organizations + ", enemies=" + enemies + ", backstory="
				+ backstory + ", otherNotes=" + otherNotes + "]";
	}
	
}
