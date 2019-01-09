package main.java.com.GDA.model.dao.dayoff;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import main.java.com.GDA.bean.Departement;
import main.java.com.GDA.bean.JourFerie;
import main.java.com.GDA.utils.ConnectionDB;

public class DayoffDAO implements IdayoffDAO {

	@Override
	public JourFerie findDayOffById(int id) throws SQLException {
		JourFerie j = new JourFerie();
		DayoffDAO dayoff = new DayoffDAO();
		Departement d = new Departement();
		
		Connection conn = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultset = null;
		
		try {
			conn = ConnectionDB.getConnection();
			String query = "Select * FROM dayoff JOIN departement_typedayoff ON departement.id = departement_typedayoff.departement_id  JOIN dayoff ON departement_dayoff.dayoff_id = dayoff.id WHERE dayoff.id = ?";
			prepareStatement = conn.prepareStatement(query);
			prepareStatement.setInt(1, id);
			resultset = prepareStatement.executeQuery();
		}
		
	
		catch (Exception e) {
		
		e.printStackTrace();
		
	}
	finally {
		
		resultset.close();
		prepareStatement.close();
		conn.close();
		
	}
			
	return j;
}


	@Override
	public JourFerie findDayOffByDate(Date date) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JourFerie findDayOffByDepartement(int idDepartement) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JourFerie createDayoff(JourFerie dayOff) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JourFerie updateDayoff(int idDayOff, JourFerie dayOffToUpdate) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JourFerie deleteDayOff(Date date) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDateExist(Date date) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
