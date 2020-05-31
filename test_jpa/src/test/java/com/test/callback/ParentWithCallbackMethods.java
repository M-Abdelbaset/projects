package com.test.callback;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "ParentWithCallbackMethods")
@Table(name = "parent_callback")
@Setter @Getter
@EntityListeners(value = {ParentEntityListener.class, AnotherParentEntityListener.class})
public class ParentWithCallbackMethods {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private Date lastUpdated;
	
	@Version
	private Byte version;
	
//	@PrePersist
	public void prePersist() {
		this.lastUpdated = new Date();
	}
	
//	@PostPersist
	public void postPersist() {
		System.out.println("Object's state: " + "id: " + id + ", and version: " + version);
	}
	
//	@PostLoad
	public void postLoad() {
		System.out.println("Object's state: " + "id: " + id + 
				", and name: " + name +
				", and version: " + version + 
				", and lastUpdated: " + lastUpdated);
	}
}
