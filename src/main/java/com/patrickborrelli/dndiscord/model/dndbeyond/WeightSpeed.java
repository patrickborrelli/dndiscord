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