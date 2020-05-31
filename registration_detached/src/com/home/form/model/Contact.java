package com.home.form.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Version;

import com.home.form.newdata.entity.ContactModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor
public class Contact {

	public Contact(ContactModel contactModel) {
		this.phone = contactModel.getPhone();
	}
	
	public static Set<Contact> toModels(List<ContactModel> contactModels) {
		Set<Contact> contacts = new HashSet<>();
		for(ContactModel cm : contactModels) {
			contacts.add(new Contact(cm));
		}
		return contacts;
	}
	
	public static Set<ContactModel> toEntities(Set<Contact> contacts) {
		Set<ContactModel> contactModels = new HashSet<>();
		for(Contact c : contacts) {
			contactModels.add(new ContactModel(c));
		}
		return contactModels;
	}
	
	private String phone;
	@Version
	private Byte version;
}
