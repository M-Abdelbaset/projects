package com.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@ConfigurationPropertiesScan
public class Main {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Main.class, args);
		YMLProps ymlProps = applicationContext.getBean(YMLProps.class);
		System.out.println(ymlProps);
	}

}