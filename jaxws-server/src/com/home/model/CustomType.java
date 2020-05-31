package com.home.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "CustomType")
@XmlType(propOrder = {"age", "name"}, name = "Type")
public class CustomType {
	private String name;
	private int age;
	
	public CustomType() {}
	
	public CustomType(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@XmlElement(name = "_name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
