package com.home.value;

import org.springframework.beans.factory.annotation.Value;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Child1 {

	@Value("${prop:defaultVal}")
	private String prop1;
	
	@Value("${prop}")
	private String prop2;
}
