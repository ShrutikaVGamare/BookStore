package org.shrutika.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.shrutika.mvc.dto.ShippingAddress;

public class ShippingAddressDao {

	public int addShippingAddress(ShippingAddress address) {
		// TODO Auto-generated method stub
		
		 Connection conn=null;
		 int shippingId=0;
			try
			{
			String driver="org.postgresql.Driver";
			Class.forName(driver).newInstance();
			
			Properties props = new Properties();
			props.setProperty("user","postgres");
			props.setProperty("password","shrutika");
			//props.setProperty("ssl","true");
			
			conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",props);
			String sqlIdentifier = "SELECT nextval('shippingidseq');";
			PreparedStatement pst = conn.prepareStatement(sqlIdentifier);
			ResultSet rs = pst.executeQuery();
			   if(rs.next())
			   {
				   shippingId = (int) rs.getInt(1);
			   }
			    
			PreparedStatement ps=conn.prepareStatement("insert into shippingaddress values(?,'A','P',?,?,?,?,?)");
			ps.setInt(1, shippingId);
			ps.setString(2, address.getStreet());
			ps.setInt(3, address.getZipCode());
			ps.setString(4, address.getState());
			ps.setString(5, address.getCountry());
			ps.setString(6, "shru");
			
			

			// execute insert SQL statement
			int res=ps.executeUpdate();
			if(res>0)
			{
				System.out.println("Sucessful insert");
			}
			else
			{
				System.out.println("Failed to insert");
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
	

		return shippingId;
	}

}
