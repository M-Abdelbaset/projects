package com.home.value;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringCore {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("com/home/value/beans.xml");
		
		System.out.println(context.getBean(Child1.class).getProp1());
//		System.out.println(context.getBean(Child1.class).getProp2());

		context.close();
	}
}
