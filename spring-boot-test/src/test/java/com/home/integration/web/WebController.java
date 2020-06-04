package com.home.integration.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/web")
public class WebController {
	
	@GetMapping(path="/model")
	String get(Model theModel) {
		theModel.addAttribute("name", "my name");
		
		return "fake";
	}
	
	@PostMapping(path="/valid")
	String validate(@Valid @ModelAttribute Person person, BindingResult bindingResult) {
		return "fake";
	}
	
	@GetMapping(path="/redirect")
	String redirect(RedirectAttributes redirectAttrs) {
		redirectAttrs.addFlashAttribute("attr", "hello");
		return "redirect:dist";
	}
	
	@GetMapping(path="/dist")
	String dist(@ModelAttribute("attr") String val) {
		return val;
	}
	
	@GetMapping(path="/testForward")
	String forward() {
		return "forward:web/model";
	}
}