package com.allianz.example.service;

import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.database.repository.PersonEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {


    @Autowired
    PersonEntityRepository personEntityRepository;

    public PersonEntity createPerson(String name, String surname, String tc, int birthYear) {
        PersonEntity person = new PersonEntity();
        person.setTc(tc);
        person.setName(name);
        person.setSurname(surname);
        person.setBirthYear(birthYear);

        personEntityRepository.save(person);

        return person;
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
