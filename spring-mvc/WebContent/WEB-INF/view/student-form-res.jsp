<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<h2>Form Result</h2>
<p>Full Name: ${student.fname} ${student.lname}</p> <br>
<p>Country: ${student.country}</p>
<p>Favorite Language: ${student.favLang}</p>
<ul>
	<c:forEach var="meal" items="${student.meals}">
		<li>${meal}<li>
	</c:forEach>
</ul>
</html>