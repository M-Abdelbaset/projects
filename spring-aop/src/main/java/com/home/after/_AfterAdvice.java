package com.home.after;

import java.util.List;
import java.util.ListIterator;
import java.util.stream.Stream;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class _AfterAdvice {
	
	@Pointcut("execution(* com.home.after.ServiceDao.run(boolean))")
	private void afterExp() {}
	
	@AfterThrowing(
			pointcut = "afterExp()", 
			throwing = "ex")
	public void afterThrowing(Exception ex) {
		System.out.println("The exception: " + ex);
	}
	
	@AfterReturning(
			pointcut = "afterExp()",
			returning = "names")
	public void afterReturning(JoinPoint jp, List<String> names) {
		
		Stream.of(jp.getArgs()).forEach(System.out::println);
		ListIterator<String> it = names.listIterator();
		while(it.hasNext()) {
			it.set(it.next().toUpperCase());
		}
		System.out.println(names);
	}
	
	@After("afterExp()")
	public void after() {
		System.out.println("After ... ");
	}
}
