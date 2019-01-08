package main.java.com.GDA.bean;

import java.util.Date;

public class Absence {

	private int id;
	private Date startDate;
	private Date endDate;
	private String reason;
	private int idAbsenceType;
	private int idStatus;
	private int idUser;
	
	
	
	public Absence() {
		super();
	}
	
	public Absence(int id, Date startDate, Date endDate, String reason, int idAbsenceType, int idStatus, int idUser) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.reason = reason;
		this.idAbsenceType = idAbsenceType;
		this.idStatus = idStatus;
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

	public int getIdAbsenceType() {
		return idAbsenceType;
	}

	public void setIdAbsenceType(int idAbsenceType) {
		this.idAbsenceType = idAbsenceType;
	}

	public int getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
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
				+ ", idAbsenceType=" + idAbsenceType + ", idStatus=" + idStatus + ", idUser=" + idUser + "]";
	}
	
			
}
