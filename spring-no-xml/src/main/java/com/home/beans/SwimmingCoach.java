package com.home.beans;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;

public class SwimmingCoach implements Coach {
	
	private CoachService service;
	@Autowired(required = false)
	public Test test;
	
	public SwimmingCoach() {}
	
	public String getWorkout() {
		return service.getService();
	}

	@Autowired(required = true)
	@Qualifier("coachServiceImpl2")
	public void setService(CoachService service, @Nullable Test test, Optional<Test> test2) {
		System.out.println("ser service called!!!");
		this.service = service;
	}
}
