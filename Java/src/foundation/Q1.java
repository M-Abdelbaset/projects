package foundation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Q1 {

	 int x;
	 Object o;
	 static float y;
	 static Object oo;
	 
	public static void main(String[] args) {

		int x;
		Object o;
		int i = 111111111;
		float f = i;
		System.out.println(f);
		System.out.println(i - (int) f);

		
		//		System.out.println(o);
		new Q1().test();
		
		byte b = -66;
		final byte finalByte = -127;
		short s = -432;
		final short finalShort = -1;
		int in = -2121;
		final int finalI = 21858;
		long l = 21l;
		float fl = 9.5f;
		double d = 4d;
		
		char c = 9;
		final char finalChar = 474;
		
		l = c;
		c = (char)l;
		
		in = c;
		c = (char)in;
		c = finalI;
		
		s = (short)c;
		c = (char)s;
	//	c = finalShort;
		
		b = (byte)c;
	//	b = finalChar;
		c = (char)b;
	//	c = finalByte;
		
		f = c;
		c = (char)f;
		
		d = c;
		c = (char)d;
		
		String ss="";
		
		Long[] arr = new Long[4];
		Object[] arr2 = arr;
		if(arr instanceof Object) {
			System.out.println("Object");
		}
		
		if(arr instanceof Object[]) {
			System.out.println("Object");
		}
		
		if(arr instanceof Number[]) {
			System.out.println("Object");
		}
		
		if(arr instanceof Long[]) {
			System.out.println("Object");
		}
		
		
	}

	void test() {
		System.out.println(x+""+o+""+y+""+oo);
	}
	
	static class A {
		
		public A(){
			
		}
		void test() throws RuntimeException {

		}
	}

	static class B extends A {

		@Override
		void test() throws NullPointerException {

		}
	}

}
