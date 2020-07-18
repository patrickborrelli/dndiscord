package com.patrickborrelli.dndiscord.model.dndbeyond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for an activation json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Activation {
	private String activationTime;
	private String activationType;
	
	public Activation() {
		
	}

	/**
	 * @return String the activationTime
	 */
	public String getActivationTime() {
		return activationTime;
	}

	/**
	 * @param activationTime - String the activationTime to set
	 */
	public void setActivationTime(String activationTime) {
		this.activationTime = activationTime;
	}

	/**
	 * @return String the activationType
	 */
	public String getActivationType() {
		return activationType;
	}

	/**
	 * @param activationType - String the activationType to set
	 */
	public void setActivationType(String activationType) {
		this.activationType = activationType;
	}

	@Override
	public String toString() {
		return "Activation [activationTime=" + activationTime + ", activationType=" + activationType + "]";
	}	
}

