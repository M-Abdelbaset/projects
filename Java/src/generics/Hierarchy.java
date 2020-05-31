package generics;

import java.io.Serializable;

public class Hierarchy {
	
	static class Parent<T extends Object>{
		
	}
	
	static class Child<V extends Serializable> extends Parent<V>{
		
	}
	
	public static void main(String[] args) {
		
		Child<String> c = new Child<String>();
		Child<Float> c2 = new Child<Float>();
		
		Parent<String> p = new Parent<String>();
		Parent<Object> p2 = new Parent<Object>();
		Parent<?> p3 = new Parent<Number>();
		Parent<? extends Number> p4 = new Parent<Long>();
		
		if(c instanceof Parent<?>) {
			System.err.println("ffds");
		}
		
		if(c instanceof Parent) {
			System.err.println("ff");
		}
		
		p = c;
		//p2 = c;
		p3 = c;
		p4 = c2;
		
		c = (Child<String>)p;

	}
	
}
