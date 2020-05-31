package com.test.criteria.params;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Parent.class)
public class Parent_ {

	public static volatile SingularAttribute<Parent, Integer> id;
	public static volatile SingularAttribute<Parent, String> name;
	public static volatile SingularAttribute<Parent, Integer> age;
}
