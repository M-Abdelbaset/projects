<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $('#put').click(  function () {
                $.ajax({
                    url: 'http://localhost:8080/security/csrf',
                    type: 'PUT',
                    data: {
                        
                    },
                    success: function () {
                    }
                })
                ;

            });
        });
    </script>
</head>
<body>
	
	<form action="${pageContext.request.contextPath}/csrf" method="GET">
		<input type="submit" value="get">
	</form>
	
	<form action="${pageContext.request.contextPath}/csrf" method="POST">
		<input type="submit" value="post">
	</form>
	
	<form:form action="${pageContext.request.contextPath}/csrf" method="POST">
		<input type="submit" value="csrf post">
	</form:form>
	
	<form> <!-- PUT -->
		<input id="put" type="submit" value="put">
	</form>
</body>
</html>