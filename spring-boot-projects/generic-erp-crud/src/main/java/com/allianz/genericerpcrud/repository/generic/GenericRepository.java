package com.allianz.genericerpcrud.repository.generic;

import com.allianz.genericerpcrud.entity.generic.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericRepository<T extends BaseEntity> extends JpaRepository<T, Long> {
}