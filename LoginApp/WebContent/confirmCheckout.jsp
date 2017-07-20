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
<input type="hidden" name="action" value="submitTransaction">
<input type="hidden" name="shippingId" value="${requestScope.shippingid}">


Card Number : ${requestScope.carddetails.cardNo} <input type="hidden" name="cardNo" value="${requestScope.carddetails.cardNo}"><br/>
Card Type: ${requestScope.carddetails.cardType}  <input type="hidden" name="cardType" value="${requestScope.carddetails.cardType}"><br/>
Company :  ${requestScope.carddetails.company}  <input type="hidden" name="company" value="${requestScope.carddetails.company}"><br/>
Expiration Date : ${requestScope.carddetails.expiratationDate}<input type="hidden" name="expDate" value="${requestScope.carddetails.expiratationDate}"><br/>
Billing Address


Street : ${requestScope.carddetails.billingAddress.street}<input type="hidden" name="street" value="${requestScope.carddetails.billingAddress.street}"><br/>
Zip : ${requestScope.carddetails.billingAddress.zipCode}<input type="hidden" name="zip" value="${requestScope.carddetails.billingAddress.zipCode}"><br/>
Country : ${requestScope.carddetails.billingAddress.country} <input type="hidden" name="country" value="${requestScope.carddetails.billingAddress.country} "><br/>
State : ${requestScope.carddetails.billingAddress.state} <input type="hidden" name="state" value="${requestScope.carddetails.billingAddress.state}">
<br/>


<input type="submit" value="Submit">
</form>
</body>
</html>