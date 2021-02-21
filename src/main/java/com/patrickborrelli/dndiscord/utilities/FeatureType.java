package com.patrickborrelli.dndiscord.utilities;

import java.util.HashMap;

/**
 * Enumerated type used to indicate character sheet source.
 * 
 * @author Patrick Borrelli
 */
public enum FeatureType {
	
	CLASS_TYPE("Class"),
	RACE("Race"),
	SUBCLASS("Subclass"),
	BACKGROUND("Background"),
	FEAT("Feat");	
	
	private String value;
	private static HashMap<String, FeatureType> valuesMap;
	
	static {
		valuesMap = 
			new HashMap<String, FeatureType>(FeatureType.values().length);
		valuesMap.put("class", CLASS_TYPE);
		valuesMap.put("race", RACE);
		valuesMap.put("subclass", SUBCLASS);
		valuesMap.put("background", BACKGROUND);
		valuesMap.put("feat", FEAT);
	}
	
	private FeatureType(String theValue) {
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
	public static FeatureType getEnum(String theValue) {
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