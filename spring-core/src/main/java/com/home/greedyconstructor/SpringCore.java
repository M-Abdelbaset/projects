package com.home.greedyconstructor;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringCore {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("com/home/greedyconstructor/beans.xml");
		
		context.close();
	}
}
