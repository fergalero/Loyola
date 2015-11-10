package com.loyola.planifica.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T extends Serializable,ID extends Serializable> {
	
	 T findById(ID id);
	 void register(T t);
	 void update(T t);
	 List<T> findAll();
	 void delete(ID id);
	

}
