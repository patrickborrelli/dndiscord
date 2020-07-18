package com.patrickborrelli.dndiscord.model.dndbeyond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Simple model for a currencies json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Coinpurse {
	@JsonProperty("cp")
	private int copperPieces;
	@JsonProperty("sp")
	private int silverPieces;
	@JsonProperty("ep")
	private int electrumPieces;
	@JsonProperty("gp")
	private int goldPieces;
	@JsonProperty("pp")
	private int platinumPieces;
	
	public Coinpurse() {
		
	}

	/**
	 * @return the copperPieces
	 */
	public int getCopperPieces() {
		return copperPieces;
	}

	/**
	 * @param copperPieces the copperPieces to set
	 */
	public void setCopperPieces(int copperPieces) {
		this.copperPieces = copperPieces;
	}

	/**
	 * @return the silverPieces
	 */
	public int getSilverPieces() {
		return silverPieces;
	}

	/**
	 * @param silverPieces the silverPieces to set
	 */
	public void setSilverPieces(int silverPieces) {
		this.silverPieces = silverPieces;
	}

	/**
	 * @return the electrumPieces
	 */
	public int getElectrumPieces() {
		return electrumPieces;
	}

	/**
	 * @param electrumPieces the electrumPieces to set
	 */
	public void setElectrumPieces(int electrumPieces) {
		this.electrumPieces = electrumPieces;
	}

	/**
	 * @return the goldPieces
	 */
	public int getGoldPieces() {
		return goldPieces;
	}

	/**
	 * @param goldPieces the goldPieces to set
	 */
	public void setGoldPieces(int goldPieces) {
		this.goldPieces = goldPieces;
	}

	/**
	 * @return the platinumPieces
	 */
	public int getPlatinumPieces() {
		return platinumPieces;
	}

	/**
	 * @param platinumPieces the platinumPieces to set
	 */
	public void setPlatinumPieces(int platinumPieces) {
		this.platinumPieces = platinumPieces;
	}

	@Override
	public String toString() {
		return "Coinpurse [copperPieces=" + copperPieces + ", silverPieces=" + silverPieces + ", electrumPieces="
				+ electrumPieces + ", goldPieces=" + goldPieces + ", platinumPieces=" + platinumPieces + "]";
	}
	
}
