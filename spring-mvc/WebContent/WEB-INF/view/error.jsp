<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h2>ERROR!</h2>
	<br>
	<c:if test="${not empty exp.errorCode && not empty exp.errorMessage}">
		<h1>${exp.errorCode}: ${exp.errorMessage}</h1>
	</c:if>
	<h2>Customer:${customer.firstName}</h2>
</body>
</html>