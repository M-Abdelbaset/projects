package com.home.beanconfig2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringCore {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("com/home/beanconfig2/beans.xml");

	//	System.out.println("\n\n");
	//	System.out.println(context.getBean("config", Config.class).myConfigBean().getName());
	//	System.out.println(context.getBean("child1", Child1.class).myChildBean().getName());

	//	System.out.println(context.getBean(TestInterfaceBeans.class).getChild2());
	//	System.out.println(context.getBean(TestInterfaceBeans.class).getChild22());
		
		context.close();
	}
}
