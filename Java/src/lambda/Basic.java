package lambda;

public class Basic{
	
	interface I{
		void test(Number n);
	}
	
	interface I2{
		Number test(Number n);
	}
	
	interface I3{
		Number test(Number n, String s);
	}
	
	
	public static void main(String[] args) {
		I i = (Number n)->{};
		i = n -> {};
		i.test(5);
		test(n->{});
		
		I2 i2 = n -> 5;
		i2 = n -> {return 5;};
		
		I3 i3 = (n, s) -> 4;
		i3 = (Number n, String s) -> 4;
	//	i3 = (Number n, s) -> 4;
	}

	static void test(I i) {
		
	}
	
	static I test() {
		return (n)->{};
	}
}
