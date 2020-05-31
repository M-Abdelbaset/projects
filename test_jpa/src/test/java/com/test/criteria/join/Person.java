package com.test.criteria.join;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Person")
@Table(name = "person")
@Setter @Getter @NoArgsConstructor
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String status;
	private String gender;
	
	public Person(String name, String status, String gender) {
		super();
		this.name = name;
		this.status = status;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", status=" + status + ", gender=" + gender
				+ "]";
	}
}
