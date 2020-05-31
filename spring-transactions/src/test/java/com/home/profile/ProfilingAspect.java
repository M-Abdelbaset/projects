package com.home.profile;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class ProfilingAspect {
	
	@Around("execution(void com.home.profile.CustomerService.persist())")
	public void stopwatch(ProceedingJoinPoint pjp) {
		
		long before = 0, after = 0;
		
		try {
			before = System.currentTimeMillis();
			pjp.proceed();
			after = System.currentTimeMillis();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		System.out.println("time: " + (after - before));
	}
}
