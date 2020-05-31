package com.home.advice.before;

import org.springframework.stereotype.Component;

@Component
public class ServiceDao2 {

	public void run() {
		System.out.println("Sevice dao 2");
	}
	
	public void addAccount() {
		System.out.println("service dao 2 add");
	}
}
