package main.java.com.GDA.bean;

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
@Table(name = "dayoff")
public class Dayoff {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Past
	@Column(name = "day_off", nullable = false)
	private LocalDate dayOff;

	@NotBlank
	@Column(length = 255, nullable = false)
	private String comment;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_day_off_id")
	private TypeDayOff typeDayOff;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "departement_id")
	private Departement departement;

	public Dayoff() {
		super();
	}

	public Dayoff(Integer id, LocalDate dayOff, String comment, TypeDayOff typeDayOff, Departement departement) {
		super();
		this.id = id;
		this.dayOff = dayOff;
		this.comment = comment;
		this.typeDayOff = typeDayOff;
		this.departement = departement;
	}

	@NotNull
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Past
	public LocalDate getDayOff() {
		return dayOff;
	}

	public void setDayOff(LocalDate dayOff) {
		this.dayOff = dayOff;
	}

	@NotBlank
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@NotBlank
	public TypeDayOff getTypeDayOff() {
		return typeDayOff;
	}

	public void setTypeDayOff(TypeDayOff typeDayOff) {
		this.typeDayOff = typeDayOff;
	}

	@NotNull
	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

}
