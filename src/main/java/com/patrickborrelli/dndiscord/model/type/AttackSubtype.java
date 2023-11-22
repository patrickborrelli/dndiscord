package com.patrickborrelli.dndiscord.model.type;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumerated type used for armor classifications.
 * 
 * @author Patrick Borrelli
 */
public enum AttackSubtype {
	UNKNOWN(1), NATURAL(2), UNARMED(3);

	private Integer value;
	private static HashMap<Integer, AttackSubtype> valuesMap;
	private static HashMap<AttackSubtype, String> stringMap;

	static {
		valuesMap = new HashMap<Integer, AttackSubtype>(AttackSubtype.values().length);
		valuesMap.put(1, UNKNOWN);
		valuesMap.put(2, NATURAL);
		valuesMap.put(3, UNARMED);

		stringMap = new HashMap<AttackSubtype, String>(AttackSubtype.values().length);
		stringMap.put(UNKNOWN, "Unknown");
		stringMap.put(NATURAL, "Natural");
		stringMap.put(UNARMED, "Unarmed");
	}

	private AttackSubtype(Integer theValue) {
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
	 * @return an AttackSubtype containing the enumeration represented by the
	 *         provided String.
	 */
	public static AttackSubtype getEnum(Integer theValue) {
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