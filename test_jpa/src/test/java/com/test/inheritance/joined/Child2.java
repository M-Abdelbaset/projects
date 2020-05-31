package com.test.inheritance.joined;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Child2")
@Table(name = "child2")
public class Child2 extends Parent {

	public String child2Name;
	
	public Child2(String parentName, String childName) {
		this.parentName = parentName;
		this.child2Name = childName;
	}		
}
