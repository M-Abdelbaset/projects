package com.home.form.newdata;

import java.util.Set;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import com.home.form.model.Auth;
import com.home.form.model.Contact;
import com.home.form.model.User;
import com.home.form.newdata.entity.AuthModel;
import com.home.form.newdata.entity.ContactModel;
import com.home.form.newdata.entity.UserModel;

@Stateful
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.NEVER)
public class NewDataBean {
	
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager em;
	
	private UserModel userModel;
	
	public void setUserModel(User user) {
		UserModel userModel = new UserModel(user);
		em.persist(userModel);
		this.userModel = userModel;
	}
	
	public void setAuthModel(Auth auth) {
		AuthModel authModel = new AuthModel(auth);
		authModel.setUserModel(userModel);
		System.out.println(authModel);
		em.persist(authModel);
	}
	
	public void setContactModel(Set<Contact> contacts) {
		for(Contact c : contacts) {
			ContactModel cm = new ContactModel(c);
			cm.setUserModel(userModel);
			em.persist(cm);
		}
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void saveAll() {}
}
