package com.test.inheritance.singletable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity(name = "Parent")
@Table(name = "parent")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Parent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	
	public String parentName;
}
