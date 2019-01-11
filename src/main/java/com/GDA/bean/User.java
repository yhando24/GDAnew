package main.java.com.GDA.bean;

import java.util.ArrayList;
import java.util.List;

public class User {

	private int id;
	private String name;
	private String firstname;
	private String email;
	private String password;
	private int nbrDaysOfLeave;
	private int nbrRTT;
	private Departement departement;
	private Function function;
	private List<Absence> absences = new ArrayList <Absence>();
	
	
	public User() {
		
	}
	
	public User(int id, String name, String firstname, String email, String password, int nbrDaysOfLeave, int nbrRTT,
			Departement departement, Function function, List<Absence> absences) {
		super();
		this.id = id;
		this.name = name;
		this.firstname = firstname;
		this.email = email;
		this.password = password;
		this.nbrDaysOfLeave = nbrDaysOfLeave;
		this.nbrRTT = nbrRTT;
		this.departement = departement;
		this.function = function;
		this.absences = absences;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getNbrDaysOfLeave() {
		return nbrDaysOfLeave;
	}

	public void setNbrDaysOfLeave(int nbrDaysOfLeave) {
		this.nbrDaysOfLeave = nbrDaysOfLeave;
	}

	public int getNbrRTT() {
		return nbrRTT;
	}

	public void setNbrRTT(int nbrRTT) {
		this.nbrRTT = nbrRTT;
	}

		
	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

	public List<Absence> getAbsences() {
		return absences;
	}

	public void setAbsences(List<Absence> absences) {
		this.absences = absences;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", firstname=" + firstname + ", email=" + email + ", password="
				+ password + ", nbrDaysOfLeave=" + nbrDaysOfLeave + ", nbrRTT=" + nbrRTT + ", departement="
				+ departement + ", function=" + function + ", absences=" + absences + "]";
	}

	public void addAbsence(Absence absence) {
		absences.add(absence);
	}		
}
