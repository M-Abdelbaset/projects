package com.test.cascade.manytomany;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class PostTagId implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(name = "post_id")
	private Integer postId;
	@Column(name = "tag_id")
	private Integer tagId;
	
	@SuppressWarnings("unused")
	private PostTagId() {}

	public PostTagId(Integer postId, Integer tagId) {
		this.postId = postId;
		this.tagId = tagId;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		else if(!(obj instanceof PostTagId))
			return false;
		else {
			PostTagId that = (PostTagId) obj;
			return Objects.equals(postId, that.getPostId()) &&
					Objects.equals(tagId, that.getTagId());
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(postId, tagId);
	}
}
