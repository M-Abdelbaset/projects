package generics;

import java.util.ArrayList;
import java.util.List;

public class OverrideRules {

	//17, 19, 58
	
	static class A <T> {
		
	}
	
	static class B <T> extends A<T> {
		
	}
	
	static class C <T, V> extends B <T> {
		
	}
	
	public static void main(String[] args) {
		
		List<Number> numbersList = new ArrayList<Number>();
		numbersList.add(1);
		numbersList.add(1.0);
		
		List<Double> doublesList = new ArrayList<Double>();
//		doublesList.add(1); //not substitute List<Number> here, hence, not a sub type!
		doublesList.add(1.0);
		
		A<String> a1 = new B<String>();
//		a1 = new B<Long>(); // must have same type of the common parameter
		
		
		A<String> a2 = new C<String, Long>();
//		a2 = new C<Long, Long>(); //same here!
		
		
		/***********************************************/
		//wild cards
		
		List<? extends MyDouble> anyExtendsDouble = new ArrayList<MyDouble>();
		MyDouble e = new MyDouble();
//		anyExtendsDouble.add(e);
		
		List<? super MyDouble> anySuperDouble = new ArrayList<Object>();
		anySuperDouble.add(new MyDouble());
	}
	
	
	static class MyDouble {}

	static class MyDouble1 extends MyDouble{}
	
	static class MyDouble2 extends MyDouble{}

}