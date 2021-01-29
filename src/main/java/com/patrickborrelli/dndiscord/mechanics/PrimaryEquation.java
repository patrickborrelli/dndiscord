package com.patrickborrelli.dndiscord.mechanics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.patrickborrelli.dndiscord.exceptions.MalformedEquationException;

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
	private int constant = 0;
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
	
	//default constructor
	public PrimaryEquation() {
		
	}
	
	/**
	 * Full constructor.
	 * 
	 * @param positive a boolean indication of
	 * 	whether or not this term is positive.
	 * @param count the count to set
	 * @param constant the constant to set
	 * @param die the die to set
	 * @param nonStandardDieSides the nonStandardDieSides to set
	 * @param modifier the modifier to set
	 * @param keep an indication of whether to keep
	 * @param drop an indication of whether to drop
	 * @param reroll an indication of whether to reroll
	 * @param critd an indication of whether to critd
	 * @param critr an indiction of whether to critr
	 * @param keepDirection the direction indicator for keep 
	 * @param dropDirection the direction indicator for drop
	 * @param keepCount the count to keep
	 * @param dropCount the count to drop
	 * @param rerollValue the value of a reroll
	 * @param result the total result value
	 * @param resultString a string representation of the total
	 */
	public PrimaryEquation(boolean positive, int count, int constant, DieType die, int nonStandardDieSides,
			int modifier, boolean keep, boolean drop, boolean reroll, boolean critd, boolean critr, int keepDirection,
			int dropDirection, int keepCount, int dropCount, int rerollValue, int result, String resultString) {
		super();
		this.positive = positive;
		this.count = count;
		this.constant = constant;
		this.die = die;
		this.nonStandardDieSides = nonStandardDieSides;
		this.modifier = modifier;
		this.keep = keep;
		this.drop = drop;
		this.reroll = reroll;
		this.critd = critd;
		this.critr = critr;
		this.keepDirection = keepDirection;
		this.dropDirection = dropDirection;
		this.keepCount = keepCount;
		this.dropCount = dropCount;
		this.rerollValue = rerollValue;
		this.result = result;
		this.resultString = resultString;
	}

	/**
	 * Method will solve the primary equation based on the
	 * current value of its private member variables and store
	 * both the total sum, and a string representation of the 
	 * completed calculation in appropriate member variables.
	 * 
	 * @throws MalformedEquationException if the format of the 
	 *  primary equation does not have a die type.
	 */
	public void solveEquation() throws MalformedEquationException {
		if(die == null) throw new MalformedEquationException("Cannot compute malformed equation, die type not provided.  See -help roll.");
		Dice diceRoller = new Dice();
		List<Token> rolls = new ArrayList<>();
		int currentResult = 0;
		StringBuilder resultStr = new StringBuilder();
		Token curr;
		result = 0;
		
		if(die == DieType.d0) {
			//handle constant calculation:
			if(positive) {
				resultStr.append("+");
				result = constant; 
			} else {
				resultStr.append("-");
				result = constant * (-1);
			}			
			resultStr.append(constant);
			
		} else {
			resultStr.append("(");
			if(critd) count = count *2;
			for(int i = 0; i < count; i++) {
				if(die == null) {
					//non-standard die:
					currentResult = diceRoller.rollDie(die, nonStandardDieSides, 1, 0);
				} else {
					currentResult = diceRoller.rollDie(die, 1, 0);				
				}
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
			
			//if crit with double the rolled result, walk through and add duplicates in bold for all rolled values:
			if(critr) {
				rolls = processCritResult(rolls);
			}
			
			int counter = rolls.size() - 1;
			
			for(Token tok : rolls) {
				if(tok.format == STRIKE) {
					resultStr.append("~~"+ tok.value + "~~");
				} else if(tok.format == ITALIC) {
					resultStr.append("*"+ tok.value + "*");
					result += tok.value;
				} else if(tok.format == BOLD) {
					resultStr.append("**"+ tok.value + "**");
					result += tok.value;
				} else {
					resultStr.append(tok.value);
					result += tok.value;
				}
				
				if(counter > 0) resultStr.append("+");
				counter--;
			}
			
			resultStr.append(")");
			if(modifier > 0) {
				resultStr.append("+" + modifier);
			} else if(modifier < 0) {
				resultStr.append(modifier);
			}
		}
		resultString = resultStr.toString();
	}
	
	private List<Token> processCritResult(List<Token> rolls) {
		List<Token> newList = new ArrayList<Token>();
		int insertCount = 0;
		Collections.sort(rolls, new TokenIndexAscCompare());
		Token critToken;
		Token copyToken;
		
		for(Token token : rolls) {
			//copy existing data to new list:
			copyToken = new Token();
			copyToken.format = token.format;
			copyToken.value = token.value;
			copyToken.index = token.index + insertCount;
			newList.add(copyToken);
			
			//if the current token is a normal roll result, duplicate
			if(token.format == NORMAL) {
				critToken = new Token();
				critToken.format = BOLD;
				critToken.index = token.index + 1;
				critToken.value = token.value;
				insertCount += 1;
				newList.add(critToken);
			}
		}
		return newList;
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
	 * @return a boolean determination of whether the term 
	 * represented by this equation is positive or negative.
	 */
	public boolean isPositive() {
		return positive;
	}

	/**
	 * 
	 * @param positive a boolean indication of
	 * whether or not this term is positive.
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
	 * @return the constant
	 */
	public int getConstant() {
		return constant;
	}

	/**
	 * @param constant the constant to set
	 */
	public void setConstant(int constant) {
		this.constant = constant;
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

	/**
	 * Overridden method to ensure a meaningful string representation of
	 * this primary equation.
	 */
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
		
		public Token() {
			
		}
		
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
