package com.GDA.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "absence_type")
public class AbsenceType {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, insertable = false)
	private Integer id;

	@Column(length = 250, nullable = false)
	private String name;

	public AbsenceType(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public AbsenceType() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AbsenceType [id=" + id + ", name=" + name + "]";
	}

}
