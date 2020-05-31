package lambda;

public class Scopes {

	interface P{		
	}
	
	interface I extends P{
		void test(Number n);
	}

	interface I2 {
		Number test(I i);
	}

	interface I3 {
		I test(Number n);
	}

	public static void main(String[] args) {
		I2 i2 = (n) -> 5;
		i2.test(n -> {
		});
		
		I3 i3 = n -> {
			I i = c -> {
				
			};
			
			return i;
			
		};

		boolean condition = true;
		I2 i = condition ? n -> 1 : n -> 2;
		System.out.println(i.test(null));
		
		I2[] is = new I2[] {n -> 1, n -> 2, n -> 3};
		System.out.println(is[0].test(null));
		System.out.println(is[1].test(null));
		System.out.println(is[2].test(null));
		
		P p = (I) n -> {};
		
	}

}
