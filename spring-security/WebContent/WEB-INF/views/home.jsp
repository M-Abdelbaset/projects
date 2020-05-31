<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<h2>Welcome! <security:authentication property="principal.username" /></h2><br>
	<p>You are: <security:authentication property="principal.authorities" /></p>
	
	<security:authorize access="hasRole('USER')">
		<hr>
		<a href="${pageContext.request.contextPath}/admin">Admin page</a>
		<a href="${pageContext.request.contextPath}/manager">manager page</a>	
	</security:authorize>
	
	<hr>
	<a href="${pageContext.request.contextPath}/access">Access feature</a>
	<hr>
	
	<security:authorize access="hasRole('ADMIN')">
		<hr>
		<a href="${pageContext.request.contextPath}/admin">Admin page</a>
	</security:authorize>
	
	<hr>
	
	<security:authorize access="hasRole('MANAGER')">
		<a href="${pageContext.request.contextPath}/manager">manager page</a>	
	</security:authorize>
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="logout">
	</form:form>
</body>
</html>