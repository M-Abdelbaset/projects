package com.test.criteria.typed;

import java.util.List;
import java.util.Properties;
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
	@Disabled
	public void selectEntity() {
		
		CriteriaBuilder builder = masterEM.getCriteriaBuilder();
		CriteriaQuery<Parent> criteria = builder.createQuery(Parent.class);
		Root<Parent> root = criteria.from(Parent.class);
		criteria.where(builder.equal(root.get(Parent_.id), 1));
		Parent parent = masterEM.createQuery(criteria).getSingleResult();
		System.out.println(parent);
	}
	
	@Test
	@Disabled
	public void selectAttribute() {
		
		CriteriaBuilder criteriaBuilder = masterEM.getCriteriaBuilder();
		CriteriaQuery<String> query = criteriaBuilder.createQuery(String.class);
		Root<Parent> root = query.from(Parent.class);
		query.select(root.get(Parent_.name));
		query.where(criteriaBuilder.equal(root.get(Parent_.id), 1));
		String res = masterEM.createQuery(query).getSingleResult();
		System.out.println(res);
	}
	
	@Test
	@Disabled
	public void selectMultipleAttributes() {
		
		CriteriaBuilder criteriaBuilder = masterEM.getCriteriaBuilder();
		CriteriaQuery<Object[]> query = criteriaBuilder.createQuery(Object[].class);
		Root<Parent> root = query.from(Parent.class);
		
		Path<Integer> idPath = root.get(Parent_.id);
		Path<String> namePath = root.get(Parent_.name);
		
		query.select(criteriaBuilder.array(idPath, namePath));
		query.where(criteriaBuilder.greaterThanOrEqualTo(root.get(Parent_.id), 2));
		
		List<Object[]> res = masterEM.createQuery(query).getResultList();
		for(Object[] arr : res)
			System.out.println(arr[0]+":"+arr[1]);
		
		/////////////////////////////////////////
		// another way of doing it:
		
		query.multiselect(idPath, namePath);
		query.where(criteriaBuilder.greaterThanOrEqualTo(root.get(Parent_.id), 1));
		
		res = masterEM.createQuery(query).getResultList();
		for(Object[] arr : res)
			System.out.println(arr[0]+":"+arr[1]);
	}
	
	@Test
//	@Disabled
	public void selectMultipleAttributesUsingWrapper() {
		
		CriteriaBuilder criteriaBuilder = masterEM.getCriteriaBuilder();
		CriteriaQuery<Wrapper> query = criteriaBuilder.createQuery(Wrapper.class);
		Root<Parent> root = query.from(Parent.class);
		
		Path<Integer> idPath = root.get(Parent_.id);
		Path<String> namePath = root.get(Parent_.name);
		
		query.select(criteriaBuilder.construct(Wrapper.class, idPath, namePath));
		query.where(criteriaBuilder.greaterThanOrEqualTo(root.get(Parent_.id), 2));
		
		List<Wrapper> res = masterEM.createQuery(query).getResultList();
		System.out.println(res);
		
	}
}

class Wrapper {
	private final Integer id;
	private final String name;
	
	public Wrapper(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Wrapper [id=" + id + ", name=" + name + "]";
	}
}