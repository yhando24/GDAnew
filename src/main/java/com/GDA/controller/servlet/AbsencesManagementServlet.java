package main.java.com.GDA.controller.servlet;

import java.io.IOException;

import java.time.LocalDate;


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
@WebServlet("/absences-management")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 AbsenceDAO dao = new AbsenceDAO();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		   user.setAbsences(dao.findAbsencesByIdUser(user.getId()));
           session.setAttribute("user",user);
		if (request.getParameter("action") != null) {

			if (request.getParameter("action").equals("addAbsence")) {

				response.sendRedirect(request.getContextPath() + "/add-absence"); 
				
			} else if (request.getParameter("action").equals("updateAbsence")) {
				String id = request.getParameter("absId");
				System.out.println(id);
				//request.setAttribute("idAbsenceAModifier", id);
				session.setAttribute("idAbsenceAModifier", id);;

				//RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/updateAbsence");
				//dispatcher.forward(request, response);
				
				response.sendRedirect(request.getContextPath() + "/update-absence");
				
			} else if (request.getParameter("action").equals("deleteAbsence")) {
				String id = request.getParameter("absId");
            
				dao.deleteAbsence(Integer.parseInt(id));
                user.setAbsences(dao.findAbsencesByIdUser(user.getId()));
                session.setAttribute("user",user);
                response.sendRedirect(request.getContextPath() + "/absences-management");
			}

		} else {

			int nbrOfDayRtt = 0;
			int nbrOfDayCp = 0;
			for (Absence abs : user.getAbsences()) {
				if (abs.getAbsenceType().getName().equals("RTT") || abs.getAbsenceType().getName().equals("RTT employeur")   && abs.getStatus().getName().equals("VALIDEE")) {

					nbrOfDayRtt += Global.returnPeriodBetweenTwoDates((LocalDate) abs.getStartDate(),
							(LocalDate) abs.getEndDate());
					System.out.println("plop =>"+nbrOfDayRtt);

				}
				if (abs.getAbsenceType().getName().equals("conge") && abs.getStatus().getName().equals("VALIDEE")) {

					nbrOfDayCp += Global.returnPeriodBetweenTwoDates((LocalDate) abs.getStartDate(),
							(LocalDate) abs.getEndDate());
				}
			}
			nbrOfDayRtt = user.getNbrRTT() - nbrOfDayRtt;
			nbrOfDayCp = user.getNbrDaysOfLeave() - nbrOfDayCp;

			session.setAttribute("nbrOfDayRtt", nbrOfDayRtt);
			session.setAttribute("nbrOfDayCp", nbrOfDayCp);
			
			session.setAttribute("errorAdd",null);
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/WEB-INF/view/absences-management.jsp");
			dispatcher.forward(request, response);
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
