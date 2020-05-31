package com.home.test;

import java.util.Currency;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class BasicTest {

	@ParameterizedTest(name = "test method source")
	@MethodSource("testFactory")
	void test(String name, int age) {
		System.out.println(name + " " + age);
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"JPY"})
	void convert(Currency c) {
		System.out.println(c);
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"JPY"})
	void aggregate(ArgumentsAccessor accessor) {
		System.out.println(accessor.getString(0));
	}
	
	
	static Stream<Arguments> testFactory() {
		
		
		
		return Stream.of(Arguments.of("x", 11),
				Arguments.of("y", 22));
	}
}
