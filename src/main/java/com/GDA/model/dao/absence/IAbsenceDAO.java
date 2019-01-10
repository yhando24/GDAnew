package main.java.com.GDA.model.dao.absence;

import java.util.ArrayList;
import java.util.List;

import main.java.com.GDA.bean.Absence;
import main.java.com.GDA.bean.AbsenceType;



public interface IAbsenceDAO {

	
	
//	How to find all absences
	List <Absence> findAllAbsences();
	
//	How to update a absence
	void updateAbsence(int id, Absence absence);
	
//	How to find absences with the id	
	Absence findAbsenceById(int id);
	
//	How to find absences with the user id
	List <Absence> findAbsencesByIdUser(int id);
	
//	How to find absences with the type id
	List <Absence> findAbsencesByIdAbsenceType(int absenceType);

//	How to find absences with the status id
	List <Absence> findAbsencesByIdAbsenceStatut(int absenceType);

//	How to add a absence
	void addAbsence(Absence absence);

//	How to delete a absence
	void deleteAbsence(int id);
	

	
}
