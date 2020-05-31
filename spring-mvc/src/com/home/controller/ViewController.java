package com.home.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContext;

@Controller
@RequestMapping(path = "/view")
public class ViewController {

	@GetMapping(path = "/redirect/{to}")
	public String getForm(@PathVariable int to) {
		if(to == 1)
			return "redirect:home";
		else
			return "redirect:https://www.youtube.com";
	}
	
	@GetMapping(path = "/redirect/home")
	public String home() throws InterruptedException {
		Thread.sleep(5000);
		return "home";
	}
	
	@GetMapping(path = "/text", consumes = MediaType.TEXT_PLAIN_VALUE)
	public String contentText() {
		return "home";
	}
	
	@GetMapping(path = "/ctx")
	public String contentJson(RequestContext requestContext) {
		System.out.println(requestContext.getLocale());
		System.out.println(requestContext.getTimeZone());
		return "home";
	}
}
