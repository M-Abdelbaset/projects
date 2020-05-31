package com.home.form.newdata.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import com.home.form.model.Auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor
@Entity(name = "AuthModel")
@Table(name = "authModel")
public class AuthModel { 

	@Id
	private Integer id;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "id")
	private UserModel userModel;
	
	@NaturalId
	private String userName;
	private String password;
	
	public AuthModel(Auth auth) {
		this.userName = auth.getUserName();
		this.password = auth.getPassword();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == this)
			return true;
		else if (!(obj instanceof AuthModel))
			return false;
		else
			return this.userName.equals(((AuthModel)obj).getUserName()) &&
					this.password.equals(((AuthModel)obj).getPassword());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(userName, password);
	}
	
	@Override
	public String toString() {
		return "AuthModel [id=" + id + ", userModel=" + userModel + ", userName=" + userName + ", password=" + password
				+ "]";
	}
}
