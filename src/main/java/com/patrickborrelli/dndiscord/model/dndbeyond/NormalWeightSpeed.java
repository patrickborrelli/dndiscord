package com.patrickborrelli.dndiscord.model.dndbeyond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for a normal weight speed json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NormalWeightSpeed {
	private int walk;
	private int fly;
	private int burrow;
	private int swim;
	private int climb;
	
	public NormalWeightSpeed() {
		
	}

	/**
	 * @return the walk
	 */
	public int getWalk() {
		return walk;
	}

	/**
	 * @param walk the walk to set
	 */
	public void setWalk(int walk) {
		this.walk = walk;
	}

	/**
	 * @return the fly
	 */
	public int getFly() {
		return fly;
	}

	/**
	 * @param fly the fly to set
	 */
	public void setFly(int fly) {
		this.fly = fly;
	}

	/**
	 * @return the burrow
	 */
	public int getBurrow() {
		return burrow;
	}

	/**
	 * @param burrow the burrow to set
	 */
	public void setBurrow(int burrow) {
		this.burrow = burrow;
	}

	/**
	 * @return the swim
	 */
	public int getSwim() {
		return swim;
	}

	/**
	 * @param swim the swim to set
	 */
	public void setSwim(int swim) {
		this.swim = swim;
	}

	/**
	 * @return the climb
	 */
	public int getClimb() {
		return climb;
	}

	/**
	 * @param climb the climb to set
	 */
	public void setClimb(int climb) {
		this.climb = climb;
	}

	@Override
	public String toString() {
		return "NormalWeightSpeed [walk=" + walk + ", fly=" + fly + ", burrow=" + burrow + ", swim=" + swim + ", climb="
				+ climb + "]";
	}
}