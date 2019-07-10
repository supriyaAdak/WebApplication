package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.RegistrationDao;
import Dto.RegistraionDto;
import Service.IRegistrationImplements;

/**
 * Servlet implementation class PasswordChange
 */
@WebServlet("/PasswordChange")
public class PasswordChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confpassword = request.getParameter("confirmpassword");

		
		RegistraionDto user = new RegistraionDto();
			user.setEmailId(email);
			user.setPassword(confpassword);
			IRegistrationImplements service = new IRegistrationImplements();
			int k = service.setPassword(user);
			if (k != 0) {
				System.out.println("Password Reset Successfully");
				RequestDispatcher rd = request.getRequestDispatcher("SuccessfullyReset.jsp");
				rd.include(request, response);
				
			} else {
				response.sendRedirect("SetPassword.jsp");
			}
	}

}
