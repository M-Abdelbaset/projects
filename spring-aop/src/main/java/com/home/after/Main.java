package com.home.after;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class Main {

	public static void main(String[] args) {
		
		try (AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(Main.class)){
			
			ServiceDao service1 = ctx.getBean(ServiceDao.class);
			service1.run(false);
			service1.run(true);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
