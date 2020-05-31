package com.home.form.newdata.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.home.form.model.Contact;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor
@Entity(name = "ContactModel")
@Table(name = "contactModel")
public class ContactModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	 
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private UserModel userModel;
	
	private String phone;

	public ContactModel(Contact c) {
		this.phone = c.getPhone();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == this)
			return true;
		else if (!(obj instanceof ContactModel))
			return false;
		else
			return this.phone.equals(((ContactModel)obj).getPhone());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(phone);
	}
	
	@Override
	public String toString() {
		return "ContactModel [id=" + id + ", userModel=" + userModel + ", phone=" + phone + "]";
	}
}
