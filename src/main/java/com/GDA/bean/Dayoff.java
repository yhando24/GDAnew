package main.java.com.GDA.bean;

import java.time.LocalDate;
import java.util.Date;

public class Dayoff {

	private int id;
	private LocalDate dayOff;
	private String comment;
	private TypeDayOff typeDayOff;
	private Departement departement;

	
	
	
	public Dayoff() {
		super();
	}
	
	public Dayoff(int id, LocalDate dayOff, String comment, TypeDayOff typeDayOff) {
		super();
		this.id = id;
		this.dayOff = dayOff;
		this.comment = comment;
		this.typeDayOff = typeDayOff;
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

	public TypeDayOff getTypeDayOff() {
		return typeDayOff;
	}

	public void setTypeDayOff(TypeDayOff typeDayOff) {
		this.typeDayOff = typeDayOff;
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
				+ ", Type=" + typeDayOff + "]";
	}
	
			
}
