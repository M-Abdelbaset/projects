package com.test.criteria.join;

import java.util.List;
import java.util.Properties;

import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.test.AbstractJPATest;

public class CriteriaUnitTest extends AbstractJPATest {

	@SuppressWarnings("rawtypes")
	@Override
	protected Class[] getClasses() {
		return new Class[] {Person.class};
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
		masterEM.persist(new Person("mohamed", "married", "male"));
		masterEM.persist(new Person("ahmed", "single", "male"));
		masterEM.persist(new Person("ali", "married", "male"));
		masterEM.persist(new Person("sara", "single", "female"));
		masterEM.persist(new Person("noha", "single", "female"));
		masterEM.persist(new Person("aliaa", "married", "female"));
		masterEM.getTransaction().commit();
	}
	
	@Test
//	@Disabled
	public void selectCartasian() {
		
		CriteriaBuilder criteriaBuilder = masterEM.getCriteriaBuilder();
		CriteriaQuery<Tuple> query = criteriaBuilder.createTupleQuery();
		
		Root<Person> males = query.from(Person.class);
		Root<Person> females = query.from(Person.class);
		
		Predicate malesPredicate = criteriaBuilder.and(
				criteriaBuilder.equal(males.get(Person_.gender), "male"),
				criteriaBuilder.equal(males.get(Person_.status), "single")
		);
		
		Predicate femalesPredicate = criteriaBuilder.and(
				criteriaBuilder.equal(females.get(Person_.gender), "female"),
				criteriaBuilder.equal(females.get(Person_.status), "single")
		);
		
		query.multiselect(males, females);
		query.where(malesPredicate, femalesPredicate);
		
		List<Tuple> resultList = masterEM.createQuery(query).getResultList();
		for (Tuple tuple : resultList) {
			System.out.println("male " + tuple.get(0) + "\nfemale: " + tuple.get(1));
		}
	}
}