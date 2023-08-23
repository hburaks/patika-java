package com.allianz.example230821.mapper;

import com.allianz.example230821.database.entity.PersonEntity;
import com.allianz.example230821.model.PersonDTO;
import com.allianz.example230821.model.requestDTO.PageDTO;
import com.allianz.example230821.model.requestDTO.PersonRequestDTO;
import com.allianz.example230821.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonMapper implements IBaseMapper<PersonDTO, PersonEntity, PersonRequestDTO> {


    @Override
    public PersonDTO entityToDTO(PersonEntity entity) {
        PersonDTO dto = new PersonDTO();
        dto.setTc(entity.getTc());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setBirthYear(entity.getBirthYear());
        dto.setBirthYear(entity.getBirthYear());
        dto.setUuid(entity.getUuid());
        dto.setId(entity.getId());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());

        return dto;
    }

    @Override
    public PersonEntity dtoToEntity(PersonDTO dto) {
        PersonEntity entity = new PersonEntity();
        entity.setTc(dto.getTc());
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setBirthYear(dto.getBirthYear());
        entity.setBirthYear(dto.getBirthYear());
        entity.setUuid(dto.getUuid());
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());

        return entity;

    }

    @Override
    public List<PersonDTO> entityListToDTOList(List<PersonEntity> personEntities) {
        List<PersonDTO> personDTOS = new ArrayList<>();
        for (PersonEntity personEntity : personEntities) {
            personDTOS.add(entityToDTO(personEntity));
        }
        return personDTOS;
    }

    @Override
    public List<PersonEntity> dtoListTOEntityList(List<PersonDTO> personDTOS) {
        List<PersonEntity> personEntities = new ArrayList<>();
        for (PersonDTO personDTO : personDTOS) {
            personEntities.add(dtoToEntity(personDTO));
        }
        return personEntities;
    }

    @Override
    public PersonEntity requestDTOToEntity(PersonRequestDTO dto) {
        PersonEntity entity = new PersonEntity();
        entity.setTc(dto.getTc());
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setBirthYear(dto.getBirthYear());
        entity.setBirthYear(dto.getBirthYear());
        entity.setUuid(dto.getUuid());
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());

        return entity;
    }

    @Override
    public List<PersonEntity> requestDtoListTOEntityList(List<PersonRequestDTO> personRequestDTOS) {
        return null;
    }

    @Override
    public PersonEntity requestDtoToExistEntity(PersonEntity entity, PersonRequestDTO personRequestDTO) {
        entity.setBirthYear(personRequestDTO.getBirthYear());
        entity.setTc(personRequestDTO.getTc());
        entity.setName(personRequestDTO.getName());
        entity.setSurname(personRequestDTO.getSurname());
        entity.setMail(personRequestDTO.getMail());
        return entity;
    }

    @Override
    public PageDTO<PersonDTO> pageEntityToPageDTO(Page<PersonEntity> entityPage) {
        PageDTO<PersonDTO> dtoPage = new PageDTO<>();
        dtoPage.setTotalPages(entityPage.getTotalPages());
        dtoPage.setTotalElements(entityPage.getTotalElements());
        dtoPage.setSort(entityPage.getSort());
        dtoPage.setSize(entityPage.getSize());
        dtoPage.setNumber(entityPage.getNumber());
        dtoPage.setContent(entityListToDTOList(entityPage.getContent()));
        dtoPage.setHasContent(entityPage.hasContent());

        return dtoPage;
    }
}
