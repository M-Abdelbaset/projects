package com.home.service;

public class CustomException extends Exception {

	private static final long serialVersionUID = 1L;
	private final String errorDetails;
	private final String errorCode;
	
	public CustomException(String message, String errorDetails, String errorCode) {
		super(message);
		this.errorDetails = errorDetails;
		this.errorCode = errorCode;
	}

	public String getErrorDetails() {
		return errorDetails;
	}

	public String getErrorCode() {
		return errorCode;
	}
}
