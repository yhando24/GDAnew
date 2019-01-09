package main.java.com.GDA.controller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.com.GDA.bean.Absence;
import main.java.com.GDA.bean.User;
import main.java.com.GDA.model.dao.absence.AbsenceDAO;

/**
 * Servlet implementation class AbsencesManagmentUser
 */
@WebServlet("/AbsencesManagement")
public class AbsencesManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AbsencesManagement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect(request.getContextPath() + "/view/absences-managment-user.jsp");
		
	if(request.getParameter("action") != null){
		

		
		if(request.getParameter("action").equals("addAbsence")) {
			
			response.sendRedirect(request.getContextPath() + "/AddAbsence"); // logged-in page
		}
	}
	else{

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/absences-management.jsp");
		dispatcher.forward(request, response);
	}

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}
		

}
