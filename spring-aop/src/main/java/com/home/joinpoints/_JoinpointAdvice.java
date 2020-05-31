package com.home.joinpoints;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class _JoinpointAdvice {

	@Pointcut("execution(* com.home.joinpoints.*.*(..))")
	private void all() {}
	
	@Before("all()")
	public void log(JoinPoint jp) {
		
		System.out.println(jp.getKind());
		System.out.println(jp.getTarget());
		System.out.println(jp.getThis());
		
		System.out.println("log ...");
	}
}
