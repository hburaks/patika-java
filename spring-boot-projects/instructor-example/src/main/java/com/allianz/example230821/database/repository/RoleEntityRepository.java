package com.allianz.example230821.database.repository;

import com.allianz.example230821.database.entity.RoleEntity;
import com.allianz.example230821.util.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleEntityRepository extends BaseRepository<RoleEntity> {
    Optional<RoleEntity> findByName(String name);

}
