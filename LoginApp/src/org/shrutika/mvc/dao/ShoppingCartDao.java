package org.shrutika.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.shrutika.mvc.dto.Book;
import org.shrutika.mvc.dto.ShoppingCart;

public class ShoppingCartDao {

	public List<Book> addToCart(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		System.out.println("Add to cart Dao Layer");
		 Connection conn=null;
		 Book book=null;
		 List<Book> books=new ArrayList<Book>();
			try
			{
			String driver="org.postgresql.Driver";
			Class.forName(driver).newInstance();
			Properties props = new Properties();
			props.setProperty("user","postgres");
			props.setProperty("password","shrutika");
			//props.setProperty("ssl","true");
			
			conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",props);
			PreparedStatement ps=conn.prepareStatement("select * from promocodes where isbn=? and promocode=?");
			ps.setInt(1, 1);
			ps.setInt(2, 1);
			ResultSet rs=ps.executeQuery();
			shoppingCart.setUserId("shru");
			if(rs.next())
			{
				shoppingCart.setDiscountedprice(calculateDiscount(shoppingCart.getActualprice()));
			}
			else
			{
				shoppingCart.setDiscountedprice(shoppingCart.getActualprice());
			}
			
			ps=conn.prepareStatement("select * from shoppingcart where isbn=? and userid=? and cartstatus='A'");
			ps.setInt(1,shoppingCart.getIsbn());
			ps.setString(2, shoppingCart.getUserId());
			rs=ps.executeQuery();
			if(rs.next())
			{
				ps=conn.prepareStatement("update shoppingcart set quantity=quantity+? where userid=? and cartstatus='A' and isbn=?");
				ps.setInt(1, shoppingCart.getQuantity());
				ps.setString(2, shoppingCart.getUserId());
				ps.setInt(3, shoppingCart.getIsbn());
				ps.executeUpdate();
				
				ps=conn.prepareStatement("update books set quantity=quantity-? where isbn=?");
				ps.setInt(1, shoppingCart.getQuantity());
				ps.setInt(2, shoppingCart.getIsbn());
				int updateResult=ps.executeUpdate();
				System.out.println("Successfully updated ! :");
			}
			else{
			ps=conn.prepareStatement("insert into shoppingcart values(?,?,current_timestamp,?,?,?,?,'A',nextval('shopseq'))");
			ps.setString(1, shoppingCart.getUserId());
			ps.setInt(2, shoppingCart.getQuantity());
			ps.setInt(3, shoppingCart.getPromocode());
			ps.setDouble(4, shoppingCart.getActualprice());
			ps.setDouble(5, shoppingCart.getDiscountedprice());
			ps.setInt(6, shoppingCart.getIsbn());
			
			int result=ps.executeUpdate();
			if(result>0)
			{
				System.out.println("Successful insert");
			}
			else
			{
				System.out.println("Failed");
			}
		ps=conn.prepareStatement("update books set quantity=quantity-? where isbn=?");
		ps.setInt(1, shoppingCart.getQuantity());
		ps.setInt(2, shoppingCart.getIsbn());
		int updateResult=ps.executeUpdate();
		if(updateResult>0)
		{
			System.out.println("Successful update");
		}
		else
		{
			System.out.println("Failed");
		}
			}
		 ps=conn.prepareStatement("select * from books");
		 rs=ps.executeQuery();
		while(rs.next())
		{
			book=new Book();
			book.setISBN(rs.getInt("isbn"));
			book.setBook_title(rs.getString("title"));
			book.setBook_description(rs.getString("description"));
			book.setBook_quantity(rs.getInt("quantity"));
			book.setBook_price(rs.getDouble("price"));
			book.setBook_cover(rs.getString("coverphoto"));
			book.setBook_category(rs.getString("category"));
			book.setBook_threshold(rs.getInt("thresholdlimit"));
			books.add(book);
		}
			}
			catch(Exception e)

			{   e.printStackTrace();
				throw new RuntimeException();
			}
			finally
			{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		return books;
	}

	private double calculateDiscount(double actualprice) 
	{
		
		return actualprice/2;
	}

	public List<ShoppingCart> viewcart(String userid) {
		List<ShoppingCart> shoppedItems=new ArrayList<ShoppingCart>();
		ShoppingCart shopcart=null;
		
		Connection conn=null;
			try
			{
			String driver="org.postgresql.Driver";
			Class.forName(driver).newInstance();
			
			Properties props = new Properties();
			props.setProperty("user","postgres");
			props.setProperty("password","shrutika");
			//props.setProperty("ssl","true");
			
			conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",props);
			
			    
			PreparedStatement ps=conn.prepareStatement("select * from shoppingcart where userid=? and cartstatus='A'");
			ps.setString(1,"shru");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				shopcart=new ShoppingCart();
				shopcart.setUserId(rs.getString("userid"));
				shopcart.setQuantity(rs.getInt("quantity"));
				shopcart.setPromocode(rs.getInt("promocode"));
				shopcart.setActualprice(rs.getDouble("actualprice"));
				shopcart.setDiscountedprice(rs.getDouble("discountedprice"));
				shopcart.setIsbn(rs.getInt("isbn"));
				shopcart.setCartid(rs.getInt("cartid"));
				ps=conn.prepareStatement("select * from books where isbn=?");
				ps.setInt(1, shopcart.getIsbn());
				ResultSet rs1=ps.executeQuery();
				Book book=new Book();
				
				while(rs1.next())
				{
					book.setISBN(shopcart.getIsbn());
					book.setBook_title(rs1.getString("title"));
					book.setBook_price(rs1.getDouble("price"));
					book.setBook_quantity(rs1.getInt("quantity"));
					book.setBook_cover(rs1.getString("coverphoto"));
					book.setBook_category(rs1.getString("category"));
					book.setBook_description(rs1.getString("description"));
					book.setBook_threshold(rs1.getInt("thresholdlimit"));
				}
				
				shopcart.setBook(book);
				
				shoppedItems.add(shopcart);
			}

			// execute insert SQL statement

			
			}
			catch(Exception e)
			{   e.printStackTrace();
				throw new RuntimeException();
			}
			finally
			{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return shoppedItems;
	}

	public List<Double> getPrices(String userid) {
		// TODO Auto-generated method stub
		 Connection conn=null;
		 List<Double> priceList=new ArrayList<>();
			try
			{
			String driver="org.postgresql.Driver";
			Class.forName(driver).newInstance();
			
			Properties props = new Properties();
			props.setProperty("user","postgres");
			props.setProperty("password","shrutika");
			//props.setProperty("ssl","true");
			
			conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",props);
			
			    
			PreparedStatement ps=conn.prepareStatement("select sum(actualprice) from shoppingcart where userid=?");
			ps.setString(1, userid);
			ResultSet rs=ps.executeQuery();
		    if(rs.next())
		    {
		    	Double res=rs.getDouble(1);
		    	priceList.add(res);
		    	System.out.println(res);
		    }
			
			 ps=conn.prepareStatement("select sum(discountedprice) from shoppingcart where userid=?");
				ps.setString(1, userid);

			 rs=ps.executeQuery();
		    if(rs.next())
		    {
		    	Double res=rs.getDouble(1);
		    	priceList.add(res);
		    	System.out.println(res);
		    }

			// execute insert SQL statement

			
			}
			catch(Exception e)
			{   e.printStackTrace();
				throw new RuntimeException();
			}
			finally
			{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			

		return priceList;
	}

	public List<ShoppingCart> deleteItemFromCart(int cartId, String userid) {
		// TODO Auto-generated method stub
		List<ShoppingCart> shoppedItems=new ArrayList<ShoppingCart>();
		ShoppingCart shopcart=null;
		
		Connection conn=null;
			try
			{
			String driver="org.postgresql.Driver";
			Class.forName(driver).newInstance();
			
			Properties props = new Properties();
			props.setProperty("user","postgres");
			props.setProperty("password","shrutika");
			//props.setProperty("ssl","true");
			
			conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",props);
			PreparedStatement ps1=conn.prepareStatement("update shoppingcart set cartstatus='R' where cartid=? and userid=?");
			ps1.setInt(1, cartId);
			ps1.setString(2,"shru");
			ps1.executeUpdate();
		
			    
			PreparedStatement ps=conn.prepareStatement("select * from shoppingcart where userid=? and cartstatus='A'");
			ps.setString(1,"shru");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				shopcart=new ShoppingCart();
				shopcart.setUserId(rs.getString("userid"));
				shopcart.setQuantity(rs.getInt("quantity"));
				shopcart.setPromocode(rs.getInt("promocode"));
				shopcart.setActualprice(rs.getDouble("actualprice"));
				shopcart.setDiscountedprice(rs.getDouble("discountedprice"));
				shopcart.setIsbn(rs.getInt("isbn"));
				shopcart.setCartid(rs.getInt("cartid"));
				ps=conn.prepareStatement("select * from books where isbn=?");
				ps.setInt(1, shopcart.getIsbn());
				ResultSet rs1=ps.executeQuery();
				Book book=new Book();
				
				while(rs1.next())
				{
					book.setISBN(shopcart.getIsbn());
					book.setBook_title(rs1.getString("title"));
					book.setBook_price(rs1.getDouble("price"));
					book.setBook_quantity(rs1.getInt("quantity"));
					book.setBook_cover(rs1.getString("coverphoto"));
					book.setBook_category(rs1.getString("category"));
					book.setBook_description(rs1.getString("description"));
					book.setBook_threshold(rs1.getInt("thresholdlimit"));
				}
				
				shopcart.setBook(book);
				
				shoppedItems.add(shopcart);
			}

			// execute insert SQL statement

			
			}
			catch(Exception e)
			{   e.printStackTrace();
				throw new RuntimeException();
			}
			finally
			{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return shoppedItems;
	
	}

	public List<ShoppingCart> emptyCart(String userId) {
		// TODO Auto-generated method stub
		List<ShoppingCart> shoppedItems=new ArrayList<ShoppingCart>();
		ShoppingCart shopcart=null;
		
		Connection conn=null;
			try
			{
			String driver="org.postgresql.Driver";
			Class.forName(driver).newInstance();
			
			Properties props = new Properties();
			props.setProperty("user","postgres");
			props.setProperty("password","shrutika");
			//props.setProperty("ssl","true");
			
			conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",props);
			PreparedStatement ps1=conn.prepareStatement("update shoppingcart set cartstatus='R' where userid=?");
			ps1.setString(1,"shru");
			ps1.executeUpdate();
		
			    
			PreparedStatement ps=conn.prepareStatement("select * from shoppingcart where userid=? and cartstatus='A'");
			ps.setString(1,"shru");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				shopcart=new ShoppingCart();
				shopcart.setUserId(rs.getString("userid"));
				shopcart.setQuantity(rs.getInt("quantity"));
				shopcart.setPromocode(rs.getInt("promocode"));
				shopcart.setActualprice(rs.getDouble("actualprice"));
				shopcart.setDiscountedprice(rs.getDouble("discountedprice"));
				shopcart.setIsbn(rs.getInt("isbn"));
				shopcart.setCartid(rs.getInt("cartid"));
				ps=conn.prepareStatement("select * from books where isbn=?");
				ps.setInt(1, shopcart.getIsbn());
				ResultSet rs1=ps.executeQuery();
				Book book=new Book();
				
				while(rs1.next())
				{
					book.setISBN(shopcart.getIsbn());
					book.setBook_title(rs1.getString("title"));
					book.setBook_price(rs1.getDouble("price"));
					book.setBook_quantity(rs1.getInt("quantity"));
					book.setBook_cover(rs1.getString("coverphoto"));
					book.setBook_category(rs1.getString("category"));
					book.setBook_description(rs1.getString("description"));
					book.setBook_threshold(rs1.getInt("thresholdlimit"));
				}
				
				shopcart.setBook(book);
				
				shoppedItems.add(shopcart);
			}

			// execute insert SQL statement

			
			}
			catch(Exception e)
			{   e.printStackTrace();
				throw new RuntimeException();
			}
			finally
			{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return shoppedItems;
	}

}
