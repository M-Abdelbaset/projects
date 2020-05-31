package com.test.jpql;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Parent")
@Table(name = "parent")
@Setter @Getter @NoArgsConstructor

public class Parent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	@OneToMany(mappedBy = "parent",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Child> children = new HashSet<>();
	
	public void addChild(Child child) {
		if(child != null) {
			this.children.add(child);
			child.setParent(this);
		}
	}
	
	public void removeChild(Child child) {
		Iterator<Child> it = this.children.iterator();
		while(it.hasNext()) {
			Child ch = it.next();
			if(ch.equals(child)) {
				ch.setParent(null);
				it.remove();
			}
		}
	}
}
