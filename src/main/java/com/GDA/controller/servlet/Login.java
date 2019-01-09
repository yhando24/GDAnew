package main.java.com.GDA.controller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.com.GDA.bean.User;
//import main.java.com.GDA.controller.filtre.LoginFilter;
import main.java.com.GDA.model.dao.user.*;


/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Login() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recover user data

	
		
		System.out.println("dopost");
		
		String emailUser = request.getParameter("email");
		String passwordUser = request.getParameter("password");
		System.out.println(emailUser);
		System.out.println(passwordUser);
		
		
		UserDAO userDao = new UserDAO();
		
		Boolean dbRep = userDao.isUserExist(emailUser, passwordUser);
		
		User u = new User();
		
		
		if (dbRep == true) {
			
			System.out.println("true");
			
			u = userDao.findUserByEmailAndByPassword(emailUser, passwordUser);
			
			
			HttpSession session = request.getSession(true);
			session.setAttribute("user", u);
			
			System.out.println(session);
			
			User u2 = (User) session.getAttribute("user");
			
			System.out.println(u2.getFunction().getId());
			
			System.out.println(u.getFunction());
			System.out.println(u.getFunction().getId());
			
			
			if (u.getFunction().getId() == 1) {
				
				response.sendRedirect(request.getContextPath() + "/AdminControlerServlet"); // logged-in page Admin				
			}
			else if (u.getFunction().getId() == 2) {
				
				response.sendRedirect(request.getContextPath() + "/indexManager"); // logged-in page Manager				
			}
			else if (u.getFunction().getId() == 3) {
				
				response.sendRedirect(request.getContextPath() + "/indexEmployee"); // logged-in page Employee				

			}
				

			//session.setAttribute("erreur", null);
			//response.sendRedirect(request.getContextPath() + "/indexManager"); // logged-in page
			
			
			

		} else {
			
			//HttpSession session = request.getSession(true);
			System.out.println("false");
			
			//session.setAttribute("erreur", "login ou mot de passe incorrect");
			
			response.sendRedirect(request.getContextPath() + "/login"); // error alert box
		}
	}
}
