package com.patrickborrelli.dndiscord.commands;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.embed.EmbedBuilder;

import com.patrickborrelli.dndiscord.exceptions.CommandProcessingException;
import com.patrickborrelli.dndiscord.exceptions.MalformedEquationException;
import com.patrickborrelli.dndiscord.mechanics.DieType;
import com.patrickborrelli.dndiscord.mechanics.PrimaryEquation;
import com.patrickborrelli.dndiscord.messaging.MessageResponse;
import com.patrickborrelli.dndiscord.model.DiscordUser;
import com.patrickborrelli.dndiscord.model.Formula;
import com.patrickborrelli.dndiscord.model.webservice.WebserviceManager;
import com.patrickborrelli.dndiscord.utilities.AppUtil;
import com.patrickborrelli.dndiscord.utilities.CommandUtil;

/**
 * Command class to handle all types of dice rolling
 * commands issued to the DnDiscord bot.
 * 
 * @author Patrick Borrelli
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
	private static final String SAVE = "s";
	private static final String LIST = "l";
	private static final String CLEAR = "clear";
	private static final String C = "c";
	
	private boolean sendEmbed = false;
	private boolean sendBoth = false;
	
	private HelpCommand helpCommand = new HelpCommand();
	
	WebserviceManager wsManager = WebserviceManager.getInstance();

	/**
	 * {@inheritDoc}
	 */
	@Override	
	public void onCommand(Message msg, DiscordUser user, long messageReceiptTime) throws CommandProcessingException {
		TextChannel channel = msg.getChannel();
		String[] args = msg.getContent().split(" ");
		StringBuilder rollString = extractCommand(args);
		
		if(args.length < 2) {
			LOGGER.warn("Too few arguments provided to Roll command: " + msg.getContent());
			MessageResponse.sendReply(channel, "Not enough arguments provided");
			helpCommand.onCommand(msg, CommandUtil.ROLL, user, messageReceiptTime);
		} else {
			StringBuilder buf = new StringBuilder();
			buf.append("<@" + msg.getAuthor().getId() + ">: " + rollString.toString() + " --> ");
			try {
				buf.append(generateRollResponse(rollString.toString().toLowerCase(), user, msg));
			} catch(MalformedEquationException mee) {
				buf.append(mee.getMessage());
				LOGGER.error(mee.getMessage());
			}
			LOGGER.debug("Sending back reply: " + buf.toString());
			if(!sendEmbed || sendBoth) {
				MessageResponse.sendReply(channel, buf.toString());
			} else {
				sendEmbed = false;
				sendBoth = false;
			}
		}
	}
	
	private StringBuilder extractCommand(String[] args) {
		StringBuilder result = new StringBuilder();
		for(int i = 1; i < args.length; i++) {
			result.append(args[i]);
		}
		return result;		
	}
	
	private String generateRollResponse(String param, DiscordUser user, Message msg) throws MalformedEquationException {
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
					//process saved roll:
					result.append(buildFormulaResponse(param, user));
					break;
					
				case REPEAT:
					//process repeat calculation
					result.append(buildRepeatResponse(param));
					break;
					
				case SAVE:
					//validate roll format and save to user account:
					result.append(storeSavedRoll(param, user));
					break;
					
				case C:
					//process clear request:
					result.append(clearRolls(param, user));
					sendBoth = true;
					
				case LIST:
					//retrieve a list of user's saved rolls:
					buildRollEmbed(msg, retrieveSavedRolls(user));
					sendEmbed = true;
					break;
					
				default:
					//unknown request error message
					break;
			}
		}						
		return result.toString();
	}
	
	private String clearRolls(String param, DiscordUser user) {
		StringBuilder result = new StringBuilder();
		/**
		 * check to see if there are one or more named parameters,
		 * if there are, individually delete them all, if not, 
		 * delete all formulas for this user
		 */
		LOGGER.debug("Processing parameters ["+ param + "] to clear values");
		//confirm param contains 'clear':
		if(param.contains(CLEAR)) {
			param = param.replaceAll(CLEAR, "");
			LOGGER.debug("Parameter stripped of clear = " + param);
			String[] params = param.split("\\$");		
			
			if(params.length == 0) {
				LOGGER.debug("Empty parameters, clearing ALL saved rolls");
				result.append(wsManager.deleteUserFormula(user, params));
			} else {
				//process remaining parameters:
				LOGGER.debug("Empty parameters, clearing ALL saved rolls");
				result.append(wsManager.deleteUserFormula(user, params));
			}
		} else {
			LOGGER.error("Invalid format for clear request: " + param);
			result.append("Invalid format for clear request.");
		}
		retrieveSavedRolls(user);
		return result.toString();
	}
	
	private String retrieveSavedRolls(DiscordUser user) {
		StringBuilder result = new StringBuilder();
		List<Formula> formulas = wsManager.getUserFormulas(user);
		
		if(null == formulas || formulas.size() == 0) {
			result.append("No saved rolls found for user");
		} else {
			//format results:
			for(Formula roll : formulas) {
				result.append("\n" + "$" + roll.getName() + ": " + roll.getRoll());
			}
		}		
		return result.toString();
	}
	
	private String buildFormulaResponse(String param, DiscordUser user) throws MalformedEquationException {
		StringBuilder result = new StringBuilder();
		boolean formulaHasRepeat = false;
		String roll = null;
		String name = param.substring(1);
		
		LOGGER.debug("Processing roll request for: " + param);
		
		//retrieve user formula:
		roll = wsManager.getUserFormula(user, name);
		
		//if no named roll exists, indicate such:
		if(null == roll) {
			result.append("No saved roll exists with name: " + name);
		} else {
			//confirm whether there is a repeat in the function:
			formulaHasRepeat = (roll.substring(0, 1).equalsIgnoreCase(REPEAT));
			if(formulaHasRepeat) {
				result.append(buildRepeatResponse(roll));
			} else {
				result.append(buildDieResponse(roll));
			}
		}		
				
		return result.toString();
	}
	
	private void buildRollEmbed(Message msg, String contents) {
		EmbedBuilder embed = new EmbedBuilder()
				.setTitle("Saved Rolls")
				.setDescription(contents)
			    .setAuthor("DnDiscord", "http://github.com/patrickborrelli", AppUtil.getInstance().getBotAvatarUrl().toString())
			    .setColor(Color.GREEN)
			    .setFooter("©2020 AwareSoft, LLC", "https://cdn.discordapp.com/embed/avatars/1.png")
			    .setThumbnail(AppUtil.getInstance().getBotAvatarUrl().toString());
			MessageResponse.sendEmbedMessage(msg.getChannel(), embed);	
	}
		
	private String storeSavedRoll(String param, DiscordUser user) {
		StringBuilder result = new StringBuilder();
		boolean formulaHasRepeat = false;
		String roll = null;
		String name = null;
		
		LOGGER.debug("Processing save request for: " + param);
		
		//pull out roll formula:
		int beginIndex = param.indexOf("(");
		int endIndex = param.lastIndexOf(")");
		String formula = param.substring(beginIndex + 1, endIndex);
		
		//confirm whether there is a repeat in the function:
		formulaHasRepeat = (formula.substring(0, 1).equalsIgnoreCase(REPEAT));
		if(formulaHasRepeat) {
			roll = formula.substring(0, formula.indexOf(")") + 1);
			name = formula.substring(formula.lastIndexOf(",") + 1);
		} else {
			roll = formula.substring(0, formula.indexOf(","));
			name = formula.substring(formula.indexOf(",") + 1);
		}
		LOGGER.debug("Pulled out roll: " + roll + " and name: " + name);
		
		//now validate the roll formula:
		try {
			if(formulaHasRepeat) {
				buildRepeatResponse(roll);
			} else {
				buildDieResponse(roll);
			}
		} catch(MalformedEquationException mee) {
			//if we arrive here, the roll formula cannot be validated, so skip saving and notify user:
			return new String(mee.getMessage() + " Roll will not be saved.");
		}
		
		//at this point our roll formula is valid, so save it and report success or failure to user:
		result.append(wsManager.addUserFormula(user, roll, name));
		
		return result.toString();
	}
	
	private String buildDieResponse(String param) throws MalformedEquationException {
		StringBuilder result = new StringBuilder();
		int grandTotal = 0;
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
			PrimaryEquation solvedEquation = parseSingleEquation(singleEquation);
			allEquations.add(solvedEquation);
			result.append(solvedEquation.getResultString() + " ");
			grandTotal += solvedEquation.getResult();
		}
		result.append("= " + grandTotal);
		
		if(critd || critr) {
			result.append("  CRIT!");
		}
		return result.toString();
	}	
	
	private String buildRepeatResponse(String param) throws MalformedEquationException {
		StringBuilder buf = new StringBuilder();
		
		/**
		 * parse the command and repeatedly feed the equation 
		 * to the processor the required number of times.
		 * format expected is: repeat(equation, N) where N is 
		 * the number of times to be repeated.
		 */
		param = param.replaceAll(" ", "");
		String equation = param.substring(param.indexOf('(') + 1, param.indexOf(','));
		int repeats = Integer.parseInt(param.substring(param.indexOf(',')+1, param.indexOf(')')));
		LOGGER.debug("Will process equation: " + equation + " " + repeats + " times");
		buf.append("\n");
		for(int i = 0; i < repeats; i++) {
			buf.append(buildDieResponse(equation));
			buf.append("\n");
		}
		return buf.toString();
	}

	private boolean isDigit(String character) {
		return Pattern.matches("\\d", character);
	}
	
	private boolean isOperator(String ch) {
		return (ch.equalsIgnoreCase("+") ||ch.equalsIgnoreCase("-"));
	}
	
	private boolean isCharacter(String character) {
		return Pattern.matches("[a-z]{1}", character);
	}
	
	private PrimaryEquation parseSingleEquation(LinkedList<String> inputs) throws MalformedEquationException {
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
						DieType type = DieType.getEnum(value);
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
		//handle constants:
		if(haveCount && !haveDieIndicator) {
			//change count to 1, die type to d0 and add constant:
			equation.setConstant(equation.getCount());
			equation.setCount(1);
			equation.setDie(DieType.d0);
		}
		equation.solveEquation();
		LOGGER.debug(equation.toString());
		return equation;
	}
}