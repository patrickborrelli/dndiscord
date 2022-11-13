package com.patrickborrelli.dndiscord.model.dndbeyond;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Simple model for a modifier json element.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ModifierArray {
	
	private Modifier[] race;
	@JsonProperty("class")
	private Modifier[] class_mod;
	private Modifier[] background;
	private Modifier[] item;
	private Modifier[] feat;
	private Modifier[] condition;
	
	public ModifierArray() {
		
	}

	/**
	 * @return the race
	 */
	public Modifier[] getRace() {
		return race;
	}

	/**
	 * @param race the race to set
	 */
	public void setRace(Modifier[] race) {
		this.race = race;
	}

	/**
	 * @return the class_mod
	 */
	public Modifier[] getClass_mod() {
		return class_mod;
	}

	/**
	 * @param class_mod the class_mod to set
	 */
	public void setClass_mod(Modifier[] class_mod) {
		this.class_mod = class_mod;
	}

	/**
	 * @return the background
	 */
	public Modifier[] getBackground() {
		return background;
	}

	/**
	 * @param background the background to set
	 */
	public void setBackground(Modifier[] background) {
		this.background = background;
	}

	/**
	 * @return the item
	 */
	public Modifier[] getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(Modifier[] item) {
		this.item = item;
	}

	/**
	 * @return the feat
	 */
	public Modifier[] getFeat() {
		return feat;
	}

	/**
	 * @param feat the feat to set
	 */
	public void setFeat(Modifier[] feat) {
		this.feat = feat;
	}

	/**
	 * @return the condition
	 */
	public Modifier[] getCondition() {
		return condition;
	}

	/**
	 * @param condition the condition to set
	 */
	public void setCondition(Modifier[] condition) {
		this.condition = condition;
	}

	@Override
	public String toString() {
		return "ModifierArray [race=" + Arrays.toString(race) + ", class_mod=" + Arrays.toString(class_mod)
				+ ", background=" + Arrays.toString(background) + ", item=" + Arrays.toString(item) + ", feat="
				+ Arrays.toString(feat) + ", condition=" + Arrays.toString(condition) + "]";
	}
}
