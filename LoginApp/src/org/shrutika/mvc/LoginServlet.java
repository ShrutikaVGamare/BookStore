package org.shrutika.mvc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shrutika.mvc.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String username=request.getParameter("userID");
		String password=request.getParameter("password");
		
		LoginService loginService=new LoginService();
		boolean result=loginService.authenticate(username, password);
		//boolean result=true;
		//System.out.println(result);
		
		if(result)
		{
			response.sendRedirect("success.jsp");
			return;
		}
		else
		{
		response.sendRedirect("login.jsp");
			return;
		}
		
	}

}
