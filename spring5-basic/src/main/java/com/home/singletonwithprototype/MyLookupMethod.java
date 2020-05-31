package com.home.singletonwithprototype;

public class MyLookupMethod {
	
	public MyPrototype getMyPrototype() {
		return createPrototype();
	}

	public MyPrototype createPrototype() {
		return null;
	}
}
