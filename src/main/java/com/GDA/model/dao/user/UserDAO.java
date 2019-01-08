package main.java.com.GDA.model.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import main.java.com.GDA.bean.Absence;
import main.java.com.GDA.bean.Departement;
import main.java.com.GDA.bean.Function;
import main.java.com.GDA.bean.User;
import main.java.com.GDA.model.dao.absence.AbsenceDAO;
import main.java.com.GDA.utils.ConnectionDB;

public class UserDAO implements IUserDAO {

	@Override
	public User findUserByEmail(String email) throws SQLException {
		
		User u = new User();
		AbsenceDAO absence = new AbsenceDAO();
		Departement d = new Departement();
		Function f = new Function();
		
		Connection conn = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultset = null;
		
		try {
			
			conn = ConnectionDB.getConnection();
			
			String query = "SELECT u.id,u.firstname,u.name,u.email,u.password,u.idFunction,u.idDepartement,u.nbrDaysOfLeave,u.nbrRTT,f.name as namefunc,d.name as namedep FROM user u JOIN diginamicproject.function f ON u.idFunction = f.id JOIN departement d ON u.idDepartement=d.id WHERE email = ?";
			
			prepareStatement = conn.prepareStatement(query);
			
			prepareStatement.setString(1, email);
			
			resultset = prepareStatement.executeQuery();
			
		
			
			
			while (resultset.next()) {
				
				u.setId(resultset.getInt("id"));
				u.setFirstname(resultset.getString("firstname"));
				u.setName(resultset.getString("name"));
				u.setEmail(resultset.getString("email"));
				u.setPassword(resultset.getString("password"));
				d.setName(resultset.getString("namedep"));
				d.setId(resultset.getInt("idDepartement"));
				u.setDepartement(d);
				f.setId(resultset.getInt("idFunction"));
				f.setName(resultset.getString("namefunc"));
				u.setFunction(f);
				u.setNbrDaysOfLeave(resultset.getInt("nbrDaysOfLeave"));
				u.setNbrRTT(resultset.getInt("nbrRTT"));
				u.setAbsences(absence.findAbsencesByIdUser(u.getId()));
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		finally {
			
			resultset.close();
			prepareStatement.close();
			conn.close();
			
		}
				
		return u;
	}

	@Override
	public User findUserById(int id) throws SQLException {
		
		User u = new User();
		AbsenceDAO absence = new AbsenceDAO();
		Departement d = new Departement();
		Function f = new Function();
		
		Connection conn = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultset = null;
		
		try {
			
			conn = ConnectionDB.getConnection();
			
			String query = "SELECT u.id,u.firstname,u.name,u.email,u.password,u.idFunction,u.idDepartement,u.nbrDaysOfLeave,u.nbrRTT,f.name as namefunc,d.name as namedep FROM user u JOIN diginamicproject.function f ON u.idFunction = f.id JOIN departement d ON u.idDepartement=d.id WHERE id = ?";
			
			prepareStatement = conn.prepareStatement(query);
			
			prepareStatement.setInt(1, id);
			
			resultset = prepareStatement.executeQuery();
			
		
			
			
			while (resultset.next()) {
				
				u.setId(resultset.getInt("id"));
				u.setFirstname(resultset.getString("firstname"));
				u.setName(resultset.getString("name"));
				u.setEmail(resultset.getString("email"));
				u.setPassword(resultset.getString("password"));
				d.setName(resultset.getString("namedep"));
				d.setId(resultset.getInt("idDepartement"));
				u.setDepartement(d);
				f.setId(resultset.getInt("idFunction"));
				f.setName(resultset.getString("namefunc"));
				u.setFunction(f);
				u.setNbrDaysOfLeave(resultset.getInt("nbrDaysOfLeave"));
				u.setNbrRTT(resultset.getInt("nbrRTT"));
				u.setAbsences(absence.findAbsencesByIdUser(u.getId()));
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		finally {
			
			resultset.close();
			prepareStatement.close();
			conn.close();
			
		}
		
		return u;
	}

	@Override
	public boolean isUserExist(String email) {
						
		Connection conn = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultset = null;
		boolean isAvailable = false;
		
		try {
			
			conn = ConnectionDB.getConnection();
			
			String query = "SELECT * FROM user WHERE email = ?";
			
			prepareStatement = conn.prepareStatement(query);
			
			prepareStatement.setString(1, email);
			
			resultset = prepareStatement.executeQuery();
			
			if(resultset.next()) {
				
				isAvailable = true;
				
			}else {
				
				isAvailable = false;
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		finally {
			
			try {
				if(conn != null) {
					resultset.close();
					prepareStatement.close();
					conn.close();
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
		}
		
		
		return isAvailable;
	}

	@Override
	public User findUserByEmailAndByPassword(String email, String password) throws SQLException {
		
		User u = new User();
		AbsenceDAO absence = new AbsenceDAO();
		Departement d = new Departement();
		Function f = new Function();
		
		Connection conn = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultset = null;
		
		try {
			
			conn = ConnectionDB.getConnection();
			
			String query = "SELECT u.id,u.firstname,u.name,u.email,u.password,u.idFunction,u.idDepartement,u.nbrDaysOfLeave,u.nbrRTT,f.name as namefunc,d.name as namedep FROM user u JOIN diginamicproject.function f ON u.idFunction = f.id JOIN departement d ON u.idDepartement=d.id WHERE email = ? AND password = ?";
			
			prepareStatement = conn.prepareStatement(query);
			
			prepareStatement.setString(1, email);
			prepareStatement.setString(2, password);
			
			resultset = prepareStatement.executeQuery();
			
								
			while (resultset.next()) {
				
				u.setId(resultset.getInt("id"));
				u.setFirstname(resultset.getString("firstname"));
				u.setName(resultset.getString("name"));
				u.setEmail(resultset.getString("email"));
				u.setPassword(resultset.getString("password"));
				d.setName(resultset.getString("namedep"));
				d.setId(resultset.getInt("idDepartement"));
				u.setDepartement(d);
				f.setId(resultset.getInt("idFunction"));
				f.setName(resultset.getString("namefunc"));
				u.setFunction(f);
				u.setNbrDaysOfLeave(resultset.getInt("nbrDaysOfLeave"));
				u.setNbrRTT(resultset.getInt("nbrRTT"));
				u.setAbsences(absence.findAbsencesByIdUser(u.getId()));
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		finally {
			
			resultset.close();
			prepareStatement.close();
			conn.close();
			
		}
		
		return u;
		
		
	}

}
