package main.java.com.GDA.model.dao.dayoff;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import main.java.com.GDA.bean.Dayoff;

public interface IdayoffDAO {
//	find all days-off
	List<Dayoff> findAllDayOff();

//	find all days-off by ID
	Dayoff findDayOffById(int id);

//	find all days-off by year
	List<Dayoff> findDayOffByYear(int year);

//	find all days-off by Departement
	List<Dayoff> findDayOffByDepartement(int idDepartement);

//	Create a dayOff
	void createDayoff(Dayoff dayOff);

//	Update a dayOff
	void updateDayoff(int idDayOff, Dayoff dayOff);

//	Delete a dayOff
	void deleteDayOff(int id);

	boolean isDateExist(Date date);

	List<Dayoff> findDayOffByDepartementMonthAndYeat(int idDepartement, int idTypeDayOff, String month, String year);
}
