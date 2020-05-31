package lambda;

public class Generic {
	
	interface I<T>{
		void test(T t);
	}
	
	interface I2<T extends Number>{
		void test(T t);
	}
	
	
	public static void main(String[] args) {
		
		I<Number> i = (Number n)->{};
//		i = (String n)->{};
		
		I<?> i2 = (String n)->{};
		i2 = (Number n)->{};
		
		I2<?> i21 = (Number n)->{};
//		I2 i22 = (Object n)->{};
		
	}
}
