package com.patrickborrelli.dndiscord.utilities;

import java.util.HashMap;

/**
 * Enumerated type used to indicate type of damage.
 * 
 * @author Patrick Borrelli
 */
public enum DamageType {
	
	ACID("Acid"),
	BLUDGEONING("Bludgeoning"),
	COLD("Cold"),
	FIRE("Fire"),
	FORCE("Force"),
	LIGHTNING("Lightning"),
	NECROTIC("Necrotic"),
	PIERCING("Piercing"),
	POISON("Poison"),
	PSYCHIC("Psychic"),
	RADIANT("Radiant"),
	SLASHING("Slashing"),
	THUNDER("Thunder")
	;
	
	private String value;
	private static HashMap<String, DamageType> valuesMap;
	
	static {
		valuesMap = 
			new HashMap<String, DamageType>(DamageType.values().length);
		valuesMap.put("Acid",  ACID);
		valuesMap.put("Bludgeoning",  BLUDGEONING);
		valuesMap.put("Cold",  COLD);
		valuesMap.put("Fire",  FIRE);
		valuesMap.put("Force",  FORCE);
		valuesMap.put("Lightning",  LIGHTNING);
		valuesMap.put("Necrotic",  NECROTIC);
		valuesMap.put("Piercing",  PIERCING);
		valuesMap.put("Poison",  POISON);
		valuesMap.put("Psychic",  PSYCHIC);
		valuesMap.put("Radiant",  RADIANT);
		valuesMap.put("Slashing",  SLASHING);
		valuesMap.put("Thunder",  THUNDER);	
	}
	
	private DamageType(String theValue) {
		value = theValue;
	}
	
	/**
	 * Returns the value of the enumeration.
	 * 
	 * @return a String containing the value of the enumeration
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * Returns the enumeration for the provided String
	 * value for this enumeration
	 * 
	 * @param theValue the String value of this enumeration.
	 * @return an ArmorType containing the enumeration 
	 * 			represented by the provided String.
	 */
	public static DamageType getEnum(String theValue) {
		return valuesMap.get(theValue);
	}
	
	/**
	 * Overrides the default toString method provided by 
	 * {@link Object}
	 */
	@Override
	public String toString() {
		return value;
	}
}