package com.home.ms.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.home.ms.model.Post;
import com.home.ms.model.User;
import com.home.ms.service.exception.ResourceNotFoundException;

@Component
public class PostService {

	private int counter = 1;
	
	@Autowired
	private UserService userService;
	
	public List<Post> getPosts(Integer userId) {
		User user = userService.getUser(userId);
		return user.getPosts();
	}

	public Post getPost(Integer userId, Integer postId) {
		User user = userService.getUser(userId);
		return user.getPosts()
				.stream()
				.filter((post) -> post.getId().equals(postId))
				.findFirst()
				.orElseThrow(() -> new ResourceNotFoundException("Post not found: " + postId));
	}

	public void savePost(Integer userId, Post post) {
		User user = userService.getUser(userId);
		post.setId(counter++);
		user.getPosts().add(post);
	}
}
