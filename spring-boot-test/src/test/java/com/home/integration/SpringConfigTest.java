package com.home.integration;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.home.integration.Config.A;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {Config.class, B.class})
public class SpringConfigTest {

	@Autowired
	private A a;
	
	@Autowired
	private B b;

	@Test
	void assertAutowired() {
		assertNotNull(a);
		assertNotNull(b);
	}
}

@Configuration
class Config {
	
	@Bean
	public A a() {
		return new A();
	}
	
	static class A {}
}

@Component
class B {}


