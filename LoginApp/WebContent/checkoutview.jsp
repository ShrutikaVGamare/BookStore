<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
View
<form method="post" action="">
<input type="hidden" name="action" value="shippingaddress">
<table>
<c:forEach items="${requestScope.shoppingcart}" var="item">
<tr>
<td style="display: none;">${item.cartid}</td>
<td>${item.isbn}</td><td>${item.quantity}</td>
<td>${item.book.book_title}</td><td>${item.actualprice}</td>
<td>${item.discountedprice}</td><td><a href="">delete Item From Cart</a></td>
</tr>

</c:forEach>
<button type="button" class="button">Remove All Items</button>
<input type="submit" value="Proceed to Checkout"></input>


</table>
</form>
</body>
</html>