package com.allianz.example230821.service;

import com.allianz.example230821.database.entity.TaxEntity;
import com.allianz.example230821.database.repository.TaxEntityRepository;
import com.allianz.example230821.database.specification.TaxSpecification;
import com.allianz.example230821.mapper.TaxMapper;
import com.allianz.example230821.model.TaxDTO;
import com.allianz.example230821.model.requestDTO.TaxRequestDTO;
import com.allianz.example230821.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TaxService extends
        BaseService<TaxEntity, TaxDTO, TaxRequestDTO, TaxMapper, TaxEntityRepository, TaxSpecification> {
    @Autowired
    TaxEntityRepository taxEntityRepository;

    @Autowired
    TaxMapper taxMapper;

    @Autowired
    TaxSpecification specification;

    @Override
    protected TaxMapper getMapper() {
        return this.taxMapper;
    }

    @Override
    protected TaxEntityRepository getRepository() {
        return this.taxEntityRepository;
    }

    @Override
    protected TaxSpecification getSpecification() {
        return specification;
    }

    @Override
    public TaxDTO update(UUID uuid, TaxRequestDTO taxRequestDTO) {
        return super.update(uuid, taxRequestDTO);
    }
}
