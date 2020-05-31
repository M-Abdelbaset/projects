package com.home.form.editdata;

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
public class EditDataBean {

	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
	private UserModel editedUserModel;
	private AuthModel editedAuthModel;
	private ContactModel contactModel;
	
	public User getUserModel(Integer userId) {
		editedUserModel = em.find(UserModel.class, userId);	
		return new User(editedUserModel);
	}
	
	public void updateUserModel(User user) {
		this.editedUserModel.setAge(user.getAge());
		this.editedUserModel.setName(user.getName());
		System.out.println(this.editedUserModel);
	}
	
	public Auth getAuthModel(Integer userId) {
		editedAuthModel = em.createQuery(
				"select a from AuthModel a where " +
				"a.userModel.id = :userId",
				AuthModel.class)
				.setParameter("userId", userId)
				.getSingleResult();
		em.detach(editedAuthModel);
		return new Auth(editedAuthModel);
	}
	
	public void updateAuthModel(Auth auth) {
		this.editedAuthModel.setUserName(auth.getUserName());
		this.editedAuthModel.setPassword(auth.getPassword());
		System.out.println(this.editedAuthModel);
	}
	
	public void saveContactModel(Contact contact) {
		this.contactModel = new ContactModel(contact);
		this.contactModel.setUserModel(editedUserModel);
		System.out.println(this.contactModel);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void saveAll() {
		em.merge(editedUserModel);
		em.merge(editedAuthModel);
		em.persist(contactModel);
	}
}
