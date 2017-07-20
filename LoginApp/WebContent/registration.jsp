<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="RegistrationServlet">
<br> FirstName: <input type="text" name="firstname"/>
<br> LastName: <input type="text" name="lastname"/>
<br> PhoneNo: <input type="text" name="phone"/>
<br> Email: <input type="text" name="email"/>
<br> UserId/User_Name: <input type="text" name="userID"/>
<br> Password: <input type="password" name="password"/>
<br> VerifyPassword: <input type="password" name="password1"/>
<input type="submit"/>

 </form>
</body>
</html>