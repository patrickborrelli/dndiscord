package com.patrickborrelli.dndiscord.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Model of an administrator token response message.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenResponse {

	private String status;
	private boolean success;
	private String username;
	private String token;
	private String userId;
	private boolean admin;
	
	/**
	 * default constructor
	 */
	public TokenResponse() {
		
	}

	/**
	 * @return String the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param String the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return boolean the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param boolean the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * @return String the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param String the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return String the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param String the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return String the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param String the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return boolean the admin
	 */
	public boolean isAdmin() {
		return admin;
	}

	/**
	 * @param boolean the admin to set
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (admin ? 1231 : 1237);
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + (success ? 1231 : 1237);
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TokenResponse other = (TokenResponse) obj;
		if (admin != other.admin)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (success != other.success)
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TokenResponse [status=" + status + ", success=" + success + ", username=" + username + ", token="
				+ token + ", userId=" + userId + ", admin=" + admin + "]";
	}
}
