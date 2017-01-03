package com.pilaf.sdc.user.exception;

public class UserNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -945100941648595806L;
	private String reason;

	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(String reason) {
		super();
		this.reason = reason;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
