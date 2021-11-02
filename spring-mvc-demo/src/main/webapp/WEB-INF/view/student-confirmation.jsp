<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
	<head>
		<title> Student Confirmation Form</title>
	</head>
	<body>
	
		Student is confirmed: ${student.firstName} ${student.lastName}
	
		<br><br>
	
		Country: ${student.country}
		
		<br><br>
		
		Favorite Language: ${student.favoriteLanguage}
		
		<br><br>
		
		Operating System: 
		<ul>
		
			<c:forEach var="tempVar" items="${student.operatingSystems}">
				<li>${tempVar}</li>	
			</c:forEach>
			
		</ul>
	</body>
</html>