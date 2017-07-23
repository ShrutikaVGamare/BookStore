package org.shrutika.mvc.service;

import java.util.List;

import org.shrutika.mvc.dao.BookDao;
import org.shrutika.mvc.dto.Book;
import org.shrutika.mvc.dto.SalesReport;

public class BookService 
{

	public String addBook(Book bookObj) 
	{
		BookDao bookDaoObj=new BookDao();
		String result=bookDaoObj.addBook(bookObj);
		return result;
	}
	
	public String deleteBook(int book_id)
	{
		BookDao bookDaoObj=new BookDao();
		String result=bookDaoObj.deleteBook(book_id);
		return result;
	}

	public Book getBookDetails(int book_id) 
	{
		BookDao bookDaoObj=new BookDao();
		Book result=bookDaoObj.getBookDetails(book_id);
		return result;
	}

	public String updateBook(Book bookObj) 
	{
		BookDao bookDaoObj=new BookDao();
		String result=bookDaoObj.updateBook(bookObj);
		return result;		
	}

	public List<Book> viewAllBooks() {
		// TODO Auto-generated method stub
		BookDao bookDao=new BookDao();
		List<Book> books=bookDao.viewAllBooks();
		return books;
	}

	public SalesReport getEndOfSales() {
		BookDao bookDao=new BookDao();
		SalesReport salesReport=new SalesReport();
		salesReport=bookDao.getSalesReport();
		return salesReport;
	}
	

	
}
