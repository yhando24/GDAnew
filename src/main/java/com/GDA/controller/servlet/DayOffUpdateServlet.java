package main.java.com.GDA.controller.servlet;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.com.GDA.bean.Dayoff;
import main.java.com.GDA.bean.TypeDayOff;
import main.java.com.GDA.model.dao.dayoff.DayoffDAO;
import main.java.com.GDA.model.dao.dayoff.IdayoffDAO;

/**
 * Servlet implementation class DayOffUpdateServlet
 */
@WebServlet("/day-off-update")
public class DayOffUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DayOffUpdateServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String idJourAModifier = (String) session.getAttribute("idJourAModifier");
		int idDayOff = Integer.parseInt(idJourAModifier);

		System.out.println(idJourAModifier);

		DayoffDAO dayOffDao = new DayoffDAO();
		Dayoff dayOff = new Dayoff();
		dayOff = dayOffDao.findDayOffById(idDayOff);

		session.setAttribute("JourAModifier", dayOff);
		
		System.out.println(dayOff);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/day-off-update.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Dayoff dayOff = new Dayoff();
		DayoffDAO dayOffDao = new DayoffDAO();

		HttpSession session = request.getSession();
		Dayoff d = (Dayoff) session.getAttribute("JourAModifier");
		
		System.out.println(d.getDepartement());

		String date = request.getParameter("date");
		String ferieType = request.getParameter("ferieType");
		String comment = request.getParameter("comment");
		
		dayOff.setId(d.getId());
		dayOff.setDayOff(LocalDate.parse(date).plusDays(1));
		
		TypeDayOff type = new TypeDayOff();
		type.setId(Integer.parseInt(ferieType));
		dayOff.setTypeDayOff(type);
		
		dayOff.setDepartement(d.getDepartement());
				
		dayOff.setComment(comment);

		System.out.println(dayOff);

		dayOffDao.updateDayoff(dayOff.getId(), dayOff);

		response.sendRedirect(request.getContextPath() + "/day-off-management");
		
	}

}
