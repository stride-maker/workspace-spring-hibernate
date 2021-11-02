<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<title> Customer Confirmation</title>
	</head>
	<body>
		Customer is confirmed: ${customer.firstName} ${customer.lastName}
		
		<br><br>
		
		Customer free passes: ${customer.freePasses}
		
		<br><br>
		
		Customer Postal Code: ${customer.postalCode}
		
		<br><br>
		
		Customer Course Code: ${customer.courseCode}
	</body>
</html>