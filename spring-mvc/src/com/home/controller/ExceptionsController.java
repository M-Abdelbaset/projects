package com.home.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.home.exception.BusinessException1;
import com.home.exception.BusinessException2;
import com.home.exception.BusinessException3;

@Controller
@RequestMapping(path = "/exception")
public class ExceptionsController {

	@GetMapping(path = "responseStatus/{error}")
	@ResponseStatus(code = HttpStatus.OK, reason = "OK") // default response status
	public String responseStatus(@PathVariable(required = false) boolean error) {
		if(error)
			throw new BusinessException1("Exception in responseStatus ... ");
		else
			return "success";
	}
	
	@GetMapping(path = "exceptionHandler/{error}")
	public String exceptionHandler(@PathVariable int error) {
		switch (error) {
		case 1:
			throw new BusinessException2("Exception in exceptionHandler ... ");
		case 2:
			throw new BusinessException3("EXT0001", "Exception in exceptionHandler ... ");
		case 3:
			throw new NullPointerException();
		default:
			return "success";
		}
	}
	
	@ExceptionHandler
	private String handle(BusinessException2 ex, Model model) {
		model.addAttribute("handleMethod", "Handle # 1");
		return "error";
	}
}
