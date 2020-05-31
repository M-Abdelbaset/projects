package com.test.callback;

import java.util.Date;

import javax.persistence.PostLoad;
import javax.persistence.PrePersist;

public class ParentEntityListener {

	@PrePersist
	public void prePersist(ParentWithCallbackMethods obj) {
		obj.setLastUpdated(new Date());
	}
	
	@PostLoad
	public void postLoad(ParentWithCallbackMethods obj) {
		System.out.println("Object's state: " + "id: " + obj.getId() + 
				", and name: " + obj.getName() +
				", and version: " + obj.getVersion() + 
				", and lastUpdated: " + obj.getLastUpdated());
	}
}
