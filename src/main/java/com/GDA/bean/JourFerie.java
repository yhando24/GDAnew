package main.java.com.GDA.bean;

import java.util.Date;

public class JourFerie {

	private int id;
	private Date dayOff;
	private String comment;
	private TypeJourFerie typeJourFerie;

	
	
	
	public JourFerie() {
		super();
	}
	
	public JourFerie(int id, Date dayOff, Date endDate, String comment, TypeJourFerie typeJourFerie, Status status, int idUser) {
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

	public Date getDayOff() {
		return dayOff;
	}

	public void setDayOff(Date startDate) {
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




	@Override
	public String toString() {
		return "Absence [id=" + id + ", startDate=" + dayOff + ", reason=" + comment
				+ ", idAbsenceType=" + typeJourFerie + "]";
	}
	
			
}
