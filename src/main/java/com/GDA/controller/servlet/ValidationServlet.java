package main.java.com.GDA.controller.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.com.GDA.bean.Absence;
import main.java.com.GDA.bean.Status;
import main.java.com.GDA.bean.User;
import main.java.com.GDA.model.dao.absence.AbsenceDAO;

/**
 * Servlet implementation class ValidationServlet
 */
@WebServlet("/validation")
public class ValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AbsenceDAO dao = new AbsenceDAO();
		
		HttpSession session = request.getSession();
		List <User> users = new ArrayList <User>();
		
		User user = (User) session.getAttribute("user");
		

		if (request.getParameter("action") != null) {

			if (request.getParameter("action").equals("validAbsence")) {

				int id = Integer.parseInt(request.getParameter("id"));

				Absence absence = dao.findAbsenceById(id);
			
				absence.setStatus(new Status(3));
				absence.setStartDate(absence.getStartDate().plusDays(1));

				absence.setEndDate(absence.getEndDate().plusDays(1));
				dao.updateAbsence(id, absence);
				users = dao.findAllAbsencesByDepartement(user.getDepartement().getId());	
				session.setAttribute("allUsers", users);
				
				
				
				
				response.sendRedirect(request.getContextPath() + "/validation");
				
			} else if (request.getParameter("action").equals("refuseAbsence")) {
				
				int id = Integer.parseInt(request.getParameter("id"));
						
				Absence absence = dao.findAbsenceById(id);
				absence.setStartDate(absence.getStartDate().plusDays(1));

				absence.setEndDate(absence.getEndDate().plusDays(1));
				absence.setStatus(new Status(4));
				dao.updateAbsence(id, absence);
				
				
				
				users = dao.findAllAbsencesByDepartement(user.getDepartement().getId());		
			
				
				session.setAttribute("allUsers", users);
				
				
				response.sendRedirect(request.getContextPath() + "/validation");
            
			} 

		}
		else {
		System.out.println("dans la servlet");
		
		System.out.println(user.getId());
		users = dao.findAllAbsencesByDepartement(user.getDepartement().getId());	
		for (User user2 : users) {
			System.out.println("bou"+ user2);
		}
	
		
		session.setAttribute("allUsers", users);
		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/view/approval.jsp") ;
		requestDispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
