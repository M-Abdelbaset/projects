package com.home.studentsservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController 
@RefreshScope
public class StudentsController {
	
	@Autowired Environment env;
	
	@Autowired RestTemplate restTemplate;
	
	@GetMapping(path="/students")
	public String getStudentWithGrade() {
		String portNum = restTemplate.getForObject("http://GRADES-SERVICE/grade", String.class);
		return portNum;
	}
	
	@GetMapping(path="/props")
	public String getProps() {
		String props = env.getProperty("my.property") + " - " + env.getProperty("my.property2") 
		+ " - " + env.getProperty("my.propertyX") + " - " + env.getProperty("my.property.application") + " - " + env.getProperty("my.specific");
		return props;
	}
}
