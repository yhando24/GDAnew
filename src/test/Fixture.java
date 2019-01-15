package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import main.java.com.GDA.bean.Absence;
import main.java.com.GDA.bean.AbsenceType;
import main.java.com.GDA.bean.Dayoff;
import main.java.com.GDA.bean.Departement;
import main.java.com.GDA.bean.Function;
import main.java.com.GDA.bean.Status;
import main.java.com.GDA.bean.TypeDayOff;
import main.java.com.GDA.bean.User;

public class Fixture {
	
	
	public static List<Absence> getAbsenceForTest(){
		List<Absence> absences = new ArrayList<Absence>();
		List<AbsenceType> absTypes = getAbsenceTypeForTest();
		List<Status> status = getStatusForTest();
		
		absences.add( new Absence(1, LocalDate.parse("2019-01-23"),LocalDate.parse("2019-01-25"), null , absTypes.get(4), status.get(3),1));
		absences.add(new Absence(2, LocalDate.parse("2019-01-23"),LocalDate.parse("2019-01-25"), null , absTypes.get(3), status.get(2),1));
		absences.add(new Absence(3, LocalDate.parse("2019-02-12"),LocalDate.parse("2019-02-20"), null , absTypes.get(2), status.get(3),1));
		absences.add(new Absence(4, LocalDate.parse("2019-03-23"),LocalDate.parse("2019-03-25"), null , absTypes.get(1), status.get(4),1));
		absences.add(new Absence(5, LocalDate.parse("2019-02-13"),LocalDate.parse("2019-02-18"), null , absTypes.get(2), status.get(1),1));
		absences.add(new Absence(6, LocalDate.parse("2019-01-12"),LocalDate.parse("2019-01-11"), null , absTypes.get(4), status.get(1),1));
		
		absences.add(new Absence(7, LocalDate.parse("2019-01-23"),LocalDate.parse("2019-01-25"), null , absTypes.get(4), status.get(3),2));
		absences.add(new Absence(8, LocalDate.parse("2019-01-23"),LocalDate.parse("2019-01-25"), null , absTypes.get(3), status.get(2),2));
		absences.add(new Absence(9, LocalDate.parse("2019-02-12"),LocalDate.parse("2019-02-20"), null , absTypes.get(2), status.get(3),2));
		absences.add(new Absence(10, LocalDate.parse("2019-03-23"),LocalDate.parse("2019-03-25"), null , absTypes.get(1), status.get(4),2));
		absences.add(new Absence(11, LocalDate.parse("2019-02-13"),LocalDate.parse("2019-02-18"), null , absTypes.get(2), status.get(1),2));
		absences.add(new Absence(12, LocalDate.parse("2019-01-12"),LocalDate.parse("2019-01-11"), null , absTypes.get(4), status.get(1),2));
		
		absences.add(new Absence(13, LocalDate.parse("2019-01-23"),LocalDate.parse("2019-01-25"), null , absTypes.get(4), status.get(3),3));
		absences.add(new Absence(14, LocalDate.parse("2019-01-23"),LocalDate.parse("2019-01-25"), null , absTypes.get(3), status.get(2),3));
		absences.add(new Absence(15, LocalDate.parse("2019-02-12"),LocalDate.parse("2019-02-20"), null , absTypes.get(2), status.get(3),3));
		absences.add(new Absence(16, LocalDate.parse("2019-03-23"),LocalDate.parse("2019-03-25"), null , absTypes.get(1), status.get(4),3));
		absences.add(new Absence(17, LocalDate.parse("2019-02-13"),LocalDate.parse("2019-02-18"), null , absTypes.get(2), status.get(1),3));
		absences.add(new Absence(18, LocalDate.parse("2019-01-12"),LocalDate.parse("2019-01-11"), null , absTypes.get(4), status.get(1),3));
		
		return absences;
	}
	public static List<User> getUserForTest(){
		List<User> users = new ArrayList<User>();
		
		List<Departement> departements = getDepartementForTest();
		List<Function> functions = getFunctionForTest();
		List<Absence> absences = getAbsenceForTest();
		User u1 = new User(1,"NameAdminInfo","firstnameAdminInfo","adminInfo@plop.fr","plop",11,2 , departements.get(0), functions.get(0),null);
		User u2 = new User(2,"NameManagerInfo","firstManagerInfo","managerInfo@plop.fr","plop",11,2 , departements.get(0), functions.get(1),null);
		User u3 = new User(3,"NameUserInfo","firstnameUserInfo","userInfo@plop.fr","plop",11,2 , departements.get(0), functions.get(2),null);
		User u4 = new User(1,"NameAdminRH","firstnameAdminRH","adminRH@plop.fr","plop",11,2 , departements.get(1), functions.get(0),null);
		User u5 = new User(2,"NameManagerRH","firstManagerRH","managerRH@plop.fr","plop",11,2 , departements.get(1), functions.get(1),null);
		User u6 = new User(3,"NameUserRH","firstnameUserRH","userRH@plop.fr","plop",11,2 , departements.get(1), functions.get(2),null);
		for (Absence a : absences) {
			if(a.getIdUser() == 1) {
				u1.addAbsence(a);
			}else if(a.getIdUser() == 2) {
				u2.addAbsence(a);
			}else if(a.getIdUser() == 3) {
				u3.addAbsence(a);
			}
		}
		
		users.add(u1);
		users.add(u2);
		users.add(u3);
		users.add(u4);
		users.add(u5);
		users.add(u6);
		
		return users;
	}
	
	public static List<AbsenceType> getAbsenceTypeForTest(){
		List<AbsenceType> abstype = new ArrayList<AbsenceType>();
		AbsenceType abT1 = new AbsenceType(1,"conge");
		AbsenceType abT2 = new AbsenceType(2,"RTT");
		AbsenceType abT3 = new AbsenceType(3,"sSoldes");
		AbsenceType abT4 = new AbsenceType(4,"MISSION'");

		abstype.add(abT1);
		abstype.add(abT2);
		abstype.add(abT3);
		abstype.add(abT4);
		return abstype;
	}
	
	public static List<Status> getStatusForTest(){
		List<Status> status = new ArrayList<Status>();
		Status s1 = new Status(1,"INITIALE");
		Status s2 = new Status(2,"EN_ATTENTE_VALIDATION");
		Status s3 = new Status(3,"VALIDEE");
		Status s4 = new Status(4,"REJETEE");
		
		status.add(s1);
		status.add(s2);
		status.add(s3);
		status.add(s4);
		
		return status;
	}
	public static List<Departement> getDepartementForTest(){
		List<Departement> departements = new ArrayList<Departement>();
		Departement d1 = new Departement(1, "informatique");
		Departement d2 = new Departement(2, "ressources humaines");
		departements.add(d1);
		departements.add(d2);
		
		return departements;
	}
	public static List<Function> getFunctionForTest(){
		List<Function> functions = new ArrayList<Function>();
		Function f1 = new Function(1, "admin");
		Function f2 = new Function(2, "manager");
		Function f3 = new Function(3, "user");
		functions.add(f1);
		functions.add(f2);
		functions.add(f3);
		
		return functions;
	}
	public static List<TypeDayOff> getTypeDayoffForTest(){
		List<TypeDayOff> typeDaysOff = new ArrayList<TypeDayOff>();
		TypeDayOff d1 = new TypeDayOff(1, "RTT");
		TypeDayOff d2 = new TypeDayOff(2, "JourFerie");
		typeDaysOff.add(d1);
		typeDaysOff.add(d2);
		
		return typeDaysOff;
	}
	public static List<Dayoff> getDayoffForTest(){
		List<TypeDayOff> typeDaysOff = getTypeDayoffForTest();
		List<Departement> departement = getDepartementForTest();
		List<Dayoff> daysoff = new ArrayList<Dayoff>();
		Dayoff d1 = new Dayoff(1,LocalDate.parse("2019-01-15"),"comment daoyoff1", typeDaysOff.get(1), departement.get(1) );
		Dayoff d2 = new Dayoff(2,LocalDate.parse("2019-01-22"), null, typeDaysOff.get(0), departement.get(1) );
		Dayoff d3 = new Dayoff(3,LocalDate.parse("2019-05-12"),"comment daoyoff3", typeDaysOff.get(1), departement.get(0) );
		daysoff.add(d1);
		daysoff.add(d2);
		daysoff.add(d3);
		
		return daysoff;
	}
}
