package com.patrickborrelli.dndiscord.model.type;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumerated type used for armor classifications.
 * 
 * @author Patrick Borrelli
 */
public enum AttackType {
	MELEE(1), RANGED(2);

	private Integer value;
	private static HashMap<Integer, AttackType> valuesMap;
	private static HashMap<AttackType, String> stringMap;

	static {
		valuesMap = new HashMap<Integer, AttackType>(AttackType.values().length);
		valuesMap.put(1, MELEE);
		valuesMap.put(2, RANGED);

		stringMap = new HashMap<AttackType, String>(AttackType.values().length);
		stringMap.put(MELEE, "Melee");
		stringMap.put(RANGED, "Ranged");
	}

	private AttackType(Integer theValue) {
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
	 * @return an AttackType containing the enumeration represented by the provided
	 *         String.
	 */
	public static AttackType getEnum(Integer theValue) {
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