package com.test.inheritance.singletable;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@Entity(name = "Child1")
@Table(name = "child1")
@NoArgsConstructor
public class Child1 extends Parent {

	public String child1Name;
	
	public Child1(String parentName, String childName) {
		this.parentName = parentName;
		this.child1Name = childName;
	}
}
