package com.home.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
@PropertySource("classpath:/resources/countries.properties")
public class AppConfig {
	
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = 
				new ResourceBundleMessageSource();
		messageSource.setBasenames("resources/form-errors"); // extension is not specified
		return messageSource;
	}
}
