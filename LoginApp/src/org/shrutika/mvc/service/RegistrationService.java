package org.shrutika.mvc.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import org.shrutika.mvc.dto.UserDetails;

public class RegistrationService 
{

	public String insert(UserDetails user) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		  Connection conn=null;

		try
		{
System.out.println("Hello");
		String driver="org.postgresql.Driver";
		Class.forName(driver).newInstance();
		
		Properties props = new Properties();
		props.setProperty("user","postgres");
		props.setProperty("password","shrutika");
		//props.setProperty("ssl","true");
		
		conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",props);
		PreparedStatement ps=conn.prepareStatement("insert into registered_users values(?,?,?,?,?,?,'2')");
		ps.setString(1, user.getUserID());
		ps.setString(2, user.getFirstname());
		ps.setString(3, user.getLastname());
		ps.setString(4, user.getPhoneNo());
		ps.setString(5, user.getEmail());
		ps.setString(6, user.getPassword());
		

		// execute insert SQL statement
		ps .executeUpdate();

		
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
	
	

}
