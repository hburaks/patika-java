package com.allianz.example230821.service;

import com.allianz.example230821.database.entity.CustomerEntity;
import com.allianz.example230821.database.repository.CustomerEntityRepository;
import com.allianz.example230821.database.specification.CustomerSpecification;
import com.allianz.example230821.mapper.CustomerMapper;
import com.allianz.example230821.model.CustomerDTO;
import com.allianz.example230821.model.requestDTO.CustomerRequestDTO;
import com.allianz.example230821.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends BaseService<CustomerEntity, CustomerDTO, CustomerRequestDTO,
        CustomerMapper, CustomerEntityRepository, CustomerSpecification> {

    @Autowired
    CustomerEntityRepository customerEntityRepository;

    @Autowired
    CustomerMapper customerMapper;

    @Override
    protected CustomerMapper getMapper() {
        return this.customerMapper;
    }

    @Override
    protected CustomerEntityRepository getRepository() {
        return this.customerEntityRepository;
    }

    @Override
    protected CustomerSpecification getSpecification() {
        return null;
    }
}
