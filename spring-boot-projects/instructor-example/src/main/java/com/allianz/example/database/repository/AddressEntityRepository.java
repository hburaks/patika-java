package com.allianz.example.database.repository;

import com.allianz.example.database.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AddressEntityRepository extends JpaRepository<AddressEntity, Long> {
    Optional<AddressEntity> findByUuid(UUID uuid);
}
