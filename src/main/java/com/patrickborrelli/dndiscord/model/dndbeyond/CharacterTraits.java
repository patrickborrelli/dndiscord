package com.patrickborrelli.dndiscord.model.dndbeyond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for character traits json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterTraits {

	private String personalityTraits;
	private String ideals;
	private String bonds;
	private String flaws;
	private String appearance;
	
	public CharacterTraits() {
		
	}

	/**
	 * @return the personalityTraits
	 */
	public String getPersonalityTraits() {
		return personalityTraits;
	}

	/**
	 * @param personalityTraits the personalityTraits to set
	 */
	public void setPersonalityTraits(String personalityTraits) {
		this.personalityTraits = personalityTraits;
	}

	/**
	 * @return the ideals
	 */
	public String getIdeals() {
		return ideals;
	}

	/**
	 * @param ideals the ideals to set
	 */
	public void setIdeals(String ideals) {
		this.ideals = ideals;
	}

	/**
	 * @return the bonds
	 */
	public String getBonds() {
		return bonds;
	}

	/**
	 * @param bonds the bonds to set
	 */
	public void setBonds(String bonds) {
		this.bonds = bonds;
	}

	/**
	 * @return the flaws
	 */
	public String getFlaws() {
		return flaws;
	}

	/**
	 * @param flaws the flaws to set
	 */
	public void setFlaws(String flaws) {
		this.flaws = flaws;
	}

	/**
	 * @return the appearance
	 */
	public String getAppearance() {
		return appearance;
	}

	/**
	 * @param appearance the appearance to set
	 */
	public void setAppearance(String appearance) {
		this.appearance = appearance;
	}

	@Override
	public String toString() {
		return "CharacterTraits [personalityTraits=" + personalityTraits + ", ideals="
				+ ideals + ", bonds=" + bonds + ", flaws=" + flaws
				+ ", appearance=" + appearance + "]";
	}

}