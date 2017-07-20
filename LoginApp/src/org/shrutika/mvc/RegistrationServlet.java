package org.shrutika.mvc;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.shrutika.mvc.dto.UserDetails;
import org.shrutika.mvc.service.RegistrationService;

import com.sun.media.sound.RealTimeSequencerProvider;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String phoneNo=request.getParameter("phone");
		String email=request.getParameter("email");
		String userID=request.getParameter("userID");
		String password=request.getParameter("password");
		String password1=request.getParameter("password1");
		
		UserDetails user=new UserDetails();
		
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setPhoneNo(phoneNo);
		user.setEmail(email);
		user.setUserID(userID);
		user.setPassword(password);
		user.setVerifyPassword(password1);
		
		RegistrationService regServ=new RegistrationService();
		try 
		{
			String result=regServ.insert(user);
			if(result.equals("success"))
			{
				response.sendRedirect("login.jsp");
			}
			else
			{
				
			}
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
