package com.patrickborrelli.dndiscord.model.dndbeyond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for a weight speed json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeightSpeed {
	private NormalWeightSpeed normal;
	private int encumbered;
	private int heavilyEncumbered;
	private int pushDragLift;
	private int override;
	
	public WeightSpeed() {
		
	}	

	/**
	 * @return the normal
	 */
	public NormalWeightSpeed getNormal() {
		return normal;
	}

	/**
	 * @param normal the normal to set
	 */
	public void setNormal(NormalWeightSpeed normal) {
		this.normal = normal;
	}

	/**
	 * @return the encumbered
	 */
	public int getEncumbered() {
		return encumbered;
	}

	/**
	 * @param encumbered the encumbered to set
	 */
	public void setEncumbered(int encumbered) {
		this.encumbered = encumbered;
	}

	/**
	 * @return the heavilyEncumbered
	 */
	public int getHeavilyEncumbered() {
		return heavilyEncumbered;
	}

	/**
	 * @param heavilyEncumbered the heavilyEncumbered to set
	 */
	public void setHeavilyEncumbered(int heavilyEncumbered) {
		this.heavilyEncumbered = heavilyEncumbered;
	}

	/**
	 * @return the pushDragLift
	 */
	public int getPushDragLift() {
		return pushDragLift;
	}

	/**
	 * @param pushDragLift the pushDragLift to set
	 */
	public void setPushDragLift(int pushDragLift) {
		this.pushDragLift = pushDragLift;
	}

	/**
	 * @return the override
	 */
	public int getOverride() {
		return override;
	}

	/**
	 * @param override the override to set
	 */
	public void setOverride(int override) {
		this.override = override;
	}
	
	@Override
	public String toString() {
		return "WeightSpeed [normal=" + normal + ", encumbered=" + encumbered + ", heavilyEncumbered="
				+ heavilyEncumbered + ", pushDragLift=" + pushDragLift + ", override=" + override + "]";
	}
}

class NormalWeightSpeed {
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