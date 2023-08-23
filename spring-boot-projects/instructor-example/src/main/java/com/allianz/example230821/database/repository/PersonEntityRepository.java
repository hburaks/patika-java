package com.allianz.example230821.database.repository;

import com.allianz.example230821.database.entity.PersonEntity;
import com.allianz.example230821.util.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonEntityRepository extends BaseRepository<PersonEntity> {
    List<PersonEntity> findAllByNameStartingWith(String key);

    List<PersonEntity> findAllByNameContainsIgnoreCase(String key);

    List<PersonEntity> findAllByNameStartingWithOrSurnameStartingWith(String name, String surname);

}
