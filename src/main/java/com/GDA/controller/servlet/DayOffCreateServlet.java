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
import main.java.com.GDA.bean.JourFerie;
import main.java.com.GDA.bean.Status;
import main.java.com.GDA.bean.TypeJourFerie;
import main.java.com.GDA.bean.User;
import main.java.com.GDA.model.dao.absence.AbsenceDAO;
import main.java.com.GDA.model.dao.dayoff.DayoffDAO;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/view/DayOffCreate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		JourFerie dayOff = new JourFerie();
		

		
		DayoffDAO dao = new DayoffDAO();

		String pattern = "yyyy-MM-dd";
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
		dtf = dtf.withLocale(Locale.US);
		String DateStr = request.getParameter("date");
	

		LocalDate Date = LocalDate.parse(DateStr, dtf);
		





		dayOff.setDayOff(Date.plusDays(1));


	
		dayOff.setComment(request.getParameter("comment"));
		TypeJourFerie type = new TypeJourFerie();
		type.setId(Integer.parseInt(request.getParameter("ferieType")));
		dayOff.setTypeJourFerie(type);
		Departement departement = new Departement();
		departement.setId(user.getDepartement().getId());
		dayOff.setDepartement(departement);
		
		// verification non chevauchement de l'absence demandé avec absence presente en BDD
		
//		
//		List <Absence> absences = new ArrayList <Absence>();
//		
//		absences = dao.findAbsencesByIdUser(user.getId());
//		
//		boolean Chevauchement = false;
//		
//		for (Absence absence2 : absences) {
//			System.out.println("test");
//			if(absence.getStartDate().isBefore(absence2.getEndDate())) {
//				System.out.println("dans le 1er if");
//				if(absence.getEndDate().isAfter(absence2.getStartDate())) {
//					Chevauchement = true;
//					System.out.println("Sa chevauche");
//					break;
//				}
//			}
//		}
	
		// verification date j+1
		
		boolean JourPlus1 = true;
		
		if(!dayOff.getDayOff().isAfter(LocalDate.now())) {
			JourPlus1= false;
			System.out.println("j pas +1");
		}
		
//		boolean finAfterDebut = false;
//		
//		if(absence.getEndDate().isAfter(absence.getStartDate()) || absence.getEndDate().equals(absence.getStartDate())) {
//			finAfterDebut = true;
//			System.out.println("fin date après debut");
//		}
		
	
		
		
		// rajout de l'absence si pas de chevauchement
		
		if(
//				!Chevauchement && 
				JourPlus1 
//				&& finAfterDebut 
				) {
			
			//rajout d'un jour a la date et actualisation des date de l'absence
		
		
			
			// rajout de l'absence a la BDD		
			dao.createDayoff(dayOff);
			System.out.println("ajout jour ferie");

//			//conversion pour affichage et actualisation de l'user en session
//			System.out.println(" ici :" + absence.getStartDate());
//			absences = dao.findAbsencesByIdUser(user.getId());
//			user.setAbsences(absences);
//			session.setAttribute("user", user);
//			System.out.println("Sa chevauche pas et j+1");
//			response.sendRedirect(request.getContextPath() + "/absences-management");
//			session.setAttribute("errorAdd", null);
//
//		}else {
//			session.setAttribute("errorAdd", "Probleme de chevauchement de date, votre demande d'absence n'a pas été enregistrée");
//			response.sendRedirect(request.getContextPath() + "/absences-management?action=addAbsence"); // logged-in page
//		}
//		
//		
//		
//		JourFerie jourferie = new JourFerie();
//		
//		String dayOff = request.getParameter("dayoff");
//		DateFormat writeFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
//		Date startDateFormated = new Date();
//	
//		try {
//			startDateFormated = writeFormat.parse(dayOff);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		jourferie.setDayOff(startDateFormated);
//
//		jourferie.setComment(request.getParameter("reason"));
//		TypeJourFerie type = new TypeJourFerie();
//		type.setId(Integer.parseInt(request.getParameter("ferieType")));
//		jourferie.setTypeJourFerie(type);
//		
//		Status status = new Status();
//		
//		status.setId(2);
//		DayoffDAO dao = new DayoffDAO();
//		
//		HttpSession session = request.getSession();
//		User user = (User) session.getAttribute("user");
//		if (user.getFunction().equals(1)) {
//			try {
//				dao.createDayoff(jourferie);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			response.sendRedirect(request.getContextPath() + "/create-day-off"); // logged-in page
	}
		}
	}	
		
