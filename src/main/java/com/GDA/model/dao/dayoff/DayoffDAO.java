package com.GDA.model.dao.dayoff;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.GDA.bean.Absence;
import com.GDA.bean.Dayoff;
import com.GDA.model.dao.GenericDAOJpaImplement;

public class DayoffDAO extends GenericDAOJpaImplement<Absence, Integer> {

	public List<Dayoff> findAllDayOff() {

		ArrayList<Dayoff> daysOff = new ArrayList<Dayoff>();

		/*
		 * Connection connection = null; PreparedStatement prepareStatement = null;
		 * 
		 * try { connection = ConnectionDB.getConnection(); String query =
		 * "SELECT dayoff.id, date, idTypeDayOff,typedayoff.name as nametypeDayOff, idDepartement,departement.name as service, comment FROM dayoff JOIN typedayoff ON dayoff.idTypeDayOff = typedayoff.id JOIN departement ON dayoff.idDepartement = departement.id ORDER BY date"
		 * ; prepareStatement = connection.prepareStatement(query);
		 * 
		 * ResultSet resultSet = prepareStatement.executeQuery();
		 * 
		 * System.out.println(prepareStatement.toString());
		 * 
		 * while (resultSet.next()) { Dayoff dayoff = new Dayoff();
		 * dayoff.setId(resultSet.getInt("id"));
		 * dayoff.setDayOff(LocalDate.parse(resultSet.getString("date")));
		 * dayoff.setTypeDayOff( new TypeDayOff(resultSet.getInt("idTypeDayOff"),
		 * resultSet.getString("nametypeDayOff"))); dayoff.setDepartement( new
		 * Departement(resultSet.getInt("idDepartement"),
		 * resultSet.getString("service")));
		 * dayoff.setComment(resultSet.getString("comment"));
		 * 
		 * daysOff.add(dayoff); } } catch (Exception e) { e.printStackTrace(); } finally
		 * { try { prepareStatement.close(); connection.close(); } catch (SQLException
		 * e) { // ne rien faire e.printStackTrace(); } }
		 */
		return daysOff;
	}

	public Dayoff findDayOffById(int id) {

		Dayoff j = new Dayoff();
		DayoffDAO dayOffDao = new DayoffDAO();

		/*
		 * Connection conn = null; PreparedStatement prepareStatement = null; ResultSet
		 * resultset = null;
		 * 
		 * try { conn = ConnectionDB.getConnection(); String query =
		 * "SELECT dayoff.id, date, idTypeDayOff,typedayoff.name as nametypeDayOff, idDepartement,departement.name as service, comment FROM dayoff JOIN typedayoff ON dayoff.idTypeDayOff = typedayoff.id JOIN departement ON dayoff.idDepartement = departement.id WHERE dayoff.id = ?"
		 * ; prepareStatement = conn.prepareStatement(query); prepareStatement.setInt(1,
		 * id);
		 * 
		 * resultset = prepareStatement.executeQuery();
		 * 
		 * while (resultset.next()) {
		 * 
		 * j.setId(resultset.getInt("id"));
		 * j.setDayOff(LocalDate.parse(resultset.getString("date"))); j.setTypeDayOff(
		 * new TypeDayOff(resultset.getInt("idTypeDayOff"),
		 * resultset.getString("nametypeDayOff"))); j.setDepartement(new
		 * Departement(resultset.getInt("idDepartement"),
		 * resultset.getString("service")));
		 * j.setComment(resultset.getString("comment")); } }
		 * 
		 * catch (Exception e) { e.printStackTrace(); } finally { try {
		 * prepareStatement.close(); conn.close(); } catch (SQLException e) {
		 * e.printStackTrace(); } }
		 */

		return j;
	}

	public List<Dayoff> findDayOffByYear(int year) {

		ArrayList<Dayoff> daysOff = new ArrayList<Dayoff>();

		/*
		 * Connection connection = null; PreparedStatement prepareStatement = null;
		 * ResultSet resultSet = null;
		 * 
		 * try { connection = ConnectionDB.getConnection(); String Query =
		 * "SELECT dayoff.id, date, idTypeDayOff,typedayoff.name as nametypeDayOff, idDepartement,departement.name as service, comment FROM dayoff JOIN typedayoff ON dayoff.idTypeDayOff = typedayoff.id JOIN departement ON dayoff.idDepartement = departement.id WHERE YEAR ( dayoff.date ) = ? ORDER BY date ASC"
		 * ; prepareStatement = connection.prepareStatement(Query);
		 * prepareStatement.setInt(1, year);
		 * 
		 * resultSet = prepareStatement.executeQuery();
		 * 
		 * System.out.println(prepareStatement.toString());
		 * 
		 * while (resultSet.next()) { Dayoff dayoff = new Dayoff();
		 * dayoff.setId(resultSet.getInt("id"));
		 * dayoff.setDayOff(LocalDate.parse(resultSet.getString("date")));
		 * dayoff.setTypeDayOff( new TypeDayOff(resultSet.getInt("idTypeDayOff"),
		 * resultSet.getString("nametypeDayOff"))); dayoff.setDepartement( new
		 * Departement(resultSet.getInt("idDepartement"),
		 * resultSet.getString("service")));
		 * dayoff.setComment(resultSet.getString("comment"));
		 * 
		 * daysOff.add(dayoff); } } catch (Exception e) { e.printStackTrace(); } finally
		 * { try { prepareStatement.close(); connection.close(); } catch (SQLException
		 * e) { // ne rien faire e.printStackTrace(); } }
		 */

		return daysOff;
	}

	public List<Dayoff> findDayOffByDepartement(int idDepartement) {

		ArrayList<Dayoff> daysOff = new ArrayList<Dayoff>();

		/*
		 * Connection connection = null; PreparedStatement prepareStatement = null;
		 * ResultSet resultSet = null;
		 * 
		 * try { connection = ConnectionDB.getConnection(); String Query =
		 * "SELECT dayoff.id, date, idTypeDayOff,typedayoff.name as nametypeDayOff, idDepartement,departement.name as service, comment FROM dayoff JOIN typedayoff ON dayoff.idTypeDayOff = typedayoff.id JOIN departement ON dayoff.idDepartement = departement.id WHERE dayoff.idDepartement = ?"
		 * ; prepareStatement = connection.prepareStatement(Query);
		 * prepareStatement.setInt(1, idDepartement);
		 * 
		 * resultSet = prepareStatement.executeQuery();
		 * 
		 * System.out.println(prepareStatement.toString());
		 * 
		 * while (resultSet.next()) { Dayoff dayoff = new Dayoff();
		 * dayoff.setId(resultSet.getInt("id"));
		 * dayoff.setDayOff(LocalDate.parse(resultSet.getString("date")));
		 * dayoff.setTypeDayOff( new TypeDayOff(resultSet.getInt("idTypeDayOff"),
		 * resultSet.getString("nametypeDayOff")));
		 * dayoff.setComment(resultSet.getString("comment"));
		 * 
		 * daysOff.add(dayoff); } } catch (Exception e) { e.printStackTrace(); } finally
		 * { try { prepareStatement.close(); connection.close(); } catch (SQLException
		 * e) { // ne rien faire e.printStackTrace(); } }
		 */

		return daysOff;
	}

	public List<Dayoff> findDayOffByDepartementMonthAndYeat(int idDepartement, int idTypeDayOff, String month,
			String year) {

		ArrayList<Dayoff> daysOff = new ArrayList<Dayoff>();

		/*
		 * Connection connection = null; PreparedStatement prepareStatement = null;
		 * ResultSet resultSet = null;
		 * 
		 * try { connection = ConnectionDB.getConnection(); String Query =
		 * "SELECT dayoff.id, date, idTypeDayOff, typedayoff.name as nametypeDayOff, idDepartement,departement.name as service FROM dayoff JOIN typedayoff ON dayoff.idTypeDayOff = typedayoff.id JOIN departement ON dayoff.idDepartement = departement.id WHERE MONTH(date) = ? AND YEAR(date) = ? AND idTypeDayOff = ? AND idDepartement = ?"
		 * ; prepareStatement = connection.prepareStatement(Query);
		 * prepareStatement.setString(1, month); prepareStatement.setString(2, year);
		 * prepareStatement.setInt(3, idTypeDayOff); prepareStatement.setInt(4,
		 * idDepartement);
		 * 
		 * resultSet = prepareStatement.executeQuery();
		 * 
		 * System.out.println(prepareStatement.toString());
		 * 
		 * while (resultSet.next()) { Dayoff dayoff = new Dayoff();
		 * dayoff.setId(resultSet.getInt("id"));
		 * dayoff.setDayOff(LocalDate.parse(resultSet.getString("date")));
		 * dayoff.setTypeDayOff( new TypeDayOff(resultSet.getInt("idTypeDayOff"),
		 * resultSet.getString("nametypeDayOff"))); dayoff.setDepartement(new
		 * Departement(resultSet.getInt("idDepartement"),
		 * resultSet.getString("service")));
		 * 
		 * daysOff.add(dayoff); } } catch (Exception e) { e.printStackTrace(); } finally
		 * { try { prepareStatement.close(); connection.close(); } catch (SQLException
		 * e) { // ne rien faire e.printStackTrace(); } }
		 */

		return daysOff;
	}

	public void createDayoff(Dayoff dayOff) {

		/*
		 * Connection connection = null; PreparedStatement prepareStatement = null; int
		 * result;
		 * 
		 * try { connection = ConnectionDB.getConnection(); String Query =
		 * "INSERT INTO dayoff (date, idTypeDayOff, idDepartement, comment) VALUES (?,?,?,?)"
		 * ;
		 * 
		 * prepareStatement = connection.prepareStatement(Query); //
		 * prepareStatement.setDate(1, Date.valueOf(dayOff.getDayOff()));
		 * prepareStatement.setInt(2, dayOff.getTypeDayOff().getId()); //
		 * 
		 * prepareStatement.setInt(3, dayOff.getDepartement().getId());
		 * prepareStatement.setString(4, dayOff.getComment()); //
		 * 
		 * result = prepareStatement.executeUpdate();
		 * 
		 * } catch (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } finally { try { if (connection != null) {
		 * prepareStatement.close(); connection.close(); }
		 * 
		 * } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } }
		 */
	}

	public void updateDayoff(int idDayOff, Dayoff dayOff) {

		/*
		 * Connection connection = null; PreparedStatement prepareStatement = null;
		 * 
		 * int update;
		 * 
		 * try {
		 * 
		 * connection = ConnectionDB.getConnection();
		 * 
		 * String Query =
		 * "UPDATE dayoff SET date = ?, idTypeDayOff = ?, idDepartement = ?, comment = ? WHERE dayoff.id = ?"
		 * ;
		 * 
		 * prepareStatement = connection.prepareStatement(Query);
		 * 
		 * prepareStatement.setDate(1, Date.valueOf(dayOff.getDayOff()));
		 * prepareStatement.setInt(2, dayOff.getTypeDayOff().getId());
		 * prepareStatement.setInt(3, dayOff.getDepartement().getId());
		 * prepareStatement.setString(4, dayOff.getComment());
		 * prepareStatement.setInt(5, idDayOff);
		 * 
		 * update = prepareStatement.executeUpdate();
		 * 
		 * if (update == 0) { System.out.println("la modification n'a pas aboutie"); } }
		 * catch (Exception e) { e.printStackTrace(); } finally { try { if (connection
		 * != null) { prepareStatement.close(); connection.close(); } } catch
		 * (SQLException e) { e.printStackTrace(); } }
		 */
	}

	public void deleteDayOff(int id) {

		/*
		 * Connection connection = null; Statement statement = null;
		 * 
		 * int delete;
		 * 
		 * try { connection = ConnectionDB.getConnection(); String Query =
		 * "DELETE FROM dayoff WHERE id =" + id;
		 * 
		 * statement = connection.createStatement(); delete =
		 * statement.executeUpdate(Query);
		 * 
		 * } catch (Exception e) { e.printStackTrace();
		 * 
		 * } finally { try { statement.close(); connection.close(); } catch
		 * (SQLException e) { e.printStackTrace(); } }
		 */
	}

	public boolean isDateExist(Date date) {
		// TODO Auto-generated method stub
		return false;
	}

}
