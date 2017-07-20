<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="org.shrutika.mvc.dto.Book"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Book book=(Book)request.getAttribute("result");

%>
<form action="BookServlet" method="post"> 
<br><input type="hidden" name="AdminAction" value="update"/>
<br>Book ISBN:<input type="text" name="book_ISBN" value=<%= book.getISBN() %> />
<br>Book Title:<input type="text" name="book_title" value=<%=book.getBook_title() %>/>
<br>Book Price:<input type="text" name="book_price" value=<%=book.getBook_price() %>/>
<br>Book Quantity:<input type="text" name="book_quantity" value=<%=book.getBook_quantity() %>/>
<br>Book Cover:<input type="text" name="book_cover"value=<%=book.getBook_cover() %>/>
<br>Book Category:<input type="text" name="book_category"value=<%=book.getBook_category() %>/>
<br>Book Description:<input type="text" name="book_desc"value=<%=book.getBook_description() %>/>
<br>ThresholdLimit:<input type="text" name="book_threshold"value=<%=book.getBook_threshold() %>/>
<br><input type="submit" value="Update" />
</form>
</body>
</html>