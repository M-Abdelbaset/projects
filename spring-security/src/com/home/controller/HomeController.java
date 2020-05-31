package com.home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.home.security.service.SecurityService;

@Controller
public class HomeController {

	@Autowired
	private SecurityService securityService;
	
	@GetMapping(path ="/")
	public String getHome() {
		return "home";
	}
	
	@GetMapping(path = "/admin")
	public String getAdmin() {
		return "admin";
	}
	
	@GetMapping(path = "/manager")
	public String getManager() {
		return "manager";
	}
	
	@ResponseBody
	@GetMapping(path = "/access")
	public List<String> accessFeature() {
		System.out.println(securityService.getClass().getName());
		return securityService.access();
	}
	
	@GetMapping(path = "/access-denied")
	public String getAccessDenied() {
		return "access-denied";
	}
}
