package com.home.demo;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class CoachServiceImpl implements CoachService {

	@PostConstruct
	private void init() {
		System.out.println("post construct called ...!!! ");
	}
	
	public String getService() {
		return "service";
	}

}
