package com.allianz.example.database.repository;

import com.allianz.example.database.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonEntityRepository extends JpaRepository<PersonEntity, Long> {

    List<PersonEntity> findAllByNameStartingWith(String key);

    List<PersonEntity> findAllByNameContainsIgnoreCase(String key);

    List<PersonEntity> findAllByNameStartingWithOrSurnameStartingWith(String name, String surname);
}
