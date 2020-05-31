package com.home.beanconfig;

import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Setter @Getter
public class Child1 {

	@Autowired
	private MyBean myBean;
	
	@Autowired
	@Qualifier("privateBean")
	private MyBean privateBean;
	
	@Value("#{privateBean.name}")
	public String name;
	
	@Bean
	private MyBean privateBean(InjectionPoint injectionPoint) {
		System.out.println(injectionPoint.getMember());
		return new MyBean("private bean");
	}
	
	@Bean
	@Scope("prototype")
	public MyBean prototypeBean(InjectionPoint injectionPoint) {
		return new MyBean(injectionPoint.getMember().toString() 
				+ ":" + injectionPoint.getClass().toString());
	}
}
