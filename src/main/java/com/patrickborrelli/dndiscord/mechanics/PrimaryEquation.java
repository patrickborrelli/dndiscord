package com.patrickborrelli.dndiscord.mechanics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class to represent mechanics of an equation for rolling dice.
 * 
 * @author Patrick Borrelli
 */
public class PrimaryEquation {
	private static final Logger LOGGER = LogManager.getLogger(PrimaryEquation.class);
	public static final int LOWEST = 0;
	public static final int HIGHEST = 1;
	public static final int NORMAL = 0;
	public static final int STRIKE = 1;
	public static final int BOLD = 2;
	public static final int ITALIC = 3;
	
	private boolean positive = true;
	private int count = 1;
	private DieType die;
	private int nonStandardDieSides = 0;
	private int modifier = 0;
	private boolean keep = false;
	private boolean drop = false;
	private boolean reroll = false;
	private boolean critd = false;
	private boolean critr = false;
	private int keepDirection = 1;
	private int dropDirection = 0;
	private int keepCount = 0;
	private int dropCount = 0;
	private int rerollValue = 0;
	private int result = 0;
	private String resultString;
	
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
	
	public void solveEquation() {
		Dice diceRoller = new Dice();
		List<Token> rolls = new ArrayList<>();
		int currentResult = 0;
		StringBuilder result = new StringBuilder().append("(");
		Token curr;
		
		for(int i = 0; i < count; i++) {
			currentResult = diceRoller.rollDie(die, 1, 0);
			if(reroll && currentResult == rerollValue) {
				//add another roll:
				count++;
				curr = new Token(currentResult, i, STRIKE);				
			} else {
				curr = new Token(currentResult, i, NORMAL);
			}		
			rolls.add(curr);
		}
		
		//now we have a full list of tokens, so see if we need special handling:
		if(keep) {
			if(keepDirection == LOWEST) {
				keepLowest(rolls, keepCount);
			} else {
				keepHighest(rolls, keepCount);
			}
		} else if(drop) {
			if(dropDirection == LOWEST) {
				dropLowest(rolls, dropCount);
			} else {
				dropHighest(rolls, dropCount);
			}
		}
		
		int counter = rolls.size() - 1;
		
		for(Token tok : rolls) {
			if(tok.format == STRIKE) {
				result.append("~~"+ tok.value + "~~");
			} else if(tok.format == ITALIC) {
				result.append("*"+ tok.value + "*");
			} else if(tok.format == BOLD) {
				result.append("**"+ tok.value + "**");				
			} else {
				result.append(tok.value);
			}
			
			if(counter > 0) result.append("+");
			counter--;
		}
		
		result.append(")");
		if(modifier > 0) {
			result.append("+" + modifier);
		} else if(modifier < 0) {
			result.append(modifier);
		}	
		
		resultString = result.toString();
	}
	
	private void keepLowest(List<Token> rolls, int countLowest) {
		LOGGER.debug("Tokens before sorting: " + rolls.toString());
		Collections.sort(rolls, new TokenValueAscCompare());
		LOGGER.debug("Tokens after sorting: " + rolls.toString());
		//walk through from lowest until count normal marked are found, then strikethrough all others
		int i = 0;
		for(Token tok : rolls) {
			if(i == countLowest) {
				tok.format = STRIKE;
			} else {
				if(tok.format == NORMAL) {
					i++;
				}
			}			
		}
		//return to order received in:
		Collections.sort(rolls, new TokenIndexAscCompare());
	}
	
	private void keepHighest(List<Token> rolls, int countHighest) {
		LOGGER.debug("Tokens before sorting: " + rolls.toString());
		Collections.sort(rolls, new TokenValueDescCompare());
		LOGGER.debug("Tokens after sorting: " + rolls.toString());
		//walk through from lowest until count normal marked are found, then strikethrough all others
		int i = 0;
		for(Token tok : rolls) {
			if(i == countHighest) {
				tok.format = STRIKE;
			} else {
				if(tok.format == NORMAL) {
					i++;
				}
			}			
		}
		//return to order received in:
		Collections.sort(rolls, new TokenIndexAscCompare());
	}
	
	private void dropLowest(List<Token> rolls, int countLowest) {
		LOGGER.debug("Tokens before sorting: " + rolls.toString());
		Collections.sort(rolls, new TokenValueAscCompare());
		LOGGER.debug("Tokens after sorting: " + rolls.toString());
		//walk through from lowest striking through until i = countLowest:
		int i = 0;
		for(Token tok : rolls) {
			if(i == countLowest) {
				break;
			} else {
				if(tok.format != STRIKE) {
					tok.format = STRIKE;
					i++;
				}
			}			
		}
		//return to order received in:
		Collections.sort(rolls, new TokenIndexAscCompare());
	}
	
	private void dropHighest(List<Token> rolls, int countHighest) {
		LOGGER.debug("Tokens before sorting: " + rolls.toString());
		Collections.sort(rolls, new TokenValueDescCompare());
		LOGGER.debug("Tokens after sorting: " + rolls.toString());
		//walk through from highest striking through until i = countLowest:
		int i = 0;
		for(Token tok : rolls) {
			if(i == countHighest) {
				break;
			} else {
				if(tok.format != STRIKE) {
					tok.format = STRIKE;
					i++;
				}
			}			
		}
		//return to order received in:
		Collections.sort(rolls, new TokenIndexAscCompare());
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
	 * @return the critd
	 */
	public boolean isCritd() {
		return critd;
	}

	/**
	 * @param critd the critd to set
	 */
	public void setCritd(boolean critd) {
		this.critd = critd;
	}

	/**
	 * @return the critr
	 */
	public boolean isCritr() {
		return critr;
	}

	/**
	 * @param critr the critr to set
	 */
	public void setCritr(boolean critr) {
		this.critr = critr;
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
	
	/**
	 * @return the result
	 */
	public int getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(int result) {
		this.result = result;
	}

	/**
	 * @return the resultString
	 */
	public String getResultString() {
		return resultString;
	}

	/**
	 * @param resultString the resultString to set
	 */
	public void setResultString(String resultString) {
		this.resultString = resultString;
	}

	/**
	 * @return the nonStandardDieSides
	 */
	public int getNonStandardDieSides() {
		return nonStandardDieSides;
	}

	/**
	 * @param nonStandardDieSides the nonStandardDieSides to set
	 */
	public void setNonStandardDieSides(int nonStandardDieSides) {
		this.nonStandardDieSides = nonStandardDieSides;
	}

	@Override
	public String toString() {
		return "PrimaryEquation [positive=" + positive + ", count=" + count + ", die=" + die + ", nonStandardDieSides="
				+ nonStandardDieSides + ", modifier=" + modifier + ", keep=" + keep + ", drop=" + drop + ", reroll="
				+ reroll + ", critd=" + critd + ", critr=" + critr + ", keepDirection=" + keepDirection
				+ ", dropDirection=" + dropDirection + ", keepCount=" + keepCount + ", dropCount=" + dropCount
				+ ", rerollValue=" + rerollValue + ", result=" + result + ", resultString=" + resultString + "]";
	}


	class Token {
		int value;
		int index;
		int format;
		
		public Token(int theValue, int theIndex, int theFormat) {
			value = theValue;
			index = theIndex;
			format = theFormat;
		}

		@Override
		public String toString() {
			return "Token [value=" + value + ", index=" + index + ", format=" + format + "]";
		}	
	}
	
	class TokenValueDescCompare implements Comparator<Token> {
		@Override
		public int compare(Token t1, Token t2) {
			if(t1.value < t2.value) return 1;
			if(t1.value > t2.value) return -1;
			else return 0;
		}		
	}
	
	class TokenValueAscCompare implements Comparator<Token> {
		@Override
		public int compare(Token t1, Token t2) {
			if(t1.value < t2.value) return -1;
			if(t1.value > t2.value) return 1;
			else return 0;
		}		
	}
	
	class TokenIndexAscCompare implements Comparator<Token> {
		@Override
		public int compare(Token t1, Token t2) {
			if(t1.index < t2.index) return -1;
			if(t1.index > t2.index) return 1;
			else return 0;
		}
	}
}
