package streams;

import java.util.List;
import java.util.stream.Collectors;

public class Example {

	public static void main(String[] args) {
		
		List<Integer> ints = List.of(33, 12, 4, -1, 100);
		
		System.out.println(ints.stream().max(Example::test).get());
		System.out.println(ints.stream().max(Integer::compare).get());
		
		System.out.println(ints.stream().sorted().collect(Collectors.toList()));
		
	}
	
	static int test(int x, int y) {
		return x - y;
	}
}
