package com.allianz.genericerpcrud.controller.generic;

import com.allianz.genericerpcrud.entity.generic.BaseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ControllerGeneric<T extends BaseEntity> {
	
	ResponseEntity<Object> save(@RequestBody T entity);
	ResponseEntity<T> findAll();


	ResponseEntity<String> delete(@PathVariable Long id);

}
