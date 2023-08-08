package com.allianz.example.service;

import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.database.repository.PersonEntityRepository;
import com.allianz.example.mapper.PersonMapper;
import com.allianz.example.model.requestDTO.PersonRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//bean
@Service
public class PersonService extends BaseService<PersonEntity> {


    @Autowired
    PersonEntityRepository personEntityRepository;

    @Autowired
    PersonMapper personMapper;

    public PersonRequestDTO createPerson(PersonRequestDTO personRequestDTO) {

        PersonEntity personEntity = personMapper.requestDTOToEntity(personRequestDTO);
        personEntityRepository.save(personEntity);
        return personRequestDTO;
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


    public void addAddressToPerson(Optional<PersonEntity> personEntity, AddressEntity addressEntity) {
        if(personEntity.isPresent()){
            personEntity.get().getAddressEntityList().add(addressEntity);
        }
    }
}
