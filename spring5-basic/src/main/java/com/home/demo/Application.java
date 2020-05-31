package com.home.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
	//	System.out.println(ctx.getBean("gym", Coach.class).getWorkout());
	//	System.out.println(ctx.getBean("swimming2", Coach.class).getWorkout());
	//	System.out.println(ctx.getBean("static", CoachService.class));
	//	System.out.println(ctx.getBean("static2", CoachService.class));
		System.out.println(ctx.getBean("child", Child.class));
		System.out.println(ctx.getBean("parentTemplate"));
		((ConfigurableApplicationContext)ctx).close();
	}
}
