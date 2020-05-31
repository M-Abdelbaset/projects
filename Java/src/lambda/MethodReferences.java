package lambda;

public class MethodReferences {

	interface I{
		boolean test(int x);
	}
	
	interface I2{
		int get();
	}
	
	interface I3{
		int get(Impl impl);
	}
	
	interface I4{
		int compare(Impl impl1, Impl impl2);
	}
	
	interface I5{
		boolean get(Impl impl);
	}
	
	static class Impl{
		
		int x;
		
		static public boolean test(int x) {
			return x > 0;
		}	

		public Impl() {}
		
		public Impl(int x) {
			this.x = x;
		}
		
		public int get() {
			return x;
		}
		
		public int getDefaultX() {
			System.out.println(this.x);
			return -1;
		}
		
		public int compare(Impl impl2) {
			return this.x - impl2.x;
		}
		
	}
	
	public static void main(String[] args) {
		
		//static method reference
		I i = Impl::test;
		System.out.println(i.test(-1));
		
		//instance method reference with object reference
		Impl impl1 = new Impl();
		Impl impl2 = new Impl(22);
		I2 i2 = impl1::get;
		I2 i22 = impl2::get;
		System.out.println(i2.get());
		System.out.println(i22.get());
		
		//test error reference
//		I5 i5 = Impl::test;
		
		//instance method with class reference
		I3 i3 = Impl::getDefaultX;
		System.out.println(i3.get(impl1));
//		i3 = impl1::getDefaultX;
		System.out.println(i3.get(impl2));
		
		I4 i4 = Impl::compare;
		System.out.println(i4.compare(impl1, impl2));
		
		
	}
	
}
