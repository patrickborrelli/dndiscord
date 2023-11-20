package com.patrickborrelli.dndiscord.utilities;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumerated type used for character stats.
 * 
 * @author Patrick Borrelli
 */
public enum StatType {
	STRENGTH(1), DEXTERITY(2), CONSTITUTION(3), INTELLIGENCE(4), WISDOM(5), CHARISMA(6);

	private Integer value;
	private static HashMap<Integer, StatType> valuesMap;
	private static HashMap<StatType, String> stringMap;

	static {
		valuesMap = new HashMap<Integer, StatType>(StatType.values().length);
		valuesMap.put(1, STRENGTH);
		valuesMap.put(2, DEXTERITY);
		valuesMap.put(3, CONSTITUTION);
		valuesMap.put(4, INTELLIGENCE);
		valuesMap.put(5, WISDOM);
		valuesMap.put(6, CHARISMA);

		stringMap = new HashMap<StatType, String>(StatType.values().length);
		stringMap.put(STRENGTH, "Strength");
		stringMap.put(DEXTERITY, "Dexterity");
		stringMap.put(CONSTITUTION, "Constitution");
		stringMap.put(INTELLIGENCE, "Intelligence");
		stringMap.put(WISDOM, "Wisdom");
		stringMap.put(CHARISMA, "Charisma");
	}

	private StatType(Integer theValue) {
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
	 * @return an StatType containing the enumeration represented by the provided
	 *         String.
	 */
	public static StatType getEnum(Integer theValue) {
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