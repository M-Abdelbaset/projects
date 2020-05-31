package com.home.around;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class _AroundAdvice {

	@Around("execution(* com.home.around.ServiceDao.run(boolean))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		
		System.out.println("before execution");
		
		Object res = null;
		try {
			res = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		//	res = Collections.EMPTY_LIST;
			throw new IllegalStateException(e);
		}
		
		System.out.println("after execution");
		
		return res;
	}
}
