package lambda;

import java.io.FileNotFoundException;

public class Exceptions {

	interface I {
		void test(Number n) throws Exception;
	}

	class C implements I {

		@Override
		public void test(Number n) {
			
		}
	}

	public static void main(String[] args) {

		I i = n -> {
			throw new FileNotFoundException();
			
		};
		
	}
}
