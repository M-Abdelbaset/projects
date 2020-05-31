package test6;

import java.util.Map;

public class Test6_1 {

	public static void main(String[] args) {
		System.out.println('a' - 'A');;
		
		I i = (x) -> x.toLowerCase();
		i = String::toLowerCase;
		
		var bool= false;
		x: while(bool) {
			t: i = null;
		
		
			continue x;
		}
		
		Map.of();		
		
		
		int[][] arr1 = new int[1][1];
		System.out.println(arr1[0]);
		System.out.println(arr1[0].clone());
		
		
		switch(5) {
		case 1:
			var x = 6;
		case 2:
			x = 6;
		}
		
	}
	
	
	
	static interface I{
		default void def1() {}
		default void def2() {}
		default void def3() {}
		String def4(String s);
	}
	
}
