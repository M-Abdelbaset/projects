package com.home.form.editdata;

import java.util.HashSet;
import java.util.List;
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
public class EditDataBean {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager em;
	
	private UserModel editedUserModel;
	private AuthModel editedAuthModel;
	private Set<ContactModel> editedContactModels;
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public User getUserModel(Integer userId) {
		editedUserModel = em.find(UserModel.class, userId);	
		return new User(editedUserModel);
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Auth getAuthModel(Integer userId) {
		editedAuthModel = em.createQuery(
				"select a from AuthModel a where " +
				"a.userModel.id = :userId",
				AuthModel.class)
				.setParameter("userId", userId)
				.getSingleResult();
		return new Auth(editedAuthModel);
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Set<Contact> getContactModels(Integer userId){
		List<ContactModel> contacts = em.createQuery(
				"select c from ContactModel c where " +
				"c.userModel.id = :userId",
				ContactModel.class)
				.setParameter("userId", userId)
				.getResultList();
		editedContactModels = new HashSet<ContactModel>(contacts);
		return Contact.toModels(contacts);
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void updateUserModel(User user) {
		this.editedUserModel.setAge(user.getAge());
		this.editedUserModel.setName(user.getName());
		System.out.println(this.editedUserModel);
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void updateAuthModel(Auth auth) {
		this.editedAuthModel.setUserName(auth.getUserName());
		this.editedAuthModel.setPassword(auth.getPassword());
		System.out.println(this.editedAuthModel);
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void addContactModel(Contact contact) {
		ContactModel contactModel = new ContactModel(contact);
		contactModel.setUserModel(editedUserModel);
		em.persist(contactModel); // to be delayed
		System.out.println(contactModel);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void saveAll() {
		em.flush();
	}
}
