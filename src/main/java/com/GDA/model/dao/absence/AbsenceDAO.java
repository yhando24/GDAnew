
package com.GDA.model.dao.absence;

import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.TypedQuery;

import com.GDA.bean.Absence;
import com.GDA.bean.AbsenceType;
import com.GDA.bean.Departement;
import com.GDA.bean.Status;
import com.GDA.model.dao.GenericDAOJpaImplement;

public class AbsenceDAO extends GenericDAOJpaImplement<Absence, Integer> {

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

//	public List<Absence> findAllAbsences() {
//		return findAll();
//	}
//		// TODO Auto-generated method stub
//		ArrayList<Absence> absences = new ArrayList<Absence>();
//
//		Connection connection = null;
//		PreparedStatement prepareStatement = null;
//
//		try {
//			connection = ConnectionDB.getConnection();
//			String query = "SELECT absence.id, startDate, endDate, reason, idAbsenceType, idStatus, idUser, absencetype.name as nameType, status.name as nameStatus FROM absence JOIN absencetype ON absence.id = absencetype.id JOIN status ON status.id = idStatus";
//			prepareStatement = connection.prepareStatement(query);
//
//			ResultSet resultSet = prepareStatement.executeQuery();
//
//			System.out.println(prepareStatement.toString());
//
//			while (resultSet.next()) {
//				Absence absence = new Absence();
//				absence.setId(resultSet.getInt("id"));
//				absence.setStartDate(LocalDate.parse(resultSet.getString("startDate")));
//				absence.setEndDate(LocalDate.parse(resultSet.getString("endDate")));
//				absence.setReason(resultSet.getString("reason"));
//				absence.setAbsenceType(new AbsenceType(resultSet.getInt("idAbsenceType"), resultSet.getString("name")));
//				absence.setStatus(new Status(resultSet.getInt("idStatus"), resultSet.getString("name")));
//				absence.setIdUser(resultSet.getInt("idUser"));
//				absences.add(absence);
//	}}catch(Exception e)
//	{
//		e.printStackTrace();
//	}finally
//	{
//		try {
//			prepareStatement.close();
//			connection.close();
//		} catch (SQLException e) {
//			// ne rien faire
//			e.printStackTrace();
//		}
//	}return absences;
//	}

	// way for update absences in BDD, specify id of old absence and the new absence
//
//	public Absence updateAbsence(Absence absence) {
//		return update(absence);
//	}

//
//		System.out.println("dans update = " + Date.valueOf(absence.getEndDate()));
//
//		Connection connection = null;
//		PreparedStatement prepareStatement = null;
//
//		Integer update;
//
//		try {
//			connection = ConnectionDB.getConnection();
//
//			String query = "UPDATE absence set startDate = ?, endDate = ?, reason = ?, idAbsenceType = ?, idStatus = ?, idUser = ? WHERE id = ?";
//
//			prepareStatement = connection.prepareStatement(query);
//
//			prepareStatement.setDate(1, Date.valueOf(absence.getStartDate()));
//			prepareStatement.setDate(2, Date.valueOf(absence.getEndDate()));
//			prepareStatement.setString(3, absence.getReason());
//			prepareStatement.setInt(4, absence.getAbsenceType().getId());
//			prepareStatement.setInt(5, absence.getStatus().getId());
//			prepareStatement.setInt(6, absence.getIdUser());
//			prepareStatement.setInt(7, absence.getId());
//
//			update = prepareStatement.executeUpdate();
//			System.out.println("Résultat de la requête UPDATE => " + update.intValue());
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				prepareStatement.close();
//				connection.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}
//
//	}
//
//	// way for get absence with his id

//	public Absence findAbsenceById(Integer id) {
//		return find(id);
//	}

//
//		Absence absence = new Absence();
//
//		Connection connection = null;
//		PreparedStatement prepareStatement = null;
//
//		try {
//			connection = ConnectionDB.getConnection();
//			String query = "SELECT absence.id, startDate, endDate, reason, idAbsenceType, idStatus, idUser, absencetype.name as nameType, status.name as nameStatus FROM absence JOIN absencetype ON absence.idAbsenceType = absencetype.id JOIN status ON status.id = idStatus where absence.id = ?";
//			prepareStatement = connection.prepareStatement(query);
//
//			prepareStatement.setInt(1, id);
//
//			ResultSet resultSet = prepareStatement.executeQuery();
//
//			System.out.println(prepareStatement.toString());
//
//			while (resultSet.next()) {
//
//				absence.setId(resultSet.getInt("id"));
//				absence.setStartDate(LocalDate.parse(resultSet.getString("startDate")));
//				absence.setEndDate(LocalDate.parse(resultSet.getString("endDate")));
//				absence.setReason(resultSet.getString("reason"));
//				absence.setAbsenceType(
//						new AbsenceType(resultSet.getInt("idAbsenceType"), resultSet.getString("nameType")));
//				absence.setStatus(new Status(resultSet.getInt("idStatus"), resultSet.getString("nameStatus")));
//				absence.setIdUser(resultSet.getInt("idUser"));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				prepareStatement.close();
//				connection.close();
//			} catch (SQLException e) {
//				// ne rien faire
//				e.printStackTrace();
//			}
//		}
//		return absence;
//	}

	// way for get user absences by his id

	public List<Absence> findAbsencesByIdUser(Integer idUser) {
		TypedQuery<Absence> q = em.createQuery("SELECT u a From Absence as a JOIN a.user as u WHERE a.id=:idUser)",
				Absence.class);
		q.setParameter("idUser", idUser);
		return q.getResultList();
	}

//
//		ArrayList<Absence> absences = new ArrayList<Absence>();
//
//		Connection connection = null;
//		PreparedStatement prepareStatement = null;
//
//		try {
//			connection = ConnectionDB.getConnection();
//			String query = "SELECT absence.id, startDate, endDate, reason, idAbsenceType, idStatus, idUser, absencetype.name as nameType, status.name as nameStatus FROM absence JOIN absencetype ON absence.idAbsenceType = absencetype.id JOIN status ON status.id = idStatus where idUser = ?";
//			prepareStatement = connection.prepareStatement(query);
//
//			prepareStatement.setInt(1, idUser);
//
//			ResultSet resultSet = prepareStatement.executeQuery();
//
//			System.out.println(prepareStatement.toString());
//
//			while (resultSet.next()) {
//				Absence absence = new Absence();
//				absence.setId(resultSet.getInt("id"));
//				absence.setStartDate(LocalDate.parse(resultSet.getString("startDate")));
//				absence.setEndDate(LocalDate.parse(resultSet.getString("endDate")));
//				absence.setReason(resultSet.getString("reason"));
//				absence.setAbsenceType(
//						new AbsenceType(resultSet.getInt("idAbsenceType"), resultSet.getString("nameType")));
//				absence.setStatus(new Status(resultSet.getInt("idStatus"), resultSet.getString("nameStatus")));
//				absence.setIdUser(resultSet.getInt("idUser"));
//
//				absences.add(absence);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				prepareStatement.close();
//				connection.close();
//			} catch (SQLException e) {
//				// ne rien faire
//				e.printStackTrace();
//			}
//		}
//		return absences;
//	}

	public List<Absence> findAbsenceByUserMonthAndYear(Integer idUser, String month, String year) {
		TypedQuery<Absence> q = em.createQuery(
				"SELECT a From Absence as a JOIN a.user as u WHERE u.id =:iduser AND MONTH(a.startDate) =:month AND YEAR(a.startDate) =:year",
				Absence.class);
		q.setParameter("iduser", idUser);
		q.setParameter("month", month);
		q.setParameter("year", year);
		return q.getResultList();

	}
//
//		ArrayList<Absence> absences = new ArrayList<Absence>();
//
//		Connection connection = null;
//		PreparedStatement prepareStatement = null;
//
//		try {
//			connection = ConnectionDB.getConnection();
//			String query = "SELECT absence.id, startDate, endDate, idAbsenceType, idUser, absencetype.name as nameType FROM absence JOIN absencetype ON absence.idAbsenceType = absencetype.id WHERE idUser = ? AND MONTH(startDate) = ? AND YEAR(startDate) = ?";
//
//			prepareStatement = connection.prepareStatement(query);
//
//			prepareStatement.setInt(1, iduser);
//			prepareStatement.setString(2, month);
//			prepareStatement.setString(3, year);
//
//			ResultSet resultSet = prepareStatement.executeQuery();
//
//			System.out.println(prepareStatement.toString());
//
//			while (resultSet.next()) {
//				Absence absence = new Absence();
//				absence.setId(resultSet.getInt("id"));
//				absence.setStartDate(LocalDate.parse(resultSet.getString("startDate")));
//				absence.setEndDate(LocalDate.parse(resultSet.getString("endDate")));
//				absence.setAbsenceType(
//						new AbsenceType(resultSet.getInt("idAbsenceType"), resultSet.getString("nameType")));
//				absence.setIdUser(resultSet.getInt("idUser"));
//
//				absences.add(absence);
//
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				prepareStatement.close();
//				connection.close();
//			} catch (SQLException e) {
//				// ne rien faire
//				e.printStackTrace();
//			}
//		}
//		return absences;
//
//	}

	// way for get type of absence in all absence

	public List<Absence> findAbsencesByIdAbsenceType(AbsenceType absenceType) {
		TypedQuery<Absence> q = em.createQuery("SELECT a From Absence as a JOIN a.user as u WHERE absenceType=:type",
				Absence.class);
		q.setParameter("type", absenceType);
		return q.getResultList();

	}
//		ArrayList<Absence> absences = new ArrayList<Absence>();
//
//		Connection connection = null;
//		PreparedStatement prepareStatement = null;
//
//		try {
//			connection = ConnectionDB.getConnection();
//			String query = "SELECT absence.id, startDate, endDate, reason, idAbsenceType, idStatus, idUser, absencetype.name as nameType, status.name as nameStatus FROM absence JOIN absencetype ON absence.id = absencetype.id JOIN status ON status.id = idStatus where idAbsenceType = ?";
//			prepareStatement = connection.prepareStatement(query);
//
//			prepareStatement.setInt(1, absenceType);
//
//			ResultSet resultSet = prepareStatement.executeQuery();
//
//			System.out.println(prepareStatement.toString());
//
//			while (resultSet.next()) {
//				Absence absence = new Absence();
//				absence.setId(resultSet.getInt("id"));
//				absence.setStartDate(LocalDate.parse(resultSet.getString("startDate")));
//				absence.setEndDate(LocalDate.parse(resultSet.getString("endDate")));
//				absence.setReason(resultSet.getString("reason"));
//				absence.setAbsenceType(
//						new AbsenceType(resultSet.getInt("idAbsenceType"), resultSet.getString("nameType")));
//				absence.setStatus(new Status(resultSet.getInt("idStatus"), resultSet.getString("nameStatus")));
//				absence.setIdUser(resultSet.getInt("idUser"));
//
//				absences.add(absence);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				prepareStatement.close();
//				connection.close();
//			} catch (SQLException e) {
//				// ne rien faire
//				e.printStackTrace();
//			}
//		}
//		return absences;
//	}

	// way for get absences by the status of the absence

	public List<Absence> findAbsencesByIdAbsenceStatut(Status status) {
		TypedQuery<Absence> q = em.createQuery("SELECT a u From Absence as a JOIN a.user as u WHERE status=:status",
				Absence.class);
		q.setParameter("status", status);
		return q.getResultList();

	}
//		// TODO Auto-generated method stub
//		ArrayList<Absence> absences = new ArrayList<Absence>();
//
//		Connection connection = null;
//		PreparedStatement prepareStatement = null;
//
//		try {
//			connection = ConnectionDB.getConnection();
//			String query = "SELECT absence.id, startDate, endDate, reason, idAbsenceType, idStatus, idUser, absencetype.name as nameType, status.name as nameStatus FROM absence JOIN absencetype ON absence.id = absencetype.id JOIN status ON status.id = idStatus where idStatus = ?";
//			prepareStatement = connection.prepareStatement(query);
//
//			prepareStatement.setInt(1, absenceStatut);
//
//			ResultSet resultSet = prepareStatement.executeQuery();
//
//			System.out.println(prepareStatement.toString());
//
//			while (resultSet.next()) {
//				Absence absence = new Absence();
//
//				absence.setStartDate(LocalDate.parse(resultSet.getString("startDate")));
//				absence.setEndDate(LocalDate.parse(resultSet.getString("endDate")));
//				absence.setReason(resultSet.getString("reason"));
//				absence.setAbsenceType(
//						new AbsenceType(resultSet.getInt("idAbsenceType"), resultSet.getString("nameType")));
//				absence.setStatus(new Status(resultSet.getInt("idStatus"), resultSet.getString("nameStatus")));
//				absence.setIdUser(resultSet.getInt("idUser"));
//
//				absences.add(absence);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				prepareStatement.close();
//				connection.close();
//			} catch (SQLException e) {
//				// ne rien faire
//				e.printStackTrace();
//			}
//		}
//		return absences;
//	}

	// way for add an absence
//
//	public void addAbsence(Absence absence) {
//		create(absence);
//	}

//
//		Connection connection = null;
//		PreparedStatement prepareStatement = null;
//		int result;
//
//		try {
//			connection = ConnectionDB.getConnection();
//			String Query = "INSERT INTO absence (startDate, endDate, reason, idAbsenceType, idStatus, idUser) VALUES (?,?,?,?,?,?)";
//
//			prepareStatement = connection.prepareStatement(Query);
////				
//			prepareStatement.setDate(1, Date.valueOf(absence.getStartDate()));
//			prepareStatement.setDate(2, Date.valueOf(absence.getEndDate()));
//			prepareStatement.setString(3, absence.getReason());
//			prepareStatement.setInt(4, absence.getAbsenceType().getId()); //
//			prepareStatement.setInt(5, absence.getStatus().getId()); //
//			prepareStatement.setInt(6, absence.getIdUser()); //
//			result = prepareStatement.executeUpdate();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				if (connection != null) {
//					prepareStatement.close();
//					connection.close();
//				}
//
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}
//
//	}

	// way for delete an absence
//	@Override
//	public void deleteAbsence(int id) {
//
//		Connection connection = null;
//		Statement statement = null;
//		int result;
//
//		try {
//			connection = ConnectionDB.getConnection();
//			String Query = "DELETE FROM absence where id =" + id;
//
//			statement = connection.createStatement();
//			result = statement.executeUpdate(Query);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//
//				statement.close();
//				connection.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}
//	}

	public List<Absence> findAllAbsencesByDepartement(Departement idDep) {
		TypedQuery<Absence> q = em.createQuery(
				"SELECT u a From Absence as a JOIN a.user as u JOIN u.departement WHERE u.departement=:dpt",
				Absence.class);
		q.setParameter("dpt", idDep);
		return q.getResultList();

	}
//
//		List<User> users = new ArrayList<User>();
//
//		Connection connection = null;
//		PreparedStatement prepareStatement = null;
//
//		try {
//			connection = ConnectionDB.getConnection();
//			String query = "SELECT absence.id as idAbsence, startDate , endDate , reason , idAbsenceType , idStatus , idUser , user.name ,user.firstname ,status.name as namestatus , absencetype.name as nameType FROM absence JOIN user ON user.id = absence.idUser JOIN status ON idStatus = status.id JOIN absencetype on absencetype.id = idAbsencetype WHERE user.idDepartement = ? AND absence.idStatus = 2 ORDER BY idUser";
//			prepareStatement = connection.prepareStatement(query);
//
//			prepareStatement.setInt(1, idDep);
//
//			ResultSet resultSet = prepareStatement.executeQuery();
//
//			System.out.println(prepareStatement.toString());
//			System.out.println("avant le result next");
//
//			while (resultSet.next()) {
//
//				Absence absence = new Absence();
//				User user = new User();
//				absence.setId(resultSet.getInt("idAbsence"));
//				absence.setStartDate(LocalDate.parse(resultSet.getString("startDate")));
//				absence.setEndDate(LocalDate.parse(resultSet.getString("endDate")));
//				absence.setReason(resultSet.getString("reason"));
//				absence.setAbsenceType(
//						new AbsenceType(resultSet.getInt("idAbsenceType"), resultSet.getString("nameType")));
//				absence.setStatus(new Status(resultSet.getInt("idStatus"), resultSet.getString("nameStatus")));
//				absence.setIdUser(resultSet.getInt("idUser"));
//				user.setName(resultSet.getString("name"));
//				user.setName(resultSet.getString("firstname"));
//				System.out.println(absence);
//				user.addAbsence(absence);
//
//				users.add(user);
//				System.out.println(user);
//
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				prepareStatement.close();
//				connection.close();
//			} catch (SQLException e) {
//				// ne rien faire
//				e.printStackTrace();
//			}
//		}
//		return users;
//
//	}

}
