package com.patrickborrelli.dndiscord.model.type;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumerated type used for weapon property classifications.
 * 
 * @author Patrick Borrelli
 */
public enum WeaponPropertyType {
	AMMUNITION(1), FINESSE(2), HEAVY(3), LIGHT(4), LOADING(5), RANGE(7), REACH(8), SPECIAL(9), THROWN(10),
	TWO_HANDED(11), VERSATILE(12);

	private Integer value;
	private static HashMap<Integer, WeaponPropertyType> valuesMap;
	private static HashMap<WeaponPropertyType, String> stringMap;

	static {
		valuesMap = new HashMap<Integer, WeaponPropertyType>(WeaponPropertyType.values().length);
		valuesMap.put(1, AMMUNITION);
		valuesMap.put(2, FINESSE);
		valuesMap.put(3, HEAVY);
		valuesMap.put(4, LIGHT);
		valuesMap.put(5, LOADING);
		valuesMap.put(7, RANGE);
		valuesMap.put(8, REACH);
		valuesMap.put(9, SPECIAL);
		valuesMap.put(10, THROWN);
		valuesMap.put(11, TWO_HANDED);
		valuesMap.put(12, VERSATILE);

		stringMap = new HashMap<WeaponPropertyType, String>(WeaponPropertyType.values().length);
		stringMap.put(AMMUNITION, "Ammunition");
		stringMap.put(FINESSE, "Finesse");
		stringMap.put(HEAVY, "Heavy");
		stringMap.put(LIGHT, "Light");
		stringMap.put(LOADING, "Loading");
		stringMap.put(RANGE, "Range");
		stringMap.put(REACH, "Reach");
		stringMap.put(SPECIAL, "Special");
		stringMap.put(THROWN, "Thrown");
		stringMap.put(TWO_HANDED, "Two-handed");
		stringMap.put(VERSATILE, "Versatile");
	}

	private WeaponPropertyType(Integer theValue) {
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
	 * @return an WeaponPropertyType containing the enumeration represented by the
	 *         provided String.
	 */
	public static WeaponPropertyType getEnum(Integer theValue) {
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