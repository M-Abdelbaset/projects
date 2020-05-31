package com.home.xmlconfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("com/home/xmlconfig/config.xml");
		
		CustomerService service = ctx.getBean(CustomerService.class);
		TransactionalService transactionalService = ctx.getBean(TransactionalService.class);
	/*	
		service.getCustomersSize();
		service.getCustomersAndWrite();
		service.writeCustomer();
				
		try {
			service.uncheckedRollsback();
		}catch (Exception e) {}

		try {
			service.checkedNotRollback();
		}catch (Exception e) {}
		
		try {
			service.checkedRollbackFor();
		}catch (Exception e) {}
		
		try {
			service.noRollback();
		}catch (Exception e) {}
		*/
		
		service.findAndPersist();
		transactionalService.findAndPersist();
		
		ctx.close();
	}
}
