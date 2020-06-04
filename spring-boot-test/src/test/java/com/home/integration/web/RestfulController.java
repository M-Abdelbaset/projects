package com.home.integration.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class RestfulController {
	
	@Autowired ServiceImpl service;
	
	@GetMapping(path = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
	String getJson(@Nullable @RequestParam("key") String value) {
		return new StringBuilder()
				.append("{")
				.append("\"" + service.get() + "\"").append(":")
				.append("\"" + value+ "\"")
				.append("}")
				.toString();
	}
	
	@GetMapping(path = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
	Person xml() {
		return new Person("one", 111);
	}
	
	@PostMapping(path = "/session/save")
	void saveSessionData(HttpSession session, @RequestBody String body) {
		session.setAttribute("key", body);
	}
	
	@GetMapping(path = "/session/get")
	String getSessionData(HttpSession session) {
		return session.getAttribute("key").toString();
	}
}