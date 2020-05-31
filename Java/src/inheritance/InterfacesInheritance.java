package inheritance;
public class InterfacesInheritance {

	static interface I{
		static void test2() {}
		default void def() {}
	}
	
	static interface II extends I{
		 void test2() ;
		 
		 @Override
		 default void def() {}
	}
	
	static class XYZ implements I, II{

		@Override
		public void test2() {}
	}
	
	static class X{
		static void test() {}
	}
	
	static class Y extends X{
		void test2() {Y.test();}
	}
	
	static class C implements II{

		@Override
		public void test2() {
			
		}
		
		public static void main(String[] args) {
			Y.test();
			
		}
		
	}	
}