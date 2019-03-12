package com.GDA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("GDA");

		EntityManager em = emf.createEntityManager();

		EntityTransaction transac = em.getTransaction();

	}

}
