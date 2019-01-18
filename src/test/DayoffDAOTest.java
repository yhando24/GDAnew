package test;

import static org.junit.Assert.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
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
		listDayOff = daoDayoff.findAllDayOff();
		assertTrue("La liste est de même taille", listDayOff.size() == (Fixture.getDayoffForTest().size()));
		assertTrue("La liste est copié", listDayOff.equals(Fixture.getDayoffForTest()));
		fail("Les listes ne sont pas identiques");
	}

	@Test
	public void testFindDayOffById() {
		listDayOff = daoDayoff.findAllDayOff();
		daoDayoff.findDayOffById(1);
		assertTrue("L'id 1 est, condition",daoDayoff.findDayOffById(1).equals(Fixture.getDayoffForTest().get(1)));
		fail("testFindDayOffById L'id un n'est pas bon !");
	}

	@Test
	public void testFindDayOffByYear() {
		listDayOff = daoDayoff.findAllDayOff();
		daoDayoff.findDayOffByYear(2018);
		int date = Fixture.getDayoffForTest().get(1).getDayOff().getYear();
		assertTrue("L'année retourné est bien 2018", daoDayoff.findDayOffByYear(2018) == Fixture.getDayoffForTest().subList(0, 4));
		fail("testFindDayOffByYear la liste des années n'est pas la bonne !");
	}

	@Test
	public void testFindDayOffByDepartement() {
		
		fail("Not yet implemented");
	}

	@Test
	public void testCreateDayoff() {
		listDayOff = daoDayoff.findAllDayOff();
		sizeArray = listDayOff.size();
		Dayoff d2 = new Dayoff(2,LocalDate.parse("2019-01-22"), null, typeDaysOff.get(0), departement.get(1) );
		daoDayoff.createDayoff(d2);
		assertTrue("La ligne à bien été ajouté", sizeArray+1 == daoDayoff.findAllDayOff().size());
		fail("testCreateDayoff N'a pas ajouté le nouveau DayOff");
	}

	@Test
	public void testUpdateDayoff() {
		listDayOff = daoDayoff.findAllDayOff();
		Dayoff test = daoDayoff.findDayOffById(3);
		Dayoff d2 = new Dayoff(2,LocalDate.parse("2019-01-22"), null, typeDaysOff.get(0), departement.get(1) );
		daoDayoff.updateDayoff(3, d2);
		assertFalse("La modification à bien été faite.", daoDayoff.findDayOffById(3).equals(test));
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteDayOff() {
		listDayOff = daoDayoff.findAllDayOff();
		
		fail("Not yet implemented");
	}

	@Test
	public void testIsDateExist() {
		fail("Not yet implemented");
	}

}
