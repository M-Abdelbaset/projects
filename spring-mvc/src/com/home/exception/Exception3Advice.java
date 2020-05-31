package com.home.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.home.controller.ExceptionsController;
import com.home.model.Result;

@ControllerAdvice(assignableTypes = ExceptionsController.class)
public class Exception3Advice {

	@ExceptionHandler(value = BusinessException3.class)
	private String handle2(BusinessException3 ex, Model model) {
		
		model.addAttribute("exp", ex);
		return "error";
	}
	
	@ExceptionHandler(value = BusinessException2.class)
	private String handleAgain(BusinessException2 ex, Model model) {
		
		System.out.println(model.getAttribute("handleMethod"));
		return "error";
	}
	
	@ExceptionHandler
	@ResponseBody
	private ResponseEntity<Result> restfulResponse(NullPointerException ex) {
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new Result("EXT00004", "NPE"));
	}
}
