<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
	<title>List Customers</title>
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	
	<div id="wrapper">
		<div id="header">
			<h4>Welcome, <security:authentication property="principal.username"/> !</h4>
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content"> 
			
			<form:form action="${pageContext.request.contextPath}/register" method="GET">
				<input type="submit" value="Add Customer" />
			</form:form>
			
			<br>
			
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Authority</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
				<c:forEach items="${customers}" var="customer">
					<c:url var="deleteUrl" value="delete">
						<c:param name="email" value="${customer.email}"/>
					</c:url>
					<tr>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.email}</td>
						<td>${customer.authority}</td>
						<td>
							<form:form action="update" method="GET">
								<input name="email" value="${customer.email}">
								<input type="submit" value="Update Customer" />
							</form:form>
						</td>
						<td>
							<form:form action="${deleteUrl}" method="DELETE">
								<input type="submit" value="Delete Customer" />
							</form:form>
						</td>
					</tr>
				</c:forEach>
			</table>
			
			<form:form action="${pageContext.request.contextPath}/logout" method="POST">
				<input type="submit" value="Logout" />
			</form:form>
			
		</div>
	
	</div>

</body>

</html>