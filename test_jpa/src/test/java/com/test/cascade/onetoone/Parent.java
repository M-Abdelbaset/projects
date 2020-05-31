package com.test.cascade.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
	
	@OneToOne(mappedBy = "parent",
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER,
			orphanRemoval = true,
			optional = false)
	private Child child;
	
	public void addChild(Child child) {
		if(child != null) {
			this.child = child;
			child.setParent(this);
		}
	}
	
	public void removeChild() {
		if(this.child != null) {
			this.child.setParent(null);
			this.child = null;
		}
	}
}
