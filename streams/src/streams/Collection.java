package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Collection {

	public static void main(String[] args) {

		List<String> strs = List.of("1", "2", "3", "1", "77", "5");
		Set<String> set = strs.stream().collect(Collectors.toUnmodifiableSet());
		try {
			set.add("BOOM!");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		Map<String, Integer> map;
		try {
		
			map = strs.stream().collect(Collectors.toMap(k -> k, v -> Integer.parseInt(v)));
			
			map = strs.stream().
					collect(Collectors.toMap(k -> k, v -> Integer.parseInt(v), (v1, v2) -> v1 + v2));
			System.out.println(map);
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		

		double res = strs.stream().collect(Collectors.averagingInt(s -> Integer.parseInt(s)));
		System.out.println(res);
		
		long count = strs.stream().collect(Collectors.counting());
		System.out.println(count);
		
		Map<String, List<String>> map2 = strs.stream().collect(Collectors.groupingBy(s -> {
			if(s == "1")
				return "one";
			else if(s == "2")
				return "two";
			else if(s == "3")
				return "three";
			else
				return "other";
		}));
		System.out.println(map2);
		
		System.out.println(strs.stream().collect(Collectors.joining(" , ")));
		
		System.out.println(strs.stream().collect(Collectors.partitioningBy(s -> Integer.parseInt(s) > 5)));
		

	    List<String> asList = strs.stream().collect(() -> new ArrayList<String>(), (x, y) -> x.add(y),
	                                                (x, y) -> x.addAll(y));	
	    
	    
	    System.out.println(asList);
	}
}
