package com.patrickborrelli.dndiscord.exceptions;

/**
 * Custom exception used to indicate there is 
 * a problem during processing of an equation.
 * 
 * @author Patrick Borrelli
 */
public class MalformedEquationException extends Exception {
	private static final long serialVersionUID = 7848497044692174769L;
	
	public MalformedEquationException(String errorMessage) {
		super(errorMessage);
	}
}
