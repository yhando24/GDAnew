package main.java.com.GDA.controller.servlet;

import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.com.GDA.bean.Absence;
import main.java.com.GDA.bean.AbsenceForReport;
import main.java.com.GDA.bean.Dayoff;
import main.java.com.GDA.bean.User;
import main.java.com.GDA.model.dao.AbsenceForReport.AbsenceForReportDAO;
import main.java.com.GDA.model.dao.absence.AbsenceDAO;
import main.java.com.GDA.model.dao.user.UserDAO;

/**
 * Servlet implementation class ReportServlet
 */
@WebServlet("/report-planning")
public class ReportPlanningServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReportPlanningServlet() {
		super();

		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user");

		List<Dayoff> dayoff = new ArrayList<Dayoff>();
		
		if (user.getFunction().getName().equals("manager")) {
			Calendar now = Calendar.getInstance();
			int y = now.get(Calendar.YEAR);
			String year = String.valueOf(y);
			int m = now.get(Calendar.MONTH) +1;
			String month = String.valueOf(m);
			request.setAttribute("year", year);
			request.setAttribute("month", month);
			request.setAttribute("dep", user.getDepartement().getId());
			UserDAO userName = new UserDAO();

			ArrayList<User> users = new ArrayList<User>();

			users = userName.findUserByIdDepartement( user.getDepartement().getId());

			for (User user2 : users) {

				List<Absence> userAbsence = new ArrayList<Absence>();

				List<Absence> abs = new ArrayList<Absence>();

				AbsenceDAO absenceDao = new AbsenceDAO();
				abs.addAll(absenceDao.findAbsenceByUserMonthAndYear(user2.getId(), month, year));
				user2.setAbsences(abs);

			}

			Map<String, Object> plop = new HashMap<String, Object>();
			for (User u : users) {
				ArrayList<String> typeAbs = new ArrayList<String>();
				for (int i = 0; i < 31; i++) {
					typeAbs.add("");
				}
				for (int i = 0; i < 31; i++) {
					for (Absence a : u.getAbsences()) {
						
						if (a.getStartDate().getDayOfMonth()-1 == i) {
//							int duration = a.getEndDate().getDayOfYear() - a.getStartDate().getDayOfYear() + 1;
							
							Long duration = ChronoUnit.DAYS.between(a.getStartDate(),a.getEndDate())+1;
							
							for (int j = 0; j < duration; j++) {
								if(i+j < 31) {
								switch (a.getAbsenceType().getId()) {
								case 1:
									typeAbs.set(i + j, "C");
									break;
								case 2:
									typeAbs.set(i + j, "R");
									break;
								case 3:
									typeAbs.set(i + j, "S");
									break;
								case 4:
									typeAbs.set(i + j, "M");
									break;
								case 5:
									typeAbs.set(i + j, "R_E");
									break;

								}
							}
							}
						}
						
					}
				}
				
				System.out.println(typeAbs);
				plop.put(u.getName(), typeAbs);
			}
			request.setAttribute("plop", plop);


			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/reportPlanning.jsp");
			dispatcher.forward(request, response);

		} else {

			response.sendRedirect(request.getContextPath() + "/indexEmployee");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String dep = request.getParameter("departement");
		
		
		
		UserDAO userName = new UserDAO();

		ArrayList<User> users = new ArrayList<User>();

		users = userName.findUserByIdDepartement( Integer.parseInt(dep));

		for (User user2 : users) {

			List<Absence> userAbsence = new ArrayList<Absence>();

			List<Absence> abs = new ArrayList<Absence>();

			AbsenceDAO absenceDao = new AbsenceDAO();
			abs.addAll(absenceDao.findAbsenceByUserMonthAndYear(user2.getId(), month, year));
			user2.setAbsences(abs);

		}

		Map<String, Object> plop = new HashMap<String, Object>();
		for (User u : users) {
			ArrayList<String> typeAbs = new ArrayList<String>();
			for (int i = 0; i < 31; i++) {
				typeAbs.add("");
			}
			for (int i = 0; i < 31; i++) {
				for (Absence a : u.getAbsences()) {
					
					if (a.getStartDate().getDayOfMonth()-1 == i) {
//						int duration = a.getEndDate().getDayOfYear() - a.getStartDate().getDayOfYear() + 1;
						
						Long duration = ChronoUnit.DAYS.between(a.getStartDate(),a.getEndDate())+1;
						
						for (int j = 0; j < duration; j++) {
							if(i+j < 31) {
							switch (a.getAbsenceType().getId()) {
							case 1:
								typeAbs.set(i + j, "C");
								break;
							case 2:
								typeAbs.set(i + j, "R");
								break;
							case 3:
								typeAbs.set(i + j, "S");
								break;
							case 4:
								typeAbs.set(i + j, "M");
								break;
							case 5:
								typeAbs.set(i + j, "R_E");
								break;

							}
						}
						}
					}
					
				}
			}
			
			System.out.println(typeAbs);
			plop.put(u.getName(), typeAbs);
		}
		request.setAttribute("year", year);
		request.setAttribute("month", month);
		request.setAttribute("departement", dep);
		
		request.setAttribute("plop", plop);


		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/reportPlanning.jsp");
		dispatcher.forward(request, response);
	}

}
