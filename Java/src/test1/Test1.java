package test1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Test1 {

	interface i{
		default void test() {}
	}
	
	interface ii extends i{
		void test();	
	}
	
	class zzz{
		void abs() {};
	}
	
	abstract class ZZ extends zzz{
		abstract void abs();
		void test() {}
	}
	
	static class A{
		void test() {
			System.out.println("A");
		}
	}
	
	static class B extends A{
		 void test() {
			System.out.println("B");
		}
	}
	
	public static void main(String[] args) {
		int z = 9;
		int[] arr = new int[z];
		A a = new B();
		a.test();
		((A) a).test();
		
		
		try {
			Test1_2 t = new Test1_2();
			Field f = t.getClass().getDeclaredField("prv");
			// f.setAccessible(true);
			System.out.println("field:" + f + " value:" + f.get(t));
		} catch (NoSuchFieldException e1) {
			e1.printStackTrace();
		} catch (SecurityException e1) {
			e1.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");

		// consumes type or it's parents(so that implicit casting is possible)
		Consumer<Object> cons = obj -> System.out.println(obj);
		list.forEach(cons);

		/*****************************************************/

		String s = null;
		Object o = null;
		System.out.println(s + "hello");
		System.out.println(o + "hello");
		// System.out.println(s.concat("hello"));

		/******************************************************/
		// Arrays.aslist
		short ss = 5;
		new Short((byte) 5);
		new Byte((byte) 7);
		new Double(4);
		new Float(5);
		new Character('d');

		System.out.println(s instanceof String);
		String S;
		boolean b = ss == new Integer(4);

		/*********************************************************/

		int x = 0;
		int[] arr2 = null;
		try {
			arr2[x++] = 0;
		} catch (NullPointerException e) {
			// e.printStackTrace();
		}
		System.out.println("x " + x);

		/************************************************************/
		var obj = new Object();
		var c = 'g';

		for (var i = 0; i < 5; i++) {
			int ccc = i;
		}

		var student = new ArrayList<>(); // List<Object> not raw type
		var student2 = new ArrayList<String>();
		// student = student2;

		// var xyx = null;

		try (var writer = new PrintWriter(new File("test.txt"));) {
		} catch (FileNotFoundException e) {
		}

		Consumer<String> consumer = (var data) -> System.out.println(data);

		var stringVar = "";
		Object strObj = stringVar;
		// stringVar = strObj;

		/******************************************************/

		X[] strArr = { new X(1) };
		List<X> list1 = Arrays.asList(strArr);
		List<X> list2 = new ArrayList<Test1.X>(Arrays.asList(strArr));

		list1.get(0).setX(55);
		System.out.println("arr : " + strArr[0]);
		list2.add(0, null);
		System.out.println("arr : " + strArr[0]);

		// list1.add(null);

		/*********************************************************/

		byte sss = 0;
		switch (sss) {
		case (short) 2:
			break;
		case 'd':
			if (2 > 1) {
				return;
			}
		case 1:
		default:
			break;
		}

		String str = "";
		switch (str) {
		case "alpha":
			int inner = Integer.parseInt("dd");
			switch (inner) {
			case 2:
			}

		}

		if (1 < 2)
			label1: {
				System.out.println("first");
				label3: if (1 < 2) {
					System.out.println("second");
					break label1;
				}
				System.out.println("third");
			}

		System.out.println("out");

		
	}

	static class X {

		private int x;

		X(int x) {
			this.x = x;
		}

		public void setX(int x) {
			this.x = x;
		}

		@Override
		public String toString() {

			return x + "";
		}
	}

	/*
	 * var test(var v) {
	 * 
	 * }
	 */
//	static var test = 0;

}
