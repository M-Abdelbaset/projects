package com.home.advice.before;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class _BeforeAdvice {

	/**
	 * An advice is the code we want to run before, after or around certain method(s)
	 */
	
	//@Before("execution(public void run())")
	@Before("execution(public void com.home.advice.before.ServiceDao1.run())")
	public void log() {
		System.out.println("Logging aspect");
	}
	
	@Before("execution(* add*())")
	public void add() {
		System.out.println("Logging add");
	}
	
	@Before("execution(* com.home.advice.before.*.*(..))")
	public void all() {
		System.out.println("Logging all");
	}
}
