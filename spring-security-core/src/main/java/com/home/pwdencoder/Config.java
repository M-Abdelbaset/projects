package com.home.pwdencoder;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Config {

	public static void main(String[] args) {
		
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		String bcryptPwd = encoder.encode("hello 123");
		
		System.out.println(bcryptPwd);
		System.out.println(encoder.matches("hello 123", bcryptPwd)); // true
		System.out.println(encoder.matches("hello 123", "{noop}hello 123")); // true
		
		try {
			System.out.println(encoder.matches("hello 123", "hello 123")); // false
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
