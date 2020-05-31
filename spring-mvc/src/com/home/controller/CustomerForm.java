package com.home.controller;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.home.model.Customer;

@Controller
@RequestMapping(path = "/customer")
@SessionAttributes(names = {"customer-form"})
public class CustomerForm {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(false);
		binder.registerCustomEditor(String.class, trimmerEditor);
	}
	
	@GetMapping(path = "/form")
	public String getForm(Model model) {
		
		model.addAttribute("customer", new Customer());		
		return "customer-form";
	}
	
	@PostMapping(path = "/process")
	public String processForm(
			@Valid @ModelAttribute(value = "customer") Customer customer,
			BindingResult bindingResult,
			HttpServletRequest request) {
		
		Iterator<String> attr = request.getAttributeNames().asIterator();
		while(attr.hasNext())
			System.out.println(attr.next());
		
		if(bindingResult.hasErrors()) {
			return "customer-form";
		} else
			return "customer-form-res";
	}
	
	@GetMapping(path = "/customer-form")
	@ModelAttribute("customer-form")
	public Customer getFormv2() {
		return new Customer();
	}
	
	@PostMapping(path = "/processv2")
	public String processFormv2(
			@ModelAttribute(value = "customer", binding = false) Customer customer,
			HttpSession session,
			HttpServletRequest request) {
		
		System.out.println(customer);
		System.out.println("Has customer-form: " + session.getAttribute("customer-form") == null);
		
		return "customer-form-res";
	}
}
