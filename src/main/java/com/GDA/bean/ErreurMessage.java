package com.GDA.bean;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;

@Entity(name = "erreur_message")
public class ErreurMessage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, insertable = false)
	private Integer id;

	@Past
	private LocalDateTime date;

	@NotBlank
	@Column(name = "service_origine")
	private String serviceOrigine;

	@NotBlank
	private String message;

	@NotNull
	public Integer getId() {
		return id;
	}

	public ErreurMessage() {
		super();
		this.date = LocalDateTime.now();
	}

	@NotBlank
	public String getServiceOrigine() {
		return serviceOrigine;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotBlank
	public String getMessage() {
		return message;
	}

	public void setServiceOrigine(String serviceOrigine) {
		this.serviceOrigine = serviceOrigine;
	}

	@Past
	public LocalDateTime getDate() {
		return date;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

}
