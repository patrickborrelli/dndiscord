package com.patrickborrelli.dndiscord.mechanics;

import java.util.Calendar;
import java.util.Random;

/**
 * A dice mechanics class for handling roll requests.
 * 
 * @author Patrick Borrelli
 */
public class Dice {
	
	Random randomGenerator;
	static final int D4 = 4;
	static final int D6 = 6;
	static final int D8 = 8;
	static final int D10 = 10;
	static final int D12 = 12;
	static final int D20 = 20;
	static final int D100 = 100;
		
	/**
	 * Default constructor, seeds random generator
	 */
	public Dice() {
		//seeding random number generator:
		randomGenerator = new Random(Calendar.getInstance().getTimeInMillis());		
	}
	
	private int rollDie(int sides) {
		return randomGenerator.nextInt(sides) + 1;
	}
	
	private int rollDie(DieType type) {
		int castValue;
		
		switch(type) {
		
		case d4:
			castValue = randomGenerator.nextInt(D4)+1;
			break;
		
		case d6:
			castValue = randomGenerator.nextInt(D6)+1;
			break;
			
		case d8:
			castValue = randomGenerator.nextInt(D8)+1;
			break;
		
		case d10:
			castValue = randomGenerator.nextInt(D10)+1;
			break;
			
		case d12:
			castValue = randomGenerator.nextInt(D12)+1;
			break;
		
		case d20:
			castValue = randomGenerator.nextInt(D20)+1;
			break;

		case d100:
			castValue = randomGenerator.nextInt(D100)+1;
			break;
			
		default: 
			castValue = 0;
			break;
		}		
		return castValue;
	}
	
	/**
	 * Method to generate random dice throws.
	 * 
	 * @param type an Enum of die types
	 * @param num an int representing the number of times to cast the type of die
	 * @param mod an int representing a modification of the resulting value (ie., 2d4 +1)
	 * @return an int representing the value cast
	 */
	public int rollDie(DieType type, int num, int mod) {
		
		int result = 0;
		for(int i=0; i<num; i++) {
			result += rollDie(type);
		}
		result += mod;		
		return result;
	}
	
	/**
	 * Method to generate random dice throws for non-standard die types.
	 * 
	 * @param type an Enum of die type
	 * @param dieValue an int representing the sides on the non-standard die
	 * @param num an int representing the number of times to cast the type of die
	 * @param mod an int representing a modification of the resulting value (ie., 2d4 +1)
	 * @return an int representing the value cast
	 */
	public int rollDie(DieType type, int dieValue, int num, int mod) {
		
		int result = 0;
		for(int i=0; i<num; i++) {
			result += rollDie(dieValue);
		}
		result += mod;		
		return result;
	}
}