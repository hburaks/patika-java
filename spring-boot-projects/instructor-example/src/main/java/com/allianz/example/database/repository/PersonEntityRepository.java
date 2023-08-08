package com.allianz.example.database.repository;

import com.allianz.example.database.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PersonEntityRepository extends JpaRepository<PersonEntity, Long> {

    List<PersonEntity> findAllByNameStartingWith(String key);

    List<PersonEntity> findAllByNameContainsIgnoreCase(String key);


    List<PersonEntity> findAllByNameStartingWithOrSurnameStartingWith(String name, String surname);


    //sql injection "select * from User where username="+username+" and password="+passsword +"or 1=1"

    @Query("select p from PersonEntity  p where p.name = ?1 and p.surname = ?2")
    List<PersonEntity> getPersonAllByName(String name, String surname);


    @Modifying
    @Query("delete from PersonEntity p where p.name=?1")
    void deletePersonByName(String name);


    Optional<PersonEntity> findByUuid(UUID uuid);

    @Modifying
    @Query("delete from PersonEntity p where p.uuid=?1")
    void deletePersonByUUID(UUID uuid);

    long deleteByUuid(UUID uuid);


}
