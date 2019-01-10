package main.java.com.GDA.controller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.com.GDA.bean.Absence;
import main.java.com.GDA.model.dao.absence.AbsenceDAO;

/**
 * Servlet implementation class UpdateAbsenceServlet
 */
@WebServlet("/updateAbsence")
public class UpdateAbsenceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAbsenceServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String idAbsenceAModifier = (String) request.getAttribute("idAbsenceAModifier");
		 int id = Integer.parseInt(idAbsenceAModifier);
		 System.out.println(idAbsenceAModifier);
		 AbsenceDAO absencedao = new AbsenceDAO();
		 Absence absence = new Absence();
		 absence = absencedao.findAbsenceById(id);
		 
		 HttpSession session = request.getSession();
		 session.setAttribute("absenceAModifier", absence);
		 System.out.println(absence);
		 
		 
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/absence-modif.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		doGet(request, response);
	}

}
