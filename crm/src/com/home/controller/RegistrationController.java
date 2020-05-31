package com.home.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.home.dto.CustomerDTO;
import com.home.security.SecurityUtil;
import com.home.service.UserService;

@Controller
@RequestMapping("/")
public class RegistrationController {

	@Autowired
	private UserService userService;

	@GetMapping(path = "/register")
	public String register(Model model) {
		model.addAttribute("customerDTO", new CustomerDTO());
		return "register";
	}
	
	@PostMapping(path = "/process-register")
	public String home(@Valid @ModelAttribute("customerDTO") CustomerDTO customer, 
			BindingResult bindingResult,
			HttpServletRequest request) {
		
		String target = "redirect:/customer/list";
		
		if(!bindingResult.hasErrors()) {
			try {
				userService.registerCustomer(customer);
				
				if(SecurityUtil.isAnonymous())
					request.login(customer.getEmail(), customer.getPassword()); // auto-authenticate
			} catch (ServletException e) { // failed to authenticate
				e.printStackTrace();
				target = "redirect:/login";
			} catch (Exception e) { // save exception
				e.printStackTrace();
				bindingResult.rejectValue("email", null, e.getMessage());
				target = "register";
			}
		} else {
			target = "register";
		}
		
		return target;
	}	
}
