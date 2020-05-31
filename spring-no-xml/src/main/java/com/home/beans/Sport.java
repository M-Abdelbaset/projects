package com.home.beans;

public class Sport {

	private String name;
	private String coach;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCoach(String coach) {
		this.coach = coach;
	}

	@Override
	public String toString() {
		return "Sport [name=" + name + ", coach=" + coach + "]";
	}
}
