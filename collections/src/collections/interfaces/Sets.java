package collections.interfaces;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class Sets {

	public static void main(String[] args) {
		
		SortedSet<Number> ss = new TreeSet<Number>();
		ss.add(1);
		ss.add(2);
		ss.add(3);
		
		SortedSet<Number> ss2 = ss.headSet(3);
		System.out.println(ss2);
		
		SortedSet<Number> ss3 = ss.tailSet(1);
		System.out.println(ss3);
		
	//	ss.clear();
		
		System.out.println(ss2 + " " + ss3);
		
		System.out.println(ss.comparator());
		
		Comparator<Object> oc = (x, y) -> x.hashCode() - y.hashCode();
		ss = new TreeSet<Number>(oc);
		System.out.println(ss.comparator());

		
		NavigableSet<Double> ns = new TreeSet<Double>();
		ns.add(1.5);
		ns.add(7.);
		ns.add(2.1);
		ns.add(2.7);
		ns.add(3.0);
		System.out.println(ns.descendingSet());
		System.out.println("floor: " + ns.floor(1.55));
		System.out.println("ceil: " + ns.ceiling(2.));
		
		System.out.println("************");
		
		System.out.println(ns.subSet(0., true, 7., true));
		

	}
	
}
