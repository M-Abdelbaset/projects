package com.home.exceptiontranslation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;

@Configuration
@ComponentScan
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class Main extends BasicConfig {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(Main.class);	
		
		System.out.println(ctx.getBean(CustomerDao.class).getClass().getName());
		ctx.getBean(CustomerService.class).save();
		
		ctx.close();
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor PersistenceExceptionTranslationPostProcessor(){
		return new PersistenceExceptionTranslationPostProcessor();
	}
}
