package com.GDA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.GDA.bean.Departement;
import com.GDA.bean.Function;
import com.GDA.bean.User;



public class Main {

	public static void main(String[] args) {


		EntityManagerFactory emf = Persistence.createEntityManagerFactory("GDA");   

		EntityManager em = emf.createEntityManager();   
	
		EntityTransaction transac = em.getTransaction();
		
		transac.begin();
		
		Departement d = new Departement("testdepartement");
		em.persist(d) ;
		
		Function f = new Function("poste"); 
		em.persist(f) ;
		
		User u = new User();
		
		//u.setId(4);
		
		u.setName("nom4");
		
		u.setEmail("truc@mail.fr");
		
		u.setDepartement(d);
		
		u.setFunction(f);
		
		u.setFirstname("prenom4");
		
		u.setPassword("truc");
		
		em.persist(u);
		
		transac.commit();
		
		 
		
		em.close();   
		
		emf.close(); 

	}

}
