<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<h2>Student Form</h2>
	<form:form action="process" modelAttribute="student" method="get">
		First name: <form:input path="fname"/> <br>
		Last  name:  <form:input path="lname"/> <br>
		Country: 
		<form:select path="country">
			<form:option value="EG Country" label="EG"/>
			<form:option value="KSA Country" label="KSA"/>
			<form:option value="USA Country" label="USA"/>
			<form:options items="${student.countries}"/>
		</form:select> <br>
		<form:radiobuttons path="favLang" items="${student.radios}" /> <br>
		<form:checkboxes path="meals" items="${student.foods}" /> <br>
		<input type="submit">
	</form:form>
</html>