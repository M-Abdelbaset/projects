package com.home.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SwimmingCoach implements Coach {
	
	private CoachService service;
	
	public SwimmingCoach() {}
	
	public String getWorkout() {
		return service.getService();
	}

	@Autowired
	public void setService(CoachService service) {
		this.service = service;
	}
}
