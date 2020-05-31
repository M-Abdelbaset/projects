package generics;

class Gen<T> {

	T ob;

	public Gen(T o) {
		this.ob = o;
	}
	
	public T getOb() {
		return ob;
	}

}


public class GenMain{
	
	public static void main(String[] args) {
		
		Gen<String> str = new Gen<String>("test");
		String s = str.getOb();
		
		System.out.println(s);
		System.out.println(str.getClass().getTypeName());
		System.out.println(str.getOb().getClass().getTypeName());

		
		Gen l = new Gen<Long>(4l);
		Gen i = new Gen<Integer>(40);
		l = i;
		
		
		//paramertrized Gen: Gen<Long> l = new Gen<Long>
		Gen<Long> l2 = new Gen(4l);
		Gen<Integer> i2 = new Gen(40);
	//	l2 = i2;
		
		//raw Gen: Gen g = new Gen();
		Gen l3 = new Gen(4l);
		Gen i3 = new Gen(40);
		l3 = i3;
		
		System.out.println(l.getOb());
		System.out.println(l2.getOb().getClass().getTypeName());
		System.out.println(l3.getOb());

	}
	
}
