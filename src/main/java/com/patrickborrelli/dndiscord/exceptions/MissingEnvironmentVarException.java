package com.patrickborrelli.dndiscord.exceptions;

/**
 * Custom exception used to indicate there is 
 * a missing environment variable on the host
 * computer preventing proper functionality.
 * @author Patrick Borrelli
 */
public class MissingEnvironmentVarException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public MissingEnvironmentVarException(String errorMessage) {
		super(errorMessage);
	}

}
