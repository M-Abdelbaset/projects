package com.home.bean;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

@Stateless
public class StatelessBean {
	
	public Date date;
	
	@PostConstruct
	public void init() {
		date = new Date();
	}
	
	public void access(boolean delay, int length) throws InterruptedException {
		System.out.println(Thread.currentThread().getId() + " Accessing singleton ... ");	
		if(delay) {
			System.out.println("Delay at: " + Thread.currentThread().getId());
			Thread.sleep(length);
		}
		System.out.println(Thread.currentThread().getId() + " Done accessing singleton ... ");	
	}
}
