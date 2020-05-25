package com.patrickborrelli.dndiscord.mechanics;

/**
 * Enumeration of standard RPG die types
 * 
 * @author Patrick Borrelli
 */
import java.util.HashMap;

public enum DieType {
	d0(0), //used for cases of non-random damage 
	d4 (4), 
	d6 (6), 
	d8 (8), 
	d10 (10),
	d12 (12), 
	d20 (20), 
	d100 (100);
	
	private Integer value;
	
	private static HashMap<Integer, DieType> valuesMap;
	static
	{
		valuesMap = 
			new HashMap<Integer, DieType>(DieType.values().length);
		valuesMap.put(0, d0);
		valuesMap.put(4,  d4);
		valuesMap.put(6,  d6);
		valuesMap.put(8,  d8);
		valuesMap.put(10,  d10);
		valuesMap.put(12,  d12);
		valuesMap.put(20,  d20);
		valuesMap.put(100,  d100);
	}	
	
	/**
	 * Private constructor to be used internally:
	 * 
	 * @param theValue the Integer value of the enumeration to construct
	 */
	private DieType(Integer theValue) {
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
	 * Returns the enumeration for the provided Integer value for this enumeration
	 * 
	 * @param theValue the Integer value of this enumeration.
	 * @return a DieType containing the enumeration represented by the provided Integer.
	 */
	public static DieType getEnum(Integer theValue) {
		return valuesMap.get(theValue);
	}
	
	/**
	 * Overloaded method to retrieve a DieType based on a String parameter.
	 * @param theValue  the String value of this enumeration.
	 * @return a DieType containing the enumeration represented by the provided String.
	 */
	public static DieType getEnum(String theValue) {
		DieType type;
		if(theValue.startsWith("0")) {
			type = DieType.d0;
	    } else if(theValue.contains("4")) {
			type = DieType.d4;
		} else if(theValue.contains("8")) {
			type = DieType.d8;
		} else if(theValue.contains("10")) {
			type = DieType.d10;
		} else if(theValue.contains("12")) {
			type = DieType.d12;
		} else if(theValue.contains("20")) {
			type = DieType.d20;
		} else if(theValue.contains("100")) {
			type = DieType.d100;
		} else {
			type = null;
		}
		
		return type;
	}
}
