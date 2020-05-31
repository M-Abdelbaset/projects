package collections.interfaces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;

public class Collections {

	
	public static void main(String[] args) {

		Collection<String> strsList = new ArrayList<String>();
		Collection<String> strsSet = new HashSet<String>();

		System.out.println(strsList.add("one"));
		System.out.println(strsList.add("one"));

		System.out.println(strsSet.add("one"));
		System.out.println(strsSet.add("one"));

		Collection<Number> numsList = new ArrayList<Number>();
		Collection<Float> floatList = new ArrayList<Float>();
		Collection<Object> objsList = new ArrayList<Object>();

		numsList.addAll(floatList);
		// numsList.addAll(objsList);
		
		System.out.println("*************");
		
		strsSet.clear();
		System.out.println(strsSet.addAll(strsList));
		System.out.println(strsSet.addAll(strsList));
		strsList.add("two");
		System.out.println(strsSet.addAll(strsList));
		
		System.out.println("*************");
		strsList.clear();
		strsList.add("three");
		System.out.println(strsSet.removeAll(strsList));
		strsList.add("two");
		System.out.println(strsSet.removeAll(strsList));
		System.out.println(strsSet);
		
		System.out.println("*************");
		strsList.removeIf( i -> i.isEmpty());
		
		Predicate<Object> p = o -> o.equals(null);
		strsList.removeIf(p);		
		
		System.out.println("*************");
		strsSet.clear();
		strsSet.add("four");
		strsList.add("four");
		System.out.println(strsList);
		strsList.retainAll(strsSet);
		System.out.println(strsList);
		
		System.out.println("*************");
		String[] strs = new String[strsList.size()];
		strsList.toArray(strs);
		for(String s : strs)
			System.out.println(s);
		
		System.out.println("*************");
		try {
			Number[] nums = new Number[strsList.size()];
			strsList.toArray(nums);
			for (Number s : nums)
				System.out.println(s);

			Number[] ss = toArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("*************");
		List l1 = new ArrayList<String>();
		l1.add("");
		l1.add(22);
	}

	static void addAll1(Collection<? extends Number> c) {

		List<Number> l = new ArrayList<Number>();
	//	c.add(new Integer(1));
		c.add(null);
	}

	static void addAll2(Collection<? super Number> c) {

		c.add(new Integer(1));
		
	}

	static void addAll3(Collection<Number> c) {
		c.add(new Integer(1));

	}
	
	static <T> T[] toArray() {
		return (T[]) new Object[5];
	}
	
}
