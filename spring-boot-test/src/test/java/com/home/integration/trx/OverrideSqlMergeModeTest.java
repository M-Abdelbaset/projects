package com.home.integration.trx;

import static org.hamcrest.CoreMatchers.*;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlMergeMode;
import org.springframework.test.context.jdbc.SqlMergeMode.MergeMode;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.transaction.annotation.Transactional;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringJUnitConfig
@Sql(statements = {
		"delete from student where id=100 or id=1001;", 
		"insert into student values (100, 'prnt');"})
class OverrideSqlMergeModeTest extends AbstractMySqlTest {
	
	@Test
	@Sql(statements = {"insert into student values (1001, 'prnt');"})
	@SqlMergeMode(MergeMode.MERGE)
	@Transactional
	void merge() {
		int count = JdbcTestUtils.countRowsInTableWhere(jdbcTemplate, "student", "id=100 or id=1001");
		assertThat(count, is(2));
	}
	
	@Test
	@Sql(statements = {"insert into student values (1001, 'prnt');"})
	@SqlMergeMode(MergeMode.OVERRIDE)
	@Transactional
	void override() {
		int count = JdbcTestUtils.countRowsInTableWhere(jdbcTemplate, "student", "id=100 or id=1001");
		assertThat(count, is(1));
	}
}
