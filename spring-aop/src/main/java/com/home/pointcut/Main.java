package com.home.pointcut;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class Main {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(Main.class);
		
		ServiceDao1 service1 = ctx.getBean(ServiceDao1.class);
		
		System.out.println();
		
		service1.run();
		service1.setName("name");
		service1.getName();
		
		ctx.close();
	}
}
