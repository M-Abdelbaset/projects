package com.home.jwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<?> handle(AuthenticationException ex){
		return ResponseEntity.badRequest().build();
	}
}
