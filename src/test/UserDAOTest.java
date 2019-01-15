package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.java.com.GDA.bean.Absence;
import main.java.com.GDA.bean.AbsenceType;
import main.java.com.GDA.bean.Dayoff;
import main.java.com.GDA.bean.Departement;
import main.java.com.GDA.bean.Function;
import main.java.com.GDA.bean.Status;
import main.java.com.GDA.bean.TypeDayOff;
import main.java.com.GDA.bean.User;
import main.java.com.GDA.model.dao.absence.AbsenceDAO;
import main.java.com.GDA.model.dao.dayoff.DayoffDAO;
import main.java.com.GDA.model.dao.user.UserDAO;

public class UserDAOTest {
	private static 	DayoffDAO daoDayoff;
	private static	AbsenceDAO daoAbsence ;
	private static	UserDAO daoUser;
	private static	List<Absence> listAbsence;
	private static	List<User> listUser;
	private static	List<AbsenceType> listAbcenseType;
	private static	List<Status> listStatus = Fixture.getStatusForTest();
	private static	List<Departement> listDepartement = Fixture.getDepartementForTest();
	private static	List<Function> listFunction = Fixture.getFunctionForTest();
	private static	List<TypeDayOff> listTypeDayOff = Fixture.getTypeDayoffForTest();
	private static	List<Dayoff> listDayOff = Fixture.getDayoffForTest();
	private static int sizeArray;

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		}


	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	daoDayoff = new DayoffDAO();
	daoAbsence = new AbsenceDAO();
	UserDAO daoUser = new UserDAO();
	List<Absence> listAbsence = Fixture.getAbsenceForTest();
	List<User> listUser = Fixture.getUserForTest();
	List<AbsenceType> listAbcenseType = Fixture.getAbsenceTypeForTest();
	List<Status> listStatus = Fixture.getStatusForTest();
	List<Departement> listDepartement = Fixture.getDepartementForTest();
	List<Function> listFunction = Fixture.getFunctionForTest();
	List<TypeDayOff> listTypeDayOff = Fixture.getTypeDayoffForTest();
	List<Dayoff> listDayOff = Fixture.getDayoffForTest();
	sizeArray = 0;
	}

	@Test
	public void testFindUserByEmail() {
		listAbsence.size();
		fail("Not yet implemented");
	}

	@Test
	public void testFindUserById() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsUserExist() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindUserByEmailAndByPassword() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindUserByIdDepartement() {
		fail("Not yet implemented");
	}

}
