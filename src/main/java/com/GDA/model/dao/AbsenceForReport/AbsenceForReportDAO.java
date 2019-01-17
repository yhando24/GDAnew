package main.java.com.GDA.model.dao.AbsenceForReport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import main.java.com.GDA.bean.AbsenceForReport;
import main.java.com.GDA.utils.ConnectionDB;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
public class AbsenceForReportDAO {

	public List<AbsenceForReport> findAllAbsencesByDepartementMonthAndYear(int idDep, String month, String year) {


		   List<AbsenceForReport> absences = new ArrayList<AbsenceForReport>();

		   Connection connection = null;
		   PreparedStatement prepareStatement = null;

		       try {
		           connection = ConnectionDB.getConnection();
		          // String query = "SELECT absence.id as idAbsence, startDate , endDate , reason , idAbsenceType , idStatus , idUser , user.name ,user.firstname ,status.name as namestatus , absencetype.name as nameType FROM absence JOIN user ON user.id = absence.idUser JOIN status ON idStatus = status.id JOIN absencetype on absencetype.id = idAbsencetype WHERE user.idDepartement = ? AND absence.idStatus = 2 ORDER BY idUser";
		           String query = "SELECT startDate , (DAYOFYEAR(endDate) - DAYOFYEAR(startDate) +1)  as duration , DAY( LAST_DAY(startDate)) as lastDay FROM absence JOIN user ON user.id = absence.idUser JOIN departement ON departement.id = user.idDepartement WHERE user.idDepartement = ? AND YEAR(startDate) = ? AND  MONTH(startDate) = ?"; 
		      
		           
		           prepareStatement = connection.prepareStatement(query);

		           prepareStatement.setInt(1,idDep );
		           prepareStatement.setString(2,year );
		           prepareStatement.setString(3,month );
		           ResultSet resultSet = prepareStatement.executeQuery();

		     
		     
		           while (resultSet.next()){
		              
		        	   AbsenceForReport absence = new AbsenceForReport();
			               
			            
		                absence.setDateStart(LocalDate.parse(resultSet.getString("startDate")));
		                absence.setDuration(resultSet.getInt("duration")); //lastDay
		                absence.setLastDayOfMonth(resultSet.getInt("lastDay"));
		       
		                absences.add(absence);
		       
		             
		           }
		       }
		       catch (Exception e){
		           e.printStackTrace();
		       }
		       finally{
		           try {
		               prepareStatement.close();
		               connection.close();
		           } catch (SQLException e) {
		               // ne rien faire
		               e.printStackTrace();
		           }
		       }
		       
		       return absences;

		}

	public List<AbsenceForReport> findAllAbsencesByNameDepartementMonthAndYear(int idDep, String month, String year) {

		List<AbsenceForReport> absencesPlanning = new ArrayList<AbsenceForReport>();

		Connection connection = null;
		PreparedStatement prepareStatement = null;

		try {
			connection = ConnectionDB.getConnection();
			// String query = "SELECT absence.id as idAbsence, startDate , endDate , reason
			// , idAbsenceType , idStatus , idUser , user.name ,user.firstname ,status.name
			// as namestatus , absencetype.name as nameType FROM absence JOIN user ON
			// user.id = absence.idUser JOIN status ON idStatus = status.id JOIN absencetype
			// on absencetype.id = idAbsencetype WHERE user.idDepartement = ? AND
			// absence.idStatus = 2 ORDER BY idUser";
//		           String query = "SELECT startDate , (DAYOFYEAR(endDate) - DAYOFYEAR(startDate) +1)  as duration , DAY( LAST_DAY(startDate)) as lastDay FROM absence JOIN user ON user.id = absence.idUser JOIN departement ON departement.id = user.idDepartement WHERE user.idDepartement = ? AND YEAR(startDate) = ? AND  MONTH(startDate) = ?"; 

			String query = "SELECT user.name, startDate, endDate, DAY( LAST_DAY(startDate)) as lastDay FROM absence JOIN user ON user.id = absence.idUser JOIN departement ON departement.id = user.idDepartement WHERE user.idDepartement = ? AND YEAR(startDate) = ? AND MONTH(startDate) = ?";

			prepareStatement = connection.prepareStatement(query);

			prepareStatement.setInt(1, idDep);
			prepareStatement.setString(2, year);
			prepareStatement.setString(3, month);
			ResultSet resultSet = prepareStatement.executeQuery();

			while (resultSet.next()) {

				AbsenceForReport absencePlanning = new AbsenceForReport();

				absencePlanning.setDateStart(LocalDate.parse(resultSet.getString("startDate")));
				absencePlanning.setDuration(resultSet.getInt("lastDay")); // lastDay
				absencePlanning.setLastDayOfMonth(resultSet.getInt("lastDay"));

				absencesPlanning.add(absencePlanning);
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				prepareStatement.close();
				connection.close();
			} catch (SQLException e) {
				// ne rien faire
				e.printStackTrace();
			}
		}
		return absencesPlanning;
	}
}
