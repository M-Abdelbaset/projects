package com.home.beanconfig2;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class MyBean {

	private String name;
	
	public MyBean(MyBean myBean) {
		this.name = myBean.getName();
		System.out.println(this.name);
	}
	
	public MyBean(String name) {
		this.name = name + ":" + UUID.randomUUID().toString();
		System.out.println(this.name);
	}
}
