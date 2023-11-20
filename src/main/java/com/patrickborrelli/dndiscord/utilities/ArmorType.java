package com.patrickborrelli.dndiscord.utilities;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumerated type used for armor classifications.
 * 
 * @author Patrick Borrelli
 */
public enum ArmorType {
	LIGHT(1), MEDIUM(2), HEAVY(3), SHIELD(4);

	private Integer value;
	private static HashMap<Integer, ArmorType> valuesMap;
	private static HashMap<ArmorType, String> stringMap;

	static {
		valuesMap = new HashMap<Integer, ArmorType>(ArmorType.values().length);
		valuesMap.put(1, LIGHT);
		valuesMap.put(2, MEDIUM);
		valuesMap.put(3, HEAVY);
		valuesMap.put(4, SHIELD);

		stringMap = new HashMap<ArmorType, String>(ArmorType.values().length);
		stringMap.put(LIGHT, "Light");
		stringMap.put(MEDIUM, "Medium");
		stringMap.put(HEAVY, "Heavy");
		stringMap.put(SHIELD, "Shield");
	}

	private ArmorType(Integer theValue) {
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
	@JsonValue
	public String getStringValue() {
		return stringMap.get(this);
	}

	/**
	 * Returns the enumeration for the provided String value for this enumeration
	 * 
	 * @param theValue the String value of this enumeration.
	 * @return an ArmorType containing the enumeration represented by the provided
	 *         String.
	 */
	public static ArmorType getEnum(Integer theValue) {
		return valuesMap.get(theValue);
	}

	/**
	 * Overrides the default toString method provided by {@link Object}
	 */
	@Override
	public String toString() {
		return getStringValue();
	}
}