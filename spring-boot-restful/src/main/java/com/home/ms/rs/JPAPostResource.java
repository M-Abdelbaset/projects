package com.home.ms.rs;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.home.ms.model.Post;
import com.home.ms.model.User;
import com.home.ms.service.JPAUserRepository;
import com.home.ms.service.exception.ResourceNotFoundException;

@RestController
@RequestMapping(path = "/jpa/users/{userId}/posts")
public class JPAPostResource {

	@Autowired
	private JPAUserRepository userRepository;

	@GetMapping
	public List<Post> getPosts(@PathVariable Integer userId) {
		return getUser(userId).getPosts();
	}

	@GetMapping(path = "/{postId}")
	public Post getPost(@PathVariable Integer userId, @PathVariable Integer postId) {
		
		return getPostEntity(userId, postId);
	}

	@PostMapping
	public ResponseEntity<Void> savePost(@PathVariable Integer userId, @RequestBody Post post) {
		getUser(userId).addPost(post);
		userRepository.flush();
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{postId}")
				.buildAndExpand(post.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path = "/{postId}")
	public ResponseEntity<Void> removePost(@PathVariable Integer userId,
			@PathVariable Integer postId) {
		
		getUser(userId).removePost(postId);
		userRepository.flush();
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	public ResponseEntity<Void> editPost(@PathVariable Integer userId,
			@RequestBody Post newPost) {
		
		Post post = getPostEntity(userId, newPost.getId());
		post.setMessage(newPost.getMessage());
		userRepository.flush();
		
		return ResponseEntity.noContent().build();
	}
	
	private User getUser(Integer userId) {
		Optional<User> user = userRepository.findById(userId);
		if(!user.isPresent())
			throw new ResourceNotFoundException("User not found!!");
		
		return user.get();
	}
	
	private Post getPostEntity(Integer userId, Integer postId) {
		return getUser(userId).getPosts().stream().filter((p) -> p.getId().equals(postId)).findFirst()
				.orElseThrow(() -> new ResourceNotFoundException("Post not found"));
	}
}
