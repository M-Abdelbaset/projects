package test2;

public class Diamond2 {

	public static String X = "";
	static interface I {
		
		default void get1() {System.out.println("def");}
		
		void get2();
		
		void get3();
		
		default void get4() {}
		
	}
	
	abstract static class C{
		
		public void get3() {}
		
		abstract public void get4();
		
	}
	
	static class D implements I{
		
		@Override
		public void get2() {}
		
		@Override
		public void get3() {}
		
		public static void main(String[] args) {
			
			I c = new D();
			c.get1();
			c.get3();
			
		}
	}
	
}
