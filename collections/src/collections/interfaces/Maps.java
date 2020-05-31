package collections.interfaces;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Maps {

	public static void main(String[] args) {
		
		Map<String, Integer> m = Map.of("one", 1, "two", 2);
		System.out.println(m);
		
		m = new HashMap<String, Integer>();
		m.put("one", 1);
		
		m.compute("two", (k, v) -> {System.out.println(k + " " + v);return 2;});
		System.out.println(m);
		
		System.out.println(m.computeIfAbsent("two", k -> 22));
		System.out.println(m);
		
		System.out.println(m.computeIfAbsent("three", k -> 3));
		System.out.println(m);
		
		System.out.println(m.computeIfPresent("three", (k, v) -> 33));
		System.out.println(m);
		
		Map.Entry<String, Integer> entry1 = Map.entry("1", 1);
		System.out.println(entry1);

		Comparator<Map.Entry<String, Integer>> c = Map.Entry.comparingByKey();
		
		
		m.forEach((k, v) -> {k += "+"; v+=1; System.out.println(k + "-->" + v);});
		
		m.merge("four", 4, (k, v) -> 4);
		System.out.println(m);
		m.merge("four", 4, (k, v) -> 4*4);
		System.out.println(m);
		
		m.replaceAll((k, v) -> 0);
		System.out.println(m);
		
	}
}
