package com.home.msgsource;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class Config {

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource msgSource = new ResourceBundleMessageSource();
		msgSource.setBasenames("msg", "window");
		return msgSource;
	}
}
