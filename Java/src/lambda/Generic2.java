package lambda;

import java.util.List;
import java.util.function.Predicate;

public class Generic2 {
	
	interface I<T>{
		void test(T t);
	}
	static <T> void test(T t){
		System.out.println(t.getClass().getTypeName());
	}
		
	
	interface I2{
		void test(String s);
	}
	static <T> void test2(T t){
		System.out.println(t.getClass().getTypeName());
	}
	
	interface I3<T extends Number>{
		void test(T t);
	}
	static <T> void test3(T t){
		System.out.println(t.getClass().getTypeName());
	}
	
	static class X<T>{
		void test(T t){
			System.out.println(t.getClass().getTypeName());
		}
	}
	

	
	public static void main(String[] args) {
		
		I<String> i = Generic2::<String>test;
		i.test("");
		
		I2 i2 = Generic2::<String>test2;
		i2.test("");
		i2 = Generic2::test2;
		i2.test("");
		
		I3 i3 = Generic2::test3;
		i3.test(5);
//		i3.test("");
		i3 = Generic2::<Number>test3;
		I3<Integer> i33 = Generic2::<Integer>test3;

		i33.test(5);
//		I3<String> i33 = Generic2::<String>test3;
		
		I<String> i5 = new X<String>()::test;
				
	}
	
}
