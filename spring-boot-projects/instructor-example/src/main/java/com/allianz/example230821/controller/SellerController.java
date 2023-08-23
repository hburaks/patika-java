package com.allianz.example230821.controller;

import com.allianz.example230821.database.entity.SellerEntity;
import com.allianz.example230821.database.repository.SellerEntityRepository;
import com.allianz.example230821.database.specification.SellerSpecification;
import com.allianz.example230821.mapper.SellerMapper;
import com.allianz.example230821.model.SellerDTO;
import com.allianz.example230821.model.requestDTO.SellerRequestDTO;
import com.allianz.example230821.service.SellerService;
import com.allianz.example230821.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("seller")
public class SellerController extends BaseController<
        SellerEntity,
        SellerDTO,
        SellerRequestDTO,
        SellerMapper,
        SellerEntityRepository,
        SellerSpecification,
        SellerService> {

    @Autowired
    SellerService sellerService;

    @Override
    protected SellerService getService() {
        return this.sellerService;
    }
}
