package main.java.com.GDA.bean;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;

public class AbsenceForReport {

	@Past
	LocalDate dateStart;
	
	@NotBlank
	String name;
	
	@NotBlank
	Integer duration;
	
	@NotNull
	Integer lastDayOfMonth;
	
	@NotBlank
	TypeDayOff typeDayOff;
	
	@NotBlank
	AbsenceType typeAbsence;
	
	public AbsenceForReport(LocalDate dateStart, String name, Integer duration, Integer lastDayOfMonth, TypeDayOff typeDayOff,
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
	
	@NotBlank
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@NotBlank
	public TypeDayOff getTypeDayOff() {
		return typeDayOff;
	}
	
	public void setTypeDayOff(TypeDayOff typeDayOff) {
		this.typeDayOff = typeDayOff;
	}
	
	@NotBlank
	public AbsenceType getTypeAbsence() {
		return typeAbsence;
	}
	
	public void setTypeAbsence(AbsenceType typeAbsence) {
		this.typeAbsence = typeAbsence;
	}
	
	@Past
	public LocalDate getDateStart() {
		return dateStart;
	}
	
	public void setDateStart(LocalDate dateStart) {
		this.dateStart = dateStart;
	}
	
	@NotBlank
	public Integer getDuration() {
		return duration;
	}
	
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	
	@NotNull
	public Integer getLastDayOfMonth() {
		return lastDayOfMonth;
	}
	
	public void setLastDayOfMonth(Integer lastDayOfMonth) {
		this.lastDayOfMonth = lastDayOfMonth;
	}
	
	@Override
	public String toString() {
		return "AbsenceForReport [dateStart=" + dateStart + ", duration=" + duration + ", lastDayOfMonth="
				+ lastDayOfMonth + "]";
	}
}
