package generics;

import java.io.Serializable;

public class Generic2 <T extends Serializable>{
	
	T t;
	
	public Generic2() {}
	
	public Generic2(T t) {
		this.t = t;
	}
	
	<V> void test(V v) {
		Generic2<T> od = new Generic2<>();

		System.out.println(od.get().getClass().getTypeName());
	}
	
	static <V extends Serializable> void test2(Generic2<V> g) {}
	
	void set (T t){
		
	}
	
	T get() {
		return t;
	}
	
	public static void main(String[] args) {
		//Cannot make a static reference to the non-static type T
		//Generic2<T> od = new Generic2<T>();
		Generic2.test2(new Generic2<>());
		//---------------------------
		Generic2<String> od2 = new Generic2<String>();
		od2.set("");
		//String s = od2.get();
		Serializable ser = od2.get();
		//---------------------------
	//	od2.t = (T)"";
		
		//Cannot instantiate the type Generic2<?>
		//Generic2<?> od3 = new Generic2<?>();

		//Type mismatch: cannot convert from Generic2<String> to Generic2<? extends Number>
		//Generic2<? extends Number> od4 = new Generic2<String>();

		//Bound mismatch: The type X is not a valid substitute for the bounded parameter <T extends Serializable> of the type Generic2<T>
		Generic2<? extends X> od5; //???
		//od5 = new Generic2<X>();

		Generic2<Integer> gen = new Generic2<Integer>(5);
		gen.<String>test("");
		
	}
}

class X{

}

class Y <T extends X>{}

class Z extends X{}

class F{}

interface II{}

class Main2{
	public static void main(String[] args) {
	//	Y<? extends F> str;
	//	Y<Serializable> str2;

		new Y<X>();
	}
}




