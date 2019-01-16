package main.java.com.GDA.controller.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.com.GDA.bean.Absence;
import main.java.com.GDA.bean.AbsenceType;
import main.java.com.GDA.bean.Status;
import main.java.com.GDA.bean.User;
import main.java.com.GDA.model.dao.absence.AbsenceDAO;


/**
 * Servlet implementation class AddAbsenceServlet
 */
@WebServlet("/add-absence")
public class AddAbsenceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAbsenceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/view/requiest-for-absences.jsp") ;
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Absence absence = new Absence();
		

		
		AbsenceDAO dao = new AbsenceDAO();

		String pattern = "yyyy-MM-dd";
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
		dtf = dtf.withLocale(Locale.US);
		String startDateStr = request.getParameter("beginAbsence");
	    String endDateStr = request.getParameter("endAbsence");

		LocalDate startDate = LocalDate.parse(startDateStr, dtf);
		


		LocalDate endDate =   LocalDate.parse(endDateStr, dtf);


		absence.setStartDate(startDate.plusDays(1));

		absence.setEndDate(endDate.plusDays(1));
	
		absence.setReason(request.getParameter("reason"));
		AbsenceType type = new AbsenceType();
		type.setId(Integer.parseInt(request.getParameter("congeType")));
		absence.setAbsenceType(type);
		
		Status status = new Status();
		
		status.setId(2);
		absence.setStatus(status);
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		absence.setIdUser(user.getId());
	
		
		
		// verification non chevauchement de l'absence demandé avec absence presente en BDD
		
		
		List <Absence> absences = new ArrayList <Absence>();
		
		absences = dao.findAbsencesByIdUser(user.getId());
		
		boolean Chevauchement = false;
		
		for (Absence absence2 : absences) {
			System.out.println("test");
			if(absence.getStartDate().isBefore(absence2.getEndDate())) {
				System.out.println("dans le 1er if");
				if(absence.getEndDate().isAfter(absence2.getStartDate())) {
					Chevauchement = true;
					System.out.println("Ça chevauche");
					break;
				}
			}
		}
	
		// verification date j+1
		
		boolean JourPlus1 = true;
		
		if(!absence.getStartDate().isAfter(LocalDate.now())) {
			JourPlus1= false;
			System.out.println("j pas +1");
		}
		
		boolean finAfterDebut = false;
		
		if(absence.getEndDate().isAfter(absence.getStartDate()) || absence.getEndDate().equals(absence.getStartDate())) {
			finAfterDebut = true;
			System.out.println("fin date aprés début");
		}
		
		System.out.println(finAfterDebut);
		
		
		// rajout de l'absence si pas de chevauchement
		
		if(!Chevauchement && JourPlus1 && finAfterDebut ) {
			
			//rajout d'un jour a la date et actualisation des date de l'absence
		
		
			
			// rajout de l'absence a la BDD		
			dao.addAbsence(absence);
			

			//conversion pour affichage et actualisation de l'user en session
			System.out.println(" ici :" + absence.getStartDate());
			absences = dao.findAbsencesByIdUser(user.getId());
			user.setAbsences(absences);
			session.setAttribute("user", user);
			System.out.println("Ça chevauche pas et j+1");
			response.sendRedirect(request.getContextPath() + "/absences-management");
			session.setAttribute("errorAdd", null);

		}else {
			session.setAttribute("errorAdd", "Probleme de chevauchement de date, votre demande d'absence n'a pas été enregistrée");
			response.sendRedirect(request.getContextPath() + "/absences-management?action=addAbsence"); // logged-in page
		}


		
		System.out.println("fin" + absence.getEndDate());
		

	
	}

}
