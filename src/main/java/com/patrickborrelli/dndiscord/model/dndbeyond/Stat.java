package com.patrickborrelli.dndiscord.model.dndbeyond;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for a stat json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Stat {
	private static final int STR = 1;
	private static final int DEX = 2;
	private static final int CON = 3;
	private static final int INT = 4;
	private static final int WIS = 5;
	private static final int CHA = 6;
	private static final String STRENGTH = "Strength";
	private static final String DEXTERITY = "Dexterity";
	private static final String CONSTITUTION = "Constitution";
	private static final String INTELLIGENCE = "Intelligence";
	private static final String WISDOM = "Wisdom";
	private static final String CHARISMA = "Charisma";
	
	private static Map<Integer, String> statMap = new HashMap<>();
	
	static {
		statMap.put(STR, STRENGTH);
		statMap.put(DEX, DEXTERITY);
		statMap.put(CON, CONSTITUTION);
		statMap.put(INT, INTELLIGENCE);
		statMap.put(WIS, WISDOM);
		statMap.put(CHA, CHARISMA);		
	}

	private int id;
	private String name;
	private int value;
	
	public Stat() {
		
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Stat [id=" + id + ", name=" + name + ", value=" + value + "]";
	}
}
