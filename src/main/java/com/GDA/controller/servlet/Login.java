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
			System.out.println(u.getFunction().getId());
			
			response.sendRedirect(request.getContextPath() + "/dispatchfilter");


		} else {

			// HttpSession session = request.getSession(true);
			System.out.println("false");

			// session.setAttribute("erreur", "login ou mot de passe incorrect");

			response.sendRedirect(request.getContextPath() + "/login"); // error alert box
		}
	}
}
