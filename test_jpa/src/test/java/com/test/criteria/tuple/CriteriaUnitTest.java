package com.test.criteria.tuple;

import java.util.List;
import java.util.Properties;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import com.test.AbstractJPATest;

public class CriteriaUnitTest extends AbstractJPATest {

	@SuppressWarnings("rawtypes")
	@Override
	protected Class[] getClasses() {
		return new Class[] {Parent.class};
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
		masterEM.persist(new Parent("one", 111));
		masterEM.persist(new Parent("two", 222));
		masterEM.persist(new Parent("three", 333));
		masterEM.persist(new Parent("four", 444));
		masterEM.getTransaction().commit();
	}

	@Test
//	@Disabled
	public void selectEntity() {
		CriteriaBuilder criteriaBuilder = masterEM.getCriteriaBuilder();
		CriteriaQuery<Tuple> query = criteriaBuilder.createTupleQuery();
		
		Root<Parent> root = query.from(Parent.class);
		
		Path<Integer> id = root.get(Parent_.id);
		Path<String> name = root.get(Parent_.name);
		Path<Integer> age = root.get(Parent_.age);
		
		query.multiselect(id, name, age);
		query.where(criteriaBuilder.greaterThanOrEqualTo(root.get("id"), 2));
		
		List<Tuple> resultList = masterEM.createQuery(query).getResultList();
		for(Tuple t : resultList) {
			System.out.println(t.get(name)+":"+t.get(id)+":"+t.get(age));
		}
	}
}
