package com.patrickborrelli.dndiscord.commands;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;

import com.patrickborrelli.dndiscord.exceptions.CommandProcessingException;
import com.patrickborrelli.dndiscord.mechanics.DieType;
import com.patrickborrelli.dndiscord.mechanics.PrimaryEquation;
import com.patrickborrelli.dndiscord.messaging.MessageResponse;

/**
 * Command class to handle all types of dice rolling
 * commands issued to the DnDiscord bot.
 */
public class RollCommand implements CommandExecutor {
	private static final Logger LOGGER = LogManager.getLogger(RollCommand.class);
	private static final String FORMULA = "$";
	private static final String REPEAT = "r";
	private static final String DIE = "d";
	private static final String KEEP = "k";
	private static final String KEEP_HIGH = "kh";
	private static final String KEEP_LOW = "kl";
	private static final String DROP_LOW = "dl";
	private static final String DROP_HIGH = "dh";
	private static final String REROLL = "r";
	private static final String CRITD = "critd";
	private static final String CRITR = "critr";

	@Override
	public void onCommand(Message msg) throws CommandProcessingException {
		TextChannel channel = msg.getChannel();
		String[] args = msg.getContent().split(" ");
		StringBuilder rollString = extractCommand(args);
		
		if(args.length < 2) {
			LOGGER.warn("Too few arguments provided to Roll command: " + msg.getContent());
			MessageResponse.sendReply(channel, "Not enough arguments provided");
		} else {
			MessageResponse.sendReply(channel, generateRollResponse(rollString.toString().toLowerCase()));
		}
	}
	
	private StringBuilder extractCommand(String[] args) {
		StringBuilder result = new StringBuilder();
		for(int i = 1; i < args.length; i++) {
			result.append(args[i]);
		}
		return result;		
	}
	
	private String generateRollResponse(String param) {
		StringBuilder result = new StringBuilder();
		String firstChar = param.substring(0, 1);
		
		//check first character to determine type of roll request:
		if(isDigit(firstChar)) {
			result.append(buildDieResponse(param));
		} else {
			switch(firstChar) {
				case DIE:
					result.append(buildDieResponse("1" + param));
					break;
					
				case FORMULA:
					//process formula assignment
					break;
					
				case REPEAT:
					//process repeat calculation
					break;
					
				default:
					//unknown request error message
					break;
			}
		}				
		
		return result.toString();
	}
		
	private static String buildDieResponse(String param) {
		StringBuilder result = new StringBuilder();
		boolean critr = param.contains("critr") ? true : false;
		boolean critd = param.contains("critd") ? true : false;
		
		if(critr) {
			param = param.replaceAll("critr", "");
		}
		if(critd) {
			param = param.replaceAll("critd", "");
		}
		LinkedList<String> singleEquation = null;
		List<PrimaryEquation> allEquations = new ArrayList<>();
		
		LinkedList<String> queue = new LinkedList<>();
		//the first equation will always be positive:
		queue.add("+");
		char[] input = param.toCharArray();
		for(int i = 0; i < input.length; i++) {
			queue.add("" + input[i] + "");
		}		

		//collect primary equations in a list then solve them all:
		while(queue.peek() != null) {
			singleEquation = new LinkedList<>();
			String next = queue.poll();
			singleEquation.add(next);
			while(queue.peek() != null && !isOperator(queue.peek())) {
				singleEquation.add(queue.poll());
			}
			if(critr) {
				singleEquation.add("critr");
			}
			if(critd) {
				singleEquation.add("critd");
			}
			allEquations.add(parseSingleEquation(singleEquation));
		}
		
		return result.toString();
	}	

	private static boolean isDigit(String character) {
		return Pattern.matches("\\d", character);
	}
	
	private static boolean isOperator(String ch) {
		return (ch.equalsIgnoreCase("+") ||ch.equalsIgnoreCase("-"));
	}
	
	private static boolean isCharacter(String character) {
		return Pattern.matches("[a-z]{1}", character);
	}
	
	private static PrimaryEquation parseSingleEquation(LinkedList<String> inputs) {
		PrimaryEquation equation = new PrimaryEquation();
		StringBuilder buf = new StringBuilder();
		boolean haveCount = false;
		boolean haveDieIndicator = false;
		boolean haveDieValue = false;
		boolean haveMod = false;
		boolean haveKeep = false;
		boolean haveKeepValue = false;
		boolean haveDrop = false;
		boolean haveDropValue = false;
		boolean haveReroll = false;
		boolean haveRerollValue = false;
		
		while(inputs.peek() != null) {
			String next = inputs.poll();
			
			if(next.equalsIgnoreCase("+") || next.equalsIgnoreCase("-")) {
				equation.setPositive(next.equalsIgnoreCase("+"));
			} else if(isDigit(next)) {
				buf.append(next);
				if(inputs.peek() == null || !isDigit(inputs.peek())) {
					//we have a complete number, apply it and clear the buffer:
					int value = Integer.parseInt(buf.toString());
					buf = new StringBuilder();
					
					if(!haveCount) {
						equation.setCount(value);
						haveCount = true;
					} else if(haveCount && haveDieIndicator && !haveDieValue) {
						//if standard add it otherwise add non-standard:
						LOGGER.debug("Attempting to get die type for " + value);
						DieType type = DieType.getEnum("" + value);
						if(type == null) {
							equation.setNonStandardDieSides(value);
						} else {
							equation.setDie(type);
						}
						haveDieValue = true;
					} else if(haveReroll && !haveRerollValue) {
						equation.setRerollValue(value);
						haveRerollValue = true;
					} else if(haveKeep && !haveKeepValue) {
						equation.setKeepCount(value);
						haveKeepValue = true;
					} else if(haveDrop && !haveDropValue) {
						equation.setDropCount(value);
						haveDropValue = true;
					} else if(!haveMod) {
						equation.setModifier(value);
						haveMod = true;
					} else {
						//add error for parsing problems
					}
				}
			} else if(next == CRITR) {
				equation.setCritr(true);
			} else if(next == CRITD) {
				equation.setCritd(true);
			} else if(isCharacter(next)) {
				buf.append(next);
				if(inputs.peek() == null || !isCharacter(inputs.peek())) {
					//determine what value we have in the buffer, apply it and clear the buffer:
					String value = buf.toString();
					buf = new StringBuilder();
					
					switch(value) {
						case KEEP: 
						case KEEP_HIGH:
							haveKeep = true;
							equation.setKeep(true);
							equation.setKeepDirection(PrimaryEquation.HIGHEST);						
							break;
						case KEEP_LOW:
							haveKeep = true;
							equation.setKeep(true);
							equation.setKeepDirection(PrimaryEquation.LOWEST);	
							break;
						case DROP_LOW:
							haveDrop = true;
							equation.setDrop(true);
							equation.setDropDirection(PrimaryEquation.LOWEST);
							break;
						case DROP_HIGH:
							haveDrop = true;
							equation.setDrop(true);
							equation.setDropDirection(PrimaryEquation.HIGHEST);
							break;
						case REROLL:
							haveReroll = true;
							equation.setReroll(true);
							break;
						case DIE: 
							haveDieIndicator = true;
							break;
						case CRITD:
							equation.setCritd(true);
							break;
						case CRITR:
							equation.setCritr(true);
							break;
						default:
							//add error for unknown format
							break;							
					}
					
				}
			}
		}
		LOGGER.debug(equation.toString());
		return equation;
	}
}