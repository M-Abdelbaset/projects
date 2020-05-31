package lambda;

public class Capture {

	int x = 9;
	static int y = 9;

	interface I {
		void test(Number n);
	}
	
	void test(int x) {
		System.out.println(x);
		x++;
		I i = n -> {
			this.x = 8;
			this.y = 10;
		};
	}
	
	public static void main(String[] args) {
		int xInt = 99;
		new Capture().test(xInt);
		System.out.println(xInt);
		
		{
			xInt++;
		}
		
		System.out.println(xInt);

		final int finalX;
		finalX = 9;
				
		I i = n -> {
			y = 10;
		};
		
	}
	
}
