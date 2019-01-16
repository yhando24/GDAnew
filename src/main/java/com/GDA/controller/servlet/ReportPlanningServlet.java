package main.java.com.GDA.controller.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.com.GDA.bean.User;
import main.java.com.GDA.model.dao.AbsenceForReport.AbsenceForReportDAO;

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

		if (user.getFunction().getName().equals("manager")) {
			System.out.println("plop");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/reportPlanning.jsp");
			dispatcher.forward(request, response);
		} else {
			int plop;
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
		Map<String, String> selectReportPlanning = new HashMap<String, String>();
		selectReportPlanning.put("year", year);
		selectReportPlanning.put("month", month);
		selectReportPlanning.put("departement", dep);
		session.setAttribute("selectReport", selectReportPlanning);

		AbsenceForReportDAO abs = new AbsenceForReportDAO();

		abs.findAllAbsencesByNameDepartementMonthAndYear(Integer.parseInt(dep), month, year);

		response.sendRedirect(request.getContextPath() + "/report-planning");

	}

}
