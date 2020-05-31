package generics;

import java.util.List;

public class Bridge {

	static class MyComparable implements Comparable<String>{

		@Override
		public int compareTo(String o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}

	static class MyComparable2 implements Comparable{

		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	
	static void test2(List<String> l, Comparable<String> c) {
		for (int i = 0; i < l.size(); i++) {
			String item = l.get(i);
			c.compareTo(item);
		}
	}
	
	static void test1(List l, Comparable c) {
		for (int i = 0; i < l.size(); i++) {
			Object item = l.get(i);
			c.compareTo(item);
		}
	}
	
	static void test2() {
		
	}

	
	public static void main(String[] args) {

		Comparable<String> c = new MyComparable();
		c.compareTo("");
		

		Comparable c2 = new MyComparable();
		Object o = "";
		c2.compareTo(o);
			
	}
	
}


