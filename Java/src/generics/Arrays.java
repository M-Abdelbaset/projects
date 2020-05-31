package generics;

public class Arrays {

	public static void main(String[] args) {
		
		X<?, ?>[] xs1 = new X<?, ?>[] {};
		X<?, ?>[] xs2 = new X[] {};
		X[]       xs3 = new X[] {};
//		X<?, ?>[] xs4 = new X<?, String>[] {};
//		X<?, ?>[] xs5 = new X<String, String>[] {};
//		X<?, String>[] xs6 = new X<?, ?>[] {};
//		X<Object, Object>[] xs7 = new X<?, ?>[] {};

		
	}
	
	class X<T, V>{
		
		
		
	}
	
}
