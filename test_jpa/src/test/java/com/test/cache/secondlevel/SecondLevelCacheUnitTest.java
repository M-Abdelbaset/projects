package com.test.cache.secondlevel;

import java.util.Properties;
import org.junit.jupiter.api.Test;
import com.test.AbstractJPATest;

public class SecondLevelCacheUnitTest extends AbstractJPATest {

	@SuppressWarnings("rawtypes")
	@Override
	protected Class[] getClasses() {
		return new Class[] {Child.class, Address.class};
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

	//@Test
	public void find() {
		masterEM.find(Child.class, 1);
		newEntityManager().find(Child.class, 1);
	}
	
//	@Test
	public void findChange() {
		masterEM.getTransaction().begin();
		Child child = masterEM.find(Child.class, 2);
		child.setName("new name");
		try {
			masterEM.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@Test
	public void persistAndFind() {
		
		masterEM.getTransaction().begin();
		
		Child child = new Child();
		masterEM.persist(child);
		
		masterEM.getTransaction().commit();
		
		newEntityManager().find(Child.class, child.getId());
		newEntityManager().find(Child.class, child.getId()); // not run
	}
	
//	@Test
	public void findDelete() {
		masterEM.getTransaction().begin();
		Child child = masterEM.find(Child.class, 1);
		newEntityManager().find(Child.class, 1);
		
		masterEM.remove(child); // marked for removal @ 2nd level cache && PC
		child = newEntityManager().find(Child.class, 1);
		
		assert child == null;
		masterEM.getTransaction().commit();
	}
	
//	@Test
	public void findCollection() {
		
		Child child = new Child();
		
		Address address = new Address();
		address.setAddress("address # 1");
		address.setChild(child);
		
		Address address2 = new Address();
		address2.setAddress("address # 2");
		address2.setChild(child);
		
		child.getAddresses().add(address);
		child.getAddresses().add(address2);
		
		masterEM.persist(child);
		masterEM.getTransaction().begin();
		masterEM.getTransaction().commit();
		
		newEntityManager().find(Child.class, child.getId());
		
		newEntityManager().find(Child.class, child.getId());
	}
}
