package com.allianz.example.service;

import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.database.repository.PersonEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//bean
@Service
public class PersonService {


    @Value("${gizem:25}")
    int value;

    @Autowired
    PersonEntityRepository personEntityRepository;

    public PersonEntity createPerson(String name, String surname, String tc, int birthYear) {
        PersonEntity person = new PersonEntity();
        person.setTc(tc);
        person.setName(name);
        person.setSurname(surname);
        person.setBirthYear(birthYear);


        personEntityRepository.save(person);


        System.out.println(value);

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


    public PersonEntity getPersonByUUID(UUID uuid) {

        Optional<PersonEntity> personEntityOptional = personEntityRepository.findByUuid(uuid);

        if (personEntityOptional.isPresent()) {
            return personEntityOptional.get();
        } else {
            return null;
        }

    }


    @Transactional
    public PersonEntity updatePersonByUUID(UUID uuid, PersonEntity newPersonEntity) {

        PersonEntity personEntity = getPersonByUUID(uuid);

        if (personEntity != null) {

            personEntity.setName(newPersonEntity.getName());
            personEntity.setSurname(newPersonEntity.getSurname());
            personEntity.setBirthYear(newPersonEntity.getBirthYear());
            personEntity.setTc(newPersonEntity.getTc());

            personEntityRepository.save(personEntity);



            return personEntity;
        } else {
            return null;
        }


    }


    @Transactional
    public Boolean deletePersonByUUID(UUID uuid) {
        PersonEntity personEntity = getPersonByUUID(uuid);

        if (personEntity != null) {
            personEntityRepository.deleteById(personEntity.getId());
            return true;
        } else {
            return false;
        }
    }


}
