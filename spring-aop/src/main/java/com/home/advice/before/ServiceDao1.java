package com.home.advice.before;

import org.springframework.stereotype.Component;

@Component
public class ServiceDao1 {

	public void run() {
		System.out.println("Sevice dao 1");
	}
	
	public boolean addAnyAccount() {
		System.out.println("service dao 2 add");
		return false;
	}
}
