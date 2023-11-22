package com.patrickborrelli.dndiscord.model.type;

import java.util.HashMap;

/**
 * Enumerated type used to indicate character lifestyle.
 * 
 * @author Patrick Borrelli
 */
public enum LifestyleType {
	WRETCHED(1),
	SQUALID(3),
	POOR(4),
	MODEST(5),
	COMFORTABLE(6),
	WEALTHY(7),
	ARISTOCRATIC(8);
	
	
	private Integer value;
	private static HashMap<Integer, LifestyleType> valuesMap;
	private static HashMap<LifestyleType, String> stringMap;
	
	static {
		valuesMap = 
			new HashMap<Integer, LifestyleType>(LifestyleType.values().length);
		valuesMap.put(1, WRETCHED);
		valuesMap.put(3, SQUALID);
		valuesMap.put(4, POOR);
		valuesMap.put(5, MODEST);
		valuesMap.put(6, COMFORTABLE);
		valuesMap.put(7, WEALTHY);
		valuesMap.put(8, ARISTOCRATIC);
		
		stringMap = 
			new HashMap<LifestyleType, String>(LifestyleType.values().length);
		stringMap.put(WRETCHED, "Wretched");
		stringMap.put(SQUALID, "Squalid");
		stringMap.put(POOR, "Poor");
		stringMap.put(MODEST, "Modest");
		stringMap.put(COMFORTABLE, "Comfortable");
		stringMap.put(WEALTHY, "Wealthy");
		stringMap.put(ARISTOCRATIC, "Aristocratic");
	}
	
	private LifestyleType(Integer theValue) {
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
	 * @return an LifestyleType containing the enumeration 
	 * 			represented by the provided String.
	 */
	public static LifestyleType getEnum(Integer theValue) {
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