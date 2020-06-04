package com.home.ms.rs;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.home.ms.model.Post;
import com.home.ms.service.PostService;

@RestController
@RequestMapping(path = "/users/{userId}/posts")
public class PostResource {

	@Autowired
	private PostService postService;

	@GetMapping
	public List<Post> getPosts(@PathVariable Integer userId) {
		return postService.getPosts(userId);
	}

	@GetMapping(path = "/{postId}")
	public Post getPost(@PathVariable Integer userId, @PathVariable Integer postId) {
		return postService.getPost(userId, postId);
	}

	@PostMapping
	public ResponseEntity<Void> savePost(@PathVariable Integer userId, @RequestBody Post post) {
		postService.savePost(userId, post);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{postId}")
				.buildAndExpand(post.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
