package com.home.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
public class MicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesApplication.class, args);
	}
	
	// method should be messageSource for other files rather than
	// messages.* to work
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = 
				new ResourceBundleMessageSource();
		messageSource.setBasename("msg");
		return messageSource;
	}
}
