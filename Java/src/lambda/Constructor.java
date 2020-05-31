package lambda;

public class Constructor {

	interface I{
		A newInstance(int x);
	}
	
	interface II<T>{
		B<T> newInstance(String x);
	}
	
	static class A{
		int x;
		
		public A() {}
		
		public A(int x) {
			System.out.println("cons called");
			this.x = x;
		}
		
	}
	
	static class B<T>{
		T t ;
		
		public B(T t) {
			System.out.println("cons called");
			this.t = t;
		}
		
	}
	
	public static void main(String[] args) {
		I i = A::new;
		i.newInstance(100);
		
		II<String> i2 = B::new;
		i2.newInstance("");
	}
	
}
