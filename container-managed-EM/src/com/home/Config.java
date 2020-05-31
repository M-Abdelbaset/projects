package com.home;

import javax.annotation.sql.DataSourceDefinition;

@DataSourceDefinition(
		name = "java:testDS",
		databaseName = "test_hibernate",
		portNumber = 3306,
	    serverName = "localhost",
		user = "root",
		password = "Passw0rd",
		className = "com.mysql.cj.jdbc.MysqlDataSource")
public class Config {

}
