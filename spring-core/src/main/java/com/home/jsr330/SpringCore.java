package com.home.jsr330;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringCore {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("com/home/jsr330/beans.xml");
		
		Parent parent= context.getBean(Parent.class);
		System.out.println(parent.getChild());
		System.out.println(parent.getChildProvider().get());
		
		context.close();
	}
}
