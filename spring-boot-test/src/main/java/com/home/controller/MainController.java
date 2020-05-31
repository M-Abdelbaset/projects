package com.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.home.security.SecurityUtil;

@Controller
@RequestMapping("/")
public class MainController {
	
	@GetMapping(path = "/")
	public String home() {
		return "redirect:/customer/list";
	}
	
	@GetMapping(path = "/login")
	public String login() {		
		boolean anonymous = SecurityUtil.isAnonymous();
		System.out.println(anonymous);
		return anonymous ? "login" : "redirect:/customer/list";
	}
	
	@GetMapping(path = "/denied")
	public String denied() {
		return "access-denied";
	}
}
