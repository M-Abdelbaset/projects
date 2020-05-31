package com.home.form.model;

import javax.persistence.Version;

import com.home.form.newdata.entity.AuthModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor
public class Auth {

	public Auth(AuthModel authModel) {
		this.userName = authModel.getUserName();
		this.password = authModel.getPassword();
	}
	
	private String userName;
	private String password;
	@Version
	private Byte version;
}
