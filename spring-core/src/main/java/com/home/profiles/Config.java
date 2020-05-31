package com.home.profiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
//@Profile("default")
public class Config {

	@Bean
	@Profile("dev")
	public void myDevBean() { 
		System.out.println("myDevBean called ... ");
	}
	
	@Bean
	@Profile("qa")
	public void myQaBean() { 
		System.out.println("myQaBean called ... ");
	}
}
