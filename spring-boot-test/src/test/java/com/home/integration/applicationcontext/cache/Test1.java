package com.home.integration.applicationcontext.cache;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
@ActiveProfiles(value="dev") // both share same active profile. Hence, both share same context 
public class Test1 {

	@Test
	void testProfile() {
	}
	
}