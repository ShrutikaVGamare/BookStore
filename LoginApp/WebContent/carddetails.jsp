<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="CardServlet">
<input type="hidden" name="action" value="confirmCardDetails">
<input type="hidden" name="shippingId" value="${requestScope.shippingid}">


Card Number : <input type="text" name="cardNo"><br/>
Card Type:   <input type="text" name="cardType"><br/>
Company :   <input type="text" name="company"><br/>
Expiration Date <input type="text" name="expDate"><br/>
Billing Address

Street : <input type="text" name="street"><br/>
Zip :<input type="text" name="zip"><br/>
Country : <input type="text" name="country"><br/>
State : <input type="text" name="state"><br/>


<input type="submit" value="Submit">


</form>
</body>
</html>