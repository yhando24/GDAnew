package com.GDA.controller.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.GDA.bean.Absence;
import com.GDA.bean.AbsenceType;
import com.GDA.bean.Status;
import com.GDA.bean.User;
import com.GDA.model.dao.absence.AbsenceDAO;

/**
 * Servlet implementation class UpdateAbsenceServlet
 */
@WebServlet("/update-absence")
public class UpdateAbsenceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateAbsenceServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String idAbsenceAModifier = (String) session.getAttribute("idAbsenceAModifier");
		int id = Integer.parseInt(idAbsenceAModifier);
		System.out.println(idAbsenceAModifier);
		AbsenceDAO absencedao = new AbsenceDAO();
		List<Absence> absence = new ArrayList<Absence>();
		absence = absencedao.findAbsencesByIdUser(id);

		session.setAttribute("absenceAModifier", absence);
		System.out.println(absence);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/absence-modif.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Absence absence = new Absence();
		AbsenceDAO absencedao = new AbsenceDAO();

		HttpSession session = request.getSession();
		Absence a = (Absence) session.getAttribute("absenceAModifier");

		String startDateStr = request.getParameter("beginAbsence");
		String endDateStr = request.getParameter("endAbsence");

		LocalDate start = LocalDate.parse(startDateStr);
		LocalDate end = LocalDate.parse(endDateStr);

		absence.setId(a.getId());

		absence.setStartDate(start.plusDays(1));

		absence.setEndDate(end.plusDays(1));

		absence.setReason(request.getParameter("motif"));

		AbsenceType type = new AbsenceType();
		type.setId(Integer.parseInt(request.getParameter("congeType")));
		absence.setAbsenceType(type);

		Status status = new Status();
		status.setId(2);
		absence.setStatus(status);

		User user = (User) session.getAttribute("user");
		absence.setUser(user);

		System.out.println(absence);

		absencedao.update(absence);

		response.sendRedirect(request.getContextPath() + "/absences-management");

	}

}
