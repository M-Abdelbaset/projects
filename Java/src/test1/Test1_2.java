package test1;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class Test1_2 {

	int x = 1, z = 1;
	Object[] arr = new Object[3];
	Object[] arr2 = {};
	private int prv =101;
	Test1_2() {}
	
	
	public static void main(String[] args) {

		int x = 2;
		int y = 1;
		
		for (x = 3; x < 5; x++) {}

		/****************************/

		List<String> list = new LinkedList<String>();
	
		Collections.sort(list);
		Collections.shuffle(list);
		

		/************************************/
		
		int[] arr = {1};
		arr[0] =1;
		
		int [][] arr2d = new int[2][5];
		arr2d[0] = new int[4];
		System.out.println(arr2d.length + arr2d[0].length);
		
		int[][] arr2d2 = {  {}, {0, 2}, {2, 2, 2} };
		System.out.println(arr2d2[0].length);
		System.out.println(arr2d2[1][0]);
		
		int[][][] arr3d = new int[1][][];
		arr3d[0] = new int[2][];
		arr3d[0][0] = new int[1];
		System.out.println(arr3d[0][0][0]);
		System.out.println(arr3d.length);
		
		int[][][] arr3d2 = {};
		System.out.println(arr3d2.length);
		

		int[][][] arr3d3 = { {  {1, 1}, {1, 1, 5}  }, { {3, 4, 5} }, { {6, 7, 8} }, null };
		System.out.println(arr3d3.length);		
		System.out.println("**"+arr3d3[0].length+arr3d3[1].length+arr3d3[2].length);
		System.out.println(arr3d3[0][0][1]);
		
		/**********************************************/
		
		Test1_2 t = new Test1_2();
		System.out.println(t.arr[0] +""+ t.arr[1] + t.arr[2]);
	//	System.out.println(t.arr2[0]);
		
		/************************************************/
		
		Integer intObj = 2;
		switch(intObj) {}
		
		/*********************************************/
		
		Function<Integer, String> conv = Integer::toHexString;
		conv.apply(5);

		/***************************************/
		
		String str = "d ";
		System.out.println(str.isBlank());

		/************************************/
		StringBuilder builder = new StringBuilder();
//		builder.append("hello").insert(6, "x");
		System.out.println(builder.toString());
		List l = List.of("", "");
		Set s = Set.of();
		
		/**********************************/
		char arr2[][] = new char[][] { {1, 2}, {3, 4} };
		var arr3 = new int[5];
		
		/*********************************/
		
		P p = new C();
		System.out.println(p.x + " " + p.getX());
		C c = (C) p;
		System.out.println(c.x + " " + c.getX());
		
		/***********************************/
		
		int[] arr1  = {1,2,3};
		int[] arr22 = {1,2,3,4};
		System.out.println(Arrays.compare(arr1, arr22));
		System.out.println(Arrays.compareUnsigned(arr1, arr22));

		System.out.println(Arrays.mismatch(arr1, arr22));

		
		System.out.println(new StringBuilder("world").insert(0, "hello ").toString());
		
		int k = 1;
		System.out.println(k+= 3+ (k = k+1));
		
	}



	static class P{
		int x = 1;
		int getX(){return x;}
	}
	
	static class C extends P{
		int x = 2;
		int getX(){return x;}
	}
	
	
}
