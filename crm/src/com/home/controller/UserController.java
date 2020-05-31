package com.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.home.dto.CustomerDTO;
import com.home.service.UserService;

@Controller
@RequestMapping("/customer")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("customers", userService.getCustomers());
		return "customer";
	}
	
	@GetMapping(path = "/update")
	public String updateForm(@RequestParam("email") String email, Model model) {
		
		CustomerDTO customer = userService.getCustomer(email);
		model.addAttribute("customerDTO", customer);
		
		return "update-customer";
	}
	
	@PutMapping(path = "/update")
	public String processUpdate(
			@ModelAttribute("customerDTO") CustomerDTO customer,
			BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "update-customer";
		} else {
			userService.updateCustomer(customer);
			return "redirect:/customer/list";
		}
	}
	
	@DeleteMapping(path = "/delete")
	public String delete(@RequestParam String email) {
		userService.deleteCustomer(email);
		return "redirect:/customer/list";
	}
}
