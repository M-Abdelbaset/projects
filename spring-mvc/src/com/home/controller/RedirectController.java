package com.home.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.home.model.User;

@Controller
@RequestMapping(path = "/login")
public class RedirectController {

	@GetMapping
	public String loginForm(@ModelAttribute("user") User user) {
		return "login";
	}
	
	@PostMapping(path = "/process")
	public String processLogin(@ModelAttribute("user") User user) {
		
		if("root".equals(user.getUserName()) &&
				"123".equals(user.getPassword())) {
			System.out.println("Redirecting ... ");
			return "redirect:/"; // to home page
		} else {
			return "login";
		}
	}
	
	@PostMapping(path = "/process/{to}")
	public String processLogin(@ModelAttribute("user") User user,
			@PathVariable String to,
			HttpSession session,
			HttpServletRequest request,
			RedirectAttributes redirectAttributes) {
		
		if("root".equals(user.getUserName()) &&
				"123".equals(user.getPassword())) {
			System.out.println("Redirecting ... ");
			session.setAttribute("FromRedirect", "FromRedirect");
			user.setUserName("changed inside processLogin");
			redirectAttributes.addFlashAttribute("user", user);
			return "redirect:/login/{to}"; // to home page
		} else {
			return "login";
		}
	}
	
	@ResponseBody
	@GetMapping(path = "/x")
	public String received(
			HttpSession session,
			HttpServletRequest request,
			@ModelAttribute("user") User user) {
		
		System.out.println("FromRedirect".equals(session.getAttribute("FromRedirect")));
		System.out.println("changed inside processLogin".equals(user.getUserName()));
		
		return "recieved";
	}
}
