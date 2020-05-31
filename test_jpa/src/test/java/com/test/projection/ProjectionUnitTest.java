package com.test.projection;

import java.util.Properties;
import org.hibernate.transform.Transformers;
import org.junit.jupiter.api.Test;
import com.test.AbstractJPATest;

public class ProjectionUnitTest extends AbstractJPATest {

	@SuppressWarnings("rawtypes")
	@Override
	protected Class[] getClasses() {
		return new Class[] {Student.class};
	}
	
	@Override
	protected Properties getProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
	
//	@Test
	public void projectUsingNew() {
		
		doInTransaction(masterEM, () -> {
			masterEM.persist(new Student("first one", 15));
		});
		
		System.out.println(
				newEntityManager().createQuery("select new com.test.projection.StudentDTO(s.id, s.name)"
						+ " from Student s where s.id=:id", StudentDTO.class)
				.setParameter("id", 2)
				.getSingleResult()
		);
	}
	
	@Test
	public void test() {
		System.out.println(
			masterEM.createNativeQuery("select s.id, s.name"
					+ " from student s where s.id=:id")
			.setParameter("id", 2)
			.unwrap(org.hibernate.query.NativeQuery.class)
			.setResultTransformer(Transformers.aliasToBean(StudentDTO.class))
			.getSingleResult()
		);
	}
}