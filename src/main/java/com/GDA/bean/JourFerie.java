package main.java.com.GDA.bean;

import java.time.LocalDate;
import java.util.Date;

public class JourFerie {

	private int id;
	private LocalDate dayOff;
	private String comment;
	private TypeJourFerie typeJourFerie;
	private Departement departement;

	
	
	
	public JourFerie() {
		super();
	}
	
	public JourFerie(int id, LocalDate dayOff, Date endDate, String comment, TypeJourFerie typeJourFerie, Status status, int idUser) {
		super();
		this.id = id;
		this.dayOff = dayOff;
		this.comment = comment;
		this.typeJourFerie = typeJourFerie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDayOff() {
		return dayOff;
	}

	public void setDayOff(LocalDate startDate) {
		this.dayOff = startDate;
	}


	public String getComment() {
		return comment;
	}

	public void setComment(String reason) {
		this.comment = reason;
	}

	public TypeJourFerie getTypeJourFerie() {
		return typeJourFerie;
	}

	public void setTypeJourFerie(TypeJourFerie typeJourFerie) {
		this.typeJourFerie = typeJourFerie;
	}




	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	@Override
	public String toString() {
		return "Absence [id=" + id + ", startDate=" + dayOff + ", reason=" + comment
				+ ", idAbsenceType=" + typeJourFerie + "]";
	}
	
			
}
