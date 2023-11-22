package com.patrickborrelli.dndiscord.model.type;

import java.util.HashMap;

/**
 * Enumerated type used to indicate character sheet source.
 * 
 * @author Patrick Borrelli
 */
public enum SheetSourceType {
	
	BEYOND("BEYOND"),
	DNDISCORD("DNDISCORD");
	
	private String value;
	private static HashMap<String, SheetSourceType> valuesMap;
	
	static {
		valuesMap = 
			new HashMap<String, SheetSourceType>(SheetSourceType.values().length);
		valuesMap.put("BEYOND", BEYOND);
		valuesMap.put("DNDISCORD", DNDISCORD);
	}
	
	private SheetSourceType(String theValue) {
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
	public static SheetSourceType getEnum(String theValue) {
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