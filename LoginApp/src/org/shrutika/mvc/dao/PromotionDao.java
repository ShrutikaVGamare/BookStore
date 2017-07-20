package org.shrutika.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.shrutika.mvc.dto.Promotions;

public class PromotionDao {

	public String addPromotion(Promotions promotions) {
		// TODO Auto-generated method stub
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
		
			PreparedStatement ps=conn.prepareStatement("insert into  promocodes values(?,?,?,?)");
			ps.setInt(1, promotions.getPromocode());
			ps.setInt(2, promotions.getCouponvalue());
			ps.setInt(3, promotions.getCouponclass());
			ps.setInt(4, promotions.getIsbn());

			// execute insert SQL statement
			int result=ps.executeUpdate();

			
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
			return "Success";

	}

	public List<Promotions> getAllPromotions() {
		// TODO Auto-generated method stub
		 Connection conn=null;
		 List<Promotions> promList=new ArrayList<Promotions>();
			try
			{
			String driver="org.postgresql.Driver";
			Class.forName(driver).newInstance();
			
			Properties props = new Properties();
			props.setProperty("user","postgres");
			props.setProperty("password","shrutika");
			//props.setProperty("ssl","true");
			
			conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",props);
		
			PreparedStatement ps=conn.prepareStatement("select * from promocodes");
			

			// execute insert SQL statement
			ResultSet rs=ps.executeQuery();
			
			Promotions promotion=null;
			while(rs.next())
			{
				promotion=new Promotions();
				promotion.setIsbn(rs.getInt("isbn"));
				promotion.setCouponclass(rs.getInt("couponclass"));
				promotion.setCouponvalue(rs.getInt("couponvalue"));
				promotion.setPromocode(rs.getInt("promocode"));
				promList.add(promotion);
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
			
		return promList;
	}

	public List<Promotions> deletePromo(String[] selectedPromos) 
	{
		 
		 Connection conn=null;
		 List<Promotions> promList=new ArrayList<Promotions>();

			try
			{
			String driver="org.postgresql.Driver";
			Class.forName(driver).newInstance();
			
			Properties props = new Properties();
			props.setProperty("user","postgres");
			props.setProperty("password","shrutika");
			//props.setProperty("ssl","true");
			
			conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",props);
			
		 
			PreparedStatement ps=null;
			for(String promocode:selectedPromos)
			{
			ps=conn.prepareStatement("delete from promocodes where promocode =?");
			ps.setInt(1, Integer.parseInt(promocode));
			int result=ps.executeUpdate();
			}
			

			// execute insert SQL statement
			
			 ps=conn.prepareStatement("select * from promocodes");
				

				// execute insert SQL statement
				ResultSet rs=ps.executeQuery();
				
				Promotions promotion=null;
				while(rs.next())
				{
					promotion=new Promotions();
					promotion.setIsbn(rs.getInt("isbn"));
					promotion.setCouponclass(rs.getInt("couponclass"));
					promotion.setCouponvalue(rs.getInt("couponvalue"));
					promotion.setPromocode(rs.getInt("promocode"));
					promList.add(promotion);
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
			return promList;
	}

}
