package com.home.joinpoints;

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
				
		service1.run("abc");
		
		ctx.close();
	}
}
