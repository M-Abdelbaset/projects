package generics;

public class Init {

	static class X<T>{
		T t;
		
		X(){}
		
		X(T t){
			this.t = t;
		}
		
		void set(T t) {
			this.t = t;
		}
		
		T get() {
			return t;
		}
		
	}
	
	abstract class Y implements Comparable{
		
	}
	static char c;
	public static void main(String args[]) {
		X<?> s = new X<>();
	//	s.t = "";
		double d = 100-000-0;
		X<Integer> s2 = new X<Integer>();
		s2.t = 12;
		
		X s3 = new X(123);
		X s4 = new X("222");
		s3 = s4;
		
		X<? extends String> s5 = new X<>("");
		s5.set(null);
	//	s5.set("");
		
		
		X[] xss = new X[2];
		xss[0] = s3;
		System.out.println("c"+c+"c");
		
		
		int x = 1234567890;
		float y = x;
		System.out.println(x - y);
	
		Integer i1 = 1;
		Integer i2 = 1;
		Long l1 = 1l;
		Byte b = 1;
		
		System.out.println(i1==1);
		System.out.println(i1==i2);
		System.out.println(i1.equals(b));
		System.out.println(i1.equals(l1));
		
		byte bb = 1;
		char cc = 'f';
		
	//	c xx = 9;
		switch(';') {
			default: i1=3;
		//	case bb: i1=29;
		}
		String String ="";
	//	String.substr
		
		bb %= 7;

		
		int[] intarr = new int[0];
		intarr.clone();
		int[][] arr;
	//	arr[0] = new int[]{};
	}
	
}
