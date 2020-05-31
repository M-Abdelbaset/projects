package com.home.integration;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.Getter;
import lombok.Setter;

@ExtendWith(SpringExtension.class)
@EnableConfigurationProperties(value = Sport.class)
@TestPropertySource("classpath:sport.properties")
public class LoadPropertiesTest {

	@Autowired
	private Sport sportProps;
	
	@Test
	void testSportProprties() {
		assertAll(() -> assertEquals("football", sportProps.getName()),
				  () -> assertEquals(11, sportProps.getPlayers()));
	}
}

@Setter @Getter
@ConfigurationProperties(prefix = "sport")
class Sport {
	private String name;
	private int players;
}