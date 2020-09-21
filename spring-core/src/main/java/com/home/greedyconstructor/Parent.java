package com.home.greedyconstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Parent {

	@Autowired(required = false)
	public Parent() {
		System.out.println("Default constructor ...");
	}
	
	@Autowired(required = false)
	public Parent(Child1 child) {
		System.out.println("One arg constructor ...");
	}
	
	@Autowired(required = false)
	public Parent(Child1 child1, Child2 child2) {
		System.out.println("Two arg constructor ...");
	}
}
