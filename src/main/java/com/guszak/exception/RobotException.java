package com.guszak.exception;

public class RobotException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public RobotException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public RobotException() {
		super();
	}
}

