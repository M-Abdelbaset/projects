package test2;

import java.util.Arrays;

public class StringBuilderTest {

	String s = this.toString();
	
	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder();
		System.out.println(sb.capacity() + " " + sb.length());
		sb.append("hello");
		System.out.println(sb.capacity() + " " + sb.length());
		sb.append("worldhellos");
		System.out.println(sb.capacity() + " " + sb.length());
		sb.append("newstring");
		System.out.println(sb.capacity() + " " + sb.length());
		
		System.out.println(new StringBuilder('x')); //empty builder!
		
		System.out.println(new StringBuilder("x").codePointAt(0) == (int)'x');
		
		System.out.println(new StringBuilder("hello").delete(0, 2));
		
		System.out.println(new StringBuilder("hello:").append("world", 1, 5));
		
		System.out.println(new StringBuilder("hello").deleteCharAt(2));

		System.out.println(new StringBuilder("hello").insert(1, 'c'));
		System.out.println(new StringBuilder("hello").insert(5, " world"));
		System.out.println(new StringBuilder("hello").insert(2, 2.5f));
		
		System.out.println(new StringBuilder("hello").replace(0, 2, "fe"));
		
		System.out.println(new StringBuilder("hello").reverse());
		
		System.out.println(new StringBuilder("hello").subSequence(0, 3));
		
		System.out.println(sb);
		sb.setLength(2);
		System.out.println(sb);
		
		System.out.println(new StringBuilderTest().s);
	
	}
	
	
	interface I{default void test() {}}
	
	interface I2 extends I{default void test() {}}
	
	static class XY{
		 static void test2() {}
	}
	
	static class XY2 extends XY{
		static void test3() {}
	}
	
	static class X extends XY implements I2{
		static void text() { test2();}
		void text2() {test(); test2();}
		public static void main(String[] args) {
			
		}
	}
	
	
}
