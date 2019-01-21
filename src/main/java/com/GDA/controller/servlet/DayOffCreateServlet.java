package main.java.com.GDA.controller.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.com.GDA.bean.Absence;
import main.java.com.GDA.bean.AbsenceType;
import main.java.com.GDA.bean.Departement;
import main.java.com.GDA.bean.Dayoff;
import main.java.com.GDA.bean.Status;
import main.java.com.GDA.bean.TypeDayOff;
import main.java.com.GDA.bean.User;
import main.java.com.GDA.model.dao.absence.AbsenceDAO;
import main.java.com.GDA.model.dao.dayoff.DayoffDAO;
import main.java.com.GDA.model.dao.user.UserDAO;

/**
 * Servlet implementation class DayOfCreateServlet
 */
@WebServlet("/create-day-off")
public class DayOffCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DayOffCreateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/view/DayOffCreate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		Dayoff dayOff = new Dayoff();

		DayoffDAO dao = new DayoffDAO();

		String pattern = "yyyy-MM-dd";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
		dtf = dtf.withLocale(Locale.US);
		String DateStr = request.getParameter("date");

		LocalDate Date = LocalDate.parse(DateStr, dtf);

		dayOff.setDayOff(Date.plusDays(1));

		dayOff.setComment(request.getParameter("comment"));
		TypeDayOff type = new TypeDayOff();
		type.setId(Integer.parseInt(request.getParameter("ferieType")));
		dayOff.setTypeDayOff(type);
		Departement departement = new Departement();
		departement.setId(user.getDepartement().getId());
		dayOff.setDepartement(departement);

		// verification non chevauchement de l'absence demand� avec absence presente en
		// BDD

		
		List <Dayoff> dayOffs = new ArrayList <Dayoff>();
		
		dayOffs = dao.findAllDayOff();
		
		boolean Chevauchement = false;
		
		for (Dayoff dayoff2 : dayOffs) {
			System.out.println("test :" + dayoff2.getDayOff() + " lautre :  " + dayOff.getDayOff().minusDays(1));
			if (dayoff2.getDayOff().isEqual(dayOff.getDayOff().minusDays(1))) {
				Chevauchement = true;
				System.out.println("ça chevauche");
				session.setAttribute("errorAdd", "Probleme de chevauchement de date, un jour férié existe deja a cette date");
				response.sendRedirect(request.getContextPath() + "/create-day-off"); // logged-in page
				break;
			}
		}
	

	// verification date j+1

	boolean JourPlus1 = true;

	if(!dayOff.getDayOff().isAfter(LocalDate.now()))
	{
		JourPlus1 = false;
		System.out.println("j pas +1");
	}



	// rajout de l'absence si pas de chevauchement

	if(
			!Chevauchement && 
	JourPlus1

	)
	{

		// rajout d'un jour a la date et actualisation des date de l'absence

		// rajout de l'absence a la BDD
		if (type.getId() == 2) {
			UserDAO daoUser = new UserDAO();
			AbsenceDAO daoAbsence = new AbsenceDAO();
			ArrayList<User> users = daoUser.findUserByIdDepartement(user.getDepartement().getId());
			for (User user2 : users) {
				Absence absence = new Absence();
				absence.setStartDate(Date.plusDays(1));
				absence.setEndDate(Date.plusDays(1));
				absence.setReason(request.getParameter("comment"));
				Status status = new Status();
				status.setId(3);
				absence.setStatus(status);
				AbsenceType abstype = new AbsenceType();
				abstype.setId(5);
				absence.setAbsenceType(abstype);
				absence.setIdUser(user2.getId());
				daoAbsence.addAbsence(absence);
			}
		}

		dao.createDayoff(dayOff);
		System.out.println("ajout jour férié");



		response.sendRedirect(request.getContextPath() + "/day-off-management"); // logged-in page
	}
}}
