package com.home.ms.rs;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.home.ms.model.User;
import com.home.ms.service.UserService;

import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping(path = "/users")
@Validated
public class UserResource {

	@Autowired
	private UserService userService;
	
	@GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
	@GetMapping(path = "/{id}")
	@ApiResponse(message = "get user successfully", code = 200)
	public Resource<User> getUser(@ApiParam(name = "the user id") @PathVariable("id") Integer id) {
		
		Resource<User> user = new Resource<>(userService.getUser(id));
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getUsers());
		user.add(linkTo.withRel("users"));
		
		return user;
	}
	
	@PostMapping
	public ResponseEntity<Void> saveUser(@Valid @RequestBody User user) {
		userService.saveUser(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(user.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@Positive @PathVariable("id") Integer userId) {
		userService.deleteUser(userId);
		return ResponseEntity.noContent().build();
	}
	
}
