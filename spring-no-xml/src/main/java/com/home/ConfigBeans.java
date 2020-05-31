package com.home;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.home.beans.Coach;
import com.home.beans.CoachService;
import com.home.beans.CoachServiceImpl;
import com.home.beans.GymCoach;
import com.home.beans.SwimmingCoach;

@Configuration
public class ConfigBeans {
	
	@Bean
	public CoachService coachServiceImpl() {
		return new CoachServiceImpl("1");
	}
	
	@Bean
	public CoachService coachServiceImpl2() {
		return new CoachServiceImpl("2");
	}
	
	@Bean
	public Coach gymCouch() {
		return new GymCoach(coachServiceImpl());
	}
	
	@Bean
	public Coach swimmingCouch() {
		return new SwimmingCoach();
	}
}
