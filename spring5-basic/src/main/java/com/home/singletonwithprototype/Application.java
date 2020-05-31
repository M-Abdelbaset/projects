package com.home.singletonwithprototype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println(ctx.getBean("myPrototypeBean", MyPrototype.class));
		System.out.println(ctx.getBean("myPrototypeBean", MyPrototype.class));
		System.out.println(ctx.getBean("myPrototypeBean", MyPrototype.class));
		System.out.println();
		///////////////////////////////////////////////////////////////////////
		System.out.println(ctx.getBean("mySingleton1", MySingleton.class).getMyPrototype());
		System.out.println(ctx.getBean("mySingleton1", MySingleton.class).getMyPrototype());
		System.out.println(ctx.getBean("mySingleton1", MySingleton.class).getMyPrototype());
		System.out.println();
		///////////////////////////////////////////////////////////////////////
		System.out.println(ctx.getBean("mySingleton2", MyContextAwareSingleton.class).getMyPrototype());
		System.out.println(ctx.getBean("mySingleton2", MyContextAwareSingleton.class).getMyPrototype());
		System.out.println(ctx.getBean("mySingleton2", MyContextAwareSingleton.class).getMyPrototype());
		System.out.println();
		///////////////////////////////////////////////////////////////////////
		System.out.println(ctx.getBean("mySingleton3", MyLookupMethod.class).getMyPrototype());
		System.out.println(ctx.getBean("mySingleton3", MyLookupMethod.class).getMyPrototype());
		System.out.println(ctx.getBean("mySingleton3", MyLookupMethod.class).getMyPrototype());
	}
}
