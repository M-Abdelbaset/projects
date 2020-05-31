package com.home.singletonwithprototype;

import java.util.UUID;

public class MyPrototype {
	
	private UUID uuid;
	
	public MyPrototype() {
		this.uuid = UUID.randomUUID();
	}

	@Override
	public String toString() {
		return "MyPrototype [uuid=" + uuid + "]";
	}
}
