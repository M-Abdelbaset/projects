package com.home.ms.rs;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
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
import com.home.ms.service.JPAUserRepository;
import com.home.ms.service.exception.ResourceNotFoundException;

import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping(path = "/jpa/users")
@Validated
public class JPAUserResource {

	@Autowired
	private JPAUserRepository userRepository;
	
	@GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	@ApiResponse(message = "get user successfully", code = 200)
	public Resource<User> getUser(@ApiParam(name = "the user id") @PathVariable("id") Integer id) {
		
		Optional<User> user = userRepository.findById(id);
		
		if(!user.isPresent())
			throw new ResourceNotFoundException("User not found!!");
		
		Resource<User> userResorce = new Resource<>(user.get());
		
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getUsers());
		userResorce.add(linkTo.withRel("users"));
		
		return userResorce;
	}
	
	@PostMapping
	public ResponseEntity<Void> saveUser(@Valid @RequestBody User user) {
		userRepository.save(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(user.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@Positive @PathVariable("id") Integer userId) {
		userRepository.deleteById(userId);
		return ResponseEntity.noContent().build();
	}
	
}
