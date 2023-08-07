package com.allianz.genericerpcrud.service.generic;

import com.allianz.genericerpcrud.entity.generic.BaseEntity;

import java.util.List;

public interface ServiceGeneric<T extends BaseEntity>  {
	
	List<T> findAll() throws Exception;
	T save(T entity) throws Exception;
	void delete(Long id) throws Exception;
	
}
