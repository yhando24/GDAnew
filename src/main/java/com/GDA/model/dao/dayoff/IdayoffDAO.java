package main.java.com.GDA.model.dao.dayoff;

import java.sql.Date;
import java.sql.SQLException;

import main.java.com.GDA.bean.JourFerie;

public interface IdayoffDAO {
	JourFerie findDayOffById(int id);
	JourFerie findDayOffByDate(Date date);
	JourFerie findDayOffByDepartement(int idDepartement);
	void createDayoff(JourFerie dayOff);
	JourFerie updateDayoff(int idDayOff, JourFerie dayOffToUpdate);
	JourFerie deleteDayOff(Date date) throws SQLException;
	boolean isDateExist(Date date) throws SQLException;
}
