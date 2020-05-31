package com.home.qualifiers;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringCore {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("com/home/qualifiers/beans.xml");
		
		System.out.println(context.getBean(Service.class).getP1().get());
		System.out.println(context.getBean(Service.class).getP2().get());
		System.out.println(context.getBean(Service.class).getChild3().get());
		
		for(Parent p : context.getBean(Service.class).getChildGroup())
			System.out.println(p.get());
		
		System.out.println(((Parent)context.getBean(Service.class).getChild2()).get());
		
		context.close();
	}
}
