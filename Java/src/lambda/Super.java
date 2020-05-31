package lambda;

public class Super {

	interface  I{
		int test();
	}
	
	static class A {
		int test() {
			return 1;
		}
	}
	
	static class B extends A {

		@Override
		int test() {
			return 2;
		}
		
		void test2() {
			A a = B.this;
			System.out.println(a);
			
			B b = B.this;
			System.out.println(b);
			
			I i1 = super::test;
			System.out.println(i1.test());
			
			I i2 = B.super::test;
			System.out.println(i2.test());
			
			I i3 = this::test;
			System.out.println(i3.test());			
			
		}
		
	}
	
	public static void main(String[] args) {
		B b = new B();
		b.test2();
		
	}
	
}
