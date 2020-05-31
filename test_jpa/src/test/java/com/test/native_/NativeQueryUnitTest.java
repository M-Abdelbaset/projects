package com.test.native_;

import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.test.AbstractJPATest;

public class NativeQueryUnitTest extends AbstractJPATest {

	@SuppressWarnings("rawtypes")
	@Override
	protected Class[] getClasses() {
		return new Class[] {Person.class, Laptop.class};
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
		
		Laptop lp1 = new Laptop("Dell2");
		Laptop lp2 = new Laptop("Dell3");
		Laptop lp3 = new Laptop("Dell3");
		
		masterEM.persist(new Person("mohamed", "married", "male", lp1));
		masterEM.persist(new Person("ahmed", "single", "male", lp2));
		masterEM.persist(new Person("sara", "single", "female", lp3));
		
		masterEM.getTransaction().commit();
	}
	
	@Test
	@Disabled
	public void selectNative() {
		Person singleResult = (Person) masterEM
				.createNativeQuery("select * from person where id=1", Person.class)
				.getSingleResult();
		System.out.println(singleResult);
		
		EntityManager em = newEntityManager();
		singleResult = (Person) em
				.createNativeQuery("select id, name, gender from person where id=1", Person.class)
				.getSingleResult();
		System.out.println(singleResult);
	}
	
	@Test
	@Disabled
	public void selectGender() {
	
		String query = "select p.name as NAME, p.id as ID, p.gender as GENDER, p.status as MART_STATUS from person p where gender='female'";
		Person singleResult = (Person) masterEM
				.createNativeQuery(query, "genderPerson")
				.getSingleResult();
		System.out.println(singleResult);
	}
	
	@Test
	@Disabled
	public void selectJoin() {

		String query = "select p.id as ID, p.gender as GENDER, p.name as NAME, p.status as MART_STATUS, l.model as LMODEL "
				+ "from person p inner join laptop l "
				+ "on p.id = l.id " 
				+ "where gender='male'";

		List<Person> singleResult =  (List<Person>) masterEM.createNativeQuery(query, "join").getResultList();
		for(Object o : singleResult)
			System.out.println(o);
	}
	
	@Test
	public void selectDTO() {
		
		doInTransaction(masterEM, () -> {
			masterEM.persist(new Person("mohamed", "married", "male", new Laptop("")));
		});
		
		System.out.println(
				masterEM
				.createNamedQuery("PostDTO", PersonDTO.class)
				.setParameter("id", 1)
				.getSingleResult());
	}
}
