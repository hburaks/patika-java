package com.allianz.example230821.service;

import com.allianz.example230821.database.entity.BillEntity;
import com.allianz.example230821.database.repository.BillEntityRepository;
import com.allianz.example230821.database.specification.BillSpecification;
import com.allianz.example230821.mapper.BillMapper;
import com.allianz.example230821.model.BillDTO;
import com.allianz.example230821.model.requestDTO.BillRequestDTO;
import com.allianz.example230821.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService extends BaseService<BillEntity, BillDTO, BillRequestDTO,
        BillMapper, BillEntityRepository, BillSpecification> {

    @Autowired
    BillEntityRepository billEntityRepository;

    @Autowired
    BillMapper billMapper;


    @Autowired
    BillSpecification billSpecification;

    @Override
    protected BillMapper getMapper() {
        return this.billMapper;
    }

    @Override
    protected BillEntityRepository getRepository() {
        return this.billEntityRepository;
    }

    @Override
    protected BillSpecification getSpecification() {
        return billSpecification;
    }

}
