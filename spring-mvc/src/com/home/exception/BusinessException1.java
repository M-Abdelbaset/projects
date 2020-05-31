package com.home.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "BusinessException1")
public class BusinessException1 extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BusinessException1(String reason) {
		super(reason);
	}
}
