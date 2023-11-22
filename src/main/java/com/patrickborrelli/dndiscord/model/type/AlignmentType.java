package com.patrickborrelli.dndiscord.model.type;

import java.util.HashMap;

/**
 * Enumerated type used to indicate character alignment.
 * 
 * @author Patrick Borrelli
 */
public enum AlignmentType {
	
	UNKNOWN(0),
	LAWFUL_GOOD(1),
	NEUTRAL_GOOD(2),
	CHAOTIC_GOOD(3),
	LAWFUL_NEUTRAL(4),
	NEUTRAL(5),
	CHAOTIC_NEUTRAL(6),
	LAWFUL_EVIL(7),
	NEUTRAL_EVIL(8),
	CHAOTIC_EVIL(9);
	
	
	private Integer value;
	private static HashMap<Integer, AlignmentType> valuesMap;
	private static HashMap<AlignmentType, String> stringMap;
	
	static {
		valuesMap = 
			new HashMap<Integer, AlignmentType>(AlignmentType.values().length);
		valuesMap.put(0,  UNKNOWN);
		valuesMap.put(1, LAWFUL_GOOD);
		valuesMap.put(2, NEUTRAL_GOOD);
		valuesMap.put(3, CHAOTIC_GOOD);
		valuesMap.put(4, LAWFUL_NEUTRAL);
		valuesMap.put(5, NEUTRAL);
		valuesMap.put(6, CHAOTIC_NEUTRAL);
		valuesMap.put(7, LAWFUL_EVIL);
		valuesMap.put(8, NEUTRAL_EVIL);
		valuesMap.put(9, CHAOTIC_EVIL);
		
		stringMap = 
			new HashMap<AlignmentType, String>(AlignmentType.values().length);
		stringMap.put(UNKNOWN, "Unknown");
		stringMap.put(LAWFUL_GOOD, "Lawful good");
		stringMap.put(NEUTRAL_GOOD, "Neutral good");
		stringMap.put(CHAOTIC_GOOD, "Chaotic good");
		stringMap.put(LAWFUL_NEUTRAL, "Lawful neutral");
		stringMap.put(NEUTRAL, "Neutral");
		stringMap.put(CHAOTIC_NEUTRAL, "Chaotic neutral");
		stringMap.put(LAWFUL_EVIL, "Lawful evil");
		stringMap.put(NEUTRAL_EVIL, "Neutral evil");
		stringMap.put(CHAOTIC_EVIL, "Chaotic evil");
	}
	
	private AlignmentType(Integer theValue) {
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
	 * @return an AlignmentType containing the enumeration 
	 * 			represented by the provided String.
	 */
	public static AlignmentType getEnum(Integer theValue) {
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