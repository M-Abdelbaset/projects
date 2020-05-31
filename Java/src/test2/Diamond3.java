package test2;

import java.util.Arrays;

public class Diamond3 {

	static interface I {
		
		default void get1() {System.out.println("def");}
		
		void get2();
		
		void get3();
		
		default void get4() {}
		
		default void get5() {System.out.println("def 5");}
		
	}
	
	abstract static class C {
		
		public void get3() {}
		
		abstract public void get4();
		
		public void get5() {System.out.println("c 5");}
	}
	
	static class D extends C implements I{
		
		@Override
		public void get2() {}
		
		@Override
		public void get4() {}
		
		public static void main(String[] args) {
			
			C c = new D();
	//		c.get1();
			c.get3();
			c.get5();
			
			int[] arr1 = {'a', 'b', 'c'};
			int[] arr2 =  {'a', 'b', 'a'};
			
			System.out.println(Arrays.compare(arr1, arr2));
		
			
			System.out.println(new StringBuilder("hello")+" worlds");
		}
	}
	
}
