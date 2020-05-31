<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<body>
	
	<form:form action="${pageContext.request.contextPath}/process-register"
			   modelAttribute="customerDTO" 
			   method="POST">
		
		First name:
		<form:input path="firstName" type="text" /> 
		<form:errors path="firstName"/><br/>
		
		Last name:
		<form:input path="lastName" type="text" /> 
		<form:errors path="lastName"/><br/>
		
		Email address:
		<form:input path="email" type="text" />
		<form:errors path="email"/><br/>
		
		Password:
		<form:input path="password" type="password" />
		<form:errors path="password"/><br/>
		
		Role:
		<form:input path="authority" type="text" />
		<form:errors path="authority"/><br/>
		
		<input type="submit" name="Register" />
		
	</form:form>
</body>

</html>