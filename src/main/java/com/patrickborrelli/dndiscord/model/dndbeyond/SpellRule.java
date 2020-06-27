package com.patrickborrelli.dndiscord.model.dndbeyond;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for a spell rule json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SpellRule {
	private int multiClassSpellSlotDivisor;
	private int multiClassSpellSlotRounding;
	private boolean isRitualSpellCaster;
	private int[] levelCantripsKnownMaxes;
	private int[] levelSpellKnownMaxes;
	private int[][] levelSpellSlots;
	
	public SpellRule() {
		
	}

	/**
	 * @return the multiClassSpellSlotDivisor
	 */
	public int getMultiClassSpellSlotDivisor() {
		return multiClassSpellSlotDivisor;
	}

	/**
	 * @param multiClassSpellSlotDivisor the multiClassSpellSlotDivisor to set
	 */
	public void setMultiClassSpellSlotDivisor(int multiClassSpellSlotDivisor) {
		this.multiClassSpellSlotDivisor = multiClassSpellSlotDivisor;
	}

	/**
	 * @return the multiClassSpellSlotRounding
	 */
	public int getMultiClassSpellSlotRounding() {
		return multiClassSpellSlotRounding;
	}

	/**
	 * @param multiClassSpellSlotRounding the multiClassSpellSlotRounding to set
	 */
	public void setMultiClassSpellSlotRounding(int multiClassSpellSlotRounding) {
		this.multiClassSpellSlotRounding = multiClassSpellSlotRounding;
	}

	/**
	 * @return the isRitualSpellCaster
	 */
	public boolean isRitualSpellCaster() {
		return isRitualSpellCaster;
	}

	/**
	 * @param isRitualSpellCaster the isRitualSpellCaster to set
	 */
	public void setRitualSpellCaster(boolean isRitualSpellCaster) {
		this.isRitualSpellCaster = isRitualSpellCaster;
	}

	/**
	 * @return the levelCantripsKnownMaxes
	 */
	public int[] getLevelCantripsKnownMaxes() {
		return levelCantripsKnownMaxes;
	}

	/**
	 * @param levelCantripsKnownMaxes the levelCantripsKnownMaxes to set
	 */
	public void setLevelCantripsKnownMaxes(int[] levelCantripsKnownMaxes) {
		this.levelCantripsKnownMaxes = levelCantripsKnownMaxes;
	}

	/**
	 * @return the levelSpellKnownMaxes
	 */
	public int[] getLevelSpellKnownMaxes() {
		return levelSpellKnownMaxes;
	}

	/**
	 * @param levelSpellKnownMaxes the levelSpellKnownMaxes to set
	 */
	public void setLevelSpellKnownMaxes(int[] levelSpellKnownMaxes) {
		this.levelSpellKnownMaxes = levelSpellKnownMaxes;
	}

	/**
	 * @return the levelSpellSlots
	 */
	public int[][] getLevelSpellSlots() {
		return levelSpellSlots;
	}

	/**
	 * @param levelSpellSlots the levelSpellSlots to set
	 */
	public void setLevelSpellSlots(int[][] levelSpellSlots) {
		this.levelSpellSlots = levelSpellSlots;
	}

	@Override
	public String toString() {
		return "SpellRule [multiClassSpellSlotDivisor=" + multiClassSpellSlotDivisor + ", multiClassSpellSlotRounding="
				+ multiClassSpellSlotRounding + ", isRitualSpellCaster=" + isRitualSpellCaster
				+ ", levelCantripsKnownMaxes=" + Arrays.toString(levelCantripsKnownMaxes) + ", levelSpellKnownMaxes="
				+ Arrays.toString(levelSpellKnownMaxes) + ", levelSpellSlots=" + Arrays.toString(levelSpellSlots) + "]";
	}

}