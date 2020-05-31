package com.home;

public class BusinessImpl {
	
	private TestService testService;

	public BusinessImpl(TestService testService) {
		this.testService = testService;
	}
	
	public String sayHello() {
		return "say hello " + testService.getName();
	}
}
