package com.patrickborrelli.dndiscord.model.dndbeyond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * Simple model for a DndBeyond character wrapper..
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DndBeyondResponse {
	
	private long id;
	private boolean success;
	private String message;
	private DndBeyondSheet data;
	
	public DndBeyondResponse() {		
		
	}

	/**
	 * Retrieves the id
	 *
	 * @return long the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Set the id
	 *
	 * @param id long the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Retrieves the success
	 *
	 * @return boolean the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * Set the success
	 *
	 * @param success boolean the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * Retrieves the message
	 *
	 * @return String the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Set the message
	 *
	 * @param message String the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Retrieves the data
	 *
	 * @return DndBeyondSheet the data
	 */
	public DndBeyondSheet getData() {
		return data;
	}

	/**
	 * Set the data
	 *
	 * @param data DndBeyondSheet the data to set
	 */
	public void setData(DndBeyondSheet data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "DndBeyondResponse [id=" + id + ", success=" + success + ", message=" + message + ", data=" + data + "]";
	}
}
