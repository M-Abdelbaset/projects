package com.home.proxy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringCore {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("com/home/proxy/beans.xml");

		System.out.println(ctx.getBean(Config.MySingletonBean.class));
		System.out.println(ctx.getBean(Config.MySingletonBean.class));
		System.out.println(ctx.getBean(Config.MySingletonBean.class));
		System.out.println();
		System.out.println(ctx.getBean(Config.MyProtoBean.class));
		System.out.println(ctx.getBean(Config.MyProtoBean.class));
		System.out.println(ctx.getBean(Config.MyProtoBean.class));
		System.out.println();
		System.out.println(ctx.getBean(Config.MySingletonBean2.class).getMyProtoBean()); // same instance each time
		System.out.println(ctx.getBean(Config.MySingletonBean2.class).getMyProtoBean());
		System.out.println(ctx.getBean(Config.MySingletonBean2.class).getMyProtoBean());
		System.out.println();
		
		////
		
		System.out.println(ctx.getBean(ParentBean.class).getSingletonBean());
		System.out.println(ctx.getBean(ParentBean.class).getSingletonBean());
		System.out.println(ctx.getBean(ParentBean.class).getSingletonBean());
		System.out.println();
		System.out.println(ctx.getBean(ParentBean.class).getPrototypeBean());
		System.out.println(ctx.getBean(ParentBean.class).getPrototypeBean());
		System.out.println(ctx.getBean(ParentBean.class).getPrototypeBean());
		System.out.println();
		System.out.println(ctx.getBean(ParentBean.class).getPFactory().getObject());
		System.out.println(ctx.getBean(ParentBean.class).getPFactory().getObject());
		System.out.println(ctx.getBean(ParentBean.class).getPFactory().getObject());
		System.out.println();
		System.out.println(ctx.getBean(ParentBean.class).getProvider().get());
		System.out.println(ctx.getBean(ParentBean.class).getProvider().get());
		System.out.println(ctx.getBean(ParentBean.class).getProvider().get());
		System.out.println();
		
		// proxies
		System.out.println(ctx.getBean(ParentBean.class).getProxiedSingletonBean());
		System.out.println(ctx.getBean(ParentBean.class).getProxiedSingletonBean());
		System.out.println(ctx.getBean(ParentBean.class).getProxiedSingletonBean());
		System.out.println();
		System.out.println(ctx.getBean(ParentBean.class).getProxiedPrototypeBean());
		System.out.println(ctx.getBean(ParentBean.class).getProxiedPrototypeBean());
		System.out.println(ctx.getBean(ParentBean.class).getProxiedPrototypeBean());
		
		ctx.close();
	}
}
