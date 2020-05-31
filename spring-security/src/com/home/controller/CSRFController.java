package com.home.controller;

import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/csrf")
public class CSRFController {

	@GetMapping(path = "/session")
	public void playWithSession(
			@RequestParam(required = false) Boolean invalidate,
			@RequestParam(required = false) Integer interval,
			HttpSession session) {
		
		System.out.println("Session info:");
		System.out.println("Session id: " + session.getId());
		System.out.println("Creation time: " + new Date(session.getCreationTime()));
		System.out.println("Last access date: " + new Date(session.getLastAccessedTime()));
		System.out.println("Max inactive: " + session.getMaxInactiveInterval());
		System.out.println("Is new: " + session.isNew());
		
		if(invalidate != null) {
			session.invalidate();
		}		
		
		if(interval != null) {
			session.setMaxInactiveInterval(5);
		}
	}
	
	@GetMapping(path = "/form")
	public String getCsrf(HttpSession session) {
		return "csrf";
	}
	
	@GetMapping
	@ResponseBody
	public String csrf() {
		return "recieved in GET";
	}
	
	@PostMapping
	@ResponseBody
	public String postCsrf() {
		return "recieved in POST";
	}
	
	@PutMapping
	@ResponseBody
	public String putCsrf() {
		return "recieved in PUT";
	}
}
