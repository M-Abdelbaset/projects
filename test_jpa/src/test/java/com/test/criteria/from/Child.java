package com.test.criteria.from;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Child")
@Table(name="child")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Child {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Person person;
	
	public Child(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Child [id=" + id + ", name=" + name + "]";
	}
}
