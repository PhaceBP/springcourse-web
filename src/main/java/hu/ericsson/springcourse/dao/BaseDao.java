package hu.ericsson.springcourse.dao;

import java.io.Serializable;
import java.util.List;

import hu.ericsson.springcourse.model.BusinessObject;

public interface BaseDao<T extends BusinessObject, ID extends Serializable> {

	
	ID create(T object);
	
	ID update(T object);
	
	void delete(ID id);
	
	T get(ID id);
	
	List<T> getEntities();
	
}
