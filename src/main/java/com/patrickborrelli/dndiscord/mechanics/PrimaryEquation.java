package com.patrickborrelli.dndiscord.mechanics;

/**
 * Class to represent mechanics of an equation for rolling dice.
 * 
 * @author Patrick Borrelli
 */
public class PrimaryEquation {
	public static final int LOWEST = 0;
	public static final int HIGHEST = 1;
	
	private boolean positive = true;
	private int count = 1;
	private DieType die;
	private int modifier = 0;
	private boolean keep = false;
	private boolean drop = false;
	private boolean reroll = false;
	private int keepDirection = 1;
	private int dropDirection = 0;
	private int keepCount = 0;
	private int dropCount = 0;
	private int rerollValue = 0;
	
	public PrimaryEquation() {
		
	}

	/**
	 * Full constructor
	 * 
	 * @param count
	 * @param die
	 * @param modifier
	 * @param keep
	 * @param drop
	 * @param reroll
	 * @param keepDirection
	 * @param dropDirection
	 * @param keepCount
	 * @param dropCount
	 * @param rerollValue
	 */
	public PrimaryEquation(boolean positive, int count, DieType die, int modifier, boolean keep, boolean drop, boolean reroll,
			int keepDirection, int dropDirection, int keepCount, int dropCount, int rerollValue) {
		this.positive = positive;
		this.count = count;
		this.die = die;
		this.modifier = modifier;
		this.keep = keep;
		this.drop = drop;
		this.reroll = reroll;
		this.keepDirection = keepDirection;
		this.dropDirection = dropDirection;
		this.keepCount = keepCount;
		this.dropCount = dropCount;
		this.rerollValue = rerollValue;
	}

	/**
	 * @return the positive
	 */
	public boolean isPositive() {
		return positive;
	}

	/**
	 * @param positive the positive to set
	 */
	public void setPositive(boolean positive) {
		this.positive = positive;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return the die
	 */
	public DieType getDie() {
		return die;
	}

	/**
	 * @param die the die to set
	 */
	public void setDie(DieType die) {
		this.die = die;
	}

	/**
	 * @return the modifier
	 */
	public int getModifier() {
		return modifier;
	}

	/**
	 * @param modifier the modifier to set
	 */
	public void setModifier(int modifier) {
		this.modifier = modifier;
	}

	/**
	 * @return the keep
	 */
	public boolean isKeep() {
		return keep;
	}

	/**
	 * @param keep the keep to set
	 */
	public void setKeep(boolean keep) {
		this.keep = keep;
	}

	/**
	 * @return the drop
	 */
	public boolean isDrop() {
		return drop;
	}

	/**
	 * @param drop the drop to set
	 */
	public void setDrop(boolean drop) {
		this.drop = drop;
	}

	/**
	 * @return the reroll
	 */
	public boolean isReroll() {
		return reroll;
	}

	/**
	 * @param reroll the reroll to set
	 */
	public void setReroll(boolean reroll) {
		this.reroll = reroll;
	}

	/**
	 * @return the keepDirection
	 */
	public int getKeepDirection() {
		return keepDirection;
	}

	/**
	 * @param keepDirection the keepDirection to set
	 */
	public void setKeepDirection(int keepDirection) {
		this.keepDirection = keepDirection;
	}

	/**
	 * @return the dropDirection
	 */
	public int getDropDirection() {
		return dropDirection;
	}

	/**
	 * @param dropDirection the dropDirection to set
	 */
	public void setDropDirection(int dropDirection) {
		this.dropDirection = dropDirection;
	}

	/**
	 * @return the keepCount
	 */
	public int getKeepCount() {
		return keepCount;
	}

	/**
	 * @param keepCount the keepCount to set
	 */
	public void setKeepCount(int keepCount) {
		this.keepCount = keepCount;
	}

	/**
	 * @return the dropCount
	 */
	public int getDropCount() {
		return dropCount;
	}

	/**
	 * @param dropCount the dropCount to set
	 */
	public void setDropCount(int dropCount) {
		this.dropCount = dropCount;
	}

	/**
	 * @return the rerollValue
	 */
	public int getRerollValue() {
		return rerollValue;
	}

	/**
	 * @param rerollValue the rerollValue to set
	 */
	public void setRerollValue(int rerollValue) {
		this.rerollValue = rerollValue;
	}	
}
