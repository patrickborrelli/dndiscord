package com.patrickborrelli.dndiscord.utilities;

import java.util.HashMap;

/**
 * Enumerated type used to indicate type of item filter.
 * 
 * @author Patrick Borrelli
 */
public enum FilterType {
	
	ARMOR("Armor"),
	POTION("Potion"),
	RING("Ring"),
	ROD("Rod"),
	SCROLL("Scroll"),
	STAFF("Staff"),
	WAND("Wand"),
	WEAPON("Weapon"),
	WONDROUS("Wondrous"),
	OTHER_GEAR("Other gear")
	;
	
	private String value;
	private static HashMap<String, FilterType> valuesMap;
	
	static {
		valuesMap = 
			new HashMap<String, FilterType>(FilterType.values().length);
		valuesMap.put("Armor",  ARMOR);
		valuesMap.put("Potion",  POTION);
		valuesMap.put("Ring",  RING);
		valuesMap.put("Rod",  ROD);
		valuesMap.put("Scroll",  SCROLL);
		valuesMap.put("Staff",  STAFF);
		valuesMap.put("Wand",  WAND);
		valuesMap.put("Weapon",  WEAPON);
		valuesMap.put("Wondrous",  WONDROUS);
		valuesMap.put("Other",  OTHER_GEAR);
	}
	
	private FilterType(String theValue) {
		value = theValue;
	}
	
	/**
	 * Returns the value of the enumeration.
	 * 
	 * @return a String containing the value of the enumeration
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * Returns the enumeration for the provided String
	 * value for this enumeration
	 * 
	 * @param theValue the String value of this enumeration.
	 * @return an ArmorType containing the enumeration 
	 * 			represented by the provided String.
	 */
	public static FilterType getEnum(String theValue) {
		return valuesMap.get(theValue);
	}
	
	/**
	 * Overrides the default toString method provided by 
	 * {@link Object}
	 */
	@Override
	public String toString() {
		return value;
	}
}