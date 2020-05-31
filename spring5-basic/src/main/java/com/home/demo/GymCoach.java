package com.home.demo;

public class GymCoach implements Coach {
	
	private CoachService service;
	
	public GymCoach(CoachService service) {
		this.service = service;
	}
	
	public String getWorkout() {
		return service.getService();
	}

}
