package com.allianz.genericerpcrud.repository.generic;

import com.allianz.genericerpcrud.entity.generic.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface GenericRepository<T extends BaseEntity> extends JpaRepository<T, Long> {
}