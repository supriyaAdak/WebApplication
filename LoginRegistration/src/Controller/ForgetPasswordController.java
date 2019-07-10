package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.IRegistrationImplements;

/**
 * Servlet implementation class ForgetPasswordController
 */
@WebServlet("/ForgetPasswordController")
public class ForgetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static IRegistrationImplements mailsender = new IRegistrationImplements();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	    

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String Email = request.getParameter("email");

		System.out.println(Email);

		boolean check = mailsender.checkEmail(Email);
		if (check == true) {
			System.out.println("Email is  Verified");
		} else {
			System.out.println("Your Email is not verified");
		}
		request.getRequestDispatcher("Welcome.jsp").forward(request, response);
	//	System.out.println("register successfully");

	}
	

}
