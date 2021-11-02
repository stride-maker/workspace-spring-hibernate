<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
	<head>
		<title>
			Home
		</title>
	</head>
	
	<body>
		<h2> Welcome to Mohit Company!!</h2>
		<h3> Yoohoo!!!</h3>
		
		<form:form action="${pageContext.request.contextPath}/logout"
				   method="POST">
			<input type="submit" value="logout">
		</form:form>
	</body>
</html>