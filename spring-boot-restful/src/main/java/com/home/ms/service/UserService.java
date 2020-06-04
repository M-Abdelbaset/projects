package com.home.ms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.home.ms.model.User;
import com.home.ms.service.exception.ResourceNotFoundException;

@Component
public class UserService {

	public static final List<User> USERS = new ArrayList<>();
	private static int counter = 4;
	
	static {
		USERS.add(new User(1, "one"));
		USERS.add(new User(2, "two"));
		USERS.add(new User(3, "three"));
	}

	public List<User> getUsers() {
		return USERS;
	}

	public User getUser(Integer id) {
		return USERS.stream()
				.filter((user) -> user.getId().equals(id))
				.findFirst()
				.orElseThrow(() -> new ResourceNotFoundException("User not found: id=" + id));
	}
	
	public void saveUser(User user) {
		if(user.getId() != null)
			throw new IllegalStateException("Id must be null >> " + user.getId());
		user.setId(counter++);
		USERS.add(user);
	}

	public void deleteUser(Integer userId) {
		
		if(!(USERS.removeIf((user) -> user.getId().equals(userId))))
			throw new ResourceNotFoundException("User not found: id=" + userId); 
	}
}
