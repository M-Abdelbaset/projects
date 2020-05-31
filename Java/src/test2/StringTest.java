package test2;

import java.nio.CharBuffer;

public class StringTest {

	public static void main(String[] args) {

		System.out.println("hello".charAt(4));

		System.out.println("Kello ".compareTo("hello")); // upper case first, then lower case

		System.out.println("hello".concat(" world"));

		System.out.println("hello".contains("o"));
		System.out.println("hello".contains("lo"));
		System.out.println("hello".contains(new StringBuilder("he")));
		System.out.println("hello".contains(new StringBuffer("he")));

		// contentEquals() checks content only(any CharSequence object) while equals()
		// checks for type also.
		// equals() compares 2 Strings only
		System.out.println("hello".contentEquals(new StringBuilder("hello")));
		System.out.println("hello".contentEquals(new StringBuilder("hell")));
		System.out.println("hello".contentEquals(new StringBuilder("Hello")));
		System.out.println("hello".contentEquals(new StringBuffer("hello")));
		
		System.out.println("hello".endsWith(""));
		System.out.println("hello".endsWith("h"));
		System.out.println("hello".endsWith("llo"));
		
		System.out.println("hello".indexOf('f'));
		System.out.println("hello".indexOf('l'));
		
		System.out.println("hello".indexOf("lo"));
		
		System.out.println("hello".indexOf("l", 0));
		
		String intern = new String("intern");
		System.out.println(intern == "intern");
		System.out.println(intern == new String("intern"));		
		System.out.println(intern.intern() == "intern");		
		
		System.out.println("h g ".isBlank());
		System.out.println("".isBlank());
		System.out.println(" ".isBlank());
	
		System.out.println("".isEmpty());
		System.out.println(" ".isEmpty());
		
		System.out.println("hello".lastIndexOf('l'));
		System.out.println("hello".lastIndexOf("llo"));
		System.out.println("hello".lastIndexOf('l', 4));
		
		System.out.println("hello".repeat(2));
		
		System.out.println("hello" == "hello".replace('h', 'h')); //returns same string
		System.out.println("hello" == "hello".replace("h", "h")); //returns a new string if the replacement is found in the String
		System.out.println("hello" == "hello".replace("x", "x")); //returns same string since x is not found in target String
		System.out.println("hello".replace("ll", "x"));
		
		System.out.println("hello".replaceAll("l", "x"));
		
		System.out.println("hello".substring(1));
		System.out.println("hello".substring(1, 3));
		
		System.out.println("\td\n".strip().equals("d"));
		System.out.println("\td\n".trim().equals("d"));
		System.out.println("\u2000d".strip().equals("d")); //strip is uni-code aware method
		System.out.println("\u2000d".trim().equals("\u2000d"));
				
	}

}
