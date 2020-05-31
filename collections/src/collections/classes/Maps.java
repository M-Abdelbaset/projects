package collections.classes;

import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Maps {

	public static void main(String[] args) {
		
		NavigableMap<Integer, Integer> ints = new TreeMap<>();
		ints.put(3, 3);
		ints.put(1, 1);
		ints.put(2, 2);
		System.out.println(ints);
		
		
		System.out.println(ints.headMap(2, true));
		
		System.out.println(ints.pollFirstEntry());
		System.out.println(ints);
		
		System.out.println(ints.lastKey());
		System.out.println(ints.floorKey(3));
		System.out.println(ints.lowerKey(3));
		
		System.out.println("*******************");
		
		Map<Integer, Integer> ints2 = new LinkedHashMap<>();
		ints2.put(3, 3);
		ints2.put(1, 1);
		ints2.put(2, 2);
		System.out.println(ints2);
		
		ints2 = new LinkedHashMap<>(0, 10, true);
		ints2.put(3, 3);
		ints2.put(1, 1);
		ints2.put(2, 2);
		System.out.println(ints2);
		ints2.get(3);
		ints2.get(2);
		System.out.println(ints2);
		
		System.out.println("*******************");

		Map<E, String> enumMap = new EnumMap<E, String>(E.class);
		enumMap.put(E.e1, "e1");
	
	}

}

enum E{
	e1, e2, e3;
}
