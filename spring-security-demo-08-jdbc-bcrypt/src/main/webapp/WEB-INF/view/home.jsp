<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>
	<head>
		<title>
			Home
		</title>
	</head>
	
	<body>
		<h2> Welcome to Mohit Company!!</h2>
		<hr>
		
		<!-- display username and role -->
		<p>
			User: <security:authentication property="principal.username"/>
			<br><br>
			Role(s): <security:authentication property="principal.authorities"/>
		</p>
		
		<hr>
		
		<!-- add a link to /leaders -- only for managers -->
		<security:authorize access="hasRole('MANAGER')">
			<p>
				<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
				(Only for Manager peeps)
			</p>
		</security:authorize>
		
		<security:authorize access="hasRole('ADMIN')">
			<p>
				<a href="${pageContext.request.contextPath}/systems">Admins Meeting</a>
				(Only for Admin peeps)
			</p>
		</security:authorize>
		<hr>
		<form:form action="${pageContext.request.contextPath}/logout"
				   method="POST">
			<input type="submit" value="logout">
		</form:form>
	</body>
</html>