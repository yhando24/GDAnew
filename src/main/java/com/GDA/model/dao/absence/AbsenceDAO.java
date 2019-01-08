package main.java.com.GDA.model.dao.absence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.java.com.GDA.bean.Absence;
import main.java.com.GDA.bean.AbsenceType;
import main.java.com.GDA.bean.Status;
import main.java.com.GDA.utils.ConnectionDB;

public class AbsenceDAO implements  IabsencesDAO {

	
	
	// way for get all absences in BDD
	@Override
	public List<Absence> findAllAbsences() {
		// TODO Auto-generated method stub
		ArrayList <Absence> absences = new ArrayList<Absence>();
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		
		try {
			connection = ConnectionDB.getConnection();
			String query = "SELECT absence.id, startDate, endDate, reason, idAbsenceType, idStatus, idUser, absencetype.name as nameType, status.name as nameStatus FROM absence JOIN absencetype ON absence.id = absencetype.id JOIN status ON status.id = idStatus";
			prepareStatement = connection.prepareStatement(query);
			
			ResultSet resultSet = prepareStatement.executeQuery();
			
			System.out.println(prepareStatement.toString());
		
			while (resultSet.next()){
				 Absence absence = new Absence();
				 absence.setId(resultSet.getInt("id"));
				 absence.setStartDate(resultSet.getTimestamp("startDate"));
				 absence.setEndDate(resultSet.getTimestamp("endDate"));
				 absence.setReason(resultSet.getString("reason"));
				 absence.setAbsenceType(new AbsenceType(resultSet.getInt("idAbsenceType"),resultSet.getString("nameType")));
				 absence.setStatus(new Status(resultSet.getInt("idStatus"),resultSet.getString("nameType")));
				 absence.setIdUser(resultSet.getInt("idUser"));	
				 absences.add(absence);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
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
	
	
	// way for update  absences in BDD, specify id of old absence and the new absence
	@Override
	public void updateAbsence(int id, Absence absence) {
	
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		

		try
		{
			connection = ConnectionDB.getConnection();
			connection.setAutoCommit(false);
			
			String query = "UPDATE abscence set startDate = ?, endDate = ?, reason = ?, idAbsenceType = ?, idStatus = ?, idUser = ? WHERE id = ?";
			
			prepareStatement = connection.prepareStatement(query);

			prepareStatement.setDate(1, new java.sql.Date(absence.getStartDate().getTime()) );
			prepareStatement.setDate(2, new java.sql.Date(absence.getEndDate().getTime()) );
			prepareStatement.setString(3, absence.getReason());
			prepareStatement.setInt(4, absence.getIdAbsenceType() );
			prepareStatement.setInt(5, absence.getIdStatus());
			prepareStatement.setInt(6, absence.getIdUser());
			prepareStatement.setInt(7, absence.getId());
						
			Integer update = prepareStatement.executeUpdate(query);
			System.out.println("R�sultat de la requ�te UPDATE => " + update.intValue());
			

			connection.commit();
			
			
		}
		catch (Exception e)
		{
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally
		{
			try {
				prepareStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
	
	
	// way for get absence with his id
	@Override
	public Absence findAbsenceById(int id) {
		
		 Absence absence = new Absence();
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		
		try {
			connection = ConnectionDB.getConnection();
			String query = "SELECT * FROM absence where id = ?";
			prepareStatement = connection.prepareStatement(query);
			
			prepareStatement.setInt(1,id );
			
			ResultSet resultSet = prepareStatement.executeQuery();
			
			System.out.println(prepareStatement.toString());
		
			while (resultSet.next()){
				
				 absence.setId(resultSet.getInt("id"));
				 absence.setStartDate(resultSet.getTimestamp("startDate"));
				 absence.setEndDate(resultSet.getTimestamp("endDate"));
				 absence.setReason(resultSet.getString("reason"));
				 absence.setIdAbsenceType(resultSet.getInt("idAbsenceType"));
				 absence.setIdStatus(resultSet.getInt("idStatus"));
				 absence.setIdUser(resultSet.getInt("idUser"));			 
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				prepareStatement.close();
				connection.close();
			} catch (SQLException e) {
				// ne rien faire
				e.printStackTrace();
			}
		}
		return absence;
	}
	
	
	
	// way for get user absences by his id
	@Override
	public List<Absence> findAbsencesByIdUser(int idUser) {
		
		// TODO Auto-generated method stub

		ArrayList <Absence> absences = new ArrayList<Absence>();
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		
		try {
			connection = ConnectionDB.getConnection();
			String query = "SELECT * FROM absence where idUser = ?";
			prepareStatement = connection.prepareStatement(query);
			
			prepareStatement.setInt(1,idUser );
			
			ResultSet resultSet = prepareStatement.executeQuery();
			
			System.out.println(prepareStatement.toString());
		
			while (resultSet.next()){
				 Absence absence = new Absence();
				 absence.setId(resultSet.getInt("id"));
				 absence.setStartDate(resultSet.getTimestamp("startDate"));
				 absence.setEndDate(resultSet.getTimestamp("endDate"));
				 absence.setReason(resultSet.getString("reason"));
				 absence.setIdAbsenceType(resultSet.getInt("idAbsenceType"));
				 absence.setIdStatus(resultSet.getInt("idStatus"));
				 absence.setIdUser(resultSet.getInt("idUser"));		
				 
				 absences.add(absence);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
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
	
	
	// way for get type of absence in all absence
	@Override
	public List<Absence> findAbsencesByIdAbsenceType(int absenceType) {
	ArrayList <Absence> absences = new ArrayList<Absence>();
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		
		try {
			connection = ConnectionDB.getConnection();
			String query = "SELECT * FROM absence where idAbsenceType = ?";
			prepareStatement = connection.prepareStatement(query);
			
			prepareStatement.setInt(1,absenceType );
			
			ResultSet resultSet = prepareStatement.executeQuery();
			
			System.out.println(prepareStatement.toString());
		
			while (resultSet.next()){
				 Absence absence = new Absence();
				 absence.setId(resultSet.getInt("id"));
				 absence.setStartDate(resultSet.getTimestamp("startDate"));
				 absence.setEndDate(resultSet.getTimestamp("endDate"));
				 absence.setReason(resultSet.getString("reason"));
				 absence.setIdAbsenceType(resultSet.getInt("idAbsenceType"));
				 absence.setIdStatus(resultSet.getInt("idStatus"));
				 absence.setIdUser(resultSet.getInt("idUser"));		
				 
				 absences.add(absence);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
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
	
	
	// way for get absences by the status of the absence
	@Override
	public List<Absence> findAbsencesByIdAbsenceStatut(int absenceStatut) {
		// TODO Auto-generated method stub
	ArrayList <Absence> absences = new ArrayList<Absence>();
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		
		try {
			connection = ConnectionDB.getConnection();
			String query = "SELECT * FROM absence where idStatus = ?";
			prepareStatement = connection.prepareStatement(query);
			
			prepareStatement.setInt(1,absenceStatut );
			
			ResultSet resultSet = prepareStatement.executeQuery();
			
			System.out.println(prepareStatement.toString());
		
			while (resultSet.next()){
				 Absence absence = new Absence();
				
				 absence.setStartDate(resultSet.getTimestamp("startDate"));
				 absence.setEndDate(resultSet.getTimestamp("endDate"));
				 absence.setReason(resultSet.getString("reason"));
				 absence.setIdAbsenceType(resultSet.getInt("idAbsenceType"));
				 absence.setIdStatus(resultSet.getInt("idStatus"));
				 absence.setIdUser(resultSet.getInt("idUser"));		
				 
				 absences.add(absence);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
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


	// way for add an absence
	@Override
	public void addAbsence(Absence absence) {
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		 int result;
			try {
				connection = ConnectionDB.getConnection();
				String Query = "INSERT INTO absence VALUES (?,?,?,?,?,?)";
		
				prepareStatement = connection.prepareStatement(Query);
				
				prepareStatement.setDate(1, new java.sql.Date(absence.getStartDate().getTime()) );
				prepareStatement.setDate(2, new java.sql.Date(absence.getEndDate().getTime()) );
				prepareStatement.setString(3, absence.getReason());
				prepareStatement.setInt(4, absence.getAbsenceType().getId() );
				prepareStatement.setInt(5, absence.getStatus().getId());
				prepareStatement.setInt(6, absence.getIdUser());
				 
				 
				result = prepareStatement.executeUpdate(Query);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
		
					prepareStatement.close();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
			}
		
	}

	// way for delete an absence
	@Override
	public void deleteAbsence(int id) {
		
		
		Connection connection = null;
		Statement statement = null;
		 int result;
		
		try {
			connection = ConnectionDB.getConnection();
			String Query = "DELETE FROM absence where id ="+id;
		
			statement = connection.createStatement();
			result = statement.executeUpdate(Query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
	
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
	}



	
	
}
