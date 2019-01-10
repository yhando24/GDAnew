package main.java.com.GDA.controller.servlet;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Date;

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
import main.java.com.GDA.utils.Global;

/**
 * Servlet implementation class AbsencesManagmentUser
 */
@WebServlet("/AbsencesManagement")
public class AbsencesManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AbsencesManagementServlet() {
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
		
		if(request.getParameter("action").equals("updateAbsence")) {
			String id = request.getParameter("absId");
			System.out.println(id);
		    request.setAttribute("idAbsenceAModifier", id);
		    
		    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/updateAbsence");
			dispatcher.forward(request, response);
		}
		
	}
	else{
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int nbrOfDayRtt = 0;
		int nbrOfDayCp = 0;

//		for (Absence abs : user.getAbsences()) {
//			if(abs.getAbsenceType().getName().equals("RTT")&&abs.getStatus().getName().equals("VALIDEE")) {
//			
//				nbrOfDayRtt += Global.returnPeriodBetweenTwoDates((Date) abs.getStartDate(), (Date) abs.getEndDate());
//				
//			}if(abs.getAbsenceType().getName().equals("conge")&&abs.getStatus().getName().equals("VALIDEE")) {
//				
//				nbrOfDayCp += Global.returnPeriodBetweenTwoDates((Date) abs.getStartDate(), (Date) abs.getEndDate());
//			}
//		}

		nbrOfDayRtt = user.getNbrRTT() - nbrOfDayRtt;
		nbrOfDayCp = user.getNbrDaysOfLeave() - nbrOfDayCp;
	
		session.setAttribute("nbrOfDayRtt", nbrOfDayRtt);
		session.setAttribute("nbrOfDayCp", nbrOfDayCp);
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
