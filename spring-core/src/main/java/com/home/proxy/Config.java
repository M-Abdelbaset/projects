package com.home.proxy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import lombok.Getter;
import lombok.Setter;

@Configuration
public class Config {

	@Bean
	@Scope("prototype")
	public MyProtoBean myProtoBean() {
		return new MyProtoBean();
	}
	
	@Bean
	@Scope("singleton")
	public MySingletonBean mySingletonBean() {
		return new MySingletonBean();
	}
	
	@Bean
	@Scope("singleton")
	public MySingletonBean2 mySingletonBean2() {
		return new MySingletonBean2(myProtoBean());
	}
	
	public static class MySingletonBean {}
	
	public static class MyProtoBean {}	
	
	@Setter @Getter
	public static class MySingletonBean2 {
		
		private MyProtoBean myProtoBean;
		
		public MySingletonBean2(MyProtoBean myProtoBean) {
			this.myProtoBean = myProtoBean;
		}
	}
}
