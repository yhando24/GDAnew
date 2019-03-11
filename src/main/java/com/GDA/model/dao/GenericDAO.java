package main.java.com.GDA.model.dao;

import java.io.Serializable;

public interface GenericDAO<T, PK extends Serializable> {

	T create(T object);

	T read(PK id);

	T update(T object);

	void delete(T object);
}
