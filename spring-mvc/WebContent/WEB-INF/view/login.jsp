<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form:form modelAttribute="user" method="post" action="login/process">
		User name: <form:input path="userName" /> <br>
		Password: <form:input path="password" /> <br>
		<input type="submit">
	</form:form> <br>
	<form:form modelAttribute="user" method="post" action="login/process/x">
		User name: <form:input path="userName" /> <br>
		Password: <form:input path="password" /> <br>
		<input type="submit">
	</form:form>
</body>
</html>