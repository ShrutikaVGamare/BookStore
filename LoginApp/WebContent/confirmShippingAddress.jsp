<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="ShippingAddressServlet">
<input type="hidden" name="action" value="submitShippingAddress">
<br/>
Street :  ${requestScope.address.street} <input type="hidden" name="street" value="${requestScope.address.street}"/>
<br/>
Country :   ${requestScope.address.country}<input type="hidden" name="country" value=" ${requestScope.address.country}" />
<br/>
State :   ${requestScope.address.state}<input type="hidden" name="state" value=" ${requestScope.address.street}"/>
<br/>
Zip :  ${requestScope.address.zipCode}<input type="hidden" name="zip" value="${requestScope.address.zipCode}"/>
<br/>
<input type="submit" value="submit"/>



</form> 
</body>
</html>