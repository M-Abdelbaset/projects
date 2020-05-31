package com.home;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Stateless;

@Stateless
@DataSourceDefinition(
		name = "java:wildfly/mysql", 
		className = "com.mysql.cj.jdbc.MysqlDataSource",
		user="root", 
		password = "Passw0rd", 
		databaseName = "test_hibernate", 
		portNumber = 3306, 
		serverName = "localhost")
public class DSConfig{
	
}
