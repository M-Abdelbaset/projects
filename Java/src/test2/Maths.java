package test2;

public class Maths {

	public static void main(String[] args) {
		
		int k = 1;
		k += (k+2) * (k=4); //k = 1 + 3 * 4;
		System.out.println(k);
		
		k = 1;
		k += (k=4) * (k+2); //k = 1 + 4 * 6
		
		System.out.println(k);
		
		k = 1;
		k += 3 + ++k; //k = 1 + 3 + 2
		
		System.out.println(k);
		
		k = 1;
		k += (++k) + 3 + k; //k = 1 + 2 + 3 + 2
		
		System.out.println(k);
		
		k = 1;
		k += (++k) + 3 + ++k; //k = 1 + 2 + 3 + 3
		
		System.out.println(k);
		
		k = 1;
		k += (++k) + 3 + k++; //k = 1 + 2 + 3 + 2
		
		System.out.println(k);
		
	}
	
}
