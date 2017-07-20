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

public class BookDao {

	public String addBook(Book bookObj) 
	{
		
		 Connection conn=null;
		 int bookID=0;
			try
			{
			String driver="org.postgresql.Driver";
			Class.forName(driver).newInstance();
			
			Properties props = new Properties();
			props.setProperty("user","postgres");
			props.setProperty("password","shrutika");
			//props.setProperty("ssl","true");
			
			conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",props);
			String sqlIdentifier = "SELECT nextval('book_isbn_seq');";
			PreparedStatement pst = conn.prepareStatement(sqlIdentifier);
			ResultSet rs = pst.executeQuery();
			   if(rs.next())
			   {
				   bookID = (int) rs.getLong(1);
			   }
			    
			PreparedStatement ps=conn.prepareStatement("insert into books values(?,?,?,?,?,?,?,?)");
			ps.setInt(1, bookID);
			ps.setString(2, bookObj.getBook_title());
			ps.setDouble(3, bookObj.getBook_price());
			ps.setInt(4, bookObj.getBook_quantity());
			ps.setString(5, bookObj.getBook_cover());
			ps.setString(6, bookObj.getBook_category());
			ps.setString(7, bookObj.getBook_description());
			ps.setInt(8, bookObj.getBook_threshold());
			

			// execute insert SQL statement
			ps.executeUpdate();

			
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

	public String deleteBook(int book_id) 
	{
		
		Connection conn=null;
			int bookID=book_id;
			try
			{
			String driver="org.postgresql.Driver";
			Class.forName(driver).newInstance();
			
			Properties props = new Properties();
			props.setProperty("user","postgres");
			props.setProperty("password","shrutika");
			//props.setProperty("ssl","true");
			
			conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",props);
			PreparedStatement ps=conn.prepareStatement("delete from books where isbn=?");
			ps.setInt(1, bookID);
			ps.executeUpdate();
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

	public Book getBookDetails(int book_id) 
	{
		Book bookDetails=new Book();
		
		 Connection conn=null;
		 
		 int bookID=book_id;
		 
			try
			{
			String driver="org.postgresql.Driver";
			Class.forName(driver).newInstance();
			
			Properties props = new Properties();
			props.setProperty("user","postgres");
			props.setProperty("password","shrutika");
			//props.setProperty("ssl","true");
			
			conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",props);
			
			
			PreparedStatement ps=conn.prepareStatement("select * from books where isbn=?");
			ps.setInt(1,bookID);
			
			ResultSet result=ps.executeQuery();
			while(result.next())
			{
				bookDetails.setISBN(result.getInt(1));
				bookDetails.setBook_title(result.getString(2));
				bookDetails.setBook_price(result.getDouble(3));
				bookDetails.setBook_quantity(result.getInt(4));
				bookDetails.setBook_cover(result.getString(5));
				bookDetails.setBook_category(result.getString(6));
				bookDetails.setBook_description(result.getString(7));
				bookDetails.setBook_threshold(result.getInt(8));
				
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
			return bookDetails;
	}

	public String updateBook(Book bookObj) 
	{

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
		
			    
			PreparedStatement ps=conn.prepareStatement("update books set isbn=?,title=?,price=?,quantity=?,coverphoto=?,category=?,description=?,thresholdlimit=? where isbn=?");
			ps.setInt(1, bookObj.getISBN());
			ps.setString(2, bookObj.getBook_title());
			ps.setDouble(3, bookObj.getBook_price());
			ps.setInt(4, bookObj.getBook_quantity());
			ps.setString(5, bookObj.getBook_cover());
			ps.setString(6, bookObj.getBook_category());
			ps.setString(7, bookObj.getBook_description());
			ps.setInt(8, bookObj.getBook_threshold());
			ps.setInt(9, bookObj.getISBN());

			// execute insert SQL statement
			ps.executeUpdate();

			//conn.commit();
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

	public List<Book> viewAllBooks() {
		// TODO Auto-generated method stub
		 Connection conn=null;
		 List<Book> books=new ArrayList<>();
		 Book book=null;
			
			try
			{
			String driver="org.postgresql.Driver";
			Class.forName(driver).newInstance();
			
			Properties props = new Properties();
			props.setProperty("user","postgres");
			props.setProperty("password","shrutika");
			//props.setProperty("ssl","true");
			
			conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",props);
		
			    
			PreparedStatement ps=conn.prepareStatement("select * from books");
			ResultSet rs=ps.executeQuery();
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

			// execute insert SQL statement
		//	ps.executeUpdate();

			//conn.commit();
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

}
