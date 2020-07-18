package com.patrickborrelli.dndiscord.model.dndbeyond;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Simple model for a spellbook (spells) json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Spellbook {
	private Spell[] race;
	@JsonProperty("class")
	private Spell[] classbased;
	private Spell[] item;
	private Spell[] feat;
	
	public Spellbook() {
		
	}

	/**
	 * @return the race
	 */
	public Spell[] getRace() {
		return race;
	}

	/**
	 * @param race the race to set
	 */
	public void setRace(Spell[] race) {
		this.race = race;
	}

	/**
	 * @return the classbased
	 */
	public Spell[] getClassbased() {
		return classbased;
	}

	/**
	 * @param classbased the classbased to set
	 */
	public void setClassbased(Spell[] classbased) {
		this.classbased = classbased;
	}

	/**
	 * @return the item
	 */
	public Spell[] getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(Spell[] item) {
		this.item = item;
	}

	/**
	 * @return the feat
	 */
	public Spell[] getFeat() {
		return feat;
	}

	/**
	 * @param feat the feat to set
	 */
	public void setFeat(Spell[] feat) {
		this.feat = feat;
	}

	@Override
	public String toString() {
		return "Spellbook [race=" + Arrays.toString(race) + ", classbased=" + Arrays.toString(classbased) + ", item="
				+ Arrays.toString(item) + ", feat=" + Arrays.toString(feat) + "]";
	}

}
