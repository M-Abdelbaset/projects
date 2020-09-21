package test_jpa;

import java.util.HashSet;
import java.util.Set;

class Main {
	
	public static void main(String[] args) {
		
		Set<String> stds = new HashSet<>();
		stds.add("one");
		stds.add("two");
		
		stds.forEach(System.out::println);
	}
}

class Student {
	
	String anme;
	public Student(String name) {
		
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}