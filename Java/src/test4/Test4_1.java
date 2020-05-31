package test4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Test4_1 {

	static class TestClass {
//		void probe(int... x) {System.out.println("In ...");} //1

//		void probe(Integer x) {System.out.println("In Integer");} //2

		void probe(long x) {System.out.println("In long");} //3

		void probe(Long x) {System.out.println("In LONG");}//4

		public final static void main(String[] args) {
		
			Integer a = 4;
			new TestClass().probe(a); // 5
			
			int b = 4;
			new TestClass().probe(b); // 6
			
		};
		
		
		
	};
	
	public final static void main(String[] args) {
	
		try {
			throw null;
		}catch (Exception ex) {
			System.out.println(ex);
			System.out.println(ex == null);
		//	ex.printStackTrace();
		}
		
		int x=0, y=0;
		int z = x = y = 9;
		
		List<String> l = new ArrayList<String>();
		l.add("1");
		l.add("2");
		l.add(1, "3");
		System.out.println(l);
		l.set(0, "3");
		System.out.println(l);
		
		char c = 65535;
		
		switch(2) {
		default: System.out.println(22);
		case 2: System.out.println(2);
		}
		
	};
	
}
