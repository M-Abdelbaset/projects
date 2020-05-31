package com.home.beanconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Bean
	public MyBean myBean() { // cannot be private or final
		System.out.println("Is private bean visisble: " + privateBean.getName());
		return new MyBean("inside config class");
	}
	
	@Autowired
	@Qualifier("privateBean")
	private MyBean privateBean;
}
