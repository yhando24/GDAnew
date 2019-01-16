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

public class AbsenceForReportDAO {
	public List<AbsenceForReport> findAllAbsencesByDepartementMonthAndYear(int idDep , String month,String year ){

		   List<AbsenceForReport> absences = new ArrayList<AbsenceForReport>();

		   Connection connection = null;
		   PreparedStatement prepareStatement = null;

		       try {
		           connection = ConnectionDB.getConnection();
		          // String query = "SELECT absence.id as idAbsence, startDate , endDate , reason , idAbsenceType , idStatus , idUser , user.name ,user.firstname ,status.name as namestatus , absencetype.name as nameType FROM absence JOIN user ON user.id = absence.idUser JOIN status ON idStatus = status.id JOIN absencetype on absencetype.id = idAbsencetype WHERE user.idDepartement = ? AND absence.idStatus = 2 ORDER BY idUser";
		           String query = "SELECT startDate , (DAYOFYEAR(endDate) - DAYOFYEAR(startDate) +1)  as duration , DAY( LAST_DAY(startDate)) as lastDay FROM absence JOIN user ON user.id = absence.idUser JOIN departement ON departement.id = user.idDepartement WHERE user.idDepartement = 1 AND YEAR(startDate) = 2019 AND  MONTH(startDate) = 1"; 
		      
		           
		           prepareStatement = connection.prepareStatement(query);

		           prepareStatement.setInt(1,idDep );

		           ResultSet resultSet = prepareStatement.executeQuery();

		           System.out.println(prepareStatement.toString());
		           System.out.println("avant le result next");
		     
		           while (resultSet.next()){
		              
		        	   AbsenceForReport absence = new AbsenceForReport();
			               
			            
		                absence.setDateStart(LocalDate.parse(resultSet.getString("startDate")));
		                absence.setDuration(resultSet.getInt("lastDay")); //lastDay
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

}