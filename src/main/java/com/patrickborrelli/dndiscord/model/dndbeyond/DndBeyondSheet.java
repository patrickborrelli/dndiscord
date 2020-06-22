package com.patrickborrelli.dndiscord.model.dndbeyond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for a DNDBeyond Sheet json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DndBeyondSheet {
	private CharacterRecord character;
	
	public DndBeyondSheet() {
		
	}

	/**
	 * @return CharacterRecord the character
	 */
	public CharacterRecord getCharacter() {
		return character;
	}

	/**
	 * @param CharacterRecord the character to set
	 */
	public void setCharacter(CharacterRecord character) {
		this.character = character;
	}

	@Override
	public String toString() {
		return "DndBeyondSheet [character=" + character + "]";
	}
}
