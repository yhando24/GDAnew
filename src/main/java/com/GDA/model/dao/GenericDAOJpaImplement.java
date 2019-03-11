package main.java.com.GDA.model.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import main.java.com.GDA.database.DatabaseHandle;

public abstract class GenericDAOJpaImplement<T, PK extends Serializable> implements GenericDAO<T, PK> {

	protected Class<T> entityClass;

	protected EntityManager em = DatabaseHandle.getEntityManagerFactory();
	

	public GenericDAOJpaImplement() {
		ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperClass.getActualTypeArguments()[0];
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
		
		return object ;
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
