package com.GDA.database;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DatabaseHandle {

	// Create an EntityManagerFactory when you start the application.
	private static EntityManager entityManager;

	public static synchronized EntityManager getEntityManagerFactory() {
		if (entityManager == null || !entityManager.isOpen()) {
			entityManager = Persistence.createEntityManagerFactory("GDA").createEntityManager();
		}

		return entityManager;
	}

}
