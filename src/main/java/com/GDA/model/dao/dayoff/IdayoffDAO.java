package main.java.com.GDA.model.dao.dayoff;

import java.sql.Date;
import java.sql.SQLException;

import main.java.com.GDA.bean.JourFerie;

public interface IdayoffDAO {
	JourFerie findDayOffById(int id) throws SQLException;
	JourFerie findDayOffByDate(Date date) throws SQLException;
	JourFerie findDayOffByDepartement(int idDepartement) throws SQLException;
	JourFerie createDayoff(JourFerie dayOff) throws SQLException;
	JourFerie updateDayoff(int idDayOff, JourFerie dayOffToUpdate) throws SQLException;
	JourFerie deleteDayOff(Date date) throws SQLException;
	boolean isDateExist(Date date) throws SQLException;
}
