<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Deletes Book</title>
</head>
<body>
<form action="BookServlet" method="post">
<br><input type="hidden" name="AdminAction" value="delete"/>
<br><input type="text" name="book_id">
<br><input type="submit">

</form>
</body>
</html>