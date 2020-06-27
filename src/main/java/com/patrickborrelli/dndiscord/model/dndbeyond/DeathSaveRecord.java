package com.patrickborrelli.dndiscord.model.dndbeyond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for a death save record json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeathSaveRecord {
	private int failCount;
	private int successCount;
	private boolean isStabilized;
	
	public DeathSaveRecord() {
		
	}

	/**
	 * @return the failCount
	 */
	public int getFailCount() {
		return failCount;
	}

	/**
	 * @param failCount the failCount to set
	 */
	public void setFailCount(int failCount) {
		this.failCount = failCount;
	}

	/**
	 * @return the successCount
	 */
	public int getSuccessCount() {
		return successCount;
	}

	/**
	 * @param successCount the successCount to set
	 */
	public void setSuccessCount(int successCount) {
		this.successCount = successCount;
	}

	/**
	 * @return the isStabilized
	 */
	public boolean isStabilized() {
		return isStabilized;
	}

	/**
	 * @param isStabilized the isStabilized to set
	 */
	public void setStabilized(boolean isStabilized) {
		this.isStabilized = isStabilized;
	}

	@Override
	public String toString() {
		return "DeathSaveRecord [failCount=" + failCount + ", successCount=" + successCount + ", isStabilized="
				+ isStabilized + "]";
	}

}