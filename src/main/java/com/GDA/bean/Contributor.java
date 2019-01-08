package main.java.com.GDA.bean;

	import java.util.ArrayList;
	import java.util.List;
	import java.util.Optional;

	public class Contributor {
		
		public enum Grade {
			EMPLOYE, MANAGER, ADMINISTRATEUR;
		}

		private static final int BASE_CONGES_PAYES = 28;
		private static final int BASE_RTT = 11;
		
		private String matricule;
		private String nom;
		private String prenom;
		private String email;
		private String password;
		private Optional<Contributor> manager = Optional.ofNullable(null);
		private List<Contributor> subalternes = new ArrayList<>();
		private Departement departement;
		private Grade grade = Grade.EMPLOYE;
		private int congesPayes = BASE_CONGES_PAYES;
		private int rtt = BASE_RTT;

		public Contributor() {
			super();
		}

		public String getMatricule() {
			return matricule;
		}

		public void setMatricule(String matricule) {
			this.matricule = matricule;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Departement getDepartement() {
			return departement;
		}

		public void setDepartement(Departement departement) {
			this.departement = departement;
		}

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
		
		public Grade getGrade(){
			return this.grade;
		}
		
		public void setGrade(Grade grade){
			this.grade = grade;
		}

		public int getCongesPayes() {
			return congesPayes;
		}

		public void setCongesPayes(int congesPayes) {
			this.congesPayes = congesPayes;
		}

		public int getRtt() {
			return rtt;
		}

		public void setRtt(int rtt) {
			this.rtt = rtt;
		}

	}
