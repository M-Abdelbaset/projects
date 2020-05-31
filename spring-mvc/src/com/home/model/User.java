package com.home.model;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class User {
	
	public static interface WithoutPasswordView {}
	public static interface WithPasswordView extends WithoutPasswordView {}
	
	@JsonView(User.WithoutPasswordView.class)
	private String userName;
	@JsonView(User.WithPasswordView.class)
	private String password;
	@JsonView(User.WithoutPasswordView.class)
	private int age;
	@JsonView(User.WithoutPasswordView.class)
	private String job;
}
