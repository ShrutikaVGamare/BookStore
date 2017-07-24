package org.shrutika.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.shrutika.mvc.dto.CardDetails;
import org.shrutika.mvc.dto.ShoppingCart;
import org.shrutika.mvc.emailsender.EmailSender;

public class TransactionDao {

	public String perfromTransaction(CardDetails details, String shippingId) {
		// TODO Auto-generated method stub
		 Connection conn=null;
		 
		 int transactionid=1;
			try
			{
			String driver="org.postgresql.Driver";
			Class.forName(driver).newInstance();
			
			Properties props = new Properties();
			props.setProperty("user","postgres");
			props.setProperty("password","shrutika");
			//props.setProperty("ssl","true");
			
			conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",props);
			String sqlIdentifier = "SELECT nextval('card_seq');";
			PreparedStatement pst = conn.prepareStatement(sqlIdentifier);
			ResultSet rs1 = pst.executeQuery();
			int cardId=0;
			   if(rs1.next())
			   {
				    cardId= (int) rs1.getLong(1);
			   }
			
			PreparedStatement ps=conn.prepareStatement("insert into carddetails values(?,'P',?,?,?,current_timestamp,?,?,?,?,?)");
			ps.setInt(1, cardId);
			ps.setString(2, details.getCardNo());
			ps.setString(3, details.getCardType());
			ps.setString(4, details.getCompany());
			ps.setString(5, details.getBillingAddress().getStreet());
			ps.setInt(6, details.getBillingAddress().getZipCode());
			ps.setString(7, details.getBillingAddress().getState());
			ps.setString(8, details.getBillingAddress().getCountry());
			ps.setString(9,"shru");
			
			

			// execute insert SQL statement
			ps.executeUpdate();

			// Now Genrate a transaction Id via a transaction sequence and store it an int variable
			ps=conn.prepareStatement("select * from shoppingcart where cartstatus='A'and userid=?");
			ps.setString(1, "shru");
			
			ResultSet rs=ps.executeQuery();
			List<ShoppingCart> shopList=new ArrayList<ShoppingCart>();
			ShoppingCart cart=null;
			while(rs.next())
			{   cart=new ShoppingCart();
				cart.setIsbn(rs.getInt("isbn"));
				cart.setQuantity(rs.getInt("quantity"));
				double actualPrice=rs.getDouble("actualprice");
				double discountedPrice=rs.getDouble("discountedprice");
				cart.setActualprice(actualPrice*cart.getQuantity());
				cart.setDiscountedprice(discountedPrice*cart.getQuantity());
				cart.setPromocode(rs.getInt("promocode"));
				shopList.add(cart);
			}
			String sqlIdentifier1 = "SELECT nextval('transaction_seq');";
			PreparedStatement pst1 = conn.prepareStatement(sqlIdentifier);
			 rs = pst1.executeQuery();
			   if(rs.next())
			   {
				   transactionid = (int) rs.getLong(1);
			   }
			
			for(ShoppingCart shopcart:shopList)
			{
				ps=conn.prepareStatement("insert into transactions values(?,?,?,current_timestamp,?,?,?,?,?,?,?)");
				ps.setInt(1, transactionid);
				ps.setString(2, "shru");
				ps.setInt(3, shopcart.getQuantity());
				ps.setInt(4, shopcart.getPromocode());
				ps.setDouble(5, shopcart.getActualprice());
				ps.setDouble(6, shopcart.getDiscountedprice());
				ps.setDouble(7, 0);
				ps.setInt(8, shopcart.getIsbn());
				ps.setInt(9, Integer.parseInt(shippingId));
				ps.setInt(10, cardId);
				ps.executeUpdate();
				
				
			}
			// After that get all shiiping details of user which status A Isbn , actual 
			ps=conn.prepareStatement("update shoppingcart set cartstatus='R' where userid=?");
			ps.setString(1, "shru");
			ps.executeUpdate();
            System.out.println("Sending ");
			
			ps=conn.prepareStatement("select email from registered_users where userid=?");
			ps.setString(1, "shru");
			ResultSet res=ps.executeQuery();
			if(res.next())
			{
				String email=res.getString("email");
				String[] to={email};
				EmailSender sender=new EmailSender();
			boolean result=	sender.sendMail(email, "liveIT@92", "Suceess", to);
			if(result)
			{
				System.out.println("Mail Send");
			}
			else
			{
				System.out.println("Failed to send mail");
			}
				
			}
			}
			catch(Exception e)
			{   e.printStackTrace();
			System.out.println("Hi");;
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
			

		return null;
	}

}
