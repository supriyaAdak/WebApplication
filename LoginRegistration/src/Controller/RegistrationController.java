package Controller;

import Dto.RegistraionDto;
import Service.IRegistrationImplements;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet(name = "RegistrationController1", urlPatterns = { "/RegistrationController1" })
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try 
		{
			RegistraionDto register = new RegistraionDto();
		    String fname=request.getParameter("FirstName");
		    String lname = request.getParameter("LastName");
		    String Uname=request.getParameter("UserName");
		    String Emailid = request.getParameter("EmailId");
		    String Password = request.getParameter("password");


			   register.setFirstName(fname);
			   register.setLastName(lname);
			   register.setUserName(Uname);
			   register.setPassword(Password);
			   register.setEmailId(Emailid);
			   IRegistrationImplements Ruser = new IRegistrationImplements();
		       boolean bool=Ruser.registration(register);
		  
		 if(bool==true) 
		 {
		   RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
		   rd.forward(request, response);
		}
		 else 
		 {
			 RequestDispatcher rd = request.getRequestDispatcher("Registration.jsp");
				rd.forward(request, response);
			 
			 
		 }
		 }
		catch(Exception e) 
		{
			System.out.println("exception in registration"+e);
		}
		
		
		
	}

}
