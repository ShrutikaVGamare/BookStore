package org.shrutika.mvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shrutika.mvc.dto.Book;
import org.shrutika.mvc.service.BookService;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action=request.getParameter("AdminAction");
		if(action.equals("add"))
		{
			addBook(request,response);
		}
		else if(action.equals("delete"))
		{
			deleteBook(request,response);
		}
		else if(action.equals("search"))
		{
			search(request,response);
		}
		else if(action.equals("update"))
		{
			update(request,response);
		}else if(action.equals("viewAllBooks"))
		{
			viewAllBooks(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	
		
		
	}

	private void viewAllBooks(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<Book> books =new ArrayList<Book>();
		BookService bookService=new BookService();
		books=bookService.viewAllBooks();
		request.setAttribute("books", books);
		try 
		{ 
			RequestDispatcher dispatcher=request.getRequestDispatcher("userShoppingCart.jsp");
			dispatcher.forward(request, response);
			
		} catch (IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) 
	{
		Book bookObj=new Book();
		bookObj.setBook_title(request.getParameter("book_title"));
		bookObj.setBook_price((Double.parseDouble(request.getParameter("book_price"))));
		bookObj.setBook_quantity(Integer.parseInt(request.getParameter("book_quantity")));
		bookObj.setBook_cover(request.getParameter("book_cover"));
		bookObj.setBook_category(request.getParameter("book_category"));
		bookObj.setBook_description(request.getParameter("book_desc"));
		bookObj.setBook_threshold(Integer.parseInt(request.getParameter("book_threshold")));
		bookObj.setISBN(Integer.parseInt(request.getParameter("book_ISBN")));
		BookService bookServObj=new BookService();
		String result=bookServObj.updateBook(bookObj);
		
		
		
	}

	private void search(HttpServletRequest request, HttpServletResponse response) 
	{
		int book_id=Integer.parseInt(request.getParameter("book_id"));
		BookService bookServObj=new BookService();
		Book result=bookServObj.getBookDetails(book_id);
		System.out.println(result);
		request.setAttribute("result", result);
		try 
		{ 
			RequestDispatcher dispatcher=request.getRequestDispatcher("Admin_UpdateViewDetails.jsp");
			dispatcher.forward(request, response);
			//getServletConfig().getServletContext().getRequestDispatcher("/Admin_UpdateBook_bkDetails.jsp").forward(request, response);
			//request.getRequestDispatcher("Admin_UpdateBook_bkDetails.jsp").forward(request, response);
			//response.sendRedirect("Admin_UpdateBook_bkDetails.jsp");
		} catch (IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void deleteBook(HttpServletRequest request, HttpServletResponse response) 
	{
		int book_id=Integer.parseInt(request.getParameter("book_id"));
		BookService bookServObj=new BookService();
		String result=bookServObj.deleteBook(book_id);
		
	}

	private void addBook(HttpServletRequest request, HttpServletResponse response) 
	{
		Book bookObj=new Book();
		bookObj.setBook_title(request.getParameter("book_title"));
		bookObj.setBook_price((Double.parseDouble(request.getParameter("book_price"))));
		bookObj.setBook_quantity(Integer.parseInt(request.getParameter("book_quantity")));
		bookObj.setBook_cover(request.getParameter("book_cover"));
		bookObj.setBook_category(request.getParameter("book_category"));
		bookObj.setBook_description(request.getParameter("book_desc"));
		bookObj.setBook_threshold(Integer.parseInt(request.getParameter("book_threshold")));
		BookService bookServObj=new BookService();
		String result=bookServObj.addBook(bookObj);
		
	}

	

}
