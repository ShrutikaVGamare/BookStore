package org.shrutika.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shrutika.mvc.dto.ShippingAddress;
import org.shrutika.mvc.service.ShippingAddressService;

/**
 * Servlet implementation class ShippingAddressServlet
 */
@WebServlet("/ShippingAddressServlet")
public class ShippingAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShippingAddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		if(action.equals("shippingaddress"))
		{
			response.sendRedirect("shippingaddress.jsp");
		}
		else if(action.equals("confirmShippingAddress"))
		{
			confirmShippingAddress(request,response);
		}
		else if(action.equals("submitShippingAddress"))
		{
			submitShippingDetails(request,response);
		}
	}

	private void submitShippingDetails(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ShippingAddress address=new ShippingAddress();
		address.setCountry(request.getParameter("country"));
		address.setState(request.getParameter("state"));
		address.setStreet(request.getParameter("street"));
		address.setZipCode(Integer.parseInt(request.getParameter("zip")));
		request.setAttribute("address", address);
		ShippingAddressService service=new ShippingAddressService();
		int shippingid=service.addShippingDetails(address);
		request.setAttribute("shippingid", shippingid);
		try 
		{ 
			RequestDispatcher dispatcher=request.getRequestDispatcher("carddetails.jsp");
			dispatcher.forward(request, response);
			
		} catch (IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void confirmShippingAddress(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ShippingAddress address=new ShippingAddress();
		address.setCountry(request.getParameter("country"));
		address.setState(request.getParameter("state"));
		address.setStreet(request.getParameter("street"));
		address.setZipCode(Integer.parseInt(request.getParameter("zip")));
		request.setAttribute("address", address);
		try 
		{ 
			RequestDispatcher dispatcher=request.getRequestDispatcher("confirmShippingAddress.jsp");
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
