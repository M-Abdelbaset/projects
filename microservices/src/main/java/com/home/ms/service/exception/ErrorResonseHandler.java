package com.home.ms.service.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class ErrorResonseHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorResponse> handleAllException(Exception ex, WebRequest request) {
		
		return new ResponseEntity<ErrorResponse>(
				new ErrorResponse(
						ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR
		);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<ErrorResponse> handleUserException(Exception ex, WebRequest request) {
		
		return new ResponseEntity<ErrorResponse>(
				new ErrorResponse(
						ex.getMessage()), HttpStatus.NOT_FOUND
		);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		return new ResponseEntity<Object>(
				new ErrorResponse(ex.getMessage()), HttpStatus.BAD_REQUEST
		);
	}
}
