package org.shrutika.mvc.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shrutika.mvc.dao.ShoppingCartDao;
import org.shrutika.mvc.dto.Book;
import org.shrutika.mvc.dto.ShoppingCart;

/**
 * Servlet implementation class ShoppingCartServlet
 */
@WebServlet("/ShoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		if(action.equals("addtocart"))
		{
			addtocart(request,response);
		}
		else if(action.equals("view"))
		{
			viewCart(request,response);
		}
		else if(action.equals("deletebyId"))
		{
			deletebyId(request,response);
		}
		else if(action.equals("shippingaddress"))
		{
			response.sendRedirect("shippingAddress.jsp");
		}
		else if(action.equals("emptyCart"))
		{
			emptyCart(request,response);
		}
	}

	private void emptyCart(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		ShoppingCartService service=new ShoppingCartService();
		List<ShoppingCart> shoppingCart=service.emptyCart("shru");
		request.setAttribute("shoppingcart", shoppingCart);
		List<Double> prices=service.getPrices("shru");
		request.setAttribute("totalActualPrice", prices.get(0));
		request.setAttribute("totalDiscountedPrice", prices.get(1));

		try 
		{ 
			RequestDispatcher dispatcher=request.getRequestDispatcher("checkoutview.jsp");
			dispatcher.forward(request, response);
			
		} catch (IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void deletebyId(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String cartid=request.getParameter("id");
		System.out.println("Cart id is "+cartid);
		ShoppingCartService service=new ShoppingCartService();
		List<ShoppingCart> shoppingCart=service.deleteItemFromCart(Integer.parseInt(cartid),"shru");
		request.setAttribute("shoppingcart", shoppingCart);
		List<Double> prices=service.getPrices("shru");
		request.setAttribute("totalActualPrice", prices.get(0));
		request.setAttribute("totalDiscountedPrice", prices.get(1));

		try 
		{ 
			RequestDispatcher dispatcher=request.getRequestDispatcher("checkoutview.jsp");
			dispatcher.forward(request, response);
			
		} catch (IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void viewCart(HttpServletRequest request, HttpServletResponse response) 
	{
		ShoppingCartService shopServ=new ShoppingCartService();
		List<ShoppingCart> shoppingCart=shopServ.viewcart("shru");
		request.setAttribute("shoppingcart", shoppingCart);
		List<Double> prices=shopServ.getPrices("shru");
		request.setAttribute("totalActualPrice", prices.get(0));
		request.setAttribute("totalDiscountedPrice", prices.get(1));

		try 
		{ 
			RequestDispatcher dispatcher=request.getRequestDispatcher("checkoutview.jsp");
			dispatcher.forward(request, response);
			
		} catch (IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void addtocart(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ShoppingCartService addtoCartService=new ShoppingCartService();
		ShoppingCart shoppingCart=new ShoppingCart();
		/*shoppingCart.setIsbn(Integer.parseInt(request.getParameter("modalISBN")));
		shoppingCart.setActualprice(Integer.parseInt(request.getParameter("modalPrice")));
		shoppingCart.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		shoppingCart.setUserId("shru");
		shoppingCart.setPromocode(Integer.parseInt(request.getParameter("modalPromoCode"))); */
		shoppingCart.setIsbn(Integer.parseInt(request.getParameter("isbn")));
		shoppingCart.setActualprice(Double.parseDouble(request.getParameter("price")));
		shoppingCart.setPromocode(Integer.parseInt(request.getParameter("promocode")));
		shoppingCart.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		List<Book> books=addtoCartService.addToCart(shoppingCart);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
