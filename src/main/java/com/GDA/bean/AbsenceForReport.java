package main.java.com.GDA.bean;

import java.time.LocalDate;

public class AbsenceForReport {

	LocalDate dateStart;
	String name;
	int duration;
	int lastDayOfMonth;
	
	
	public AbsenceForReport() {
		super();
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AbsenceForReport(LocalDate dateStart, int duration, int lastDayOfMonth,String name) {
		super();
		this.dateStart = dateStart;
		this.duration = duration;
		this.lastDayOfMonth = lastDayOfMonth;
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
