package com.home.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@SpringJUnitConfig(classes = ConfigInheritanceTest.Config.class, inheritInitializers = true)
public class ConfigInheritanceTest extends BasetTest {

	@Autowired A a;
	@Autowired A2 a2;
	
	@Test
	void test() {
		assertThat(a.getVal(), is("other"));
		assertThat(a2, notNullValue());
	}
	
	@Configuration
	static class Config {
		
		@Bean
		A a() {
			return new A("other");
		}
	}
}

@SpringJUnitConfig(classes = BasetTest.BaseConfig.class)
class BasetTest {

	@Configuration
	static class BaseConfig {
		
		@Bean
		A a() {
			return new A("base");
		}
		
		@Bean
		A2 a2() {
			return new A2();
		}
	}
}

@Getter @AllArgsConstructor
class A {
	final String val;
}

class A2 {}

