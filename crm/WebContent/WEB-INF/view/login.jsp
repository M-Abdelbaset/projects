<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<body>

	<c:if test="${param.error != null}">
		<p>Bad Credentials!</p>
	</c:if>
	
	<c:if test="${param.error != null}">
		<p>Bad Credentials!</p>
	</c:if>
	<c:if test="${param.logout != null}">
		<p>Loged out successfully!!</p>
	</c:if>
	<form:form action="${pageContext.request.contextPath}/process-login" method="POST">
		username: <input type="text" name="username" /> <br/>
		password: <input type="password" name="password" /> <br/>
		<input type="submit" />
	</form:form>
	
	<a href="${pageContext.request.contextPath}/register">Register</a>
</body>

</html>