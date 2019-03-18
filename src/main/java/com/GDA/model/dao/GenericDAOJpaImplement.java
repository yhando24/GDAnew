package com.GDA.model.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import com.GDA.database.DatabaseHandle;

public class GenericDAOJpaImplement<T, PK extends Serializable> implements GenericDAO<T, PK> {

	protected Class<T> entityClass;

	// @PersistenceUnit(unitName="GDA")
	// protected EntityManagerFactory emf;
	protected EntityManager em = DatabaseHandle.getEntityManagerFactory();
	// protected EntityManager em;

	public GenericDAOJpaImplement() {
		ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperClass.getActualTypeArguments()[0];
		// em = emf.createEntityManager();
	}

	@Override
	public T create(T object) {
		em.getTransaction().begin();

		em.persist(object);

		em.getTransaction().commit();

		return object;
	}

	@Override
	public T find(PK id) {
		return this.em.find(entityClass, id);
	}

	@Override
	public T update(T object) {

		em.getTransaction().begin();

		em.merge(object);

		em.getTransaction().commit();

		return object;
	}

	@Override
	public void delete(T object) {

		em.getTransaction().begin();

		em.remove(em.merge(object));

		em.getTransaction().commit();
	}

	@Override
	public List<T> findAll() {
		return this.em.createQuery("FROM " + entityClass.getName(), entityClass).getResultList();
	}

}
