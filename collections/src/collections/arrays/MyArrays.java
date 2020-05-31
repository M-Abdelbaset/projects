package collections.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyArrays<T> {
	
	public static void main(String[] args) {
		
		List<String> l = Arrays.asList("1", "2");
		l.set(0, "2");
	//	l.add("");
	
		String[] arr = new String[]{"1", "2"};
		Arrays.sort(arr, (x, y) -> x.charAt(0) - y.charAt(0));
		
		Student[] s = new Student[] {new Student(), new Student()};
	//	Arrays.sort(s);
		
	//	Arrays.binarySearch(s, new Student());
		
		System.out.println(Arrays.copyOf(arr, 2, Object[].class));
				
		
		Number[] ns = new Number[] {1, 2};
	//	arr = Arrays.copyOf(ns, 2, String[].class); // RTE not CTE is thrown
		
		
		int[] arr1 = new int[] {1, 2, 3};
		int[] arr2 = new int[] {1, 2, 33};
		System.out.println(Arrays.equals(arr1, arr2));
		
		Student[] s1 = new Student[] {new Student(21), new Student(24)}; 
		Student[] s2 = new Student[] {new Student(1), new Student(2)};
		System.out.println(Arrays.equals(s1, s2));
		
		int[][] arr11 = new int[][] {{1}, {1, 2}};
		int[][] arr22 = new int[][] {{1}, {1, 2}};
		System.out.println(Arrays.equals(arr11, arr22));
		System.out.println(Arrays.deepEquals(arr11, arr22));
		
		Arrays.spliterator(arr);
		Spliterator.OfInt sp = Arrays.spliterator(arr1);
		IntStream intS = Arrays.stream(arr1);	
		
	//	Arrays.setAll(arr1, (x) -> 1);
		
		System.out.println(Arrays.asList(s1));
		Arrays.setAll(s1, (x) -> new Student(x));
		System.out.println(Arrays.asList(s1));
		
		System.out.println(Arrays.toString(arr1));
		Arrays.parallelPrefix(arr1, (x, y) -> x*y);
		System.out.println(Arrays.toString(arr1));

		
		System.out.println(Arrays.compare(new int[] {1, 2, -1}, new int[] {1, 2}));
		System.out.println(Arrays.compare(new int[] {1, 2, -1}, new int[] {1, 2, 3}));

		System.out.println(Arrays.mismatch(new int[] {1, 2, -1}, new int[] {1, 2}));
		System.out.println(Arrays.mismatch(new int[] {1, 2}, new int[] {1, 2}));

		
	}
	
}

class Student {
	
	public int age;
	
	public Student() {}
	
	public Student(int age) {
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.age - ((Student)obj).age == 0;
	}

	@Override
	public String toString() {
		return "Student [age=" + age + "]";
	}
	
	
}