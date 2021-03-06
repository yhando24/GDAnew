package com.GDA.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity

@Table(name = "user_")
public class User {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, insertable = false)
	private Integer id;

	@NotBlank
	@Column(name="lastname",length = 45, nullable = false)
	private String name;

	@NotBlank
	@Column(length = 45, nullable = false)
	private String firstname;

	@NotBlank
	@Column(length = 150, nullable = false)
	private String email;

	@NotBlank
	@Column(length = 45, nullable = false)
	private String password;

	@NotNull
	@Column
	private Integer nbrDaysOfLeave;

	@NotNull
	@Column
	private Integer nbrRTT;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "departement_id", updatable = false)
	private Departement departement;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "function_id", updatable = false)
	private Function function;

	@OneToMany(mappedBy = "user")
	private List<Absence> absences = new ArrayList<Absence>();

	public User() {

	}

	public User(Integer id, String name, String firstname, String email, String password, int nbrDaysOfLeave,
			int nbrRTT, Departement departement, Function function, List<Absence> absences) {
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

	@NotNull
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotBlank
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotBlank
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@NotBlank
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@NotBlank
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@NotNull
	public int getNbrDaysOfLeave() {
		return nbrDaysOfLeave;
	}

	public void setNbrDaysOfLeave(int nbrDaysOfLeave) {
		this.nbrDaysOfLeave = nbrDaysOfLeave;
	}

	@NotNull
	public int getNbrRTT() {
		return nbrRTT;
	}

	public void setNbrRTT(int nbrRTT) {
		this.nbrRTT = nbrRTT;
	}

	@NotNull
	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	@NotBlank
	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

	@NotBlank
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
