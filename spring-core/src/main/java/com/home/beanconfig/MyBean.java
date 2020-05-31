package com.home.beanconfig;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class MyBean {

	public MyBean(String name) {
		this.name = name;
	}
	
	private String name;
}
