package main.java.com.GDA.controller.servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.com.GDA.bean.Dayoff;
import main.java.com.GDA.model.dao.dayoff.DayoffDAO;

/**
 * Servlet implementation class DayOffManagement
 */
@WebServlet("/day-off-management")
public class DayOffManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DayOffManagementServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DayoffDAO dao = new DayoffDAO();
		HttpSession session = request.getSession();
		session.setAttribute("errorAdd", null);
		Calendar now = Calendar.getInstance();
		int y = now.get(Calendar.YEAR);
		String year = String.valueOf(y);
		
		if (request.getParameter("action") != null) {

			if (request.getParameter("action").equals("addDayoff")) {

				response.sendRedirect(request.getContextPath() + "/create-day-off");

			}

			else if (request.getParameter("action").equals("updateDayoff")) {

				String id = request.getParameter("dayId");

				session.setAttribute("idJourAModifier", id);

				response.sendRedirect(request.getContextPath() + "/day-off-update");

			}

			else if (request.getParameter("action").equals("deleteDayoff")) {

				String id = request.getParameter("dayId");
				dao.deleteDayOff(Integer.parseInt(id));
				response.sendRedirect(request.getContextPath() + "/day-off-management");

			}

		} else {

			List<Dayoff> dayoffs = dao.findDayOffByYear(y);

			session.setAttribute("dayoffs", dayoffs);
			
			request.setAttribute("selectYear", year);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/day-off-management.jsp");
			dispatcher.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int year = Integer.parseInt(request.getParameter("selectYear"));
		System.out.println(year);
		DayoffDAO dao = new DayoffDAO();
		HttpSession session = request.getSession();
		String selectYear = request.getParameter("selectYear");
		
		List<Dayoff> dayoffsByYear = dao.findDayOffByYear(year);
		session.setAttribute("dayoffs", dayoffsByYear);
		
		request.setAttribute("selectYear", selectYear);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/day-off-management.jsp");
		dispatcher.forward(request, response);
	
	}

}
