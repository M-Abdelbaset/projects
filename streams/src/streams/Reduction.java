package streams;

import java.util.List;
import java.util.stream.Stream;

public class Reduction {

	public static void main(String[] args) {
		
		List<String> strs = List.of("1", "2", "3", "4");
		System.out.println(strs.stream().reduce((x, y) -> x + "," + y));
		System.out.println(strs.stream().reduce("arr: ", (x, y) -> x + "," + y));
		
		System.out.println("*******");
		strs.parallelStream().sorted().forEach(x -> System.out.print(x + " "));
		System.out.println();
		strs.parallelStream().sorted().forEachOrdered(x -> System.out.print(x + " "));
		
		List<User> users = List.of(new User(1), new User(2), new User(3));
		users.stream().reduce(0, (age1, user2) -> age1 + user2.getAge(),
				(user1, user2) -> user1 + user2);
		
		
		System.out.println();
		strs.stream().flatMap(x -> Stream.of(x, "+")).forEach(y -> System.out.print(y)); // One-to-many mapping
				
	}
}

class User{
	int age;
	
	public User(int age) {
		this.age= age;
	}
	
	public int getAge() {
		return age;
	}
}