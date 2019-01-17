
package main.java.com.GDA.model.dao.absence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import main.java.com.GDA.bean.Absence;
import main.java.com.GDA.bean.AbsenceForReport;
import main.java.com.GDA.bean.AbsenceType;
import main.java.com.GDA.bean.Status;
import main.java.com.GDA.bean.User;
import main.java.com.GDA.utils.ConnectionDB;

public class AbsenceDAO implements IAbsenceDAO {

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

	// way for get all absences in BDD
	@Override
	public List<Absence> findAllAbsences() {
		// TODO Auto-generated method stub
		ArrayList<Absence> absences = new ArrayList<Absence>();

		Connection connection = null;
		PreparedStatement prepareStatement = null;

		try {
			connection = ConnectionDB.getConnection();
			String query = "SELECT absence.id, startDate, endDate, reason, idAbsenceType, idStatus, idUser, absencetype.name as nameType, status.name as nameStatus FROM absence JOIN absencetype ON absence.id = absencetype.id JOIN status ON status.id = idStatus";
			prepareStatement = connection.prepareStatement(query);

			ResultSet resultSet = prepareStatement.executeQuery();

			System.out.println(prepareStatement.toString());

			while (resultSet.next()) {
				Absence absence = new Absence();
				absence.setId(resultSet.getInt("id"));
				absence.setStartDate(LocalDate.parse(resultSet.getString("startDate")));
				absence.setEndDate(LocalDate.parse(resultSet.getString("endDate")));
				absence.setReason(resultSet.getString("reason"));
				absence.setAbsenceType(new AbsenceType(resultSet.getInt("idAbsenceType"), resultSet.getString("name")));
				absence.setStatus(new Status(resultSet.getInt("idStatus"), resultSet.getString("name")));
				absence.setIdUser(resultSet.getInt("idUser"));
				absences.add(absence);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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

	// way for update absences in BDD, specify id of old absence and the new absence
	@Override
	public void updateAbsence(int id, Absence absence) {

		System.out.println("dans update = " + Date.valueOf(absence.getEndDate()));

		Connection connection = null;
		PreparedStatement prepareStatement = null;

		Integer update;

		try {
			connection = ConnectionDB.getConnection();

			String query = "UPDATE absence set startDate = ?, endDate = ?, reason = ?, idAbsenceType = ?, idStatus = ?, idUser = ? WHERE id = ?";

			prepareStatement = connection.prepareStatement(query);

			prepareStatement.setDate(1, Date.valueOf(absence.getStartDate()));
			prepareStatement.setDate(2, Date.valueOf(absence.getEndDate()));
			prepareStatement.setString(3, absence.getReason());
			prepareStatement.setInt(4, absence.getAbsenceType().getId());
			prepareStatement.setInt(5, absence.getStatus().getId());
			prepareStatement.setInt(6, absence.getIdUser());
			prepareStatement.setInt(7, absence.getId());

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

	// way for get absence with his id
	@Override
	public Absence findAbsenceById(int id) {

		Absence absence = new Absence();

		Connection connection = null;
		PreparedStatement prepareStatement = null;

		try {
			connection = ConnectionDB.getConnection();
			String query = "SELECT absence.id, startDate, endDate, reason, idAbsenceType, idStatus, idUser, absencetype.name as nameType, status.name as nameStatus FROM absence JOIN absencetype ON absence.idAbsenceType = absencetype.id JOIN status ON status.id = idStatus where absence.id = ?";
			prepareStatement = connection.prepareStatement(query);

			prepareStatement.setInt(1, id);

			ResultSet resultSet = prepareStatement.executeQuery();

			System.out.println(prepareStatement.toString());

			while (resultSet.next()) {

				absence.setId(resultSet.getInt("id"));
				absence.setStartDate(LocalDate.parse(resultSet.getString("startDate")));
				absence.setEndDate(LocalDate.parse(resultSet.getString("endDate")));
				absence.setReason(resultSet.getString("reason"));
				absence.setAbsenceType(
						new AbsenceType(resultSet.getInt("idAbsenceType"), resultSet.getString("nameType")));
				absence.setStatus(new Status(resultSet.getInt("idStatus"), resultSet.getString("nameStatus")));
				absence.setIdUser(resultSet.getInt("idUser"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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

		ArrayList<Absence> absences = new ArrayList<Absence>();

		Connection connection = null;
		PreparedStatement prepareStatement = null;

		try {
			connection = ConnectionDB.getConnection();
			String query = "SELECT absence.id, startDate, endDate, reason, idAbsenceType, idStatus, idUser, absencetype.name as nameType, status.name as nameStatus FROM absence JOIN absencetype ON absence.idAbsenceType = absencetype.id JOIN status ON status.id = idStatus where idUser = ?";
			prepareStatement = connection.prepareStatement(query);

			prepareStatement.setInt(1, idUser);

			ResultSet resultSet = prepareStatement.executeQuery();

			System.out.println(prepareStatement.toString());

			while (resultSet.next()) {
				Absence absence = new Absence();
				absence.setId(resultSet.getInt("id"));
				absence.setStartDate(LocalDate.parse(resultSet.getString("startDate")));
				absence.setEndDate(LocalDate.parse(resultSet.getString("endDate")));
				absence.setReason(resultSet.getString("reason"));
				absence.setAbsenceType(
						new AbsenceType(resultSet.getInt("idAbsenceType"), resultSet.getString("nameType")));
				absence.setStatus(new Status(resultSet.getInt("idStatus"), resultSet.getString("nameStatus")));
				absence.setIdUser(resultSet.getInt("idUser"));

				absences.add(absence);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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

	public List<Absence> findAbsenceByUserMonthAndYear(int iduser, String month, String year) {

		ArrayList<Absence> absences = new ArrayList<Absence>();

		Connection connection = null;
		PreparedStatement prepareStatement = null;

		try {
			connection = ConnectionDB.getConnection();
			String query = "SELECT absence.id, startDate, endDate, idAbsenceType, idUser, absencetype.name as nameType FROM absence JOIN absencetype ON absence.idAbsenceType = absencetype.id WHERE idUser = ? AND MONTH(startDate) = ? AND YEAR(startDate) = ?";

			prepareStatement = connection.prepareStatement(query);

			prepareStatement.setInt(1, iduser);
			prepareStatement.setString(2, month);
			prepareStatement.setString(3, year);

			ResultSet resultSet = prepareStatement.executeQuery();

			System.out.println(prepareStatement.toString());

			while (resultSet.next()) {
				Absence absence = new Absence();
				absence.setId(resultSet.getInt("id"));
				absence.setStartDate(LocalDate.parse(resultSet.getString("startDate")));
				absence.setEndDate(LocalDate.parse(resultSet.getString("endDate")));
				absence.setAbsenceType(
						new AbsenceType(resultSet.getInt("idAbsenceType"), resultSet.getString("nameType")));
				absence.setIdUser(resultSet.getInt("idUser"));

				absences.add(absence);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		ArrayList<Absence> absences = new ArrayList<Absence>();

		Connection connection = null;
		PreparedStatement prepareStatement = null;

		try {
			connection = ConnectionDB.getConnection();
			String query = "SELECT absence.id, startDate, endDate, reason, idAbsenceType, idStatus, idUser, absencetype.name as nameType, status.name as nameStatus FROM absence JOIN absencetype ON absence.id = absencetype.id JOIN status ON status.id = idStatus where idAbsenceType = ?";
			prepareStatement = connection.prepareStatement(query);

			prepareStatement.setInt(1, absenceType);

			ResultSet resultSet = prepareStatement.executeQuery();

			System.out.println(prepareStatement.toString());

			while (resultSet.next()) {
				Absence absence = new Absence();
				absence.setId(resultSet.getInt("id"));
				absence.setStartDate(LocalDate.parse(resultSet.getString("startDate")));
				absence.setEndDate(LocalDate.parse(resultSet.getString("endDate")));
				absence.setReason(resultSet.getString("reason"));
				absence.setAbsenceType(
						new AbsenceType(resultSet.getInt("idAbsenceType"), resultSet.getString("nameType")));
				absence.setStatus(new Status(resultSet.getInt("idStatus"), resultSet.getString("nameStatus")));
				absence.setIdUser(resultSet.getInt("idUser"));

				absences.add(absence);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		ArrayList<Absence> absences = new ArrayList<Absence>();

		Connection connection = null;
		PreparedStatement prepareStatement = null;

		try {
			connection = ConnectionDB.getConnection();
			String query = "SELECT absence.id, startDate, endDate, reason, idAbsenceType, idStatus, idUser, absencetype.name as nameType, status.name as nameStatus FROM absence JOIN absencetype ON absence.id = absencetype.id JOIN status ON status.id = idStatus where idStatus = ?";
			prepareStatement = connection.prepareStatement(query);

			prepareStatement.setInt(1, absenceStatut);

			ResultSet resultSet = prepareStatement.executeQuery();

			System.out.println(prepareStatement.toString());

			while (resultSet.next()) {
				Absence absence = new Absence();

				absence.setStartDate(LocalDate.parse(resultSet.getString("startDate")));
				absence.setEndDate(LocalDate.parse(resultSet.getString("endDate")));
				absence.setReason(resultSet.getString("reason"));
				absence.setAbsenceType(
						new AbsenceType(resultSet.getInt("idAbsenceType"), resultSet.getString("nameType")));
				absence.setStatus(new Status(resultSet.getInt("idStatus"), resultSet.getString("nameStatus")));
				absence.setIdUser(resultSet.getInt("idUser"));

				absences.add(absence);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
			String Query = "INSERT INTO absence (startDate, endDate, reason, idAbsenceType, idStatus, idUser) VALUES (?,?,?,?,?,?)";

			prepareStatement = connection.prepareStatement(Query);
//				
			prepareStatement.setDate(1, Date.valueOf(absence.getStartDate()));
			prepareStatement.setDate(2, Date.valueOf(absence.getEndDate()));
			prepareStatement.setString(3, absence.getReason());
			prepareStatement.setInt(4, absence.getAbsenceType().getId()); //
			prepareStatement.setInt(5, absence.getStatus().getId()); //
			prepareStatement.setInt(6, absence.getIdUser()); //
			result = prepareStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					prepareStatement.close();
					connection.close();
				}

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
			String Query = "DELETE FROM absence where id =" + id;

			statement = connection.createStatement();
			result = statement.executeUpdate(Query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {

				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public List<User> findAllAbsencesByDepartement(int idDep) {

		List<User> users = new ArrayList<User>();

		Connection connection = null;
		PreparedStatement prepareStatement = null;

		try {
			connection = ConnectionDB.getConnection();
			String query = "SELECT absence.id as idAbsence, startDate , endDate , reason , idAbsenceType , idStatus , idUser , user.name ,user.firstname ,status.name as namestatus , absencetype.name as nameType FROM absence JOIN user ON user.id = absence.idUser JOIN status ON idStatus = status.id JOIN absencetype on absencetype.id = idAbsencetype WHERE user.idDepartement = ? AND absence.idStatus = 2 ORDER BY idUser";
			prepareStatement = connection.prepareStatement(query);

			prepareStatement.setInt(1, idDep);

			ResultSet resultSet = prepareStatement.executeQuery();

			System.out.println(prepareStatement.toString());
			System.out.println("avant le result next");

			while (resultSet.next()) {

				Absence absence = new Absence();
				User user = new User();
				absence.setId(resultSet.getInt("idAbsence"));
				absence.setStartDate(LocalDate.parse(resultSet.getString("startDate")));
				absence.setEndDate(LocalDate.parse(resultSet.getString("endDate")));
				absence.setReason(resultSet.getString("reason"));
				absence.setAbsenceType(
						new AbsenceType(resultSet.getInt("idAbsenceType"), resultSet.getString("nameType")));
				absence.setStatus(new Status(resultSet.getInt("idStatus"), resultSet.getString("nameStatus")));
				absence.setIdUser(resultSet.getInt("idUser"));
				user.setName(resultSet.getString("name"));
				user.setName(resultSet.getString("firstname"));
				System.out.println(absence);
				user.addAbsence(absence);

				users.add(user);
				System.out.println(user);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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

}
