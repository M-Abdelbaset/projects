package com.test.criteria.from;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Person.class)
public class Person_ {

	public static volatile SingularAttribute<Person, Integer> id;
	public static volatile SingularAttribute<Person, String> name;
	public static volatile SingularAttribute<Person, Address> address;
	public static volatile SetAttribute<Person, Child> children;
}
