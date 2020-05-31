package com.test.naturalid;

import java.util.Properties;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import com.test.AbstractJPATest;

public class NaturalIdUnitTest extends AbstractJPATest {

	@SuppressWarnings("rawtypes")
	@Override
	protected Class[] getClasses() {
		return new Class[] {Address.class};
	}
	
	@Override
	protected Properties getProperties() {
		Properties properties = new Properties();
		
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.cache.use_second_level_cache", "true");
		properties.put("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory");
		properties.put("hibernate.cache.use_query_cache", "true");
		
		return properties;
	}
	
	@Test
	public void select() {
	/*
		masterEM.getTransaction().begin();
		
		Address address = new Address(null, "Faisal");
		masterEM.persist(address);
	*/	
		masterEM.unwrap(Session.class)
				.bySimpleNaturalId(Address.class)
				.load("Faisal");
		
		masterEM.unwrap(Session.class)
				.bySimpleNaturalId(Address.class)
				.load("Faisal");
		
	//	masterEM.getTransaction().commit();
	}
}
