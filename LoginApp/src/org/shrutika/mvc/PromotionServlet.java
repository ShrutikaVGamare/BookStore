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

import org.shrutika.mvc.dto.Promotions;
import org.shrutika.mvc.service.PromotionService;

/**
 * Servlet implementation class PromotionServlet
 */
@WebServlet("/promotionServlet")
public class PromotionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PromotionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("AdminAction");
		if(action.equals("add"))
		{
			addPromotion(request,response);
		}
		if(action.equals("delLink"))
		{
			viewAllPromotions(request,response);
		}
		if(action.equals("deletePromotion"))
		{
			deleteSelectedPromotions(request,response);
		}
		
	}

	private void deleteSelectedPromotions(HttpServletRequest request, HttpServletResponse response) 
	{
		String[] selectedPromos=request.getParameterValues("selected");
		PromotionService deletePromoObj=new PromotionService();
		List<Promotions> result=deletePromoObj.deletePromo(selectedPromos);
		request.setAttribute("promList", result);
		RequestDispatcher dispatcher=request.getRequestDispatcher("Admin_DeletePromotions.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void viewAllPromotions(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		PromotionService promService=new PromotionService();
		List<Promotions> promList=promService.getAllPromotions();
		request.setAttribute("promList", promList);
		RequestDispatcher dispatcher=request.getRequestDispatcher("Admin_DeletePromotions.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addPromotion(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Promotions promotions=new Promotions();
		promotions.setIsbn(Integer.parseInt(request.getParameter("isbn")));
		promotions.setPromocode(Integer.parseInt(request.getParameter("promocode")));
		promotions.setCouponvalue(Integer.parseInt(request.getParameter("copCode")));
		promotions.setCouponclass(Integer.parseInt(request.getParameter("copClass")));
		PromotionService promService=new PromotionService();
		String result=promService.addPromotion(promotions);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
