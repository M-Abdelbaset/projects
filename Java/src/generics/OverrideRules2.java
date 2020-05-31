package generics;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OverrideRules2 {

	static class A<T> {
		T t;

		public void add(T t1, T t2) {
		}

		public T get() {
			return t;
		}
	}

	static class B<T, V> extends A<T> {
	}

	public static void main(String[] args) throws IOException {

		MyNumber n = new MyNumber();
		MyDouble d = new MyDouble();
		MyDouble2 d2 = new MyDouble2();
		MyDouble3 d3 = new MyDouble3();
		MyInt i = new MyInt();

		A<MyNumber> numbers = new A<MyNumber>();
		numbers.add(n, i);
		numbers.add(d, i);

		A<MyDouble> myDoubles = new A<MyDouble>();
		myDoubles.add(d, d);
		myDoubles.add(d2, d3); // you can use sub types of MyDouble
//		doubles.add(n, d3); //However, you can't use super types
//		doubles.add(d, i);
//		numbers = doubles;

		/*
		 * Note: since the inheritance relationship is not working from the beginning,
		 * no need to test the opposite of the relationship: doubles = (A<Double>)
		 * numbers. For example, casting from String to Integer is not possible even if
		 * explicitly as no inheritance relation exists between the two types.
		 */

		A<MyNumber> a = new B<MyNumber, String>(); // String type has no effect on the inheritance hierarchy
		// A<MyNumber> a2 = new B<MyDouble, String>(); //invalid! The same as above.

		/*****************************************************/

		//A<?> accepts any valid parameterized type of A 
		A<?> any1 = new A<MyNumber>();
		any1 = new A<MyDouble>();
		any1 = new A<String>();
		
		/*
		 * since A<?> references can point to any object of A with any parameterized type, 
		 * it's not safe to add any object because the compiler can't guarantee to which object the 
		 * reference is pointing to
		 */
		//any1.add("", ""); //might be pointing to A<MyDouble>
		//any1.add(new Object(), new Object()); //even Object can be referring to a sub-type that is not compatible
		
		Object o = any1.get(); //The only guaranteed return type by the compiler is Object

		/*****************************************************/
		
		/*
		 * <? extends MyDouble> refers to a family of types that has MyDouble as it's
		 * parent. For example, <MyDouble>, <MyDouble1>, <MyDouble2>. It doesn't mean
		 * that a single object can operate on all these types at once.
		 */
		A<? extends MyDouble> anyExtendsDouble = new A<>();
		anyExtendsDouble = new A<MyDouble>();
		anyExtendsDouble = new A<MyDouble2>();
		anyExtendsDouble = new A<MyDouble3>();

		/*
		 * Guaranteed to return MyDouble because it's the highest type.
		 */
		d = anyExtendsDouble.get();
		n = anyExtendsDouble.get();
		o = anyExtendsDouble.get();

		/*
		 * Not allowed to use any type because MyDouble is the highest type. For
		 * example, we might attempt to use a MyDouble where MyDouble2 should've been
		 * used, and MyDouble is not a MyDouble2.
		 */
//		anyExtendsDouble.add(d2, d2);

		/*
		 * A<MyDouble> extends A<? extends MyDouble> since an object of type A<? extends
		 * MyDouble> can be substituted with an object of A<MyDouble> while keeping same
		 * behavior, hence, following the Liskov principle. Although we can't
		 * instantiate objects of type A<? extends MyDouble>, we can assign different
		 * objects to a A<? extends MyDouble> reference, as we have seen. All of these
		 * objects have a behavior of adding and returning two MyDouble, MyDouble2 , or
		 * MyDouble3. Since these three types are instances of MyDouble, A<MyDouble> is
		 * a sub type of A<? extends MyDouble>, because it can fully handle these 3
		 * types, as below:.
		 */

		A<MyDouble2> myDouble2 = new A<>();
		myDouble2.add(d2, d3);
		myDouble2.add(d2, d2);
		myDouble2.add(d3, d3);
		d = myDouble2.get();
		// A<MyDoubles> supports all behaviors of A<MyDoubles2>
		myDoubles.add(d2, d3);
		myDoubles.add(d2, d2);
		myDoubles.add(d3, d3);
		d = myDoubles.get();

		A<MyDouble3> myDouble3 = new A<>();
		myDouble3.add(d3, d3);
		d = myDouble3.get();
		// A<MyDoubles> supports all behaviors of A<MyDoubles2>
		myDoubles.add(d3, d3);
		d = myDoubles.get();

		/*
		 * Objects of A<? extends MyDouble> can be replaced with A<MyDouble> safely.
		 * 
		 */
		anyExtendsDouble = myDoubles;

		/**************************************************************/

		A<? super MyDouble> anySuperDouble;
		anySuperDouble = new A<MyDouble>();
		anySuperDouble = new A<MyNumber>();
		anySuperDouble = new A<Serializable>();
		anySuperDouble = new A<Object>();

		// Guaranteed to accept MyDouble or it's sub types because MyDouble is a base
		// type, and any sub type
		// can work as a replacement due to inheritance. For example, MyDouble3 can work
		// in place of Object.
		anySuperDouble.add(d, d);
		anySuperDouble.add(d2, d3);

		/*
		 * Not Guaranteed to return a specific object because it might be pointing to a
		 * different type. For example, you might expect to get MyNumber while the
		 * object is of type MyDouble. Generics protects against ClassCaseException at
		 * run-time. The only allowed type is Object.
		 */
		o = anySuperDouble.get();

		/*
		 * A<MyDouble> extends A<? super MyDouble> since an object of type A<? super
		 * MyDouble> can be substituted with an object of A<MyDouble> while keeping same
		 * behavior. All of A<? super MyDouble> objects have a behavior of adding and
		 * returning sub types of MyDouble. An A<MyDouble> object is a sub type of A<?
		 * super MyDouble>, because it can fully substitute A<? super MyDouble>
		 */

		myDoubles.add(d, d);
		myDoubles.add(d2, d3);
		myDoubles.add(d2, d2);
		myDoubles.add(d3, d3);
		d = myDoubles.get();


		Map<String, String> map = new HashMap<String, String>();
		map.put("one", "1");
		map.put("two", "2");
		
		map.forEach((k, v) -> System.out.println(k + " " + v));
		
		
		List<String> l = (List<String>)map.values();
		l.forEach(System.out::print);
		l.forEach(OverrideRules2::print1);
		l.forEach(new OverrideRules2()::print2);
	}

	static MyNumber extend1(A<? extends MyNumber> numbers) {
		MyNumber n1, n2;
	//	numbers.add(n1, n2);
		return numbers.get();
	}
	
	static void print1(String s) {}
	void print2(String s) {}
	
	static void extend2(A<? extends Serializable> serializables) {}

	static class MyNumber implements Serializable {}

	static class MyDouble extends MyNumber {}

	static class MyDouble2 extends MyDouble {}

	static class MyDouble3 extends MyDouble2 {}

	static class MyInt extends MyNumber {}

}
