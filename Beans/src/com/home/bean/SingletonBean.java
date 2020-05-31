package com.home.bean;

import javax.ejb.Singleton;

@Singleton
public class SingletonBean {
	
	public void access(boolean delay, int length) throws InterruptedException {
		System.out.println(Thread.currentThread().getId() + " Accessing singleton ... ");	
		if(delay) {
			System.out.println("Delay at: " + Thread.currentThread().getId());
			Thread.sleep(length);
		}
		System.out.println(Thread.currentThread().getId() + " Done accessing singleton ... ");	
	}
}
