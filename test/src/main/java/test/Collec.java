package test;

import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

public class Collec {

	public static void main(String[] args) {
/*
		Set<Student> stds = new HashSet<Student>();
		Student s1 = new Student("1");
		Student s2 = new Student("1");
		stds.add(s1);
		stds.add(s2);
		
		Set<String> strs = new HashSet<>();
		strs.add("one");
		strs.add("two");
		strs.add("three");
		strs.add("four");
		strs.add("five");
		System.out.println(strs);
		
		strs = new LinkedHashSet<>();
		strs.add("one");
		strs.add("two");
		strs.add("three");
		strs.add("four");
		strs.add("five");
		System.out.println(strs);

		Map<String, String> mp = new HashMap<>();
		mp.put("one", "one");
		mp.put("two", "two");
		mp.put("three", "three");
		mp.put("four", "four");
		mp.put("five", "five");
		System.out.println(mp);
		
		mp = new LinkedHashMap<>();
		mp.put("one", "one");
		mp.put("two", "two");
		mp.put("three", "three");
		mp.put("four", "four");
		mp.put("five", "five");
		System.out.println(mp);
		
*/
		SortedSet<String> ss = new TreeSet<>();
		ss.add("one");
		ss.add("two");
		ss.add("three");
		ss.add("four");
		ss.add("five");
		System.out.println(ss);
		
		
	}

}

class Student {

	private String name;

	public Student(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public boolean equals(Object obj) {
		Student that = (Student) obj;
		
		return name.equals(that.name);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}