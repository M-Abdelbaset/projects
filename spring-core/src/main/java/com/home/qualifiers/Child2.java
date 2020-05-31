package com.home.qualifiers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier("c22")
@Component
public class Child2 implements Parent {

	public String get() {
		return "child 2";
	}
}
