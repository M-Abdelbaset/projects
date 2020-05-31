package com.home.exception;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BusinessException3 extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	private String errorMessage;
	
	public BusinessException3(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
}
