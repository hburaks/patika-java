package com.allianz.example.util;

import com.allianz.example.util.dbutil.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface IBaseService<Entity extends BaseEntity> {
    List<Entity> findAll() throws Exception;
    Entity save(Entity entity) throws Exception;
    void delete(Long id) throws Exception;

    Optional<Entity> findById(Long id) throws Exception;
}