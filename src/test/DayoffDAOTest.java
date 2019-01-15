package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
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

public class DayoffDAOTest {
	private static 	DayoffDAO daoDayoff;
	private static	AbsenceDAO daoAbsence ;
	private static	UserDAO daoUser;
	private static	List<Absence> listAbsence;
	private static	List<User> listUser;
	private static	List<AbsenceType> listAbcenseType;
	private static	List<Status> listStatus;
	private static	List<Departement> listDepartement;
	private static	List<Function> listFunction;
	private static	List<TypeDayOff> listTypeDayOff ;
	private static	List<Dayoff> listDayOff;
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
	daoUser = new UserDAO();
	listAbsence = Fixture.getAbsenceForTest();
	listUser = Fixture.getUserForTest();
	listAbcenseType = Fixture.getAbsenceTypeForTest();
	listStatus = Fixture.getStatusForTest();
	listDepartement = Fixture.getDepartementForTest();
	listFunction = Fixture.getFunctionForTest();
	listTypeDayOff = Fixture.getTypeDayoffForTest();
	listDayOff = Fixture.getDayoffForTest();
	sizeArray = 0;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindAllDayOff() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindDayOffById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindDayOffByYear() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindDayOffByDepartement() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateDayoff() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateDayoff() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteDayOff() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsDateExist() {
		fail("Not yet implemented");
	}

}
