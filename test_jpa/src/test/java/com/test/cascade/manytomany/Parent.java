package com.test.cascade.manytomany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	
	@ManyToMany(mappedBy = "parents", cascade = {CascadeType.PERSIST, 
			CascadeType.MERGE,
			CascadeType.REMOVE})
	private Set<Child> children = new HashSet<>();
	
	public void addChild(Child child) {
		if(child != null) {
			this.children.add(child);
			child.getParents().add(this);
		}
	}
	
	public void removeChild(Child child) {
		this.children.remove(child);
		child.getParents().remove(this);
	}
	
	public void removeChildren() {
		Set<Child> ch2 = new HashSet<>(this.children);
		for(Child child : ch2) {
			removeChild(child);
		}
	}
}
