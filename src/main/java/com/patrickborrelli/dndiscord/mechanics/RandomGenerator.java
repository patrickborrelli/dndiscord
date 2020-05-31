package com.patrickborrelli.dndiscord.mechanics;

import java.security.SecureRandom;

/**
 * A singleton application utility to ensure only 
 * one instance of a seeded SecureRandom is
 * utilized throughout the application.
 * 
 * @author Patrick Borrelli
 */
public class RandomGenerator {
	private static volatile RandomGenerator instance;
	private static final SecureRandom random = new SecureRandom();
	
	/**
	 * Returns an instance of the RandomGenerator to the 
	 * calling client.
	 * 
	 * @return the RandomGenerator
	 */
	public static RandomGenerator getInstance() {
		if(instance == null) {
			synchronized(RandomGenerator.class) {
				if(instance == null) {
					instance = new RandomGenerator();
				}
			}
		}
		return instance;
	}
	
	/**
	 * Wrapper for Java SecureRandom nextInt call, returns the 
	 * next pseudorandom, uniformly distributed int value from 
	 * this random number generator's sequence. The general 
	 * contract of nextInt is that one int value is pseudorandomly 
	 * generated and returned. All 232 possible int values are 
	 * produced with (approximately) equal probability.
	 * 
	 * @return the next pseudorandom, uniformly distributed int value 
	 * 		from this random number generator's sequence
	 */
	public final int nextInt() {
		return random.nextInt();
	}
	
	/**
	 * Wrapper for Java SecureRandom nextInt(int bound) call, returns 
	 * a pseudorandom, uniformly distributed int value between 0 (inclusive) 
	 * and the specified value (exclusive), drawn from this random 
	 * number generator's sequence. The general contract of nextInt 
	 * is that one int value in the specified range is pseudorandomly 
	 * generated and returned. All bound possible int values are 
	 * produced with (approximately) equal probability. 
	 * 
	 * @param bound - the upper bound (exclusive), must be positive. 
	 * @return the next pseudorandom, uniformly distributed int value 
	 * 		between zero (inclusive) and bound (exclusive) from this random 
	 * 		number generator's sequence
	 */
	public final int nextInt(int bound) {
		return random.nextInt(bound);
	}
}
