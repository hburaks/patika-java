package com.allianz.example.database.repository;

import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.util.dbutil.BaseRepository;

public interface TaxRepository extends BaseRepository<TaxEntity> {
    TaxEntity findByCode(String code);
}
