<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="BookServlet" method="post"> 
<br><input type="hidden" name="AdminAction" value="add"/>
<br>Book Title:<input type="text" name="book_title"/>
<br>Book Price:<input type="text" name="book_price"/>
<br>Book Quantity:<input type="text" name="book_quantity"/>
<br>Book Cover:<input type="text" name="book_cover"/>
<br>Book Category:<input type="text" name="book_category"/>
<br>Book Description:<input type="text" name="book_desc"/>
<br>ThresholdLimit:<input type="text" name="book_threshold"/>
<br><input type="submit" />
</form>
</body>
</html>