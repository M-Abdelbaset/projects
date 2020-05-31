package lambda;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class PredefinedFunctionalInterfaces {

	public static void main(String[] args) {
		
		//Predicate: boolean test(T t);
		Predicate<String> testStr = str -> str.contains("hello");
		System.out.println(testStr.test("hell"));
		
		//Consumer: void accept(T t);
		Consumer<String> consumeStr = input -> System.out.println(input);
		consumeStr.accept("hello");
		
		//Supplier: T get();
		Supplier<String> supp = () -> "default";
		System.out.println(supp.get());
		
		//Function: T2 apply(T1 t1);
		Function<String, Long> func = (str) -> Long.parseLong(str);
		System.out.println(func.apply("51"));
				
		//UnaryOperator T apply(T t);
		UnaryOperator<String> unary = str -> str+"unary";
		System.out.println(unary.apply("this is "));
		
		//BinaryOperator: T apply(T t1, T t2);
		BinaryOperator<String> binary = (str1, str2) -> str1 + str2 +"binary";
		System.out.println(binary.apply("first ", "second "));
		
	}
	
}
