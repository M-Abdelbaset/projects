package com.home.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "ParentAssignedId")
@Table(name = "parent_assigned_id")
@Setter @Getter @NoArgsConstructor
public class ParentAssignedId {

	@Id
	private Integer id;

	public ParentAssignedId(Integer id){
		this.id = id;
	}
	
	private String name;
}
