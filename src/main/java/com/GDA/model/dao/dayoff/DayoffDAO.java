package main.java.com.GDA.model.dao.dayoff;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import main.java.com.GDA.bean.Departement;
import main.java.com.GDA.bean.Dayoff;
import main.java.com.GDA.bean.TypeDayOff;
import main.java.com.GDA.utils.ConnectionDB;

public class DayoffDAO implements IdayoffDAO {

	@Override
	public Dayoff findDayOffById(int id){
		Dayoff j = new Dayoff();
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
		
		try {
			resultset.close();
			prepareStatement.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
			
	return j;
}


	@Override
	public Dayoff findDayOffByDate(Date date){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dayoff findDayOffByDepartement(int idDepartement){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createDayoff(Dayoff dayOff) {
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		int result;
	
		 
			  			
			try {
				connection = ConnectionDB.getConnection();
				String Query = "INSERT INTO dayoff (date, idTypeDayOff, idDepartement, comment) VALUES (?,?,?,?)";
				
				

				
				
				prepareStatement = connection.prepareStatement(Query);
//				
				prepareStatement.setDate(1, Date.valueOf(dayOff.getDayOff()));
				prepareStatement.setInt(2, dayOff.getTypeDayOff().getId()); // 

				prepareStatement.setInt(3, dayOff.getDepartement().getId());
				prepareStatement.setString(4, dayOff.getComment()); // 

				result = prepareStatement.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					if(connection != null) {
						prepareStatement.close();
						connection.close();
					}
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
			}
	}

	@Override
	public Dayoff updateDayoff(int idDayOff, Dayoff dayOffToUpdate){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dayoff deleteDayOff(Date date) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDateExist(Date date) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
