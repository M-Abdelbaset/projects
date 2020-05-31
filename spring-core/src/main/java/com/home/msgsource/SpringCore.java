package com.home.msgsource;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringCore {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("com/home/msgsource/beans.xml");
		
		MessageSource msgSource = (MessageSource) context;
		System.out.println(msgSource.getMessage("msg1", null, "Default", Locale.ENGLISH));
		System.out.println(msgSource.getMessage("msg1", null, "Default", Locale.FRENCH));
		System.out.println(msgSource.getMessage("window", new String[] {"home", "red"}, 
				"Default", Locale.ENGLISH));
		
		context.close();
	}
}
