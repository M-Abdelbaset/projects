package com.home.joinpoints;

import org.springframework.stereotype.Component;

@Component
public class ServiceDao1 {

	public void run(String name) {
		System.out.println("Sevice dao :" + name);
	}
}
