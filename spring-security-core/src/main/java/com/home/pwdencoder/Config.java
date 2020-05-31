package com.home.pwdencoder;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@ComponentScan
public class Config {

	public static void main(String[] args) {
		
		/*
		 * AnnotationConfigApplicationContext ctx = new
		 * AnnotationConfigApplicationContext(Config.class);
		 */
		
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

		String bcryptPwd = encoder.encode("hello 123");
		System.out.println(encoder.matches("hello 123", bcryptPwd));
		System.out.println(encoder.matches("hello 123", "{noop}hello 123"));
		
		try {
			System.out.println(encoder.matches("hello 123", "hello 123"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
