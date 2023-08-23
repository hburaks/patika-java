package com.allianz.example230821.controller;

import com.allianz.example230821.database.entity.PersonEntity;
import com.allianz.example230821.database.repository.PersonEntityRepository;
import com.allianz.example230821.database.specification.PersonSpecification;
import com.allianz.example230821.mapper.PersonMapper;
import com.allianz.example230821.model.PersonDTO;
import com.allianz.example230821.model.requestDTO.PersonRequestDTO;
import com.allianz.example230821.service.PersonService;
import com.allianz.example230821.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person")
public class PersonController extends BaseController<
        PersonEntity,
        PersonDTO,
        PersonRequestDTO,
        PersonMapper,
        PersonEntityRepository,
        PersonSpecification,
        PersonService> {

    @Autowired
    PersonService personService;

    @Override
    protected PersonService getService() {
        return this.personService;
    }
}