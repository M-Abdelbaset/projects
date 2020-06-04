package com.home.ms.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@ApiModel(description = "user model")
@Entity(name = "User")
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	@ApiModelProperty(required = true, allowEmptyValue = false, notes = "Must be not empty")
	private String name;
	
	@Past
	private Date birthDate = new Date();
	
	@OneToMany(mappedBy = "user",
			cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY,
			orphanRemoval = true)
	@JsonManagedReference
	private List<Post> posts = new ArrayList<>();
	
	public User(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public void addPost(Post post) {
		this.posts.add(post);
		post.setUser(this);
	}
	
	public void removePost(Integer postId) {
		Iterator<Post> it = this.posts.iterator();
		while(it.hasNext()) {
			Post post = it.next();
			if(post.getId().equals(postId)) {
				post.setUser(null);
				it.remove();
			}
		}
	}
}
