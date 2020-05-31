package collections.classes;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Sets {

	public static void main(String[] args) {
		
		System.out.println("************");
		Set<Double> s = new HashSet<Double>();
		s.add(1.);
		s.add(2.);
		s.add(3.);
		s.add(3.);
		s.add(4.);
		s.add(3.);
		s.add(0.);
		
		Iterator<Double> it = s.iterator();
		while(it.hasNext())
			System.out.print(it.next() + " ");
		
		s = new LinkedHashSet<Double>();//insertion-order set
		s.add(1.);
		s.add(2.);
		s.add(3.);
		s.add(3.);
		s.add(4.);
		s.add(3.);
		s.add(0.);
		System.out.println();
		
		it = s.iterator();
		while(it.hasNext())
			System.out.print(it.next() + " ");
		
		s = new TreeSet<Double>();//ascending-order
		s.add(1.);
		s.add(2.);
		s.add(3.);
		s.add(3.);
		s.add(4.);
		s.add(3.);
		s.add(0.);
		System.out.println();
		
		it = s.iterator();
		while(it.hasNext())
			System.out.print(it.next() + " ");
		
		System.out.println();
		
		EnumSet<E> es1 = EnumSet.allOf(E.class);
		System.out.println(es1);
		
		EnumSet<E> es2 = EnumSet.of(E.e1);
		
		EnumSet<E> es3 = EnumSet.complementOf(es2);
		System.out.println(es3);
		
		List<E> enums = List.of(E.e1);
		es3 = EnumSet.copyOf(enums);
		System.out.println(es3);
		
		es2 = EnumSet.noneOf(E.class);
		System.out.println(es2);
		
		es2 = EnumSet.range(E.e1, E.e4);
		System.out.println(es2);
		
	}
	
	enum E{
		e1, e2, e3, e4, e5, e6, e7;
	}
}
