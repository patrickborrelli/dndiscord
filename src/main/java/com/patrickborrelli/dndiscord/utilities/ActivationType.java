package com.patrickborrelli.dndiscord.utilities;

import java.util.HashMap;

/**
 * Enumerated type used to indicate feature activation.
 * 
 * @author Patrick Borrelli
 */
public enum ActivationType {
	ACTION(1),
	BONUS_ACTION(2),
	REACTION(3);
	
	
	private Integer value;
	private static HashMap<Integer, ActivationType> valuesMap;
	private static HashMap<ActivationType, String> stringMap;
	
	static {
		valuesMap = 
			new HashMap<Integer, ActivationType>(ActivationType.values().length);
		valuesMap.put(1, ACTION);
		valuesMap.put(2, BONUS_ACTION);
		valuesMap.put(3, REACTION);
		
		stringMap = 
			new HashMap<ActivationType, String>(ActivationType.values().length);
		stringMap.put(ACTION, "Action");
		stringMap.put(BONUS_ACTION, "Bonus action");
		stringMap.put(REACTION, "Reaction");
	}
	
	private ActivationType(Integer theValue) {
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
	 * @return an ActivationType containing the enumeration 
	 * 			represented by the provided String.
	 */
	public static ActivationType getEnum(Integer theValue) {
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
