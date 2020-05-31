package com.home;

import javax.annotation.sql.DataSourceDefinition;
import javax.annotation.sql.DataSourceDefinitions;

@DataSourceDefinitions(value = {
		@DataSourceDefinition(
			name = "java:testDS",
			databaseName = "test_hibernate",
			portNumber = 3306,
		    serverName = "localhost",
			user = "root",
			password = "Passw0rd",
			className = "com.mysql.cj.jdbc.MysqlDataSource"),
		@DataSourceDefinition(
				name = "java:nonJTA",
				databaseName = "test_hibernate",
				portNumber = 3306,
			    serverName = "localhost",
				user = "root",
				password = "Passw0rd",
				className = "com.mysql.cj.jdbc.MysqlDataSource",
				properties = {"hibernate.connection.autocommit=0"})
})
public class Config {

}
