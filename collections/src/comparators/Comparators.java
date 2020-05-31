package comparators;

import java.util.Comparator;

public class Comparators {

	public static void main(String[] args) {
		
		Comparator<String> c = (a, b) -> a.compareTo(b);
		System.out.println(c.compare("1", "2"));
		
		System.out.println(c.reversed().compare("1", "2"));
		
		Comparator<String> cmp = Comparator.reverseOrder();
		System.out.println(cmp.compare("1", "2"));
		
		System.out.println(Comparator.nullsFirst(c).compare("1", null));
		System.out.println(Comparator.nullsLast(c).compare("1", null));
		
		System.out.println("*************");
		Comparator<String> c2 = (a, b) -> a.charAt(0) - b.charAt(0);
		System.out.println(c2.compare("12", "13"));
		Comparator<String> c3 = c2.thenComparing((a, b) -> a.charAt(1) - b.charAt(1));
		System.out.println(c3.compare("12", "13"));
		Comparator<String> c4 = c2.thenComparing(a -> a.charAt(1));
		System.out.println(c4.compare("12", "13"));
		Comparator<String> c5 = c2.thenComparingLong(a -> a.charAt(1));
		System.out.println(c5.compare("12", "13"));
		
	}
}

