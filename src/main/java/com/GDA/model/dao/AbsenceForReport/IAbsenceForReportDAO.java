package main.java.com.GDA.model.dao.AbsenceForReport;

import java.util.List;

import main.java.com.GDA.bean.AbsenceForReport;

public interface IAbsenceForReportDAO {
	List <AbsenceForReport> findAllAbsencesByDepartementMonthAndYear();
}
