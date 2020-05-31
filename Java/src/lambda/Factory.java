package lambda;

public class Factory {

	interface NoArg<V>{
		V create();
	}
	
	interface OneArg<T, V>{
		V create(T t);
	}
	
	interface TwoArg<T, V, L>{
		L create(T t, V v);
	}
	
	interface NoArgArray<V>{
		V create(int n);
	}
	
	interface NoArgArrayV2<V>{
		V create(int n, int m);
	}
	
	public static <V> V factory1(NoArg<V> ref) {
		return ref.create();
	}
	
	public static <T, V> V factory2(OneArg<T, V> ref, T t) {
		return ref.create(t);
	}
	
	public static <T, V, L> L factory3(TwoArg<T, V, L> ref, T t, V v) {
		return ref.create(t, v);
	}
	
	static class A {
		public A() {
			System.out.println("A created");
		}
	}
	
	static class AA{
		public AA() {
			System.out.println("AA created");
		}
	}
	
	static class B<T> {
		public B(T t) {
			System.out.println("B of:" + t + " created");
		}
	}
	
	static class C<T, V> {
		public C(T t, V v) {
			System.out.println("C of:" + t + " and " + v + " created");
		}
	}
	
	public static void main(String[] args) {
		
		NoArg<A> noArg1 = A::new;
		NoArg<AA> noArg2 = AA::new;
		
		A a = factory1(noArg1);
		AA aa = factory1(noArg2);
		
		/***************************/
		
		OneArg<String, B<String>> oneArg1 = B<String>::new;
		B b = factory2(oneArg1, "hello");
		
		/*****************************/
		
		TwoArg<String, Integer, C<String, Integer>> twoArg1 = C<String, Integer>::new;
		C<String, Integer> c = factory3(twoArg1, "hello", 123);
		
		/**********************************/
		
		NoArgArray<A[]> aArr = A[]::new;
		A[] arr = aArr.create(2);
		arr[0] = new A();
		arr[1] = new A();
		System.out.println(arr[0] + " " + arr[1]);
		
	}
	
	
}
