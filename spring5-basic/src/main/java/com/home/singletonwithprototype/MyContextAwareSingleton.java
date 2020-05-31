package com.home.singletonwithprototype;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyContextAwareSingleton implements ApplicationContextAware {

	private ApplicationContext applicationContext;
	
	public MyPrototype getMyPrototype() {
		return applicationContext.getBean("myPrototypeBean", MyPrototype.class);
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
