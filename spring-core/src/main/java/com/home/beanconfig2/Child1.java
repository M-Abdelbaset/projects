package com.home.beanconfig2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;

@Component
@Setter @Getter
public class Child1 {

	@Bean
	@Scope("singleton")
	public MyBean myChildBean() {
		return new MyBean("inside child1 class");
	}
	
	@Bean
	@Scope("singleton")
	public MyBean myChildBeanUsingMyBean() {
		return new MyBean(myChildBean());
	}
}
