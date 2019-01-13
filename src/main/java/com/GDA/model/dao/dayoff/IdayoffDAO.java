package main.java.com.GDA.model.dao.dayoff;

import java.sql.Date;
import java.sql.SQLException;

import main.java.com.GDA.bean.Dayoff;

public interface IdayoffDAO {
	Dayoff findDayOffById(int id);
	Dayoff findDayOffByDate(Date date);
	Dayoff findDayOffByDepartement(int idDepartement);
	void createDayoff(Dayoff dayOff);
	Dayoff updateDayoff(int idDayOff, Dayoff dayOffToUpdate);
	Dayoff deleteDayOff(Date date) throws SQLException;
	boolean isDateExist(Date date) throws SQLException;
}
