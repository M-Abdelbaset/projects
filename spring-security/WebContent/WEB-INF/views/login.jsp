<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<body>
<h3>Custom login page</h3>
<form:form method="POST" action="${pageContext.request.contextPath}/process">
	<c:if test="${param.error != null}">
		<p>Bad credentials!!</p>
	</c:if>
	<c:if test="${param.logout != null}">
		<p>Loged out successfully!!</p>
	</c:if>
	<p>user name: <input type="text" name="username" /></p>
	<p>password:  <input type="password" name="password" /></p>
	<input type="submit" value="login" />
</form:form>

</body>
</html>