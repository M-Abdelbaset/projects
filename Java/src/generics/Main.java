package generics;

public class Main {

	public static void main(String[] args) {
		Generic<String> str = new Generic<String>();
		Generic<String> str2 = new Generic<String>();
		Generic<Integer> str3 = new Generic<Integer>();
		
		str = str2;
		
		str.set("hello world");
		String s = str.get();
		
//		Generic2<MyDouble> d = new Generic2<MyDouble>();
		Generic2<MyInt> d2 = new Generic2<MyInt>();
		
//		d.test(d2);

	}
	
}

class MyDouble extends Number implements Cloneable{

	@Override
	public int intValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long longValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float floatValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double doubleValue() {
		// TODO Auto-generated method stub
		return 0;
	}

}

class MyInt extends Number implements Cloneable, I{

	@Override
	public int intValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long longValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float floatValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double doubleValue() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

interface I{
	
}
