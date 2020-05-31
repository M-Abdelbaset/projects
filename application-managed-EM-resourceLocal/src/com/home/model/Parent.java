package com.home.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	public Parent(String name){
		this.name = name;
	}
	
	private String name;

	@Override
	public boolean equals(Object obj) {
		if(obj == this)
			return true;
		else if(!(obj instanceof Parent)) 
			return false;
		else
			return ((Parent)obj).getName().equals(this.getName());
	}
}
