package main.java.com.GDA.model.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, PK extends Serializable> {

	T create(T object);

	T find(PK id);

	T update(T object);

	void delete(T object);

	List<T> findAll();
}
