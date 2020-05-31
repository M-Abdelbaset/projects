package com.home.jsr330;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.inject.Provider;

import org.springframework.lang.Nullable;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@ManagedBean
public class Parent {
	
	@Inject
	private Child child;
	
	@Inject
	private Child2 child2;
	
	@Inject
	private Provider<Child> childProvider;
	
	@Inject
	public void test(@Nullable Child2 child2) {
		System.out.println(child2);
	}
}
