package com.GDA;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Test;

import com.GDA.bean.Absence;
import com.GDA.bean.Departement;
import com.GDA.bean.Function;
import com.GDA.bean.User;
import com.GDA.model.dao.absence.AbsenceDAO;





public class Main {

	public static void main(String[] args) {


		EntityManagerFactory emf = Persistence.createEntityManagerFactory("GDA");   

		EntityManager em = emf.createEntityManager();   

		Absence absence1 = new Absence();
		absence1.setStartDate(LocalDate.of(2019, 5, 6));
		absence1.setEndDate(LocalDate.of(2019, 5, 16));
		absence1.setReason("Mal au ventre");

		em.persist(absence1);
		
		//AbsenceDAO absencedao = new AbsenceDAO();
		
		
		 //absence1.findAllAbsencesByDepartement()
		AbsenceDAO absenceDAO = new AbsenceDAO();
		List<Absence> absences = absenceDAO.findAllAbsencesByDepartementMonthAndYear(6, 5, 2019);
		System.out.println(absences.size());
		em.close();   
		
		emf.close(); 

	}
	

}
