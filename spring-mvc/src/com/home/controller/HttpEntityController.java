package com.home.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.home.model.User;

@Controller
@RequestMapping("httpEntity")
public class HttpEntityController {

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void get(HttpEntity<User> user) {
		System.out.println(user.getBody());
		System.out.println(user.getHeaders().getContentType());
	}
}
