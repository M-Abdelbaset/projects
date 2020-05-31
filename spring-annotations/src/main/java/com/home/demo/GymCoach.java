package com.home.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("gym")
public class GymCoach implements Coach {
	
	private CoachService service;
	
	public GymCoach(@Autowired CoachService service) {
		this.service = service;
	}
	
	public String getWorkout() {
		return service.getService();
	}
}
