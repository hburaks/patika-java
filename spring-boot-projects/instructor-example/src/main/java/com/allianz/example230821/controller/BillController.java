package com.allianz.example230821.controller;

import com.allianz.example230821.database.entity.BillEntity;
import com.allianz.example230821.database.repository.BillEntityRepository;
import com.allianz.example230821.database.specification.BillSpecification;
import com.allianz.example230821.mapper.BillMapper;
import com.allianz.example230821.model.BillDTO;
import com.allianz.example230821.model.requestDTO.BillRequestDTO;
import com.allianz.example230821.service.BillService;
import com.allianz.example230821.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bill")
public class BillController extends BaseController<
        BillEntity,
        BillDTO,
        BillRequestDTO,
        BillMapper,
        BillEntityRepository,
        BillSpecification,
        BillService> {

    @Autowired
    BillService billService;

    @Override
    protected BillService getService() {
        return this.billService;
    }
}