package com.patrickborrelli.dndiscord.utilities;

import java.util.HashMap;

/**
 * Enumerated type used to indicate type of damage.
 * 
 * @author Patrick Borrelli
 */
public enum DamageType {
	
	BLUDGEONING(1),
	PIERCING(2),
	SLASHING(3),
	NECROTIC(4),
	ACID(5),
	COLD(6),
	FIRE(7),
	LIGHTNING(8),
	THUNDER(9),
	POISON(10),
	PSYCHIC(11),
	RADIANT(12),
	FORCE(13)
	;
	
	private Integer value;
	private static HashMap<Integer, DamageType> valuesMap;
	private static HashMap<DamageType, String> stringMap;
	private static HashMap<String, DamageType> inverseMap;
	
	static {
		valuesMap = 
			new HashMap<Integer, DamageType>(DamageType.values().length);
		valuesMap.put(1, BLUDGEONING);
		valuesMap.put(2, PIERCING);
		valuesMap.put(3, SLASHING);
		valuesMap.put(4, NECROTIC);
		valuesMap.put(5, ACID);
		valuesMap.put(6, COLD);
		valuesMap.put(7, FIRE);
		valuesMap.put(8, LIGHTNING);
		valuesMap.put(9, THUNDER);
		valuesMap.put(10, POISON);
		valuesMap.put(11, PSYCHIC);
		valuesMap.put(12, RADIANT);
		valuesMap.put(13, FORCE);
		
		stringMap = 
			new HashMap<DamageType, String>(DamageType.values().length);
		stringMap.put(BLUDGEONING, "Bludgeoning");
		stringMap.put(PIERCING, "Piercing");
		stringMap.put(SLASHING, "Slashing");
		stringMap.put(NECROTIC, "Necrotic");
		stringMap.put(ACID, "Acid");
		stringMap.put(COLD, "Cold");
		stringMap.put(FIRE, "Fire");
		stringMap.put(LIGHTNING, "Lightning");
		stringMap.put(THUNDER, "Thunder");
		stringMap.put(POISON, "Poison");
		stringMap.put(PSYCHIC, "Psychic");
		stringMap.put(RADIANT, "Radiant");
		stringMap.put(FORCE, "Force");
				
		inverseMap = 
			new HashMap<String, DamageType>(DamageType.values().length);
		inverseMap.put("Bludgeoning", BLUDGEONING);
		inverseMap.put("Piercing", PIERCING);
		inverseMap.put("Slashing", SLASHING);
		inverseMap.put("Necrotic", NECROTIC);
		inverseMap.put("Acid", ACID);
		inverseMap.put("Cold", COLD);
		inverseMap.put("Fire", FIRE);
		inverseMap.put("Lightning", LIGHTNING);
		inverseMap.put("Thunder", THUNDER);
		inverseMap.put("Poison", POISON);
		inverseMap.put("Psychic", PSYCHIC);
		inverseMap.put("Radiant", RADIANT);
		inverseMap.put("Force", FORCE);
	}
	
	private DamageType(Integer theValue) {
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
	 * @return an DamageType containing the enumeration 
	 * 			represented by the provided Integer.
	 */
	public static DamageType getEnum(Integer theValue) {
		return valuesMap.get(theValue);
	}
	
	/**
	 * Returns the enumeration corresponding to the provided String
	 * @param value the String representation of this enumeration
	 * @return an DamageType containing the enumeration 
	 * 			represented by the provided String.
	 */
	public static DamageType getEnum(String value) {
		return inverseMap.get(value);
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