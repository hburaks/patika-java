package com.allianz.example230821.database.repository;

import com.allianz.example230821.database.entity.UserEntity;
import com.allianz.example230821.util.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEntityRepository extends BaseRepository<UserEntity> {

    Optional<UserEntity> findByEmail(String email);
}
