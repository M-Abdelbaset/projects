package com.test.callback;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;

public class AnotherParentEntityListener {

	@PostPersist
	public void postPersist(ParentWithCallbackMethods obj) {
		System.out.println("Object's state: " + "id: " + obj.getId() + ", and version: " + obj.getVersion());
	}
	
	@PostLoad
	public void postLoad2(ParentWithCallbackMethods obj) {
		System.out.println("Another postLoad callback method ... ");
	}
}
