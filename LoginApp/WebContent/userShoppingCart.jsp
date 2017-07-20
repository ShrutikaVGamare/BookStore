<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	  <script src="js/cart.js">
	  
	</script>
<title>Insert title here</title>
</head>

<body>
<table>
<tr><th>ISBN</th><th>Title</th><th>Price</th><th>Description</th><th>Quantity Available</th>
<th>Category</th><th>Cover Photo</th><th></th>
</tr>

<c:forEach items="${requestScope.books}" var="book">
<tr>
<td abbr="modalISBN"><c:out value="${book.ISBN}"></c:out></td>
<td abbr="modalTitle"><c:out value="${book.book_title}"></c:out></td>
<td abbr="modalPrice"><c:out value="${book.book_price}"></c:out></td>
<td abbr="modalDescription"><c:out value="${book.book_description}"></c:out></td>
<td abbr="modalCartSel"><c:out value="${book.book_quantity}"></c:out></td>
<td abbr="modalCategory"><c:out value="${book.book_category}"></c:out></td>
<td abbr="modalCover"><c:out value="${book.book_cover}"></c:out></td>
<td><a class="addtoCart">Add to Cart</a></td>

</tr>

</c:forEach>
</table>

<div id="mycartModal" class="modal" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Modal Header</h4>
      </div>
      <div class="modal-body">
       <form method="get" action="ShoppingCartServlet">
       <input type="hidden" name="action" value="addtocart">
       Your Interest<br/>
       Book isbn   <input id="modalISBN" name="modalISBN" type="text" disabled="disabled" value="1"></input> <br/>
       Title     <input id="modalTitle" name="modalTitle" type="text" disabled="disabled" ><br/>
       Price  <input id="modalPrice" name="modalPrice" type="text" disabled="disabled" ><br/>
       Quantity  <select name= "modalCartSel" id="modalCartSel">     
       
       
       </select><br/>
       Description  <input id="modalDescription" name="modalDescription" type="text" disabled="disabled" ><br/>
       Category  <input id="modalCategory" name="modalCategory" type="text" disabled="disabled" ><br/>
       Cover Photo  <input id="modalCover" name="modalCover" type="text" disabled="disabled" ><br/>
       PromoCode    <input id="modalPromoCode" name="modalPromoCode" type="text"><br/>
        <button type="button" class="btn btn-default"  id="addCartModalBtn"> Add To Cart</button> 
      <!-- <input type="submit" name="submit" value="Add" > -->
       </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
<form method="post" action="ShoppingCartServlet" id="addtoCartHidden">
<input type="hidden" name="action" value="addtocart">
<input id="isbn" name="isbn" type="hidden" ></input>
<input id="category" name="category" type="hidden" ></input>
<input id="cover" name="cover" type="hidden" ></input>
<input id="promocode" name="promocode" type="hidden" ></input>
<input id="description" name="description" type="hidden" ></input>
<input id="quantity" name="quantity" type="hidden" ></input>
<input id="title" name="title" type="hidden" ></input>
<input id="price" name="price" type="hidden" ></input>






</form>
</body>
</html>