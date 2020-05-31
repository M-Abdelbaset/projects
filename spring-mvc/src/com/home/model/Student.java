package com.home.model;

import java.util.Map;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Student {

	private String fname = "initial fName";
	private String lname = "initial lName";
	private String country = "USA Country";
	private Map<String, String> countries = Map.of("India country", "IN",
													"Germany country", "DE");
	
	private String favLang = "PHP";
	private Set<String> radios = Set.of("Java", "PHP", "C++");
	private Set<String> foods = Set.of("Lunch", "Dinner", "Subber");
	private Set<String> meals;
}
