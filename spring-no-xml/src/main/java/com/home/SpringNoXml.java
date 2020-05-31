package com.home;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.home.beans.Coach;
import com.home.beans.SwimmingCoach;

@Configuration
@ComponentScan
public class SpringNoXml {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(SpringNoXml.class);
		
		Coach swimmingCoach = ctx.getBean("swimmingCouch", Coach.class);
		System.out.println(swimmingCoach.getWorkout());
		System.out.println(((SwimmingCoach)swimmingCoach).test);
		Coach gymCoach = ctx.getBean("gymCouch", Coach.class);
		System.out.println(gymCoach.getWorkout());
		
		ctx.close();
	}
}
