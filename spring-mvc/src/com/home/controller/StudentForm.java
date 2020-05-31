package com.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.home.model.Student;

@Controller
@RequestMapping(path = "/student")
public class StudentForm {
	
	@GetMapping(path = "/form")
	public String getForm(Model model) {
		
		model.addAttribute("student", new Student());
		return "student-form";
	}
	
	@GetMapping(path = "/process")
	public String processForm(@ModelAttribute("student") Student student) {
		
		return "student-form-res";
	}	
}
