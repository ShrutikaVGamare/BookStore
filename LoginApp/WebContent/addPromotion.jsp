<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="promotionServlet" method="post"> 
<br><input type="hidden" name="AdminAction" value="add"/>
<br>Promo Code:<input type="text" name="promocode"/>
<br>Coupon Code:<input type="text" name="copCode"/>
<br>Coupon Class:<input type="text" name="copClass"/>
<br>Book ISBN<input type="text" name="isbn"/>

<br><input type="submit" />
</form>
</body>
</html>