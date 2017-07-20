package org.shrutika.mvc.service;

import java.util.List;

import org.shrutika.mvc.dao.ShoppingCartDao;
import org.shrutika.mvc.dto.Book;
import org.shrutika.mvc.dto.ShoppingCart;

public class ShoppingCartService {

	public List<Book> addToCart(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		ShoppingCartDao addTocartDao=new ShoppingCartDao();
		List<Book> books=addTocartDao.addToCart(shoppingCart);
		return books;
	}

	public List<ShoppingCart> viewcart(String userid) 
	{
		ShoppingCartDao shopCartDao= new ShoppingCartDao();
		return shopCartDao.viewcart(userid);
		
		
	}

	public List<Double> getPrices(String userid) {
		// TODO Auto-generated method stub
		ShoppingCartDao shoppingCartDao=new ShoppingCartDao();
		
		return shoppingCartDao.getPrices(userid);
	}

}
