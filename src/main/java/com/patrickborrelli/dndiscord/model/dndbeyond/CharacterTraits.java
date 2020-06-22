package com.patrickborrelli.dndiscord.model.dndbeyond;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for character traits json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterTraits {

	private String[] personalityTraits;
	private String[] ideals;
	private String[] bonds;
	private String[] flaws;
	private String appearance;
	
	public CharacterTraits() {
		
	}

	/**
	 * @return String[] the personalityTraits
	 */
	public String[] getPersonalityTraits() {
		return personalityTraits;
	}

	/**
	 * @param String[] the personalityTraits to set
	 */
	public void setPersonalityTraits(String[] personalityTraits) {
		this.personalityTraits = personalityTraits;
	}

	/**
	 * @return String[] the ideals
	 */
	public String[] getIdeals() {
		return ideals;
	}

	/**
	 * @param String[] the ideals to set
	 */
	public void setIdeals(String[] ideals) {
		this.ideals = ideals;
	}

	/**
	 * @return String[] the bonds
	 */
	public String[] getBonds() {
		return bonds;
	}

	/**
	 * @param String[] the bonds to set
	 */
	public void setBonds(String[] bonds) {
		this.bonds = bonds;
	}

	/**
	 * @return String[] the flaws
	 */
	public String[] getFlaws() {
		return flaws;
	}

	/**
	 * @param String[] the flaws to set
	 */
	public void setFlaws(String[] flaws) {
		this.flaws = flaws;
	}

	/**
	 * @return String the appearance
	 */
	public String getAppearance() {
		return appearance;
	}

	/**
	 * @param String the appearance to set
	 */
	public void setAppearance(String appearance) {
		this.appearance = appearance;
	}

	@Override
	public String toString() {
		return "CharacterTraits [personalityTraits=" + Arrays.toString(personalityTraits) + ", ideals="
				+ Arrays.toString(ideals) + ", bonds=" + Arrays.toString(bonds) + ", flaws=" + Arrays.toString(flaws)
				+ ", appearance=" + appearance + "]";
	}
	
}
