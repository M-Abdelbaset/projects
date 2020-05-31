package com.test.cascade.manytomany;

import java.util.Properties;
import org.junit.jupiter.api.Test;
import com.test.AbstractJPATest;

public class SeparateTableManyToMany extends AbstractJPATest {

	@SuppressWarnings("rawtypes")
	@Override
	protected Class[] getClasses() {
		return new Class[] {Post.class, Tag.class, PostTag.class};
	}
	
	@Override
	protected Properties getProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
	
//	@Test
	public void addAll() {
		
		masterEM.getTransaction().begin();
		
		Post javaPost = new Post("Java");
		masterEM.persist(javaPost);
		
		Tag javaTag1 = new Tag("spring");
		Tag javaTag2 = new Tag("hibernate");
		masterEM.persist(javaTag1);
		masterEM.persist(javaTag2);
			
		javaPost.addTag(javaTag1);
		javaPost.addTag(javaTag2);
		
		masterEM.getTransaction().commit();
	}
	
	@Test 
	public void removePostTag() {
		
		masterEM.getTransaction().begin();
		
		Post post = masterEM
				.createQuery("from Post p"
						+ " join fetch p.postTags"
						+ " where p.id=:id", Post.class)
				.setParameter("id", 4)
				.getSingleResult();
		post.removeTag(new Tag(5));
		
		masterEM.getTransaction().commit();
	}
}