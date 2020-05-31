package com.test.criteria.from;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Child.class)
public class Child_ {
	
	public static volatile SingularAttribute<Child, Integer> id;
	public static volatile SingularAttribute<Child, String> name;
	public static volatile SingularAttribute<Child, Person> person;
}
