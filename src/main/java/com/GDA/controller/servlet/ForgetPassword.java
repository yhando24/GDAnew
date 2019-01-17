package main.java.com.GDA.controller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.protobuf.Empty;

import main.java.com.GDA.bean.QuestionUser;
import main.java.com.GDA.bean.User;
import main.java.com.GDA.model.dao.absence.AbsenceDAO;
import main.java.com.GDA.model.dao.user.UserDAO;

/**
 * Servlet implementation class ForgetPassword
 */
@WebServlet("/forget-password")
public class ForgetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForgetPassword() {
		super();
		// TODO Auto-generated constructor stub
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = new User();
		UserDAO dao = new UserDAO();
		QuestionUser qu = new QuestionUser();
//		*si ya une action
		if (request.getParameter("action") != null) {
//			si c check reponse
			if(request.getParameter("action").equals("CheckReponse")) {
				System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaa :" + request.getParameter("userToCheck"));
					qu = dao.findQuestionUserByIdUser(Integer.parseInt(request.getParameter("userToCheck")));
					
//							si c la bonne reponse
					if(qu.getResponse().equals(request.getParameter("reponse"))){
						System.out.println("oui !!!!!!");
						
						request.setAttribute("UserReal", "exist");
						request.setAttribute("userId", qu.getIdUser());
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/forgot-password.jsp");
						dispatcher.forward(request, response);	
//						si c pas la bonne reponse
					}else {
						request.setAttribute("UserReal", null);
					}}
			
			else {
				System.out.println("une autre action");
			}
		}
			System.out.println("dedans");
		
			u=dao.findUserByEmail(request.getParameter("email"));
			if(u.getEmail() != null) {
				 qu = dao.findQuestionUserByMail(request.getParameter("email"));
				System.out.println();
				request.setAttribute("question", qu);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/forgot-password.jsp");
				dispatcher.forward(request, response);	
				
				
			}
		
		}
	

	}
