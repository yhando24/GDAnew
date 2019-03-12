package com.GDA.bean;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "absence")
public class Absence {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Past
	@Column
	private LocalDate startDate;

	@Past
	@Column
	private LocalDate endDate;

	@NotBlank
	@Column(length = 250, nullable = false)
	private String reason;

	@NotBlank
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "absence_type_id")
	private AbsenceType absenceType;

	@NotBlank
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status_id")
	private Status status;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	public Absence() {
		super();
	}

	public Absence(Integer id, LocalDate startDate, LocalDate endDate, String reason, AbsenceType absenceType,
			Status status, User user) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.reason = reason;
		this.absenceType = absenceType;
		this.status = status;
		this.user = user;
	}

	@NotNull
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Past
	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	@Past
	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	@NotBlank
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@NotBlank
	public AbsenceType getAbsenceType() {
		return absenceType;
	}

	public void setAbsenceType(AbsenceType absenceType) {
		this.absenceType = absenceType;
	}

	@NotBlank
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public User getUser() {
		return user;

	}

	public void setIdUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Absence [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", reason=" + reason
				+ ", idAbsenceType=" + absenceType + ", idStatus=" + status + ", user=" + user + "]";
	}

}
