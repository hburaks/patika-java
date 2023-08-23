package com.allianz.example230821.service;

import com.allianz.example230821.database.entity.SellerEntity;
import com.allianz.example230821.database.repository.SellerEntityRepository;
import com.allianz.example230821.database.specification.SellerSpecification;
import com.allianz.example230821.mapper.SellerMapper;
import com.allianz.example230821.model.SellerDTO;
import com.allianz.example230821.model.requestDTO.SellerRequestDTO;
import com.allianz.example230821.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService extends
        BaseService<SellerEntity, SellerDTO, SellerRequestDTO, SellerMapper, SellerEntityRepository, SellerSpecification> {
    @Autowired
    SellerEntityRepository sellerEntityRepository;

    @Autowired
    SellerMapper sellerMapper;

    @Override
    protected SellerMapper getMapper() {
        return this.sellerMapper;
    }

    @Override
    protected SellerEntityRepository getRepository() {
        return this.sellerEntityRepository;
    }

    @Override
    protected SellerSpecification getSpecification() {
        return null;
    }
}
