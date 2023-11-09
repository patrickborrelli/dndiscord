package com.patrickborrelli.dndiscord.model.dndbeyond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for a DNDBeyond Speed.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Speed {
	private long movementId;
	private long distance;
	private String source;
	
	public Speed() {}

	/**
	 * Retrieves the movementId
	 *
	 * @return long the movementId
	 */
	public long getMovementId() {
		return movementId;
	}

	/**
	 * Set the movementId
	 *
	 * @param movementId long the movementId to set
	 */
	public void setMovementId(long movementId) {
		this.movementId = movementId;
	}

	/**
	 * Retrieves the distance
	 *
	 * @return long the distance
	 */
	public long getDistance() {
		return distance;
	}

	/**
	 * Set the distance
	 *
	 * @param distance long the distance to set
	 */
	public void setDistance(long distance) {
		this.distance = distance;
	}

	/**
	 * Retrieves the source
	 *
	 * @return String the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * Set the source
	 *
	 * @param source String the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	};
	
	
}
