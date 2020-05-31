package com.test.cache.firstlevel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Child")
@Table(name = "child")
@Getter @AllArgsConstructor @NoArgsConstructor
public class Child {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true)
	private String name;

	private Integer age;

	public Child setName(String name) {
		this.name = name;
		return this;
	}
	
	public Child setAge(Integer age) {
		this.age = age;
		return this;
	}
}
