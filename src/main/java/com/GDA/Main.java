package com.GDA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.GDA.bean.User;



public class Main {

	public static void main(String[] args) {


		EntityManagerFactory emf = Persistence.createEntityManagerFactory("GDA");   

		EntityManager em = emf.createEntityManager();   
	
		EntityTransaction transac = em.getTransaction();
		
		transac.begin();
		
		User u = new User();
		
		u.setId(4);
		
		u.setName("nom4");
		
		u.setEmail("prenom4");
		
		em.persist(u);
		
		transac.commit();
		
		 
		
		em.close();   
		
		emf.close(); 

	}

}
