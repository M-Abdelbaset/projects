package com.test.cascade.manytomany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "Tag")
@Table(name = "tag")
@Getter @Setter
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
//	@NaturalId
	private String tag;
	@OneToMany(mappedBy = "tag", 
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<PostTag> postTags = new HashSet<PostTag>();
	
	public Tag() {}
	
	public Tag(Integer id) {
		this.id = id;
	}
	
	public Tag(String tag) {
		this.tag = tag;
	}
}
