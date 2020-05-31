package com.home.beanconfig2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {

	@Bean
	@Scope("singleton")
	public MyBean myConfigBean() {
		return new MyBean("inside config class");
	}
	
	@Bean
	@Scope("singleton")
	public MyBean myConfigBeanUsingMyBean() {
		return new MyBean(myConfigBean());
	}
	
	@Bean
	public Parent myConfigBeanUsingInterface() {
		System.out.println("Hello world!");
		return new Child2();
	}
}
