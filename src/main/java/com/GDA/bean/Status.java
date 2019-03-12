package com.GDA.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="status")
public class Status {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	@Column(length = 45, nullable = false)
	private String name;
	
	
	
	public Status() {
		super();
	}

	public Status(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Status(Integer id) {
	
		this.id = id;

	}

	@NotNull
	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@NotBlank
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Status [id=" + id + ", name=" + name + "]";
	}
	
	
}
