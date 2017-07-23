package org.shrutika.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shrutika.mvc.dto.CardDetails;
import org.shrutika.mvc.dto.ShippingAddress;
import org.shrutika.mvc.service.TransactionService;

/**
 * Servlet implementation class CardServlet
 */
@WebServlet("/CardServlet")
public class CardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		if(action.equals("confirmCardDetails"))
		{
			confirmCardDetails(request,response);
		}
		else if(action.equals("submitTransaction"))
		{
			submitCardDetails(request,response);
		}
	}

	private void submitCardDetails(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		CardDetails details=new CardDetails();
		ShippingAddress address=new ShippingAddress();
		address.setCountry(request.getParameter("country"));
		address.setState(request.getParameter("state"));
		address.setStreet(request.getParameter("street"));
		address.setZipCode(Integer.parseInt(request.getParameter("zip")));
		details.setBillingAddress(address);
		details.setCardNo(request.getParameter("cardNo"));
		details.setCardType(request.getParameter("cardType"));
		details.setCompany(request.getParameter("company"));
		details.setExpiratationDate(request.getParameter("expDate"));
		request.setAttribute("shippingId", request.getParameter("shippingId"));
		request.setAttribute("carddetails", details);
		TransactionService service =new TransactionService();
		String result=service.performTransaction(details,request.getParameter("shippingId"));
		try 
		{ 
			RequestDispatcher dispatcher=request.getRequestDispatcher("confirmCheckout.jsp");
			dispatcher.forward(request, response);
			
		} catch (IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void confirmCardDetails(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		CardDetails details=new CardDetails();
		ShippingAddress address=new ShippingAddress();
		address.setCountry(request.getParameter("country"));
		address.setState(request.getParameter("state"));
		address.setStreet(request.getParameter("street"));
		address.setZipCode(Integer.parseInt(request.getParameter("zip")));
		details.setBillingAddress(address);
		details.setCardNo(request.getParameter("cardNo"));
		details.setCardType(request.getParameter("cardType"));
		details.setCompany(request.getParameter("company"));
		details.setExpiratationDate(request.getParameter("expDate"));
		request.setAttribute("shippingId", request.getParameter("shippingId"));
		request.setAttribute("carddetails", details);
		try 
		{ 
			RequestDispatcher dispatcher=request.getRequestDispatcher("confirmCheckout.jsp");
			dispatcher.forward(request, response);
			
		} catch (IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
