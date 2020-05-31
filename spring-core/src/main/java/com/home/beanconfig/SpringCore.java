package com.home.beanconfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringCore {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("com/home/beanconfig/beans.xml");

		context.close();
	}
}
