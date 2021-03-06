package com.GDA.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "_function")
public class Function {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, insertable = false)
	private Integer id;

	@NotBlank

	@Column(length = 45, nullable = false)
	private String name;

	public Function() {

	}

	public Function(String name) {
		super();
		this.name = name;
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
		return "Function [id=" + id + ", name=" + name + "]";
	}

}
