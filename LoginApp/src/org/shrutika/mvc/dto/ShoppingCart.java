package org.shrutika.mvc.dto;

public class ShoppingCart {
	
private	String userId;
private int cartid;

private Book book;
private int quantity;
private int promocode;
private double actualprice;
private double discountedprice;
private int isbn;

public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getPromocode() {
	return promocode;
}
public void setPromocode(int promocode) {
	this.promocode = promocode;
}
public double getActualprice() {
	return actualprice;
}
public void setActualprice(double actualprice) {
	this.actualprice = actualprice;
}
public double getDiscountedprice() {
	return discountedprice;
}
public void setDiscountedprice(double discountedprice) {
	this.discountedprice = discountedprice;
}
public int getIsbn() {
	return isbn;
}
public void setIsbn(int isbn) {
	this.isbn = isbn;
}

public int getCartid() {
	return cartid;
}
public void setCartid(int cartid) {
	this.cartid = cartid;
}
public Book getBook() {
	return book;
}
public void setBook(Book book) {
	this.book = book;
}

}
