package com.patrickborrelli.dndiscord.utilities;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumerated type used for armor classifications.
 * 
 * @author Patrick Borrelli
 */
public enum ActionType {
	WEAPON(1), SPELL(2), GENERAL(3);

	private Integer value;
	private static HashMap<Integer, ActionType> valuesMap;
	private static HashMap<ActionType, String> stringMap;

	static {
		valuesMap = new HashMap<Integer, ActionType>(ActionType.values().length);
		valuesMap.put(1, WEAPON);
		valuesMap.put(2, SPELL);
		valuesMap.put(3, GENERAL);

		stringMap = new HashMap<ActionType, String>(ActionType.values().length);
		stringMap.put(WEAPON, "Weapon");
		stringMap.put(SPELL, "Spell");
		stringMap.put(GENERAL, "General");
	}

	private ActionType(Integer theValue) {
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
	 * @return an ActionType containing the enumeration represented by the provided
	 *         String.
	 */
	public static ActionType getEnum(Integer theValue) {
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