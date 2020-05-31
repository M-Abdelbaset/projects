package com.test.cascade.manytomany;

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
import lombok.Setter;

@Entity(name = "Post")
@Table(name = "post")
@Getter @Setter
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String topic;
	@OneToMany(mappedBy = "post", 
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<PostTag> postTags = new HashSet<PostTag>();
	
	@SuppressWarnings("unused")
	private Post() {}
	
	public Post(Integer id) {
		this.id = id;
	}
	
	public Post(String topic) {
		this.topic = topic;
	}
	
	public void addTag(Tag tag) {
		PostTag postTag = new PostTag(this, tag);
		this.postTags.add(postTag);
		tag.getPostTags().add(postTag);
	}
	
	public void removeTag(Tag tag) {
		PostTag postTag = new PostTag(this, tag);
		Iterator<PostTag> it = postTags.iterator();
		while(it.hasNext()) {
			PostTag item = it.next();
			if(item.equals(postTag)) {
				System.out.println("item found");
				item.setPost(null);
				item.setTag(null);
				item.getTag().getPostTags().remove(item);
				it.remove();
			}
		}
	}
}
