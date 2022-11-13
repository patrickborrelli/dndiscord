package com.patrickborrelli.dndiscord.utilities;

import java.util.HashMap;

/**
 * Enumerated type used to indicate feature activation.
 * 
 * @author Patrick Borrelli
 */
public enum ActivationType {
	ACTION(1),
	NO_ACTION(2),
	BONUS_ACTION(3),
	REACTION(4),
	MINUTE(6),
	HOUR(7),
	SPECIAL(8)
	;
	
	
	private Integer value;
	private static HashMap<Integer, ActivationType> valuesMap;
	private static HashMap<ActivationType, String> stringMap;
	private static HashMap<String, ActivationType> inverseMap;
	
	static {
		valuesMap = 
			new HashMap<Integer, ActivationType>(ActivationType.values().length);
		valuesMap.put(1, ACTION);
		valuesMap.put(2, NO_ACTION);
		valuesMap.put(3, BONUS_ACTION);
		valuesMap.put(4, REACTION);
		valuesMap.put(6, MINUTE);
		valuesMap.put(7, HOUR);
		valuesMap.put(8, SPECIAL);
		
		stringMap = 
			new HashMap<ActivationType, String>(ActivationType.values().length);
		stringMap.put(ACTION, "Action");
		stringMap.put(NO_ACTION, "No action");
		stringMap.put(BONUS_ACTION, "Bonus action");
		stringMap.put(REACTION, "Reaction");
		stringMap.put(MINUTE, "Minute");
		stringMap.put(HOUR, "Hour");
		stringMap.put(SPECIAL, "Special");
		
		inverseMap = 
				new HashMap<String, ActivationType>(ActivationType.values().length);
		inverseMap.put("Action", ACTION);
		inverseMap.put("No action", NO_ACTION);
		inverseMap.put("Bonus action", BONUS_ACTION);
		inverseMap.put("Reaction", REACTION);
		inverseMap.put("Minute", MINUTE);
		inverseMap.put("Hour", HOUR);
		inverseMap.put("Special", SPECIAL);
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
	 * Returns the enumeration for the provided Integer
	 * value for this enumeration
	 * 
	 * @param theValue the Integer value of this enumeration.
	 * @return an ActivationType containing the enumeration 
	 * 			represented by the provided String.
	 */
	public static ActivationType getEnum(Integer theValue) {
		return valuesMap.get(theValue);
	}
	
	/**
	 * Returns the enumeration for the provided String
	 * value for this enumeration
	 * 
	 * @param theValue the String value of this enumeration.
	 * @return an ActivationType containing the enumeration 
	 * 			represented by the provided String.
	 */
	public static ActivationType getEnum(String theValue) {
		return inverseMap.get(theValue);
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
