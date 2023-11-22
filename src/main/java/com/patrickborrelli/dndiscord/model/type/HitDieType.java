package com.patrickborrelli.dndiscord.model.type;

import java.util.HashMap;

/**
 * Enumerated type used to indicate type of hit die.
 * 
 * @author Patrick Borrelli
 */
public enum HitDieType {
	
	D4(4),
	D6(6),
	D8(8),
	D10(10),
	D12(12);
	
	
	private Integer value;
	private static HashMap<Integer, HitDieType> valuesMap;
	
	static {
		valuesMap = 
			new HashMap<Integer, HitDieType>(HitDieType.values().length);
		valuesMap.put(4, D4);
		valuesMap.put(6, D6);
		valuesMap.put(8, D8);
		valuesMap.put(10, D10);
		valuesMap.put(12, D12);
	}
	
	private HitDieType(Integer theValue) {
		value = theValue;
	}
	
	/**
	 * Returns the value of the enumeration.
	 * 
	 * @return an Integer containing the value of the enumeration
	 */
	public Integer getValue() {
		return value;
	}
	
	/**
	 * Returns the enumeration for the provided Integer
	 * value for this enumeration
	 * 
	 * @param theValue the String value of this enumeration.
	 * @return an ArmorType containing the enumeration 
	 * 			represented by the provided String.
	 */
	public static HitDieType getEnum(Integer theValue) {
		return valuesMap.get(theValue);
	}
	
	/**
	 * Overrides the default toString method provided by 
	 * {@link Object}
	 */
	@Override
	public String toString() {
		return value.toString();
	}
}