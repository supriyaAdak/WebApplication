package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dto.RegistraionDto;
import Service.IRegistrationImplements;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RegistraionDto loginuser = new RegistraionDto();
		 String EmailId = request.getParameter("UserName");
		 String Password = request.getParameter("password");
		 loginuser.setPassword(Password);
		 loginuser.setEmailId(EmailId);
		 IRegistrationImplements Ruser = new IRegistrationImplements();
	       boolean bool=Ruser.Login(loginuser);
	       if (loginuser.isValid())
	       {
	  	        
	            HttpSession session = request.getSession(true);	    
	            session.setAttribute("currentSessionUser",loginuser); 
	            response.sendRedirect("LoginSuccessful.jsp"); //logged-in page      		
	       }
	  	        
	       else 
	            response.sendRedirect("Registration.jsp"); //error page 
	  } 
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
