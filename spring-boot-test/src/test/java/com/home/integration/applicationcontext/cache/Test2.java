package com.home.integration.applicationcontext.cache;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
@ActiveProfiles(value="dev2")
public class Test2 {

	@Test
	void testProfile() {
	}
	
}