package inheritance;

public class Sub extends Abstract{

	public Sub() {
		System.out.println("sub called");
	}
	
	public static void main(String[] args) {
		Sub sub = new Sub();
		
		int[] arr = new int[3];
		Object o = arr;
		
		Sub s = null;
		I i = (I)s;

	}
	
	
	static class SS{}
	
	@Override
	final void test() {
		// TODO Auto-generated method stub
		
	}
	
	static interface I{}
	
}
