package com.home.demo;

public class SwimmingCoach implements Coach {
	
	private CoachService service;
	private String name;
	private int experience;
	
	private void init() {
		System.out.println("Initializing this ... ");
	}
	
	private void destroy() {
		System.out.println("Destroying this ... ");
	}
	
	public SwimmingCoach() {}
	
	public String getWorkout() {
		return service.getService() + " by " + name + " with " + experience;
	}

	public void setService(CoachService service) {
		this.service = service;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setExperience(int experience) {
		this.experience = experience;
	}
}
