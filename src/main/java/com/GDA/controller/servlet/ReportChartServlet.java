package com.GDA.controller.servlet;

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

import com.GDA.bean.Absence;
import com.GDA.bean.User;
import com.GDA.model.dao.absence.AbsenceDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class ReportServlet
 * 
 * @param <ObjectMapper>
 */
@WebServlet("/report-chart")
public class ReportChartServlet<ObjectMapper> extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReportChartServlet() {
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
			Calendar now = Calendar.getInstance();
			int y = now.get(Calendar.YEAR);
			String year = String.valueOf(y);
			int m = now.get(Calendar.MONTH) + 1;
			String month = String.valueOf(m);
			request.setAttribute("year", year);
			request.setAttribute("month", month);
			request.setAttribute("dep", user.getDepartement().getId());

			AbsenceDAO abs = new AbsenceDAO();

			System.out.println("id dep => " + user.getDepartement().getId() + " month =>" + month + " year => " + year);
			List<Absence> absences = abs.findAllAbsencesByDepartementMonthAndYear(user.getDepartement().getId(), m, y);
			final GsonBuilder builder = new GsonBuilder();
			final Gson gson = builder.create();
			String json = gson.toJson(absences);

			System.out.println(json);

			request.setAttribute("absenceForChart", json);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/report-chart.jsp");
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

		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String dep = request.getParameter("departement");
		request.setAttribute("year", year);
		request.setAttribute("month", month);
		request.setAttribute("dep", dep);

		AbsenceDAO abs = new AbsenceDAO();

		List<Absence> absences = abs.findAllAbsencesByDepartementMonthAndYear(Integer.parseInt(dep),
				Integer.parseInt(month), Integer.parseInt(year));
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();
		String json = gson.toJson(absences);

		System.out.println(json);

		request.setAttribute("absenceForChart", json);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/report-chart.jsp");
		dispatcher.forward(request, response);
	}

}
