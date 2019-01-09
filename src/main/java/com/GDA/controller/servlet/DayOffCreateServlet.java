package main.java.com.GDA.controller.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import main.java.com.GDA.bean.JourFerie;
import main.java.com.GDA.bean.Status;
import main.java.com.GDA.bean.TypeJourFerie;
import main.java.com.GDA.bean.User;
import main.java.com.GDA.model.dao.dayoff.DayoffDAO;

/**
 * Servlet implementation class DayOfCreateServlet
 */
@WebServlet("/DayOffCreateServlet")
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
		JourFerie jourferie = new JourFerie();
		
		String dayOff = request.getParameter("dayoff");
		DateFormat writeFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
		Date startDateFormated = new Date();
	
		try {
			startDateFormated = writeFormat.parse(dayOff);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jourferie.setDayOff(startDateFormated);

		jourferie.setComment(request.getParameter("reason"));
		TypeJourFerie type = new TypeJourFerie();
		type.setId(Integer.parseInt(request.getParameter("ferieType")));
		jourferie.setTypeJourFerie(type);
		
		Status status = new Status();
		
		status.setId(2);
		DayoffDAO dao = new DayoffDAO();
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user.getFunction().equals(1)) {
			try {
				dao.createDayoff(jourferie);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			response.sendRedirect(request.getContextPath() + "/DayOffCreate.jsp"); // logged-in page
	}
		}
	}	
		
