package generics;

import java.util.List;

public class Ambiguity {

	static class Amb<T, V extends Number>{
		T t;
		V v;
		
		void set(T t) {
			
		}
		
		void set(V v) {
			
		}
			
		void set2(List<String> l) {}
	//	void set2(List<Long> l) {} //causes ambiguity due to erasure
		
	}

	static class A {
		void set2(List<String> l) {}
	}
	static class B extends A{
		//void set2(List<Long> l) {} //causes ambiguity due to erasure
		void set2(List l) {}
	}
	
	static class X<T>{
		
	}
	
	public static void main(String[] args) {
		
		Amb<String, Integer> amb = new Amb<>();
		
		amb.set(5);
		amb.set("");
		
		Amb<?, ?>[] xs = new Amb<?, ?>[] {null};
		Object [] objects = xs;
		objects[0] = "";
		Amb<?, ?> pp = xs[0];
		
		Amb<Integer, Integer> amb2 = new Amb<>();
		
	//	amb2.set(5);
	//	amb2.set("");
	//	amb2.set2(7);
		
		Amb amb3 = null;
		
		amb2 = amb3;
		amb3 = amb;
		
		X[] lists1 = new X[3];
		X<String>[] lists2 = new X[] {new X(), new X<Double>()};
		
		
	
	}
	
}
