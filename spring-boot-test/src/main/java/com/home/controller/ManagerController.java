package com.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/manager")
public class ManagerController {

	@GetMapping("/add")
	public String add() {
		return "add";
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public String delete() {
		return "";
	}
}
