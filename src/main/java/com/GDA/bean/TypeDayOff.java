package com.GDA.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.mapping.Set;

@Entity
@Table(name="type_day_off")
public class TypeDayOff {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	@Column(length = 45, nullable = false)
	private String name;
	
	public TypeDayOff() {
		
	}
	
	public TypeDayOff(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	@NotNull
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
		return "AbsenceType [id=" + id + ", name=" + name + "]";
	}
		
}
