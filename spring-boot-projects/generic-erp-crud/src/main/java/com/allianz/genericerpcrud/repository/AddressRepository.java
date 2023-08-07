package com.allianz.genericerpcrud.repository;

import com.allianz.genericerpcrud.entity.AddressEntity;
import com.allianz.genericerpcrud.repository.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends GenericRepository<AddressEntity> {
}
