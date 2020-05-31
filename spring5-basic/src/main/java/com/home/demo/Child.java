package com.home.demo;

public class Child {

	private String name;
	private int age;
	private String lname;
	
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
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	@Override
	public String toString() {
		return "Child [name=" + name + ", age=" + age + ", lname=" + lname + "]";
	}
	
}
