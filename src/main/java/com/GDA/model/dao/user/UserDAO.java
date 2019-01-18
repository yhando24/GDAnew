package main.java.com.GDA.model.dao.user;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import main.java.com.GDA.bean.Absence;
import main.java.com.GDA.bean.AbsenceType;
import main.java.com.GDA.bean.Departement;
import main.java.com.GDA.bean.Function;
import main.java.com.GDA.bean.QuestionUser;
import main.java.com.GDA.bean.Status;
import main.java.com.GDA.bean.User;
import main.java.com.GDA.model.dao.absence.AbsenceDAO;
import main.java.com.GDA.utils.ConnectionDB;

public class UserDAO implements IUserDAO {

	@Override
	public User findUserByEmail(String email){
		
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
			
			try {
				resultset.close();
				prepareStatement.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		}
				
		return u;
	}

	@Override
	public User findUserById(int id){
		
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
			
			try {
				resultset.close();
				prepareStatement.close();
				conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		return u;
	}

	@Override
	public boolean isUserExist(String email,String password) {
						
		Connection conn = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultset = null;
		boolean isAvailable = false;
		
		try {
			
			conn = ConnectionDB.getConnection();
			
			String query = "SELECT * FROM user WHERE email = ? AND password = ?";
			
			prepareStatement = conn.prepareStatement(query);
			
			prepareStatement.setString(1, email);
			prepareStatement.setString(2, password);
			
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
	public User findUserByEmailAndByPassword(String email, String password) {
		
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
				//u.setPassword(resultset.getString("password"));
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
		
		return u;
		
		
	}

	@Override
	public ArrayList <User> findUserByIdDepartement(int idDepartement) {
		  ArrayList<User> users = new ArrayList<User>();

		   Connection connection = null;
		   PreparedStatement prepareStatement = null;

		       try {
		           connection = ConnectionDB.getConnection();
		           String query = "SELECT id, name FROM user WHERE idDepartement = ?";
		           prepareStatement = connection.prepareStatement(query);

		           prepareStatement.setInt(1,idDepartement );

		           ResultSet resultSet = prepareStatement.executeQuery();

		     
		           while (resultSet.next()){
		              
			            User user = new User();
			            user.setId(resultSet.getInt("id"));
			            user.setName(resultSet.getString("name"));
			            
		                users.add(user);	             
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
		       return users;
	}
	
	@Override
	public void ChangePasswordToUser(int id, String password) {
		
		String generatedPassword = null;
		try {
			// Create MessageDigest instance for MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			// Add password bytes to digest
			md.update(password.getBytes());
			// Get the hash's bytes
			byte[] bytes = md.digest();
			// This bytes[] has bytes in decimal format;
			// Convert it to hexadecimal format
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			// Get complete hashed password in hex format
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		System.out.println(generatedPassword);

		Connection connection = null;
		PreparedStatement prepareStatement = null;

		Integer update;

		try {
			connection = ConnectionDB.getConnection();

			String query = "UPDATE user set password = ? WHERE id = ?";

			prepareStatement = connection.prepareStatement(query);

			prepareStatement.setString(1, generatedPassword );
			prepareStatement.setInt(2, id);
	

			update = prepareStatement.executeUpdate();
			System.out.println("Résultat de la requête UPDATE => " + update.intValue());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				prepareStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
		
	
	@Override
	public QuestionUser findQuestionUserByMail(String email){
		
		QuestionUser u = new QuestionUser();	
		Connection conn = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultset = null;
		
		try {
			
			conn = ConnectionDB.getConnection();
			
			String query = "SELECT idsecretQuestion, question, response, idUser FROM secretQuestion as sQ join diginamicproject.user as u ON u.id = sQ.idUser WHERE u.email = ?"; 
			
			prepareStatement = conn.prepareStatement(query);
			
			prepareStatement.setString(1, email);
			
			resultset = prepareStatement.executeQuery();
			
		
			
			
			while (resultset.next()) {

				u.setQuestion(resultset.getString("question"));
				u.setResponse(resultset.getString("response"));
				u.setIdUser(Integer.parseInt(resultset.getString("idUser")));	
			}
			
		} catch (Exception e) {
			
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
				
		return u;
	}
	
	@Override
	public QuestionUser findQuestionUserByIdUser(int id){
		System.out.println("laaa :" + id);
		QuestionUser u = new QuestionUser();	
		Connection conn = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultset = null;
		
		try {
			
			conn = ConnectionDB.getConnection();
			
			String query = "SELECT idsecretQuestion, question, response, idUser FROM secretQuestion as sQ join diginamicproject.user as u ON u.id = sQ.idUser WHERE u.id = ?"; 
			
			prepareStatement = conn.prepareStatement(query);
			
			prepareStatement.setInt(1, id);
			
			resultset = prepareStatement.executeQuery();
			
		
			
			
			while (resultset.next()) {

				u.setQuestion(resultset.getString("question"));
				u.setResponse(resultset.getString("response"));
				u.setIdUser(Integer.parseInt(resultset.getString("idUser")));	
			}
			
		} catch (Exception e) {
			
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
				
		return u;
	}
}
