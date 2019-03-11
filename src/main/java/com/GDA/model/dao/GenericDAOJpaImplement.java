package main.java.com.GDA.model.dao.user;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import main.java.com.GDA.model.dao.GenericDAO;

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
	public T read(PK id) {
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

}
