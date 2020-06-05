package com.home.studentsservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StudentsController {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Autowired Environment env;
	
	@Autowired RestTemplate restTemplate;
	
	@GetMapping(path="/students")
	public String getStudentWithGrade() {
		String portNum = restTemplate.getForObject("http://GRADES-SERVICE/grade", String.class);
		return portNum;
	}
	
	@GetMapping(path="/props")
	public String getProps() {
		String props = env.getProperty("my.property") + " - " + env.getProperty("my.property2") + " - " + env.getProperty("my.propertyX");
		return props;
	}
}
