package com.allianz.instructorExample.mapper;

import com.allianz.instructorExample.database.entity.PersonEntity;
import com.allianz.instructorExample.model.PersonDTO;
import com.allianz.instructorExample.model.requestDTO.PersonRequestDTO;
import com.allianz.instructorExample.util.BaseDTO;
import com.allianz.instructorExample.util.IBaseMapper;
import com.allianz.instructorExample.util.dbutil.BaseEntity;

import java.util.List;

public class PersonMapper implements IBaseMapper<PersonDTO, PersonEntity, PersonRequestDTO> {


    @Override
    public PersonDTO entityToDTO(PersonEntity entity) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setTc(entity.getTc());
        personDTO.setName(entity.getName());
        personDTO.setSurname(entity.getSurname());
        personDTO.setId(entity.getId());
        personDTO.setUuid(entity.getUuid());
        personDTO.setBirthYear(entity.getBirthYear());
        personDTO.setCreationDate(entity.getCreationDate());
        personDTO.setUpdatedDate(entity.getUpdatedDate());

        return null;
    }

    @Override
    public PersonEntity dtoToEntity(PersonDTO dto) {
        return null;
    }

    @Override
    public List<PersonDTO> entityListToDTOList(List<PersonEntity> personEntities) {
        return null;
    }

    @Override
    public List<PersonEntity> dtoListTOEntityList(List<PersonDTO> personDTOS) {
        return null;
    }

    @Override
    public PersonEntity requestDTOToEntity(PersonRequestDTO dto) {
        return null;
    }
}
