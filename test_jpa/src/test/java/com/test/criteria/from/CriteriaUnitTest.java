package com.test.criteria.from;

import java.util.List;
import java.util.Properties;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import com.test.AbstractJPATest;

public class CriteriaUnitTest extends AbstractJPATest {

	@SuppressWarnings("rawtypes")
	@Override
	protected Class[] getClasses() {
		return new Class[] {Person.class, Child.class};
	}
	
	@Override
	protected Properties getProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}

	@Test
	@Disabled
	public void persist() {
		
		masterEM.getTransaction().begin();
		
		Child child11 = new Child("child 1");
		Child child12 = new Child("child 1");
		Child child13 = new Child("child 1");
		Child child21 = new Child("child 2");
		Child child22 = new Child("child 2");
		
		
		Person person1 = new Person("one");
		person1.addChild(child11);
		person1.addChild(child12);
		person1.addChild(child13);
		
		Person person2 = new Person("two");
		person2.addChild(child21);
		person2.addChild(child22);
		
		masterEM.persist(person1);
		masterEM.persist(person2);
		
		masterEM.getTransaction().commit();
	}
	
	@Test
//	@Disabled
	public void joinOneToMany() {
		CriteriaBuilder criteriaBuilder = masterEM.getCriteriaBuilder();
		CriteriaQuery<Person> query = criteriaBuilder.createQuery(Person.class);
		
		Root<Person> root = query.from(Person.class);
		query.select(root).distinct(true);
		root.join(Person_.children);
	//	query.where(criteriaBuilder.equal(root.get(Person_.id), 1));
		
		List<Person> resultList = masterEM.createQuery(query).getResultList();
		System.out.println(resultList);
	}
	
	@Test
	@Disabled
	public void fetch() {
		CriteriaBuilder criteriaBuilder = masterEM.getCriteriaBuilder();
		CriteriaQuery<Person> query = criteriaBuilder.createQuery(Person.class);
		
		Root<Person> root = query.from(Person.class);
		query.select(root).distinct(true);
		root.fetch(Person_.children);
		query.where(criteriaBuilder.equal(root.get(Person_.id), 1));
		
		List<Person> resultList = masterEM.createQuery(query).getResultList();
		System.out.println(resultList);
	}
}













