package com.allianz.genericerpcrud.controller.generic;

import com.allianz.genericerpcrud.entity.generic.BaseEntity;
import com.allianz.genericerpcrud.service.generic.ServiceGeneric;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings({ "unchecked", "rawtypes" })
@ResponseBody
public class ControllerGenericImpl<T extends BaseEntity> implements ControllerGeneric<T> {
	
	@Autowired
	private ServiceGeneric<T> genericService;

	@Override
	@PostMapping
	public ResponseEntity<Object> save(T entity) {
		try {
			return new ResponseEntity(genericService.save(entity),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity("Error!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Override
	@GetMapping
	public ResponseEntity<T> findAll() {
		try {
			return new ResponseEntity(genericService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Override
	@DeleteMapping("/{id}")	
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		try {
			genericService.delete(id);
			return new ResponseEntity("Success!", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity("Error!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
