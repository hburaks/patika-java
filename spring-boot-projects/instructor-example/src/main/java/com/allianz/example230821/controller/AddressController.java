package com.allianz.example230821.controller;

import com.allianz.example230821.database.entity.AddressEntity;
import com.allianz.example230821.database.repository.AddressEntityRepository;
import com.allianz.example230821.database.specification.AddressSpecification;
import com.allianz.example230821.mapper.AddressMapper;
import com.allianz.example230821.model.AddressDTO;
import com.allianz.example230821.model.requestDTO.AddressRequestDTO;
import com.allianz.example230821.service.AddressService;
import com.allianz.example230821.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("address")
public class AddressController extends BaseController<
        AddressEntity,
        AddressDTO,
        AddressRequestDTO,
        AddressMapper,
        AddressEntityRepository,
        AddressSpecification,
        AddressService> {

    @Autowired
    AddressService addressService;

    @Override
    protected AddressService getService() {
        return this.addressService;
    }
}