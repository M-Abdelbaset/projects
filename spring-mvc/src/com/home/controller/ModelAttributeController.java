package com.home.controller;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.home.model.Customer;

@Controller
@RequestMapping(path = "/modelAtrribute")
public class ModelAttributeController {

	@ModelAttribute("customer")
	private Customer getCustomer(@PathVariable @Nullable String fname, 
			@RequestParam @Nullable String lname) {
		System.out.println("invoked getCustomer");
		Customer customer = new Customer();
		customer.setFirstName(fname);
		customer.setLastName(lname);
		System.out.println(customer);
		return customer;
	}
	
	@GetMapping(path = "/{fname}")
	public String form() {
		System.out.println("invoked form");
		return "customer-form";
	}
	
	@PostMapping(path = "/process")
	public String process(@ModelAttribute Customer customer) {
		
		System.out.println(customer);
		
		return "customer-form-res";
	}
}
