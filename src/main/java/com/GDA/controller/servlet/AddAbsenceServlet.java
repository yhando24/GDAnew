package main.java.com.GDA.controller.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
@WebServlet("/AddAbsence")
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
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		String startDateStr = request.getParameter("beginAbsence");
	    String endDateStr = request.getParameter("endAbsence");

		Date startDate = null;
		try {
			startDate = simpleDateFormat.parse(startDateStr);
		} catch (ParseException e) {
			System.out.println("erreur de conversion");
			e.printStackTrace();
		}
	

		Date endDate = null;
		try {
			endDate = simpleDateFormat.parse(endDateStr);
		} catch (ParseException e) {
			System.out.println("erreur de conversion");
			e.printStackTrace();
		}
	
		absence.setStartDate(startDate);

		absence.setEndDate(endDate);
	
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
	
		dao.addAbsence(absence);
		
		response.sendRedirect(request.getContextPath() + "/AbsencesManagement"); // logged-in page
	
	}

}
