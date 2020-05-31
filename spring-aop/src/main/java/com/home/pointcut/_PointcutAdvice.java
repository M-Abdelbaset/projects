package com.home.pointcut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class _PointcutAdvice {

	@Pointcut("execution(* com.home.pointcut.*.*(..))")
	private void all() {}
	
	@Pointcut("execution(* com.home.pointcut.*.set*(..))")
	private void setters() {}

	@Pointcut("execution(* com.home.pointcut.*.get*(..))")
	private void getters() {}
	
	@Before("all() && !(getters() || setters())")
	public void allButSettersAndGetters() {
		System.out.println("allButSettersAndGetters");
	}
}
