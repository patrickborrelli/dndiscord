package com.patrickborrelli.dndiscord.utilities;

import java.util.HashMap;

/**
 * Enumerated type used for armor classifications.
 * 
 * @author Patrick Borrelli
 */
public enum CategoryType {
	SIMPLE(1),
	MARTIAL(2);	
	
	private Integer value;
	private static HashMap<Integer, CategoryType> valuesMap;
	private static HashMap<CategoryType, String> stringMap;
	
	static {
		valuesMap = 
			new HashMap<Integer, CategoryType>(CategoryType.values().length);
		valuesMap.put(1, SIMPLE);
		valuesMap.put(2, MARTIAL);
		
		stringMap = 
			new HashMap<CategoryType, String>(CategoryType.values().length);
		stringMap.put(SIMPLE, "Simple");
		stringMap.put(MARTIAL, "Martial");
	}
	
	private CategoryType(Integer theValue) {
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
	 * Returns the string value of the enumeration
	 * 
	 * @return a String containing the value of the enumeration
	 */
	public String getStringValue() {
		return stringMap.get(this);
	}
	
	/**
	 * Returns the enumeration for the provided String
	 * value for this enumeration
	 * 
	 * @param theValue the String value of this enumeration.
	 * @return an CategoryType containing the enumeration 
	 * 			represented by the provided String.
	 */
	public static CategoryType getEnum(Integer theValue) {
		return valuesMap.get(theValue);
	}
	
	/**
	 * Overrides the default toString method provided by 
	 * {@link Object}
	 */
	@Override
	public String toString() {
		return getStringValue();
	}
}