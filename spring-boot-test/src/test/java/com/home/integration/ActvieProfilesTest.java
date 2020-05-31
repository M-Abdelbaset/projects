package com.home.integration;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import lombok.AllArgsConstructor;
import lombok.Getter;

@SpringJUnitConfig(classes = {ActvieProfilesTest.Config1.class, ActvieProfilesTest.Config2.class})
@ActiveProfiles(value="dev")
public class ActvieProfilesTest {

	@Autowired A a;
	
	@Test
	void testProfile() {
		assertThat(a.getVal(), is("dev"));
	}
	
	@Configuration
	@Profile("dev")
	static class Config1 {
		
		@Bean
		A a() {
			return new A("dev");
		}
	}
	
	@Configuration
	@Profile("prod")
	static class Config2 {
		
		@Bean
		A a() {
			return new A("prod");
		}
	}
	
	@Getter @AllArgsConstructor
	static class A {
		final String val;
	}
}
