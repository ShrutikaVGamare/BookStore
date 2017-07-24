package org.shrutika.mvc.dto;

import java.util.ArrayList;
import java.util.List;

public class SalesReport {

	private double totalActualPrice;
	private double totalPriceSoldfor;
	private int totalQuantitysold;
	private List<Book> book=new ArrayList<Book>();

	public double getTotalActualPrice() {
		return totalActualPrice;
	}
	public void setTotalActualPrice(double totalActualPrice) {
		this.totalActualPrice = totalActualPrice;
	}
	public double getTotalPriceSoldfor() {
		return totalPriceSoldfor;
	}
	public void setTotalPriceSoldfor(double totalPriceSoldfor) {
		this.totalPriceSoldfor = totalPriceSoldfor;
	}
	public int getTotalQuantitysold() {
		return totalQuantitysold;
	}
	public void setTotalQuantitysold(int totalQuantitysold) {
		this.totalQuantitysold = totalQuantitysold;
	}
	public List<Book> getBook() {
		return book;
	}
	public void setBook(List<Book> book) {
		this.book = book;
	}
	
}
