package com.home.integration;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.home.integration.Config2.A2;

@ContextHierarchy(value = {
		@ContextConfiguration(classes = {Config2.class, B2.class}),
		@ContextConfiguration(locations = "classpath:beans.xml")})
@ExtendWith(SpringExtension.class)
public class ContextHierarchyTest {

	@Autowired
	private A2 a;

	@Autowired
	private B2 b;

	@Autowired
	private C2 c;

	@Test
	void assertAutowired() {
		assertNotNull(a);
		assertNotNull(b);
		assertNotNull(c);
	}

}

@Configuration
class Config2 {

	@Bean
	public A2 a() {
		return new A2();
	}

	static class A2 {
	}
}

@Component
class B2 {
}

class C2 {
}
