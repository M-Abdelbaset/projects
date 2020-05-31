package com.test.criteria.from;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@Embedded
	private Address address;
	
	@OneToMany(mappedBy = "person", 
			cascade = CascadeType.ALL, 
			orphanRemoval = true, 
			fetch = FetchType.LAZY)
	private Set<Child> children = new HashSet<>();
	
	public Person(String name) {
		super();
		this.name = name;
	}
	
	public void addChild(Child c) {
		children.add(c);
		c.setPerson(this);
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address=" + address + ", children=" + children + "]\n";
	}
}
