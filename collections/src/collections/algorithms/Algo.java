package collections.algorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class Algo {

	public static void main(String[] args) {
		Set<Integer> s = new HashSet<Integer>();
		System.out.println(Collections.addAll(s, 1));
		System.out.println(Collections.addAll(s, 1, 2));
		System.out.println(Collections.addAll(s, 1, 2));
		
		System.out.println("\n************\n");
		
		Student s1 = new Student(44);
		Student s2 = new Student(5);
		Student s3 = new Student(11);
		Student s4 = new Student(9);
		Student s5 = new Student(1);
		
		List<Student> stds = new ArrayList<Student>();
		Collections.addAll(stds, s1, s2, s3, s4, s5);
		
		System.out.println(Collections.binarySearch(stds, 
				new Student(1),
				(x, y) -> x.age - y.age));
		
		System.out.println("\n************\n");
		
		List<Integer> ints = new ArrayList<Integer>();
		ints.add(1);
		List objs = ints;
		objs.add("one"); //OK!!
		List<Integer> ints2 = Collections.checkedList(ints, Integer.class);
		objs = ints2;
		try {
			objs.add("one"); //not OK!!
		}catch (ClassCastException ex) {
			ex.printStackTrace();
		}
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("one", 1);
		Map objMap = map;
		objMap.put(1, "one");
		Map<String, Integer> map2 = Collections.checkedMap(map, String.class, Integer.class);
		
		try {
			objMap = map2;
			objMap.put(1, "one");
		}catch (ClassCastException ex) {
			ex.printStackTrace();
		}
		
		System.out.println("\n************\n");
		
		Queue<Integer> intQ = new ArrayDeque<Integer>();
		intQ.add(1); intQ.add(2);
		Set<Integer> intS = new TreeSet<Integer>();
		intS.add(1);
		System.out.println(Collections.disjoint(intQ, intS));
		intS.remove(1);
		System.out.println(Collections.disjoint(intQ, intS));
		
		System.out.println("\n************\n");
		
		Enumeration<String> en = Collections.emptyEnumeration();
		
		System.out.println("\n************\n");
		
		System.out.println(ints);
		Collections.fill(ints, 55);
		System.out.println(ints);

		System.out.println("\n************\n");
		System.out.println(Collections.frequency(ints, 55));
		
		System.out.println("\n************\n");
		Collections.addAll(ints, 1, 44, 5, 76);
		System.out.println(Collections.indexOfSubList(ints, List.of(44, 5)));
		
		System.out.println("\n************\n");
		Collections.addAll(stds, s1, s2, s3, s4, s5);
		System.out.println(Collections.max(stds, (x, y) -> x.age - y.age));
		
		System.out.println("\n************\n");
		
		ints = Collections.synchronizedList(ints);
		Iterator<Integer> itr = ints.iterator();
		while(itr.hasNext()) {
			int i = itr.next();
		}
		
	}
}

enum E {
	e1, e2, e3;
}

class Student{
	
	public Student(int age) {
		this.age = age;
	}
	
	public int age;

	@Override
	public String toString() {
		return "Student [age=" + age + "]";
	}
	
}