package com.patrickborrelli.dndiscord.utilities;

import java.util.HashMap;

public enum AlignmentType {
	
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
	private String stringValue;
	private static HashMap<Integer, AlignmentType> valuesMap;
	private static HashMap<String, AlignmentType> stringMap;
	
	static {
		valuesMap = 
			new HashMap<Integer, AlignmentType>(AlignmentType.values().length);
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
			new HashMap<String, AlignmentType>(AlignmentType.values().length);
		stringMap.put("Lawful good", LAWFUL_GOOD);
		stringMap.put("Neutral good", NEUTRAL_GOOD);
		stringMap.put("Chaotic good", CHAOTIC_GOOD);
		stringMap.put("Lawful neutral", LAWFUL_NEUTRAL);
		stringMap.put("Neutral", NEUTRAL);
		stringMap.put("Chaotic neutral", CHAOTIC_NEUTRAL);
		stringMap.put("Lawful evil", LAWFUL_EVIL);
		stringMap.put("Neutral evil", NEUTRAL_EVIL);
		stringMap.put("Chaotic evil", CHAOTIC_EVIL);
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
		return stringValue;
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