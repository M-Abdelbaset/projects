package com.home.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class GymCoach implements Coach {
	
	private CoachService service;
	
	public GymCoach(@Autowired CoachService service) {
		this.service = service;
	}
	
	public String getWorkout() {
		return service.getService();
	}
}
