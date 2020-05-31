package com.home.pointcut;

import org.springframework.stereotype.Component;

@Component
public class ServiceDao1 {

	private String name;
	
	public void run() {
		System.out.println("Sevice dao 1");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
