package main.java.com.GDA.bean;

import java.time.LocalDate;

public class AbsenceForReport {

	LocalDate dateStart;
	String name;
	int duration;
	int lastDayOfMonth;
	TypeDayOff typeDayOff;
	AbsenceType typeAbsence;
	
	public AbsenceForReport(LocalDate dateStart, String name, int duration, int lastDayOfMonth, TypeDayOff typeDayOff,
			AbsenceType typeAbsence) {
		super();
		this.dateStart = dateStart;
		this.name = name;
		this.duration = duration;
		this.lastDayOfMonth = lastDayOfMonth;
		this.typeDayOff = typeDayOff;
		this.typeAbsence = typeAbsence;
	}
	
	public AbsenceForReport() {
		super();
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public TypeDayOff getTypeDayOff() {
		return typeDayOff;
	}
	
	public void setTypeDayOff(TypeDayOff typeDayOff) {
		this.typeDayOff = typeDayOff;
	}
	
	public AbsenceType getTypeAbsence() {
		return typeAbsence;
	}
	
	public void setTypeAbsence(AbsenceType typeAbsence) {
		this.typeAbsence = typeAbsence;
	}
	
	public LocalDate getDateStart() {
		return dateStart;
	}
	
	public void setDateStart(LocalDate dateStart) {
		this.dateStart = dateStart;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public int getLastDayOfMonth() {
		return lastDayOfMonth;
	}
	
	public void setLastDayOfMonth(int lastDayOfMonth) {
		this.lastDayOfMonth = lastDayOfMonth;
	}
	
	@Override
	public String toString() {
		return "AbsenceForReport [dateStart=" + dateStart + ", duration=" + duration + ", lastDayOfMonth="
				+ lastDayOfMonth + "]";
	}
}
