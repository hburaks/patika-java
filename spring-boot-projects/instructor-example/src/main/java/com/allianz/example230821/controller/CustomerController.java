package com.allianz.example230821.controller;

import com.allianz.example230821.database.entity.CustomerEntity;
import com.allianz.example230821.database.repository.CustomerEntityRepository;
import com.allianz.example230821.database.specification.CustomerSpecification;
import com.allianz.example230821.mapper.CustomerMapper;
import com.allianz.example230821.model.CustomerDTO;
import com.allianz.example230821.model.requestDTO.CustomerRequestDTO;
import com.allianz.example230821.service.CustomerService;
import com.allianz.example230821.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
public class CustomerController extends BaseController<
        CustomerEntity,
        CustomerDTO,
        CustomerRequestDTO,
        CustomerMapper,
        CustomerEntityRepository,
        CustomerSpecification,
        CustomerService> {

    @Autowired
    CustomerService customerService;

    @Override
    protected CustomerService getService() {
        return this.customerService;
    }
}