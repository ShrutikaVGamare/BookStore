<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="org.shrutika.mvc.dto.Promotions"%>
<%@ page import="java.util.List" %>    
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="promotionServlet">
<table>
    <c:forEach items="${requestScope.promList}" var="promotions">
        <tr>
            <td>Promo Code: <c:out value="${promotions.promocode}"/></td>
		    <td>Coupon Value: <c:out value="${promotions.couponvalue}"/></td>
			<td>Coupon Class: <c:out value="${promotions.couponclass}"/></td>
 			<td>Book ISBN: <c:out value="${promotions.isbn}"/></td>
 			
 			<td><input type="checkbox" name="selected" value="${promotions.promocode}"></td> 
            <!-- <td><a href="promotionServlet?AdminAction=deleteCode">Delete PromoCode</a>  -->
        </tr>
    </c:forEach>
</table> 
<input type="hidden" name="AdminAction" value="deletePromotion">
<input type="submit" name="submit" value="DELETE"/>
</form>
</body>
</html>