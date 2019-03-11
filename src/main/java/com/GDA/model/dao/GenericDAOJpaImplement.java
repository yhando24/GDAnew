package main.java.com.GDA.model.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericDAOJpaImplement<T, PK extends Serializable> implements GenericDAO<T, PK> {

	protected Class<T> entityClass;

	@PersistenceContext
	protected EntityManager em;

	public GenericDAOJpaImplement() {
		ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperClass.getActualTypeArguments()[0];
	}

	@Override
	public T create(T object) {
		this.em.persist(object);
		return object;
	}

	@Override
	public T find(PK id) {
		return this.em.find(entityClass, id);
	}

	@Override
	public T update(T object) {
		return this.em.merge(object);
	}

	@Override
	public void delete(T object) {
		this.em.remove(this.em.merge(object));

	}

	@Override
	public List<T> findAll(T object) {
		return this.em.createQuery("FROM " + entityClass.getName(), entityClass).getResultList();
	}

}
