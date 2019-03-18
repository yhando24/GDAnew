package com.GDA.model.dao.AbsenceForReport;

import java.util.List;

import com.GDA.bean.AbsenceForReport;

public interface IAbsenceForReportDAO {
	List<AbsenceForReport> findAllAbsencesByDepartementMonthAndYear();
}
