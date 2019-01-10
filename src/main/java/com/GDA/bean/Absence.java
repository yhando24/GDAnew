package main.java.com.GDA.bean;

import java.util.Date;

public class Absence {

	private int id;
	private Date startDate;
	private Date endDate;
	private String reason;
	private AbsenceType absenceType;
	private Status status;
	private int idUser;
	
	
	
	public Absence() {
		super();
	}
	
	public Absence(int id, Date startDate, Date endDate, String reason, AbsenceType absenceType, Status status, int idUser) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.reason = reason;
		this.absenceType = absenceType;
		this.status = status;
		this.idUser = idUser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public AbsenceType getAbsenceType() {
		return absenceType;
	}

	public void setAbsenceType(AbsenceType absenceType) {
		this.absenceType = absenceType;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}


	
	
	@Override
	public String toString() {
		return "Absence [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", reason=" + reason
				+ ", idAbsenceType=" + absenceType + ", idStatus=" + status + ", idUser=" + idUser + "]";
	}
	
			
}
