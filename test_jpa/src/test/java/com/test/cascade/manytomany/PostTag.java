package com.test.cascade.manytomany;

import java.util.Date;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "PostTag")
@Table(name = "post_tag")
@Getter @Setter
public class PostTag {

	@EmbeddedId
	private PostTagId postTagId;
	@CreationTimestamp
	private Date date;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "tag_id", insertable = false, updatable = false)
//	@MapsId("TagId") // alternative approach
	private Tag tag;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "post_id", insertable = false, updatable = false)
//	@MapsId("postId") // alternative approach
	private Post post;
	
	@SuppressWarnings("unused")
	private PostTag() {}
	
	public PostTag(Post post, Tag tag) {
		this.postTagId = new PostTagId(post.getId(), tag.getId());
		this.tag = tag;
		this.post = post;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		else if(!(obj instanceof PostTag))
			return false;
		else {
			PostTag that = (PostTag) obj;
			return Objects.equals(this.postTagId, that.getPostTagId());
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(postTagId);
	}
}
