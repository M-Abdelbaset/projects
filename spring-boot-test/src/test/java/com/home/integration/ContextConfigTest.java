package com.home.integration;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(ContextConfigTest.A.class)
class ContextConfigTest {

	@Autowired
	private A a;
	
	@Test
	void test() {
		assertNotNull(a);
	}
	
	static class A {
		
	}
}
