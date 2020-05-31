package com.home.advice.before;

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
		ServiceDao2 service2 = ctx.getBean(ServiceDao2.class);
		
		service1.run();
		service1.addAnyAccount();
		service2.run();
		service2.addAccount();
		
		System.out.println(service1.getClass().getName());
		System.out.println(service2.getClass().getName());
		
		ctx.close();
	}
}
