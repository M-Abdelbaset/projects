package com.home.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/hello")
public class HelloWorldForm {
	
	@GetMapping(path = "/form")
	public String getForm() {
		return "form";
	}
	
	@GetMapping(path = "/process")
	public String processForm() {
		return "form-res";
	}
	
	@GetMapping(path = "/processV2")
	public String processFormV2(HttpServletRequest request, Model model) {
		
		String name = request.getParameter("name");
		name = name.toUpperCase();
		
		model.addAttribute("newName", "New name: " + name);
		
		return "form-res";
	}
}
