package com.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.annotation.JsonView;
import com.home.model.User;

@Controller
@RequestMapping(path = "/jackson")
public class JsonJacksonController {

	@GetMapping
	@ResponseBody
	public User getUser() {
		return new User("user", "1234", 55, "engineer");
	}
	
	@GetMapping(path = "/without")
	@ResponseBody
	@JsonView(User.WithoutPasswordView.class)
	public User getUserWithoutPassword() {
		return new User("user", "1234", 55, "engineer");
	}
	
	@GetMapping(path = "/with")
	@ResponseBody
	@JsonView(User.WithPasswordView.class)
	public User getUserWithPassword() {
		return new User("user", "1234", 55, "engineer");
	}
	
	@GetMapping(path = "/form")
	public String getUserWithoutPasswordForm(Model model) {
		
		model.addAttribute("user", new User("ahmed", "5555", 17, "Doctor"));
	//	model.addAttribute(JsonView.class.getName(), User.WithoutPasswordView.class);
		
		return "userView";
	}
}
