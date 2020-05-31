<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<body>
	
	<h3>Update Customer</h3>
	<form:form action="${pageContext.request.contextPath}/customer/update"
			   modelAttribute="customerDTO" 
			   method="PUT">
		First name: <form:input path="firstName" type="text" /> 
		<form:errors path="firstName"/><br/>
		Last name: <form:input path="lastName" type="text" /> 
		<form:errors path="lastName"/><br/>
		<input type="submit" name="Update" />
	</form:form>
	<a href="${pageContext.request.contextPath}/">Home</a>
</body>

</html>