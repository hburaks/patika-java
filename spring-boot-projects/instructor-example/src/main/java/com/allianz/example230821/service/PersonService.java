package com.allianz.example230821.service;

import com.allianz.example230821.database.entity.PersonEntity;
import com.allianz.example230821.database.repository.PersonEntityRepository;
import com.allianz.example230821.database.specification.PersonSpecification;
import com.allianz.example230821.mapper.PersonMapper;
import com.allianz.example230821.model.PersonDTO;
import com.allianz.example230821.model.requestDTO.PersonRequestDTO;
import com.allianz.example230821.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService extends
        BaseService<PersonEntity, PersonDTO, PersonRequestDTO, PersonMapper, PersonEntityRepository, PersonSpecification> {

    @Autowired
    PersonEntityRepository personEntityRepository;

    @Autowired
    PersonMapper personMapper;

    @Override
    protected PersonMapper getMapper() {
        return this.personMapper;
    }

    @Override
    protected PersonEntityRepository getRepository() {
        return this.personEntityRepository;
    }

    @Override
    protected PersonSpecification getSpecification() {
        return null;
    }

    public List<PersonEntity> getPersonNameStartWith(String key) {
        return personEntityRepository.findAllByNameStartingWith(key);
    }

    public List<PersonEntity> getPersonNameIContains(String key) {
        return personEntityRepository.findAllByNameContainsIgnoreCase(key);
    }


    public List<PersonEntity> getPersonNameStartWithAndSurnameStartWith(String name, String surname) {
        return personEntityRepository.findAllByNameStartingWithOrSurnameStartingWith(name, surname);
    }

}
