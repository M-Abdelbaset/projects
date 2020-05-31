package com.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.home.service.ManagerService;

@Controller
@RequestMapping("/manager")
public class ManagerController {

//	@Autowired
	private ManagerService managerService;
	
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
