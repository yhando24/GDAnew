package com.GDA.bean;

	import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

	
	public class Contributor {
		
		public enum Grade {
			EMPLOYE, MANAGER, ADMINISTRATEUR;
		}

		private static final Integer BASE_CONGES_PAYES = 28;
		private static final Integer BASE_RTT = 11;
		
		
				
		@NotNull
		private String matricule;
		
		@NotBlank
		private String nom;
		
		@NotBlank
		private String prenom;
		
		@NotBlank
		private String email;
		
		@NotBlank
		private String password;
		
		private Optional<Contributor> manager = Optional.ofNullable(null);
		
		@OneToMany
		private List<Contributor> subalternes = new ArrayList<>();
		
		@OneToOne
		private Departement departement;
		private Grade grade = Grade.EMPLOYE;
		private Integer congesPayes = BASE_CONGES_PAYES;
		private Integer rtt = BASE_RTT;

		public Contributor() {
			super();
		}

		@NotNull
		public String getMatricule() {
			return matricule;
		}

		public void setMatricule(String matricule) {
			this.matricule = matricule;
		}

		@NotBlank
		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		@NotBlank
		public String getPrenom() {
			return prenom;
		}

		
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		@NotBlank
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		@NotBlank
		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@NotBlank
		public Departement getDepartement() {
			return departement;
		}

		public void setDepartement(Departement departement) {
			this.departement = departement;
		}

		@NotBlank
		public Optional<Contributor> getManager() {
			return this.manager;
		}

		public void setManager(Contributor manager) {
			this.manager = Optional.ofNullable(manager);
		}
		
		public List<Contributor> getSubalternes(){
			return new ArrayList<>(this.subalternes);
		}
		
		public void addSubalterne(Contributor sub){
			this.subalternes.add(sub);
		}
		
		@NotBlank
		public Grade getGrade(){
			return this.grade;
		}
		
		public void setGrade(Grade grade){
			this.grade = grade;
		}

		@NotNull
		public Integer getCongesPayes() {
			return congesPayes;
		}

		public void setCongesPayes(Integer congesPayes) {
			this.congesPayes = congesPayes;
		}

		@NotNull
		public Integer getRtt() {
			return rtt;
		}

		public void setRtt(Integer rtt) {
			this.rtt = rtt;
		}

	}
