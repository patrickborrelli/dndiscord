package com.patrickborrelli.dndiscord.model.dndbeyond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for a range json block, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Range {
	private String origin;
    private int rangeValue;
    private String aoeSize;
    private String aoeType;
    private int aoeValue;
    private boolean hasAoeSpecialDescription;
    private int range;
    private int longRange;
    
    public Range() {
    	
    }

	/**
	 * @return String the origin
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * @param String the origin to set
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	/**
	 * @return int the rangeValue
	 */
	public int getRangeValue() {
		return rangeValue;
	}

	/**
	 * @param int the rangeValue to set
	 */
	public void setRangeValue(int rangeValue) {
		this.rangeValue = rangeValue;
	}

	/**
	 * @return String the aoeSize
	 */
	public String getAoeSize() {
		return aoeSize;
	}

	/**
	 * @param String the aoeSize to set
	 */
	public void setAoeSize(String aoeSize) {
		this.aoeSize = aoeSize;
	}

	/**
	 * @return String the aoeType
	 */
	public String getAoeType() {
		return aoeType;
	}

	/**
	 * @param String the aoeType to set
	 */
	public void setAoeType(String aoeType) {
		this.aoeType = aoeType;
	}

	/**
	 * @return int the aoeValue
	 */
	public int getAoeValue() {
		return aoeValue;
	}

	/**
	 * @param int the aoeValue to set
	 */
	public void setAoeValue(int aoeValue) {
		this.aoeValue = aoeValue;
	}

	/**
	 * @return boolean the hasAoeSpecialDescription
	 */
	public boolean isHasAoeSpecialDescription() {
		return hasAoeSpecialDescription;
	}

	/**
	 * @param boolean the hasAoeSpecialDescription to set
	 */
	public void setHasAoeSpecialDescription(boolean hasAoeSpecialDescription) {
		this.hasAoeSpecialDescription = hasAoeSpecialDescription;
	}

	/**
	 * @return int the range
	 */
	public int getRange() {
		return range;
	}

	/**
	 * @param int the range to set
	 */
	public void setRange(int range) {
		this.range = range;
	}

	/**
	 * @return int the longRange
	 */
	public int getLongRange() {
		return longRange;
	}

	/**
	 * @param int the longRange to set
	 */
	public void setLongRange(int longRange) {
		this.longRange = longRange;
	}

	@Override
	public String toString() {
		return "Range [origin=" + origin + ", rangeValue=" + rangeValue + ", aoeSize=" + aoeSize + ", aoeType="
				+ aoeType + ", aoeValue=" + aoeValue + ", hasAoeSpecialDescription=" + hasAoeSpecialDescription
				+ ", range=" + range + ", longRange=" + longRange + "]";
	}    
}
