package com.allianz.example230821.controller;

import com.allianz.example230821.database.entity.TaxEntity;
import com.allianz.example230821.database.repository.TaxEntityRepository;
import com.allianz.example230821.database.specification.TaxSpecification;
import com.allianz.example230821.mapper.TaxMapper;
import com.allianz.example230821.model.TaxDTO;
import com.allianz.example230821.model.requestDTO.TaxRequestDTO;
import com.allianz.example230821.service.TaxService;
import com.allianz.example230821.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tax")
public class TaxController extends BaseController<
        TaxEntity,
        TaxDTO,
        TaxRequestDTO,
        TaxMapper,
        TaxEntityRepository,
        TaxSpecification,
        TaxService> {

    @Autowired
    TaxService taxService;

    @Override
    protected TaxService getService() {
        return taxService;
    }


}
