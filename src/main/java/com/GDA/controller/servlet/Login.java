package main.java.com.GDA.controller.servlet;

import java.io.IOException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.com.GDA.bean.User;

import main.java.com.GDA.model.dao.user.*;

/**
 * Servlet implementation class Login
 */


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
	

		
		
		
		HttpSession session = (request).getSession();
		
		if (session.getAttribute("user") == null) {
		if(request.getParameter("errorlogin") != null)	{
			
			request.setAttribute("noUser", "Aucun utilisateur existant avec cette adresse mail");
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/login.jsp");
		dispatcher.forward(request, response);
		}
		
		else {
			
			response.sendRedirect(request.getContextPath() + "/dispatchfilter");
		}
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

// Pwd : Hash to MD5

		String generatedPassword = null;
		try {
			// Create MessageDigest instance for MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			// Add password bytes to digest
			md.update(passwordUser.getBytes());
			// Get the hash's bytes
			byte[] bytes = md.digest();
			// This bytes[] has bytes in decimal format;
			// Convert it to hexadecimal format
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			// Get complete hashed password in hex format
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		System.out.println(generatedPassword);

// Test if user exist in DB, using DAO functions

		UserDAO userDao = new UserDAO();

		Boolean dbRep = userDao.isUserExist(emailUser, generatedPassword);

		User u = new User();

		if (dbRep == true) {

			System.out.println("true");

			// Test email and pwd, create the session and send to the dispatchFilter

			u = userDao.findUserByEmailAndByPassword(emailUser, generatedPassword);

			HttpSession session = request.getSession(true);
			session.setAttribute("user", u);

			// System.out.println(session);
			System.out.println(u.getFunction().getId());

			response.sendRedirect(request.getContextPath() + "/dispatchfilter");

		} else {

			System.out.println("false");

			request.setAttribute("errorMessage", "email ou mot de passe inconnu");

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
			rd.include(request, response);

		}

	}
}
