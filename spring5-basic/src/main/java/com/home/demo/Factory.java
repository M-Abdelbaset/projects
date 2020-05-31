package com.home.demo;

public class Factory {

	public static CoachServiceImpl create(String s) {
		System.out.println(s);
		return new CoachServiceImpl();
	}
	
	public CoachServiceImpl create2(String s) {
		System.out.println(s);
		return new CoachServiceImpl();
	}
}
