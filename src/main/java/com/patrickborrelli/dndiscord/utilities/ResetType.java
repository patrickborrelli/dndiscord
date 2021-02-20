package com.patrickborrelli.dndiscord.utilities;

import java.util.HashMap;

/**
 * Enumerated type used to indicate feature activation.
 * 
 * @author Patrick Borrelli
 */
public enum ResetType {
	SHORT_REST(1),
	LONG_REST(2);
	
	
	private Integer value;
	private static HashMap<Integer, ResetType> valuesMap;
	private static HashMap<ResetType, String> stringMap;
	
	static {
		valuesMap = 
			new HashMap<Integer, ResetType>(ResetType.values().length);
		valuesMap.put(1, SHORT_REST);
		valuesMap.put(2, LONG_REST);
		
		stringMap = 
			new HashMap<ResetType, String>(ResetType.values().length);
		stringMap.put(SHORT_REST, "Short rest");
		stringMap.put(LONG_REST, "Long rest");
	}
	
	private ResetType(Integer theValue) {
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
	 * @return an ResetType containing the enumeration 
	 * 			represented by the provided String.
	 */
	public static ResetType getEnum(Integer theValue) {
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
