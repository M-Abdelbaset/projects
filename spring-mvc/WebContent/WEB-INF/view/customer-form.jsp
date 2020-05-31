<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
	<h2>Customer Form</h2>
	<form:form action="process" modelAttribute="customer" method="post"> 
		First name <form:input path="firstName"/> <br>
		Last  name (*) <form:input path="lastName"/>
		<form:errors path="lastName" cssClass="error"/><br>
		PostalCode <form:input path="postalCode"/>
		<form:errors path="postalCode" cssClass="error"/> <br>
		Count <form:input path="count"/>
		<form:errors path="count" cssClass="error"/> <br>
		Course <form:input path="course"/>
		<form:errors path="course" cssClass="error"/> <br>
		<input type="submit">
	</form:form>
</html>