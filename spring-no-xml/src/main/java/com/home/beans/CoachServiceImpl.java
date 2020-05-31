package com.home.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:sports.properties")
public class CoachServiceImpl implements CoachService {

	private final String id;
	
	@Value("${sport.name}")
	private String name;

	@Value("${sport.coach}")
	private String coach;

	private Sport sport;
	
	public CoachServiceImpl(String id) {
		this.id = id;
	}
	
	public String getService() {
		return "service: " + id + " " + name + " " + coach + " " + sport;
	}
}
