package streams;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Streams_1 {
	
	public static void main(String[] args) {
		
	/*
		List<Integer> ints = List.of(1, 2, 3);
		Stream<Integer> st = ints.stream();
		System.out.println(st.min(Integer::compare).get());
		System.out.println(st.min(Integer::compare).get());
		*/
		System.out.println(new ArrayList<Object>().add(null));
		
		
		NavigableSet<String> ts = new TreeSet<String>();
		ts.add("one");
		ts.add("two");
		
		NavigableSet<String> ts2 = ts.descendingSet();
		ts2.remove("one");
		
		System.out.println(ts);
		System.out.println(ts2);
	
	}
	
	
	
}
