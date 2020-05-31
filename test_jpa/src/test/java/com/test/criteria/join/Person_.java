package com.test.criteria.join;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Person.class)
public class Person_ {

	public static volatile SingularAttribute<Person, Integer> id;
	public static volatile SingularAttribute<Person, String> name;
	public static volatile SingularAttribute<Person, String> status;
	public static volatile SingularAttribute<Person, String> gender;
}
