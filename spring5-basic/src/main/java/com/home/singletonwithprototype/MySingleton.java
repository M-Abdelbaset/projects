package com.home.singletonwithprototype;

public class MySingleton {
	
	private MyPrototype myPrototype;
	
	public MyPrototype getMyPrototype() {
		return myPrototype;
	}
	
	public void setMyPrototype(MyPrototype myPrototype) {
		this.myPrototype = myPrototype;
	}
}
