package com.test.criteria.params;

import java.util.Properties;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
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
	public void selectUsingParam() {
		
		CriteriaBuilder builder = masterEM.getCriteriaBuilder();
		CriteriaQuery<Parent> query = builder.createQuery(Parent.class);
		Root<Parent> root = query.from(Parent.class);
		
		ParameterExpression<Integer> idParameter = builder.parameter(Integer.class);
		query.where(builder.equal(root.get(Parent_.id), idParameter));
		
		Parent parent = masterEM.createQuery(query)
				.setParameter(idParameter, 1)
				.getSingleResult();
		
		System.out.println(parent);
	}
}