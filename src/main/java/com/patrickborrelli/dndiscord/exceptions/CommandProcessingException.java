package com.patrickborrelli.dndiscord.exceptions;

/**
 * Custom exception used to indicate there is 
 * a problem during execution of a command.
 * 
 * @author Patrick Borrelli
 */
public class CommandProcessingException extends Exception {
	private static final long serialVersionUID = -1651038377204250278L;

	public CommandProcessingException(String errorMessage) {
		super(errorMessage);
	}

}
