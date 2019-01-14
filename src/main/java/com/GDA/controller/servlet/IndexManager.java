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
import main.java.com.GDA.config.Role;

/**
 * Servlet implementation class IndexManager
 */
@WebServlet("/indexManager")
public class IndexManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexManager() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		HttpSession session = (request).getSession();
		System.out.println(session.getAttribute("user"));

		session.setAttribute("errorAdd",null);
		
		User u2 = (User) session.getAttribute("user");
		
		if (u2.getFunction().getId() == Role.ROLE_MANAGER.getValue()) {
				
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/homeManager.jsp");
			dispatcher.forward(request, response);	
		}
		
		else {
			
			response.sendRedirect(request.getContextPath() + "/login");
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.sendRedirect(request.getContextPath() + "/homeManager.jsp"); // logged-in page

	}

}
